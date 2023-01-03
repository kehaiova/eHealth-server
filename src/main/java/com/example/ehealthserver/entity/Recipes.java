package com.example.ehealthserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Data
@Table(name = "RECIPES_TEST")
public class Recipes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn()
    Set<RecipeDrugs> recipeDrugsList;

    @Column(name = "PERSON_ID")
    private Long personId;

    @Column(name = "PRESCRIPTION_BOOKLET_NO")
    private String prescriptionBookletNo;

    @Column(name = "PROTOCOL_NO")
    private String protocolNo;

    @Column(name = "OUTPATION_LIST_NO")
    private String outpationListNo;


    @Column(name = "DOCTOR_NAMES")
    private String doctorNames;

    @Column(name = "UIN_DOCTOR")
    private String uinDoctor;

    @Column(name = "ISSUE_DATE")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date issueDate;
}
