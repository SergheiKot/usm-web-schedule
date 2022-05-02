package com.sergheikot.usmwebschedule.jpa.repository;

import com.sergheikot.usmwebschedule.jpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByLoginAndPassword(String login, String password);

}
