package io.github.hmnshgpt455.gitissuetrackeruserservice.model.processors;

import io.github.hmnshgpt455.common.model.UserDTO;
import io.github.hmnshgpt455.gitissuetrackeruserservice.web.controllers.UserController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Component
public class UserCollectionModelProcessor implements RepresentationModelProcessor<CollectionModel<UserDTO>> {
    @Override
    public CollectionModel<UserDTO> process(CollectionModel<UserDTO> model) {
        model.add(linkTo(methodOn(UserController.class).getAllUsers()).withSelfRel());
        model.add(linkTo(methodOn(UserController.class).getAllUsers()).withRel("users"));
        model.add(linkTo(UserController.class).slash("role").withRel("roles"));
        model.add(linkTo(UserController.class).slash("organization").withRel("organizations"));
        model.add(linkTo(UserController.class).slash("project").withRel("projects"));
        return model;
    }
}
