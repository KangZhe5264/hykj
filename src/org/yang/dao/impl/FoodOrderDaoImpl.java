package org.yang.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.yang.dao.FoodOrderDao;
import org.yang.javabeans.FoodOrder;
import org.yang.javabeans.Leaguer;


@Repository
public class FoodOrderDaoImpl implements FoodOrderDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	

	@Override
	public void add(FoodOrder foodOrder) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(foodOrder);
	}

	@Override
	public void Eidt(FoodOrder foodOrder) {
		// TODO Auto-generated method stub
		hibernateTemplate.merge(foodOrder);
	}

	@Override
	public List<FoodOrder> QueryAll(String department) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<FoodOrder> foodOrderList = (List<FoodOrder>) hibernateTemplate.find("from FoodOrder u where u.food_department_fk = ?", department);
		return foodOrderList;
	}

	public List<FoodOrder> QueryByParam(Map<String, Object> paramMap) {
		DetachedCriteria dc = DetachedCriteria.forClass(FoodOrder.class);
		dc.add(Restrictions.allEq(paramMap));
		
		@SuppressWarnings("unchecked")
		List<FoodOrder> foodOrderList = (List<FoodOrder>) hibernateTemplate.findByCriteria(dc);
		return foodOrderList;
	}

	@Override
	public Leaguer getUserById(String openid) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
