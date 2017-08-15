<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
    	<title>会员信息管理</title>
    	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
		<link rel="stylesheet" href="css/leaguer-manager.css">
  	</head>
  	
  	<body>
    	<div class="search">
    		<div class="search-pro">
    			<form id="form-search">
					<label class="search-label">会员等级</label>
					<input class="search-input" name="levelName" value=""/>
					<label class="search-label">会员电话</label>
					<input class="search-input" name="levelName" value=""/>
					<label class="search-label">会员姓名</label>
					<input class="search-input" name="levelName" value=""/>
				</form>
				<button class="button">查 找</button>
			</div>
    	</div>
    	<div class="manager-list" align="center">
    		<table class="table-list" border="1" cellspacing="0" cellpadding="0">
    			<tr>
	    			<th>序 号</th>
	    			<th>姓 名</th>
	    			<th>等 级</th>
	    			<th>联系电话</th>
	    			<th>账户余额</th>
	    			<th>累计充值</th>
	    		</tr>
	    		<c:if test="${not empty leaguerList}">
		           	<c:forEach items="${leaguerList}" var="a" varStatus="s">
						<tr class="data">
							<td>${s.index}</td>
							<td>${a.userName}</td>
							<td>${a.vip.levalName}</td>
							<td>${a.userPhone}</td>
							<td>${a.balance}</td>
							<td>${a.history}</td>
						</tr>
					</c:forEach>
				</c:if>
    		</table>
    	</div>
    	<div class="manager-detail" align="center">
    		<form id="form-detail">
	    		<div class="manager-pro">
	    			<input class="manager-input" type="hidden" name="leaguer.openId" value=""/>
					<label class="manager-label">会员姓名</label>
					<input class="manager-input" name="leaguer.userName" value=""/>
				</div>
				<div class="manager-pro">
					<label class="manager-label">会员等级</label>
					<input class="manager-input" name="leaguer.vip.levalName" value=""/>
					<label class="manager-label">会员电话</label>
					<input class="manager-input" name="leaguer.userPhone" value=""/>
				</div>
				<div class="manager-pro">
					<label class="manager-label">账户余额</label>
					<input class="manager-input" name="leaguer.balance" value=""/>
					<label class="manager-label">累计充值</label>
					<input class="manager-input" name="leaguer.history" value=""/>
				</div>
			</form>
			<div class="manager-pro">
				<button class="button_add">新 增</button>
				<button class="button_submit">提 交</button>
				<button class="button_delete">删 除</button>
			</div>
    	</div>
  	</body>
  	<script src="js/jquery-min.js"></script>
  	<script src="js/leaguer-manager.js"></script>
</html>
