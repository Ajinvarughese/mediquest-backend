package com.project.mediquest.service;

import com.project.mediquest.entities.Medicine;
import com.project.mediquest.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {
    @Autowired
    private MedicineRepository medicineRepository;

    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

    public Medicine saveMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    public List<Medicine> searchByName(String keyword){
        return medicineRepository.findByNameContainingIgnoreCase(keyword);
    }

    public Medicine getMedicineById(Long id) {
        return medicineRepository.findById(id).orElse(null);
    }

    public Medicine addMedicine(Medicine medicine){
        return medicineRepository.save(medicine);
    }

    public void deleteMedicine(Long id) {
        medicineRepository.deleteById(id);
}
}