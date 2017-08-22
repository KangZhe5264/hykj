/**
 * add by yangwc
 */
$(function() {
	$.ajax({
        url: '/business/leaguerLog/selectAll.java',
        type: 'POST',
        dataType: "json",
        success : function(data) {
        	$("tbody").html("");
        	$.each(data, function(i, item) {
        		$("tbody").append(
   	           		 "<tr>" +
   	           		 	"<td>" + i + "</td>" +
   	           		    "<td>" + item.sequence + "</td>" +
   	           		 	"<td>" + item.type + "</td>" +
   	           		    "<td>" + item.leaguer.userName + "</td>" +
   	           		 	"<td>" + item.worths + "</td>" +
   	           		    "<td>" + item.createTime + "</td>" +
	           		    "<td>" + item.info + "</td>" +
   	           		 "</tr>"
   	             );
                $("tbody>tr").addClass("data");
                $("tr[class='data']").click(function(){
            		$(this).siblings().css("background-color","");
            		$(this).css("background-color","orange");
            	})
        	});
        }
    });
	
	$(".button").click(function(){
		$.ajax({
	        url: '/business/leaguerLog/selectByCondition.java',
	        type: 'POST',
	        dataType: "json",
	        data: $('#form-search').serialize(),
	        success : function(data) {
	        	$("tbody").html("");
	        	$.each(data, function(i, item) {
	        		$("tbody").append(
	   	           		 "<tr>" +
	   	           		 	"<td>" + i + "</td>" +
	   	           		    "<td>" + item.sequence + "</td>" +
	   	           		 	"<td>" + item.type + "</td>" +
	   	           		    "<td>" + item.leaguer.userName + "</td>" +
	   	           		 	"<td>" + item.worths + "</td>" +
	   	           		    "<td>" + item.createTime + "</td>" +
		           		    "<td>" + item.info + "</td>" +
	   	           		 "</tr>"
	   	             );
	                $("tbody>tr").addClass("data");
	                $("tr[class='data']").click(function(){
	            		$(this).siblings().css("background-color","");
	            		$(this).css("background-color","orange");
	            	})
	        	});
	        }
	    });
	});
})