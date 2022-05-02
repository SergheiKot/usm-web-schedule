package com.sergheikot.usmwebschedule.controller;

import com.sergheikot.usmwebschedule.constants.UserRoles;
import com.sergheikot.usmwebschedule.jpa.domain.DateItem;
import com.sergheikot.usmwebschedule.jpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dateItem")
public class DateItemController extends BaseController<DateItem> {

    @Override
    public boolean isUserHaveAccess(User user, DateItem accessObject) {
        return user.getUserRole().getId() == UserRoles.ADMIN
                || user.getOrganization().getId() == accessObject.getOrganization().getId();
    }

    @Override
    public JpaRepository<DateItem, Integer> getControllerRepository() {
        return getDateItemRepository();
    }

}
