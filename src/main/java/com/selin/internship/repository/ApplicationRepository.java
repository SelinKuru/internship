package com.selin.internship.repository;

import com.selin.internship.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findByStudentEmail(String studentEmail);

    List<Application> findByCompanyName(String companyName);

    List<Application> findByPositionContainingIgnoreCase(String position);
}
