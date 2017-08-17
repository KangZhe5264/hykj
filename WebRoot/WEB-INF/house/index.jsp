<%@page language="java" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>房间信息</title>
		<link charset="UTF-8" rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/css/comm.css"/>
	</head>
	<body>
		<header></header>
		<section >
			<header>惠业提供技术支持</header>
			<C:forEach items="${house }" var="h">
				<div class="item yes" data="${h.id }">${h.type }-可以预定-${h.price }元每天</div>
			</C:forEach>
			
			<%-- <div class="item no" data="2">帝王间-不可以预定-20元每天</div> --%>
		</section>
		<section class="none">
			<header>请确认您的订单信息</header>
			<section>
				<div>
					<label for="contact_phone">我们应该怎么联系您</label>
					<input type="tel" name="contact_phone" id="contact_phone" value="13653522945" />
				</div>
				<div>
					<label for="quantity">您将预定的是<a>标准间</a></label>
					<br />
					<input type="number" name="quantity" id="quantity" value="1" />间
				</div>
				<div>
					<label for="arrive_time">您将于</label>
					<input type="text" name="arrive_time" id="arrive_time" value="2017年12月12日" />到达
				</div>
				<div>
					<label for="active_time">届时,您将停留</label>
					<input type="text" name="active_time" id="active_time" value="2天" />
				</div>
			</section>
			<footer>
				<label>因此,您应支付</label>
				<input disabled="disabled" type="number" name="amount" id="amount" value="3000"/>元
				<!--<br />
				<input type="radio" name="pay_way" value="1" checked="checked"/><label>默认支付</label>
				<br />
				<input type="radio" name="pay_way" value="2"/><label>微信支付</label>-->
				<button>确认支付</button>
			</footer>
		</section>
		<footer>
			copy
		</footer>
		<script type="text/javascript" language="JavaScript" src="${pageContext.request.contextPath }/style/js/comm.js"></script>
		<script type="text/javascript">
			window.onload = function(){init_house_index();}
		</script>
	</body>
</html>
