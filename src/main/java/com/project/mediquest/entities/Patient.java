package com.project.mediquest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Patient extends User {
        private String dob;

        @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
        @JsonIgnore
        private List<Appointment> appointments;

        @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
        @JsonIgnore
        private List<InsuranceClaim> insuranceClaims;
}

