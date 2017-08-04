package org.yang.javabeans;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Vip entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "vip", catalog = "hotel")

public class Vip implements java.io.Serializable {

	// Fields

	private Integer id;
	private String levalName;
	private String role;
	private Double landmark;
	private Set<Leaguer> leaguers = new HashSet<Leaguer>(0);

	// Constructors

	/** default constructor */
	public Vip() {
	}

	/** minimal constructor */
	public Vip(String levalName, Double landmark) {
		this.levalName = levalName;
		this.landmark = landmark;
	}

	/** full constructor */
	public Vip(String levalName, String role, Double landmark, Set<Leaguer> leaguers) {
		this.levalName = levalName;
		this.role = role;
		this.landmark = landmark;
		this.leaguers = leaguers;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "leval_name", nullable = false)

	public String getLevalName() {
		return this.levalName;
	}

	public void setLevalName(String levalName) {
		this.levalName = levalName;
	}

	@Column(name = "role")

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(name = "landmark", nullable = false, precision = 10)

	public Double getLandmark() {
		return this.landmark;
	}

	public void setLandmark(Double landmark) {
		this.landmark = landmark;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "vip")

	public Set<Leaguer> getLeaguers() {
		return this.leaguers;
	}

	public void setLeaguers(Set<Leaguer> leaguers) {
		this.leaguers = leaguers;
	}

}