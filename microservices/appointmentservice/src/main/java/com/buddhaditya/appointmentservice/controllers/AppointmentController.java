package com.buddhaditya.appointmentservice.controllers;

import com.buddhaditya.appointmentservice.dto.AppointmentRequest;
import com.buddhaditya.appointmentservice.dto.AppointmentResponse;
import com.buddhaditya.appointmentservice.services.interfaces.AppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/healthsuite/appointment")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    // Book an appointment
    @PostMapping
    public ResponseEntity<AppointmentResponse> bookAppointment(
            @Valid @RequestBody AppointmentRequest request) {
        AppointmentResponse response = appointmentService.bookAppointment(request);
        return ResponseEntity.ok(response);
    }

    // Get appointment by ID
    @GetMapping("/{id}")
    public ResponseEntity<AppointmentResponse> getAppointmentById(
            @PathVariable Long id) {
        AppointmentResponse response = appointmentService.getAppointment(id);
        return ResponseEntity.ok(response);
    }

    // Get all appointments for a patient
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<AppointmentResponse>> getAppointmentsByPatient(
            @PathVariable Long patientId) {
        List<AppointmentResponse> responses = appointmentService.getAppointmentsByPatient(patientId);
        return ResponseEntity.ok(responses);
    }

    // Get all appointments for a doctor
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<AppointmentResponse>> getAppointmentsByDoctor(
            @PathVariable Long doctorId) {
        List<AppointmentResponse> responses = appointmentService.getAppointmentsByDoctor(doctorId);
        return ResponseEntity.ok(responses);
    }

    // Update appointment
    @PutMapping("/{id}")
    public ResponseEntity<AppointmentResponse> updateAppointment(
            @PathVariable Long id,
            @Valid @RequestBody AppointmentRequest request) {
        AppointmentResponse response = appointmentService.updateAppointment(id, request);
        return ResponseEntity.ok(response);
    }

    // Cancel appointment
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelAppointment(@PathVariable Long id) {
        appointmentService.cancelAppointment(id);
        return ResponseEntity.noContent().build();
    }
}
