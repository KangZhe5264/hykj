/**
 * 
 */
$(function() {
	
	$(".button_add").attr("disabled", false); 
	$(".button_submit").attr("disabled", true); 
	$(".button_delete").attr("disabled", true);
	
	$.ajax({
        url: '/business/vip/VipManage.java',
        type: 'POST',
        dataType: "json",
        success : function(data) {
        	$("tbody").html("");
       	 	$.each(data, function(i, item) {
	       		$("tbody").append(
	           		 "<tr>" +
	           		 	"<td>" + i + "</td>" +
	           		    "<td>" + item.id + "</td>" +
	           		 	"<td>" + item.levalName + "</td>" +
	           		 	"<td>" + item.landmark + "</td>" +
	           		 	"<td>" + item.role + "</td>" +
	           		 "</tr>"
	             );
                 $("tbody>tr").addClass("data");
                 
                 $("tr[class='data']").click(function(){
             		$(this).siblings().css("background-color","");
             		$(this).css("background-color","orange");
             		var id = $(this).find("td")[1].innerHTML;
             		var levelName = $(this).find("td")[2].innerHTML;
             		var landmark = $(this).find("td")[3].innerHTML;
             		var role = $(this).find("td")[4].innerHTML;
             		$("input[name='id']").val(id);
             		$("input[name='levalName']").val(levelName);
             		$("input[name='landmark']").val(landmark);
             		$("input[name='role']").val(role);
             		$(".button_add").attr("disabled", false); 
             		$(".button_submit").attr("disabled", true); 
             		$(".button_delete").attr("disabled", false);
             	})
	        });
        }  
    });
	
	$(".button").click(function(){
		$.ajax({
	        url: '/business/vip/VipCondition.java',
	        type: 'POST', 	
	        data: $('#form-search').serialize(),
	        dataType: "json",
	        success : function(data) {
	        	 $("tbody").html("");
	        	 $.each(data, function(i, item) {
	        		 $("tbody").append(
        				 "<tr>" +
	 	           		 	"<td>" + i + "</td>" +
	 	           		    "<td>" + item.id + "</td>" +
	 	           		 	"<td>" + item.levalName + "</td>" +
	 	           		 	"<td>" + item.landmark + "</td>" +
	 	           		 	"<td>" + item.role + "</td>" +
	 	           		 "</tr>"
	                  );
	                 $("tbody>tr").addClass("data");
	                 
	                 $("tr[class='data']").click(function(){
	             		$(this).siblings().css("background-color","");
	             		$(this).css("background-color","orange");
	             		var id = $(this).find("td")[1].innerHTML;
	             		var levelName = $(this).find("td")[2].innerHTML;
	             		var landmark = $(this).find("td")[3].innerHTML;
	             		var role = $(this).find("td")[4].innerHTML;
	             		$("input[name='id']").val(id);
	             		$("input[name='levalName']").val(levelName);
	             		$("input[name='landmark']").val(landmark);
	             		$("input[name='role']").val(role);
	             		$(".button_add").attr("disabled", false); 
	             		$(".button_submit").attr("disabled", true); 
	             		$(".button_delete").attr("disabled", false);
	             	})
	             });
            }  
	    });
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
	        data: $('#form-detail').serialize(),
	        dataType: "json",
	        success : function(data) {
	        	$("tbody").html("");
	        	 $.each(data, function(i, item) {
	        		 $("tbody").append(
        				 "<tr>" +
	 	           		 	"<td>" + i + "</td>" +
	 	           		    "<td>" + item.id + "</td>" +
	 	           		 	"<td>" + item.levalName + "</td>" +
	 	           		 	"<td>" + item.landmark + "</td>" +
	 	           		 	"<td>" + item.role + "</td>" +
	 	           		 "</tr>"
	                  );
	                 $("tbody>tr").addClass("data");
	                 
	                 $("tr[class='data']").click(function(){
	             		$(this).siblings().css("background-color","");
	             		$(this).css("background-color","orange");
	             		var id = $(this).find("td")[1].innerHTML;
	             		var levelName = $(this).find("td")[2].innerHTML;
	             		var landmark = $(this).find("td")[3].innerHTML;
	             		var role = $(this).find("td")[4].innerHTML;
	             		$("input[name='id']").val(id);
	             		$("input[name='levalName']").val(levelName);
	             		$("input[name='landmark']").val(landmark);
	             		$("input[name='role']").val(role);
	             		$(".button_add").attr("disabled", false); 
	             		$(".button_submit").attr("disabled", true); 
	             		$(".button_delete").attr("disabled", false);
	             	})
	             });
            }  
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
	        data: $('#form-detail').serialize(),
	        dataType: "json",
	        success : function(data) {
	        	 $("tbody").html("");
	        	 $.each(data, function(i, item) {
	                 $("tbody").append(
                		 "<tr>" +
	 	           		 	"<td>" + i + "</td>" +
	 	           		    "<td>" + item.id + "</td>" +
	 	           		 	"<td>" + item.levalName + "</td>" +
	 	           		 	"<td>" + item.landmark + "</td>" +
	 	           		 	"<td>" + item.role + "</td>" +
	 	           		 "</tr>"
	                  );
	                 $("tbody>tr").addClass("data");
	                 $("tr[class='data']").click(function(){
	             		$(this).siblings().css("background-color","");
	             		$(this).css("background-color","orange");
	             		var id = $(this).find("td")[1].innerHTML;
	             		var levelName = $(this).find("td")[2].innerHTML;
	             		var landmark = $(this).find("td")[3].innerHTML;
	             		var role = $(this).find("td")[4].innerHTML;
	             		$("input[name='id']").val(id);
	             		$("input[name='levalName']").val(levelName);
	             		$("input[name='landmark']").val(landmark);
	             		$("input[name='role']").val(role);
	             		$(".button_add").attr("disabled", false); 
	             		$(".button_submit").attr("disabled", true); 
	             		$(".button_delete").attr("disabled", false);
	             	})
	             });
            }  
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