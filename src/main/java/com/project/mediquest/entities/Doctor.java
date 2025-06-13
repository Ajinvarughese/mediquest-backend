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
public class Doctor extends User {
        private Long doctorId;
        private String specialization;
        private Boolean availability;
        private String picture;
        private Integer experience;
        private String fromTime;
        private String toTime;
        @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
        @JsonIgnore
        private List<Appointment> appointments;
    }

