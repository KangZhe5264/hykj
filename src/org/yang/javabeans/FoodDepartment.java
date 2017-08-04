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
import javax.persistence.UniqueConstraint;

/**
 * FoodDepartment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "food_department", catalog = "hotel", uniqueConstraints = @UniqueConstraint(columnNames = { "manager",
		"mag_pwd" }) )

public class FoodDepartment implements java.io.Serializable {

	// Fields

	private Integer id;
	private String deptName;
	private String uri;
	private String manager;
	private String magPwd;
	private Set<FoodOrder> foodOrders = new HashSet<FoodOrder>(0);

	// Constructors

	/** default constructor */
	public FoodDepartment() {
	}

	/** minimal constructor */
	public FoodDepartment(String deptName, String manager, String magPwd) {
		this.deptName = deptName;
		this.manager = manager;
		this.magPwd = magPwd;
	}

	/** full constructor */
	public FoodDepartment(String deptName, String uri, String manager, String magPwd, Set<FoodOrder> foodOrders) {
		this.deptName = deptName;
		this.uri = uri;
		this.manager = manager;
		this.magPwd = magPwd;
		this.foodOrders = foodOrders;
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

	@Column(name = "dept_name", nullable = false)

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Column(name = "uri")

	public String getUri() {
		return this.uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	@Column(name = "manager", nullable = false, length = 40)

	public String getManager() {
		return this.manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	@Column(name = "mag_pwd", nullable = false, length = 30)

	public String getMagPwd() {
		return this.magPwd;
	}

	public void setMagPwd(String magPwd) {
		this.magPwd = magPwd;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "foodDepartment")

	public Set<FoodOrder> getFoodOrders() {
		return this.foodOrders;
	}

	public void setFoodOrders(Set<FoodOrder> foodOrders) {
		this.foodOrders = foodOrders;
	}

}