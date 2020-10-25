package ru.croc.coder.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import ru.croc.coder.domain.User;

/**
 * todo Document type UserEventsHandler
 */
@RepositoryEventHandler
public class UserEventHandler {

    private static final Logger log = LoggerFactory.getLogger(UserEventHandler.class);

    @HandleBeforeCreate
    @HandleBeforeSave
    public void handleUserSaving(User user) {
        System.out.println("!!! " + user);
        log.info("inside user event handler");
        user.setPassword(user.getPassword() + " hello");
    }
}
