

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
	<!-- SPRING FORM -->
	<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
	
	<!--JSTL  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	
	

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/variable.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/manager/layout/css.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/manager/layout/js.jsp"></jsp:include>
</head>
<body class="sb-nav-fixed">
	<!-- nav -->
	<jsp:include page="/WEB-INF/views/manager/layout/nav.jsp"></jsp:include>
	<!-- end nav -->

	<div id="layoutSidenav">
	
	<!-- layoutSidenav -->
	<jsp:include page="/WEB-INF/views/manager/layout/layoutSidenav.jsp"></jsp:include>
	<!-- End layoutSidenav -->
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<h1 class="mt-4">Category</h1>
					<p>Danh sach category</p>
				<p>
					<c:forEach var = "category" items="${categories }">
         				<p>${category.name}</p>
     				 </c:forEach>
				</p>
				</div>
			</main>

			<!-- footer -->
			<jsp:include page="/WEB-INF/views/manager/layout/footer.jsp"></jsp:include>
			<!--End footer -->
		</div>
	</div>
</body>
</html>

