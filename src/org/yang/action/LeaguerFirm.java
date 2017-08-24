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
import org.yang.javabeans.Leaguer;
import org.yang.javabeans.Vip;
import org.yang.service.LeaguerService;
import org.yang.service.VipService;

import utils.WXUtils;

@Controller
@RequestMapping("/leaguer")
public class LeaguerFirm {

	@Autowired
	private LeaguerService leaguerService;
	@Autowired
	private VipService vipService;
	
	@RequestMapping("/LeaguerManage")
	public @ResponseBody List<Leaguer> leaguerManage(HttpServletRequest request)
	{
		
		List<Leaguer> leaguers = new ArrayList<Leaguer>();
		for(Leaguer leaguer:leaguerService.QueryAll()){
			Leaguer lea = new Leaguer();
			Vip vip = new Vip();
			lea.setBalance(leaguer.getBalance());
			lea.setHistory(leaguer.getHistory());
			lea.setOpenId(leaguer.getOpenId());
			lea.setUserName(leaguer.getUserName());
			lea.setUserPhone(leaguer.getUserPhone());
			lea.setUserPwd(leaguer.getUserPwd());
			vip.setId(leaguer.getVip().getId());
			vip.setLevalName(leaguer.getVip().getLevalName());
			lea.setVip(vip);
			leaguers.add(lea);
		}
		
		return leaguers;
	}
	
	@RequestMapping("/LeaguerCondition")
	public @ResponseBody List<Leaguer> leaguerCondition(HttpServletRequest request)
	{
		String cod1 = request.getParameter("where-id");
		String cod2 = request.getParameter("where-userPhone");
		String cod3 = request.getParameter("where-userName");
		
		Map<String,Object> paramMap = new HashMap<String,Object>();
		
		if(!"".equals(cod1) && cod1 != null){
			Vip vip = new Vip();
			vip.setId(Integer.parseInt(cod1));
			paramMap.put("vip", vip);
		}
		
		if(!"".equals(cod2) && cod2 != null){
			paramMap.put("userPhone", cod2);
		}
		
		if(!"".equals(cod3) && cod3 != null){
			paramMap.put("userName", cod3);
		}
		
		List<Leaguer> leaguers = new ArrayList<Leaguer>();
		for(Leaguer leaguer:leaguerService.QueryByCondition(paramMap)){
			Leaguer lea = new Leaguer();
			Vip vip = new Vip();
			lea.setBalance(leaguer.getBalance());
			lea.setHistory(leaguer.getHistory());
			lea.setOpenId(leaguer.getOpenId());
			lea.setUserName(leaguer.getUserName());
			lea.setUserPhone(leaguer.getUserPhone());
			lea.setUserPwd(leaguer.getUserPwd());
			vip.setId(leaguer.getVip().getId());
			vip.setLevalName(leaguer.getVip().getLevalName());
			lea.setVip(vip);
			leaguers.add(lea);
		}
		
		return leaguers;
	}
	
	@RequestMapping("/LeaguerDelete")
	public @ResponseBody List<Leaguer> leaguerDelete(HttpServletRequest request,Leaguer leaguer)
	{
		leaguerService.removeLeaguer(leaguer);
		
		List<Leaguer> leaguers = new ArrayList<Leaguer>();
		for(Leaguer temp:leaguerService.QueryAll()){
			Leaguer lea = new Leaguer();
			Vip vip = new Vip();
			lea.setBalance(temp.getBalance());
			lea.setHistory(temp.getHistory());
			lea.setOpenId(temp.getOpenId());
			lea.setUserName(temp.getUserName());
			lea.setUserPhone(temp.getUserPhone());
			lea.setUserPwd(temp.getUserPwd());
			vip.setId(temp.getVip().getId());
			vip.setLevalName(temp.getVip().getLevalName());
			lea.setVip(vip);
			leaguers.add(lea);
		}
		
		return leaguers;
	}
	
