package com.jsm.jsmapp.data.dtos;

import com.jsm.jsmapp.data.models.Role;

import java.util.Set;

public record Response(int code, String message, String userID) {
    public Response(int code, String message){
        this(code, message,"");
    }
}
