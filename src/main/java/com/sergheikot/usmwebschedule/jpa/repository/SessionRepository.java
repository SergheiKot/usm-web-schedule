package com.sergheikot.usmwebschedule.jpa.repository;

import com.sergheikot.usmwebschedule.jpa.domain.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Integer> {

    List<Session> findByKey(String key);

}
