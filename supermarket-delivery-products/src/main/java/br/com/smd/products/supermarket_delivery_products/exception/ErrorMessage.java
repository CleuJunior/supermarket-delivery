package br.com.smd.products.supermarket_delivery_products.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessage {
    private int status;
    private String message;
    private String details;

    public static ErrorMessage from(String message, int status) {
        ErrorMessage body = new ErrorMessage();
        body.message = message;
        body.status = status;
        return body;
    }
}
