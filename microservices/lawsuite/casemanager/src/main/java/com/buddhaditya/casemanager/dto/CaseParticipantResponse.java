package com.buddhaditya.casemanager.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CaseParticipantResponse {
    private Long id;
    private Long caseId;
    private Long participantId;
    private String role;
    private String name;
    private String email;
}
