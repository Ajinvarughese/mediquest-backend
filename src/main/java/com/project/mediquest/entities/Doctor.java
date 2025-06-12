package com.project.mediquest.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Doctor {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        private String specialization;
        private String availability; // e.g. Mon-Fri, 10-2 PM

        @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
        private List<Appointment> appointments;
    }

