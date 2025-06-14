package com.project.mediquest.controller;
import com.project.mediquest.dto.Availability;
import com.project.mediquest.entities.Appointment;
import com.project.mediquest.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @PostMapping
    public Appointment bookAppointment(@RequestBody Appointment appointment) {
        return service.book(appointment);
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return service.getAll();
    }

    @PostMapping("/availability/{id}")
    public ResponseEntity<Boolean> isAvailable(@PathVariable Long id, @RequestBody Availability availability) {
        return ResponseEntity.ok(service.getAvailability(id, availability));
    }


    @GetMapping("/doctor/{id}")
    public List<Appointment> getByDoctor(@PathVariable Long id) {
        return service.getByDoctor(id);
    }

    @PutMapping("/{id}/status")
    public Appointment updateStatus(@PathVariable Long id, @RequestParam String status) {
        return service.updateStatus(id, status);
    }
}
