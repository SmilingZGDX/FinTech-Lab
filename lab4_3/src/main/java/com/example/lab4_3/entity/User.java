package com.example.lab4_3.entity;

import java.util.Date;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "CUST_CI")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Type is required")
    @Size(max = 50, message = "Contact info type must not exceed 50 characters")
    private String contactInfoType;

    @NotBlank(message = "Detail is required")
    @Size(max = 100, message = "Contact detail must not exceed 100 characters")
    private String contactDetail;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date effectiveDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    // Getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getContactInfoType() {
        return contactInfoType;
    }
    public void setContactInfoType(String contactInfoType) {
        this.contactInfoType = contactInfoType;
    }

    public String getContactDetail() {
        return contactDetail;
    }
    public void setContactDetail(String contactDetail) {
        this.contactDetail = contactDetail;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }
    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}