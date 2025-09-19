package com.buddhaditya.casemanager.repositories;

import com.buddhaditya.casemanager.entities.CaseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseCategoryRepository extends JpaRepository<CaseCategory, Long> {
}

