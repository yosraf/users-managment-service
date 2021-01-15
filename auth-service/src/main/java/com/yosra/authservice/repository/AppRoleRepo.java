package com.yosra.authservice.repository;

import com.yosra.authservice.entity.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepo extends JpaRepository<AppRole, Long> {

    AppRole findByName(String name);
}
