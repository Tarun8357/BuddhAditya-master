package com.buddhaditya.casemanager.repositories;

import com.buddhaditya.casemanager.entities.CaseHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CaseHistoryRepository extends JpaRepository<CaseHistory, Long> {
    List<CaseHistory> findByCaseId(Long caseId);
}

