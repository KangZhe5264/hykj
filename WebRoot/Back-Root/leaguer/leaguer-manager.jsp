<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
					<select name="where-id"></select>
					<label class="search-label">会员电话</label>
					<input class="search-input" name="where-userPhone" value=""/>
					<label class="search-label">会员姓名</label>
					<input class="search-input" name="where-userName" value=""/>
				</form>
				<button class="button">查 找</button>
			</div>
    	</div>
    	<div class="manager-list" align="center">
    		<table class="table-list" border="1" cellspacing="0" cellpadding="0">
	    		<thead>
	    			<tr>
		    			<th>序 号</th>
		    			<th>OpenId</th>
		    			<th>姓 名</th>
		    			<th>等级编号</th>
		    			<th>等 级</th>
		    			<th>联系电话</th>
		    			<th>账户余额</th>
		    			<th>累计充值</th>
		    			<th>支付密码</th>
		    		</tr>
		    	</thead>
	    		<tbody></tbody>
    		</table>
    	</div>
    	<div class="manager-detail" align="center">
    		<form id="form-detail">
	    		<div class="manager-pro">
	    			<input class="manager-input" type="hidden" name="openId" value=""/>
					<label class="manager-label">会员姓名</label>
					<input class="manager-input" name="userName" value=""/>
					<label class="manager-label">会员等级</label>
					<select class="manager-select" name="id"></select>
				</div>
				<div class="manager-pro">
					<label class="manager-label">会员电话</label>
					<input class="manager-input" name="userPhone" value=""/>
					<label class="manager-label">账户余额</label>
					<input class="manager-input" name="balance" value=""/>
				</div>
				<div class="manager-pro">
					<label class="manager-label">累计充值</label>
					<input class="manager-input" name="history" value=""/>
					<label class="manager-label">支付密码</label>
					<input class="manager-input" name="userPwd" value=""/>
				</div>
			</form>
			<div class="manager-pro">
				<button class="button_submit">提 交</button>
				<button class="button_delete">删 除</button>
			</div>
    	</div>
  	</body>
  	<script src="js/jquery-min.js"></script>
  	<script src="js/leaguer-manager.js"></script>
</html>
