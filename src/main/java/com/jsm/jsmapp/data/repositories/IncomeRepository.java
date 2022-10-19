package com.jsm.jsmapp.data.repositories;

import com.jsm.jsmapp.data.models.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, Long> {
}

