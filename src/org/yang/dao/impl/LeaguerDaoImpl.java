package org.yang.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.yang.dao.LeaguerDAO;
import org.yang.javabeans.Leaguer;
import org.yang.javabeans.Vip;

/**
 * LeaguerDAO�ӿڵ�ʵ��
 * ����ʱ��:2017��8��10�� ����3:02:38
 * ����޸���:���Ĳ�
 * ����޸�ʱ��:2017��8��14�� ����9:35:38
 * @author ����Ե
 */
public class LeaguerDaoImpl implements LeaguerDAO{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public Leaguer getUserById(String openid) {
		// TODO Auto-generated method stub
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("openId", openid);
		DetachedCriteria dc = DetachedCriteria.forClass(Leaguer.class);
		dc.add(Restrictions.allEq(paramMap));
		
		@SuppressWarnings("unchecked")
		List<Leaguer> leaguerList = (List<Leaguer>) hibernateTemplate.findByCriteria(dc);
		
		return leaguerList.get(0);
	}

	@Override
	public void add(Leaguer leaguer) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(leaguer);
	}

	@Override
	public void Eidt(Leaguer leaguer) {
		// TODO Auto-generated method stub
		hibernateTemplate.merge(leaguer);
	}

	@Override
	public void Delete(Leaguer leaguer) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(leaguer);
	}

	@Override
	public List<Leaguer> QueryAll() {
		// TODO Auto-generated method stub
		List<Leaguer> leaguerList = hibernateTemplate.loadAll(Leaguer.class);
		return leaguerList;
	}

	@Override
	public List<Leaguer> QueryByParam(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		DetachedCriteria dc = DetachedCriteria.forClass(Leaguer.class);
		dc.add(Restrictions.allEq(paramMap));
		
		@SuppressWarnings("unchecked")
		List<Leaguer> leaguerList = (List<Leaguer>) hibernateTemplate.findByCriteria(dc);
		return leaguerList;
	}


}
