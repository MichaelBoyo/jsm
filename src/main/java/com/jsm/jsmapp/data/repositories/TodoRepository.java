package com.jsm.jsmapp.data.repositories;

import com.jsm.jsmapp.data.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
