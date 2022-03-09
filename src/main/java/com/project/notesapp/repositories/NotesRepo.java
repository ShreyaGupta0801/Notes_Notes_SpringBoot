package com.project.notesapp.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.notesapp.models.Notes;
import com.project.notesapp.models.User;

@Repository
public interface NotesRepo extends JpaRepository<Notes, Long>{
    List<Notes> findByUserId(Long userId);
}
