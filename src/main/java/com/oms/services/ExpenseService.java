package com.oms.services;

import com.oms.Entity.Expense;
import com.oms.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;
    private static List<Expense> list = new ArrayList<>();

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Optional<Expense> getClientById(Integer expenseId) {
        return expenseRepository.findById(expenseId);
    }

    public Expense saveClient(Expense expense){
        return expenseRepository.save(expense);
    }

    public  void deleteExpense(Integer expenseId){
        expenseRepository.deleteById(expenseId);
    }
}
