package com.project.mediquest.service;

import com.project.mediquest.entities.InsuranceClaim;
import com.project.mediquest.enums.InsuranceStatus;
import com.project.mediquest.repository.InsuranceClaimRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceClaimService {
    @Autowired
    private InsuranceClaimRepository insuranceClaimRepository;

    public InsuranceClaim saveClaim(InsuranceClaim claim) {
        claim.setStatus(InsuranceStatus.PENDING);
        return insuranceClaimRepository.save(claim);
    }

    public List<InsuranceClaim> getAllClaims() {
        return insuranceClaimRepository.findAll();
    }

    public List<InsuranceClaim> getClaimByUser(String phone) {
        return insuranceClaimRepository.findByPatientPhone(phone);
    }

    public InsuranceClaim updateClaim(InsuranceClaim claim) {
        InsuranceClaim existing = insuranceClaimRepository.findById(claim.getId())
                .orElseThrow(() -> new EntityNotFoundException("Entity not found with id: "+claim.getId()));
        existing.setAmount(claim.getAmount());
        existing.setStatus(claim.getStatus());
        existing.setDateOfService(claim.getDateOfService());
        existing.setTreatmentDescription(claim.getTreatmentDescription());
        existing.setProviderId(claim.getProviderId());
        existing.setProviderName(claim.getProviderName());
        existing.setTreatmentCode(claim.getTreatmentCode());

        return insuranceClaimRepository.save(existing);
    }

    public InsuranceClaim getClaimById(Long id) {
        return insuranceClaimRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Claim not found with id: "+id));
    }

    public InsuranceClaim updateStatus(Long id, InsuranceStatus status) {
        InsuranceClaim claim = getClaimById(id);
        claim.setStatus(status);
        return insuranceClaimRepository.save(claim);
    }
    public void deleteClaim(Long id) {
        insuranceClaimRepository.deleteById(id);
}
}