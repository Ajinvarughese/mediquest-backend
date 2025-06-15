package com.project.mediquest.controller;

import com.project.mediquest.entities.Admin;
import com.project.mediquest.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin")
@AllArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping
    public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin) {
        return ResponseEntity.ok(adminService.registerAdmin(admin));
    }

    @PostMapping("/login")
    public ResponseEntity<Admin> loginAdmin(@RequestBody Admin admin) {
        return ResponseEntity.ok(adminService.loginAdmin(admin));
    }
}
