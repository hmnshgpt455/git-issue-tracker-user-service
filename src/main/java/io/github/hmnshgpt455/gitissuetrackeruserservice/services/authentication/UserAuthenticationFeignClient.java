package io.github.hmnshgpt455.gitissuetrackeruserservice.services.authentication;

import io.github.hmnshgpt455.common.responses.AvailabilityResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "authentication-service")
public interface UserAuthenticationFeignClient {

    @GetMapping(path = "/api/v1/authentication/username/{username}/availability")
    AvailabilityResponse checkUsernameAvailability(@PathVariable("username") String username);
}
