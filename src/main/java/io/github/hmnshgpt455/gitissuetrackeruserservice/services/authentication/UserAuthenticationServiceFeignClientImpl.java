package io.github.hmnshgpt455.gitissuetrackeruserservice.services.authentication;

import io.github.hmnshgpt455.common.responses.AvailabilityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAuthenticationServiceFeignClientImpl implements UserAuthenticationService {

    private final UserAuthenticationFeignClient userAuthenticationFeignClient;

    @Override
    public AvailabilityResponse checkUsernameAvailability(String username) {
        return userAuthenticationFeignClient.checkUsernameAvailability(username);
    }
}
