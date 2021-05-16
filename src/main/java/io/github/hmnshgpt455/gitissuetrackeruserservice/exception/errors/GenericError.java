package io.github.hmnshgpt455.gitissuetrackeruserservice.exception.errors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericError {

    private String message;
    private Integer status;
    private OffsetDateTime timestamp;
}
