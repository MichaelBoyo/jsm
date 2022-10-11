package com.jsm.jsmapp.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document
@Data
public class User {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;
    private Set<Role> roles;
}
