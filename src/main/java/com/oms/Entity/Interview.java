package com.oms.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Interview {

    @Id
    @Column(name = "interview_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer interviewId;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String mobileNo;

    @Column
    private OffsetDateTime interviewDate;

    @Column
    private LocalTime interviewTime;

    @Column
    private String profile;

    @Column
    private String gender;

    @Column(length = 50)
    private String status;

    @Column
    private OffsetDateTime date;

    @Column(length = 45)
    private String location;

    @Column(length = 45)
    private String mode;

    @Column(length = 45)
    private String result;

}