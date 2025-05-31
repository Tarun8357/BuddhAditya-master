package com.buddhaditya.casemanager.services.interfaces;

import com.buddhaditya.casemanager.dto.CaseHistoryRequest;
import com.buddhaditya.casemanager.dto.CaseHistoryResponse;

import java.util.List;

public interface CaseHistoryService {
    CaseHistoryResponse addHistory(CaseHistoryRequest request);
    List<CaseHistoryResponse> getHistoryByCaseId(Long caseId);
}
