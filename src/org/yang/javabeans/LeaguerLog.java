package org.yang.javabeans;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * LeaguerLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "leaguer_log", catalog = "hotel")

public class LeaguerLog implements java.io.Serializable {

	// Fields

	private String sequence;
	private Leaguer leaguer;
	private String type;
	private Double worths;
	private Timestamp createTime;
	private String info;

	// Constructors

	/** default constructor */
	public LeaguerLog() {
	}

	/** minimal constructor */
	public LeaguerLog(Leaguer leaguer, String type, Double worths, Timestamp createTime) {
		this.leaguer = leaguer;
		this.type = type;
		this.worths = worths;
		this.createTime = createTime;
	}

	/** full constructor */
	public LeaguerLog(Leaguer leaguer, String type, Double worths, Timestamp createTime, String info) {
		this.leaguer = leaguer;
		this.type = type;
		this.worths = worths;
		this.createTime = createTime;
		this.info = info;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "sequence", unique = true, nullable = false)

	public String getSequence() {
		return this.sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "leaguer_fk", nullable = false)

	public Leaguer getLeaguer() {
		return this.leaguer;
	}

	public void setLeaguer(Leaguer leaguer) {
		this.leaguer = leaguer;
	}

	@Column(name = "type", nullable = false, length = 10)

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "worths", nullable = false, precision = 10)

	public Double getWorths() {
		return this.worths;
	}

	public void setWorths(Double worths) {
		this.worths = worths;
	}

	@Column(name = "create_time", nullable = false, length = 19)

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "info", length = 600)

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}