/**
 * add by yangwc
 * leaguer-info.html的js
 */

$(function() {
	$("#sub-btn").click(function(){
		var firpwd = $(".userPwd").val();
		var secpwd = $(".sec-userPwd").val();
		var oldpwd = $(".oldPwd").val();
		var openId = $(".openId").val();
		if(firpwd != secpwd) {
			$("#msg").html("两次密码不一致");
			return;
		}
		$.ajax({
	        url: '/business/leaguer/LeaguerEdit.java',
	        type: 'POST',
	        data: "openId="+openId+"&oldPwd="+oldpwd+"&userPwd="+firpwd+"&type=REPWD",
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
