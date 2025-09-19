package com.buddhaditya.casemanager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CaseHistoryResponse {
    private Long id;
    private String action;
    private String description;
    private LocalDateTime actionDate;
    private String performedBy;
    private Long caseId;
}
