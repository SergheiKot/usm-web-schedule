package com.sergheikot.usmwebschedule.jpa.repository;

import com.sergheikot.usmwebschedule.jpa.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
}
