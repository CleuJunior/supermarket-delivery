package br.com.smd.products.supermarket_delivery_cart.config;

import br.com.smd.products.supermarket_delivery_cart.exception.BadRequestException;
import br.com.smd.products.supermarket_delivery_cart.exception.ConflictException;
import br.com.smd.products.supermarket_delivery_cart.exception.InternalServerErrorException;
import br.com.smd.products.supermarket_delivery_cart.exception.NotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.io.InputStream;

@Slf4j
@RequiredArgsConstructor
public class ApiErrorDecoder implements ErrorDecoder {

    private final ObjectMapper mapper;
    private final String apiName;

    @Override
    public Exception decode(String methodKey, Response response) {
        int status = response.status();

        try {
            InputStream stream = response.body().asInputStream();
            ErrorBody body = mapper.readValue(stream, ErrorBody.class);
            log.error("{} error response: {}", apiName, body);
            if (status == 500) {
                return new InternalServerErrorException("internal_server_exception", body.getMessage());
            }
            if (status == 404) {
                return new NotFoundException("api_exception", body.getMessage());
            }
            if (status == 400) {
                return new BadRequestException("api_exception", body.getMessage());
            }
            if (status == 409) {
                return new ConflictException("api_exception", body.getMessage());
            }
            return new ApiException("api_exception", body.getMessage());
        } catch (Throwable error) {
            log.error("Could not deserialize API error message", error);
            return new ApiException("api_exception", HttpStatus.valueOf(status).getReasonPhrase());
        }
    }
}
