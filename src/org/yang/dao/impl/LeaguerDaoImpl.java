package org.yang.dao.impl;

import org.yang.javabeans.Leaguer;

/**
 * ��Ա�leaguer��ʵ����Leaguer�Ĳ����ӿ�
 * ����ʱ��:2017��8��10�� ����3:02:38
 * ����޸���:����Ե
 * ����޸�ʱ��:2017��8��10�� ����3:02:38
 * @author ����Ե
 */
public interface LeaguerDaoImpl {

	/**
	 * ͨ������openid�ҵ���Ӧ�Ļ�Ա��Ϣ
	 * @param openid ��Ա��openid,���ڲ���Ψһ�Ļ�Ա
	 * @return ��Ψһ��Ӧ �Ļ�Ա��¼��ʵ�������ķ�ʽ����
	 */
	public Leaguer getUserById(String openid);

}
