package io.github.hmnshgpt455.gitissuetrackeruserservice.model.processors;

import io.github.hmnshgpt455.common.model.UserDTO;
import io.github.hmnshgpt455.gitissuetrackeruserservice.domain.User;
import io.github.hmnshgpt455.gitissuetrackeruserservice.web.controllers.UserController;
import org.apache.commons.lang.StringUtils;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserModelProcessor implements RepresentationModelProcessor<UserDTO> {
    @Override
    public UserDTO process(UserDTO model) {
        if (null != model.getId() && StringUtils.isNotEmpty(model.getId().toString())) {
            model.add(linkTo(methodOn(UserController.class)
                    .getAllUsers()).slash(model.getId()).withSelfRel());
        }

        if (null != model.getRoles()) {
            model.getRoles().forEach(roleDto -> {
                if (null != roleDto.getId() && StringUtils.isNotEmpty(roleDto.getId().toString())) {
                    roleDto.add(linkTo(UserController.class).slash("role").slash(roleDto.getId()).withSelfRel());
                }
            });
        }

        if (null != model.getOrganization() && null != model.getOrganization().getId()
                && StringUtils.isNotEmpty(model.getOrganization().getId().toString())) {
            model.getOrganization().add(linkTo(UserController.class).slash("organization").slash(model.getOrganization().getId()).withSelfRel());
            model.getOrganization().add(linkTo(UserController.class).slash("organization").withRel("organizations"));
        }

        if (null != model.getProjects()) {
            model.getProjects().forEach(projectDTO -> {
                if (null != projectDTO.getId() && StringUtils.isNotEmpty(projectDTO.getId().toString())) {
                    projectDTO.add(linkTo(UserController.class).slash("project").slash(projectDTO.getId()).withSelfRel());
                }
            });
        }

        return model;
    }
}
