package com.project.mediquest.entities;

import com.project.mediquest.enums.ClaimType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceClaim {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String patientId;

        private String hospitalName;

        private ClaimType claimType;

        private BigDecimal amount;

        @Column(columnDefinition = "TEXT")
        private String treatmentDescription;

        private String documentUrl;

        private String status;

        @CreationTimestamp
        @Column(nullable = false)
        private LocalDate submissionDate;

        @ManyToOne
        @JoinColumn(name = "patient")
        private Patient patient;
    }


