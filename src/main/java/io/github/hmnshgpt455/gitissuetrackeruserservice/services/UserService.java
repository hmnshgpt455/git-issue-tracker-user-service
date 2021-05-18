package io.github.hmnshgpt455.gitissuetrackeruserservice.services;

import io.github.hmnshgpt455.common.model.UserDTO;
import io.github.hmnshgpt455.common.responses.AvailabilityResponse;

import java.util.List;

public interface UserService {

    UserDTO saveNewUser(UserDTO userDTO);
    AvailabilityResponse checkUsernameAvailability(String username);
    List<UserDTO> getAllUsers();
}
