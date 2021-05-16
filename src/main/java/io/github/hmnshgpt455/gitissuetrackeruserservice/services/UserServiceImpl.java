package io.github.hmnshgpt455.gitissuetrackeruserservice.services;

import io.github.hmnshgpt455.common.model.UserDTO;
import io.github.hmnshgpt455.common.model.responses.AvailabilityResponse;
import io.github.hmnshgpt455.gitissuetrackeruserservice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDTO saveNewUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public AvailabilityResponse checkEmailAvailability(String email) {
        return AvailabilityResponse.builder()
                .isAvailable(!userRepository.existsByEmail(email))
                .build();
    }

    @Override
    public AvailabilityResponse checkUsernameAvailability(String username) {
        return AvailabilityResponse.builder()
                .isAvailable(!userRepository.existsByUsername(username))
                .build();
    }
}
