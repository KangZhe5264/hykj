package org.yang.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yang.javabeans.Leaguer;
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
	
	@RequestMapping("/LeaguerDelete")
	public String leaguerDelete(HttpServletRequest request)
	{
		Leaguer leaguer = (Leaguer) request.getAttribute("leaguer");
		
		leaguerService.removeLeaguer(leaguer);
		
		request.setAttribute("leaguerList", leaguerService.QueryAll());
		
		return "/Back-Root/leaguer/leaguer-manager.jsp";
	}
	
	@RequestMapping("/LeaguerCreate")
	public String leaguerCreate(HttpServletRequest request)
	{
		Leaguer leaguer = (Leaguer) request.getAttribute("leaguer");
		
		leaguerService.create(leaguer);
		
		return "/Back-Root/leaguer/leaguer-manager.jsp";
	}
	
	@RequestMapping("/LeaguerEdit")
	public String leaguerEdit(HttpServletRequest request)
	{
		Leaguer leaguer = (Leaguer) request.getAttribute("leaguer");
		
		leaguerService.modify(leaguer);
		
		return "/Back-Root/leaguer/leaguer-manager.jsp";
	}
	
	@RequestMapping("/LeaguerSubmit")
	public String leaguerSubmit(HttpServletRequest request)
	{
		Leaguer leaguer = (Leaguer) request.getAttribute("leaguer");
		
		leaguerService.submit(leaguer);
		
		request.setAttribute("leaguerList", leaguerService.QueryAll());
		
		return "/Back-Root/leaguer/leaguer-manager.jsp";
	}
}
