/**
 * add by yangwc
 */
$(function() {
	
	$.ajax({
        url: '/business/leaguer/LeaguerManage.java',
        type: 'POST'
    });
	
	$(".button_add").attr("disabled", false); 
	$(".button_submit").attr("disabled", true); 
	$(".button_delete").attr("disabled", true);
	
	$("tr[class='data']").click(function(){
		$(this).siblings().css("background-color","");
		$(this).css("background-color","orange");
		$("input[name='leaguer.userName']").val($(this).find("td")[1].innerHTML);
		$("input[name='leaguer.vip.levalName']").val($(this).find("td")[2].innerHTML);
		$("input[name='leaguer.userPhone']").val($(this).find("td")[3].innerHTML);
		$("input[name='leaguer.balance']").val($(this).find("td")[4].innerHTML);
		$("input[name='leaguer.history']").val($(this).find("td")[5].innerHTML);
	})
	
	$(".button_add").click(function(){
		$(".manager-pro").find("input").val("");
		$(".button_add").attr("disabled", true); 
		$(".button_submit").attr("disabled", false);
		$(".button_delete").attr("disabled", true);
	})
	
	$(".button_submit").click(function(){
		$.ajax({
	        url: '/business/leaguer/LeaguerSubmit.java',
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
	        url: '/business/leaguer/LeaguerDelete.java',
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