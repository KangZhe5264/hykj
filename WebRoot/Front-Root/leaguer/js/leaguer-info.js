/**
 * add by yangwc
 * leaguer-info.html的js
 */
$(function() {
	
	var openId = $("#openId").val();
	
	$.ajax({
        url: '/business/leaguer/LeaguerFind.java',
        type: 'POST',
        data: "openId="+openId,
        dataType: "json",
        success : function(data) {
        	$("#userName").html(data.userName);
        	$("#balance").html(data.balance);
        	$("#openId").html(data.openId);
        	$("#levalName").html(data.vip.levalName);
        }
	});
	
	$("#recharge").click(function(){
		window.location="leaguer-recharge.html";
	})
	$("#record").click(function(){
		window.location="leaguer-record.html";
	})
	$("#repwd").click(function(){
		window.location="leaguer-repwd.html";
	})
})