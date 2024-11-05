package com.client.client_service.service;

import com.client.client_service.dto.ClientDto;
import com.client.client_service.mapper.ClientMapper;
import com.client.client_service.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientConversionService {

    private final ClientMapper clientMapper;

    @Autowired
    public ClientConversionService(ClientMapper clientMapper) {
        this.clientMapper = clientMapper;
    }

    public ClientDto convertToDto(Client client) {
        return clientMapper.clientToClientDto(client);
    }

    public Client convertToEntity(ClientDto clientDto) {
        return clientMapper.clientDtoToClient(clientDto);
    }
}
