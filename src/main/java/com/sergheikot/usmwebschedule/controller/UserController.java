package com.sergheikot.usmwebschedule.controller;

import com.sergheikot.usmwebschedule.constants.UserRoles;
import com.sergheikot.usmwebschedule.jpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController extends BaseController<User> {

    @Override
    public boolean isUserHaveAccess(User user, User accessObject) {
        return user.getUserRole().getId() == UserRoles.ADMIN || user.getId() == accessObject.getId();
    }

    @Override
    public JpaRepository<User, Integer> getControllerRepository() {
        return getUserRepository();
    }

}
