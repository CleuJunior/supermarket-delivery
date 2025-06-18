package br.com.smd.products.supermarket_delivery_products.controller;

import br.com.smd.products.supermarket_delivery_products.dto.request.ClientRequest;
import br.com.smd.products.supermarket_delivery_products.dto.request.ClientUpdateAddressRequest;
import br.com.smd.products.supermarket_delivery_products.dto.response.ClientResponse;
import br.com.smd.products.supermarket_delivery_products.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;

    @GetMapping("/{clientId}")
    public ResponseEntity<ClientResponse> getClientById(@PathVariable("clientId") String clientId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.findById(clientId));
    }

    @GetMapping
    public ResponseEntity<List<ClientResponse>> getListClient() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getListClient());
    }

    @PostMapping
    public ResponseEntity<ClientResponse> saveClient(@RequestBody ClientRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.saveClient(request));
    }

    @PatchMapping("/{clientId}")
    public ResponseEntity<ClientResponse> updateClientAddress(@PathVariable("clientId") String clientId,
                                                              @RequestBody ClientUpdateAddressRequest request) {

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(service.updateAddress(clientId, request));
    }
}
