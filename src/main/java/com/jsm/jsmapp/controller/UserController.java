package com.jsm.jsmapp.controller;

import com.jsm.jsmapp.exceptions.UserNotFoundException;
import com.jsm.jsmapp.services.userService.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/users")
@AllArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;
    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable String id) throws UserNotFoundException {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @GetMapping("/companyBalance")
    public ResponseEntity<?> getCompanyBalance() {
        return ResponseEntity.ok(userService.getCompanyBalance());
    }

}
