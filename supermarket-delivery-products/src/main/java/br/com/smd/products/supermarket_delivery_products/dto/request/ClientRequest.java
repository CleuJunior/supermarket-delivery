package br.com.smd.products.supermarket_delivery_products.dto.request;

import br.com.smd.products.supermarket_delivery_products.domain.Address;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ClientRequest(
        @JsonProperty("first_name")
        String firstName,
        @JsonProperty("last_name")
        String lastName,
        @CPF
        String cpf,
        @JsonProperty("birth_date")
        LocalDate birthDate,
        @Email
        String email,
        @JsonProperty("phone_number")
        String phoneNumber,
        Address address
) {
}

