package com.project.mediquest.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String patientName;

        private LocalDate appointmentDate;

        private String doctorName;

        private String doctorCategory;

        private String status; // e.g. "BOOKED", "COMPLETED", "CANCELLED"
}