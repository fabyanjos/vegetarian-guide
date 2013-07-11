<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"			prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" 		prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 	prefix="form"%>
<!doctype html>
<html lang="en">
<head>
	<title><spring:message code="image"/></title>	
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
					<label><spring:message code="title"/>: <span class="mandatory">*</span> </label>
					<form:input path="name" />
					<form:errors cssClass="error" path="name"/>
				</li>
				<li>
					<label><spring:message code="description"/>: </label>
					<form:textarea path="description" />
					<form:errors cssClass="error" path="description"/>
				</li>
				<li>
					<label><spring:message code="image"/>: <span class="mandatory">*</span> </label>
					<input type="file" name="file" id="file" accept="image/png, image/gif, image/jpeg"></input>
					<form:errors cssClass="error" path="file"/>
				</li>				
				<li><input type="submit" value="<spring:message code="save"/>" class="button"/></li>
			</ul>
		</fieldset>
	</form:form>
	</div>
</body>
</html>