package com.oms.service;


import com.oms.dto.AssessmentDto.ClientDto;

import java.util.List;

public interface ClientService {

    String addClient(ClientDto clientDto);

    ClientDto GetById(Integer clientId);

    public List<ClientDto> getAllClient(int pageNo, int pageSize);

    String deleteAttendance(Integer clientId);

    String updateClient(Integer clientId, ClientDto clientDto);

}
