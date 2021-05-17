package io.github.hmnshgpt455.gitissuetrackeruserservice.services;

import io.github.hmnshgpt455.common.model.OrganizationDTO;
import io.github.hmnshgpt455.common.model.ProjectDTO;
import io.github.hmnshgpt455.common.model.UserDTO;
import io.github.hmnshgpt455.common.model.responses.AvailabilityResponse;
import io.github.hmnshgpt455.gitissuetrackeruserservice.domain.Project;
import io.github.hmnshgpt455.gitissuetrackeruserservice.domain.User;
import io.github.hmnshgpt455.gitissuetrackeruserservice.exception.definitions.InvalidRequest;
import io.github.hmnshgpt455.gitissuetrackeruserservice.mapper.UserMapper;
import io.github.hmnshgpt455.gitissuetrackeruserservice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final OrganizationService organizationService;
    private final ProjectService projectService;
    private final UserMapper userMapper;

    @Override
    public UserDTO saveNewUser(UserDTO userDTO) {
        User userEntity = userMapper.userDtoToUser(userDTO);
        setProjectEntities(userDTO.getProjects(), userEntity);
        setOrganizationEntity(userDTO.getOrganization(), userEntity);
        User savedUser = userRepository.save(userEntity);
        return userMapper.userToUserDto(savedUser);
    }

    private void setOrganizationEntity(OrganizationDTO organizationDTO, User userEntity) {

        Optional.ofNullable(organizationDTO).ifPresentOrElse(organization -> {
            Optional.ofNullable(organization.getName()).ifPresentOrElse(organizationName ->
                    userEntity.setOrganization(organizationService.getOrganizationByName(organizationName)), () -> {
                throw new InvalidRequest("Organization name is null or empty");
            });
            organizationService.getOrganizationByName(organization.getName());
        }, () -> {
            throw new InvalidRequest("Organization is null or empty");
        });
    }

    private void setProjectEntities(Set<ProjectDTO> projectDTOs, User userEntity) {
        Optional.ofNullable(projectDTOs).ifPresentOrElse(projects -> {

            List<ProjectDTO> filteredProjects = projects.stream().filter(projectDTO ->
                    StringUtils.isNotEmpty(projectDTO.getProjectName())).collect(Collectors.toList());

            List<Project> projectEntities = projectService.getAllProjectsByNames(
                    filteredProjects.stream().map(ProjectDTO::getProjectName).collect(Collectors.toList()));
            userEntity.setProjects(new HashSet<>(projectEntities));

        }, () -> {
            throw new InvalidRequest("Project names are null or empty");
        });
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
