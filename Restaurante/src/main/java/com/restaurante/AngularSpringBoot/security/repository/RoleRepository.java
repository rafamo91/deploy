package com.restaurante.AngularSpringBoot.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurante.AngularSpringBoot.security.entity.Role;
import com.restaurante.AngularSpringBoot.security.enums.RoleName;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	Optional<Role> findByRoleName(RoleName roleName);

}
