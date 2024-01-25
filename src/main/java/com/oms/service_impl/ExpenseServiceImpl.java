package com.oms.service_impl;


import com.oms.Entity.Expense;
import com.oms.dto.ExpenseDto.ExpenseDto;
import com.oms.exceptions.ExpenceException.Incorrect;
import com.oms.exceptions.ExpenceException.Incorrect1;
import com.oms.repositories.ExpenseRepository;
import com.oms.service.ExpenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenceService {


    @Autowired
    public ExpenseRepository expenseRepository;


    //PostMapping(add)
    @Override
    public String addExpence(ExpenseDto expenseDto) {

        Expense expense1 = new Expense(expenseDto);

        expenseRepository.save(expense1);
        return "Expences Added Successfully";
    }

    @Override
    public String updateExpence(ExpenseDto newExpenseDto, Integer id) {
        Expense expense1 = expenseRepository.findById(id).orElseThrow(() -> new Incorrect("ExpencesNotFound", HttpStatus.NOT_FOUND));

        if (newExpenseDto.getAmount() != null) {
            expense1.setAmount(newExpenseDto.getAmount());
        }

        if (newExpenseDto.getCategory() != null) {
            expense1.setCategory(newExpenseDto.getCategory());
        }

        if (newExpenseDto.getDate() != null) {
            expense1.setDate(newExpenseDto.getDate());
        }

        if (newExpenseDto.getDescription() != null) {
            expense1.setDescription(newExpenseDto.getDescription());
        }

        if (newExpenseDto.getName() != null) {
            expense1.setName(newExpenseDto.getName());
        }

        if (newExpenseDto.getPaidBy() != null) {
            expense1.setPaidBy(newExpenseDto.getPaidBy());
        }

        if (newExpenseDto.getPaymentType() != null) {
            expense1.setPaymentType(newExpenseDto.getPaymentType());
        }

        if (newExpenseDto.getUserId() != null) {
            expense1.setUserId(newExpenseDto.getUserId());
        }

        if (newExpenseDto.getExpenseId() != null) {
            expense1.setExpenseId(newExpenseDto.getExpenseId());
        }

        expenseRepository.save(expense1);
        return "Expense Updated";
    }


    public ExpenseDto getById(Integer expenseId) {
        Optional<Expense> byId = expenseRepository.findById(expenseId);
        if (byId.isPresent()) {
            ExpenseDto expenseDto = new ExpenseDto(byId.get());
            expenseDto.setExpenseId(expenseId);
            return expenseDto;
        } else {
            throw new Incorrect("Expences Not Found", HttpStatus.NOT_FOUND);
        }
    }


    @Override
    public List<ExpenseDto> getAllExpences() {
        List<Expense> all = expenseRepository.findAll();
        if (all.isEmpty()) {
            throw new Incorrect("Expences Added Successfully not found", null);
        }
        return all.stream().map(ExpenseDto::new).collect(Collectors.toList());
    }


    @Override
    public String deleteExpence(Integer id) {
        Optional<Expense> byId = expenseRepository.findById(id);
        if (byId.isPresent()) {
            expenseRepository.deleteById(id);
            return "Expence Data Deleted Sucessfully";
        } else {
            throw new Incorrect1("Expence Id Not Found");
        }

    }


}







