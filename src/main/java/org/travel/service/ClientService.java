package org.travel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.travel.mapper.ClientMapper;
import org.travel.repository.ClientRepository;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRep;
    @Autowired
    private ClientMapper clientMap;
}
