/**
 * add by yangwc
 * leaguer-info.html的js
 */

$(function() {
	
	var openId = getUrlParam("openId");
	
	$.ajax({
        url: '/business/leaguerLog/selectMine.java',
        type: 'POST',
        data: "openId="+openId,
        dataType: "json",
        success : function(data) {
        	$.each(data, function(i, item) {
        		$(".ps-lt").append(
        			"<div class='lt-dsb'>"+
	        			 "<p>"+ item.info + "</p>"+
	        			 "<li>"+item.worths +"元</li>"+
	        		"</div>"
   	            );
        	})	
        	$("li").addClass("arr-right");
        	$(".lt-dsb").trigger("create");
        	$(".lt-dsb p").trigger("create");
        	$(".arr-right").trigger("create");
        }
	});
	
	function getUrlParam(name){
		var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
		var r = window.location.search.substr(1).match(reg);  //匹配目标参数
		if (r!=null) return unescape(r[2]); return null; //返回参数值
	} 
	
})
