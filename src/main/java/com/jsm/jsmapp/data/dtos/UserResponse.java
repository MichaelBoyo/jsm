package com.jsm.jsmapp.data.dtos;

import com.jsm.jsmapp.data.models.Role;
import com.jsm.jsmapp.data.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;
@Data
public class UserResponse {
    private String id;
    private String firstname;
    private String lastname;
    private String username;
    private String email;

    private Set<Role> roles;

    public UserResponse(User user) {
        this.id = user.getId();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.roles = user.getRoles();
    }
}
