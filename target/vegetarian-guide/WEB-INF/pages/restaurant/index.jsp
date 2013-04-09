<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>
<html lang="en">
<head>
<title>Welcome To Spring MVC Internationalization !!!</title>

</head>
<body>
	<p>
		Choose: <a href="<c:url value='?lang=en'/>">English</a> | <a
			href="<c:url value='?lang=pt'/>">Portuguese</a> | <a
			href="<c:url value='?lang=de'/>">German</a>
	</p>

	<c:forEach items="${countries}" var="c">
		<p>
			<spring:message code="${c.name}" />
		</p>
	</c:forEach>

	<p>
		Current: <c:out value="${pageContext.response.locale}" />
	</p>
	
	<script type="text/javascript" src="/js/maps.js">
		
	</script>
</body>
</html>