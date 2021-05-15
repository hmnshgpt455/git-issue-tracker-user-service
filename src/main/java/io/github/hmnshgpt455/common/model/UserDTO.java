package io.github.hmnshgpt455.common.model;

import io.github.hmnshgpt455.gitissuetrackeruserservice.domain.Organization;
import io.github.hmnshgpt455.gitissuetrackeruserservice.domain.Project;
import io.github.hmnshgpt455.gitissuetrackeruserservice.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable  {

    static final long serialVersionUID = -4133151599555050916L;

    @Null
    private UUID id = null;

    @Null
    private Long version = null;

    @Null
    private OffsetDateTime createdDate = null;

    @Null
    private OffsetDateTime lastModifiedDate = null;

    @NotNull
    private String firstName;
    private String lastName;

    @NotNull
    private String username;

    @NotNull
    private String email;

    @NotNull
    private RoleDTO role;

    @NotNull
    private OrganizationDTO organization;

    private Set<ProjectDTO> projects = new HashSet<>();

}
