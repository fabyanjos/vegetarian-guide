<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"			prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" 		prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 	prefix="form"%>
<!doctype html>
<html lang="en">
<head>
	<title><spring:message code="contact"/></title>
	<meta name="description" content="<spring:message code="meta.description"/>, <spring:message code="contact"/>">
</head>
<body>
	<form:form method="post" action="/contact/send" modelAttribute="message">
		<h2><spring:message code="contact"/></h2>
		<c:if test="${!empty error}">
			<p class="validationMsg"><spring:message code="${error}"/></p>
		</c:if>
		<c:if test="${!empty success}">
			<p class="successMsg"><spring:message code="${success}"/></p>
		</c:if>
			<p>
				<label><spring:message code="name"/>: </label>
				<c:choose>
				<c:when test="${!empty SPRING_SECURITY_CONTEXT.authentication.principal}">
					<form:input path="name" value="${SPRING_SECURITY_CONTEXT.authentication.principal.name}" cssErrorClass="inputError"/>
				</c:when>
				<c:otherwise>
					<form:input path="name" cssErrorClass="inputError"/>
				</c:otherwise>
				</c:choose>
				<form:errors cssClass="error" path="name"/>
			</p>
			<p>
				<label><spring:message code="email"/>: <span class="mandatory">*</span> </label>
				<c:choose>
				<c:when test="${!empty SPRING_SECURITY_CONTEXT.authentication.principal}">
					<form:input path="email" value="${SPRING_SECURITY_CONTEXT.authentication.principal.email}" cssErrorClass="inputError"/>
				</c:when>
				<c:otherwise>
					<form:input path="email" cssErrorClass="inputError"/>
				</c:otherwise>
				</c:choose>
				<form:errors cssClass="error" path="email"/>
			</p>
			<p>
				<label><spring:message code="subject"/>: <span class="mandatory">*</span> </label>
				<form:input path="subject" cssErrorClass="inputError"/>
				<form:errors cssClass="error" path="subject"/>
			</p>
			<p>
				<label><spring:message code="message"/>: <span class="mandatory">*</span> </label>
				<form:textarea path="description" cssErrorClass="inputError"/>
				<form:errors cssClass="error" path="description"/>
			</p>				
			<p><input type="submit" value="<spring:message code="send"/>" class="button"/></p>
	</form:form>
</body>
</html>