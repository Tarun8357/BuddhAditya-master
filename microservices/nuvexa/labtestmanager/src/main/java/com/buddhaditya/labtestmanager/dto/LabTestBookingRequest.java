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
public class LabTestBookingRequest {
    private Long patientId;
    private Long testTypeId;
    private LocalDateTime scheduledDate;
    private String location;
    private String technicianName;
    private String notes;
    private String createdBy;
}
