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

public class Patient {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        private String email;
        private String password;
        private String phone;

        @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
        private List<Appointment> appointments;

        @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
        private List<InsuranceClaim> insuranceClaims;

}

