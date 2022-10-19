package com.jsm.jsmapp.data.repositories;

import com.jsm.jsmapp.data.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NoteRepository extends JpaRepository<Note, Long> {
}
