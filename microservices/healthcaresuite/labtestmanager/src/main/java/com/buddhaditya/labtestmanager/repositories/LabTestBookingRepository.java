package com.buddhaditya.labtestmanager.repositories;

import com.buddhaditya.labtestmanager.entities.LabTestBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LabTestBookingRepository extends JpaRepository<LabTestBooking, Long> {
    List<LabTestBooking> findByPatientId(Long patientId);
    List<LabTestBooking> findByTestTypeId(Long testTypeId);
}
