package br.com.smd.products.supermarket_delivery_cart.config.api.client;

import br.com.smd.products.supermarket_delivery_cart.domain.Client;
import feign.Headers;
import feign.RequestLine;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientApi {

    @RequestLine("GET /v1/clients")
    @Headers({"Accept: application/json"})
    List<Client> listProducts();

    @RequestLine("GET /v1/clients/{clientId}")
    @Headers({"Accept: application/json"})
    Client getClientById(@Param("clientId") String clientId);

}
