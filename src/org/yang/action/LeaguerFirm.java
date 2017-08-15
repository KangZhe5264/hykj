package org.yang.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yang.javabeans.Leaguer;
import org.yang.javabeans.Vip;
import org.yang.service.LeaguerService;

@Controller
@RequestMapping("/leaguer")
public class LeaguerFirm {

	@Autowired
	private LeaguerService leaguerService;
	
	@RequestMapping("/LeaguerManage")
	public String leaguerManage(HttpServletRequest request)
	{
		request.setAttribute("leaguerList", leaguerService.QueryAll());
		
		return "/Back-Root/leaguer/leaguer-manager.jsp";
	}
	
	@RequestMapping("/LeaguerCondition")
	public String leaguerCondition(HttpServletRequest request)
	{
		String cod1 = request.getParameter("where-levelName");
		String cod2 = request.getParameter("where-userPhone");
		String cod3 = request.getParameter("where-userName");
		
		Map<String,Object> paramMap = new HashMap<String,Object>();
		
		if(!"".equals(cod1) && cod1 != null){
			paramMap.put("vip.levalName", cod1);
		}
		
		if(!"".equals(cod2) && cod2 != null){
			paramMap.put("userPhone", cod2);
		}
		
		if(!"".equals(cod3) && cod3 != null){
			paramMap.put("userName", cod3);
		}
		
		request.setAttribute("leaguerList", leaguerService.QueryByCondition(paramMap));
		
		return "/Back-Root/leaguer/leaguer-manager.jsp";
	}
	
	@RequestMapping("/LeaguerDelete")
	public String leaguerDelete(HttpServletRequest request,Leaguer leaguer)
	{
		leaguerService.removeLeaguer(leaguer);
		
		request.setAttribute("leaguerList", leaguerService.QueryAll());
		
		return "/Back-Root/leaguer/leaguer-manager.jsp";
	}
	
	@RequestMapping("/LeaguerCreate")
	public String leaguerCreate(HttpServletRequest request,Leaguer leaguer)
	{
		
		leaguerService.create(leaguer);
		
		return "/Back-Root/leaguer/leaguer-manager.jsp";
	}
	
	@RequestMapping("/LeaguerEdit")
	public String leaguerEdit(HttpServletRequest request,Leaguer leaguer)
	{
		
		leaguerService.modify(leaguer);
		
		return "/Back-Root/leaguer/leaguer-manager.jsp";
	}
	
	@RequestMapping("/LeaguerSubmit")
	public String leaguerSubmit(HttpServletRequest request,Leaguer leaguer,Vip vip)
	{
		leaguer.setVip(vip);
		
		leaguerService.submit(leaguer);
		
		request.setAttribute("leaguerList", leaguerService.QueryAll());
		
		return "/Back-Root/leaguer/leaguer-manager.jsp";
	}
}
