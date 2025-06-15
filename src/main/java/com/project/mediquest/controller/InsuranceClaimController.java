package com.project.mediquest.controller;

import com.project.mediquest.entities.InsuranceClaim;
import com.project.mediquest.library.FileUpload;
import com.project.mediquest.service.InsuranceClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class InsuranceClaimController {

    private final InsuranceClaimService insuranceClaimService;
    private final FileUpload fileUpload;

    public InsuranceClaimController(InsuranceClaimService insuranceClaimService, FileUpload fileUpload) {
        this.insuranceClaimService = insuranceClaimService;
        this.fileUpload = fileUpload;
    }

    @PostMapping
    public InsuranceClaim addClaim(@RequestBody InsuranceClaim claim) {
        return insuranceClaimService.saveClaim(claim);
    }

    @GetMapping
    public List<InsuranceClaim> getAllClaims() {
        return insuranceClaimService.getAllClaims();
    }

    @PostMapping(path = "/file/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addFile(@ModelAttribute("picture") MultipartFile file) throws IOException {
        String pictureUrl = fileUpload.uploadFile(file);
        return ResponseEntity.ok(pictureUrl);
    }

    @GetMapping("/{id}")
    public InsuranceClaim getClaim(@PathVariable Long id) {
        return insuranceClaimService.getClaimById(id);
    }

    @GetMapping("/user/{phone}")
    public ResponseEntity<List<InsuranceClaim>> getClaimByUser(@PathVariable String phone) {
        return ResponseEntity.ok(insuranceClaimService.getClaimByUser(phone));
    }

    @DeleteMapping("/{id}")
    public void deleteClaim(@PathVariable Long id) {
        insuranceClaimService.deleteClaim(id);
}
}