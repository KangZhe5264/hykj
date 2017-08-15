package org.yang.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.yang.javabeans.LeaguerLog;

/**
 * @author yangwc
 * @function LeaguerLog的Service接口类
 */
public interface LeaguerLogService {

	/**
	 * @return List<LeaguerLog>
	 * @function 查询全部记录
	 */
	public List<LeaguerLog> queryAll();
	
	/**
	 * @param openId 
	 * @return List<LeaguerLog>
	 * @function 查询用户个人的记录
	 */
	public List<LeaguerLog> queryMine(String openId);
	
	/**
	 * @param paramMap 
	 * @return List<LeaguerLog>
	 * @function 用户记录的条件查询
	 */
	public List<LeaguerLog> queryByCondition(Map<String,Object> paramMap,String lo,String hi);
}
