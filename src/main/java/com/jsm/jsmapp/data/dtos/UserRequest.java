package com.jsm.jsmapp.data.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest{
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;
}
