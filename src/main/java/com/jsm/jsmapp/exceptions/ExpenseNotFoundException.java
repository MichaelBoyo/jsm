package com.jsm.jsmapp.exceptions;

public class ExpenseNotFoundException extends Exception {
    public ExpenseNotFoundException() {
        super("Expense not found");
    }
}
