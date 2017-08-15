package org.yang.service;

import java.util.List;
import java.util.Map;

import org.yang.javabeans.Leaguer;

/**
 * @author   杨文昌
 * @function Leaguer的Service接口类
 */

public interface LeaguerService {

	/**  
	 *   Add by yangwc 
	 *   @function 新增会员
	 *   @param Leaguer
	 */
	public void create(Leaguer Leaguer);
	
	/**  
	 *   Add by yangwc 
	 *   @function 修改会员
	 *   @param Leaguer
	 */
	public void modify(Leaguer Leaguer);
	
	/**  
	 *   Add by yangwc 
	 *   @function 会员信息提交（修改和新增）
	 *   @param Leaguer
	 */
	public void submit(Leaguer Leaguer);
	
	/**  
	 *   Add by yangwc 
	 *   @function 删除会员
	 *   @param Leaguer
	 */
	public void removeLeaguer(Leaguer Leaguer);
	
	/**  
	 *   Add by yangwc 
	 *   @function 查询全部的会员
	 *   @return List<Leaguer>
	 */
	public List<Leaguer> QueryAll();
	
	
	/**  
	 *   Add by yangwc 
	 *   @function 条件查询
	 *   @param paramMap<字段名,值>
	 *   @return List<Leaguer>
	 */
	public List<Leaguer> QueryByCondition(Map<String,Object> paramMap);
	
	/**  
	 *   Add by 杨殊缘
	 *   @function 根据openid查询会员信息
	 *   @param paramMap<K,V>
	 *   @return Leaguer
	 */
	public Leaguer getUserByOpenid(String openid);
	
}
