package com.jsm.jsmapp.controller;

import com.jsm.jsmapp.data.models.Todo;
import com.jsm.jsmapp.services.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/todo")
public record TodoController(TodoService todoService) {
    @PostMapping
    public ResponseEntity<?> addTodo(@RequestBody Todo todo) {
        return ResponseEntity.ok(todoService.save(todo));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllTodos(@RequestParam Integer page, @RequestParam Integer noOfItems) {
        return ResponseEntity.ok(todoService.getAllTodo(page, noOfItems));
    }
}
