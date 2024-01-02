package com.oms.services;

import com.oms.Entity.Client;
import com.oms.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
       @Autowired
       private ClientRepository clientRepository;
       private static List<Client> list = new ArrayList<>();

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(Integer clientId) {
        return clientRepository.findById(clientId);
    }

    public Client saveClient(Client client){
        return clientRepository.save(client);
    }

    public  void deleteClient(Integer clientId){
        clientRepository.deleteById(clientId);
    }
}
