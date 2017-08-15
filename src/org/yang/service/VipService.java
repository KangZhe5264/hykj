package org.yang.service;

import java.util.List;
import java.util.Map;

import org.yang.javabeans.Vip;

/**
 * @author   杨文昌
 * @function vip的Service接口类
 */
public interface VipService {

	/**  
	 *   Add by yangwc 
	 *   @function 新增会员种类
	 *   @param Vip
	 */
	public void create(Vip vip);
	
	/**  
	 *   Add by yangwc 
	 *   @function 修改会员种类
	 *   @param Vip
	 */
	public void modify(Vip vip);
	
	/**  
	 *   Add by yangwc 
	 *   @function 会员种类的新增或修改
	 *   @param Vip
	 */
	public void submit(Vip vip);
	
	/**  
	 *   Add by yangwc 
	 *   @function 删除会员种类
	 *   @param Vip
	 */
	public void removeVip(Vip vip);
	
	/**  
	 *   Add by yangwc 
	 *   @function 查询全部的会员种类
	 *   @return List<Vip>
	 */
	public List<Vip> QueryAll();
	
	
	/**  
	 *   Add by yangwc 
	 *   @function 条件查询
	 *   @param paramMap<字段名,值>
	 *   @return List<Vip>
	 */
	public List<Vip> QueryByCondition(Map<String,Object> paramMap);
	
}
