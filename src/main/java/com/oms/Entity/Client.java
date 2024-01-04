package com.oms.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
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

}
