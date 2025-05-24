package com.buddhaditya.casemanager.mapper;

import com.buddhaditya.casemanager.dto.CaseHistoryRequest;
import com.buddhaditya.casemanager.dto.CaseHistoryResponse;
import com.buddhaditya.casemanager.entities.Case;
import com.buddhaditya.casemanager.entities.CaseHistory;

import java.time.LocalDateTime;

public class CaseHistoryMapper {

    public static CaseHistory toEntity(CaseHistoryRequest request, Case aCase) {
        return CaseHistory.builder()
                .action(request.getAction())
                .description(request.getDescription())
                .performedBy(request.getPerformedBy())
                .actionDate(LocalDateTime.now())
                .aCase(aCase)
                .build();
    }

    public static CaseHistoryResponse toResponse(CaseHistory entity) {
        return new CaseHistoryResponse(
                entity.getId(),
                entity.getAction(),
                entity.getDescription(),
                entity.getActionDate(),
                entity.getPerformedBy(),
                entity.getACase() != null ? entity.getACase().getId() : null
        );
    }
}
