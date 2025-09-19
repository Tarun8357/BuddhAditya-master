package com.buddhaditya.labtestmanager.services.interfaces;


import com.buddhaditya.labtestmanager.dto.LabTestBookingRequest;
import com.buddhaditya.labtestmanager.dto.LabTestBookingResponse;

import java.util.List;

public interface LabTestBookingService {
    LabTestBookingResponse bookLabTest(LabTestBookingRequest request);
    LabTestBookingResponse getLabTestBookingById(Long id);
    List<LabTestBookingResponse> getLabTestBookingsByPatient(Long patientId);
    List<LabTestBookingResponse> getLabTestBookingsByLabTestType(Long labTestTypeId);
    LabTestBookingResponse updateLabTestBooking(Long id, LabTestBookingRequest request);
    void cancelLabTestBooking(Long id);
}
