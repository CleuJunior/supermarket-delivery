package br.com.smd.products.supermarket_delivery_cart.exception;

public class BadRequestException extends DomainException {

    public BadRequestException(String messageKey, String... arguments) {

        super(messageKey, arguments);
    }
}
