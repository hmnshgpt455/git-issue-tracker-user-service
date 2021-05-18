package io.github.hmnshgpt455.gitissuetrackeruserservice.services.authentication;

import io.github.hmnshgpt455.common.responses.AvailabilityResponse;

public interface UserAuthenticationService {

    AvailabilityResponse checkUsernameAvailability(String username);
}
