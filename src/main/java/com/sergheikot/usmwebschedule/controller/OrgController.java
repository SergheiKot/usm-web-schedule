package com.sergheikot.usmwebschedule.controller;

import com.sergheikot.usmwebschedule.constants.UserRoles;
import com.sergheikot.usmwebschedule.jpa.domain.Organization;
import com.sergheikot.usmwebschedule.jpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("org")
public class OrgController extends BaseController<Organization> {

    @Override
    public boolean isUserHaveAccess(User user, Organization accessObject) {
        return user.getUserRole().getId() == UserRoles.ADMIN
                || accessObject.getId() == user.getOrganization().getId();
    }

    @Override
    public JpaRepository<Organization, Integer> getControllerRepository() {
        return getOrganizationRepository();
    }

}
