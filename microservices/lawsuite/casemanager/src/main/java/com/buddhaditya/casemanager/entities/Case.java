package com.buddhaditya.casemanager.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;
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
@Entity
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String caseNumber;
    private String title;
    private String description;
    private String status; // e.g. OPEN, CLOSED, IN_PROGRESS
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;

    @ManyToOne
    private CaseCategory category;

    @OneToMany(mappedBy = "case", cascade = CascadeType.ALL)
    private List<Document> documents;

    @OneToMany(mappedBy = "case", cascade = CascadeType.ALL)
    private List<CaseHistory> histories;

    @OneToMany(mappedBy = "case", cascade = CascadeType.ALL)
    private List<Note> notes;
}

