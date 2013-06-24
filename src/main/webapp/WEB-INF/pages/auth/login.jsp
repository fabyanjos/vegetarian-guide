<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"			prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" 		prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 	prefix="form"%>
<!doctype html>
<html lang="en">
<head>
<script type="text/javascript" src="http://connect.facebook.net/en_US/all.js"></script>
</head>

<body>
	<p class="validationMsg">
		<spring:message code="login.request"/>
	</p>
</body>
</html>