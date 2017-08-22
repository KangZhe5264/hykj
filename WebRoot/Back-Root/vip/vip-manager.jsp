<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    	<title>会员类型管理</title>
		<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
		<link rel="stylesheet" href="css/vip-manager.css">
  	</head>
  	
  	<body>
    	<div class="search">
    		<div class="search-pro">
    			<form id="form-search">
					<label class="search-label">会员等级</label>
					<input class="search-input" name="where-levelName" value=""/>
				</form>
				<button class="button">查 找</button>
			</div>
    	</div>
    	<div class="manager-list" align="center">
    		<table class="table-list" border="1" cellspacing="0" cellpadding="0">
    			<thead>
	    			<tr>
		    			<th>序 号</th>
		    			<th>会员编号</th>
		    			<th>会员等级</th>
		    			<th>到达金额</th>
		    			<th>优惠方式</th>
		    		</tr>
    			</thead>
    			<tbody></tbody>
    		</table>
    	</div>
    	<div class="manager-detail" align="center">
    		<form id="form-detail">
	    		<div class="manager-pro">
	    			<input class="manager-input" type="hidden" name="id" value=""/>
					<label class="manager-label">会员等级</label>
					<input class="manager-input" name="levalName" value=""/>
					<label class="manager-label">到达金额</label>
					<input class="manager-input" name="landmark" value=""/>
				</div>
				<div class="manager-pro">
					<label class="manager-label">优惠方式</label>
					<input class="manager-input" name="role" value=""/>
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
  	<script src="js/vip-manager.js"></script>
</html>
