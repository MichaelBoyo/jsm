package com.jsm.jsmapp.data.repositories;

import com.jsm.jsmapp.data.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
