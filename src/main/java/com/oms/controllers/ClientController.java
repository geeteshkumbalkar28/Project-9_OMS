package com.oms.controllers;

import com.oms.Entity.Client;
import com.oms.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;

    public List<Client> getAllClients() {
        return this.clientService.getAllClients();
    }
    @GetMapping("/{clientId}")
    public Optional<Client> getClientById(@PathVariable Integer clientId){
        return clientService.getClientById(clientId);
    }
    @PostMapping
    public Client saveClient(@RequestBody Client client){
        return clientService.saveClient(client);
    }



    @DeleteMapping("/{clientId}")
    public void deleteClient(@PathVariable Integer clientId){
        clientService.deleteClient(clientId);
    }
}

