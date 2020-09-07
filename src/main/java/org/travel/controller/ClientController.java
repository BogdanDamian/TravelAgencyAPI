package org.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.travel.dto.ClientDto;
import org.travel.exception.TravelAgencyException;
import org.travel.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    private ClientService clientSrv;

    @GetMapping
    public ResponseEntity<List<ClientDto>> get(@RequestParam(required = false, defaultValue = "0") Integer pageNr,
                                               @RequestParam(required = false, defaultValue = "25") Integer pageSize,
                                               @RequestParam(required = false) String name,
                                               @RequestParam(required = false) String telephone) {
        try {
            return new ResponseEntity<>(clientSrv.get(name, telephone, pageNr, pageSize), HttpStatus.OK);
        } catch (TravelAgencyException trAgEx) {
            trAgEx.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(clientSrv.getById(id), HttpStatus.OK);
        } catch (TravelAgencyException trAgEx) {
            trAgEx.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ClientDto> save(@RequestBody ClientDto clientDto) {
        try {
            return new ResponseEntity<>(clientSrv.save(clientDto), HttpStatus.OK);
        } catch (TravelAgencyException trAgEx) {
            trAgEx.printStackTrace();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping
    public ResponseEntity<ClientDto> update(@RequestBody ClientDto clientDto) {
        try {
            return new ResponseEntity<>(clientSrv.update(clientDto), HttpStatus.OK);
        } catch (TravelAgencyException trAgEx) {
            trAgEx.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClientDto> deleteById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(clientSrv.deleteById(id), HttpStatus.OK);
        } catch (TravelAgencyException trAgEx) {
            trAgEx.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
