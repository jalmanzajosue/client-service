package com.client.client_service.controller;

import com.client.client_service.exception.ResourceNotFoundException;
import com.client.client_service.model.ApiResponse;
import com.client.client_service.model.Client;
import com.client.client_service.model.ErrorDetails;
import com.client.client_service.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api")

public class ClientController {
    @Autowired
    private ClientService clientService;
    @GetMapping("/clients/{codigoUnico}")
    public Mono<ResponseEntity<ApiResponse<Client>>> getClients(@PathVariable("codigoUnico") String codigoUnico) {
        return clientService.getClientByUniqueCode(codigoUnico)
                .map(client -> ResponseEntity.ok(ApiResponse.success(client,200)))
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("Client not found with unique code: " + codigoUnico)));
    }


}