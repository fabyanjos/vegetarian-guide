<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"			prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" 		prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 	prefix="form"%>
<!doctype html>
<html lang="en">
<head>
	<title><spring:message code="image"/></title>	
	<meta name="description" content="<spring:message code="meta.description"/>, <spring:message code="image"/>">
</head>
<body>
	<form:form method="post" action="/restaurant/image/save/${restaurantId}" modelAttribute="image" enctype="multipart/form-data">
		<h2><spring:message code="image"/></h2>
		<c:if test="${!empty error}">
			<p class="validationMsg"><spring:message code="${error}"/></p>
		</c:if>
		<p>
			<label><spring:message code="title"/>: <span class="mandatory">*</span> </label>
			<form:input path="name" cssErrorClass="inputError"/>
			<form:errors cssClass="error" path="name"/>
		</p>
		<p>
			<label><spring:message code="description"/>: </label>
			<form:textarea path="description" cssErrorClass="inputError"/>
			<form:errors cssClass="error" path="description"/>
		</p>
		<p>
			<label><spring:message code="image"/>: <span class="mandatory">*</span> </label>
			<input type="file" name="file" id="file" accept="image/png, image/gif, image/jpeg"></input>
			<form:errors cssClass="error" path="file"/>
		</p>				
		<p><input type="submit" value="<spring:message code="save"/>" class="button"/></p>
	</form:form>
</body>
</html>