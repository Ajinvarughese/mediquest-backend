package com.project.mediquest.controller;

import com.project.mediquest.entities.Doctor;
import com.project.mediquest.library.FileUpload;
import com.project.mediquest.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
    private final DoctorService doctorService;
    private final FileUpload fileUpload;

    @Autowired
    public DoctorController(DoctorService doctorService, FileUpload fileUpload) {
        this.doctorService = doctorService;
        this.fileUpload = fileUpload;
    }

    @PostMapping(path = "/file/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addImage(@ModelAttribute("picture") MultipartFile file) throws IOException {
        String pictureUrl = fileUpload.uploadFile(file);
        return ResponseEntity.ok(pictureUrl);
    }

    @PostMapping
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        return ResponseEntity.ok(doctorService.saveDoctor(doctor));
    }

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @PostMapping("/login")
    public ResponseEntity<Doctor> loginDoctor(@RequestBody Doctor doctor) {
        return ResponseEntity.ok(doctorService.loginDoctor(doctor));
    }

    @GetMapping("/{id}")
    public Doctor getDoctor(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
    }
}
