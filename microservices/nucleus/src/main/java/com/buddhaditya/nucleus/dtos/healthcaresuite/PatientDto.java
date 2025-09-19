package com.buddhaditya.nucleus.dtos.healthcaresuite;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientDto {
    private Long patientId;
    private String name;
    private String email;
    private String phone;
    private String gender;
    private int age;
}
