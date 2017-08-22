package org.yang.dao;

import java.util.List;
import java.util.Map;

import org.yang.javabeans.FoodOrder;
import org.yang.javabeans.Leaguer;

public interface FoodOrderDao {

	public Leaguer getUserById(String openid);
	
	/**
	 * 娣诲姞璁㈤淇℃伅
	 * @param foodOrder
	 */
	public void add(FoodOrder foodOrder);
	/**
	 * 淇敼璁㈤鐘舵��
	 * @param foodOrder
	 */
	public void Eidt(FoodOrder foodOrder);
	
	
	
	/**
	 * 鍏ㄩ儴璁㈠崟
	 * @param foodOrder
	 */
	public List<FoodOrder> QueryAll(String department);

	public List<FoodOrder> QueryByParam(Map<String, Object> paramMap);

	
}
