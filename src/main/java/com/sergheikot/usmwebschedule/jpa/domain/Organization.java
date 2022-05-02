package com.sergheikot.usmwebschedule.jpa.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "organization")
@Data
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    @Column(unique = true, nullable = false)
    private String name;

    private String description;

}
