package org.yang.javabeans;

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
 * FoodOrder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "food_order", catalog = "hotel")

public class FoodOrder implements java.io.Serializable {

	// Fields

	private String serial;
	private FoodDepartment foodDepartment;
	private String arriveTime;
	private String auditing;
	private Boolean obligate;
	private String contactPhone;
	private Integer quantity;

	// Constructors

	/** default constructor */
	public FoodOrder() {
	}

	/** full constructor */
	public FoodOrder(FoodDepartment foodDepartment, String arriveTime, String auditing, Boolean obligate,
			String contactPhone, Integer quantity) {
		this.foodDepartment = foodDepartment;
		this.arriveTime = arriveTime;
		this.auditing = auditing;
		this.obligate = obligate;
		this.contactPhone = contactPhone;
		this.quantity = quantity;
	}

	// Property accessors
	@GenericGenerator(name = "demo1", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "demo1")

	@Column(name = "serial", unique = true, nullable = false)

	public String getSerial() {
		return this.serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "food_department_fk", nullable = false)

	public FoodDepartment getFoodDepartment() {
		return this.foodDepartment;
	}

	public void setFoodDepartment(FoodDepartment foodDepartment) {
		this.foodDepartment = foodDepartment;
	}

	@Column(name = "arrive_time", nullable = false, length = 300)

	public String getArriveTime() {
		return this.arriveTime;
	}

	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}

	@Column(name = "auditing", nullable = false, length = 2)

	public String getAuditing() {
		return this.auditing;
	}

	public void setAuditing(String auditing) {
		this.auditing = auditing;
	}

	@Column(name = "obligate", nullable = false)

	public Boolean getObligate() {
		return this.obligate;
	}

	public void setObligate(Boolean obligate) {
		this.obligate = obligate;
	}

	@Column(name = "contact_phone", nullable = false, length = 35)

	public String getContactPhone() {
		return this.contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	@Column(name = "quantity", nullable = false)

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}