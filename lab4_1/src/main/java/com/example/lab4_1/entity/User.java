package com.example.lab4_1.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@SuppressWarnings("unused")
@Entity
@Table(name = "`CUST_DETAILS`")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cstId;
    
    @Column(name = "CSTDET_TYPE")
    private String cstDetType;

    @Column(name = "CSTDET_FULLNAME")
    private String cstDetFullName;
    
    @Column(name = "CSTDET_DOB")
    private String cstDetDob;
    
    @Column(name="CSTDET_STATUS")
    private String cstDetStatus;
    
    @Column(name="CSTDET_CONTACT")
    private String cstDetContact;
    
    @Column(name="CSTDET_MOBILE")
    private String cstDetMobile;
    
    @Column(name="CSTDET_EMAIL")
    private String cstDetEmail;
    
    @Column(name="CSTDET_COUNTRY")
    private String cstDetCountry;

    @Column(name = "CSTDET_EFCTV_DT")
    private String cstDetEfctvDt;

    @Column(name = "CSTDET_CRUD_VALUE")
    private String cstDetCrudValue;

    @Column(name = "CSTDET_USER_ID")
    private String cstDetUserId;

    @Column(name = "CSTDET_WS_ID")
    private String cstDetWsId;

    @Column(name = "CSTDET_PRGM_ID")
    private String cstDetPrgmId;

    @Column(name = "CSTDET_HOST_TS",nullable=false,updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime cstDetHostTs;

    @Column(name = "CSTDET_LOCAL_TS",nullable=false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime cstDetLocalTs;

    @Column(name = "CSTDET_ACPT_TS")
    private String cstDetAcptTs;

    @Column(name = "CSTDET_ACPT_TS_UTC_OFST")
    private String cstDetAcptTsUtcOfst;

    @Column(name = "CSTDET_UUID")
    private String cstDetUuid;
    
    // Getters and setters
    public Long getCstId() {
        return cstId;
    }
    public void setCstId(Long cstId) {
        this.cstId = cstId;
    }
    
    public String getCstDetType() {
        return cstDetType;
    }
    public void setCstDetType(String cstDetType) {
        this.cstDetType = cstDetType;
    }
    
    public String getCstDetFullName() {
        return cstDetFullName;
    }
    public void setCstDetFullName(String cstDetFullName) {
        this.cstDetFullName = cstDetFullName;
    }
    
    public String getCstDetDob() {
        return cstDetDob;
    }

    public void setCstDetDob(String cstDetDob) {
        this.cstDetDob = cstDetDob;
    }
    
    public String getCstDetStatus() {
        return cstDetStatus;
    }

    public void setCstDetStatus(String cstDetStatus) {
        this.cstDetStatus = cstDetStatus;
    }

    public String getCstDetContact() {
        return cstDetContact;
    }

    public void setCstDetContact(String cstDetContact) {
        this.cstDetContact = cstDetContact;
    }

    public String getCstDetMobile() {
        return cstDetMobile;
    }

    public void setCstDetMobile(String cstDetMobile) {
        this.cstDetMobile = cstDetMobile;
    }

    public String getCstDetEmail() {
        return cstDetEmail;
    }

    public void setCstDetEmail(String cstDetEmail) {
        this.cstDetEmail = cstDetEmail;
    }

    public String getCstDetCountry() {
        return cstDetCountry;
    }

    public void setCstDetCountry(String cstDetCountry) {
        this.cstDetCountry = cstDetCountry;
    }

    public String getCstDetEfctvDt() {
        return cstDetEfctvDt;
    }

    public void setCstDetEfctvDt(String cstDetEfctvDt) {
        this.cstDetEfctvDt = cstDetEfctvDt;
    }

    public String getCstDetCrudValue() {
        return cstDetCrudValue;
    }

    public void setCstDetCrudValue(String cstDetCrudValue) {
        this.cstDetCrudValue = cstDetCrudValue;
    }

    public String getCstDetUserId() {
        return cstDetUserId;
    }

    public void setCstDetUserId(String cstDetUserId) {
        this.cstDetUserId = cstDetUserId;
    }

    public String getCstDetWsId() {
        return cstDetWsId;
    }

    public void setCstDetWsId(String cstDetWsId) {
        this.cstDetWsId = cstDetWsId;
    }

    public String getCstDetPrgmId() {
        return cstDetPrgmId;
    }

    public void setCstDetPrgmId(String cstDetPrgmId) {
        this.cstDetPrgmId = cstDetPrgmId;
    }

    public LocalDateTime getCstDetHostTs() {
        return cstDetHostTs;
    }

    public void setCstDetHostTs(LocalDateTime cstDetHostTs) {
        this.cstDetHostTs = cstDetHostTs;
    }

    public LocalDateTime getCstDetLocalTs() {
        return cstDetLocalTs;
    }

    public void setCstDetLocalTs(LocalDateTime cstDetLocalTs) {
        this.cstDetLocalTs = cstDetLocalTs;
    }

    public String getCstDetAcptTs() {
        return cstDetAcptTs;
    }

    public void setCstDetAcptTs(String cstDetAcptTs) {
        this.cstDetAcptTs = cstDetAcptTs;
    }

    public String getCstDetAcptTsUtcOfst() {
        return cstDetAcptTsUtcOfst;
    }

    public void setCstDetAcptTsUtcOfst(String cstDetAcptTsUtcOfst) {
        this.cstDetAcptTsUtcOfst = cstDetAcptTsUtcOfst;
    }

    public String getCstDetUuid() {
        return cstDetUuid;
    }

    public void setCstDetUuid(String cstDetUuid) {
        this.cstDetUuid = cstDetUuid;
    }
}