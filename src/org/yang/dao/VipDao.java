package org.yang.dao;

import java.util.List;
import java.util.Map;

import org.yang.javabeans.Vip;

/**
 * @author   杨文昌
 * @function Vip表操作的Dao类接口
 */

public interface VipDao {
	
	/**  
	 *   Add by yangwc 
	 *   用于新增会员种类记录
	 *   @param Vip
	 */
	public void insert(Vip vip);
	
	/**
	 *   Add by yangwc
	 *   用于更新会员种类记录
	 *   @param Vip
	 */
	public void edit(Vip vip);
	
	/**
	 *   Add by yangwc
	 *   会员种类记录的新增或修改
	 *   @param Vip
	 */
	public void saveOrUpdate(Vip vip);
	
	/**
	 *   Add by yangwc  
	 *   用于删除会员种类记录
	 *   @param Vip
	 */
	public void delete(Vip vip);
	
	/**
	 *   Add by yangwc
	 *   用于查询所有会员等级记录
	 *   @return List<Vip>
	 */
	public List<Vip> selectAll();
	
	/**
	 *   Add by yangwc
	 *   用于根据条件查询会员等级记录
	 *   @return List<Vip>
	 */
	public List<Vip> selectByParam(Map<String,Object> paramMap);
}
