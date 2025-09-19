package com.buddhaditya.labtestmanager.repositories;

import com.buddhaditya.labtestmanager.entities.LabTestResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LabTestResultRepository extends JpaRepository<LabTestResult, Long> {
    Optional<LabTestResult> findByBookingId(Long bookingId);
}
