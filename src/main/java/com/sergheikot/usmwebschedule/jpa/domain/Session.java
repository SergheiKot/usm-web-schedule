package com.sergheikot.usmwebschedule.jpa.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "session")
@Data
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    @Column(unique = true, nullable = false)
    private String key;

    @OneToOne
    @JoinColumn(unique = true, nullable = false)
    private User user;

}
