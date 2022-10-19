package com.jsm.jsmapp.exceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("AppUser not found");
    }
}
