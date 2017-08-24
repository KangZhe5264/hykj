/**
 * add by yangwc
 * leaguer-info.html的js
 */

$(function() {
	
	$("#msgcontain").hide();
	$(".sub-btn").click(function(){
		var openId = $("#openId").val();
		var balance = $("#balance").val();
		if(balance == "" || balance == null){
			$("#msgcontain").show();
			$("#msg").html("金额不能为空");
		}else if(balance <= 0){
			$("#msgcontain").show();
			$("#msg").html("金额必须大于0");
		}
		$.ajax({
	        url: '/business/leaguer/LeaguerEdit.java',
	        type: 'POST',
	        data: "openId="+openId+"&balance="+balance+"&type=RECHARGE",
	        dataType: "json",
	        success : function(data) {
	        	if(data == "SUCCESS"){
	        		$.ajax({
	        	        url: '/business/leaguerLog/createLeaguerLog.java',
	        	        type: 'POST',
	        	        data: "openId="+openId+"&balance="+balance,
	        	        dataType: "json",
	        	        success : function(data) {
	        	        	if(data == "SUCCESS"){
	        	        		window.location="leaguer-success.html";
	        	        	}else{
	        	        		$("#msgcontain").show();
	        	    			$("#msg").html("数据提交失败");
	        	        	}
	        	        }
	        		});
	        	}else{
	        		$("#msgcontain").show();
	    			$("#msg").html("数据提交失败");
	        	}
	        }
		});
	})
	
	function getUrlParam(name){
		var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
		var r = window.location.search.substr(1).match(reg);  //匹配目标参数
		if (r!=null) return unescape(r[2]); return null; //返回参数值
	} 
	
	$("#openId").val(getUrlParam("openId"));
})
