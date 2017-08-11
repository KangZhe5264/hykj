package org.yang.formbeans;

/**
 * 前台会员进行订房时下的订单相关的信息
 * 创建时间:2017年8月9日 下午4:12:23
 * 最后修改人:杨殊缘
 * 最后修改时间:2017年8月9日 下午4:12:23
 * @author 杨殊缘
 */
public class Destine {

	private String contact_phone = "";//联系人电话
	private int house;//订单预定的房间类型
	private int quantity;//订单预定的房间数量
	private String arrive_time ="";//订单预计开始时间
	private String active_time = "";//订单预计持续时间
	private double amount;//订单消费总额
	private double price;//订单中每间房间的单价
	private String requestBody = "";//请求时间
	private String openid = "";//对应的订单主人
			
	public String getContact_phone() {
		return contact_phone;
	}


	public void setContact_phone(String contact_phone) {
		this.contact_phone = contact_phone;
	}


	public int getHouse() {
		return house;
	}


	public void setHouse(int house) {
		this.house = house;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getArrive_time() {
		return arrive_time;
	}


	public void setArrive_time(String arrive_time) {
		this.arrive_time = arrive_time;
	}


	public String getActive_time() {
		return active_time;
	}


	public void setActive_time(String active_time) {
		this.active_time = active_time;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getRequestBody() {
		return requestBody;
	}


	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}

	public String getOpenid() {
		return openid;
	}


	public void setOpenid(String openid) {
		this.openid = openid;
	}


	public boolean testContact_phone()
	{
		return !(this.contact_phone == null || "".equals(this.contact_phone));
	}
	
	public boolean testHouse()
	{
		return this.house > 0;
	}
	public boolean testQuantity()
	{
		return this.quantity > 0;
	}
	public boolean testArrive_time()
	{
		return !(this.arrive_time == null || "".equals(this.arrive_time));
	}
	public boolean testActive_time()
	{
		return !(this.active_time == null || "".equals(this.active_time));
	}
	public boolean testAmount()
	{
		return this.amount > 0;
	}
	public boolean testPrice()
	{
		return this.price > 0;
	}
	public boolean testrequestBody()
	{
		return !(this.requestBody == null || "".equals(this.requestBody));
	}
	
	private boolean testOpenid() {
		// TODO Auto-generated method stub
		return !(this.openid == null || "".equals(this.openid));
	}

	public boolean testForDestine()
	{
		if(!this.testActive_time())return false;
		if(!this.testAmount())return false;
		if(!this.testArrive_time())return false;
		if(!this.testContact_phone())return false;
		if(!this.testHouse())return false;
		if(!this.testPrice())return false;
		if(!this.testQuantity())return false;
		if(!this.testOpenid())return false;
		
		if(this.getAmount() != this.getPrice() * this.getQuantity()) return false;
		return true;
		
	}
	
	public boolean testForChangeHouse()
	{
		if(!this.testPrice()) return false;
		if(!this.testHouse()) return false;
		
		return true;
	}
}
