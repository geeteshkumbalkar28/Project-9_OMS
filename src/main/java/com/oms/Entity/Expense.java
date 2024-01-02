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
public class Expense {

    @Id
    @Column(name = "expense_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer expenseId;



    @Column(nullable = false)
    private Integer amount;

    @Column
    private String category;

    @Column
    private OffsetDateTime date;

    @Column(name = "\"description\"")
    private String description;

    @Column
    private String name;

    @Column
    private String paidBy;

    @Column
    private String paymentType;

    @Column
    private Integer userId;

    @Column(length = 45)
    private String expensecol;

}