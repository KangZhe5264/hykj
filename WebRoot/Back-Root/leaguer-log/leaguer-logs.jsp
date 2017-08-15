<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
    	<title>会员充值记录</title>
    	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
		<link rel="stylesheet" href="css/leaguer-logs.css">
  	</head>
  	
  	<body>
    	<div class="search">
    		<div class="search-pro">
				<label class="search-label">订单号</label>
				<input class="search-input" name="where-sequence" value=""/>
				<label class="search-label">订单类型</label>
				<input class="search-input" name="where-type" value=""/>
				<label class="search-label">会员姓名</label>
				<input class="search-input" name="where-userName" value=""/>
				<br>
				<label class="search-label">订单时间</label>
				<input class="search-input" name="where-lowTime" value=""/>-
				<input class="search-input" name="where-highTime" value=""/>
				<button class="button">查 找</button>
			</div>
    	</div>
    	<div class="manager-list" align="center">
    		<table class="table-list" border="1" cellspacing="0" cellpadding="0">
    			<tr>
    				<th>序 号</th>
	    			<th>订单号</th>
	    			<th>订单类型</th>
	    			<th>会员姓名</th>
	    			<th>金 额</th>
	    			<th>订单时间</th>
	    			<th>备注</th>
	    		</tr>
	    		<c:if test="${not empty logs}">
		           	<c:forEach items="${logs}" var="a" varStatus="s">
						<tr class="data">
							<td>${s.index}</td>
							<td>${a.sequence}</td>
							<td>${a.type}</td>
							<td>${a.leaguer.userName}</td>
							<td>${a.worths}</td>
							<td>${a.createTime}</td>
							<td>${a.info}</td>
						</tr>
					</c:forEach>
				</c:if>
    		</table>
    	</div>
  	</body>
  	<script src="js/jquery-min.js"></script>
  	<script src="js/leaguer-logs.js"></script>
</html>
