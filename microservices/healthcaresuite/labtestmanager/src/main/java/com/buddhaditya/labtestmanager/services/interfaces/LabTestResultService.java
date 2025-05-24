package com.buddhaditya.labtestmanager.services.interfaces;


import com.buddhaditya.labtestmanager.dto.LabTestResultRequest;
import com.buddhaditya.labtestmanager.dto.LabTestResultResponse;

public interface LabTestResultService {
    LabTestResultResponse addLabTestResult(LabTestResultRequest request);
    LabTestResultResponse getLabTestResultById(Long id);
    LabTestResultResponse updateLabTestResult(Long id, LabTestResultRequest request);
    void deleteLabTestResult(Long id);
}
