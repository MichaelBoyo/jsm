package com.jsm.jsmapp.services.expenseService;

import com.jsm.jsmapp.data.dtos.AddExpenseRequest;
import com.jsm.jsmapp.data.dtos.GetALlExpenseRequest;
import com.jsm.jsmapp.data.dtos.Response;
import com.jsm.jsmapp.data.dtos.UpdateExpenseRequest;
import com.jsm.jsmapp.data.models.Expense;
import com.jsm.jsmapp.exceptions.ExpenseNotFoundException;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;

public interface ExpenseService {
    Response addExpense(AddExpenseRequest expenseRequest);
    String updateExpense(UpdateExpenseRequest expenseRequest);
    String deleteExpense(String id);
    Expense getExpense(String id) throws ExpenseNotFoundException;
    Page<Expense> getExpenses(GetALlExpenseRequest expenseRequest);

    List<Expense> getAllExpenses();
}
