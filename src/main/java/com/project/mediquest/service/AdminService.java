package com.project.mediquest.service;

import com.project.mediquest.entities.Admin;
import com.project.mediquest.repository.AdminRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;

    public Admin registerAdmin(Admin admin) {
        System.out.println(admin.getName());
        System.out.println(admin.getPhone());
        return adminRepository.save(admin);
    }

    public Admin loginAdmin(Admin admin) {
        Admin existing = adminRepository.findByAdminId(admin.getAdminId())
                .orElseThrow(() -> new EntityNotFoundException("Admin not found with id: "+admin.getAdminId()));
        if(existing.getPassword().equals(admin.getPassword()) && existing.getAdminId().equals(admin.getAdminId())) {
            return existing;
        }
        throw new IllegalArgumentException("User id or password must be wrong");
    }
}
