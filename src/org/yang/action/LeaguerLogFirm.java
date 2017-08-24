package org.yang.action;

import java.sql.Timestamp;
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
import org.yang.javabeans.LeaguerLog;
import org.yang.service.LeaguerLogService;
import org.yang.service.LeaguerService;

/**
 * @author yangwc
 * @function LeaguerLogµÄactionÀà
 */

@Controller
@RequestMapping("/leaguerLog")
public class LeaguerLogFirm {
	
	@Autowired
	private LeaguerLogService leaguerLogService;
	@Autowired
	private LeaguerService leaguerService;
	
	@RequestMapping("/selectAll")
	public @ResponseBody List<LeaguerLog> selectAll(HttpServletRequest request){
		
		List<LeaguerLog> leaguerLogs = new ArrayList<LeaguerLog>();
		for(LeaguerLog leaguerlog:leaguerLogService.queryAll()){
			LeaguerLog temp = new LeaguerLog();
			Leaguer lea = new Leaguer();
			temp.setSequence(leaguerlog.getSequence());
			temp.setType(leaguerlog.getType());
			temp.setCreateTime(leaguerlog.getCreateTime());
			temp.setInfo(leaguerlog.getInfo());
			temp.setWorths(leaguerlog.getWorths());
			lea.setOpenId(leaguerlog.getLeaguer().getOpenId());
			lea.setUserName(leaguerlog.getLeaguer().getUserName());
			temp.setLeaguer(lea);
			leaguerLogs.add(temp);
		}
		
		return leaguerLogs;
	}
	
	@RequestMapping("/selectMine")
	public @ResponseBody List<LeaguerLog> selectMine(HttpServletRequest request){
		
		String openId = request.getParameter("openId");
		List<LeaguerLog> leaguerLogs = leaguerLogService.queryMine(openId);
		
		List<LeaguerLog> newLogs = new ArrayList<LeaguerLog>();
		
		for(LeaguerLog temp : leaguerLogs){
			LeaguerLog log = new LeaguerLog();
			log.setWorths(temp.getWorths());
			log.setInfo(temp.getCreateTime().toString());
			newLogs.add(log);
		}
		
		return newLogs;
	}
	
	@RequestMapping("/selectByCondition")
	public @ResponseBody List<LeaguerLog> selectByCondition(HttpServletRequest request){
		
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
		
		List<LeaguerLog> leaguerLogs = new ArrayList<LeaguerLog>();
		for(LeaguerLog leaguerlog:leaguerLogService.queryByCondition(paramMap,cod4,cod5)){
			LeaguerLog temp = new LeaguerLog();
			Leaguer lea = new Leaguer();
			temp.setSequence(leaguerlog.getSequence());
			temp.setType(leaguerlog.getType());
			temp.setCreateTime(leaguerlog.getCreateTime());
			temp.setInfo(leaguerlog.getInfo());
			temp.setWorths(leaguerlog.getWorths());
			lea.setOpenId(leaguerlog.getLeaguer().getOpenId());
			lea.setUserName(leaguerlog.getLeaguer().getUserName());
			temp.setLeaguer(lea);
			leaguerLogs.add(temp);
		}
		
		return leaguerLogs;
	}

	@RequestMapping("/createLeaguerLog")
	public @ResponseBody String createLog(HttpServletRequest request){
		
		String openId = request.getParameter("openId");
		String balance = request.getParameter("balance");
		
		try{
			Leaguer leaguer = new Leaguer();
			leaguer = leaguerService.getUserByOpenid(openId);
		
			LeaguerLog leaguerLog = new LeaguerLog();
			leaguerLog.setCreateTime(new Timestamp(System.currentTimeMillis()));
			leaguerLog.setInfo("");
			leaguerLog.setLeaguer(leaguer);
			leaguerLog.setType("³ä Öµ");
			leaguerLog.setWorths(Double.parseDouble(balance));
			
			leaguerLogService.createLog(leaguerLog);
			
			return "SUCCESS";
		
		}catch(Exception e){
			return "ERROR";
		}
	}
}
