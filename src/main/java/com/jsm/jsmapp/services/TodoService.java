package com.jsm.jsmapp.services;

import com.jsm.jsmapp.data.models.Note;
import com.jsm.jsmapp.data.models.Todo;
import com.jsm.jsmapp.data.repositories.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
public record TodoService(TodoRepository todoRepository) {
    public Todo save(Todo todo){
        todo.setDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm")));
        log.info("todo ---> {}", todo);
        return todoRepository.save(todo);
    }
    public Page<Todo> getAllTodo(int page, int size) {
        return todoRepository.findAll(Pageable.ofSize(size).withPage(page-1));
    }

}
