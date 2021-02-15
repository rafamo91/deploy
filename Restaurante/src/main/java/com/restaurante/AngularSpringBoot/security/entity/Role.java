package com.restaurante.AngularSpringBoot.security.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.restaurante.AngularSpringBoot.security.enums.RoleName;
import com.sun.istack.NotNull;

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	@Enumerated(EnumType.STRING)
	private RoleName roleName;
	
	public Role() {
	}

	public Role(int id, RoleName roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}
	
	public Role(RoleName roleName) {
		this.roleName = roleName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RoleName getRoleName() {
		return roleName;
	}

	public void setRoleName(RoleName roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + "]";
	}
	
	
	
	
	

}
