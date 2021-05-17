package io.github.hmnshgpt455.gitissuetrackeruserservice.repositories;

import io.github.hmnshgpt455.gitissuetrackeruserservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends JpaRepository<User, UUID> {

    @RestResource(exported = false)
    boolean existsByUsername(String username);

    @RestResource(exported = false)
    boolean existsByEmail(String email);
}
