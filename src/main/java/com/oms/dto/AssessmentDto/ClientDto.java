package com.oms.dto.AssessmentDto;

import com.oms.Entity.Client;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

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

    public ClientDto(Client client) {
        this.clientId = client.getClientId();
        this.companyAddress =client.getCompanyAddress();
        this.companyRegNumber = client.getCompanyRegNumber();
        this.dateOfBirth = client.getDateOfBirth();
        this.dateOfJoining = client.getDateOfJoining();
        this.email =client.getEmail();
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.gender = client.getGender();
        this.gstNumber = client.getGstNumber();
        this.mobileNumber = client.getMobileNumber();
        this.panNumber = client.getPanNumber();
        this.serviceOrProduct = client.getServiceOrProduct();
        this.status = client.getStatus();
        this.userId = client.getUserId();
    }


}
