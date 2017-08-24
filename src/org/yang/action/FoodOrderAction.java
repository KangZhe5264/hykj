package org.yang.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yang.javabeans.FoodOrder;
import org.yang.service.FoodOrderService;

import utils.WXUtils;



@Controller
@RequestMapping("/Food-style")
public class FoodOrderAction {

	@Autowired
	private FoodOrderService foodOrderService;

	@RequestMapping("/Login")
	public String login(HttpServletRequest request) {
		String manager = (String) request.getParameter("manager");
		String magPwd = (String) request.getParameter("magPwd");
		if (manager.equals("wfhazct0352") && magPwd.equals("wfhazct0352")) {

			HttpSession session = request.getSession();
			session.setAttribute("manager", "中餐厅");
			List<FoodOrder> foodOrderList = foodOrderService.QueryAll("中餐厅");
			int nums = 0;
			int nums1 = 0;
			int nums2 = 0;
			for (FoodOrder foodOrder : foodOrderList) {
				if (foodOrder.getAuditing().equals("待审核")) {
					nums++;
				}
				if (foodOrder.getAuditing().equals("审核通过")) {
					nums1++;
				}
				if (foodOrder.getAuditing().equals("驳回")) {
					nums2++;
				}

			}
			request.setAttribute("message", "中餐厅");
			request.setAttribute("foodOrderList", foodOrderList);
			request.setAttribute("nums", nums);
			request.setAttribute("nums1", nums1);
			request.setAttribute("nums2", nums2);
			return "/Food-style/index.jsp";
		} else if (manager.equals("wfhaxct0352") && magPwd.equals("wfhaxct0352")) {
			HttpSession session = request.getSession();
			session.setAttribute("manager", "西餐厅");
			List<FoodOrder> foodOrderList = foodOrderService.QueryAll("西餐厅");
			int nums = 0;
			int nums1 = 0;
			int nums2 = 0;
			for (FoodOrder foodOrder : foodOrderList) {
				if (foodOrder.getAuditing().equals("待审核")) {
					nums++;
				}
				if (foodOrder.getAuditing().equals("审核通过")) {
					nums1++;
				}
				if (foodOrder.getAuditing().equals("驳回")) {
					nums2++;
				}

			}
			request.setAttribute("message", "西餐厅");
			request.setAttribute("foodOrderList", foodOrderList);
			request.setAttribute("nums", nums);
			request.setAttribute("nums1", nums1);
			request.setAttribute("nums2", nums2);
			return "/Food-style/index.jsp";
		} else if (manager.equals("wfhahct0352") && magPwd.equals("wfhahct0352")) {
			HttpSession session = request.getSession();
			session.setAttribute("manager", "韩餐厅");
			List<FoodOrder> foodOrderList = foodOrderService.QueryAll("韩餐厅");
			int nums = 0;
			int nums1 = 0;
			int nums2 = 0;
			for (FoodOrder foodOrder : foodOrderList) {
				if (foodOrder.getAuditing().equals("待审核")) {
					nums++;
				}
				if (foodOrder.getAuditing().equals("审核通过")) {
					nums1++;
				}
				if (foodOrder.getAuditing().equals("驳回")) {
					nums2++;
				}

			}
			request.setAttribute("message", "韩餐厅");
			request.setAttribute("foodOrderList", foodOrderList);
			request.setAttribute("nums", nums);
			request.setAttribute("nums1", nums1);
			request.setAttribute("nums2", nums2);
			return "/Food-style/index.jsp";
		} else {
			return "/Food-style/login.jsp";
		}
	}

	@RequestMapping("/FoodOrderMsg")
	public String foodOrderIndex(HttpServletRequest request) {
		// request.setAttribute("foodOrderList", foodOrderService.QueryAll());

		HttpSession session = request.getSession();
		String message = (String) session.getAttribute("manager");
		System.out.println(message);
		List<FoodOrder> foodOrderList = foodOrderService.QueryAll(message);
		int nums = 0;
		int nums1 = 0;
		int nums2 = 0;
		for (FoodOrder foodOrder : foodOrderList) {
			if (foodOrder.getAuditing().equals("待审核")) {
				nums++;
			}
			if (foodOrder.getAuditing().equals("审核通过")) {
				nums1++;
			}
			if (foodOrder.getAuditing().equals("驳回")) {
				nums2++;
			}

		}
		request.setAttribute("message", message);
		request.setAttribute("foodOrderList", foodOrderList);
		request.setAttribute("nums", nums);
		request.setAttribute("nums1", nums1);
		request.setAttribute("nums2", nums2);
		return "/Food-style/index.jsp";
	}

	@RequestMapping("/FoodOrderInfo")
	public String foodOrderInfo(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String message = (String) session.getAttribute("manager");
		List<FoodOrder> foodOrderList = foodOrderService.QueryAll(message);
		ArrayList<FoodOrder> list = new ArrayList<FoodOrder>();
		int nums = 0;
		int nums1 = 0;
		int nums2 = 0;
		for (FoodOrder foodOrder : foodOrderList) {
			if (foodOrder.getAuditing().equals("待审核")) {
				list.add(foodOrder);
				nums++;
			}
			if (foodOrder.getAuditing().equals("审核通过")) {
				nums1++;
			}
			if (foodOrder.getAuditing().equals("驳回")) {
				nums2++;
			}
		}
		request.setAttribute("message", message);
		request.setAttribute("foodOrderList", list);
		request.setAttribute("nums", nums);
		request.setAttribute("nums1", nums1);
		request.setAttribute("nums2", nums2);
		return "/Food-style/message.jsp";
	}

