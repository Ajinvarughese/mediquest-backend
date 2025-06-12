package com.project.mediquest.controller;

import com.project.mediquest.entities.Medicine;
import com.project.mediquest.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    // Get all medicines
    @GetMapping
    public ResponseEntity<List<Medicine>> getAllMedicines() {
        return ResponseEntity.ok(medicineService.getAllMedicines());
    }

    // Get a medicine by ID
    @GetMapping("/{id}")
    public ResponseEntity<Medicine> getMedicineById(@PathVariable Long id) {
        Medicine medicine = medicineService.getMedicineById(id);
        if (medicine != null) {
            return ResponseEntity.ok(medicine);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Add a new medicine
    @PostMapping
    public ResponseEntity<Medicine> addMedicine(@RequestBody Medicine medicine) {
        return ResponseEntity.ok(medicineService.addMedicine(medicine));
    }

    // Update an existing medicine
    @PutMapping("/{id}")
    public ResponseEntity<Medicine> updateMedicine(@PathVariable Long id, @RequestBody Medicine updatedMedicine) {
        Medicine existingMedicine = medicineService.getMedicineById(id);
        if (existingMedicine == null) {
            return ResponseEntity.notFound().build();
        }
        updatedMedicine.setId(id);
        return ResponseEntity.ok(medicineService.saveMedicine(updatedMedicine));
    }

    // Delete a medicine
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicine(@PathVariable Long id) {
        Medicine existingMedicine = medicineService.getMedicineById(id);
        if (existingMedicine == null) {
            return ResponseEntity.notFound().build();
        }
        medicineService.deleteMedicine(id);
        return ResponseEntity.noContent().build();
    }

    // Search medicines by name
    @GetMapping("/search")
    public ResponseEntity<List<Medicine>> searchMedicines(@RequestParam String keyword) {
        return ResponseEntity.ok(medicineService.searchByName(keyword));
    }
}
