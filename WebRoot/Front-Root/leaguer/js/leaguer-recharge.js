/**
 * add by yangwc
 * leaguer-info.html的js
 */

$(function() {
	$(".sub-btn").click(function(){
		var openId = $("#openId").val();
		var balance = $("#balance").val();
		$.ajax({
	        url: '/business/leaguer/LeaguerEdit.java',
	        type: 'POST',
	        data: "openId="+openId+"&balance="+balance+"&type=RECHARGE",
	        dataType: "json",
	        success : function(data) {
	        	if(data == "SUCCESS"){
	        		window.location="leaguer-success.html";
	        	}else{
	        		$(".msg").html(data);
	        	}
	        }
		});
	})
})
