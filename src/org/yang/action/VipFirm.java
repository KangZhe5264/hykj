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
import org.yang.javabeans.Vip;
import org.yang.service.VipService;

@Controller
@RequestMapping("/vip")
public class VipFirm {

	@Autowired
	private VipService vipService;
	
	@RequestMapping("/VipManage")
	public @ResponseBody List<Vip> vipManage(HttpServletRequest request)
	{
		List<Vip> vips = new ArrayList<Vip>();
		for(Vip vip:vipService.QueryAll()){
			Vip v = new Vip();
			v.setId(vip.getId());
			v.setLandmark(vip.getLandmark());
			v.setLevalName(vip.getLevalName());
			v.setRole(vip.getRole());
			vips.add(v);
		}
		
		return vips;
	}
	
	@RequestMapping("/VipCondition")
	public @ResponseBody List<Vip> vipCondition(HttpServletRequest request)
	{
		String cod1 = request.getParameter("where-levelName");
		
		Map<String,Object> paramMap = new HashMap<String,Object>();
		
		if(!"".equals(cod1) && cod1 != null){
			paramMap.put("levalName", cod1);
		}
		
		List<Vip> vips = new ArrayList<Vip>();
		for(Vip vip:vipService.QueryByCondition(paramMap)){
			Vip v = new Vip();
			v.setId(vip.getId());
			v.setLandmark(vip.getLandmark());
			v.setLevalName(vip.getLevalName());
			v.setRole(vip.getRole());
			vips.add(v);
		}
		
		return vips;
	}
	
	@RequestMapping("/VipDelete")
	public @ResponseBody List<Vip> vipDelete(HttpServletRequest request,Vip vipper)
	{
		vipService.removeVip(vipper);
		
		List<Vip> vips = new ArrayList<Vip>();
		for(Vip vip:vipService.QueryAll()){
			Vip v = new Vip();
			v.setId(vip.getId());
			v.setLandmark(vip.getLandmark());
			v.setLevalName(vip.getLevalName());
			v.setRole(vip.getRole());
			vips.add(v);
		}
		
		return vips;
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
	public @ResponseBody List<Vip> vipSubmit(HttpServletRequest request,Vip vip)
	{
		vipService.submit(vip);
		
		List<Vip> vips = new ArrayList<Vip>();
		for(Vip temp:vipService.QueryAll()){
			Vip v = new Vip();
			v.setId(temp.getId());
			v.setLandmark(temp.getLandmark());
			v.setLevalName(temp.getLevalName());
			v.setRole(temp.getRole());
			vips.add(v);
		}
		
		return vips;
	}
}
