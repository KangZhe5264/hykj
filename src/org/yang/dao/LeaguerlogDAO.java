package org.yang.dao;

import java.util.List;
import java.util.Map;

import org.yang.javabeans.LeaguerLog;

/**
 * @author yangwc
 * @function LeaguerLog��Dao��ӿ�
 */
public interface LeaguerlogDAO {

	/**
	 * @function �����־��¼
	 * @param leaguerLog
	 */
	public void add(LeaguerLog leaguerLog);
	
	/**
	 * @function ��ѯ������־��¼
	 */
	public List<LeaguerLog> seletAll();
	
	/**
	 * @function ��ѯ�Լ�����־��¼��openId��
	 * @param openId
	 */
	public List<LeaguerLog> seletLogByOpenId(String openId);
	
	/**
	 * @function log��������ѯ
	 * @param paramMap<K,V>
	 */
	public List<LeaguerLog> seletLogByCondition(Map<String,Object> paramMap,String lo,String hi);
}
