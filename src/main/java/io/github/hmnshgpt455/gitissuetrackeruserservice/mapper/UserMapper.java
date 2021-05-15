package io.github.hmnshgpt455.gitissuetrackeruserservice.mapper;

import io.github.hmnshgpt455.common.model.UserDTO;
import io.github.hmnshgpt455.gitissuetrackeruserservice.domain.User;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class, RoleMapper.class, ProjectMapper.class, OrganizationMapper.class})
public interface UserMapper {

    User userDtoToUser(UserDTO userDTO);
    UserDTO userToUserDto(User user);

}
