package com.buddhaditya.labtestmanager.repositories;

import com.buddhaditya.labtestmanager.entities.LabTestStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LabTestStatusRepository extends JpaRepository<LabTestStatus, Long> {
    Optional<LabTestStatus> findByBookingId(Long bookingId);
}
