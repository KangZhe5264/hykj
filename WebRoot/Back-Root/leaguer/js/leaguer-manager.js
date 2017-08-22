/**
 * add by yangwc
 */
$(function() {
	
	$.ajax({
        url: '/business/vip/VipManage.java',
        type: 'POST',
        dataType: "json",
        success : function(data) {
        	$("select").html("");
        	$("select").html("<option value = ''></option>");
       	 	$.each(data, function(i, item) {
	       		$("select").append(
	           		 "<option value = '" + item.id + "'>"+ item.levalName +"</option>"
	            );
       	 	})
        }  
    });
	
	$.ajax({
        url: '/business/leaguer/LeaguerManage.java',
        type: 'POST',
        dataType: "json",
        success : function(data) {
        	$("tbody").html("");
        	$.each(data, function(i, item) {
        		$("tbody").append(
   	           		 "<tr>" +
   	           		 	"<td>" + i + "</td>" +
   	           		    "<td>" + item.openId + "</td>" +
   	           		 	"<td>" + item.userName + "</td>" +
   	           		    "<td>" + item.vip.id + "</td>" +
   	           		 	"<td>" + item.vip.levalName + "</td>" +
   	           		 	"<td>" + item.userPhone + "</td>" +
   	           		    "<td>" + item.balance + "</td>" +
   	           		    "<td>" + item.history + "</td>" +
   	           		    "<td>" + item.userPwd + "</td>" +
   	           		 "</tr>"
   	             );
                $("tbody>tr").addClass("data");
                $("tr[class='data']").click(function(){
            		$(this).siblings().css("background-color","");
            		$(this).css("background-color","orange");
            		$("input[name='openId']").val($(this).find("td")[1].innerHTML);
            		$("input[name='userName']").val($(this).find("td")[2].innerHTML);
            		$("select[name='id']").val($(this).find("td")[3].innerHTML);
            		$("input[name='levalName']").val($(this).find("td")[4].innerHTML);
            		$("input[name='userPhone']").val($(this).find("td")[5].innerHTML);
            		$("input[name='balance']").val($(this).find("td")[6].innerHTML);
            		$("input[name='history']").val($(this).find("td")[7].innerHTML);
            		$("input[name='userPwd']").val($(this).find("td")[8].innerHTML);
            	})
        	});
        }
    });
	
	$(".button_submit").attr("disabled", true); 
	$(".button_delete").attr("disabled", true);
	
	$(".button").click(function(){
		$.ajax({
	        url: '/business/leaguer/LeaguerCondition.java',
	        type: 'POST',
	        data: $('#form-search').serialize(),
	        dataType: "json",
	        success : function(data) {
	        	$("tbody").html("");
	        	$.each(data, function(i, item) {
	        		$("tbody").append(
        				"<tr>" +
	   	           		 	"<td>" + i + "</td>" +
	   	           		    "<td>" + item.openId + "</td>" +
	   	           		 	"<td>" + item.userName + "</td>" +
	   	           		    "<td>" + item.vip.id + "</td>" +
	   	           		 	"<td>" + item.vip.levalName + "</td>" +
	   	           		 	"<td>" + item.userPhone + "</td>" +
	   	           		    "<td>" + item.balance + "</td>" +
	   	           		    "<td>" + item.history + "</td>" +
	   	           		    "<td>" + item.userPwd + "</td>" +
	   	           		 "</tr>"
	   	             );
	                $("tbody>tr").addClass("data");
	                $("tr[class='data']").click(function(){
	            		$(this).siblings().css("background-color","");
	            		$(this).css("background-color","orange");
	            		$("input[name='openId']").val($(this).find("td")[1].innerHTML);
	            		$("input[name='userName']").val($(this).find("td")[2].innerHTML);
	            		$("select[name='id']").val($(this).find("td")[3].innerHTML);
	            		$("input[name='levalName']").val($(this).find("td")[4].innerHTML);
	            		$("input[name='userPhone']").val($(this).find("td")[5].innerHTML);
	            		$("input[name='balance']").val($(this).find("td")[6].innerHTML);
	            		$("input[name='history']").val($(this).find("td")[7].innerHTML);
	            		$("input[name='userPwd']").val($(this).find("td")[8].innerHTML);
	            	})
	        	});
	        }
	    });
	})
	
	$(".button_submit").click(function(){
		$.ajax({
	        url: '/business/leaguer/LeaguerSubmit.java',
	        type: 'POST',
	        data: $('#form-detail').serialize(),
	        dataType: "json",
	        success : function(data) {
	        	$("tbody").html("");
	        	$.each(data, function(i, item) {
	        		$("tbody").append(
        				"<tr>" +
	   	           		 	"<td>" + i + "</td>" +
	   	           		    "<td>" + item.openId + "</td>" +
	   	           		 	"<td>" + item.userName + "</td>" +
	   	           		    "<td>" + item.vip.id + "</td>" +
	   	           		 	"<td>" + item.vip.levalName + "</td>" +
	   	           		 	"<td>" + item.userPhone + "</td>" +
	   	           		    "<td>" + item.balance + "</td>" +
	   	           		    "<td>" + item.history + "</td>" +
	   	           		    "<td>" + item.userPwd + "</td>" +
	   	           		"</tr>"
	   	             );
	                $("tbody>tr").addClass("data");
	                $("tr[class='data']").click(function(){
	            		$(this).siblings().css("background-color","");
	            		$(this).css("background-color","orange");
	            		$("input[name='openId']").val($(this).find("td")[1].innerHTML);
	            		$("input[name='userName']").val($(this).find("td")[2].innerHTML);
	            		$("select[name='id']").val($(this).find("td")[3].innerHTML);
	            		$("input[name='levalName']").val($(this).find("td")[4].innerHTML);
	            		$("input[name='userPhone']").val($(this).find("td")[5].innerHTML);
	            		$("input[name='balance']").val($(this).find("td")[6].innerHTML);
	            		$("input[name='history']").val($(this).find("td")[7].innerHTML);
	            		$("input[name='userPwd']").val($(this).find("td")[8].innerHTML);
	            	})
	        	});
	        }
	    });
		$(".manager-pro").find("input").val("");
		$(".manager-pro").find("select").val("");
		$(".button_submit").attr("disabled", true); 
		$(".button_delete").attr("disabled", true);
	})
	
	$(".button_delete").click(function(){
		$.ajax({
	        url: '/business/leaguer/LeaguerDelete.java',
	        type: 'POST',
	        data: $('#form-detail').serialize(),
	        dataType: "json",
	        success : function(data) {
	        	$("tbody").html("");
	        	$.each(data, function(i, item) {
	        		$("tbody").append(
        				"<tr>" +
	   	           		 	"<td>" + i + "</td>" +
	   	           		    "<td>" + item.openId + "</td>" +
	   	           		 	"<td>" + item.userName + "</td>" +
	   	           		    "<td>" + item.vip.id + "</td>" +
	   	           		 	"<td>" + item.vip.levalName + "</td>" +
	   	           		 	"<td>" + item.userPhone + "</td>" +
	   	           		    "<td>" + item.balance + "</td>" +
	   	           		    "<td>" + item.history + "</td>" +
	   	           		    "<td>" + item.userPwd + "</td>" +
	   	           		 "</tr>"
	   	             );
	                $("tbody>tr").addClass("data");
	                $("tr[class='data']").click(function(){
	            		$(this).siblings().css("background-color","");
	            		$(this).css("background-color","orange");
	            		$("input[name='openId']").val($(this).find("td")[1].innerHTML);
	            		$("input[name='userName']").val($(this).find("td")[2].innerHTML);
	            		$("select[name='id']").val($(this).find("td")[3].innerHTML);
	            		$("input[name='levalName']").val($(this).find("td")[4].innerHTML);
	            		$("input[name='userPhone']").val($(this).find("td")[5].innerHTML);
	            		$("input[name='balance']").val($(this).find("td")[6].innerHTML);
	            		$("input[name='history']").val($(this).find("td")[7].innerHTML);
	            		$("input[name='userPwd']").val($(this).find("td")[8].innerHTML);
	            	})
	        	});
	        }
	    });
		$(".manager-pro").find("input").val("");
		$(".manager-pro").find("select").val("");
		$(".button_submit").attr("disabled", true);
		$(".button_delete").attr("disabled", true);
	})
	
	$(".manager-input").bind("input",function(){
		$(".button_submit").attr("disabled", false);
		$(".button_delete").attr("disabled", true);
	})
	
})