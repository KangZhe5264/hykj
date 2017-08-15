package org.yang.dao;

import java.util.List;
import java.util.Map;

import org.yang.javabeans.Vip;

/**
 * @author   ���Ĳ�
 * @function Vip�������Dao��ӿ�
 */

public interface VipDao {
	
	/**  
	 *   Add by yangwc 
	 *   ����������Ա�����¼
	 *   @param Vip
	 */
	public void insert(Vip vip);
	
	/**
	 *   Add by yangwc
	 *   ���ڸ��»�Ա�����¼
	 *   @param Vip
	 */
	public void edit(Vip vip);
	
	/**
	 *   Add by yangwc
	 *   ��Ա�����¼���������޸�
	 *   @param Vip
	 */
	public void saveOrUpdate(Vip vip);
	
	/**
	 *   Add by yangwc  
	 *   ����ɾ����Ա�����¼
	 *   @param Vip
	 */
	public void delete(Vip vip);
	
	/**
	 *   Add by yangwc
	 *   ���ڲ�ѯ���л�Ա�ȼ���¼
	 *   @return List<Vip>
	 */
	public List<Vip> selectAll();
	
	/**
	 *   Add by yangwc
	 *   ���ڸ���������ѯ��Ա�ȼ���¼
	 *   @return List<Vip>
	 */
	public List<Vip> selectByParam(Map<String,Object> paramMap);
}
