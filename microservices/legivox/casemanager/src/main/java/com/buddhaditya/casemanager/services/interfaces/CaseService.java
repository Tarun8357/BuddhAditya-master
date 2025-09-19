package com.buddhaditya.casemanager.services.interfaces;

import com.buddhaditya.casemanager.dto.CaseRequest;
import com.buddhaditya.casemanager.dto.CaseResponse;

import java.util.List;

public interface CaseService {
    CaseResponse createCase(CaseRequest request);
    CaseResponse getCaseById(Long id);
    List<CaseResponse> getCasesByStatus(String status);
    List<CaseResponse> getCasesByCategory(Long categoryId);
    CaseResponse updateCase(Long id, CaseRequest request);
    void deleteCase(Long id);
}
