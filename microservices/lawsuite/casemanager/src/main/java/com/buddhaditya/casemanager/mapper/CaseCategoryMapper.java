package com.buddhaditya.casemanager.mapper;

import com.buddhaditya.casemanager.dto.CaseCategoryRequest;
import com.buddhaditya.casemanager.dto.CaseCategoryResponse;
import com.buddhaditya.casemanager.entities.CaseCategory;

public class CaseCategoryMapper {

    public static CaseCategory toEntity(CaseCategoryRequest request) {
        CaseCategory entity = new CaseCategory();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        return entity;
    }

    public static CaseCategoryResponse toResponse(CaseCategory entity) {
        return new CaseCategoryResponse(
                entity.getId(),
                entity.getName(),
                entity.getDescription()
        );
    }
}

