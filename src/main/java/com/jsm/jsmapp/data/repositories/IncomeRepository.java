package com.jsm.jsmapp.data.repositories;

import com.jsm.jsmapp.data.models.Income;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IncomeRepository extends MongoRepository<Income, String> {
}

