package br.com.smd.products.supermarket_delivery_cart.exception;

import lombok.Data;

@Data
public class DomainException extends RuntimeException {

    private final String messageKey;
    private final String[] arguments;

    public DomainException(String messageKey, String... arguments) {
        this.messageKey = messageKey;
        this.arguments = arguments;
    }
}
