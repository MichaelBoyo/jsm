package com.jsm.jsmapp.controller;

import com.jsm.jsmapp.data.dtos.AddIncomeRequest;
import com.jsm.jsmapp.data.dtos.GetALlIncomeRequest;
import com.jsm.jsmapp.data.dtos.UpdateIncomeRequest;
import com.jsm.jsmapp.exceptions.IncomeNotFoundException;
import com.jsm.jsmapp.services.incomeService.IncomeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/api/v1/income")
@AllArgsConstructor
public class IncomeController {
    private final IncomeService incomeService;
    @PostMapping
    public ResponseEntity<?> addIncome(@RequestBody AddIncomeRequest request){
        return ResponseEntity.ok(incomeService.addIncome(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getIncome(@PathVariable String id) throws IncomeNotFoundException {
        return ResponseEntity.ok(incomeService.getIncome(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteIncome(@PathVariable String id){
        return ResponseEntity.ok(incomeService.deleteIncome(id));
    }
    @PatchMapping
    public ResponseEntity<?> updateExpense(@RequestBody UpdateIncomeRequest request){
        return ResponseEntity.ok(incomeService.updateIncome(request));
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllExpense(@RequestParam Integer noOfItemsPerPage, @RequestParam Integer pageNumber ){
        GetALlIncomeRequest expenseRequest = new GetALlIncomeRequest(noOfItemsPerPage, pageNumber);
        return ResponseEntity.ok(incomeService.getIncomes(expenseRequest));
    }
}
