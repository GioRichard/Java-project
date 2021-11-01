

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
					<h1 class="mt-4">Product</h1>
					<p>Danh sach san pham</p>
					
					
					<sf:form action="${base}/manager/ad_product" method="post" modelAttribute="product" enctype="multipart/form-data">				
						
						<div class="form-group">
							<label for="category">Category(required)</label>
							<sf:select path="categories.id" class="form-control" id="category">
							<sf:options items="${categories }" itemValue="id" itemLabel="name"/>
							</sf:select>
						</div>
						
						<div class="form-group">
							<label for = "title">Title (required)</label>
							<sf:input path="title" required="required" autocomplete="off" type="text" class="form-control" id="title" placeholder="Title"  ></sf:input>
						</div>
						
						<div class="form-group">
							<label for = "price">Price (required)</label>
							<sf:input path="price" required="required" type="number" autocomplete="off" class="form-control" id="price" placeholder="price"></sf:input>
						</div>
						
						<div class="form-group">
							<label for = "priceSale">Price Sale (required)</label>
							<sf:input path="priceSale" required="required" type="number" autocomplete="off" class="form-control" id="priceSale" placeholder="priceSale"></sf:input>
						</div>
						
						<div class="form-group">
							<label for = "short_description">Description (required)</label>
							<sf:textarea path="shortDes" autocomplete="of" 
							class="form-control" id="shortDes" placeholder="Short Description" required="required" rows="3"></sf:textarea>
						</div>
						
						<div class="form-group">
							<label for = "detail_description">Details (required)</label>
							<sf:textarea path="detail" autocomplete="of" 
							class="form-control summernote" id="detail_description" placeholder=" Description" required="required" rows="3"></sf:textarea>
						</div>
						
						
						<div class="form-group form-check">
							<sf:checkbox path="isHot" class="form-check-input" id="isHot"/>
							<label for = "isHot" class="form-check-label">Is Hot Product?</label>
						</div>
						
						<div class="form-group">
							<label for = "fileProductAvatar">avatar</label>
							<input type="file" class="form-control-file" name="productAvatar" id="fileProductAvatar">
						</div>
						
						<div class="form-group">
							<label for = "fileProductPictures">Pictures</label>
							<input type="file" class="form-control-file" name="productPictures" id="fileProductPictures" multiple="multiple">
						</div>
						
						<a href="/manager/ad_product" class="btn" role="button" aria-pressed="true" >Back to</a>
						<button type="submit" class="btn"> save Product</button>
					</sf:form> 
					
					
					
						
						<%-- <div class="form-group">
							<label for = "title">Title (required)</label>
							<input path="tile" required="required" autocomplete="off" type="text" class="form-control" id="title" placeholder="Title"></input>
						</div>
						
						<div class="form-group">
							<label for = "price">Price (required)</label>
							<input path="price" type="number" autocomplete="off" class="form-control" id="price" placeholder="price"></input>
						</div>
						
						<div class="form-group">
							<label for = "priceSale">Price Sale (required)</label>
							<input path="priceSale" type="number" autocomplete="off" class="form-control" id="priceSale" placeholder="priceSale"></input>
						</div>
						
						<div class="form-group">
							<label for = "short_description">Description (required)</label>
							<textarea path="shortDes" autocomplete="of" 
							class="form-control" id="shortDes" placeholder=" Short Description"cols="10" rows="10"></textarea>
						</div>
						
						<div class="form-group">
							<label for = "details_description">Details (required)</label>
							<textarea path="details" autocomplete="of" 
							class="form-control summernote" id="shortDes" placeholder=" Short Description" cols="10" rows="10"></textarea>
						</div>
						
						
						<div class="form-group form-check">
							<checkbox path="isHot" class="form-check-input" id="isHot"/>
							<label for = "isHot">Is Hot Product?</label>
						</div>
						
						<div class="form-group">
							<label for = "fileProductAvatar">avatar</label>
							<input type="file" class="form-control-file" name="productAvatar" id="fileProductAvatar">
						</div>
						
						<div class="form-group">
							<label for = "fileProductPictures">Pictures</label>
							<input type="file" class="form-control-file" name="productPictures" id="fileProductPictures" multiple="multiple">
						</div>
						
						<a href="/manager/list-product" class="btn" role="button" aria-pressed="true" >Back to</a>
						<button type="submit" class="btn"> save Product</button> --%>
				
					
				</div>
			</main>

			<!-- footer -->
			<jsp:include page="/WEB-INF/views/manager/layout/footer.jsp"></jsp:include>
			<!--End footer -->
		</div>
	</div>
</body>
</html>

