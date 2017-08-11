package org.yang.service.impl;

import org.yang.javabeans.Leaguer;

/**
 * 对会员进行搞做的相关方法
 * 创建时间:2017年8月11日 下午3:39:36
 * 最后修改人:杨殊缘
 * 最后修改时间:2017年8月11日 下午3:39:36
 * @author 杨殊缘
 */
public interface LeaguerServiceImpl {

	/**
	 * 通过会员的openid找到系统中会员所拥有的信息
	 * @param openid
	 * @return 将系统中的会员openid对应的信息记录取出来
	 */
	public Leaguer getUserByOpenid(String openid);

}
