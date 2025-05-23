package com.buddhaditya.userauth.services.roles;

import com.buddhaditya.userauth.entities.Role;
import com.buddhaditya.userauth.repository.interfaces.RoleRepository;
import com.buddhaditya.userauth.utils.LoggerUtil;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class RoleInitializer {

    private final RoleRepository roleRepository;

    public RoleInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void initRoles() {
        List<String> defaultRoles = Arrays.asList("USER", "ADMIN", "MODERATOR");

        for (String roleName : defaultRoles) {
            if (roleRepository.findByName(roleName).isEmpty()) {
                Role role = new Role();
                role.setName(roleName);
                roleRepository.save(role);
                LoggerUtil.info("Initialized default role: " + roleName);
            }
        }
    }
}
