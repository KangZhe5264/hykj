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
 * House entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "house", catalog = "hotel")

public class House implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -168857855349638657L;
	private Integer id;
	private String type;
	private Boolean state;
	private Double price;
	private Set<HouseOrder> houseOrders = new HashSet<HouseOrder>(0);

	// Constructors

	/** default constructor */
	public House() {
	}

	/** minimal constructor */
	public House(String type, Boolean state, Double price) {
		this.type = type;
		this.state = state;
		this.price = price;
	}

	/** full constructor */
	public House(String type, Boolean state, Double price, Set<HouseOrder> houseOrders) {
		this.type = type;
		this.state = state;
		this.price = price;
		this.houseOrders = houseOrders;
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

	@Column(name = "type", nullable = false)

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "state", nullable = false)

	public Boolean getState() {
		return this.state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	@Column(name = "price", nullable = false, precision = 10)

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "house")

	public Set<HouseOrder> getHouseOrders() {
		return this.houseOrders;
	}

	public void setHouseOrders(Set<HouseOrder> houseOrders) {
		this.houseOrders = houseOrders;
	}

}