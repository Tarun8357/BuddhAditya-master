package com.buddhaditya.casemanager.services.impl;

import com.buddhaditya.casemanager.dto.CaseRequest;
import com.buddhaditya.casemanager.dto.CaseResponse;
import com.buddhaditya.casemanager.entities.Case;
import com.buddhaditya.casemanager.entities.CaseCategory;
import com.buddhaditya.casemanager.exceptions.ResourceNotFoundException;
import com.buddhaditya.casemanager.mapper.CaseMapper;
import com.buddhaditya.casemanager.repositories.CaseCategoryRepository;
import com.buddhaditya.casemanager.repositories.CaseRepository;
import com.buddhaditya.casemanager.services.interfaces.CaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CaseServiceImpl implements CaseService {

    private final CaseRepository caseRepository;
    private final CaseCategoryRepository categoryRepository;

    @Override
    public CaseResponse createCase(CaseRequest request) {
        CaseCategory category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with ID: " + request.getCategoryId()));

        Case aCase = CaseMapper.toEntity(request, category);
        aCase.setCreatedAt(LocalDateTime.now());
        aCase.setUpdatedAt(LocalDateTime.now());

        return CaseMapper.toResponse(caseRepository.save(aCase));
    }

    @Override
    public CaseResponse getCaseById(Long id) {
        Case aCase = caseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Case not found with ID: " + id));
        return CaseMapper.toResponse(aCase);
    }

    @Override
    public List<CaseResponse> getCasesByStatus(String status) {
        List<Case> cases = caseRepository.findByStatus(status);
        return cases.stream()
                .map(CaseMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<CaseResponse> getCasesByCategory(Long categoryId) {
        List<Case> cases = caseRepository.findByCategoryId(categoryId);
        return cases.stream()
                .map(CaseMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CaseResponse updateCase(Long id, CaseRequest request) {
        Case aCase = caseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Case not found with ID: " + id));

        CaseCategory category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with ID: " + request.getCategoryId()));

        aCase.setTitle(request.getTitle());
        aCase.setDescription(request.getDescription());
        aCase.setStatus(request.getStatus());
        aCase.setCategory(category);
        aCase.setUpdatedAt(LocalDateTime.now());
        aCase.setCreatedBy(request.getCreatedBy());

        return CaseMapper.toResponse(caseRepository.save(aCase));
    }

    @Override
    public void deleteCase(Long id) {
        Case aCase = caseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Case not found with ID: " + id));
        caseRepository.delete(aCase);
    }
}
