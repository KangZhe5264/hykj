package org.yang.service.impl;

import java.util.List;

import org.yang.formbeans.Destine;
import org.yang.javabeans.House;
import org.yang.javabeans.HouseOrder;

/**
 * ��������ϵͳ����ز���
 * ����ʱ��:2017-08-09 11:39:31
 * ����޸���:����Ե
 * ����޸�ʱ��:2017-08-09 11:42:12
 * @author ����Ե
 *
 */
public interface HouseServiceImpl {

	/**
	 * ��ϵͳ�е����з���������Ϊ���Ϸ���
	 * ��Ҫ�жϷ����Ƿ���Խ��ж���,�������ķ����ų���ȥ
	 * @return ���п��Ա���Ա���ж����Ĳ����ķ���
	 */
	public List<House> canUseHouse();

	/**
	 * ͨ��house���������о�׼��ѯ,����Ӧ�ļ�¼��Ϊʵ����з���
	 * @param house Ҫ��ѯ��house���¼������
	 * @return ����Ӧ�ı��¼��䵽��������Ϊ����
	 */
	public House getHouseById(int house);

	/**
	 * �������е�������ݷ�װ�ɶ�Ӧ�Ķ����������־û������ݿ���
	 * @param destine װ�ر�Ҫ�Ĳ�����Ϣ
	 * @return 0��ʾ�˻�����,1��ʾ�����ɹ�,������ʾ����ʧ��
	 */
	public int destineOrder(Destine destine);

	/**
	 * �������ķ���ļ۸��޸�Ϊ�µļ۸�,�޸ĳɹ������µļ۸�,�޸�ʧ�ܷ��ؾ��еļ۸���Ϣ
	 * @param house ָ��Ҫ�����޸ĵķ����¼
	 * @param price �÷����µļ۸�
	 * @return �����ݿ������еĶ�Ӧ����ļ۸���Ϣ��Ϊ����
	 */
	public double changePrice(int house, double price);

	/**
	 * ��ָ�������״̬���н���,1��Ϊ0,0��Ϊ1
	 * ����������true,����ʧ�ܷ���false
	 * @param house Ҫ����״̬�޸ĵķ����¼������ֵ
	 * @return �ò������ƶ�״̬,�ɹ�Ϊtrue
	 */
	public boolean changeState(int house);

	/**
	 * �������еĲ�������һ���µķ����¼��Ϣ�����浽���ݿ���
	 * stateĬ��Ϊtrue,��ʾ���Խ��ж�������
	 * @param type �µķ����¼������
	 * @param price �µķ����¼�ļ۸�
	 */
	public void newHouse(String type, double price);

	/**
	 * �޸�һ�����������״̬,���ͨ����Ҫִ����Ӧ�Ŀۿ֪ͨ����
	 * @param serial ��Ҫ�޸ĵĶ�����¼������
	 * @param option ��˲���,1��ʾ���ͨ��,0��ʾ����
	 * @return ��Ӧ�Ķ��������Ƿ�ɹ����
	 */
	public boolean auditingOrder(String serial, int option);

	/**
	 * ͨ��ָ���Ķ�����Ϣ��û�Ա����һ����Ϣ��ʾ��Ա������֤����֤����
	 * @param serial ��ԵĶ�����¼������ֵ
	 */
	public void msg(String serial);

	/**
	 * �޸�һ������ϵͳ�Ķ��������Ԥ��״̬��Ϊ0
	 * ʹ����֤��У�鵱ǰ�����Ƿ����ִ��
	 * ������Ӧ���˵���¼,����option�ֱ��˵�ԭ��
	 * �Ի�Ա������Ϣ��ʾ
	 * @param serial Ҫ�˵��Ķ�����¼������
	 * @param option �˵���ԭ��:1��ʾ�����˵�,0��ʾ�����˵�
	 * @param check_num ͨ����֤����֤�ò����Ƿ���Ա�ִ��
	 */
	public void backOrder(String serial, int option, String check_num);

	/**
	 * ��������������ʷ�Ķ���������¼��Ϣ
	 * @param day ��ѯ����ʷ��Χ0�Լ�С��0��ʾ��ѯȫ������λΪ��
	 * @param back �Ƿ�Ҫ��ѯ�˵���¼,true��ʾ����ѯ�˵���¼,false��ʾ��ѯ�˵���¼
	 * @return ����ѯ���Ķ�����Ϣ��Ϊ���Ϸ���
	 */
	public List<HouseOrder> historyOrder(int day , boolean back);

	/**
	 * �����еķ�����Ϣ����������ֱ�Ӳ�ѯ����
	 * ��Ҫһ�����������,���Ƿ����Ԥ����������
	 * @return ����ѯ���ķ����¼��Ϣ��Ϊ���������
	 */
	public List<House> allHouse();

	
}
