/**
 * add by yangwc
 * leaguer-info.html的js
 */

$(function() {
	$("#msgcontain").hide();
	$("#openId").val(getUrlParam(name));
	var codeval = "";
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
	
	$(".sub-btn").click(function(){
		var openId = $("#openId").val();
		var userName = $("#userName").val();
		var userPhone = $("#userPhone").val();
		var userPwd = $("#userPwd").val();
		var id = $("#id").val();
		var code = $("#code").val();
		if(userName == "" || userName == null){
			$("#msgcontain").show();
			$("#msg").html("会员姓名不能为空");
			return;
		}else if(userPhone == "" || userPhone == null){
			$("#msgcontain").show();
			$("#msg").html("手机号码不能为空");
			return;
		}else if(code == "" || code == null){
			$("#msgcontain").show();
			$("#msg").html("验证码不能为空");
			return;
		}else if(userPwd == "" || userPwd == null){
			$("#msgcontain").show();
			$("#msg").html("支付密码不能为空");
			return;
		}else if(codeval != code){
			$("#msgcontain").show();
			$("#msg").html("验证码错误，请核查");
			return;
		}
		$.ajax({
	        url: '/business/leaguer/LeaguerCreate.java',
	        type: 'POST',
	        data: "openId="+openId+"&userName="+userName+"&userPhone="+userPhone+"&userPwd="+userPwd+"&id="+id,
	        dataType: "json",
	        success : function(data) {
	        	if(data == "SUCCESS"){
	        		window.location="leaguer-success.html";
	        	}else{
	        		$("#msgcontain").show();
	    			$("#msg").html("数据异常");
	        	}
	        }
		});
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
