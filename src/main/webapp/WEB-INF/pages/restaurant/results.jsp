<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 			prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" 		prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 	prefix="form"%>
<!doctype html>
<html lang="en">
<head>
<title>Restaurant</title>

</head>
<body>
<script type="text/javascript">
function getDistance(latOrigin, lngOrigin, latDestine, lngDestine) {
	var latLngA = new google.maps.LatLng(latOrigin, lngOrigin);
    var latLngB = new google.maps.LatLng(latDestine, lngDestine);
    var result = google.maps.geometry.spherical.computeDistanceBetween (latLngA, latLngB);
    return result / 1000;
}
</script>
	<div id="main">
		<div id="place">
		<h3>Dados do local</h3>
			<ul>
				<c:forEach items="${restaurants}" var="r">
					<li>${r.name}</li>
					<script type="text/javascript">
						document.write(getDistance('${origin.latitude}', '${origin.longitude}', '${r.latitude}' , '${r.longitude}'));
					</script>
				</c:forEach>
			</ul>
		</div>
	
	</div>
	
</body>
</html>