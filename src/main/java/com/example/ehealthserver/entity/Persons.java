package com.example.ehealthserver.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "PERSONS_TEST")
public class Persons {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "PERSON_ID")
    Set<Recipes> recipeList;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "PERSON_ID")
    Set<Referrals> referralsSet;

    @Column(name = "ID_TYPE")
    private String idType;

    @Column(name = "PERSON_IDENTIFICATOR")
    private String personIdentificator;

    @Column(name = "PERSON_NAMES")
    private String personNames;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "RHIF_NO")
    private String rhifNo;
}
