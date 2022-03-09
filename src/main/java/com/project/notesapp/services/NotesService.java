package com.project.notesapp.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.notesapp.models.Notes;
import com.project.notesapp.models.User;
import com.project.notesapp.repositories.NotesRepo;

@Service
public class NotesService {

    @Autowired
    private NotesRepo notesRepo;


    public List<Notes> getAllNotesByUser(Long userId) {
        return notesRepo.findByUserId(userId);
    }

    public Notes addNote(Notes notes) {
        return notesRepo.save(notes);
    }

    public ResponseEntity<Notes> updateNote(@PathVariable Long id, @RequestBody Notes updatedNote) {
        Notes oldNote = notesRepo.findById(id).orElseThrow();
        oldNote.setMessage(updatedNote.getMessage());
        notesRepo.save(oldNote);
        return ResponseEntity.ok(oldNote);
    }

    public ResponseEntity<Map<String, Boolean>> deleteNote(Long id) {
        Notes notes = notesRepo.findById(id).orElseThrow();
        notesRepo.delete(notes);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);

   
    
}
}
