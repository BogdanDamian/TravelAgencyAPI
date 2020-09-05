package org.travel.mapper;

import org.mapstruct.Mapper;
import org.travel.dto.ClientDto;
import org.travel.model.Client;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client dtoToModel(ClientDto clientDto);

    ClientDto modelToDto(Client client);
}
