/**
 * add by yangwc
 * leaguer-info.html的js
 */

$(function() {
	
	var openId = getUrlParam("openId");
	var codeval = "";
	
	$("#msgcontain").hide();
	$.ajax({
        url: '/business/leaguer/LeaguerFind.java',
        type: 'POST',
        data: "openId="+openId,
        dataType: "json",
        success : function(data) {
        	$("#userPhone").val(data.userPhone);
        }
	});
	
	$(".sub-btn").click(function(){
		var firpwd = $("#userPwd").val();
		var secpwd = $("#sec-userPwd").val();
		var code = $("#code").val();
		if(firpwd != secpwd) {
			$("#msgcontain").show();
			$("#msg").html("两次密码不一致");
			return;
		}else if(code != codeval){
			$("#msgcontain").show();
			$("#msg").html("验证码错误，请核查");
			return;
		}else if(firpwd == "" || firpwd == null){
			$("#msgcontain").show();
			$("#msg").html("新密码不能为空");
			return;
		}else if(code == "" || code == null){
			$("#msgcontain").show();
			$("#msg").html("验证码不能为空");
			return;
		}
		$.ajax({
	        url: '/business/leaguer/LeaguerEdit.java',
	        type: 'POST',
	        data: "openId="+openId+"&userPwd="+firpwd+"&type=REPWD",
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
	
	$(".code-btn").click(function(){
		codeval = RndNum(4);
		alert(codeval);
		$("#codetemp").val(codeval);
		var count = 60;
        var countdown = setInterval(CountDown, 1000);
        function CountDown() {
            $(".code-btn").attr("disabled", true);
            $(".code-btn").css("background", "gray");
            $(".code-btn").html(count + "秒");
            if (count == 0) {
                $(".code-btn").html("获 取").removeAttr("disabled");
                $(".code-btn").css("background", "rgb(12,152,194)");
                clearInterval(countdown);
            }
            count--;
        }
	})
	
	function getUrlParam(name){
		var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
		var r = window.location.search.substr(1).match(reg);  //匹配目标参数
		if (r!=null) return unescape(r[2]); return null; //返回参数值
	} 
	
	function RndNum(n){
	    var rnd="";
	    for(var i=0;i < n;i++)
	        rnd += Math.floor(Math.random()*10);
	    return rnd;
	}
})
