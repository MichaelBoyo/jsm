package com.jsm.jsmapp.services.incomeService;

import com.jsm.jsmapp.data.dtos.AddIncomeRequest;
import com.jsm.jsmapp.data.dtos.GetALlIncomeRequest;
import com.jsm.jsmapp.data.dtos.Response;
import com.jsm.jsmapp.data.dtos.UpdateIncomeRequest;
import com.jsm.jsmapp.data.models.Income;
import com.jsm.jsmapp.data.repositories.IncomeRepository;
import com.jsm.jsmapp.exceptions.IncomeNotFoundException;
import com.jsm.jsmapp.services.notificationService.NotificationService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@AllArgsConstructor
public class IncomeServiceImpl implements IncomeService {
    private final IncomeRepository incomeRepository;
    private final NotificationService notificationService;
    private final ModelMapper modelMapper;

    @Override
    public Response addIncome(AddIncomeRequest incomeRequest) {
        Income income = modelMapper.map(incomeRequest, Income.class);
        income.setDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm")));
        incomeRepository.save(income);
        notificationService.addNotification(incomeRequest.getPostedBy()+" added income, "+ incomeRequest.getAmount());
        return new Response(200,"Income added successfully");
    }

    @Override
    public String updateIncome(UpdateIncomeRequest expenseRequest) {
        return null;
    }

    @Override
    public String deleteIncome(Long id) {
        incomeRepository.deleteById(id);
        return "Income deleted successfully";
    }

    @Override
    public Income getIncome(Long id) throws IncomeNotFoundException {
        return incomeRepository.findById(id).orElseThrow(IncomeNotFoundException::new);
    }

    @Override
    public Page<Income> getIncomes(GetALlIncomeRequest expenseRequest) {

        return incomeRepository.findAll
                (Pageable.ofSize(expenseRequest.noOfPageItems()).withPage(expenseRequest.pageNum() -1));
    }

    @Override
    public List<Income> getAllIncome() {
        return incomeRepository.findAll();
    }
}

