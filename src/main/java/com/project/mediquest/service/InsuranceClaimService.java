package com.project.mediquest.service;

import com.project.mediquest.entities.InsuranceClaim;
import com.project.mediquest.repository.InsuranceClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceClaimService {
    @Autowired
    private InsuranceClaimRepository insuranceClaimRepository;

    public InsuranceClaim saveClaim(InsuranceClaim claim) {
        return insuranceClaimRepository.save(claim);
    }

    public List<InsuranceClaim> getAllClaims() {
        return insuranceClaimRepository.findAll();
    }

    public InsuranceClaim getClaimById(Long id) {
        return insuranceClaimRepository.findById(id).orElse(null);
    }

    public void deleteClaim(Long id) {
        insuranceClaimRepository.deleteById(id);
}
}