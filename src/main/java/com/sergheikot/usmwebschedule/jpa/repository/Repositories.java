package com.sergheikot.usmwebschedule.jpa.repository;

import org.springframework.beans.factory.annotation.Autowired;

public class Repositories {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DateItemRepository dateItemRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    public OrganizationRepository getOrganizationRepository() {
        return organizationRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public DateItemRepository getDateItemRepository() {
        return dateItemRepository;
    }

    public SessionRepository getSessionRepository() {
        return sessionRepository;
    }

    public UserRoleRepository getUserRoleRepository() {
        return userRoleRepository;
    }

}
