<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"		prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" 	prefix="spring"%>
<!doctype html>
<html lang="en">
<head>
	<title><spring:message code="system.msg"/></title>
	<meta name="description" content="<spring:message code="meta.description"/>, <spring:message code="system.msg"/>">
</head>

<body>
	    <h2><spring:message code="system.msg"/></h2>
	    <c:choose>
	    	<c:when test="${!empty warn}">
	    		<p class="warningMsg">
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
			    	<c:if test="${!empty restaurantName}">
			    		<br/>
		    			<a href="/restaurant/${restaurantName}">Visualizar</a>
		    		</c:if>
			    </p>
		    </c:otherwise>
	    </c:choose>
</body>
</html>