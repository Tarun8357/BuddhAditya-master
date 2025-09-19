package com.buddhaditya.labtestmanager.controllers;

import com.buddhaditya.labtestmanager.dto.LabTestResultRequest;
import com.buddhaditya.labtestmanager.dto.LabTestResultResponse;
import com.buddhaditya.labtestmanager.services.interfaces.LabTestResultService;
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


@RestController
@RequestMapping("/api/labtest-results")
@RequiredArgsConstructor
public class LabTestResultController {

    private final LabTestResultService resultService;

    @PostMapping
    public ResponseEntity<LabTestResultResponse> addLabTestResult(@RequestBody LabTestResultRequest request) {
        LabTestResultResponse response = resultService.addLabTestResult(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LabTestResultResponse> getLabTestResultById(@PathVariable Long id) {
        LabTestResultResponse response = resultService.getLabTestResultById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LabTestResultResponse> updateLabTestResult(@PathVariable Long id,
                                                                     @RequestBody LabTestResultRequest request) {
        LabTestResultResponse response = resultService.updateLabTestResult(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLabTestResult(@PathVariable Long id) {
        resultService.deleteLabTestResult(id);
        return ResponseEntity.noContent().build();
    }
}
