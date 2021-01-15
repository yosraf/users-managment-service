package com.yosra.authservice.web;

import com.yosra.authservice.dto.UserRoleDto;
import com.yosra.authservice.entity.AppRole;
import com.yosra.authservice.entity.AppUser;
import com.yosra.authservice.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(path = "/users")
    public List<AppUser> getUsers() {
        return this.accountService.listUsers();
    }

    @PostMapping(path = "/users")
    public AppUser saveUser(@RequestBody AppUser user) {
        return this.accountService.addUser(user);
    }

    @PostMapping(path = "/roles")
    public AppRole saveRole(@RequestBody AppRole role) {
        return this.accountService.addRole(role);
    }

    @PostMapping(path = "addrole")
    public void addRoleToUser(UserRoleDto userRoleDto) {
        this.accountService.addRoleToUser(userRoleDto.getUserName(), userRoleDto.getRoleName());
    }
}
