package com.oms.dto.ExpenseDto;

import com.oms.Entity.Expense;

import lombok.*;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDto {
    private Integer expenseId;


    private Integer amount;
    private String category;
    private OffsetDateTime date;
    private String description;
    private String name;
    private String paidBy;
    private String paymentType;
    private Integer userId;
    private String expensecol;

    //Dto to Entity

    public ExpenseDto(Expense expense) {
        this.amount = expense.getAmount();
        this.category = expense.getCategory();
        this.date = expense.getDate();
        this.description = expense.getDescription();
        this.name = expense.getName();
        this.paidBy = expense.getPaidBy();
        this.paymentType = expense.getPaymentType();
        this.userId = expense.getUserId();
        this.expensecol = expense.getExpensecol();


    }


}
