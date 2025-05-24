package com.buddhaditya.casemanager.mapper;

import com.buddhaditya.casemanager.dto.CaseParticipantRequest;
import com.buddhaditya.casemanager.dto.CaseParticipantResponse;
import com.buddhaditya.casemanager.entities.CaseParticipant;
import com.buddhaditya.casemanager.entities.Case;

public class CaseParticipantMapper {

    public static CaseParticipant toEntity(CaseParticipantRequest request) {
        CaseParticipant entity = new CaseParticipant();
        entity.setParticipantId(request.getParticipantId());
        entity.setRole(request.getRole());
        entity.setName(request.getName());
        entity.setEmail(request.getEmail());

        // Create a Case instance with only the id (for the foreign key reference)
        Case caseEntity = new Case();
        caseEntity.setId(request.getCaseId());
        entity.setACase(caseEntity);

        return entity;
    }

    public static CaseParticipantResponse toResponse(CaseParticipant entity) {
        return new CaseParticipantResponse(
                entity.getId(),
                entity.getACase().getId(),
                entity.getParticipantId(),
                entity.getRole(),
                entity.getName(),
                entity.getEmail()
        );
    }
}
