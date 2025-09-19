package com.buddhaditya.casemanager.mapper;

import com.buddhaditya.casemanager.dto.NoteRequest;
import com.buddhaditya.casemanager.dto.NoteResponse;
import com.buddhaditya.casemanager.entities.Note;

public class NoteMapper {

    public static Note toEntity(NoteRequest request) {
        Note entity = new Note();
        entity.setContent(request.getContent());
        entity.setCreatedBy(request.getCreatedBy()); // Map to entity's author
        return entity;
    }


    public static NoteResponse toResponse(Note entity) {
        return new NoteResponse(
                entity.getId(),
                entity.getContent(),
                entity.getCreatedBy(),
                entity.getCreatedAt()
        );
    }
}
