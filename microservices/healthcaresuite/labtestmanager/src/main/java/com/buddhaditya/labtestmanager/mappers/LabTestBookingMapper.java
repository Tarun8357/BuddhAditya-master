package com.buddhaditya.labtestmanager.mappers;


import com.buddhaditya.labtestmanager.dto.LabTestBookingRequest;
import com.buddhaditya.labtestmanager.dto.LabTestBookingResponse;
import com.buddhaditya.labtestmanager.entities.LabTestBooking;

public class LabTestBookingMapper {

    public static LabTestBooking toEntity(LabTestBookingRequest labTestBookingRequest) {
        LabTestBooking entity = new LabTestBooking();
        entity.setPatientId(labTestBookingRequest.getPatientId());
        entity.setTestTypeId(labTestBookingRequest.getTestTypeId());
        entity.setScheduledDate(labTestBookingRequest.getScheduledDate());
        entity.setLocation(labTestBookingRequest.getLocation());
        entity.setTechnicianName(labTestBookingRequest.getTechnicianName());
        entity.setNotes(labTestBookingRequest.getNotes());
        entity.setCreatedBy(labTestBookingRequest.getCreatedBy());
        return entity;
    }

    public static LabTestBookingResponse toResponse(LabTestBooking entity) {
        return new LabTestBookingResponse(
                entity.getId(),
                entity.getPatientId(),
                entity.getTestTypeId(),
                entity.getScheduledDate(),
                entity.getStatus(),
                entity.getLocation(),
                entity.getTechnicianName(),
                entity.getNotes(),
                entity.getCreatedBy(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
