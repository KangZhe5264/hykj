/**
 * add by yangwc
 */
$(function() {
	
	$("tr[class='data']").click(function(){
		$(this).siblings().css("background-color","");
		$(this).css("background-color","orange");
	})
	
})