package io.github.hmnshgpt455.common.model.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailabilityResponse {

    private Boolean isAvailable;
}
