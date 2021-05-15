package io.github.hmnshgpt455.gitissuetrackeruserservice.mapper;

import io.github.hmnshgpt455.common.model.ProjectDTO;
import io.github.hmnshgpt455.gitissuetrackeruserservice.domain.Project;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface ProjectMapper {

    Project projectDtoToProject(ProjectDTO projectDTO);

    ProjectDTO projectToProjectDto(Project project);

}
