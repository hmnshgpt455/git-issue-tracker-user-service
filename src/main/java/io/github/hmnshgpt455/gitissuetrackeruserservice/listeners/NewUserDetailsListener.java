package io.github.hmnshgpt455.gitissuetrackeruserservice.listeners;

import io.github.hmnshgpt455.common.model.UserDTO;
import io.github.hmnshgpt455.gitissuetrackeruserservice.config.JmsConfig;
import io.github.hmnshgpt455.gitissuetrackeruserservice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NewUserDetailsListener {

    private final UserService userService;

    @JmsListener(destination = JmsConfig.NEW_USER_QUEUE)
    public void listen(@Payload UserDTO userDTO) {
        userService.saveNewUser(userDTO);
    }
}
