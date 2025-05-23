package com.buddhaditya.labtestmanager.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LabTestTypeRequest {
    private String name;
    private String description;
    private String sampleType;
    private Double price;
    private String preparationInstructions;
    private String department;
    private Boolean active;
}
