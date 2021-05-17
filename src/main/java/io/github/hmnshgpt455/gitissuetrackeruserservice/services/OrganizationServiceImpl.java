package io.github.hmnshgpt455.gitissuetrackeruserservice.services;

import io.github.hmnshgpt455.gitissuetrackeruserservice.domain.Organization;
import io.github.hmnshgpt455.gitissuetrackeruserservice.repositories.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;

    @Override
    public Organization getOrganizationByName(String organizationName) {
        return organizationRepository.findByName(organizationName);
    }
}
