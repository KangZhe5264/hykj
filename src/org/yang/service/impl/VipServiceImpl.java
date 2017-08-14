package org.yang.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yang.dao.VipDao;
import org.yang.javabeans.Vip;
import org.yang.service.VipService;

/**
 * @author   杨文昌
 * @function VipService接口类的实现
 */
@Service
@Transactional
public class VipServiceImpl implements VipService{

	@Autowired
	private VipDao vipDao;

	@Override
	public void create(Vip vip) {
		// TODO Auto-generated method stub
		vipDao.insert(vip);
	}

	@Override
	public void modify(Vip vip) {
		// TODO Auto-generated method stub
		vipDao.edit(vip);
	}

	@Override
	public void removeVip(Vip vip) {
		// TODO Auto-generated method stub
		vipDao.delete(vip);
	}

	@Override
	public List<Vip> QueryAll() {
		// TODO Auto-generated method stub
		List<Vip> vipList = vipDao.selectAll();
		return vipList;
	}

	@Override
	public List<Vip> QueryByCondition(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		List<Vip> vipList = vipDao.selectByParam(paramMap);
		return vipList;
	}
}
