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
 * 对接口HouseServiceImpl进行实现
 * 创建时间:2017年8月10日 下午2:33:50
 * 最后修改人:杨殊缘
 * 最后修改时间:2017年8月10日 下午2:33:50
 * @author 杨殊缘
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
		//构建查询参数
		DetachedCriteria criteria = DetachedCriteria.forClass(House.class);
		criteria.add(Restrictions.eq("state", true));
		
		List<House> result = houseDao.selectByCriteria(criteria);
		//规范化result
		if(result == null)
			result = new ArrayList<House>();
		return result;
	}

	@Override
	public House getHouseById(int house) {
		// TODO Auto-generated method stub
		//排除空参数的影响
		if(house <= 0) return null;
		return houseDao.selectById(house);
	}

	@Override
	public int destineOrder(Destine destine) {
		// TODO Auto-generated method stub
		//排除无效的参数
		if(destine == null || !destine.testForDestine()) return -1;
		//判断余额是否可以完成支付
		Leaguer leaguer = leaguerDao.getUserById(destine.getOpenid());
		
		if(leaguer == null) return -1;
		
		if(leaguer.getBalance() < destine.getAmount()) return 0;
		
		//产生订房系统的order
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
		//将生成的记录持久化到数据库中
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
			log.error("修改房间价格信息时出现无效的参数:house");
		}
		
		if(price <= 0)
		{
			Logger log = Logger.getLogger(HouseService.class);
			log.error("修改房间价格信息时出现无效的参数:price");
			return houseTemp.getPrice();
		}
		
		houseTemp.setPrice(price);
		
		//将新改变的房间信息保存到数据库中
		houseDao.update(houseTemp);
		
		return houseTemp.getPrice();
	}

	@Override
	public boolean changeState(int house) {
		// TODO Auto-generated method stub
		//排除空参数的影响
		if(house <= 0) return false;
		
		House houseTemp = houseDao.selectById(house);
		if(houseTemp == null) return false;
		//设定新的状态信息
		houseTemp.setState(!houseTemp.getState());
		//持久化到数据库中
		houseDao.update(houseTemp);
		return true;
	}

	@Override
	public void newHouse(String type, double price) {
		// TODO Auto-generated method stub
		//排除空参数的影响
		if(type == null || "".equals(type) || price <= 0) return;
		
		//构建房间类型实体类对象
		House house = new House();
		house.setType(type);
		house.setPrice(price);
		house.setState(true);
		
		//保存到数据库中
		houseDao.insert(house);

	}

	@Override
	public boolean auditingOrder(String serial, int option) {
		// TODO Auto-generated method stub

		//排除空参数的影响
		if(serial == null || "".equals(serial)) return false;
		//找到对应的订单信息
		HouseOrder order = houseOrderDao.selectOrderById(serial);
		
		if(order == null) return false;
		
		//对操作参数进行解封 
		switch (option) {
			case 0://驳回
				order.setAuditing("0");
				houseOrderDao.update(order);
				return false;
			case 1://审核通过
				order.setAuditing("1");
				//会员账号中进行扣费操作
				if(order.getLeaguer().getBalance() > (order.getHouse().getPrice() * order.getQuantity()))
				{
					order.getLeaguer().setBalance(order.getLeaguer().getBalance() - (order.getHouse().getPrice() * order.getQuantity()));
					houseOrderDao.update(order);
					//订单审核通过发信息提示-待完成
					
					return true;
				}
				//余额不足以支付订单 发送信息提示-待完成
				
				return false;
			default:return false;
		}
		
	}

	@Override
	public void msg(String serial) {
		// TODO Auto-generated method stub
		//排除空参数的影响
		if(serial == null || "".equals(serial))
			return;
		//找到指定订单的相关信息
		HouseOrder order = houseOrderDao.selectOrderById(serial);
		
		if(order == null)
			return;
		
		//对用户发送验证码--待完成
		Map<String, String> temp = new HashMap<String, String>();
		temp.put("openid", order.getLeaguer().getOpenId());
		WXUtils.sendOneToOneMsg(temp);
	}

	@Override
	public void backOrder(String serial, int option, String check_num) {
		// TODO Auto-generated method stub
		//排除空参数的影响
		if(serial == null || "".equals(serial) || check_num == null || "".equals(check_num)) return;
		
		HouseOrder order = houseOrderDao.selectOrderById(serial);
		
		//验证验证码是否可以使用-待完成
		Map<String, String> temp = new HashMap<String, String>();
		temp.put("openid", order.getLeaguer().getOpenId());
		WXUtils.sendOneToOneMsg(temp);
		
		//将房间预留状态舍弃
		order.setObligate(false);
		//重新存入数据库中
		houseOrderDao.update(order);
	}

	@Override
	public List<HouseOrder> historyOrder(int day, boolean back) {
		// TODO Auto-generated method stub
		//构建条件
		DetachedCriteria criteria = DetachedCriteria.forClass(HouseOrder.class);
		criteria.add(Restrictions.ge("createTime", Timestamp.valueOf(LocalDateTime.now().plusDays(0-day))));
		criteria.add(Restrictions.and(Restrictions.eq("obligate", back)));
		
		//条件查询
		List<HouseOrder> result = houseOrderDao.selectOrderByCriteria(criteria);
		//将null化为长度0作为返回
		return result == null?new ArrayList<HouseOrder>():result;
	}

	@Override
	public List<House> allHouse() {
		// TODO Auto-generated method stub
		//构建查询条件
		DetachedCriteria criteria = DetachedCriteria.forClass(House.class);
		criteria.addOrder(Order.desc("state"));
		
		//执行查询操作
		List<House> result = houseDao.selectByCriteria(criteria);
		return result == null?new ArrayList<House>():result;
	}

}
