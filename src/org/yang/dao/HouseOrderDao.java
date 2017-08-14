package org.yang.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.yang.dao.impl.HouseOrderDaoImpl;
import org.yang.javabeans.HouseOrder;

@Repository
public class HouseOrderDao implements HouseOrderDaoImpl {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void insert(HouseOrder order) {
		// TODO Auto-generated method stub
		//排除空参数的影响
		if(order == null) return;
		if(		order.getHouse() == null || 
				order.getArriveTime() == null || "".equals(order.getArriveTime()) || 
				order.getActiveTime() == null || "".equals(order.getActiveTime()) || 
				order.getAuditing() == null || "".equals(order.getAuditing()) || 
				order.getObligate() == null || 
				order.getContactPhone() == null || "".equals(order.getContactPhone()) ||
				order.getQuantity() <= 0 || 
				order.getAmount() <= 0 || 
				order.getLeaguer() == null) return;
		
		hibernateTemplate.save(order);
	}

	@Override
	public HouseOrder selectOrderById(String serial) {
		// TODO Auto-generated method stub
		//排除空参数的影响
		if(serial == null || "".equals(serial)) return null;
		
		return hibernateTemplate.load(HouseOrder.class, serial);
	}

	@Override
	public void update(HouseOrder order) {
		// TODO Auto-generated method stub
		//排除空参数的影响
		if(order == null) return;
		if(		order.getSerail() == null || "".equals(order.getSerail()) ||
				order.getHouse() == null || 
				order.getArriveTime() == null || "".equals(order.getArriveTime()) || 
				order.getActiveTime() == null || "".equals(order.getActiveTime()) || 
				order.getAuditing() == null || "".equals(order.getAuditing()) || 
				order.getObligate() == null || 
				order.getContactPhone() == null || "".equals(order.getContactPhone()) ||
				order.getQuantity() <= 0 || 
				order.getAmount() <= 0 || 
				order.getLeaguer() == null) return;
		
		hibernateTemplate.update(order);
	}

	@Override
	public List<HouseOrder> selectOrderByCriteria(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		if(criteria == null) return null;
		return (List<HouseOrder>) hibernateTemplate.findByCriteria(criteria);
	}

}
