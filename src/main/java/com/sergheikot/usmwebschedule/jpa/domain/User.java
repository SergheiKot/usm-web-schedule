package com.sergheikot.usmwebschedule.jpa.domain;

import com.sergheikot.usmwebschedule.constants.UserRoles;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    @Column(unique = true, nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Organization organization;

    @ManyToOne
    @JoinColumn(nullable = false, columnDefinition = "" + UserRoles.USER + "")
    private UserRole userRole;

}
