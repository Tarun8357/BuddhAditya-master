package com.buddhaditya.labtestmanager.dto;

import com.buddhaditya.labtestmanager.entities.enums.TestStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LabTestStatusRequest {
    private Long bookingId;
    private TestStatus status;
    private String updatedBy;
    private String comments;
}
