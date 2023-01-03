package com.example.ehealthserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "V_REFERRALS")
public class VReferrals {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "PERSON_IDENTIFICATOR")
    private String personIdentificator;

    @Column(name = "PERSON_NAMES")
    private String personNames;

    @Column(name = "DIAGNOSIS_PRIMARY_NAME")
    private String diagnosisPrimaryName;

    @Column(name = "MCB_CODE_PRIMARY")
    private String mcbCodePrimary;

    @Column(name = "ISSUE_DATE")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date issueDate;

    @Column(name = "MEDICAL_REFERRAL_NO")
    private String medicalReferralNo;

    @Column(name = "OUTPATION_LIST_NO")
    private String outpationListNo;

    @Column(name = "SENT_FOR")
    private String sentFor;

    @Column(name = "UIN_DOCTOR")
    private String uinDoctor;
}
