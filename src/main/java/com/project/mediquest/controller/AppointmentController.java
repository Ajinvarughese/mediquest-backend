package com.project.mediquest.controller;
import com.project.mediquest.entities.Appointment;
import com.project.mediquest.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "*")
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

    @GetMapping("/doctor")
    public List<Appointment> getByDoctor(@RequestParam String doctorName) {
        return service.getByDoctor(doctorName);
    }

    @PutMapping("/{id}/status")
    public Appointment updateStatus(@PathVariable Long id, @RequestParam String status) {
        return service.updateStatus(id, status);
    }
}
