package org.yang.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yang.formbeans.Destine;
import org.yang.formbeans.HouseAndOrder;
import org.yang.javabeans.HouseOrder;
import org.yang.javabeans.Leaguer;
import org.yang.service.LeaguerService;
import org.yang.service.impl.HouseServiceImpl;

import utils.WXUtils;

/**
 * ����ϵͳ��url�綨
 * ����ʱ��:2017��8��9�� ����2:03:28
 * ����޸���:����Ե
 * ����޸�ʱ��:2017��8��9�� ����2:03:28
 * @author ����Ե
 */
@Controller
@RequestMapping("/house")
public class House {

	@Autowired
	private HouseServiceImpl houseService;
	
	@Autowired
	private LeaguerService leaguerService;
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request , String code , String state)
	{
		//�ų��ղ�����Ӱ��
		if(code == null || "".equals(code) || state == null || "".equals(state))
			return "/Front-Root/404.html";
		//��֤��Ա��Ϣ�Ƿ����,����������л�Ա����Ϣ
		
		//��openid�����ڻỰ��Χ��
		request.getSession().setAttribute("openid", WXUtils.getOpenId(request , code));
		//������Ԥ���ķ������ҳ���н���չʾ
		request.setAttribute("house", houseService.canUseHouse());
		
		return "forward:/WEB-INF/house/index.jsp";
	}
	
	@RequestMapping("/house_manager")
	public String houseManager(HttpServletRequest request)
	{
		//���������͵������Ϣ����ҳ���н���չʾ
		request.setAttribute("house", houseService.allHouse());
		
		return "forward:/WEB-INF/house/house_manager.jsp";
	}
	
	@RequestMapping("/house")
	public @ResponseBody Map<String, Object> house(HttpServletRequest request , int house)
	{
		//�������ز�������
		Map<String, Object> result = new HashMap<String, Object>();
		//�ų��ղ�����Ӱ��
		if(house <= 0)
		{
			result.put("flag",false);
			result.put("msg", "ָ���ķ����Ų�����!");
			return result;
		}
		
		Leaguer leaguer = leaguerService.getUserByOpenid((String) request.getSession().getAttribute("openid"));
		org.yang.javabeans.House houseType = houseService.getHouseById(house);
		if(leaguer == null || houseType == null)
		{
			result.put("flag",false);
			result.put("msg", "ָ���ķ����Ų�����!");
			return result;
		}
		
		result.put("flag",true);
		Map<String, Object> temp = new HashMap<String, Object>();
		temp.put("contact_phone", leaguer.getUserPhone());
		temp.put("price", houseType.getPrice());
		result.put("msg", temp);
		return result;
	}
	
	@RequestMapping("/info")
	public @ResponseBody Map<String, Object> info()
	{
		//�ù����ݲ����趨
		return null;
	}
	
	@RequestMapping("/destine")
	public @ResponseBody String destine(HttpServletRequest request , Destine destine)
	{
		String openid = (String) request.getSession().getAttribute("openid");
		destine.setOpenid(openid);
		//�ų��ղ�����Ӱ��
		if(!destine.testForDestine()) return "�������ڴ���,�����";
		
		switch(houseService.destineOrder(destine))
		{
			case 0:return "�ύ����ʧ��,���������˻����";
			case 1:return "���ύ����,��ȴ�����Ա���";
			case -1:return "ִ��service����";
			default:return "�ύ����ʧ��,�������ύ";
		}
	}
	
	@RequestMapping("/chenge_house")
	public @ResponseBody Map<String, Object> changeHouse(Destine destine)
	{
		//������������
		Map<String, Object> result = new HashMap<String, Object>();
		
		//��½�����Ϣ�ж�--����
		
		//�ų��ղ�����Ӱ��
		if(!destine.testForChangeHouse())
		{
			result.put("flag",true);
			result.put("msg", "���ڲ�����Ĳ���");
			return result;
		}
		
		double price = houseService.changePrice(destine.getHouse(),destine.getPrice());
		if(destine.getPrice() == price)
		{
			result.put("flag",true);
			result.put("msg", "�޸ĳɹ�!");
		}
		else
		{
			result.put("flag",false);
			result.put("msg", price);
		
		}
		
		return result;
	}
	
	@RequestMapping("/change_state")
	public @ResponseBody String changeState(Destine destine)
	{
		//�ų��ղ�����Ӱ��
		if(!destine.testHouse()) return "��Ч�Ĳ���";
		
		return houseService.changeState(destine.getHouse())? "�޸ĳɹ�":"�޸�ʧ��";
	}
	
	@RequestMapping("/add_house")
	public @ResponseBody Map<String, Object> addHouse(HouseAndOrder hao)
	{
		//������������
		Map<String, Object> result = new HashMap<String, Object>();
		
		//�ų��ղ�����Ӱ��
		if(!hao.testForAddHouse())
		{
			result.put("flag", false);
			result.put("msg", "��Ч�Ĳ���");
			return result;
		}
		
		houseService.newHouse(hao.getType(),hao.getPrice());
		
		result.put("flag", true);
		return result;
	}
	
	@RequestMapping("/auditing")
	public @ResponseBody String auditing(HouseAndOrder hao)
	{
		//�ų��ղ�����Ӱ��
		if(!hao.testForAuditing()) return "��Ч�Ĳ���";
		
		houseService.auditingOrder(hao.getSerial(),hao.getOption());
		
		switch(hao.getOption())
		{
			case 0: return "���سɹ�";
			case 1: return "���ͨ��";
			default: return "�����쳣";
		}
	}
	
	@RequestMapping("/check_msg")
	public @ResponseBody String checkMsg(HouseAndOrder hao)
	{
		//�ų��ղ�����Ӱ��
		if(!hao.testSerial()) return "��Ч�Ĳ���";
		
		houseService.msg(hao.getSerial());
		return "�ѷ�����֤��,�����ѻ�Ա�鿴";
	}
	
	@RequestMapping("/back_order")
	public @ResponseBody String backOrder(HouseAndOrder hao)
	{
		//�ų��ղ�����Ӱ��
		if(!hao.testForBackOrder()) return "��Ч�Ĳ�����Ϣ";
		
		houseService.backOrder(hao.getSerial(),hao.getOption(),hao.getCheck_num());
		
		switch(hao.getOption())
		{
			case 0: return "Ԥ�ڶ�����������˵�";
			case 1: return "�˵��ɹ�";
			default: return "�����쳣";
		}
	}
	
	@RequestMapping("/refur")
	public @ResponseBody Map<String, Object> refur()
	{
		//�������ز���
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<HouseOrder> list = houseService.historyOrder(7,true);
		
		if(list == null)//���޷��ص�list��Ϊ����Ϊ0��list
			list = new ArrayList<HouseOrder>();
		
		List<Map<String, Object>> temp = new ArrayList<Map<String, Object>>();
		for (HouseOrder order : list) {
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("house", order.getHouse().getId());
			map.put("type", order.getHouse().getType());
			map.put("username", order.getLeaguer().getUserName());
			map.put("arriveTime", order.getArriveTime());
			map.put("activeTime", order.getActiveTime());
			map.put("auditing", order.getAuditing());
			map.put("obligate", order.getObligate());
			map.put("contactPhone", order.getContactPhone());
			map.put("quantity", order.getQuantity());
			map.put("amount", order.getAmount());
			
			temp.add(map);
		}
		
		result.put("flag",true);
		result.put("msg", temp);
		return result;
	}
	
	
	
	
	
}
