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
 * 订房系统的url界定
 * 创建时间:2017年8月9日 下午2:03:28
 * 最后修改人:杨殊缘
 * 最后修改时间:2017年8月9日 下午2:03:28
 * @author 杨殊缘
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
		//排除空参数的影响
		if(code == null || "".equals(code) || state == null || "".equals(state))
			return "/Front-Root/404.html";
		//验证会员信息是否存在,不存在则进行会员绑定信息
		
		//将openid放置在会话域范围内
		request.getSession().setAttribute("openid", WXUtils.getOpenId(request , code));
		//将可以预定的房间放在页面中进行展示
		request.setAttribute("house", houseService.canUseHouse());
		
		return "forward:/WEB-INF/house/index.jsp";
	}
	
	@RequestMapping("/house_manager")
	public String houseManager(HttpServletRequest request)
	{
		//将房间类型的相关信息放在页面中进行展示
		request.setAttribute("house", houseService.allHouse());
		
		return "forward:/WEB-INF/house/house_manager.jsp";
	}
	
	@RequestMapping("/house")
	public @ResponseBody Map<String, Object> house(HttpServletRequest request , int house)
	{
		//构建返回参数容器
		Map<String, Object> result = new HashMap<String, Object>();
		//排除空参数的影响
		if(house <= 0)
		{
			result.put("flag",false);
			result.put("msg", "指定的房间编号不存在!");
			return result;
		}
		
		Leaguer leaguer = leaguerService.getUserByOpenid((String) request.getSession().getAttribute("openid"));
		org.yang.javabeans.House houseType = houseService.getHouseById(house);
		if(leaguer == null || houseType == null)
		{
			result.put("flag",false);
			result.put("msg", "指定的房间编号不存在!");
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
		//该功能暂不做设定
		return null;
	}
	
	@RequestMapping("/destine")
	public @ResponseBody String destine(HttpServletRequest request , Destine destine)
	{
		String openid = (String) request.getSession().getAttribute("openid");
		destine.setOpenid(openid);
		//排除空参数的影响
		if(!destine.testForDestine()) return "参数存在错误,请矫正";
		
		switch(houseService.destineOrder(destine))
		{
			case 0:return "提交订单失败,请检测您的账户余额";
			case 1:return "已提交订单,请等待管理员审核";
			case -1:return "执行service出错";
			default:return "提交订单失败,请重新提交";
		}
	}
	
	@RequestMapping("/chenge_house")
	public @ResponseBody Map<String, Object> changeHouse(Destine destine)
	{
		//构建返回数据
		Map<String, Object> result = new HashMap<String, Object>();
		
		//登陆相关信息判断--不做
		
		//排除空参数的影响
		if(!destine.testForChangeHouse())
		{
			result.put("flag",true);
			result.put("msg", "存在不合理的参数");
			return result;
		}
		
		double price = houseService.changePrice(destine.getHouse(),destine.getPrice());
		if(destine.getPrice() == price)
		{
			result.put("flag",true);
			result.put("msg", "修改成功!");
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
		//排除空参数的影响
		if(!destine.testHouse()) return "无效的操作";
		
		return houseService.changeState(destine.getHouse())? "修改成功":"修改失败";
	}
	
	@RequestMapping("/add_house")
	public @ResponseBody Map<String, Object> addHouse(HouseAndOrder hao)
	{
		//构建返回数据
		Map<String, Object> result = new HashMap<String, Object>();
		
		//排除空参数的影响
		if(!hao.testForAddHouse())
		{
			result.put("flag", false);
			result.put("msg", "无效的参数");
			return result;
		}
		
		houseService.newHouse(hao.getType(),hao.getPrice());
		
		result.put("flag", true);
		return result;
	}
	
	@RequestMapping("/auditing")
	public @ResponseBody String auditing(HouseAndOrder hao)
	{
		//排除空参数的影响
		if(!hao.testForAuditing()) return "无效的参数";
		
		houseService.auditingOrder(hao.getSerial(),hao.getOption());
		
		switch(hao.getOption())
		{
			case 0: return "驳回成功";
			case 1: return "审核通过";
			default: return "产生异常";
		}
	}
	
	@RequestMapping("/check_msg")
	public @ResponseBody String checkMsg(HouseAndOrder hao)
	{
		//排除空参数的影响
		if(!hao.testSerial()) return "无效的参数";
		
		houseService.msg(hao.getSerial());
		return "已发送验证码,请提醒会员查看";
	}
	
	@RequestMapping("/back_order")
	public @ResponseBody String backOrder(HouseAndOrder hao)
	{
		//排除空参数的影响
		if(!hao.testForBackOrder()) return "无效的参数信息";
		
		houseService.backOrder(hao.getSerial(),hao.getOption(),hao.getCheck_num());
		
		switch(hao.getOption())
		{
			case 0: return "预期订出房间产生退单";
			case 1: return "退单成功";
			default: return "产生异常";
		}
	}
	
	@RequestMapping("/refur")
	public @ResponseBody Map<String, Object> refur()
	{
		//构建返回参数
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<HouseOrder> list = houseService.historyOrder(7,true);
		
		if(list == null)//将无返回的list变为长度为0的list
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
