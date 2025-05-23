package com.buddhaditya.labtestmanager.mappers;


import com.buddhaditya.labtestmanager.dto.LabTestStatusRequest;
import com.buddhaditya.labtestmanager.dto.LabTestStatusResponse;
import com.buddhaditya.labtestmanager.entities.LabTestStatus;

public class LabTestStatusMapper {

    public static LabTestStatus toEntity(LabTestStatusRequest dto) {
        LabTestStatus entity = new LabTestStatus();
        entity.setBookingId(dto.getBookingId());
        entity.setStatus(dto.getStatus());
        entity.setUpdatedBy(dto.getUpdatedBy());
        entity.setComments(dto.getComments());
        return entity;
    }

    public static LabTestStatusResponse toResponse(LabTestStatus entity) {
        return new LabTestStatusResponse(
                entity.getId(),
                entity.getBookingId(),
                entity.getStatus(),
                entity.getUpdatedBy(),
                entity.getComments(),
                entity.getUpdatedAt()
        );
    }
}
