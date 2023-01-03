package com.example.ehealthserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "V_RECIPES")
public class VRecipes {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "PERSON_IDENTIFICATOR")
    private String personIdentificator;

    @Column(name = "PERSON_NAMES")
    private String personNames;

    @Column(name = "UIN_DOCTOR")
    private String uinDoctor;

    @Column(name = "PROTOCOL_NO")
    private String protocolNo;

    @Column(name = "PRESCRIPTION_BOOKLET_NO")
    private String prescriptionBookletNo;

    @Column(name = "OUTPATION_LIST_NO")
    private String outpationListNo;

    @Column(name = "ISSUE_DATE")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date issueDate;

    @Column(name = "DRUG_PRODUCT_NAME")
    private String drugProductName;

    @Column(name = "MCB_CODE")
    private String mcbCode;

}
