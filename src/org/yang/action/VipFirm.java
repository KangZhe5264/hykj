package org.yang.action;

import java.util.HashMap;
import java.util.Map;

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
	
	@RequestMapping("/VipCondition")
	public String vipCondition(HttpServletRequest request)
	{
		String cod1 = request.getParameter("where-levelName");
		
		Map<String,Object> paramMap = new HashMap<String,Object>();
		
		if(!"".equals(cod1) && cod1 != null){
			paramMap.put("levalName", cod1);
		}
		
		request.setAttribute("vipList", vipService.QueryByCondition(paramMap));
		
		return "/Back-Root/vip/vip-manager.jsp";
	}
	
	@RequestMapping("/VipDelete")
	public String vipDelete(HttpServletRequest request,Vip vipper)
	{
		vipService.removeVip(vipper);
		
		request.setAttribute("vipList", vipService.QueryAll());
		
		return "/Back-Root/vip/vip-manager.jsp";
	}
	
	@RequestMapping("/VipCreate")
	public String vipCreate(HttpServletRequest request,Vip vipper)
	{
		vipService.create(vipper);
		
		request.setAttribute("vipList", vipService.QueryAll());
		
		return "/Back-Root/vip/vip-manager.jsp";
	}
	
	@RequestMapping("/VipEdit")
	public String vipEdit(HttpServletRequest request,Vip vipper)
	{
		vipService.modify(vipper);
		
		request.setAttribute("vipList", vipService.QueryAll());
		
		return "/Back-Root/vip/vip-manager.jsp";
	}
	
	@RequestMapping("/VipSubmit")
	public void vipSubmit(HttpServletRequest request,Vip vip)
	{
		vipService.submit(vip);
		
		request.getSession().setAttribute("vipList", vipService.QueryAll());
	}
}
