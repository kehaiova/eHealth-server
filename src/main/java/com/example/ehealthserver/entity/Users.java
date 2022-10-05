package com.example.ehealthserver.entity;

import javax.persistence.*;

@Entity
@Table(name="V_eHEALTH_USERS")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "PERSON_ID")
    private Long person_id;

    @Column(name="USERNAME")
    private String username;

    @Column(name="PASSWORD")
    private String password;
}
