package org.yang.dao.impl;

import org.yang.javabeans.Leaguer;

/**
 * 针对表leaguer和实体类Leaguer的操作接口
 * 创建时间:2017年8月10日 下午3:02:38
 * 最后修改人:杨殊缘
 * 最后修改时间:2017年8月10日 下午3:02:38
 * @author 杨殊缘
 */
public interface LeaguerDaoImpl {

	/**
	 * 通过主键openid找到对应的会员信息
	 * @param openid 会员的openid,用于查找唯一的会员
	 * @return 将唯一对应 的会员记录以实体类对象的方式返回
	 */
	public Leaguer getUserById(String openid);

}
