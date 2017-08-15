package org.yang.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yang.javabeans.Leaguer;
import org.yang.service.LeaguerLogService;

/**
 * @author yangwc
 * @function LeaguerLogµÄactionÀà
 */

@Controller
@RequestMapping("/leaguerLog")
public class LeaguerLogFirm {
	
	@Autowired
	private LeaguerLogService leaguerLogService;
	
	@RequestMapping("/selectAll")
	public String selectAll(HttpServletRequest request){
		
		request.setAttribute("logs", leaguerLogService.queryAll());
		
		return "/Back-Root/LeaguerLog/leaguerLog.jsp";
	}
	
	@RequestMapping("/selectMine")
	public String selectMine(HttpServletRequest request){
		String openId = (String)request.getAttribute("openId");
		request.setAttribute("logs", leaguerLogService.queryMine(openId));
		
		return "/Back-Root/LeaguerLog/leaguerLog-mine.jsp";
	}
	
	@RequestMapping("/selectByCondition")
	public String selectByCondition(HttpServletRequest request){
		
		Map<String,Object> paramMap = new HashMap<String,Object>();
		String cod1 = request.getParameter("where-sequence");
		String cod2 = request.getParameter("where-type");
		String cod3 = request.getParameter("where-userName");
		String cod4 = request.getParameter("where-lowTime");
		String cod5 = request.getParameter("where-highTime");
		
		if(!"".equals(cod1) && cod1 != null){
			paramMap.put("sequence", cod1);
		}
		if(!"".equals(cod2) && cod2 != null){
			paramMap.put("type", cod2);
		}
		if(!"".equals(cod3) && cod3 != null){
			Leaguer leaguer = new Leaguer();
			leaguer.setUserName(cod3);
			paramMap.put("leaguer", leaguer);
		}
		
		request.setAttribute("logs", leaguerLogService.queryByCondition(paramMap,cod4,cod5));
		
		return "/Back-Root/LeaguerLog/leaguerLog.jsp";
	}

}
