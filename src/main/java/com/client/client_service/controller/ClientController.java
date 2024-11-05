package com.client.client_service.controller;

import com.client.client_service.dto.ClientDto;
import com.client.client_service.exception.ResourceNotFoundException;
import com.client.client_service.model.ApiResponse;
import com.client.client_service.model.Client;
import com.client.client_service.service.ClientConversionService;
import com.client.client_service.service.ClientService;
import com.client.client_service.mapper.ClientMapper; // Asegúrate de importar tu mapper
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientConversionService clientConversionService; // Inyección del mapper

    @GetMapping("/clients/{codigoUnico}")
    public Mono<ResponseEntity<ApiResponse<ClientDto>>> getClients(@PathVariable("codigoUnico") String codigoUnico) {
        return clientService.getClientByUniqueCode(codigoUnico)
                .map(client -> ResponseEntity.ok(ApiResponse.success(clientConversionService.convertToDto(client), 200)))
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("Client not found with unique code: " + codigoUnico)));
    }
}
