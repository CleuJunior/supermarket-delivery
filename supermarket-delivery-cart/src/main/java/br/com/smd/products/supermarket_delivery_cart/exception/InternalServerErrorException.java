package br.com.smd.products.supermarket_delivery_cart.exception;

public class InternalServerErrorException extends DomainException {

    public InternalServerErrorException(String messageKey, String... arguments) {

        super(messageKey, arguments);
    }
}
