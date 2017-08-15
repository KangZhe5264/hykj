package org.yang.service;

import java.util.List;
import java.util.Map;

import org.yang.javabeans.Vip;

/**
 * @author   ���Ĳ�
 * @function vip��Service�ӿ���
 */
public interface VipService {

	/**  
	 *   Add by yangwc 
	 *   @function ������Ա����
	 *   @param Vip
	 */
	public void create(Vip vip);
	
	/**  
	 *   Add by yangwc 
	 *   @function �޸Ļ�Ա����
	 *   @param Vip
	 */
	public void modify(Vip vip);
	
	/**  
	 *   Add by yangwc 
	 *   @function ��Ա������������޸�
	 *   @param Vip
	 */
	public void submit(Vip vip);
	
	/**  
	 *   Add by yangwc 
	 *   @function ɾ����Ա����
	 *   @param Vip
	 */
	public void removeVip(Vip vip);
	
	/**  
	 *   Add by yangwc 
	 *   @function ��ѯȫ���Ļ�Ա����
	 *   @return List<Vip>
	 */
	public List<Vip> QueryAll();
	
	
	/**  
	 *   Add by yangwc 
	 *   @function ������ѯ
	 *   @param paramMap<�ֶ���,ֵ>
	 *   @return List<Vip>
	 */
	public List<Vip> QueryByCondition(Map<String,Object> paramMap);
	
}
