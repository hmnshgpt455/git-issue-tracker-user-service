package io.github.hmnshgpt455.gitissuetrackeruserservice.repositories;

import io.github.hmnshgpt455.gitissuetrackeruserservice.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "role", path = "role")
public interface RoleRepository extends JpaRepository<Role, UUID> {
}
