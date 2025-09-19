package com.buddhaditya.labtestmanager.services.impl;

import com.buddhaditya.labtestmanager.dto.LabTestBookingRequest;
import com.buddhaditya.labtestmanager.dto.LabTestBookingResponse;
import com.buddhaditya.labtestmanager.entities.LabTestBooking;
import com.buddhaditya.labtestmanager.entities.enums.BookingStatus;
import com.buddhaditya.labtestmanager.exceptions.ResourceNotFoundException;
import com.buddhaditya.labtestmanager.mappers.LabTestBookingMapper;
import com.buddhaditya.labtestmanager.repositories.LabTestBookingRepository;
import com.buddhaditya.labtestmanager.services.interfaces.LabTestBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LabTestBookingServiceImpl implements LabTestBookingService {

    private final LabTestBookingRepository repository;

    @Override
    public LabTestBookingResponse bookLabTest(LabTestBookingRequest request) {
        LabTestBooking booking = LabTestBookingMapper.toEntity(request);
        booking.setStatus(BookingStatus.BOOKED); // initial status
        return LabTestBookingMapper.toResponse(repository.save(booking));
    }

    @Override
    public LabTestBookingResponse getLabTestBookingById(Long id) {
        LabTestBooking booking = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lab test booking not found"));
        return LabTestBookingMapper.toResponse(booking);
    }

    @Override
    public List<LabTestBookingResponse> getLabTestBookingsByPatient(Long patientId) {
        return repository.findByPatientId(patientId)
                .stream()
                .map(LabTestBookingMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<LabTestBookingResponse> getLabTestBookingsByLabTestType(Long labTestTypeId) {
        return repository.findByTestTypeId(labTestTypeId)
                .stream()
                .map(LabTestBookingMapper::toResponse)
                .collect(Collectors.toList());
    }


    @Override
    public LabTestBookingResponse updateLabTestBooking(Long id, LabTestBookingRequest request) {
        LabTestBooking booking = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lab test booking not found"));
        booking.setPatientId(request.getPatientId());
        booking.setTestTypeId(request.getTestTypeId());
        booking.setScheduledDate(request.getScheduledDate());
        booking.setLocation(request.getLocation());
        booking.setTechnicianName(request.getTechnicianName());
        booking.setNotes(request.getNotes());
        booking.setCreatedBy(request.getCreatedBy());
        return LabTestBookingMapper.toResponse(repository.save(booking));
    }

    @Override
    public void cancelLabTestBooking(Long id) {
        LabTestBooking booking = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lab test booking not found"));
        booking.setStatus(BookingStatus.CANCELLED);
        repository.save(booking);
    }
}
