package com.kazm.translate.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_role")
public class RoleModel extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	@ManyToOne
    @JoinColumn(name = "user_id")
	private UserModel user;
	private String Role;	
	
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}
	
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}

}
