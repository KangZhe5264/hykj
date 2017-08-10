package org.yang.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.yang.javabeans.House;

@Repository
public class HouseDAO {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public List<House> selectAll()
	{
		return hibernateTemplate.loadAll(House.class);
	}
}
