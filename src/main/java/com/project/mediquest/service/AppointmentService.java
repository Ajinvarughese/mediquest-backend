package com.project.mediquest.service;

import com.project.mediquest.entities.Appointment;
import com.project.mediquest.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    public Appointment book(Appointment appointment) {
        appointment.setStatus("BOOKED");
        return repository.save(appointment);
    }

    public List<Appointment> getAll() {
        return repository.findAll();
    }

    public List<Appointment> getByDoctor(String doctorName) {
        return repository.findByDoctorName(doctorName);
    }

    public Appointment updateStatus(Long id, String newStatus) {
        Appointment appointment = repository.findById(id).orElseThrow();
        appointment.setStatus(newStatus);
        return repository.save(appointment);
    }
}




