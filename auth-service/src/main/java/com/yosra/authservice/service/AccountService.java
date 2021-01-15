package com.yosra.authservice.service;

import com.yosra.authservice.entity.AppRole;
import com.yosra.authservice.entity.AppUser;

import java.util.List;

public interface AccountService {

    AppUser addUser(AppUser user);

    AppRole addRole(AppRole role);

    void addRoleToUser(String userName, String roleName);

    AppUser loadUserByUserName(String userName);

    List<AppUser> listUsers();

}
