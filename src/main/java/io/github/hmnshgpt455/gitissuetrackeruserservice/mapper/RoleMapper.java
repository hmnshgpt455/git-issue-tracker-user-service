package io.github.hmnshgpt455.gitissuetrackeruserservice.mapper;

import io.github.hmnshgpt455.common.model.RoleDTO;
import io.github.hmnshgpt455.gitissuetrackeruserservice.domain.Role;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface RoleMapper {

    Role roleDtoToRole(RoleDTO roleDTO);
    RoleDTO roleToRoleDto(Role role);
}
