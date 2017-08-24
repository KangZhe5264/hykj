package org.yang.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yang.dao.LeaguerDAO;
import org.yang.dao.impl.HouseDaoImpl;
import org.yang.dao.impl.HouseOrderDaoImpl;
import org.yang.formbeans.Destine;
import org.yang.javabeans.House;
import org.yang.javabeans.HouseOrder;
import org.yang.javabeans.Leaguer;
import org.yang.service.impl.HouseServiceImpl;

import utils.WXUtils;

/**
 * �Խӿ�HouseServiceImpl����ʵ��
 * ����ʱ��:2017��8��10�� ����2:33:50
 * ����޸���:����Ե
 * ����޸�ʱ��:2017��8��10�� ����2:33:50
 * @author ����Ե
 */
@Service
@Transactional
public class HouseService implements HouseServiceImpl {

	@Autowired
	private HouseDaoImpl houseDao;
	
	@Autowired
	private LeaguerDAO leaguerDao;
	
	@Autowired
	private HouseOrderDaoImpl houseOrderDao;
	@Override
	public List<House> canUseHouse() {
		// TODO Auto-generated method stub
		//������ѯ����
		DetachedCriteria criteria = DetachedCriteria.forClass(House.class);
		criteria.add(Restrictions.eq("state", true));
		
		List<House> result = houseDao.selectByCriteria(criteria);
		//�淶��result
		if(result == null)
			result = new ArrayList<House>();
		return result;
	}

	@Override
	public House getHouseById(int house) {
		// TODO Auto-generated method stub
		//�ų��ղ�����Ӱ��
		if(house <= 0) return null;
		return houseDao.selectById(house);
	}

	@Override
	public int destineOrder(Destine destine) {
		// TODO Auto-generated method stub
		//�ų���Ч�Ĳ���
		if(destine == null || !destine.testForDestine()) return -1;
		//�ж�����Ƿ�������֧��
		Leaguer leaguer = leaguerDao.getUserById(destine.getOpenid());
		
		if(leaguer == null) return -1;
		
		if(leaguer.getBalance() < destine.getAmount()) return 0;
		
		//��������ϵͳ��order
		HouseOrder order = new HouseOrder();
		order.setActiveTime(destine.getActive_time());
		order.setAmount(destine.getAmount());
		order.setArriveTime(destine.getArrive_time());
		order.setAuditing("-1");
		order.setContactPhone(destine.getContact_phone());
		order.setHouse(houseDao.selectById(destine.getHouse()));
		order.setObligate(true);
		order.setQuantity(destine.getQuantity());
		order.setLeaguer(leaguer);
		order.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
		//�����ɵļ�¼�־û������ݿ���
		houseOrderDao.insert(order);
		
		return 1;
	}

	@Override
	public double changePrice(int house, double price) {
		// TODO Auto-generated method stub
		
		House houseTemp = houseDao.selectById(house);
		
		if(houseTemp == null)
		{
			Logger log = Logger.getLogger(HouseService.class);
			log.error("�޸ķ���۸���Ϣʱ������Ч�Ĳ���:house");
		}
		
		if(price <= 0)
		{
			Logger log = Logger.getLogger(HouseService.class);
			log.error("�޸ķ���۸���Ϣʱ������Ч�Ĳ���:price");
			return houseTemp.getPrice();
		}
		
		houseTemp.setPrice(price);
		
		//���¸ı�ķ�����Ϣ���浽���ݿ���
		houseDao.update(houseTemp);
		
		return houseTemp.getPrice();
	}

	@Override
	public boolean changeState(int house) {
		// TODO Auto-generated method stub
		//�ų��ղ�����Ӱ��
		if(house <= 0) return false;
		
		House houseTemp = houseDao.selectById(house);
		if(houseTemp == null) return false;
		//�趨�µ�״̬��Ϣ
		houseTemp.setState(!houseTemp.getState());
		//�־û������ݿ���
		houseDao.update(houseTemp);
		return true;
	}

