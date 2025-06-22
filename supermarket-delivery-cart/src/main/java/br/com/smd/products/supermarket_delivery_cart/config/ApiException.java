package br.com.smd.products.supermarket_delivery_cart.config;

import br.com.smd.products.supermarket_delivery_cart.exception.DomainException;
import lombok.Getter;

@Getter
public class ApiException extends DomainException {

    public ApiException(String messageKey, String... arguments) {

        super(messageKey, arguments);
    }
}
