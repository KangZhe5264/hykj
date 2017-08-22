<%@page import="org.yang.javabeans.FoodOrder"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<title>订单管理</title>
<link href="bootstrap-3.3.5-dist/css/bootstrap.min.css" title=""
	rel="stylesheet" />
<link title="" href="css/style.css" rel="stylesheet" type="text/css" />
<link title="blue" href="css/dermadefault.css" rel="stylesheet"
	type="text/css" />
<link title="green" href="css/dermagreen.css" rel="stylesheet"
	type="text/css" disabled="disabled" />
<link title="orange" href="css/dermaorange.css" rel="stylesheet"
	type="text/css" disabled="disabled" />
<link href="css/templatecss.css" rel="stylesheet" title=""
	type="text/css" />
<script src="script/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="script/jquery.cookie.js" type="text/javascript"></script>
<script src="bootstrap-3.3.5-dist/js/bootstrap.min.js"
	type="text/javascript"></script>
</head>

<body>
	<nav class="nav navbar-default navbar-mystyle navbar-fixed-top">
	<div class="navbar-header">
		<button class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-collapse">
			<span class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
		</button>
		<a class="navbar-brand mystyle-brand"><span
			class="glyphicon glyphicon-home"></span></a>
	</div>
	<div class="collapse navbar-collapse">
		<ul class="nav navbar-nav">
			<li class="li-border"><a class="mystyle-color"
				href="/business/Food-style/FoodOrderMsg.java">餐饮管理系统</a></li>
			<li class="dropdown li-border"><a href="#"
				class="dropdown-toggle mystyle-color" data-toggle="dropdown">${message}<span
					class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="/business/Food-style/FoodOrderEnd.java">退出</a></li>
				</ul></li>
			<li class="dropdown"><a href="#"
				class="dropdown-toggle mystyle-color" data-toggle="dropdown">换肤<span
					class="caret"></span></a>
				<ul class="dropdown-menu changecolor">
					<li id="blue"><a href="#">蓝色</a></li>
					<li class="divider"></li>
					<li id="green"><a href="#">绿色</a></li>
					<li class="divider"></li>
					<li id="orange"><a href="#">橙色</a></li>
				</ul></li>
		</ul>
	</div>
	</nav>
	<div class="down-main">
		<div class="left-main left-full">
			<div class="sidebar-fold">
				<span class="glyphicon glyphicon-menu-hamburger"></span>
			</div>
			<div class="subNavBox">
				<div class="sBox">
					<div class="subNav sublist-down">
						<span class="title-icon glyphicon glyphicon-chevron-down"></span><span
							class="sublist-title">控制中心</span>
					</div>
					<ul class="navContent" style="display:block">
						<li>
							<div class="showtitle" style="width:100px;">
								<img src="img/leftimg.png" />订单管理
							</div> <a href="/business/Food-style/FoodOrderInfo.java"><span
								class="sublist-icon glyphicon glyphicon-envelope"></span><span
								class="sub-title">订单管理</span></a>
						</li>
					</ul>
				</div>
				<div class="sBox"></div>
			</div>
		</div>
		<div class="right-product right-off">
			<div class="container-fluid">
				<div class="info-center">
					<div class="page-header">
						<div class="pull-left">
							<h4>订单管理</h4>
						</div>
					</div>
					<div class="info-center-title">
						<span class="padding-large-right manage-title pull-left"> <a
							class="" href="/business/Food-style/FoodOrderInfo.java">待审核(${nums})</a>
						</span> <span class="padding-large-right pull-left"><a
							href="/business/Food-style/FoodOrderOfPass.java">已通过(${nums1})</a></span>
						<span class="pull-left"><a
							href="/business/Food-style/FoodOrderOfTurn.java">已驳回(${nums2})</a></span>
						<span class="pull-right"><a
							href="/business/Food-style/FoodOrderOfAll.java">全部信息</a></span>
					</div>

					<div class="clearfix"></div>
					<div class="table-margin">
						<table class="table table-bordered table-header">
							<thead>
								<tr>

									<td class="w15">客户名称</td>
									<td class="w15">联系方式</td>
									<td class="w15">到店时间</td>
									<td class="w15">预计人数</td>
									<td class="w15">类别</td>
									<td class="w15">订单状态</td>
									<td class="w15">审核状态</td>
									<td class="w15">操作</td>
								</tr>
							</thead>
							<tbody>
								<%
									ArrayList<FoodOrder> list = (ArrayList<FoodOrder>) request.getAttribute("foodOrderList");
									Collections.reverse(list);
									int num = 0;
									for (FoodOrder foodOrder : list) {
								%>
								<tr>
									<td><%=foodOrder.getUserName()%></td>
									<td><%=foodOrder.getContactPhone()%></td>
									<td><%=foodOrder.getArriveTime()%></td>
									<td><%=foodOrder.getQuantity()%></td>
									<td><%=foodOrder.getFood_department_fk()%></td>
									<td><%=foodOrder.getObligate()%></td>
									<td><%=foodOrder.getAuditing()%></td>
									<%
										if (foodOrder.getAuditing().equals("待审核")) {
									%>
									<td><a
										href="/business/Food-style/FoodOrderEdit.java?oper=pass&id=<%=foodOrder.getSerial()%>&username=<%=foodOrder.getUserName()%>&userphone=<%=foodOrder.getContactPhone()%>&food_department_fk=<%=foodOrder.getFood_department_fk()%>&arriveTime=<%=foodOrder.getArriveTime()%>&quantity=<%=foodOrder.getQuantity()%>&openid=<%=foodOrder.getOpenid()%>"><span
											style="color:green;">通过</span></a><a
										href="/business/Food-style/FoodOrderEdit.java?oper=turn&id=<%=foodOrder.getSerial()%>&username=<%=foodOrder.getUserName()%>&userphone=<%=foodOrder.getContactPhone()%>&food_department_fk=<%=foodOrder.getFood_department_fk()%>&arriveTime=<%=foodOrder.getArriveTime()%>&quantity=<%=foodOrder.getQuantity()%>&openid=<%=foodOrder.getOpenid()%>"><span
											style="color:red;">驳回</span></a></td>
									<%
										} else if (foodOrder.getAuditing().equals("驳回")) {
									%>
									<td><a
										href="/business/Food-style/FoodOrderEdit.java?oper=pass&id=<%=foodOrder.getSerial()%>&username=<%=foodOrder.getUserName()%>&userphone=<%=foodOrder.getContactPhone()%>&food_department_fk=<%=foodOrder.getFood_department_fk()%>&arriveTime=<%=foodOrder.getArriveTime()%>&quantity=<%=foodOrder.getQuantity()%>&openid=<%=foodOrder.getOpenid()%>"><span
											style="color:green;">取消驳回</span></a></td>
									<%
										} else if (foodOrder.getAuditing().equals("审核通过")) {
									%>
									<td><a
										href="/business/Food-style/FoodOrderEdit.java?oper=turn&id=<%=foodOrder.getSerial()%>&username=<%=foodOrder.getUserName()%>&userphone=<%=foodOrder.getContactPhone()%>&food_department_fk=<%=foodOrder.getFood_department_fk()%>&arriveTime=<%=foodOrder.getArriveTime()%>&quantity=<%=foodOrder.getQuantity()%>&openid=<%=foodOrder.getOpenid()%>"><span
											style="color:red;">取消</span></a></td>
									<%
										}
									%>
								</tr>
								<%
									}
								%>
							</tbody>
						</table>
					</div>
				</div>
				<div class="show-page hidden">
					<ul>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			/*换肤*/
			$(".dropdown .changecolor li").click(function() {
				var style = $(this).attr("id");
				$("link[title!='']").attr("disabled", "disabled");
				$("link[title='" + style + "']").removeAttr("disabled");
	
				$.cookie('mystyle', style, {
					expires : 7
				}); // 存储一个带7天期限的 cookie 
			})
			var cookie_style = $.cookie("mystyle");
			if (cookie_style != null) {
				$("link[title!='']").attr("disabled", "disabled");
				$("link[title='" + cookie_style + "']").removeAttr("disabled");
			}
			/*左侧导航栏显示隐藏功能*/
			$(".subNav").click(function() {
				/*显示*/
				if ($(this).find("span:first-child").attr('class') == "title-icon glyphicon glyphicon-chevron-down") {
					$(this).find("span:first-child").removeClass("glyphicon-chevron-down");
					$(this).find("span:first-child").addClass("glyphicon-chevron-up");
					$(this).removeClass("sublist-down");
					$(this).addClass("sublist-up");
				}
				/*隐藏*/
				else {
					$(this).find("span:first-child").removeClass("glyphicon-chevron-up");
					$(this).find("span:first-child").addClass("glyphicon-chevron-down");
					$(this).removeClass("sublist-up");
					$(this).addClass("sublist-down");
				}
				// 修改数字控制速度， slideUp(500)控制卷起速度
				$(this).next(".navContent").slideToggle(300).siblings(".navContent").slideUp(300);
			})
			/*左侧导航栏缩进功能*/
			$(".left-main .sidebar-fold").click(function() {
	
				if ($(this).parent().attr('class') == "left-main left-full") {
					$(this).parent().removeClass("left-full");
					$(this).parent().addClass("left-off");
	
					$(this).parent().parent().find(".right-product").removeClass("right-full");
					$(this).parent().parent().find(".right-product").addClass("right-off");
	
	
				} else {
					$(this).parent().removeClass("left-off");
					$(this).parent().addClass("left-full");
	
					$(this).parent().parent().find(".right-product").removeClass("right-off");
					$(this).parent().parent().find(".right-product").addClass("right-full");
	
	
				}
			})
	
			/*左侧鼠标移入提示功能*/
			$(".sBox ul li").mouseenter(function() {
				if ($(this).find("span:last-child").css("display") == "none") {
					$(this).find("div").show();
				}
			}).mouseleave(function() {
				$(this).find("div").hide();
			})
		})
	</script>
</body>
</html>
