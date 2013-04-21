<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"				prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" 		prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 	prefix="form"%>
<!doctype html>
<html lang="en">
<head>
<title>Restaurant</title>

</head>
<body>
	<div id="main">
		<div id="place">
		<h3>Dados do local</h3>
			<ul>
				<c:forEach items="${restaurants}" var="r">
					<li><c:out value="${r.name}"/></li>
					<li><c:out value="${r.distance}"/></li>
				</c:forEach>
			</ul>
		</div>
	
	</div>
	
</body>
</html>