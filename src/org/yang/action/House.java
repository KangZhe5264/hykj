package org.yang.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yang.service.DemoService;

@Controller
@RequestMapping("/house")
public class House {

	@Autowired
	private DemoService demoService;
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request)
	{
		request.setAttribute("arg", demoService.demo());
		
		return "/index.jsp";
	}
}
