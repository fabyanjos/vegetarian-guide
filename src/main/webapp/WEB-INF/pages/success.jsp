<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"		prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" 	prefix="spring"%>
<!doctype html>
<html lang="en">
<head>
	<title><spring:message code="success"/></title>
	<meta name="description" content="<spring:message code="meta.description"/>, <spring:message code="success"/>">
</head>

<body>
    <h2><spring:message code="message"/></h2>
    <p class="successMsg"><spring:message code="${success}"/></p>
</body>
</html>