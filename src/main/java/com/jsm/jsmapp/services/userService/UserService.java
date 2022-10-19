package com.jsm.jsmapp.services.userService;

import com.jsm.jsmapp.data.dtos.UserRequest;
import com.jsm.jsmapp.data.dtos.Response;
import com.jsm.jsmapp.data.dtos.UserResponse;
import com.jsm.jsmapp.exceptions.UserNotFoundException;

public interface UserService {
    Response registerUser(UserRequest userRequest);

    UserResponse getUser(Long id) throws UserNotFoundException;

    Response getCompanyBalance();
}
