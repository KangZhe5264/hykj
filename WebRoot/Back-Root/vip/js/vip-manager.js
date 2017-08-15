/**
 * 
 */
$(function() {
	
	$(".button_add").attr("disabled", false); 
	$(".button_submit").attr("disabled", true); 
	$(".button_delete").attr("disabled", true);
	
	$(".button").click(function(){
		$.ajax({
	        url: '/business/vip/VipCondition.java',
	        type: 'POST',
	        data: $('#form-detail').serialize()
	    });
	})
	
	$("tr[class='data']").click(function(){
		$(this).siblings().css("background-color","");
		$(this).css("background-color","orange");
		$("input[name='vip.levelName']").val($(this).find("td")[1].innerHTML);
		$("input[name='vip.landmark']").val($(this).find("td")[2].innerHTML);
		$("input[name='vip.role']").val($(this).find("td")[3].innerHTML);
		$(".button_add").attr("disabled", false); 
		$(".button_submit").attr("disabled", true); 
		$(".button_delete").attr("disabled", false);
	})
	
	$(".button_add").click(function(){
		$(".manager-pro").find("input").val("");
		$(".button_add").attr("disabled", true); 
		$(".button_submit").attr("disabled", false);
		$(".button_delete").attr("disabled", true);
	})
	
	$(".button_submit").click(function(){
		$.ajax({
	        url: '/business/vip/VipSubmit.java',
	        type: 'POST',
	        data: $('#form-detail').serialize()
	    });
		$(".manager-pro").find("input").val("");
		$(".button_add").attr("disabled", false); 
		$(".button_submit").attr("disabled", true); 
		$(".button_delete").attr("disabled", true);
	})
	
	$(".button_delete").click(function(){
		$.ajax({
	        url: '/business/vip/VipDelete.java',
	        type: 'POST',
	        data: $('#form-detail').serialize()
	    });
		$(".manager-pro").find("input").val("");
		$(".button_add").attr("disabled", false); 
		$(".button_submit").attr("disabled", true);
		$(".button_delete").attr("disabled", true);
	})
	
	$(".manager-input").bind("input",function(){
		$(".button_submit").attr("disabled", false);
		$(".button_delete").attr("disabled", true);
	})
	
})