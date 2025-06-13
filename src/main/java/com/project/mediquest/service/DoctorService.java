package com.project.mediquest.service;

import com.project.mediquest.entities.Doctor;
import com.project.mediquest.repository.DoctorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor loginDoctor(Doctor doctor) {
        Doctor existing = doctorRepository.findByDoctorId(doctor.getDoctorId())
                .orElseThrow(() -> new EntityNotFoundException(("Doctor not found with id: "+doctor.getDoctorId())));
        if(existing.getDoctorId().equals(doctor.getDoctorId()) && existing.getPassword().equals(doctor.getPassword())) {
            return existing;
        }
        throw new IllegalArgumentException("User id or password must be wrong");
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
}
}