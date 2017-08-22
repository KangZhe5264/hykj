package org.yang.service;

import java.util.List;
import java.util.Map;

import org.yang.javabeans.FoodOrder;
import org.yang.javabeans.Leaguer;

public interface FoodOrderService {

	public void create(FoodOrder foodOrder);
	
	public void modify(FoodOrder foodOrder);
	
	public List<FoodOrder> QueryAll(String department);
	
	public List<FoodOrder> QueryByCondition(Map<String,Object> paramMap);
	
	public Leaguer getUserByOpenid(String openid);
	
	
}
