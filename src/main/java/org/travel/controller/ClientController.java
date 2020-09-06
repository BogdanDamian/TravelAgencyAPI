package org.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.travel.service.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    private ClientService clientSrv;
}
