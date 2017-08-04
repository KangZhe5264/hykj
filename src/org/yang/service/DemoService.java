package org.yang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yang.dao.HouseDAO;
import org.yang.javabeans.House;

@Service
@Transactional
public class DemoService {
	
	@Autowired
	private HouseDAO houseDao;
	
	public List<House> demo()
	{
		return houseDao.selectAll();
	}
}
