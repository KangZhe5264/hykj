<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<title>订餐</title>

<link href="css/form.css" rel="stylesheet" type="text/css">
</head>
<body>

<div id="subjects">
		<div class="form_ctrl page_head" id="1" title="订餐" style="color: white; background-color: rgb(255, 108, 0)"><h2>订餐</h2></div>
		
						<div class="form_goods_image" style="background-image:url(images/v5_data/pic/z.jpg);" onClick="location.href='food_info.jsp?food_department_fk=中餐厅';"></div>
						
						<div class="form_goods_image" style="background-image:url(images/v5_data/pic/x.jpg);" onClick="location.href='food_info.jsp?food_department_fk=西餐厅';"></div>
						
						<div class="form_goods_image" style="background-image:url(images/v5_data/pic/h.jpg);" onClick="location.href='food_info.jsp?food_department_fk=汉餐厅';"></div>
</div>

<script src="js/vdata/form.min.js" type="text/javascript"></script>

</body>
</html>