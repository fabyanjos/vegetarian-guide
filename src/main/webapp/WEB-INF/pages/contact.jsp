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
	<form:form method="post" action="/contact/send" modelAttribute="message">
		<h3><spring:message code="contact"/></h3>
		<c:if test="${!empty error}">
			<p class="validationMsg"><spring:message code="${error}"/></p>
		</c:if>
		<c:if test="${!empty success}">
			<p class="successMsg"><spring:message code="${success}"/></p>
		</c:if>
		<fieldset id="place">
			<ul>
				<li>
					<label><spring:message code="name"/>: </label>
					<c:choose>
					<c:when test="${!empty SPRING_SECURITY_CONTEXT.authentication.principal}">
						<form:input path="name" value="${SPRING_SECURITY_CONTEXT.authentication.principal.name}"/>
					</c:when>
					<c:otherwise>
						<form:input path="name" />
					</c:otherwise>
					</c:choose>
					<form:errors cssClass="error" path="name"/>
				</li>
				<li>
					<label><spring:message code="email"/>: <span class="mandatory">*</span> </label>
					<c:choose>
					<c:when test="${!empty SPRING_SECURITY_CONTEXT.authentication.principal}">
						<form:input path="email" value="${SPRING_SECURITY_CONTEXT.authentication.principal.email}"/>
					</c:when>
					<c:otherwise>
						<form:input path="email" />
					</c:otherwise>
					</c:choose>
					<form:errors cssClass="error" path="email"/>
				</li>
				<li>
					<label><spring:message code="subject"/>: <span class="mandatory">*</span> </label>
					<form:input path="subject" />
					<form:errors cssClass="error" path="subject"/>
				</li>
				<li>
					<label><spring:message code="message"/>: <span class="mandatory">*</span> </label>
					<form:textarea path="description" />
					<form:errors cssClass="error" path="description"/>
				</li>				
				<li><input type="submit" value="<spring:message code="save"/>" class="button"/></li>
			</ul>
		</fieldset>
	</form:form>
	</div>
</body>
</html>