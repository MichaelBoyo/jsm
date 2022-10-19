package com.jsm.jsmapp.controller;

import com.jsm.jsmapp.data.dtos.Response;
import com.jsm.jsmapp.data.models.Note;
import com.jsm.jsmapp.services.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/note")
public record NoteController(NoteService noteService) {
    @PostMapping
    public ResponseEntity<?> addNote(@RequestBody Note note) {
        return ResponseEntity.ok(noteService.save(note));
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllNotes(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(noteService.getAllNotes(page, size));
    }
}
