package com.project.mediquest.repository;



import com.project.mediquest.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDoctorId(Long id);
    List<Appointment> findByStatus(String status);
}