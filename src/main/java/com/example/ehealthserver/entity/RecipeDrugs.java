package com.example.ehealthserver.entity;

import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "RECIPE_DRUGS_TEST")
public class RecipeDrugs implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DRUG_ID")
    private Long drugId;

    @Column(name = "RECIPE_DRUGS_LIST_ID")
    private Long recipeId;

    @Column(name = "MCB_CODE")
    private String mcbCode;

    @Column(name = "DRUG_PRODUCT_NAME")
    private String drugProductName;

}
