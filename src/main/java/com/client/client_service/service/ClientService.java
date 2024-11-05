package com.client.client_service.service;

import com.client.client_service.dto.ClientDto;
import com.client.client_service.exception.NotFoundException;
import com.client.client_service.exception.ResourceNotFoundException;
import com.client.client_service.model.Client;
import com.client.client_service.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Mono<Client> getClientByUniqueCode(String codigoUnico) {
        return clientRepository.findByUniqueCode(codigoUnico)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("Cliente no encontrado con código único: " + codigoUnico)));
    }
}