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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1988395585317474271L;
	private String userName;
	private String serial;
	private String food_department_fk;
	private String arriveTime;
	private String auditing;
	private String obligate;
	private String contactPhone;
	private String quantity;
	private String openid;

	// Constructors

	/** default constructor */
	public FoodOrder() {
	}

	/** full constructor */
	public FoodOrder(String userName, String serial, String food_department_fk, String arriveTime, String auditing,
			String obligate, String contactPhone, String quantity,String openid) {
		super();
		this.userName = userName;
		this.serial = serial;
		this.food_department_fk = food_department_fk;
		this.arriveTime = arriveTime;
		this.auditing = auditing;
		this.obligate = obligate;
		this.contactPhone = contactPhone;
		this.quantity = quantity;
		this.openid=openid;
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
	@Column(name = "user_name", nullable = false)
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getObligate() {
		return this.obligate;
	}

	public void setObligate(String obligate) {
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

	public String getQuantity() {
		return this.quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	@Column(name = "food_department_fk", nullable = false)
	public String getFood_department_fk() {
		return food_department_fk;
	}
	
	public void setFood_department_fk(String food_department_fk) {
		this.food_department_fk = food_department_fk;
	}
	@Column(name = "openid", nullable = true)
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
	

}