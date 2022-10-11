package com.jsm.jsmapp.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class JwtResponseModel {
    private String token;
    private int code;
    private String username;
}
