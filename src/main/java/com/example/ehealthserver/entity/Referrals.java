package com.example.ehealthserver.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="REFERRALS_TEST")
public class Referrals implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "PERSON_ID")
    private Long personId;

    @Column(name = "OUTPATION_LIST_NO")
    private String outpationListNo;

    @Column(name = "MEDICAL_REFERRAL_NO")
    private String medicalReferralNo;

    @Column(name = "MCB_CODE_PRIMARY")
    private String mcbCodePrimary;

    @Column(name = "DIAGNOSIS_PRIMARY_NAME")
    private String diagnosisPrimaryName;

    @Column(name = "SENT_FOR")
    private String sentFor;

    @Column(name = "DOCTOR_NAMES")
    private String doctorNames;

    @Column(name = "UIN_DOCTOR")
    private String uinDoctor;

    @Column(name = "ISSUE_DATE")
    private Date issueDate;

}
