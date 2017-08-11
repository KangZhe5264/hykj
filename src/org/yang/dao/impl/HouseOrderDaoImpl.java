package org.yang.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.yang.javabeans.HouseOrder;

/**
 * ��Ա�HouseOrder�Լ�ʵ����houseOrder�Ĳ���
 * ����ʱ��:2017��8��10�� ����3:41:39
 * ����޸���:����Ե
 * ����޸�ʱ��:2017��8��10�� ����3:41:39
 * @author ����Ե
 */
public interface HouseOrderDaoImpl {

	/**
	 * ��һ�����������������ݿ���
	 * �ǹؼ��ֶ�serial��createTime,�����Ϊ�ؼ��ֶ�
	 * @param order �������йؼ��ֶεĶ���������¼����
	 */
	public void insert(HouseOrder order);

	/**
	 * ͨ�����¼����ֵ��ѯ��Ӧ�ļ�¼��Ϣ
	 * @param serial houseOrder���¼������ֵ
	 * @return ����Ӧ�ı��¼��Ϣ��װ��ʵ��������н��з���
	 */
	public HouseOrder selectOrderById(String serial);

	/**
	 * ��һ�����������޸ĺ����Ϣ���´��뵽���ݿ���
	 * ����ֵ�Ǳ�����ڵ�
	 * @param order ���޸ĺ�Ķ�����Ϣ
	 */
	public void update(HouseOrder order);

	/**
	 * ͨ��������ѯ�����������еļ�¼���޵Ĳ�ѯ����
	 * @param criteria ��ѯ��������
	 * @return ����ѯ�����Ϊ���Ϸ���
	 */
	public List<HouseOrder> selectOrderByCriteria(DetachedCriteria criteria);

}
