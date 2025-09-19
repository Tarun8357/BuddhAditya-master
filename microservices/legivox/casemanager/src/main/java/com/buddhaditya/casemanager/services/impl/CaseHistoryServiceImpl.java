package com.buddhaditya.casemanager.services.impl;

import com.buddhaditya.casemanager.dto.CaseHistoryRequest;
import com.buddhaditya.casemanager.dto.CaseHistoryResponse;
import com.buddhaditya.casemanager.entities.Case;
import com.buddhaditya.casemanager.entities.CaseHistory;
import com.buddhaditya.casemanager.exceptions.ResourceNotFoundException;
import com.buddhaditya.casemanager.mapper.CaseHistoryMapper;
import com.buddhaditya.casemanager.repositories.CaseHistoryRepository;
import com.buddhaditya.casemanager.repositories.CaseRepository;
import com.buddhaditya.casemanager.services.interfaces.CaseHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CaseHistoryServiceImpl implements CaseHistoryService {

    private final CaseHistoryRepository historyRepository;
    private final CaseRepository caseRepository;

    @Override
    public CaseHistoryResponse addHistory(CaseHistoryRequest request) {
        // Fetch the case entity
        Case aCase = caseRepository.findById(request.getCaseId())
                .orElseThrow(() -> new ResourceNotFoundException("Case not found with ID: " + request.getCaseId()));

        // Map to entity and save
        CaseHistory history = CaseHistoryMapper.toEntity(request, aCase);
        CaseHistory savedHistory = historyRepository.save(history);

        // Return response DTO
        return CaseHistoryMapper.toResponse(savedHistory);
    }

    @Override
    public List<CaseHistoryResponse> getHistoryByCaseId(Long caseId) {
        List<CaseHistory> histories = historyRepository.findByCaseId(caseId);
        return histories.stream()
                .map(CaseHistoryMapper::toResponse)
                .collect(Collectors.toList());
    }
}
