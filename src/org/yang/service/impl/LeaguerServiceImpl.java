package org.yang.service.impl;

import org.yang.javabeans.Leaguer;

/**
 * �Ի�Ա���и�������ط���
 * ����ʱ��:2017��8��11�� ����3:39:36
 * ����޸���:����Ե
 * ����޸�ʱ��:2017��8��11�� ����3:39:36
 * @author ����Ե
 */
public interface LeaguerServiceImpl {

	/**
	 * ͨ����Ա��openid�ҵ�ϵͳ�л�Ա��ӵ�е���Ϣ
	 * @param openid
	 * @return ��ϵͳ�еĻ�Աopenid��Ӧ����Ϣ��¼ȡ����
	 */
	public Leaguer getUserByOpenid(String openid);

}
