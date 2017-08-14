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
		
		return "redirect:/LeaguerManage";
	}
	
	@RequestMapping("/LeaguerCreate")
	public String vipCreate(HttpServletRequest request)
	{
		Leaguer leaguer = (Leaguer) request.getAttribute("leaguer");
		
		leaguerService.create(leaguer);
		
		return "redirect:/LeaguerManage";
	}
	
	@RequestMapping("/LeaguerEdit")
	public String leaguerEdit(HttpServletRequest request)
	{
		Leaguer leaguer = (Leaguer) request.getAttribute("leaguer");
		
		leaguerService.modify(leaguer);
		
		return "redirect:/LeaguerManage";
	}
}
