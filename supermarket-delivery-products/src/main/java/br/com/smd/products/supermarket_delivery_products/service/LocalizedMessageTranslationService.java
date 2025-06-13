package br.com.smd.products.supermarket_delivery_products.service;

import br.com.smd.products.supermarket_delivery_products.exception.DomainException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;

import java.util.Locale;

@RequiredArgsConstructor
@Service
public class LocalizedMessageTranslationService {
    private final MessageSource source;

    public String translateMessage(DomainException exception) {
        Locale locale = LocaleContextHolder.getLocale();
        return source.getMessage(exception.getMessageKey(), exception.getArguments(), locale);
    }

    public String translateMessage(String messageKey, String... arguments) {
        Locale locale = LocaleContextHolder.getLocale();
        return source.getMessage(messageKey, arguments, locale);
    }

    public String translateMessage(FieldError fieldError) {
        Locale locale = LocaleContextHolder.getLocale();
        return source.getMessage(fieldError, locale);
    }
}
