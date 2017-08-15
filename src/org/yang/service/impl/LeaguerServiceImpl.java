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
 * 对会员进行搞做的相关方法
 * 创建时间:2017年8月11日 下午3:39:36
 * 最后修改人:yangwc
 * 最后修改时间:2017年8月14日 下午9:58:36
 * @author 杨殊缘
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
	 * add by 杨殊缘
	 * 通过会员的openid找到系统中会员所拥有的信息
	 * @param openid
	 * @return 将系统中的会员openid对应的信息记录取出来
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
