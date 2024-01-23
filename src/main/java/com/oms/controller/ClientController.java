package com.oms.controller;

import com.oms.dto.AssessmentDto.ClientDto;
import com.oms.dto.AssessmentDto.ResponseAllClientDTO;
import com.oms.dto.AssessmentDto.ResponseClientDTO;
import com.oms.dto.AssessmentDto.ResponseDto1;
import com.oms.exceptions.AssesmentException.ClientAlreadyExistException;
import com.oms.exceptions.AssesmentException.ClientNotFoundException;
import com.oms.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/addClient")
    public ResponseEntity<String> addClient(@RequestBody ClientDto clientDto) {
        try {
            String response = clientService.addClient(clientDto);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (ClientAlreadyExistException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student already exists");
        }
    }

    @GetMapping("/byID")
    public ResponseEntity<ResponseClientDTO> GetClientById(@RequestParam Integer clientId){
        try {
            ResponseClientDTO success = new ResponseClientDTO("success");
            ClientDto clientDto = clientService.GetById(clientId);
            success.setObject(clientDto);
            return ResponseEntity.status(HttpStatus.OK).body(success);

        }catch (ClientNotFoundException e)
        {
            ResponseClientDTO responseClientDTO = new ResponseClientDTO("unsuccessful");
            responseClientDTO.setException("User Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseClientDTO);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseAllClientDTO> getAllAssessment(@RequestParam int  pageNo,
                                                                 @RequestParam(value = "pageSize" , defaultValue = "10") int pageSize) {
        try {
            ResponseAllClientDTO allClientDTO = new ResponseAllClientDTO("success");
            List<ClientDto> allClient = clientService.getAllClient(pageNo, pageSize);

            if (allClient.isEmpty()){
                allClientDTO.setMessage("Unsuccess");
                allClientDTO.setException("Page Not Found");
            }else {
            allClientDTO.setList(allClient);
            }
            return ResponseEntity.status(HttpStatus.OK).body(allClientDTO);
        }catch (ClientNotFoundException e)
        {
            ResponseAllClientDTO unsuccessful = new ResponseAllClientDTO("unsuccessful");
            unsuccessful.setException("Page Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(unsuccessful);
        }
    }


    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto1> deleteAssessment(@RequestParam Integer clientId) {
        try {
            String string = clientService.deleteAttendance(clientId);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto1("success", string));
        } catch (ClientNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto1("unsucces", "Id Not Found"));
        }
    }

    @PatchMapping("/update/{clientId}")
    public ResponseEntity<ResponseDto1> UpdateClient(@RequestBody ClientDto clientDto, @PathVariable ("clientId")Integer clientId){
        try {
            String result = clientService.updateClient(clientId,clientDto);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto1("success", result));
        }
        catch (ClientNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto1("unsuccess", "ID Not Found"));
        }
    }
}
