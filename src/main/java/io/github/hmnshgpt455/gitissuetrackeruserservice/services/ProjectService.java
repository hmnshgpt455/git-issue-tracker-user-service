package io.github.hmnshgpt455.gitissuetrackeruserservice.services;

import io.github.hmnshgpt455.gitissuetrackeruserservice.domain.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAllProjectsByNames(List<String> projectNames);
}
