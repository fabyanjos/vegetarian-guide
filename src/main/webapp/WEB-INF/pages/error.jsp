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
		    <p class="errorMsg">
		    	<c:choose>
		    		<c:when test="${!empty msg}">
		    			<spring:message code="${msg}"/>
		    		</c:when>
		    		<c:otherwise>
		    			<spring:message code="system.error"/>
		    		</c:otherwise>
		    	</c:choose>
		    </p>
	    </fieldset>
    </div>
</body>
</html>