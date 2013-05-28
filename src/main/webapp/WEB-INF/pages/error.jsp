<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"		prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" 	prefix="spring"%>
<!doctype html>
<html lang="en">
<head>
</head>

<body>
	<div id="main">
		<fieldset id="place">
		    <h3><spring:message code="error"/></h3>
		    <p class="errorMsg"><spring:message code="${msg}"/></p>
	    </fieldset>
    </div>
</body>
</html>