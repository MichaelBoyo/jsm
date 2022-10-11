package com.jsm.jsmapp.data.repositories;

import com.jsm.jsmapp.data.models.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpenseRepository extends MongoRepository<Expense, String> {
}
