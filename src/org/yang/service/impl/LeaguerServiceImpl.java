package org.yang.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yang.dao.LeaguerDAO;
import org.yang.javabeans.Leaguer;
import org.yang.service.LeaguerService;

/**
 * �Ի�Ա���и�������ط���
 * ����ʱ��:2017��8��11�� ����3:39:36
 * ����޸���:yangwc
 * ����޸�ʱ��:2017��8��14�� ����9:58:36
 * @author ����Ե
 */

@Service
@Transactional
public class LeaguerServiceImpl implements LeaguerService{

	@Autowired
	private LeaguerDAO leaguerDao;
	
	@Override
	public void create(Leaguer leaguer) {
		// TODO Auto-generated method stub
		leaguerDao.add(leaguer);
	}

	@Override
	public void modify(Leaguer leaguer) {
		// TODO Auto-generated method stub
		leaguerDao.Eidt(leaguer);
	}

	@Override
	public void removeLeaguer(Leaguer leaguer) {
		// TODO Auto-generated method stub
		leaguerDao.Delete(leaguer);
	}

	@Override
	public List<Leaguer> QueryAll() {
		// TODO Auto-generated method stub
		List<Leaguer> leaguerList = leaguerDao.QueryAll();
		return leaguerList;
	}

	@Override
	public List<Leaguer> QueryByCondition(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		List<Leaguer> leaguerList = leaguerDao.QueryByParam(paramMap);
		return leaguerList;
	}

	/**
	 * add by ����Ե
	 * ͨ����Ա��openid�ҵ�ϵͳ�л�Ա��ӵ�е���Ϣ
	 * @param openid
	 * @return ��ϵͳ�еĻ�Աopenid��Ӧ����Ϣ��¼ȡ����
	 */
	@Override
	public Leaguer getUserByOpenid(String openid) {
		// TODO Auto-generated method stub
		Leaguer leaguer = leaguerDao.getUserById(openid);
		return leaguer;
	}

	@Override
	public void submit(Leaguer Leaguer) {
		// TODO Auto-generated method stub
		leaguerDao.SaveOrUpdate(Leaguer);
	}

}
