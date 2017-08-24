/**
 * add by yangwc
 * leaguer-info.html的js
 */
$(function() {
	
	$("#openId").val(getUrlParam(name));
	
	var openId = $("#openId").val();
	
	$.ajax({
        url: '/business/leaguer/LeaguerFind.java',
        type: 'POST',
        data: "openId="+openId,
        dataType: "json",
        success : function(data) {
        	$("#userName").html(data.userName);
        	$("#balance").html(data.balance);
        	$("#openId").val(data.openId);
        	$("#levalId").val(data.vip.id);
        }
	});
	
	$("#recharge").click(function(){
		window.location="../Front-Root/leaguer/leaguer-recharge.html?openId="+openId;
	})
	$("#record").click(function(){
		window.location="../Front-Root/leaguer/leaguer-record.html?openId="+openId;
	})
	$("#repwd").click(function(){
		window.location="../Front-Root/leaguer/leaguer-repwd.html?openId="+openId;
	})
	
	$('.check-on').click(function(){
		$(this).toggleClass('check-off');
	})
	
	(function (doc, win) {
	    var docEl = doc.documentElement,
		resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',
		recalc = function () {
		  var clientWidth = docEl.clientWidth;
		  if (!clientWidth) return;
		  docEl.style.fontSize = 100 * (clientWidth / 750) + 'px';
		};

	  if (!doc.addEventListener) return;
	  win.addEventListener(resizeEvt, recalc, false);
	  doc.addEventListener('DOMContentLoaded', recalc, false);
	})(document, window);
	
	function getUrlParam(name){
		var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
		var r = window.location.search.substr(1).match(reg);  //匹配目标参数
		if (r!=null) return unescape(r[2]); return null; //返回参数值
	} 
})