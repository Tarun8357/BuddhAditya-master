package com.buddhaditya.labtestmanager.mappers;


import com.buddhaditya.labtestmanager.dto.LabTestResultRequest;
import com.buddhaditya.labtestmanager.dto.LabTestResultResponse;
import com.buddhaditya.labtestmanager.entities.LabTestResult;

public class LabTestResultMapper {

    public static LabTestResult toEntity(LabTestResultRequest labTestResultRequest) {
        LabTestResult entity = new LabTestResult();
        entity.setBookingId(labTestResultRequest.getBookingId());
        entity.setResultUrl(labTestResultRequest.getResultUrl());
        entity.setResultSummary(labTestResultRequest.getResultSummary());
        entity.setComments(labTestResultRequest.getComments());
        entity.setResultDate(labTestResultRequest.getResultDate());
        entity.setUploadedBy(labTestResultRequest.getUploadedBy());
        return entity;
    }

    public static LabTestResultResponse toResponse(LabTestResult entity) {
        return new LabTestResultResponse(
                entity.getId(),
                entity.getBookingId(),
                entity.getResultUrl(),
                entity.getResultSummary(),
                entity.getComments(),
                entity.getResultDate(),
                entity.getUploadedBy(),
                entity.getCreatedAt()
        );
    }
}
