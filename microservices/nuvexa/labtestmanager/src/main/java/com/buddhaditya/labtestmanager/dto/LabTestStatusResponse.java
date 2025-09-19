package com.buddhaditya.labtestmanager.dto;

import com.buddhaditya.labtestmanager.entities.enums.TestStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LabTestStatusResponse {
    private Long id;
    private Long bookingId;
    private TestStatus status;
    private String updatedBy;
    private String comments;
    private LocalDateTime updatedAt;
}
