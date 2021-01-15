package com.yosra.authservice.service;

import com.yosra.authservice.entity.AppRole;
import com.yosra.authservice.entity.AppUser;
import com.yosra.authservice.repository.AppRoleRepo;
import com.yosra.authservice.repository.AppUserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final AppRoleRepo appRoleRepo;
    private final AppUserRepo appUserRepo;
    private final PasswordEncoder passwordEncoder;

    public AccountServiceImpl(AppRoleRepo appRoleRepo, AppUserRepo appUserRepo,
                              PasswordEncoder passwordEncoder) {
        this.appRoleRepo = appRoleRepo;
        this.appUserRepo = appUserRepo;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public AppUser addUser(AppUser user) {
        String pw = user.getPassword();
        user.setPassword(this.passwordEncoder.encode(pw));
        return appUserRepo.save(user);
    }

    @Override
    public AppRole addRole(AppRole role) {
        return appRoleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        AppUser appUser = appUserRepo.findByUserName(userName);
        AppRole appRole = appRoleRepo.findByName(roleName);
        appUser.getRoles().add(appRole);
    }

    @Override
    public AppUser loadUserByUserName(String userName) {
        return appUserRepo.findByUserName(userName);
    }

    @Override
    public List<AppUser> listUsers() {
        return appUserRepo.findAll();
    }
}
