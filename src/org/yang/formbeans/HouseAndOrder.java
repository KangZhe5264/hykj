package org.yang.formbeans;
/**
 * 新增一条房间记录以及操作订房系统的订单状态的请求参数
 * 创建时间:2017年8月9日 下午5:24:41
 * 最后修改人:杨殊缘
 * 最后修改时间:2017年8月9日 下午5:24:41
 * @author 杨殊缘
 */
public class HouseAndOrder {

	private String type = "";//新增房间类型的名称
	private double price;//房间类型的价格
	private int option;//操作类型参数
	private String serial;//遥操作的订单的主键值
	private String check_num = "";//对应操作的验证码
	private String requestBody = "";//请求时间
	
	
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
