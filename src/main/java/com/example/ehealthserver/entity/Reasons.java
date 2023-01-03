package com.example.ehealthserver.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "REASONS_SENT_TEST")
public class Reasons {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "REASON")
    private String reason;
}
