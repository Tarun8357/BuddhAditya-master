package com.buddhaditya.labtestmanager.controllers;

import com.buddhaditya.labtestmanager.entities.LabTestStatus;
import com.buddhaditya.labtestmanager.services.interfaces.LabTestStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/labtest-statuses")
@RequiredArgsConstructor
public class LabTestStatusController {

    private final LabTestStatusService statusService;

    @GetMapping
    public ResponseEntity<List<LabTestStatus>> getAllStatuses() {
        List<LabTestStatus> statuses = statusService.getAllStatuses();
        return ResponseEntity.ok(statuses);
    }
}
