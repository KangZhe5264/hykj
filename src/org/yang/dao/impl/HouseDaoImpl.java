package org.yang.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.yang.javabeans.House;

/**
 * ��Ա�house�Լ�ʵ����House������ز���
 * ����ʱ��:2017��8��10�� ����2:36:16
 * ����޸���:����Ե
 * ����޸�ʱ��:2017��8��10�� ����2:36:16
 * @author ����Ե
 */
public interface HouseDaoImpl {

	/**
	 * ͨ����ѯ����������صĲ�ѯ
	 * @param criteria ��ѯ�����ķ�װ����
	 * @return �����ϲ�ѯ������house���¼��Ϊ���Ͻ��з���
	 */
	public List<House> selectByCriteria(DetachedCriteria criteria);

	/**
	 * ͨ�����¼����ֵ�ҵ���Ӧ�ļ�¼��Ϊ����
	 * @param house house���¼������ֵ
	 * @return ����ֵ��Ӧ�ı��¼��Ϣ
	 */
	public House selectById(int house);

	/**
	 * ��һ���޸Ĺ��ķ�����Ϣ���±��浽���ݿ���,��������ֵ�Ǳ���Ĵ���
	 * @param house ����������ֵ�Լ����º����ݵķ�����Ϣ����
	 */
	public void update(House house);

	/**
	 * ��һ���������͵���Ϣ�������ݿ���
	 * ��������Ĳ������������
	 * @param house ��ŷ������ͼ�¼��Ϣ��ʵ�������
	 */
	public void insert(House house);

}
