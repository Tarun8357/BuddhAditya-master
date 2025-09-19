package com.buddhaditya.labtestmanager.entities;


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
@Table(name = "lab_test_results")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LabTestResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookingId;

    private String resultUrl; // Could be a PDF or image link

    private String resultSummary;

    private String comments;

    private LocalDateTime resultDate;

    private String uploadedBy;

    private LocalDateTime createdAt;
}
