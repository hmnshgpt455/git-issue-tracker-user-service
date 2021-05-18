package io.github.hmnshgpt455.gitissuetrackeruserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GitIssueTrackerUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GitIssueTrackerUserServiceApplication.class, args);
    }

}
