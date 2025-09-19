package com.buddhaditya.casemanager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CaseRequest {
    private String title;
    private String description;
    private String status;
    private Long categoryId;
    private String createdBy;
}

