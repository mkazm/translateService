package com.kazm.translate.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.kazm.translate.dict.RoleEnum;

@Entity
@Table(name = "user")
public class UserModel extends BaseModel {

	private static final long serialVersionUID = 1L;
	@NotNull
	@Size(min = 2, max = 14)
	private String username;
	@NotNull
	@Size(min = 60, max = 61)
	private String password;
	@NotNull
	@Size(min = 2, max = 45)
	private String email;
	@NotNull
	@Size(min = 1, max = 1)
	private String activated;
	private String hash;
	@NotNull
	@Size(min = 1, max = 1)
	private String level;
	@NotNull
	@Enumerated(EnumType.STRING)
	private RoleEnum mainRole;
	@NotNull
	private BigDecimal balance = new BigDecimal(0);

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

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

	public String getActivated() {
		return activated;
	}

	public void setActivated(String activated) {
		this.activated = activated;
	}

	public RoleEnum getMainRole() {
		return mainRole;
	}

	public void setMainRole(RoleEnum mainRole) {
		this.mainRole = mainRole;
	}

}
