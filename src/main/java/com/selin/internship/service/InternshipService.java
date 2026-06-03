package com.selin.internship.service;

import com.selin.internship.entity.Internship;
import com.selin.internship.exception.InternshipNotFoundException;
import com.selin.internship.repository.InternshipRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InternshipService {

    private final InternshipRepository internshipRepository;

    public InternshipService(InternshipRepository internshipRepository) {
        this.internshipRepository = internshipRepository;
    }

    public List<Internship> getAllInternships() {
        return internshipRepository.findAll();
    }

    public Internship getInternshipById(Long id) {
        return internshipRepository.findById(id)
                .orElseThrow(() ->
                        new InternshipNotFoundException("Başvuru bulunamadı"));
    }

    public Internship saveInternship(Internship internship) {
        return internshipRepository.save(internship);
    }

    public void deleteInternship(Long id) {
        Internship internship = getInternshipById(id);
        internshipRepository.delete(internship);
    }

    public List<Internship> searchByCompany(String companyName) {
        return internshipRepository
                .findByCompanyNameContainingIgnoreCase(companyName);
    }

    public List<Internship> searchByPosition(String position) {
        return internshipRepository
                .findByPositionContainingIgnoreCase(position);
    }

    public List<Internship> searchByStatus(String status) {
        return internshipRepository.findByStatusIgnoreCase(status);
    }

    @Transactional
    public void createTwoInternshipsWithRollbackTest() {
        Internship firstInternship = new Internship();
        firstInternship.setCompanyName("Rollback Test Company 1");
        firstInternship.setPosition("Backend Intern");
        firstInternship.setStatus("APPLIED");

        internshipRepository.save(firstInternship);

        Internship secondInternship = new Internship();
        secondInternship.setCompanyName("Rollback Test Company 2");
        secondInternship.setPosition("Java Intern");
        secondInternship.setStatus("APPLIED");

        internshipRepository.save(secondInternship);

        throw new RuntimeException("Rollback testi için hata oluşturuldu");
    }
}