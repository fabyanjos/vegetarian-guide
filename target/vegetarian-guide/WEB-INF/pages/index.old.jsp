<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!doctype html>
<html lang="en">
<head>
  <title>Welcome To Spring MVC Internationalization !!!</title>
  
  <script type="text/javascript">
	  function initialize() {
		  var mapOptions = {
		    zoom: 8,
		    center: new google.maps.LatLng(-34.397, 150.644),
		    mapTypeId: google.maps.MapTypeId.ROADMAP
		  }
		  var map = new google.maps.Map(document.getElementById("map-canvas"), mapOptions);
		}
	
		function loadScript() {
		  var script = document.createElement("script");
		  script.type = "text/javascript";
		  script.src = "https://maps.google.com/maps?file=api&v=2&sensor=false&key=QjKoZFeHsGAZcaIpKFtuQBWF&callback=initialize";
		  document.body.appendChild(script);
		}
	
		window.onload = loadScript;
  </script>
</head>
<body>
  <h1>Spring MVC Internationalization !!!</h1>
  
  <p>Choose:
      <a href="<c:url value='?lang=en'/>">English</a>
      | <a href="<c:url value='?lang=pt'/>">Portuguese</a>
	  | <a href="<c:url value='?lang=de'/>">German</a>
  </p>
  
  <c:forEach items="${countries}" var="c">
  	<p><spring:message code="${c.name}"/></p>
  </c:forEach>
  
  <p>Current: <c:out value="${pageContext.response.locale}" /></p>
  
  <div id="map-canvas" style="width: 90%; height: 90%"></div>
</body>
</html>