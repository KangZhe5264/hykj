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
 * HouseOrder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "house_order", catalog = "hotel")

public class HouseOrder implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2251765524378369472L;
	private String serail;
	private House house;
	private Leaguer leaguer;
	private String arriveTime;
	private String activeTime;
	private String auditing;
	private Boolean obligate;
	private String contactPhone;
	private Integer quantity;
	private Double amount;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public HouseOrder() {
	}

	/** full constructor */
	public HouseOrder(House house, Leaguer leaguer, String arriveTime, String activeTime, String auditing,
			Boolean obligate, String contactPhone, Integer quantity, Double amount, Timestamp createTime) {
		this.house = house;
		this.leaguer = leaguer;
		this.arriveTime = arriveTime;
		this.activeTime = activeTime;
		this.auditing = auditing;
		this.obligate = obligate;
		this.contactPhone = contactPhone;
		this.quantity = quantity;
		this.amount = amount;
		this.createTime = createTime;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "serail", unique = true, nullable = false)

	public String getSerail() {
		return this.serail;
	}

	public void setSerail(String serail) {
		this.serail = serail;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "house_fk", nullable = false)

	public House getHouse() {
		return this.house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "leaguer_fk", nullable = false)

	public Leaguer getLeaguer() {
		return this.leaguer;
	}

	public void setLeaguer(Leaguer leaguer) {
		this.leaguer = leaguer;
	}

	@Column(name = "arrive_time", nullable = false, length = 300)

	public String getArriveTime() {
		return this.arriveTime;
	}

	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}

	@Column(name = "active_time", nullable = false, length = 300)

	public String getActiveTime() {
		return this.activeTime;
	}

	public void setActiveTime(String activeTime) {
		this.activeTime = activeTime;
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

	@Column(name = "amount", nullable = false, precision = 12)

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Column(name = "create_time", nullable = false, length = 19)

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}