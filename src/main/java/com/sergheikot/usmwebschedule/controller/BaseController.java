package com.sergheikot.usmwebschedule.controller;

import com.sergheikot.usmwebschedule.exception.NotAccessException;
import com.sergheikot.usmwebschedule.jpa.domain.User;
import com.sergheikot.usmwebschedule.jpa.repository.Repositories;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

public abstract class BaseController<T> extends Repositories {

    private static final String ID = "id";
    private static final String SESSION_KEY = "sessionKey";

    public abstract boolean isUserHaveAccess(User user, T accessObject);

    public abstract JpaRepository<T, Integer> getControllerRepository();

    private void checkAccess(User user, T accessObject) {
        if (user == null || accessObject == null || !isUserHaveAccess(user, accessObject)) {
            throw new NotAccessException();
        }
    }

    @GetMapping("{" + ID + "}")
    public T read(@PathVariable(ID) T value,
                  @RequestParam(SESSION_KEY) String sessionKey) {

        checkAccess(getSessionRepository().findByKey(sessionKey).get(0).getUser(), value);

        return value;
    }

    @PostMapping
    public T create(@RequestBody T value,
                    @RequestParam(SESSION_KEY) String sessionKey) {

        checkAccess(getSessionRepository().findByKey(sessionKey).get(0).getUser(), value);

        return getControllerRepository().save(value);
    }

    @PutMapping("{" + ID + "}")
    public T update(@PathVariable(ID) T valueFromDb,
                    @RequestBody T value,
                    @RequestParam(SESSION_KEY) String sessionKey) {

        checkAccess(getSessionRepository().findByKey(sessionKey).get(0).getUser(), value);

        BeanUtils.copyProperties(value, valueFromDb, ID);

        return getControllerRepository().save(valueFromDb);
    }

    @DeleteMapping("{" + ID + "}")
    public void delete(@RequestBody T value,
                       @RequestParam(SESSION_KEY) String sessionKey) {

        checkAccess(getSessionRepository().findByKey(sessionKey).get(0).getUser(), value);

        getControllerRepository().delete(value);
    }

}
