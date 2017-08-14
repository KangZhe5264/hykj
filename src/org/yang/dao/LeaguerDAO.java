package org.yang.dao;

import java.util.List;
import java.util.Map;

import org.yang.javabeans.Leaguer;
/**
 * @author yangwc
 * @function Leaguer的DAO类接口
 */

public interface LeaguerDAO {
	/**
	 * add by 杨殊缘
	 * 通过主键openid找到对应的会员信息
	 * @param openid 会员的openid,用于查找唯一的会员
	 * @return 将唯一对应 的会员记录以实体类对象的方式返回
	 */
	public Leaguer getUserById(String openid);
	
	/**
	 * 会员注册
	 * @param leaguer 要添加的会员
	 */
	public void add(Leaguer leaguer);
	
	/**
	 * 会员信息修改
	 * @param leaguer 要修改的会员信息
	 */
	public void Eidt(Leaguer leaguer);
	
	/**
	 * 会员信息删除
	 * @param leaguer 要删除的会员信息
	 */
	public void Delete(Leaguer leaguer);
	
	/**
	 * 会员信息删除
	 * @return List<leaguer> 全部会员信息
	 */
	public List<Leaguer> QueryAll();
	
	/**
	 * @param Map 查询条件<K,V>
	 * @return List<leaguer> 全部会员信息
	 */
	public List<Leaguer> QueryByParam(Map<String,Object> paramMap);
}
