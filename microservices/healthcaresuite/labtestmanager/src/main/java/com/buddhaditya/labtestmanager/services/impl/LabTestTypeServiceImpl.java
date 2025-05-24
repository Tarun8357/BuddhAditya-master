package com.buddhaditya.labtestmanager.services.impl;

import com.buddhaditya.labtestmanager.dto.LabTestTypeRequest;
import com.buddhaditya.labtestmanager.dto.LabTestTypeResponse;
import com.buddhaditya.labtestmanager.entities.LabTestType;
import com.buddhaditya.labtestmanager.exceptions.ResourceNotFoundException;
import com.buddhaditya.labtestmanager.mappers.LabTestTypeMapper;
import com.buddhaditya.labtestmanager.repositories.LabTestTypeRepository;
import com.buddhaditya.labtestmanager.services.interfaces.LabTestTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LabTestTypeServiceImpl implements LabTestTypeService {

    private final LabTestTypeRepository repository;

    @Override
    public LabTestTypeResponse createLabTestType(LabTestTypeRequest request) {
        LabTestType type = LabTestTypeMapper.toEntity(request);
        return LabTestTypeMapper.toResponse(repository.save(type));
    }

    @Override
    public LabTestTypeResponse getLabTestTypeById(Long id) {
        LabTestType type = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lab test type not found"));
        return LabTestTypeMapper.toResponse(type);
    }

    @Override
    public List<LabTestTypeResponse> getAllLabTestTypes() {
        return repository.findAll()
                .stream()
                .map(LabTestTypeMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public LabTestTypeResponse updateLabTestType(Long id, LabTestTypeRequest request) {
        LabTestType type = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lab test type not found"));
        type.setName(request.getName());
        type.setDescription(request.getDescription());
        type.setSampleType(request.getSampleType());
        type.setPrice(request.getPrice());
        type.setPreparationInstructions(request.getPreparationInstructions());
        type.setDepartment(request.getDepartment());
        type.setActive(request.getActive());
        return LabTestTypeMapper.toResponse(repository.save(type));
    }

    @Override
    public void deleteLabTestType(Long id) {
        LabTestType type = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lab test type not found"));
        repository.delete(type);
    }
}
