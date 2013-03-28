<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>
<html lang="en">
<head>
<title>Welcome To Spring MVC Internationalization !!!</title>

<link rel="stylesheet" href="//www.google.com/cse/style/look/default.css" type="text/css" />
    <link href='//fonts.googleapis.com/css?family=Open+Sans:300,400' rel='stylesheet' type='text/css'>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
    <script id="jqueryui" src="//ajax.googleapis.com/ajax/libs/jqueryui/1.8.10/jquery-ui.min.js" defer async></script>
    <script src="//www.google.com/jsapi"></script>
    <script type="text/javascript" src="//maps.googleapis.com/maps/api/js?sensor=false&libraries=places"></script>
    

</head>
<body>
	<p>
		<input id="autocomplete" type="text" size="100px" onkeydown="searchPlaces();">
	</p>
	<div id="map-canvas" style="width: 650px; height: 300px;"></div>

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