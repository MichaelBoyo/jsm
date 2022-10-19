package com.jsm.jsmapp.services;

import com.jsm.jsmapp.data.models.Note;
import com.jsm.jsmapp.data.repositories.NoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
public record NoteService(NoteRepository noteRepository) {
    public Note save(Note note) {
        log.info("note -->  {}" ,note );
        note.setDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm")));
        return noteRepository.save(note);
    }

    public Page<Note> getAllNotes(int page, int size) {
        return noteRepository.findAll(Pageable.ofSize(size).withPage(page-1));
    }
}
