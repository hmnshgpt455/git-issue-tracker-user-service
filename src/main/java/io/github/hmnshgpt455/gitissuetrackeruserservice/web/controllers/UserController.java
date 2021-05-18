package io.github.hmnshgpt455.gitissuetrackeruserservice.web.controllers;

import io.github.hmnshgpt455.common.model.UserDTO;
import io.github.hmnshgpt455.common.responses.AvailabilityResponse;
import io.github.hmnshgpt455.gitissuetrackeruserservice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/user/{username}/availability")
    @ResponseBody
    public AvailabilityResponse validateAvailability(@PathVariable("username") String username) {
        return userService.checkUsernameAvailability(username);
    }

}
