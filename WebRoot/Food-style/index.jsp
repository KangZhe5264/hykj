﻿<%@page import="org.yang.javabeans.FoodOrder"%>
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
<title>首页</title>
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
		<div class="right-product my-index right-full">
			<div class="container-fluid">
				<div class="info-center">

					<!---title----->
					<div class="info-title">
						<div class="pull-left">
							<h1>
								<strong>欢迎登录餐饮管理系统！</strong>
							</h1>

						</div>

						<div class="clearfix"></div>
					</div>
					<!----content-list---->
					<div class="content-list">
						<div class="row">
							<div class="col-md-3">
								<div class="content">
									<div class="w30 left-icon pull-left">
										<span class="glyphicon glyphicon-file blue"></span>
									</div>
									<div class="w70 right-title pull-right">
										<div class="title-content">
											<p>待审核</p>
											<h3 class="number">${nums}</h3>
											<button class="btn btn-default"
												onclick="location.href='/business/Food-style/FoodOrderInfo.java'">去处理</button>
										</div>
									</div>
									<div class="clearfix"></div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="content">
									<div class="w30 left-icon pull-left">
										<span class="glyphicon glyphicon-file violet"></span>
									</div>
									<div class="w70 right-title pull-right">
										<div class="title-content">
											<p>审核通过</p>
											<h3 class="number">${nums1}</h3>
											<button class="btn btn-default"
												onclick="location.href='/business/Food-style/FoodOrderOfPass.java'">查看</button>
										</div>
									</div>
									<div class="clearfix"></div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="content">
									<div class="w30 left-icon pull-left">
										<span class="glyphicon glyphicon-file orange"></span>
									</div>
									<div class="w70 right-title pull-right">
										<div class="title-content">
											<p>已驳回</p>
											<h3 class="number">${nums2}</h3>
											<button class="btn btn-default"
												onclick="location.href='/business/Food-style/FoodOrderOfTurn.java'">查看</button>
										</div>
									</div>
									<div class="clearfix"></div>
								</div>
							</div>

						</div>
						<!-------信息列表------->
						<div class="row newslist" style="margin-top:20px;">
							<div class="col-md-8">
								<div class="panel panel-default">
									<div class="panel-heading">
										最近订单
										<div class="caret"></div>

									</div>
									<%
										ArrayList<FoodOrder> list = (ArrayList<FoodOrder>) request.getAttribute("foodOrderList");
										Collections.reverse(list);
										int num = 0;
										for (FoodOrder foodOrder : list) {
											if (num == 5) {
												break;
											}
									%>

									<div class="panel-body">
										<div class="w15 pull-left">
											<img src="img/noavatar_middle.gif" width="25" height="25"
												alt="图片" class="img-circle">
											<%=foodOrder.getUserName()%>
										</div>
										<div class="w55 pull-left"><%=foodOrder.getArriveTime()%></div>
										<div class="w20 pull-left text-center"><%=foodOrder.getContactPhone()%></div>
										<div class="w10 pull-left text-center">
											<span class="text-green-main"><%=foodOrder.getAuditing()%></span>
										</div>
									</div>

									<%
										num++;
										}
									%>

								</div>
							</div>

							<div class="col-md-4">
								<div class="panel panel-default">
									<div class="panel-heading">技术支持</div>
									<div class="panel-body">
										<h4>大同惠业科技咨询有限公司</h4>
										</br> 客服电话：15103522023（康哲）
									</div>
								</div>

							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		setInterval('rep()', 1000 * 30);
		function rep() {
			location.href = "/business/Food-style/FoodOrderMsg.java";
	
		}
	
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
