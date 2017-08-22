<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<title>订餐</title>

<link href="css/form.css" rel="stylesheet" type="text/css">
<%
String food_department_fk=request.getParameter("food_department_fk");
%>
</head>
<body>

<div id="subjects">
	<form id="main_form" action="/business/Food-style/FoodOrderFrontEndCreate.java" method="post" accept-charset="utf-8" style="padding-bottom: 4em;">
	
	
		<div class="form_ctrl page_head" id="1" title="订房" style="color: white; background-color:  rgb(255, 108, 0)"><h2>订餐</h2></div>
		<div class="form_ctrl input_text" id="3" title="姓名">
			<label class="ctrl_title">姓名</label>
			<input type="text" name="userName" value="" placeholder="请输入姓名">
		</div>
		<div class="form_ctrl input_text" id="2" title="openid">
			<label class="ctrl_title">openid</label>
			<input type="text" name="openid" value="" placeholder="请输入openid">
		</div>
		<div class="form_ctrl input_text" id="4" title="联系电话">
			<label class="ctrl_title">联系电话</label>
			<input type="text" name="contactPhone" value="" placeholder="请输入电话号码">
		</div>
		<div class="form_ctrl input_date" id="7" title="入住日期">
			<label class="ctrl_title">到店日期</label>
			<input type="text" readonly="" name="arriveTime" placeholder="请输入日期" onClick="editDate(event);" value="2013-09-27">
		</div>
		<input type="text" style="display:none" name="food_department_fk" value=<%=food_department_fk%>>
		
		<div class="form_ctrl form_select" id="5" title="称呼">
			<label class="ctrl_title">选择餐段</label>
			<select name="timeInterval"><option value="午餐">午餐</option><option value="晚餐">晚餐</option></select>
			<div></div>
		</div>
		
		<div class="form_ctrl form_select" id="8" title="人数">
			<label class="ctrl_title">预定人数</label>
			<select name="quantity" >
				<option value="1~5人">1~5人</option>
				<option value="6~10人">6~10人</option>
				<option value="10~15人">10~15人</option>
				<option value="更多">更多</option>
			</select>
			<div></div>
		</div>
	
		<div class="form_ctrl form_submit" id="9" title="点击按钮预订房间">
			<label class="ctrl_title">点击按钮预订</label>
			<input type="submit" name="submit" value="提交" style="color: white; background-color: rgb(255, 108, 0);">
		
		</div>
			

<a href="tel:15103522023" style="color: white; background-color: blue;padding:5px 20px;font-size:16px;font-weight:bold;text-decoration:none;border:1px solid blue;margin-left:10px">电话预定</a>
			</form>
</div>

<script src="js/vdata/form.min.js" type="text/javascript"></script>

</body>
</html>