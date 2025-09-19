package com.buddhaditya.casemanager.mapper;

import com.buddhaditya.casemanager.dto.CaseRequest;
import com.buddhaditya.casemanager.dto.CaseResponse;
import com.buddhaditya.casemanager.entities.Case;
import com.buddhaditya.casemanager.entities.CaseCategory;

public class CaseMapper {

    public static Case toEntity(CaseRequest request, CaseCategory category) {
        Case entity = new Case();
        entity.setTitle(request.getTitle());
        entity.setDescription(request.getDescription());
        entity.setStatus(request.getStatus());
        entity.setCreatedBy(request.getCreatedBy());
        entity.setCategory(category);
        return entity;
    }

    public static CaseResponse toResponse(Case entity) {
        return new CaseResponse(
                entity.getId(),
                entity.getCaseNumber(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getStatus(),
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                entity.getCreatedBy(),
                entity.getCategory() != null ? entity.getCategory().getId() : null
        );
    }
}
