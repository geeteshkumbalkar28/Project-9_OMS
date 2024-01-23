package com.oms.service_impl;

import com.oms.Entity.Client;
import com.oms.dto.AssessmentDto.ClientDto;
import com.oms.exceptions.AssesmentException.ClientAlreadyExistException;
import com.oms.exceptions.AssesmentException.ClientNotFoundException;
import com.oms.repositories.ClientRepository;
import com.oms.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;


    @Override
    public String addClient(ClientDto clientDto) {
        Client byEmail = clientRepository.findByEmail(clientDto.getEmail());
        if (byEmail == null){
                Client client = new Client(clientDto);
            clientRepository.save(client);
                return "Client save successfully";
        }else {
            throw new ClientAlreadyExistException("Client already exist");
        }
    }


    @Override
    public  ClientDto GetById(Integer clientId) {
        Optional<Client> byId = clientRepository.findById(clientId);
        if (byId.isEmpty()){
                throw new ClientNotFoundException("Client NOt Found", HttpStatus.NOT_FOUND);
            }
        ClientDto clientDto = new ClientDto(byId.get());
        clientDto.setClientId(clientId);
            return clientDto;
    }

    @Override
    public List<ClientDto> getAllClient(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        if (pageable.isPaged()) {

            Page<Client> clients = clientRepository.findAll(pageable);

            List<ClientDto> all = new ArrayList<>();

            for (Client client : clients) {
                ClientDto clientDto = new ClientDto(client);
                all.add(clientDto);
            }
            return all;
        }else {
            throw new ClientNotFoundException("Resource Not Found");

        }
    }

    @Override
    public String deleteAttendance(Integer clientId) {
        ClientDto clientDto = GetById(clientId);
        if (clientDto == null){
            throw new ClientNotFoundException("Id Not Found");
        }
        clientRepository.deleteById(clientId);
        return "Attendance Deleted Successfully";
    }


    @Override
    public String updateClient(Integer clientId, ClientDto clientDto) {
        Optional<Client> byId = clientRepository.findById(clientId);

        if (byId.isPresent()) {
            Client client = byId.get();
            client.setCompanyAddress(clientDto.getCompanyAddress());
            client.setCompanyRegNumber(clientDto.getCompanyRegNumber());
            client.setDateOfBirth(clientDto.getDateOfBirth());
            client.setDateOfJoining(clientDto.getDateOfJoining());
            client.setEmail(clientDto.getEmail());
            client.setFirstName(clientDto.getFirstName());
            client.setLastName(clientDto.getLastName());
            client.setGender(clientDto.getGender());
            client.setGstNumber(clientDto.getGstNumber());
            client.setMobileNumber(clientDto.getMobileNumber());
            client.setPanNumber(clientDto.getPanNumber());
            client.setServiceOrProduct(clientDto.getServiceOrProduct());
            client.setStatus(clientDto.getStatus());
            client.setUserId(clientDto.getUserId());

            clientRepository.save(client);
            return "Client Updated Successfully";
        } else {
            throw new ClientNotFoundException("Client not found with ID: " + clientId, HttpStatus.NOT_FOUND);
        }
    }
}
