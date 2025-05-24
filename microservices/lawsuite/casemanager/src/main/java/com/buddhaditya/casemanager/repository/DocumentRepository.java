package com.buddhaditya.casemanager.repository;

import com.buddhaditya.casemanager.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    List<Document> findByCaseId(Long caseId);
}

