package io.github.hmnshgpt455.gitissuetrackeruserservice.services;

import io.github.hmnshgpt455.gitissuetrackeruserservice.domain.Organization;

public interface OrganizationService {

    Organization getOrganizationByName(String organizationName);
}
