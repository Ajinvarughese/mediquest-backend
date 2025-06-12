package com.project.mediquest.controller;

import com.project.mediquest.entities.InsuranceClaim;
import com.project.mediquest.service.InsuranceClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class InsuranceClaimController {
    @Autowired
    private InsuranceClaimService insuranceClaimService;

    @PostMapping
    public InsuranceClaim addClaim(@RequestBody InsuranceClaim claim) {
        return insuranceClaimService.saveClaim(claim);
    }

    @GetMapping
    public List<InsuranceClaim> getAllClaims() {
        return insuranceClaimService.getAllClaims();
    }

    @GetMapping("/{id}")
    public InsuranceClaim getClaim(@PathVariable Long id) {
        return insuranceClaimService.getClaimById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteClaim(@PathVariable Long id) {
        insuranceClaimService.deleteClaim(id);
}
}