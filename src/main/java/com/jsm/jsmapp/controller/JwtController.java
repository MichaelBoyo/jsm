package com.jsm.jsmapp.controller;

import com.jsm.jsmapp.data.dtos.UserRequest;
import com.jsm.jsmapp.security.JwtRequestModel;
import com.jsm.jsmapp.security.JwtResponseModel;
import com.jsm.jsmapp.security.JwtUserDetailsService;
import com.jsm.jsmapp.security.TokenManager;
import com.jsm.jsmapp.services.userService.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api/auth")
public class JwtController {
    private final JwtUserDetailsService userDetailsService;

    private final AuthenticationManager authenticationManager;

    private final TokenManager tokenManager;

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.registerUser(userRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<?> createToken(@RequestBody JwtRequestModel request) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        final String jwtToken = tokenManager.generateJwtToken(userDetails);
        return ResponseEntity.ok(new JwtResponseModel(jwtToken, 200, request.getUsername()));
    }

}
