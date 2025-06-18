package br.com.smd.products.supermarket_delivery_products.seed;

import br.com.smd.products.supermarket_delivery_products.domain.Address;
import br.com.smd.products.supermarket_delivery_products.domain.Client;
import br.com.smd.products.supermarket_delivery_products.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class ClientSeed {

    private final ClientRepository repository;

    @Bean
    public CommandLineRunner seedClient() {
        return args -> {
            List<Client> check = repository.findAll();

            if (check.isEmpty()) {
                List<Client> clientList = repository.saveAll(this.listClients());
                log.info("Seeding client database: [{}]", clientList);
            }
        };
    }

    private List<Client> listClients() {
        Client client1 = new Client();
        client1.setFirstName("Joao");
        client1.setLastName("Silva");
        client1.setName("Joao Silva");
        client1.setCpf("123.456.789-00");
        client1.setBirthDate(LocalDate.of(1990, 5, 15));
        client1.setEmail("joao.silva@email.com");
        client1.setPhoneNumber("(11) 91234-5678");
        client1.setAddress(new Address("Rua das Flores", 123, "00918273", "Sao Paulo", "SP", "Jardim Primavera", "Rua Jararaca"));
        client1.setDeleted(false);

        Client client2 = new Client();
        client2.setFirstName("Maria");
        client2.setLastName("Santos");
        client2.setName("Maria Santos");
        client2.setCpf("987.654.321-00");
        client2.setBirthDate(LocalDate.of(1985, 8, 22));
        client2.setEmail("maria.santos@email.com");
        client2.setPhoneNumber("(21) 99876-5432");
        client2.setDeleted(false);

        Client client3 = new Client();
        client3.setFirstName("Pedro");
        client3.setLastName(null);
        client3.setName("Pedro");
        client3.setCpf("111.222.333-44");
        client3.setBirthDate(LocalDate.of(1995, 3, 10));
        client3.setEmail("pedro@email.com");
        client3.setPhoneNumber("(31) 98765-4321");
        client3.setAddress(new Address("Rua do Sol", 789, null, "Belo Horizonte", "MG", "Vila Nova", "30123-456"));
        client3.setDeleted(true);

        Client client4 = new Client();
        client4.setFirstName("Ana");
        client4.setLastName("Oliveira");
        client4.setName("Ana Oliveira");
        client4.setCpf("555.666.777-88");
        client4.setBirthDate(LocalDate.of(1978, 12, 1));
        client4.setEmail("ana.oliveira@email.com");
        client4.setPhoneNumber("(41) 91234-9876");
        client4.setAddress(new Address("Rua das Palmeiras", 101, "881729371", "Curitiba", "PR", "Jardim das Flores", "80000-123"));
        client4.setDeleted(false);

        Client client5 = new Client();
        client5.setFirstName("Lucas");
        client5.setLastName("Costa");
        client5.setName("Lucas Costa");
        client5.setCpf("222.333.444-55");
        client5.setBirthDate(LocalDate.of(2000, 7, 30));
        client5.setEmail("lucas.costa@email.com");
        client5.setPhoneNumber("(51) 92345-6789");
        client5.setDeleted(false);

        return List.of(client1, client2, client3, client4, client5);
    }

}
