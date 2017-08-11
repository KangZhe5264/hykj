package org.yang.formbeans;
/**
 * ����һ�������¼�Լ���������ϵͳ�Ķ���״̬���������
 * ����ʱ��:2017��8��9�� ����5:24:41
 * ����޸���:����Ե
 * ����޸�ʱ��:2017��8��9�� ����5:24:41
 * @author ����Ե
 */
public class HouseAndOrder {

	private String type = "";//�����������͵�����
	private double price;//�������͵ļ۸�
	private int option;//�������Ͳ���
	private String serial;//ң�����Ķ���������ֵ
	private String check_num = "";//��Ӧ��������֤��
	private String requestBody = "";//����ʱ��
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getOption() {
		return option;
	}
	public void setOption(int option) {
		this.option = option;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getCheck_num() {
		return check_num;
	}
	public void setCheck_num(String check_num) {
		this.check_num = check_num;
	}
	public String getRequestBody() {
		return requestBody;
	}
	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}

	public boolean testType()
	{
		return !(this.type == null || "".equals(type));
	}
	public boolean testPrice()
	{
		return this.price > 0;
	}
	public boolean testOption()
	{
		return !(1 == this.option || 0 == this.option);
	}
	public boolean testSerial()
	{
		return !(this.serial == null || "".equals(this.serial));
	}
	public boolean testCheck_num()
	{
		return !(this.check_num == null || "".equals(this.check_num));
	}
	public boolean testRequestBody()
	{
		return !(this.requestBody == null || "".equals(this.requestBody));
	}
	
	
	public boolean testForAddHouse()
	{
		if(!this.testType()) return false;
		if(!this.testPrice()) return false;
		
		return true;
	}
	
	public boolean testForAuditing()
	{
		if(!this.testOption()) return false;
		if(!this.testSerial()) return false;
		
		return true;
	}
	
	public boolean testForBackOrder() {
		// TODO Auto-generated method stub
		if(!this.testOption()) return false;
		if(!this.testSerial()) return false;
		if(!this.testCheck_num()) return false;
		
		return true;
	}
}
