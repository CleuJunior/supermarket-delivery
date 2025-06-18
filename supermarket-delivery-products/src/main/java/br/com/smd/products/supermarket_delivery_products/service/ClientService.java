package br.com.smd.products.supermarket_delivery_products.service;

import br.com.smd.products.supermarket_delivery_products.domain.Address;
import br.com.smd.products.supermarket_delivery_products.domain.Client;
import br.com.smd.products.supermarket_delivery_products.dto.request.ClientRequest;
import br.com.smd.products.supermarket_delivery_products.dto.request.ClientUpdateAddressRequest;
import br.com.smd.products.supermarket_delivery_products.dto.response.ClientResponse;
import br.com.smd.products.supermarket_delivery_products.exception.NotFoundException;
import br.com.smd.products.supermarket_delivery_products.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;

    public ClientResponse findById(String clientId) {
        return repository.findById(clientId)
                .map(ClientResponse::new)
                .orElseThrow(() -> {
                    log.warn("Client id: [{}] not found", clientId);
                    return new NotFoundException("client.id.not.found", clientId);
                });
    }

    public List<ClientResponse> getListClient() {
        return repository.clientsNotDeleted()
                .stream()
                .filter(Objects::nonNull)
                .map(ClientResponse::new)
                .toList();
    }

    public ClientResponse saveClient(ClientRequest request) {
        Client entity = new Client(request);
        log.info("Save product: [{}]", entity);

        return new ClientResponse(repository.save(entity));
    }

    public ClientResponse updateAddress(String clientId, ClientUpdateAddressRequest request) {
        return repository.findById(clientId)
                .map(c -> {
                    Address address = Address.builder()
                            .street(request.street())
                            .number(request.number())
                            .zipCode(request.zipCode())
                            .city(request.city())
                            .state(request.state())
                            .neighborhood(request.neighborhood())
                            .complement(request.complement())
                            .build();

                    c.setAddress(address);
                    return repository.save(c);
                })
                .map(ClientResponse::new)
                .orElseThrow(() -> new NotFoundException("client.id.not.found", clientId));
    }
}
