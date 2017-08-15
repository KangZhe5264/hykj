package org.yang.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.yang.javabeans.LeaguerLog;

/**
 * @author yangwc
 * @function LeaguerLog��Service�ӿ���
 */
public interface LeaguerLogService {

	/**
	 * @return List<LeaguerLog>
	 * @function ��ѯȫ����¼
	 */
	public List<LeaguerLog> queryAll();
	
	/**
	 * @param openId 
	 * @return List<LeaguerLog>
	 * @function ��ѯ�û����˵ļ�¼
	 */
	public List<LeaguerLog> queryMine(String openId);
	
	/**
	 * @param paramMap 
	 * @return List<LeaguerLog>
	 * @function �û���¼��������ѯ
	 */
	public List<LeaguerLog> queryByCondition(Map<String,Object> paramMap,String lo,String hi);
}
