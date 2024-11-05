package com.client.client_service.mapper;

import com.client.client_service.dto.ClientDto;
import com.client.client_service.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring") // Habilita la inyección de Spring
public interface ClientMapper {
    @Mapping(target = "documentNumber", ignore = true)
    ClientDto clientToClientDto(Client client);
    Client clientDtoToClient(ClientDto clientDto);
}
