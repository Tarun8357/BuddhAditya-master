package com.buddhaditya.labtestmanager.dto;

import com.buddhaditya.labtestmanager.entities.enums.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LabTestBookingResponse {
    private Long id;
    private Long patientId;
    private Long testTypeId;
    private LocalDateTime scheduledDate;
    private BookingStatus status;
    private String location;
    private String technicianName;
    private String notes;
    private String createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
