package com.buddhaditya.labtestmanager.entities;

import com.buddhaditya.labtestmanager.entities.enums.TestStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "lab_test_statuses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LabTestStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookingId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TestStatus status;

    private String updatedBy;

    private String comments;

    private LocalDateTime updatedAt;


}
