package br.com.smd.products.supermarket_delivery_cart.exception;

public class ConflictException extends DomainException {

    public ConflictException(String messageKey, String... arguments) {

        super(messageKey, arguments);
    }
}
