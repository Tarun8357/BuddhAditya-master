package com.buddhaditya.labtestmanager.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LabTestResultRequest {
    private Long bookingId;
    private String resultUrl;
    private String resultSummary;
    private String comments;
    private LocalDateTime resultDate;
    private String uploadedBy;
}
