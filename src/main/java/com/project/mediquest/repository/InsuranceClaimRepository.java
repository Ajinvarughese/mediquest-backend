package com.project.mediquest.repository;

import com.project.mediquest.entities.InsuranceClaim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceClaimRepository extends JpaRepository<InsuranceClaim, Long> {
}
