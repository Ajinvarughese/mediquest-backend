package com.project.mediquest.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

        private String documentUrl;
        private String status;
        private LocalDate submissionDate;

        @ManyToOne
        @JoinColumn(name = "patient_id")
        private Patient patient;
    }


