package org.yang.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.yang.dao.impl.HouseDaoImpl;
import org.yang.javabeans.House;

@Repository
public class HouseDAO implements HouseDaoImpl{

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public List<House> selectByCriteria(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		//排除空参数的影响
		if(criteria == null)return null;
		return (List<House>) hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public House selectById(int house) {
		// TODO Auto-generated method stub
		//排除空参数的影响
		if(house <= 0) return null;
		return hibernateTemplate.load(House.class, house);
	}

	@Override
	public void update(House house) {
		// TODO Auto-generated method stub
		//排除空参数的影响
		if(house == null) return;
		//排除不规范对象的存在
		if(house.getId() <= 0 || house.getType() == null || "".equals(house.getType()) || house.getPrice() <= 0 || house.getState() == null) return;
		
		hibernateTemplate.update(house);
	}

	@Override
	public void insert(House house) {
		// TODO Auto-generated method stub
		//排除空参数的影响
		if(house == null) return;
		//排除不规范对象的存在
		if(house.getType() == null || "".equals(house.getType()) || house.getPrice() <= 0 || house.getState() == null) return;
		
		hibernateTemplate.save(house);
	}
	
	
}
