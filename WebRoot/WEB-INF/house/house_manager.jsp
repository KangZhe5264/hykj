<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>订房管理系统</title>
		<link charset="UTF-8" rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/css/comm.css" />
	</head>
	<body class="house_manager">
		<header>惠业科技提供技术支持</header>
		<section>
			<c:forEach items="${house }" var="h">
				<div>
					<label>${h.type }</label>
					<input type="number" value="${h.price }" disabled="disabled"/>
					<label>元/每天</label>
					<button data="${h.id }">修改</button>
					<c:if test="${h.state == true }">
						<button data="${h.id }">客满</button>
					</c:if>
					<c:if test="${h.state == false }">
						<button data="${h.id }">接待</button>
					</c:if>
				</div>
			</c:forEach>
			<div>
				<a>增加新的房间类型</a>
			</div>
		</section>
		<section class="float-right">
			<div>
				<div class="current">待审核</div>
				<div>已审核</div>
			</div>
			<ul>
				<%--
				<li data="152">
					<label>张先生预定标准间2间,预计在2017年12月下午到达,预定时长为3天。联系电话为13653522945</label>
					<br />
					<button>审核</button>
					<button>驳回</button>
				</li>
				<li data="154">
					<label>张先生预定标准间2间,预计在2017年12月下午到达,预定时长为3天。联系电话为13653522945</label>
					<br />
					<button>审核</button>
					<button>驳回</button>
				</li>
				--%>
			</ul>
			<ul class="none">
				<%--
				<li data="155">
					<label>张先生预定标准间2间,预计在2017年12月下午到达,预定时长为3天。联系电话为13653522945</label>
					<br />
					<button>退单</button>
					<button>逾时订出</button>
				</li>
				<li data="124">
					<label>张先生预定标准间2间,预计在2017年12月下午到达,预定时长为3天。联系电话为13653522945</label>
					<br />
					<button>退单</button>
					<button>逾时订出</button>
				</li>
				--%>
			</ul>
		</section>
		<footer>copy</footer>
		<script type="text/javascript" language="JavaScript" src="${pageContext.request.contextPath }/style/js/comm.js"></script>
		<script type="text/javascript">
			window.onload = function(){init_house_manager();}
		</script>
	</body>
</html>
