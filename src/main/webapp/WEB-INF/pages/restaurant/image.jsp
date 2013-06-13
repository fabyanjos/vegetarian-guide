<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"			prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" 		prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 	prefix="form"%>
<!doctype html>
<html lang="en">
<head>
	
</head>
<body>
	<div id="main">
	<form:form method="post" action="/restaurant/image/save/${restaurantId}" modelAttribute="image" enctype="multipart/form-data">
		<h3><spring:message code="image"/></h3>
		<c:if test="${!empty error}">
			<p class="validationMsg"><spring:message code="${error}"/></p>
		</c:if>
		<fieldset id="place">
			<ul>
				<li>
					<form:label path="name">Name</form:label>
					<form:input path="name" />
				</li>
				<li>
					<form:label path="description">Description</form:label>
					<form:textarea path="description" />
				</li>
				<li>
					<form:label path="filePath">Document</form:label>
					<input type="file" name="file" id="file" accept="image/png, image/gif, image/jpeg"></input>
				</li>				
				<li><input type="submit" value="<spring:message code="save"/>" class="button"/></li>
			</ul>
		</fieldset>
	</form:form>
	</div>
</body>
</html>