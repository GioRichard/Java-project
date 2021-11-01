<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- directive SPRING FORM -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<!-- Website template by freewebsitetemplates.com -->
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="user-scalable=0, width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<title>${projectTitle}</title>

<jsp:include page="/WEB-INF/views/common/variable.jsp"></jsp:include>

<jsp:include page="/WEB-INF/views/user/layout/css.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/user/layout/js.jsp"></jsp:include>

</head>
<body>

	<jsp:include page="/WEB-INF/views/user/layout/header.jsp"></jsp:include>

	<div id="body">
		<h2>Contact</h2>
	
		<c:if test="${not empty thongbao}">
			<div class="alert alert-primary" role="alert">
				${thongbao }
			</div>
		</c:if>
			
			
		<!--normal -->
		<%-- <form action="${base}/contact" method="post">
			<h3>Inquiries</h3>
			<label for="txtname"> <span>Name</span> <input type="text" id="txtname" name="txtname"></label>
			<label for="txtemail"> <span>Email</span> <input type="email" id="txtemail" name="txtemail"></label> 
			<label for="txtsubject"> <span>Subject</span> <input type="text" id="txtsubject" name="txtsubject"></label> 
			<label for="message">
				<span>Message</span>
				<textarea name="txtmessage" id="txtmessage" cols="30" rows="10"></textarea>
			</label>
			<input type="submit" id="send" value="Send">
		</form> --%>
		
		<!-- spring -->
		<sf:form action="${base}/contact" method="post" modelAttribute="contact">
			<h3>Inquiries</h3>
			<label for="txtname"> <span>Name</span> <sf:input path="txtname" type="text" id="txtname" name="txtname"></sf:input></label>
			<label for="txtemail"> <span>Email</span> <sf:input path="txtemail" type="email" id="txtemail" name="txtemail"></sf:input></label> 
			<label for="txtsubject"> <span>Subject</span> <sf:input path="txtsubject" type="text" id="txtsubject" name="txtsubject"></sf:input></label> 
			<label for="message">
				<span>Message</span>
				<sf:textarea path="txtmessage" name="txtmessage" id="txtmessage" cols="30" rows="10"></sf:textarea>
			</label>
			<input type="submit" id="send" value="Send">
			
			<!--khi goi ajax thi kieu ko dc la submit  -->
			<input type="button" onclick="saveContact()"  id="send" value="submit">
		</sf:form>
		
	</div>
	<jsp:include page="/WEB-INF/views/user/layout/footer.jsp"></jsp:include>
	
	
	<!--custom javascrip  -->
	<script type="text/javascript">
		function saveContact() {
			//day la cau truc chung phan ajax 
			//data (simpleContact): la du lieu day len action cua controller
			/* javascrip object */
			let simpleContact = {
					txtname: jQuery("#txtname").val(),  //lay theo id
					txtemail: jQuery("#txtemail").val(),  //lay theo id
					txtsubject: jQuery("#txtsubject").val(),  //lay theo id
					txtmessage: jQuery("#txtmessage").val(), 
			};
			
			
			
			//$ ===jQuery
			jQuery.ajax({
				url : "/contact-ajax",
				type : "post",
				contentType : "application/json",
				data : JSON.stringify(simpleContact),
				
				dataType : "json", //kieu tra ve tu controller la json
				success : function(jsonResult){
					alert(jsonResult.message);
				},
				error : function(jqXhr, textStatus, errorMessage){ //error callback
					
				}
			});
		}
		//Muc dich khi goi ajax la : tranh refect la trang
	
	</script>
</body>
</html>