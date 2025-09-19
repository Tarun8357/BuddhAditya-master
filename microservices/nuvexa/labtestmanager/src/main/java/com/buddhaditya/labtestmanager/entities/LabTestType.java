package com.buddhaditya.labtestmanager.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "lab_test_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LabTestType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; // e.g., "Blood Test", "MRI", etc.

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String sampleType; // e.g., "blood", "urine", etc.

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String preparationInstructions;

    private String department; // e.g., "Pathology", "Radiology"

    private Boolean active = true;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
