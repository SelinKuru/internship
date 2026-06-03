package com.selin.internship.controller;

import com.selin.internship.dto.InternshipRequestDto;
import com.selin.internship.dto.InternshipResponseDto;
import com.selin.internship.entity.Internship;
import com.selin.internship.service.InternshipService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/internships")
public class InternshipController {

    private final InternshipService internshipService;

    public InternshipController(InternshipService internshipService) {
        this.internshipService = internshipService;
    }

    @GetMapping
    public List<Internship> getAllInternships() {
        return internshipService.getAllInternships();
    }

    @GetMapping("/{id}")
    public Internship getInternshipById(@PathVariable Long id) {
        return internshipService.getInternshipById(id);
    }

    @PostMapping
    public InternshipResponseDto createInternship(
            @Valid @RequestBody InternshipRequestDto requestDto) {

        Internship internship = new Internship();
        internship.setCompanyName(requestDto.getCompanyName());
        internship.setPosition(requestDto.getPosition());
        internship.setStatus(requestDto.getStatus());
        internship.setApplicationDate(LocalDate.now());

        Internship savedInternship = internshipService.saveInternship(internship);

        return convertToResponseDto(savedInternship);
    }

    @PutMapping("/{id}")
    public InternshipResponseDto updateInternship(
            @PathVariable Long id,
            @Valid @RequestBody InternshipRequestDto requestDto) {

        Internship internship = internshipService.getInternshipById(id);

        internship.setCompanyName(requestDto.getCompanyName());
        internship.setPosition(requestDto.getPosition());
        internship.setStatus(requestDto.getStatus());

        Internship updatedInternship = internshipService.saveInternship(internship);

        return convertToResponseDto(updatedInternship);
    }

    @DeleteMapping("/{id}")
    public String deleteInternship(@PathVariable Long id) {
        internshipService.deleteInternship(id);
        return "Başvuru silindi";
    }

    @PostMapping("/rollback-test")
    public String rollbackTest() {
        internshipService.createTwoInternshipsWithRollbackTest();
        return "Rollback testi tamamlandı";
    }

    @GetMapping("/search/company")
    public List<Internship> searchByCompany(@RequestParam String companyName) {
        return internshipService.searchByCompany(companyName);
    }

    @GetMapping("/search/position")
    public List<Internship> searchByPosition(@RequestParam String position) {
        return internshipService.searchByPosition(position);
    }

    @GetMapping("/search/status")
    public List<Internship> searchByStatus(@RequestParam String status) {
        return internshipService.searchByStatus(status);
    }

    private InternshipResponseDto convertToResponseDto(Internship internship) {
        InternshipResponseDto responseDto = new InternshipResponseDto();

        responseDto.setId(internship.getId());
        responseDto.setCompanyName(internship.getCompanyName());
        responseDto.setPosition(internship.getPosition());
        responseDto.setApplicationDate(internship.getApplicationDate());
        responseDto.setStatus(internship.getStatus());

        return responseDto;
    }
}