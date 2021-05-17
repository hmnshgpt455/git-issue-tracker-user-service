package io.github.hmnshgpt455.gitissuetrackeruserservice.repositories;

import io.github.hmnshgpt455.gitissuetrackeruserservice.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "project", path = "project")
public interface ProjectRepository extends JpaRepository<Project, UUID> {

    @RestResource(exported = false)
    List<Project> findAllByProjectNameIn(List<String> projectNames);
}
