package io.github.hmnshgpt455.gitissuetrackeruserservice.bootstrap;

import io.github.hmnshgpt455.gitissuetrackeruserservice.domain.Organization;
import io.github.hmnshgpt455.gitissuetrackeruserservice.domain.Project;
import io.github.hmnshgpt455.gitissuetrackeruserservice.domain.Role;
import io.github.hmnshgpt455.gitissuetrackeruserservice.domain.User;
import io.github.hmnshgpt455.gitissuetrackeruserservice.repositories.OrganizationRepository;
import io.github.hmnshgpt455.gitissuetrackeruserservice.repositories.ProjectRepository;
import io.github.hmnshgpt455.gitissuetrackeruserservice.repositories.RoleRepository;
import io.github.hmnshgpt455.gitissuetrackeruserservice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class UserBootstrap implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final OrganizationRepository organizationRepository;
    private final ProjectRepository projectRepository;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findAll().isEmpty()) {
            Organization organization = Organization.builder()
                    .name("Mindtree")
                    .build();
            Organization organization1 = Organization.builder()
                    .name("Amdocs")
                    .build();
            Organization organization2 = Organization.builder()
                    .name("Paytm")
                    .build();

            organizationRepository.save(organization);
            organizationRepository.save(organization1);
            organizationRepository.save(organization2);

            Role role = Role.builder()
                    .name("PMO")
                    .build();
            roleRepository.save(role);
            Set<Role> roles = new HashSet<>();
            roles.add(role);
            Project project1 = Project.builder()
                    .projectName("VFIT")
                    .build();
            Project project2 = Project.builder()
                    .projectName("VFRO")
                    .build();
            Project project3 = Project.builder()
                    .projectName("TEF ARF")
                    .build();
            Project project4 = Project.builder()
                    .projectName("Maxis")
                    .build();

            projectRepository.save(project1);
            projectRepository.save(project2);
            projectRepository.save(project3);
            projectRepository.save(project4);

            Set<Project> projects1 = new HashSet<>();
            projects1.add(project1);
            projects1.add(project2);
            projects1.add(project3);

            Set<Project> projects2 = new HashSet<>();
            projects2.add(project3);
            projects2.add(project4);
            userRepository.save(User.builder()
                    .roles(roles)
                    .organization(organization)
                    .email("ss@ss.com")
                    .firstName("Himanshu")
                    .lastName("Gupta")
                    .username("hmnshgpt455")
                    .projects(projects1)
                    .build());

            User user = userRepository.save(User.builder()
                    .roles(roles)
                    .organization(organization)
                    .email("bujho@bujho.com")
                    .firstName("Bujho")
                    .lastName("Jiji")
                    .username("bujho")
                    .projects(projects2)
                    .build());
        }
    }
}
