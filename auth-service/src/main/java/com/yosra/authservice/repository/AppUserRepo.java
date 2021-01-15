package com.yosra.authservice.repository;

import com.yosra.authservice.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {
    AppUser findByUserName(String userName);
}
