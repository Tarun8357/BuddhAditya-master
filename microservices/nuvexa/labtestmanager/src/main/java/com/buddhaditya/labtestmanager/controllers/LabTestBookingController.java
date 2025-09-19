package com.buddhaditya.labtestmanager.controllers;

import com.buddhaditya.labtestmanager.dto.LabTestBookingRequest;
import com.buddhaditya.labtestmanager.dto.LabTestBookingResponse;
import com.buddhaditya.labtestmanager.services.interfaces.LabTestBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/labtest-bookings")
@RequiredArgsConstructor
public class LabTestBookingController {

    private final LabTestBookingService bookingService;

    @PostMapping
    public ResponseEntity<LabTestBookingResponse> bookLabTest(@RequestBody LabTestBookingRequest request) {
        LabTestBookingResponse response = bookingService.bookLabTest(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LabTestBookingResponse> getLabTestBooking(@PathVariable Long id) {
        LabTestBookingResponse response = bookingService.getLabTestBookingById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<LabTestBookingResponse>> getLabTestBookingsByPatient(@PathVariable Long patientId) {
        List<LabTestBookingResponse> responses = bookingService.getLabTestBookingsByPatient(patientId);
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/test-type/{labTestTypeId}")
    public ResponseEntity<List<LabTestBookingResponse>> getLabTestBookingsByLabTestType(@PathVariable Long labTestTypeId) {
        List<LabTestBookingResponse> responses = bookingService.getLabTestBookingsByLabTestType(labTestTypeId);
        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LabTestBookingResponse> updateLabTestBooking(@PathVariable Long id,
                                                                       @RequestBody LabTestBookingRequest request) {
        LabTestBookingResponse response = bookingService.updateLabTestBooking(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelLabTestBooking(@PathVariable Long id) {
        bookingService.cancelLabTestBooking(id);
        return ResponseEntity.noContent().build();
    }
}
