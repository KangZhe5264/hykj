package org.yang.javabeans;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Leaguer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "leaguer", catalog = "hotel")

public class Leaguer implements java.io.Serializable {

	// Fields

	private String openId;
	private Vip vip;
	private String userPhone;
	private String userName;
	private Double balance;
	private Double history;
	private String userPwd;
	private Set<LeaguerLog> leaguerLogs = new HashSet<LeaguerLog>(0);

	// Constructors

	/** default constructor */
	public Leaguer() {
	}

	/** minimal constructor */
	public Leaguer(String openId, String userPhone, String userName, String userPwd) {
		this.openId = openId;
		this.userPhone = userPhone;
		this.userName = userName;
		this.userPwd = userPwd;
	}

	/** full constructor */
	public Leaguer(String openId, Vip vip, String userPhone, String userName, Double balance, Double history,
			String userPwd, Set<LeaguerLog> leaguerLogs) {
		this.openId = openId;
		this.vip = vip;
		this.userPhone = userPhone;
		this.userName = userName;
		this.balance = balance;
		this.history = history;
		this.userPwd = userPwd;
		this.leaguerLogs = leaguerLogs;
	}

	// Property accessors
	@Id

	@Column(name = "open_id", unique = true, nullable = false)

	public String getOpenId() {
		return this.openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "leval_fk")

	public Vip getVip() {
		return this.vip;
	}

	public void setVip(Vip vip) {
		this.vip = vip;
	}

	@Column(name = "user_phone", nullable = false, length = 35)

	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	@Column(name = "user_name", nullable = false, length = 50)

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "balance", precision = 10)

	public Double getBalance() {
		return this.balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Column(name = "history", precision = 28)

	public Double getHistory() {
		return this.history;
	}

	public void setHistory(Double history) {
		this.history = history;
	}

	@Column(name = "user_pwd", nullable = false, length = 60)

	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "leaguer")

	public Set<LeaguerLog> getLeaguerLogs() {
		return this.leaguerLogs;
	}

	public void setLeaguerLogs(Set<LeaguerLog> leaguerLogs) {
		this.leaguerLogs = leaguerLogs;
	}

}