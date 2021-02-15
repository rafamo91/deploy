package com.restaurante.AngularSpringBoot.security.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.AngularSpringBoot.security.entity.Role;
import com.restaurante.AngularSpringBoot.security.enums.RoleName;
import com.restaurante.AngularSpringBoot.security.repository.RoleRepository;

@Service
@Transactional
public class RoleService {
	
	@Autowired
	RoleRepository roleRepository;
	
	public void save(Role role) {
		roleRepository.save(role);
	}
	
	public Optional<Role> getByRoleName(RoleName roleName){
		return roleRepository.findByRoleName(roleName);
	}

}
