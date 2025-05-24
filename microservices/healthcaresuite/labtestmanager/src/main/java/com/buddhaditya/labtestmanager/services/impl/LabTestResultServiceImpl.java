package com.buddhaditya.labtestmanager.services.impl;

import com.buddhaditya.labtestmanager.dto.LabTestResultRequest;
import com.buddhaditya.labtestmanager.dto.LabTestResultResponse;
import com.buddhaditya.labtestmanager.entities.LabTestResult;
import com.buddhaditya.labtestmanager.exceptions.ResourceNotFoundException;
import com.buddhaditya.labtestmanager.mappers.LabTestResultMapper;
import com.buddhaditya.labtestmanager.repositories.LabTestResultRepository;
import com.buddhaditya.labtestmanager.services.interfaces.LabTestResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LabTestResultServiceImpl implements LabTestResultService {

    private final LabTestResultRepository repository;

    @Override
    public LabTestResultResponse addLabTestResult(LabTestResultRequest request) {
        LabTestResult result = LabTestResultMapper.toEntity(request);
        return LabTestResultMapper.toResponse(repository.save(result));
    }

    @Override
    public LabTestResultResponse getLabTestResultById(Long id) {
        LabTestResult result = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lab test result not found"));
        return LabTestResultMapper.toResponse(result);
    }

    @Override
    public LabTestResultResponse updateLabTestResult(Long id, LabTestResultRequest request) {
        LabTestResult result = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lab test result not found"));
        result.setResultUrl(request.getResultUrl());
        result.setResultDate(request.getResultDate());
        result.setComments(request.getComments());
        result.setResultSummary(request.getResultSummary());
        result.setUploadedBy(request.getUploadedBy());
        return LabTestResultMapper.toResponse(repository.save(result));
    }

    @Override
    public void deleteLabTestResult(Long id) {
        LabTestResult result = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lab test result not found"));
        repository.delete(result);
    }
}
