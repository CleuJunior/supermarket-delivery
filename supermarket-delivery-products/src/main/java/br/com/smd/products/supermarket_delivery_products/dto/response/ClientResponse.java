package br.com.smd.products.supermarket_delivery_products.dto.response;

import br.com.smd.products.supermarket_delivery_products.domain.Address;
import br.com.smd.products.supermarket_delivery_products.domain.Client;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.ZonedDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ClientResponse(
        String id,
        String name,
        String cpf,
        @JsonProperty("birth_date")
        LocalDate birthDate,
        String email,
        @JsonProperty("phone_number")
        String phoneNumber,
        Address address,
        boolean deleted,
        @JsonProperty("creation_date")
        ZonedDateTime creationDate,
        @JsonProperty("last_modified_date")
        ZonedDateTime lastModifiedDate

) {

    public ClientResponse(Client entity) {
        this(
                entity.getId(),
                entity.getName(),
                entity.getCpf(),
                entity.getBirthDate(),
                entity.getEmail(),
                entity.getPhoneNumber(),
                entity.getAddress().orElse(null),
                entity.isDeleted(),
                entity.getCreationDate(),
                entity.getLastModifiedDate()
        );
    }
}

