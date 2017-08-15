package org.yang.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.yang.dao.LeaguerlogDAO;
import org.yang.javabeans.Leaguer;
import org.yang.javabeans.LeaguerLog;

@Repository
public class LeaguerlogDAOImpl implements LeaguerlogDAO{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void add(LeaguerLog leaguerLog) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(leaguerLog);
	}

	@Override
	public List<LeaguerLog> seletAll() {
		// TODO Auto-generated method stub
		List<LeaguerLog> logs = hibernateTemplate.loadAll(LeaguerLog.class);
		return logs;
	}

	@Override
	public List<LeaguerLog> seletLogByOpenId(String openId) {
		// TODO Auto-generated method stub
		
		Leaguer leaguer = new Leaguer();
		leaguer.setOpenId(openId);
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("leaguer", leaguer);
		DetachedCriteria dc = DetachedCriteria.forClass(Leaguer.class);
		dc.add(Restrictions.allEq(paramMap));
		
		@SuppressWarnings("unchecked")
		List<LeaguerLog> logs = (List<LeaguerLog>)hibernateTemplate.findByCriteria(dc);
		return logs;
	}

	@Override
	public List<LeaguerLog> seletLogByCondition(Map<String, Object> paramMap,String lo,String hi) {
		// TODO Auto-generated method stub
		
		String hql = "from LeaguerLog where 1=1";
		Set<String> keys = paramMap.keySet();
		for(String key : keys){
			hql += "and" + key + "= '" + paramMap.get(key) +"'";
		}
		if(!"".equals(lo) && lo != null){
			hql += "and" + "createTime > '" + lo + "'";
		}
		if(!"".equals(hi) && hi != null){
			hql += "and" + "createTime < '" + hi + "'";
		}
		@SuppressWarnings("unchecked")
		List<LeaguerLog> logs = (List<LeaguerLog>) hibernateTemplate.find(hql, "");
		
		return logs;
	}

}
