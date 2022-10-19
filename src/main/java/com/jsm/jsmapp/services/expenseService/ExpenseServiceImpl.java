package com.jsm.jsmapp.services.expenseService;


import com.jsm.jsmapp.data.dtos.AddExpenseRequest;
import com.jsm.jsmapp.data.dtos.GetALlExpenseRequest;
import com.jsm.jsmapp.data.dtos.Response;
import com.jsm.jsmapp.data.dtos.UpdateExpenseRequest;
import com.jsm.jsmapp.data.models.Expense;
import com.jsm.jsmapp.data.repositories.ExpenseRepository;
import com.jsm.jsmapp.exceptions.ExpenseNotFoundException;
import com.jsm.jsmapp.services.notificationService.NotificationService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@AllArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final NotificationService notificationService;
    private final ModelMapper modelMapper;
    @Override
    public Response addExpense(AddExpenseRequest expenseRequest) {
        Expense expense = modelMapper.map(expenseRequest, Expense.class);
        expense.setDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
        expenseRepository.save(expense);
        notificationService.addNotification(expenseRequest.getPostedBy()+" added expense, "+ expenseRequest.getAmount());
        return new Response(200,"Expense added successfully");
    }

    @Override
    public String updateExpense(UpdateExpenseRequest expenseRequest) {
        return null;
    }

    @Override
    public String deleteExpense(Long id) {
        expenseRepository.deleteById(id);
        return "Expense deleted successfully";
    }

    @Override
    public Expense getExpense(Long id) throws ExpenseNotFoundException {
        return expenseRepository.findById(id)
                .orElseThrow(ExpenseNotFoundException::new);
    }

    @Override
    public Page<Expense> getExpenses(GetALlExpenseRequest expenseRequest) {

        Pageable pageSpecs = PageRequest
                .of(expenseRequest.pageNumber() - 1,
                        expenseRequest.numberOfItemsPerPage());
        return expenseRepository.findAll(pageSpecs);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }
}
