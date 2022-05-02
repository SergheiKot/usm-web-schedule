package com.sergheikot.usmwebschedule.jpa.repository;

import com.sergheikot.usmwebschedule.jpa.domain.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
}
