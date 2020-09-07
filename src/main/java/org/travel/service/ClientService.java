package org.travel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.travel.dto.ClientDto;
import org.travel.exception.TravelAgencyException;
import org.travel.exception.clientException.*;
import org.travel.mapper.ClientMapper;
import org.travel.model.Client;
import org.travel.repository.ClientRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRep;
    @Autowired
    private ClientMapper clientMap;

    private List<Client> getAll(Integer pageNr, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNr, pageSize);
        return clientRep.findAll(pageable).toList();
    }

    private List<Client> getByTelephone(String telephone) {
        return clientRep.findAllByTelephone(telephone);
    }

    private List<Client> getAllByNameContaining(String name, Integer pageNr, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNr, pageSize);
        return clientRep.findAllByNameContaining(name, pageable);
    }

    public List<ClientDto> get(String name, String telephone, Integer pageNr, Integer pageSize)
            throws TravelAgencyException {
        List<Client> clients;
        if (name == null && telephone == null) clients = getAll(pageNr, pageSize);
        else if (telephone == null) clients = getAllByNameContaining(name, pageNr, pageSize);
        else if (name == null) clients = getByTelephone(telephone);
        else throw new ClientMeaninglessSearchException();

        if (clients.size() == 0) throw new ClientsNotFoundException();

        return clients.stream()
                .map(client -> clientMap.modelToDto(client))
                .collect(Collectors.toList());
    }

    public ClientDto getById(Long id) throws TravelAgencyException {
        Client client = clientRep.findById(id).orElse(null);
        if (client == null) throw new ClientNotFoundException();
        return clientMap.modelToDto(client);
    }

    private ClientDto saveOrUpdate(ClientDto clientDto) throws TravelAgencyException {
        if (clientDto.getName() == null) throw new ClientNullNameException();
        Client client = clientMap.dtoToModel(clientDto);
        client = clientRep.save(client);
        return clientMap.modelToDto(client);
    }

    public ClientDto save(ClientDto clientDto) throws TravelAgencyException {
        if (clientDto.getId() != null && clientRep.existsById(clientDto.getId()))
            throw new ClientExistsException();
        return saveOrUpdate(clientDto);
    }

    public ClientDto update(ClientDto clientDto) throws TravelAgencyException {
        if (!clientRep.existsById(clientDto.getId())) throw new ClientNotFoundException();
        return saveOrUpdate(clientDto);
    }

    public ClientDto deleteById(Long id) throws TravelAgencyException {
        ClientDto clientDto = getById(id);
        clientRep.delete(clientMap.dtoToModel(clientDto));
        return clientDto;
    }

}
