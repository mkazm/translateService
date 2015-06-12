package com.kazm.translate.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/**
 * @author mateusz.kazmierski 12 cze 2015
 */
@Entity
@Table(name = "balance_table")
public class BalanceHistoryModel extends BaseModel {

	private static final long serialVersionUID = -7552812240986328770L;
	@NotNull
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime dateStamp;
	@NotNull
	private BigDecimal balance;
	@NotNull
	private BigDecimal operation;
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private UserModel user;

	public DateTime getDateStamp() {
		return dateStamp;
	}

	public void setDateStamp(DateTime dateStamp) {
		this.dateStamp = dateStamp;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getOperation() {
		return operation;
	}

	public void setOperation(BigDecimal operation) {
		this.operation = operation;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

}
