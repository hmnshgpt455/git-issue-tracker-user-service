package io.github.hmnshgpt455.gitissuetrackeruserservice.web.controllers;

import io.github.hmnshgpt455.common.model.responses.AvailabilityResponse;
import io.github.hmnshgpt455.common.model.UserDTO;
import io.github.hmnshgpt455.gitissuetrackeruserservice.domain.User;
import io.github.hmnshgpt455.gitissuetrackeruserservice.exception.definitions.InvalidRequest;
import io.github.hmnshgpt455.gitissuetrackeruserservice.mapper.UserMapper;
import io.github.hmnshgpt455.gitissuetrackeruserservice.repositories.UserRepository;
import io.github.hmnshgpt455.gitissuetrackeruserservice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RepositoryRestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;


    @PostMapping(path = "/user", produces = "application/hal+json")
    @ResponseBody
    public UserDTO newUser(@RequestBody UserDTO userDTO) {
        return userService.saveNewUser(userDTO);
    }

    @GetMapping(path = "/user", produces = "application/hal+json")
    @ResponseBody
    public CollectionModel<UserDTO> getAllUsers() {
        List<UserDTO> userDTOs = userService.getAllUsers();
        return CollectionModel.of(userDTOs);
    }

    @GetMapping("/user/check-availability")
    @ResponseBody
    public AvailabilityResponse validateAvailability(@RequestParam(value = "email", required = false) String email,
                                                     @RequestParam(value = "username", required = false) String username) {
        if (StringUtils.isEmpty(email) && StringUtils.isEmpty(username)) {
            throw new InvalidRequest("Invalid request : email and username both are null");
        }

        if (StringUtils.isNotEmpty(email) && StringUtils.isNotEmpty(username)) {
            throw new InvalidRequest("Invalid request : Both email and username are not empty");
        }

        if (StringUtils.isNotEmpty(email)) {
            return userService.checkEmailAvailability(email);
        }

        return userService.checkUsernameAvailability(username);
    }

}
