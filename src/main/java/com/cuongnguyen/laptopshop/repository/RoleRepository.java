package com.cuongnguyen.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cuongnguyen.laptopshop.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
