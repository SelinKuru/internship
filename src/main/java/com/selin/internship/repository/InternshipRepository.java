package com.selin.internship.repository;

import com.selin.internship.entity.Internship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InternshipRepository extends JpaRepository<Internship, Long> {

    List<Internship> findByCompanyNameContainingIgnoreCase(String companyName);

    List<Internship> findByPositionContainingIgnoreCase(String position);

    List<Internship> findByStatusIgnoreCase(String status);
}