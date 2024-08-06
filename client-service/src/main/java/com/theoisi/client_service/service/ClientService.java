package com.theoisi.client_service.service;


import com.theoisi.client_service.dto.ClientRequest;
import com.theoisi.client_service.dto.ClientResponse;
import com.theoisi.client_service.model.Client;
import com.theoisi.client_service.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientService {

    private final ClientRepository clientRepository;

    public void createClient(ClientRequest clientRequest) {
        Client client = Client.builder()
                .name(clientRequest.getName())
                .email(clientRequest.getEmail())
                .phone(clientRequest.getPhone())
                .profession(clientRequest.getProfession())
                .address(clientRequest.getAddress())
                .build();

        clientRepository.save(client);
        log.info("Client {} created", client.getId());
    }

    public List<ClientResponse> getAllClients() {
        List<Client> clients = clientRepository.findAll();

        return clients.stream().map(this::mapToClientResponse).toList();
    }

    private ClientResponse mapToClientResponse(Client client) {
        return ClientResponse.builder()
                .id(client.getId())
                .name(client.getName())
                .email(client.getEmail())
                .phone(client.getPhone())
                .profession(client.getProfession())
                .address(client.getAddress())
                .build();
    }

    public ClientResponse getClientById(String id) {
        Optional<Client> clientOptional = clientRepository.findById(id);

        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            return mapToClientResponse(client);
        } else {
            log.warn("Client with id {} not found", id);
            return null;
        }
    }
}
