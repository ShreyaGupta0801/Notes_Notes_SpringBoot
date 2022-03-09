package com.project.notesapp.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.project.notesapp.services.NotesService;
import com.project.notesapp.models.Notes;
import com.project.notesapp.models.User;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/note")
public class NotesController {
    
    @Autowired
    private NotesService notesService;

    @PostMapping("/get-all")
    public List<Notes> getAllNotesByUser(@RequestBody User user) {
        System.out.println(user.toString());
        return notesService.getAllNotesByUser(user.getId());
    }

    @PostMapping("/add")
    public Notes addNote(@RequestBody Notes notes) {
        return notesService.addNote(notes);
    
    }
    @PutMapping("/{id}")
    public ResponseEntity<Notes> updateNote(@PathVariable Long id, @RequestBody Notes updatedNote) {
        return notesService.updateNote(id, updatedNote);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteNote(@PathVariable Long id) {
        System.out.println(id);
        return notesService.deleteNote(id);
    }
}
