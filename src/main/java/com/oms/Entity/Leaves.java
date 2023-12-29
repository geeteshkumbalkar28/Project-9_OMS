package com.oms.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Leaves {

    @Id
    @Column(name= "leave_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer leaveId;

    @Column
    private String leaveType;

    @Column
    private Integer noOfLeave;

    @Column(length = 45)
    private String status;

}