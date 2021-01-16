package com.yosra.authservice;

import com.yosra.authservice.entity.AppRole;
import com.yosra.authservice.entity.AppUser;
import com.yosra.authservice.service.AccountServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import java.util.ArrayList;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class AuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(AccountServiceImpl service) {
        return args -> {
            AppRole role = new AppRole();
            role.setId(1L);
            role.setName("ADMIN");
            service.addRole(role);
            AppUser user = new AppUser();
            user.setId(1L);
            user.setUserName("yosra");
            user.setRoles(new ArrayList<>());
            user.setPassword("password");
            service.addUser(user);
            service.addRoleToUser("yosra", "ADMIN");
        };

    }

}
