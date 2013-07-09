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
		    <h3><spring:message code="system.msg"/></h3>
		    <c:choose>
		    	<c:when test="${!empty warn}">
		    		<p class="validationMsg">
		    			<spring:message code="${warn}"/>
		    		</p>
		    	</c:when>
		    	<c:otherwise>
				    <p class="errorMsg">
				    	<c:choose>
				    		<c:when test="${!empty error}">
				    			<spring:message code="${error}"/>
				    		</c:when>
				    		<c:otherwise>
				    			<spring:message code="system.error"/>
				    		</c:otherwise>
				    	</c:choose>
				    </p>
			    </c:otherwise>
		    </c:choose>
	    </fieldset>
    </div>
</body>
</html>