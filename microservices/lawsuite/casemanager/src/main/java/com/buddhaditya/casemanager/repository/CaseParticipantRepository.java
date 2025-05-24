package com.buddhaditya.casemanager.repository;

import com.buddhaditya.casemanager.entities.CaseParticipant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CaseParticipantRepository extends JpaRepository<CaseParticipant, Long> {
    List<CaseParticipant> findByCaseId(Long caseId);
}

