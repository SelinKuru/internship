package com.selin.internship.dto;

import jakarta.validation.constraints.NotBlank;

public class InternshipRequestDto {

    @NotBlank
    private String companyName;

    @NotBlank
    private String position;

    @NotBlank
    private String status;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}