	@RequestMapping("/LeaguerCreate")
	public @ResponseBody String leaguerCreate(HttpServletRequest request)
	{
		String openId = request.getParameter("openId");
		String userName = request.getParameter("userName");
		String userPhone = request.getParameter("userPhone");
		String userPwd = request.getParameter("userPwd");
		String id = request.getParameter("id");
		
		Leaguer leaguer = new Leaguer();
		
		Vip vip = new Vip();
		vip.setId(Integer.parseInt(id));
		
		leaguer.setVip(vip);
		leaguer.setOpenId(openId);
		leaguer.setUserName(userName);
		leaguer.setUserPhone(userPhone);
		leaguer.setUserPwd(userPwd);
		leaguer.setBalance(0D);
		leaguer.setHistory(0D);
		
		try{
			leaguerService.create(leaguer);
			return "SUCCESS";
		}catch(Exception e){
			return "ERROR";
		}
		
	}
	
	@RequestMapping("/LeaguerFind")
	public @ResponseBody Leaguer leaguerFind(HttpServletRequest request)
	{
		String openId = request.getParameter("openId");
		
		Leaguer leaguer = new Leaguer();
		
		Vip v = new Vip();
		
		leaguer = leaguerService.getUserByOpenid(openId);
		
		Leaguer temp = new Leaguer();
		
		temp.setOpenId(leaguer.getOpenId());
		
		temp.setUserName(leaguer.getUserName());
		
		temp.setUserPhone(leaguer.getUserPhone());
		
		v.setLevalName(leaguer.getVip().getLevalName());
		
		temp.setVip(v);
		
		temp.setBalance(leaguer.getBalance());
		
		temp.setHistory(leaguer.getHistory());
		
		temp.setUserPwd(leaguer.getUserPwd());
		
		return temp;
	}
	
	@RequestMapping("/LeaguerEdit")
	public @ResponseBody String leaguerEdit(HttpServletRequest request,Leaguer leaguer)
	{
		String type = (String) request.getParameter("type");
		String msg = "";
		Leaguer temp = new Leaguer();
		
		if("REPWD".equals(type)){
			String openId = request.getParameter("openId");
			String userPwd = request.getParameter("userPwd");
			temp = leaguerService.getUserByOpenid(openId);
			temp.setUserPwd(userPwd);
			leaguerService.modify(temp);
			msg = "SUCCESS";
		}else if("RECHARGE".equals(type)){
			String openId = request.getParameter("openId");
			String bal = request.getParameter("balance");
			temp = leaguerService.getUserByOpenid(openId);
			temp.setBalance(temp.getBalance() + Double.parseDouble(bal));
			leaguerService.modify(temp);
			msg = "SUCCESS";
		}
		return msg;
	}
	
	@RequestMapping("/LeaguerSubmit")
	public @ResponseBody List<Leaguer> leaguerSubmit(HttpServletRequest request,Leaguer leaguer,Vip vip)
	{
		Map<String,Object> paramMap = new HashMap<String,Object>();
		
		paramMap.put("id", vip.getId());
		
		vip = vipService.QueryByCondition(paramMap).get(0);
		
		leaguer.setVip(vip);
		
		leaguerService.submit(leaguer);
		
		List<Leaguer> leaguers = new ArrayList<Leaguer>();
		
		for(Leaguer temp:leaguerService.QueryAll()){
			Leaguer lea = new Leaguer();
			Vip v = new Vip();
			lea.setBalance(temp.getBalance());
			lea.setHistory(temp.getHistory());
			lea.setOpenId(temp.getOpenId());
			lea.setUserName(temp.getUserName());
			lea.setUserPhone(temp.getUserPhone());
			lea.setUserPwd(temp.getUserPwd());
			v.setId(temp.getVip().getId());
			v.setLevalName(temp.getVip().getLevalName());
			lea.setVip(v);
			leaguers.add(lea);
		}
		
		return leaguers;
	}
	
	@RequestMapping("/LeaguerAccess")
	public String leaguerAccess(HttpServletRequest request)
	{
		String code = request.getParameter("code");
		
		String openId = WXUtils.getOpenId(request,code);
		
		Leaguer leaguer = leaguerService.getUserByOpenid(openId);
		
		if(leaguer == null){
			return "/Front-Root/leaguer/leaguer-register.html?openId="+openId;
		}else{
			return "/Front-Root/leaguer/leaguer-info.html?openId="+openId;
		}
	}
}
