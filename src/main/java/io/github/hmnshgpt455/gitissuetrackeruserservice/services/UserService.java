package io.github.hmnshgpt455.gitissuetrackeruserservice.services;

import io.github.hmnshgpt455.common.model.UserDTO;
import io.github.hmnshgpt455.common.model.responses.AvailabilityResponse;

public interface UserService {

    UserDTO saveNewUser(UserDTO userDTO);
    AvailabilityResponse checkEmailAvailability(String email);
    AvailabilityResponse checkUsernameAvailability(String username);
}
