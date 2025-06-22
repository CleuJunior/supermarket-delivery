package br.com.smd.products.supermarket_delivery_cart.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class LocaleInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        ServletRequestAttributes request = (ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes();

        Optional.ofNullable(request.getRequest().getHeader("Accept-Language"))
                .filter(header -> !header.isBlank())
                .ifPresent(language -> template.header("Accept-Language", language));
    }

}
