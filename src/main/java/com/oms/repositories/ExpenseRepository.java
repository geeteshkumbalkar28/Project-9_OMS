package com.oms.repositories;

import com.oms.Entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
}
