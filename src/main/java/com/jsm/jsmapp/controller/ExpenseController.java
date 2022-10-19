package com.jsm.jsmapp.controller;

import com.jsm.jsmapp.data.dtos.AddExpenseRequest;
import com.jsm.jsmapp.data.dtos.GetALlExpenseRequest;
import com.jsm.jsmapp.data.dtos.UpdateExpenseRequest;
import com.jsm.jsmapp.exceptions.ExpenseNotFoundException;
import com.jsm.jsmapp.services.expenseService.ExpenseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/api/v1/expenses")
@Slf4j
public record ExpenseController(ExpenseService expenseService) {
    @PostMapping
    public ResponseEntity<?> addExpense(@RequestBody AddExpenseRequest expenseRequest){
        return ResponseEntity.ok(expenseService.addExpense(expenseRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getExpense(@PathVariable Long id) throws ExpenseNotFoundException {
        return ResponseEntity.ok(expenseService.getExpense(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExpense(@PathVariable Long id){
        return ResponseEntity.ok(expenseService.deleteExpense(id));
    }
    @PatchMapping
    public ResponseEntity<?> updateExpense(@RequestBody UpdateExpenseRequest expenseRequest){
        return ResponseEntity.ok(expenseService.updateExpense(expenseRequest));
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllExpense(@RequestParam Integer noOfItemsPerPage, @RequestParam Integer pageNumber ){
        GetALlExpenseRequest expenseRequest = new GetALlExpenseRequest(noOfItemsPerPage, pageNumber);
        log.info("get all --->{}", expenseRequest);
        return ResponseEntity.ok(expenseService.getExpenses(expenseRequest));
    }
}
