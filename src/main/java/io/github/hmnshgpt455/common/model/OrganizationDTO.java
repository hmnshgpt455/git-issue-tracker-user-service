package io.github.hmnshgpt455.common.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrganizationDTO implements Serializable {

    static final long serialVersionUID = 7169114938335381426L;

    @Null
    private UUID id = null;

    @Null
    private Long version = null;

    @Null
    private OffsetDateTime createdDate = null;

    @Null
    private OffsetDateTime lastModifiedDate = null;

    @NotNull
    private String name;

}
