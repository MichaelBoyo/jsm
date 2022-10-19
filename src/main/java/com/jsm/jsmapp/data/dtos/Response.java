package com.jsm.jsmapp.data.dtos;


public record Response(int code, String message, Long userID) {
    public Response(int code, String message){
        this(code, message,0L);
    }
}
