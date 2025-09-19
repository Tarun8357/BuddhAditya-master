package com.buddhaditya.casemanager.repositories;


import com.buddhaditya.casemanager.entities.Case;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CaseRepository extends JpaRepository<Case, Long> {
    List<Case> findByStatus(String status);
    List<Case> findByCategoryId(Long categoryId);
}
