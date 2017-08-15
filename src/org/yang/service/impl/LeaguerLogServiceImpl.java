package org.yang.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yang.dao.LeaguerlogDAO;
import org.yang.javabeans.LeaguerLog;
import org.yang.service.LeaguerLogService;

/**
 * @author yangwc
 * @function leaguerService的实现类
 */
@Service
@Transactional
public class LeaguerLogServiceImpl implements LeaguerLogService{

	@Autowired
	private LeaguerlogDAO leaguerLogDao;
	
	@Override
	public List<LeaguerLog> queryAll() {
		// TODO Auto-generated method stub
		List<LeaguerLog> logs = leaguerLogDao.seletAll();
		return logs;
	}

	@Override
	public List<LeaguerLog> queryMine(String openId) {
		// TODO Auto-generated method stub
		List<LeaguerLog> logs = leaguerLogDao.seletLogByOpenId(openId);
		return logs;
	}

	@Override
	public List<LeaguerLog> queryByCondition(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		List<LeaguerLog> logs = leaguerLogDao.seletLogByCondition(paramMap);
		return logs;
	}

}
