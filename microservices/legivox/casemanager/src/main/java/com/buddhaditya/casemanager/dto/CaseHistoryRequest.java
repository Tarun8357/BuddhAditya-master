package com.buddhaditya.casemanager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CaseHistoryRequest {
    private String action;
    private String description;
    private String performedBy;
    private Long caseId;
}
