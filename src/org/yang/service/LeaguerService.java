package org.yang.service;

import java.util.List;
import java.util.Map;

import org.yang.javabeans.Leaguer;

/**
 * @author   ���Ĳ�
 * @function Leaguer��Service�ӿ���
 */

public interface LeaguerService {

	/**  
	 *   Add by yangwc 
	 *   @function ������Ա
	 *   @param Leaguer
	 */
	public void create(Leaguer Leaguer);
	
	/**  
	 *   Add by yangwc 
	 *   @function �޸Ļ�Ա
	 *   @param Leaguer
	 */
	public void modify(Leaguer Leaguer);
	
	/**  
	 *   Add by yangwc 
	 *   @function ��Ա��Ϣ�ύ���޸ĺ�������
	 *   @param Leaguer
	 */
	public void submit(Leaguer Leaguer);
	
	/**  
	 *   Add by yangwc 
	 *   @function ɾ����Ա
	 *   @param Leaguer
	 */
	public void removeLeaguer(Leaguer Leaguer);
	
	/**  
	 *   Add by yangwc 
	 *   @function ��ѯȫ���Ļ�Ա
	 *   @return List<Leaguer>
	 */
	public List<Leaguer> QueryAll();
	
	
	/**  
	 *   Add by yangwc 
	 *   @function ������ѯ
	 *   @param paramMap<�ֶ���,ֵ>
	 *   @return List<Leaguer>
	 */
	public List<Leaguer> QueryByCondition(Map<String,Object> paramMap);
	
	/**  
	 *   Add by ����Ե
	 *   @function ����openid��ѯ��Ա��Ϣ
	 *   @param paramMap<K,V>
	 *   @return Leaguer
	 */
	public Leaguer getUserByOpenid(String openid);
	
}
