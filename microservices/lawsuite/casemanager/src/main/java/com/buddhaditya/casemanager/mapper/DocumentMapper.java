package com.buddhaditya.casemanager.mapper;


import com.buddhaditya.casemanager.dto.DocumentRequest;
import com.buddhaditya.casemanager.dto.DocumentResponse;
import com.buddhaditya.casemanager.entities.Document;

public class DocumentMapper {

    public static Document toEntity(DocumentRequest request) {
        Document entity = new Document();
        entity.setId(request.getCaseId());
        entity.setFileName(request.getFileName());
        entity.setFileType(request.getFileType());
        entity.setFileUrl(request.getFileUrl());
        entity.setUploadedBy(request.getUploadedBy());
        return entity;
    }


    public static DocumentResponse toResponse(Document entity) {
        return new DocumentResponse(
                entity.getId(),
                entity.getFileName(),
                entity.getFileType(),
                entity.getFileUrl(),
                entity.getUploadedBy(),
                entity.getUploadedAt()
        );
    }
}
