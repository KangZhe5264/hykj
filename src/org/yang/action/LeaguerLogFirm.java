package org.yang.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
		
//		paramMap.put(key, value);
		
		request.setAttribute("logs", leaguerLogService.queryByCondition(paramMap));
		
		return "/Back-Root/LeaguerLog/leaguerLog.jsp";
	}

}
