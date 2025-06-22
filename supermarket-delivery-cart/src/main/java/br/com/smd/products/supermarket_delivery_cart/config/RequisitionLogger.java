package br.com.smd.products.supermarket_delivery_cart.config;

import feign.Logger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class RequisitionLogger extends Logger {

    @Override
    protected void log(String s, String s1, Object... objects) {
        if (s1.equals("---> %s %s HTTP/1.1")) {
            log.info("Requesting from {}", objects[1].toString());
        }

        if (s1.equals("<--- HTTP/1.1 %s%s (%sms)"))
            log.info("Response time: {} ms", objects[2].toString());
    }
}
