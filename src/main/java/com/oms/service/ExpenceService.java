package com.oms.service;


import com.oms.dto.ExpenseDto.ExpenseDto;

import java.util.List;

public interface ExpenceService {


    public String addExpence(ExpenseDto expense);


    String updateExpence(ExpenseDto newExpenseDto, Integer id);


    //GET (get All )

    List<ExpenseDto> getAllExpences();


    String deleteExpence(Integer id);

    ExpenseDto getById(Integer expenseId);
}
