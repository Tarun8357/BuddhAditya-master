package com.buddhaditya.labtestmanager.repositories;

import com.buddhaditya.labtestmanager.entities.LabTestType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LabTestTypeRepository extends JpaRepository<LabTestType, Long> {
    List<LabTestType> findByActiveTrue();
}
