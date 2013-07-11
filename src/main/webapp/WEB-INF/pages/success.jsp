<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"		prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" 	prefix="spring"%>
<!doctype html>
<html lang="en">
<head>
	<title><spring:message code="success"/></title>
</head>

<body>
	<div id="main">
		<fieldset id="place">
		    <h3><spring:message code="message"/></h3>
		    <p class="successMsg"><spring:message code="${success}"/></p>
	    </fieldset>
    </div>
</body>
</html>