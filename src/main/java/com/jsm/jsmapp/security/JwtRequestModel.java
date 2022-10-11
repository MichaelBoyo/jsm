package com.jsm.jsmapp.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class JwtRequestModel {

    private String username;
    private String password;

    public JwtRequestModel(String username, String password) {
        super();
        this.username = username; this.password = password;
    }
}
