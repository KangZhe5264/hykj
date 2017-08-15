package org.yang.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yang.javabeans.Vip;
import org.yang.service.VipService;

@Controller
@RequestMapping("/vip")
public class VipFirm {

	@Autowired
	private VipService vipService;
	
	@RequestMapping("/VipManage")
	public String vipManage(HttpServletRequest request)
	{
		request.setAttribute("vipList", vipService.QueryAll());
		
		return "/Back-Root/vip/vip-manager.jsp";
	}
	
	@RequestMapping("/VipDelete")
	public String vipDelete(HttpServletRequest request)
	{
		Vip vipper = (Vip) request.getAttribute("vip");
		
		vipService.removeVip(vipper);
		
		request.setAttribute("vipList", vipService.QueryAll());
		
		return "/Back-Root/vip/vip-manager.jsp";
	}
	
	@RequestMapping("/VipCreate")
	public String vipCreate(HttpServletRequest request)
	{
		Vip vipper = (Vip) request.getAttribute("vip");
		
		vipService.create(vipper);
		
		request.setAttribute("vipList", vipService.QueryAll());
		
		return "/Back-Root/vip/vip-manager.jsp";
	}
	
	@RequestMapping("/VipEdit")
	public String vipEdit(HttpServletRequest request)
	{
		Vip vipper = (Vip) request.getAttribute("vip");
		
		vipService.modify(vipper);
		
		request.setAttribute("vipList", vipService.QueryAll());
		
		return "/Back-Root/vip/vip-manager.jsp";
	}
	
	@RequestMapping("/VipSubmit")
	public String vipSubmit(HttpServletRequest request,Vip vip)
	{
//		Vip vipper = (Vip) request.getSession().getAttribute("vip");
		
		vipService.submit(vip);
		
		request.setAttribute("vipList", vipService.QueryAll());
		
		return "/Back-Root/vip/vip-manager.jsp";
	}
}
