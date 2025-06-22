package br.com.smd.products.supermarket_delivery_cart.exception;

import br.com.smd.products.supermarket_delivery_cart.config.LocalizedMessageTranslationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionAdvice {

    private final LocalizedMessageTranslationService localizedMessageTranslationService;

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ErrorMessage handle(NotFoundException cause, Locale locale) {
        log.error("Not Found: {}", cause.getMessage());
        String translated = localizedMessageTranslationService.translateMessage(cause);

        return ErrorMessage.from(translated, NOT_FOUND.value());
    }

}