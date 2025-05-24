package com.buddhaditya.labtestmanager.services.impl;

import com.buddhaditya.labtestmanager.entities.LabTestStatus;
import com.buddhaditya.labtestmanager.repositories.LabTestStatusRepository;
import com.buddhaditya.labtestmanager.services.interfaces.LabTestStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LabTestStatusServiceImpl implements LabTestStatusService {

    private final LabTestStatusRepository repository;

    @Override
    public List<LabTestStatus> getAllStatuses() {
        return repository.findAll();
    }
}
