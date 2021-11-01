
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<!-- Website template by freewebsitetemplates.com -->
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="user-scalable=0, width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<title>${projectTitle}</title>
	
	<jsp:include page="/WEB-INF/views/common/variable.jsp"></jsp:include>
	
	<jsp:include page="/WEB-INF/views/user/layout/css.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/user/layout/js.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/WEB-INF/views/user/layout/header.jsp"></jsp:include>
	<div id="body">
		<div id="tagline">
			<h1>Yoga</h1>
			<p>
				For Better Health &amp; Flexibility
			</p>
		</div>
		<img src="${base}/user/images/lady-in-yoga.jpg" alt="lady doing yoga" class="figure">
	</div>
	<jsp:include page="/WEB-INF/views/user/layout/footer.jsp"></jsp:include>
</body>
</html>