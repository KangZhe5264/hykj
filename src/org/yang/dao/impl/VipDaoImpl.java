package org.yang.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.yang.dao.VipDao;
import org.yang.javabeans.Vip;

/**
 * @author   杨文昌
 * @function VipDao接口类的实现
 */
@Repository
public class VipDaoImpl implements VipDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void insert(Vip vip) {
		hibernateTemplate.save(vip);
	}

	@Override
	public void edit(Vip vip) {
		// TODO Auto-generated method stub
		hibernateTemplate.merge(vip);
	}

	@Override
	public void delete(Vip vip) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(vip);
	}

	@Override
	public List<Vip> selectAll() {
		// TODO Auto-generated method stub
		List<Vip> vipList = hibernateTemplate.loadAll(Vip.class);
		return vipList;
	}

	@Override
	public List<Vip> selectByParam(Map<String,Object> paramMap) {
		// TODO Auto-generated method stub
		DetachedCriteria dc = DetachedCriteria.forClass(Vip.class);
		dc.add(Restrictions.allEq(paramMap));
		
		@SuppressWarnings("unchecked")
		List<Vip> vipList = (List<Vip>) hibernateTemplate.findByCriteria(dc);
		
		return vipList;
	}

	@Override
	public void saveOrUpdate(Vip vip) {
		// TODO Auto-generated method stub
		hibernateTemplate.saveOrUpdate(vip);
	}

}
