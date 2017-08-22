package org.yang.dao;

import java.util.List;
import java.util.Map;

import org.yang.javabeans.LeaguerLog;

/**
 * @author yangwc
 * @function LeaguerLog的Dao类接口
 */
public interface LeaguerlogDAO {

	/**
	 * @function 添加日志记录
	 * @param leaguerLog
	 */
	public void add(LeaguerLog leaguerLog);
	
	/**
	 * @function 查询所有日志记录
	 */
	public List<LeaguerLog> seletAll();
	
	/**
	 * @function 查询自己的日志记录（openId）
	 * @param openId
	 */
	public List<LeaguerLog> seletLogByOpenId(String openId);
	
	/**
	 * @function log的条件查询
	 * @param paramMap<K,V>
	 */
	public List<LeaguerLog> seletLogByCondition(Map<String,Object> paramMap,String lo,String hi);
}
