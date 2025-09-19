package com.buddhaditya.nucleus.dtos.healthcaresuite;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LabTestRequestDto {
    private Long patientId;
    private String testType;      // e.g. BLOOD, XRAY, MRI
    private String description;
}
