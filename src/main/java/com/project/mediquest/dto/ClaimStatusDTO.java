package com.project.mediquest.dto;

import com.project.mediquest.entities.InsuranceClaim;
import com.project.mediquest.enums.InsuranceStatus;
import lombok.Data;

@Data
public class ClaimStatusDTO {
    private InsuranceClaim insuranceClaim;
    private InsuranceStatus status;
}
