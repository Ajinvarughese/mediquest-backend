package com.project.mediquest.repository;

import com.project.mediquest.entities.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    List<Medicine> findByNameContainingIgnoreCase(String keyword);
}
