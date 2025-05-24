package com.buddhaditya.casemanager.repository;

import com.buddhaditya.casemanager.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByCaseId(Long caseId);
}