	@RequestMapping("/FoodOrderOfPass")
	public String foodOrderOfPass(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String message = (String) session.getAttribute("manager");
		List<FoodOrder> foodOrderList = foodOrderService.QueryAll(message);
		ArrayList<FoodOrder> list = new ArrayList<FoodOrder>();
		int nums = 0;
		int nums1 = 0;
		int nums2 = 0;
		for (FoodOrder foodOrder : foodOrderList) {
			if (foodOrder.getAuditing().equals("待审核")) {
				nums++;
			}
			if (foodOrder.getAuditing().equals("审核通过")) {
				list.add(foodOrder);
				nums1++;
			}
			if (foodOrder.getAuditing().equals("驳回")) {
				nums2++;
			}

		}
		request.setAttribute("message", message);
		request.setAttribute("foodOrderList", list);
		request.setAttribute("nums", nums);
		request.setAttribute("nums1", nums1);
		request.setAttribute("nums2", nums2);
		return "/Food-style/message.jsp";
	}

	@RequestMapping("/FoodOrderOfTurn")
	public String foodOrderOfTurn(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String message = (String) session.getAttribute("manager");
		List<FoodOrder> foodOrderList = foodOrderService.QueryAll(message);
		ArrayList<FoodOrder> list = new ArrayList<FoodOrder>();
		int nums = 0;
		int nums1 = 0;
		int nums2 = 0;
		for (FoodOrder foodOrder : foodOrderList) {
			if (foodOrder.getAuditing().equals("待审核")) {
				nums++;
			}
			if (foodOrder.getAuditing().equals("审核通过")) {

				nums1++;
			}
			if (foodOrder.getAuditing().equals("驳回")) {
				list.add(foodOrder);
				nums2++;
			}

		}
		request.setAttribute("message", message);
		request.setAttribute("foodOrderList", list);
		request.setAttribute("nums", nums);
		request.setAttribute("nums1", nums1);
		request.setAttribute("nums2", nums2);
		return "/Food-style/message.jsp";
	}

	@RequestMapping("/FoodOrderOfAll")
	public String foodOrderOfAll(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String message = (String) session.getAttribute("manager");
		List<FoodOrder> foodOrderList = foodOrderService.QueryAll(message);
		int nums = 0;
		int nums1 = 0;
		int nums2 = 0;
		for (FoodOrder foodOrder : foodOrderList) {
			if (foodOrder.getAuditing().equals("待审核")) {
				nums++;
			}
			if (foodOrder.getAuditing().equals("审核通过")) {

				nums1++;
			}
			if (foodOrder.getAuditing().equals("驳回")) {
				nums2++;
			}

		}
		request.setAttribute("message", message);
		request.setAttribute("foodOrderList", foodOrderList);
		request.setAttribute("nums", nums);
		request.setAttribute("nums1", nums1);
		request.setAttribute("nums2", nums2);
		return "/Food-style/message.jsp";
	}

	@RequestMapping("/FoodOrderEdit")
	public String foodOrderEdit(HttpServletRequest request) {

		String oper = request.getParameter("oper");
		String serial = request.getParameter("id");
		String userName = request.getParameter("username");
		String food_department_fk = request.getParameter("food_department_fk");
		String arriveTime = request.getParameter("arriveTime");
		String contactPhone = request.getParameter("userphone");
		String quantity = request.getParameter("quantity");
		String openid = request.getParameter("openid");
		if (oper.equals("pass")) {
			String auditing = "审核通过";
			String obligate = "订单可用";
			foodOrderService.modify(new FoodOrder(userName, serial, food_department_fk, arriveTime, auditing, obligate,
					contactPhone, quantity, openid));
			WXUtils.sendMsg(openid, userName, arriveTime, auditing);
			
			return "redirect:/Food-style/FoodOrderOfPass.java";
		} else if (oper.equals("turn")) {
			String auditing = "驳回";
			String obligate = "订单取消";
			foodOrderService.modify(new FoodOrder(userName, serial, food_department_fk, arriveTime, auditing, obligate,
					contactPhone, quantity, openid));
			WXUtils.sendMsg(openid, userName, arriveTime, auditing) ;
			return "redirect:/Food-style/FoodOrderOfTurn.java";
		} else {
			return "redirect:/Food-style/FoodOrderInfo.java";
		}
	}

	@RequestMapping("/FoodOrderFrontEndCreate")
	public String foodOrderFrontEnd(HttpServletRequest request, FoodOrder foodOrder) {
		String arriveTime =  request.getParameter("arriveTime");
		String timeInterval =  request.getParameter("timeInterval");
		String food_department_fk =  request.getParameter("food_department_fk");
		String openId=request.getParameter("openId");
		foodOrder.setArriveTime(arriveTime + timeInterval);
		foodOrder.setAuditing("待审核");
		foodOrder.setObligate("订单未生效");
		foodOrder.setFood_department_fk(food_department_fk);
		foodOrder.setOpenid(openId);
		foodOrderService.create(foodOrder);

		return "/Food-style/food_success.jsp?openId="+openId;
	}

	@RequestMapping("/FoodOrderEnd")
	public String foodOrderEnd(HttpServletRequest request,HttpSession session) {
		request.removeAttribute("manager");
		request.removeAttribute("message");
		request.removeAttribute("foodOrderList");
		request.removeAttribute("nums");
		request.removeAttribute("nums1");
		request.removeAttribute("nums2");
		session.removeAttribute("manager");
		return "/Food-style/login.jsp";
	}
	@RequestMapping("/FoodOrderAccess")
	public String foodOrderAccess(HttpServletRequest request) {
		String code=request.getParameter("code");
		String openId=WXUtils.getOpenId(request, code);
		return "/Food-style/food_index.jsp?openId="+openId;
		
	}
	

}
