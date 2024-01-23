package com.oms.Entity;

import com.oms.dto.AssessmentDto.ClientDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Client {

    @Id
    @Column(name= "client_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clientId;

    @Column
    private String companyAddress;

    @Column
    private String companyRegNumber;

    @Column
    private OffsetDateTime dateOfBirth;

    @Column
    private OffsetDateTime dateOfJoining;

    @Column
    private String email;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String gender;

    @Column
    private String gstNumber;

    @Column
    private String mobileNumber;

    @Column
    private String panNumber;

    @Column
    private String serviceOrProduct;

    @Column
    private String status;

    @Column(length = 45)
    private String userId;

    public Client(ClientDto clientDto) {
        this.clientId = clientDto.getClientId();
        this.companyAddress = clientDto.getCompanyAddress();
        this.companyRegNumber = clientDto.getCompanyRegNumber();
        this.dateOfBirth = clientDto.getDateOfBirth();
        this.dateOfJoining = clientDto.getDateOfJoining();
        this.email = clientDto.getEmail();
        this.firstName = clientDto.getEmail();
        this.lastName = clientDto.getLastName();
        this.gender = clientDto.getGender();
        this.gstNumber = clientDto.getGstNumber();
        this.mobileNumber = clientDto.getMobileNumber();
        this.panNumber = clientDto.getPanNumber();
        this.serviceOrProduct= clientDto.getServiceOrProduct();
        this.status=clientDto.getStatus();
        this.userId = clientDto.getUserId();
    }
}
