package com.jsm.jsmapp.data.dtos;

import com.jsm.jsmapp.data.models.AppUser;
import com.jsm.jsmapp.data.models.Role;
import lombok.Data;

import java.util.Set;
@Data
public class UserResponse {
    private Long id;
    private String firstname;
    private String lastname;
    private String username;
    private String email;



    public UserResponse(AppUser appUser) {
        this.id = appUser.getId();
        this.firstname = appUser.getFirstname();
        this.lastname = appUser.getLastname();
        this.username = appUser.getUsername();
        this.email = appUser.getEmail();
    }
}
