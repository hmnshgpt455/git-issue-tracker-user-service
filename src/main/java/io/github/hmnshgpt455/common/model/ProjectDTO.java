package io.github.hmnshgpt455.common.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.hmnshgpt455.gitissuetrackeruserservice.domain.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectDTO implements Serializable {

    static final long serialVersionUID = 2940681203378312652L;

    @Null
    private UUID id = null;

    @Null
    private Long version = null;

    @Null
    private OffsetDateTime createdDate = null;

    @Null
    private OffsetDateTime lastModifiedDate = null;

    @NotNull
    private String projectName;
}
