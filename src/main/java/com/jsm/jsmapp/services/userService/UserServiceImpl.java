package com.jsm.jsmapp.services.userService;

import com.jsm.jsmapp.data.dtos.UserRequest;
import com.jsm.jsmapp.data.dtos.Response;
import com.jsm.jsmapp.data.dtos.UserResponse;
import com.jsm.jsmapp.data.models.Expense;
import com.jsm.jsmapp.data.models.Income;
import com.jsm.jsmapp.data.models.Role;
import com.jsm.jsmapp.data.models.User;
import com.jsm.jsmapp.data.repositories.UserRepository;
import com.jsm.jsmapp.exceptions.UserNotFoundException;
import com.jsm.jsmapp.services.expenseService.ExpenseService;
import com.jsm.jsmapp.services.incomeService.IncomeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final ExpenseService  expenseService;
    private final IncomeService incomeService;

    @Override
    public Response registerUser(UserRequest userRequest) {
        userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        User user = modelMapper.map(userRequest, User.class);
        user.setRoles(Set.of(Role.USER, Role.ADMIN));
        user = userRepository.save(user);
        return new Response(200, "User registered successfully", user.getId());
    }

    @Override
    public UserResponse getUser(String id) throws UserNotFoundException {
        log.info("Getting user with id: {}", id);
        return userRepository.findById(id)
                .map(UserResponse::new)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public Response getCompanyBalance() {
        var income = incomeService.getAllIncome().stream().mapToDouble(Income::getAmount).sum();
        var expense = expenseService.getAllExpenses().stream().mapToDouble(Expense::getAmount).sum();
        return new Response(200,  String.valueOf(income - expense));
    }

}
