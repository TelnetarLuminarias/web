package com.telnetar.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long pk;

	private byte enabled;

	private String password;

	private String username;

	//bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy="user")
	private List<UserRole> userRoles;

	//bi-directional many-to-one association to UserSystem
	@OneToMany(mappedBy="user")
	private List<UserSystem> userSystems;

	public User() {
	}

	public Long getPk() {
		return this.pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}

	public byte getEnabled() {
		return this.enabled;
	}

	public void setEnabled(byte enabled) {
		this.enabled = enabled;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRole addUserRole(UserRole userRole) {
		getUserRoles().add(userRole);
		userRole.setUser(this);

		return userRole;
	}

	public UserRole removeUserRole(UserRole userRole) {
		getUserRoles().remove(userRole);
		userRole.setUser(null);

		return userRole;
	}

	public List<UserSystem> getUserSystems() {
		return this.userSystems;
	}

	public void setUserSystems(List<UserSystem> userSystems) {
		this.userSystems = userSystems;
	}

	public UserSystem addUserSystem(UserSystem userSystem) {
		getUserSystems().add(userSystem);
		userSystem.setUser(this);

		return userSystem;
	}

	public UserSystem removeUserSystem(UserSystem userSystem) {
		getUserSystems().remove(userSystem);
		userSystem.setUser(null);

		return userSystem;
	}

}