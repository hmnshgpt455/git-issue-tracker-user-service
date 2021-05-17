package io.github.hmnshgpt455.gitissuetrackeruserservice.repositories;

import io.github.hmnshgpt455.gitissuetrackeruserservice.domain.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "organization", path = "organization")
public interface OrganizationRepository extends JpaRepository<Organization, UUID> {

    @RestResource(exported = false)
    Organization findByName(String name);
}
