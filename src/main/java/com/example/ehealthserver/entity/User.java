package com.example.ehealthserver.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USERS_TEST")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DOCTOR_NAME")
    private String doctorName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;


    @Column(name = "UIN_DOCTOR")
    private String uinDoctor;

    @Column(name = "REGISTRY_NUMBER_LZ")
    private String registryNumberLz;


    public Long getId() {
        return id;
    }

    public String getRegistryNumberLz() {
        return registryNumberLz;
    }

    public void setRegistryNumberLz(String registryNumberLz) {
        this.registryNumberLz = registryNumberLz;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getUinDoctor() {
        return uinDoctor;
    }

    public void setUinDoctor(String uinDoctor) {
        this.uinDoctor = uinDoctor;
    }

}
