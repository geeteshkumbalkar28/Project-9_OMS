package com.oms.controllers;

import com.oms.Entity.Expense;
import com.oms.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    public List<Expense> getAllClients() {
        return this.expenseService.getAllExpenses();
    }
    @GetMapping("/{expenseId}")
    public Optional<Expense> getExpenseById(@PathVariable Integer expenseId){
        return expenseService.getClientById(expenseId);
    }
    @PostMapping
    public Expense saveClient(@RequestBody Expense expense){
        return expenseService.saveClient(expense);
    }
    @DeleteMapping("/{expenseId}")
    public void deleteExpense(@PathVariable Integer expenseId){
        expenseService.deleteExpense(expenseId);
    }
}

