package io.github.hmnshgpt455.gitissuetrackeruserservice.bootstrap;

import io.github.hmnshgpt455.gitissuetrackeruserservice.domain.User;
import io.github.hmnshgpt455.gitissuetrackeruserservice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserBootstrap implements CommandLineRunner {

    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findAll().isEmpty()) {

        }
    }
}
