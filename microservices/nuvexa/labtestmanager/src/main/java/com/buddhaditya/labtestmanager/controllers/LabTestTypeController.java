package com.buddhaditya.labtestmanager.controllers;

import com.buddhaditya.labtestmanager.dto.LabTestTypeRequest;
import com.buddhaditya.labtestmanager.dto.LabTestTypeResponse;
import com.buddhaditya.labtestmanager.services.interfaces.LabTestTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/labtest-types")
@RequiredArgsConstructor
public class LabTestTypeController {

    private final LabTestTypeService labTestTypeService;

    @PostMapping
    public ResponseEntity<LabTestTypeResponse> createLabTestType(@RequestBody LabTestTypeRequest request) {
        LabTestTypeResponse response = labTestTypeService.createLabTestType(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LabTestTypeResponse> getLabTestTypeById(@PathVariable Long id) {
        LabTestTypeResponse response = labTestTypeService.getLabTestTypeById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<LabTestTypeResponse>> getAllLabTestTypes() {
        List<LabTestTypeResponse> responses = labTestTypeService.getAllLabTestTypes();
        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LabTestTypeResponse> updateLabTestType(@PathVariable Long id,
                                                                 @RequestBody LabTestTypeRequest request) {
        LabTestTypeResponse response = labTestTypeService.updateLabTestType(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLabTestType(@PathVariable Long id) {
        labTestTypeService.deleteLabTestType(id);
        return ResponseEntity.noContent().build();
    }
}
