package com.abc.buoi2.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_users")
public class User extends BaseEntity {
	@Column(name = "username", length = 45,  nullable = false)
	private String  username;
	
	@Column(name = "password", length = 100,  nullable = false)
	private String  password;
	
	@Column(name = "email", length = 45,  nullable = false)
	private String  email;
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "users")
	private List<Role> roles = new ArrayList<Role>();
	
	public void addRoles(Role role) {
		role.getUsers().add(this);
		roles.add(role);
	}
	
	public void deleteRoles(Role role) {
		role.getUsers().remove(this);
		roles.remove(role);
	}
}
