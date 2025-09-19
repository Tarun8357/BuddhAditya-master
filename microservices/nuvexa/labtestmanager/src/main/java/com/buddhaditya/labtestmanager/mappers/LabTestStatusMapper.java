package com.buddhaditya.labtestmanager.mappers;


import com.buddhaditya.labtestmanager.dto.LabTestStatusRequest;
import com.buddhaditya.labtestmanager.dto.LabTestStatusResponse;
import com.buddhaditya.labtestmanager.entities.LabTestStatus;

public class LabTestStatusMapper {

    public static LabTestStatus toEntity(LabTestStatusRequest labTestStatusRequest) {
        LabTestStatus entity = new LabTestStatus();
        entity.setBookingId(labTestStatusRequest.getBookingId());
        entity.setStatus(labTestStatusRequest.getStatus());
        entity.setUpdatedBy(labTestStatusRequest.getUpdatedBy());
        entity.setComments(labTestStatusRequest.getComments());
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
