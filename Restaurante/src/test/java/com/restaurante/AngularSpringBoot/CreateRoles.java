package com.restaurante.AngularSpringBoot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.restaurante.AngularSpringBoot.security.entity.Role;
import com.restaurante.AngularSpringBoot.security.enums.RoleName;
import com.restaurante.AngularSpringBoot.security.service.RoleService;


@SpringBootTest
public class CreateRoles {
	
	@Autowired
	RoleService roleService;
	
	@Test
	public void create() {
		Role roleAdmin = new Role(RoleName.ROLE_ADMIN);
		Role roleUser = new Role(RoleName.ROLE_USER);
		
		roleService.save(roleUser); 
		roleService.save(roleAdmin); 
	}
	

}
