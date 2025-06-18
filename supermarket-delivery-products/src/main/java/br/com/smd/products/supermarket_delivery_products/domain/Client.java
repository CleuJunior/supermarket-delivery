package br.com.smd.products.supermarket_delivery_products.domain;

import br.com.smd.products.supermarket_delivery_products.dto.request.ClientRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("clients-entity")
public class Client extends Entity {

    @Field(name = "first_name")
    private String firstName;
    @Field(name = "last_name")
    private String lastName;
    private String name;
    private String cpf;
    @Field(name = "birth_date")
    private LocalDate birthDate;
    private String email;
    @Field("phone_number")
    private String phoneNumber;
    @Field(write = Field.Write.ALWAYS)
    private Address address;

    public Client(ClientRequest request) {
        this.firstName = request.firstName();
        this.lastName = request.lastName();
        this.name = name();
        this.cpf = request.cpf();
        this.birthDate = request.birthDate();
        this.email = request.email();
        this.phoneNumber = request.phoneNumber();
        this.address = request.address();
    }

    private String name() {
        return Optional.ofNullable(lastName)
                .map(ln -> firstName + " " + ln)
                .orElse(firstName);
    }

    public Optional<Address> getAddress() {
        return Optional.ofNullable(address);
    }

}
