package com.selin.internship.service;

import com.selin.internship.entity.Application;
import com.selin.internship.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public Application saveApplication(Application application) {
        return applicationRepository.save(application);
    }

    public List<Application> getApplicationsByStudentEmail(String email) {
        return applicationRepository.findByStudentEmail(email);
    }

    public List<Application> getApplicationsByCompanyName(String companyName) {
        return applicationRepository.findByCompanyName(companyName);
    }

    public List<Application> searchByPosition(String position) {
        return applicationRepository.findByPositionContainingIgnoreCase(position);
    }

    public Application updateApplicationStatus(Long id, String status) {
        Application application = applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));

        application.setStatus(status);

        return applicationRepository.save(application);
    }
}