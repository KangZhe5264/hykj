package org.yang.formbeans;

/**
 * ǰ̨��Ա���ж���ʱ�µĶ�����ص���Ϣ
 * ����ʱ��:2017��8��9�� ����4:12:23
 * ����޸���:����Ե
 * ����޸�ʱ��:2017��8��9�� ����4:12:23
 * @author ����Ե
 */
public class Destine {

	private String contact_phone = "";//��ϵ�˵绰
	private int house;//����Ԥ���ķ�������
	private int quantity;//����Ԥ���ķ�������
	private String arrive_time ="";//����Ԥ�ƿ�ʼʱ��
	private String active_time = "";//����Ԥ�Ƴ���ʱ��
	private double amount;//���������ܶ�
	private double price;//������ÿ�䷿��ĵ���
	private String requestBody = "";//����ʱ��
	private String openid = "";//��Ӧ�Ķ�������
			
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
