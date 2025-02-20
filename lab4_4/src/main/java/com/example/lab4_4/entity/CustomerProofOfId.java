package com.example.lab4_4.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "CUSTOMER_PROOF_ID")
public class CustomerProofOfId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CST_ID")
    private Long customerId;

    @Size(max = 100, message = "Proof of ID Type must not exceed 100 characters")
    @Column(name = "CST_PROOF_ID_TYPE")
    private String proofIdType;

    @Size(max = 100, message = "Classification Type Value must not exceed 100 characters")
    @Column(name = "CST_CLASSIFICATION_TYPE_VALUE")
    private String classificationTypeValue;

    @Column(name = "CST_START_DATE")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @Column(name = "CST_END_DATE")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    @Column(name = "CST_EFFECTIVE_DATE")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date effectiveDate;

    @Column(name = "CST_CRUD_VALUE", length = 1)
    private String crudValue;

    @Column(name = "CST_HOST_TS", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp hostTimestamp;

    @Column(name = "CST_LOCAL_TS", nullable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp localTimestamp;

    @Column(name = "CST_ACPT_TS", nullable = true)
    private Timestamp acceptedTimestamp;

    @Column(name = "CST_ACPT_TS_UTC_OFST", nullable = true)
    private Timestamp acceptedTimestampUtcOffset;

    // Getters and Setters
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getProofIdType() {
        return proofIdType;
    }

    public void setProofIdType(String proofIdType) {
        this.proofIdType = proofIdType;
    }

    public String getClassificationTypeValue() {
        return classificationTypeValue;
    }

    public void setClassificationTypeValue(String classificationTypeValue) {
        this.classificationTypeValue = classificationTypeValue;
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

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getCrudValue() {
        return crudValue;
    }

    public void setCrudValue(String crudValue) {
        this.crudValue = crudValue;
    }

    public Timestamp getHostTimestamp() {
        return hostTimestamp;
    }

    public Timestamp getLocalTimestamp() {
        return localTimestamp;
    }

    public Timestamp getAcceptedTimestamp() {
        return acceptedTimestamp;
    }

    public void setAcceptedTimestamp(Timestamp acceptedTimestamp) {
        this.acceptedTimestamp = acceptedTimestamp;
    }

    public Timestamp getAcceptedTimestampUtcOffset() {
        return acceptedTimestampUtcOffset;
    }

    public void setAcceptedTimestampUtcOffset(Timestamp acceptedTimestampUtcOffset) {
        this.acceptedTimestampUtcOffset = acceptedTimestampUtcOffset;
    }
}
