<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"				prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" 	prefix="spring"%>
<!doctype html>
<html lang="en">
<head>

</head>

<body>
	<form action="<c:url value="/signin/facebook" />" method="POST">
	    <button type="submit">Sign in with Facebook</button>
	</form>
</body>
</html>