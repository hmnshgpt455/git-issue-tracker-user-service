package io.github.hmnshgpt455.gitissuetrackeruserservice.services;

import io.github.hmnshgpt455.gitissuetrackeruserservice.domain.Project;
import io.github.hmnshgpt455.gitissuetrackeruserservice.repositories.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public List<Project> getAllProjectsByNames(List<String> projectNames) {
        return projectRepository.findAllByProjectNameIn(projectNames);
    }
}
