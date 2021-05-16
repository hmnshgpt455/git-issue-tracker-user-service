package io.github.hmnshgpt455.gitissuetrackeruserservice.repositories;

import io.github.hmnshgpt455.gitissuetrackeruserservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends JpaRepository<User, UUID> {

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
