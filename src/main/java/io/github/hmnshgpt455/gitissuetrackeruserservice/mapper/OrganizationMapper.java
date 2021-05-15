package io.github.hmnshgpt455.gitissuetrackeruserservice.mapper;

import io.github.hmnshgpt455.common.model.OrganizationDTO;
import io.github.hmnshgpt455.gitissuetrackeruserservice.domain.Organization;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface OrganizationMapper {

    OrganizationDTO organizationToOrganizationDto(Organization organization);
    Organization organizationDtoToOrganization(OrganizationDTO organizationDTO);
}