	@Override
	public void newHouse(String type, double price) {
		// TODO Auto-generated method stub
		//�ų��ղ�����Ӱ��
		if(type == null || "".equals(type) || price <= 0) return;
		
		//������������ʵ�������
		House house = new House();
		house.setType(type);
		house.setPrice(price);
		house.setState(true);
		
		//���浽���ݿ���
		houseDao.insert(house);

	}

	@Override
	public boolean auditingOrder(String serial, int option) {
		// TODO Auto-generated method stub

		//�ų��ղ�����Ӱ��
		if(serial == null || "".equals(serial)) return false;
		//�ҵ���Ӧ�Ķ�����Ϣ
		HouseOrder order = houseOrderDao.selectOrderById(serial);
		
		if(order == null) return false;
		
		//�Բ����������н�� 
		switch (option) {
			case 0://����
				order.setAuditing("0");
				houseOrderDao.update(order);
				return false;
			case 1://���ͨ��
				order.setAuditing("1");
				//��Ա�˺��н��п۷Ѳ���
				if(order.getLeaguer().getBalance() > (order.getHouse().getPrice() * order.getQuantity()))
				{
					order.getLeaguer().setBalance(order.getLeaguer().getBalance() - (order.getHouse().getPrice() * order.getQuantity()));
					houseOrderDao.update(order);
					//�������ͨ������Ϣ��ʾ-�����
					
					return true;
				}
				//������֧������ ������Ϣ��ʾ-�����
				
				return false;
			default:return false;
		}
		
	}

	@Override
	public void msg(String serial) {
		// TODO Auto-generated method stub
		//�ų��ղ�����Ӱ��
		if(serial == null || "".equals(serial))
			return;
		//�ҵ�ָ�������������Ϣ
		HouseOrder order = houseOrderDao.selectOrderById(serial);
		
		if(order == null)
			return;
		
		//���û�������֤��--�����
		Map<String, String> temp = new HashMap<String, String>();
		temp.put("openid", order.getLeaguer().getOpenId());
		WXUtils.sendOneToOneMsg(temp);
	}

	@Override
	public void backOrder(String serial, int option, String check_num) {
		// TODO Auto-generated method stub
		//�ų��ղ�����Ӱ��
		if(serial == null || "".equals(serial) || check_num == null || "".equals(check_num)) return;
		
		HouseOrder order = houseOrderDao.selectOrderById(serial);
		
		//��֤��֤���Ƿ����ʹ��-�����
		Map<String, String> temp = new HashMap<String, String>();
		temp.put("openid", order.getLeaguer().getOpenId());
		WXUtils.sendOneToOneMsg(temp);
		
		//������Ԥ��״̬����
		order.setObligate(false);
		//���´������ݿ���
		houseOrderDao.update(order);
	}

	@Override
	public List<HouseOrder> historyOrder(int day, boolean back) {
		// TODO Auto-generated method stub
		//��������
		DetachedCriteria criteria = DetachedCriteria.forClass(HouseOrder.class);
		criteria.add(Restrictions.ge("createTime", Timestamp.valueOf(LocalDateTime.now().plusDays(0-day))));
		criteria.add(Restrictions.and(Restrictions.eq("obligate", back)));
		
		//������ѯ
		List<HouseOrder> result = houseOrderDao.selectOrderByCriteria(criteria);
		//��null��Ϊ����0��Ϊ����
		return result == null?new ArrayList<HouseOrder>():result;
	}

	@Override
	public List<House> allHouse() {
		// TODO Auto-generated method stub
		//������ѯ����
		DetachedCriteria criteria = DetachedCriteria.forClass(House.class);
		criteria.addOrder(Order.desc("state"));
		
		//ִ�в�ѯ����
		List<House> result = houseDao.selectByCriteria(criteria);
		return result == null?new ArrayList<House>():result;
	}

}
