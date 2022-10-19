package com.jsm.jsmapp.services.incomeService;


import com.jsm.jsmapp.data.dtos.AddIncomeRequest;
import com.jsm.jsmapp.data.dtos.GetALlIncomeRequest;
import com.jsm.jsmapp.data.dtos.Response;
import com.jsm.jsmapp.data.dtos.UpdateIncomeRequest;
import com.jsm.jsmapp.data.models.Income;
import com.jsm.jsmapp.exceptions.IncomeNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IncomeService {
    Response addIncome(AddIncomeRequest incomeRequest);
    String updateIncome(UpdateIncomeRequest expenseRequest);
    String deleteIncome(Long id);
    Income getIncome(Long id) throws IncomeNotFoundException;
    Page<Income> getIncomes(GetALlIncomeRequest expenseRequest);

    List<Income> getAllIncome();
}
