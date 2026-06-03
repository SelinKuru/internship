package com.selin.internship.controller;

import com.selin.internship.entity.Application;
import com.selin.internship.service.ApplicationService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }

    @PostMapping
    public Application createApplication(@RequestBody Application application) {
        application.setApplicationDate(LocalDate.now());

        if (application.getStatus() == null || application.getStatus().isBlank()) {
            application.setStatus("APPLIED");
        }

        return applicationService.saveApplication(application);
    }

    @GetMapping("/student")
    public List<Application> getApplicationsByStudentEmail(@RequestParam String email) {
        return applicationService.getApplicationsByStudentEmail(email);
    }

    @GetMapping("/company")
    public List<Application> getApplicationsByCompanyName(@RequestParam String companyName) {
        return applicationService.getApplicationsByCompanyName(companyName);
    }

    @GetMapping("/search/position")
    public List<Application> searchByPosition(@RequestParam String position) {
        return applicationService.searchByPosition(position);
    }

    @PutMapping("/{id}/status")
    public Application updateApplicationStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return applicationService.updateApplicationStatus(id, status);
    }
}