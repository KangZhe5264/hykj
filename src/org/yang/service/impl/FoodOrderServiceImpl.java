package org.yang.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yang.dao.FoodOrderDao;
import org.yang.javabeans.FoodOrder;
import org.yang.javabeans.Leaguer;
import org.yang.service.FoodOrderService;


@Service
@Transactional
public class FoodOrderServiceImpl implements FoodOrderService{

	@Autowired
	private FoodOrderDao foodOrderDao;
	
	@Override
	public void create(FoodOrder foodOrder) {
		// TODO Auto-generated method stub
		foodOrderDao.add(foodOrder);
	}
	
	@Override
	public void modify(FoodOrder foodOrder) {
		// TODO Auto-generated method stub
		foodOrderDao.Eidt(foodOrder);
	}

	
	@Override
	public List<FoodOrder> QueryAll(String department) {
		// TODO Auto-generated method stub
		List<FoodOrder> foodOrderList = foodOrderDao.QueryAll(department);
		return foodOrderList;
	}



	@Override
	public Leaguer getUserByOpenid(String openid) {
		// TODO Auto-generated method stub
		Leaguer leaguer=foodOrderDao.getUserById(openid);
		return leaguer;
	}

	@Override
	public List<FoodOrder> QueryByCondition(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		List<FoodOrder> foodOrderList = foodOrderDao.QueryByParam(paramMap);
		return foodOrderList;
	}

}
