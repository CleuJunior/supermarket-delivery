package br.com.smd.products.supermarket_delivery_products.exception;

public class NotFoundException extends DomainException {

    public NotFoundException(String messageKey, String... arguments) {

        super(messageKey, arguments);
    }
}
