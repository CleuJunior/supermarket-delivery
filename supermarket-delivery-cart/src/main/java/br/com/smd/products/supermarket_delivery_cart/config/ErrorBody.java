package br.com.smd.products.supermarket_delivery_cart.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorBody {
    private int status;
    private String message;
    private String details;

    public static ErrorBody from(String message, int status) {
        ErrorBody body = new ErrorBody();
        body.message = message;
        body.status = status;
        return body;
    }
}

