package com.example.lab4_1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "CUSTOMER_DETAILS")
public class CustomerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUST_NUMBER")
    private Long customerNumber;

    @NotBlank
    @Size(max = 50)
    @Column(name = "CUST_TYPE")
    private String customerType;

    @NotBlank
    @Size(max = 100)
    @Column(name = "CUST_FULL_NAME")
    private String customerFullName;

    @Column(name = "CUST_DOB_DOI")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date customerDOB_DOI;

    @NotBlank
    @Size(max = 20)
    @Column(name = "CUST_STATUS")
    private String customerStatus;

    @Size(max = 15)
    @Column(name = "CUST_CONTACT_NUMBER")
    private String customerContactNumber;

    @Size(max = 15)
    @Column(name = "CUST_MOBILE_NUMBER")
    private String customerMobileNumber;

    @Email
    @Size(max = 100)
    @Column(name = "CUST_EMAIL_ID")
    private String customerEmail;

    @Size(max = 50)
    @Column(name = "CUST_COUNTRY_ORIGIN")
    private String customerCountryOrigin;

    @Column(name = "CUST_EFFECTIVE_DATE")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date effectiveDate;

    // Getters and Setters
    public Long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Long customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }

    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }

    public Date getCustomerDOB_DOI() {
        return customerDOB_DOI;
    }

    public void setCustomerDOB_DOI(Date customerDOB_DOI) {
        this.customerDOB_DOI = customerDOB_DOI;
    }

    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }

    public String getCustomerContactNumber() {
        return customerContactNumber;
    }

    public void setCustomerContactNumber(String customerContactNumber) {
        this.customerContactNumber = customerContactNumber;
    }

    public String getCustomerMobileNumber() {
        return customerMobileNumber;
    }

    public void setCustomerMobileNumber(String customerMobileNumber) {
        this.customerMobileNumber = customerMobileNumber;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerCountryOrigin() {
        return customerCountryOrigin;
    }

    public void setCustomerCountryOrigin(String customerCountryOrigin) {
        this.customerCountryOrigin = customerCountryOrigin;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
