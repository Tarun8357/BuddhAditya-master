package com.buddhaditya.appointmentservice.services.impl;


import com.buddhaditya.appointmentservice.dto.AppointmentRequest;
import com.buddhaditya.appointmentservice.dto.AppointmentResponse;
import com.buddhaditya.appointmentservice.dto.enums.AppointmentStatus;
import com.buddhaditya.appointmentservice.entities.Appointment;
import com.buddhaditya.appointmentservice.exceptions.ResourceNotFoundException;
import com.buddhaditya.appointmentservice.repositories.AppointmentRepository;
import com.buddhaditya.appointmentservice.services.interfaces.AppointmentMapper;
import com.buddhaditya.appointmentservice.services.interfaces.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository repository;
    private final AppointmentMapper mapper;

    @Override
    public AppointmentResponse bookAppointment(AppointmentRequest request) {
        Appointment appointment = mapper.toEntity(request);
        return mapper.toResponse(repository.save(appointment));
    }

    @Override
    public AppointmentResponse getAppointment(Long id) {
        Appointment appointment = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found"));
        return mapper.toResponse(appointment);
    }

    @Override
    public List<AppointmentResponse> getAppointmentsByPatient(Long patientId) {
        return repository.findByPatientId(patientId)
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentResponse> getAppointmentsByDoctor(Long doctorId) {
        return repository.findByDoctorId(doctorId)
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AppointmentResponse updateAppointment(Long id, AppointmentRequest request) {
        Appointment appointment = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found"));
        mapper.updateEntity(appointment, request);
        return mapper.toResponse(repository.save(appointment));
    }

    @Override
    public void cancelAppointment(Long id) {
        Appointment appointment = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found"));
        appointment.setStatus(AppointmentStatus.CANCELLED);
        repository.save(appointment);
    }
}
