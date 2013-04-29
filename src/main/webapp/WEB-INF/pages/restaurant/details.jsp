<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"			prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" 		prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 	prefix="form"%>
<!doctype html>
<html lang="en">
<head>
<title>Restaurant</title>

</head>
<body>
	<div id="main">
		<h3>Detalhes</h3>
		<div id="map-canvas"></div>
		<div id="place">
			<div class="resultLeft">
				<p><em>${restaurant.name}</em> <spring:message code="${restaurant.type}"/></p>
				<p>${restaurant.street} ${restaurant.number} - ${restaurant.postalCode}, ${restaurant.city}, <spring:message code="${restaurant.country.name}"/></p>
				
				<p>${restaurant.description}</p>
				<c:if test="${!empty r.phone}"><p><span class="phone">${restaurant.phone}</span></p></c:if>
				<c:if test="${!empty r.website}"><p><a href="${restaurant.website}" target="_blank" class="websiteLink"><spring:message code="website"/></a></p></c:if>
			</div>
			<div class="resultRight">
			</div>
			
			<ul id="listResult">
				<c:forEach items="${restaurant.reviews}" var="r" varStatus="i">
					<li>
						<div class="resultLeft">
							<p>${r.title}</p>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>

<script type="text/javascript" src="/js/maps.js"></script>  
<script type="text/javascript">
$(window).load(function () {
	<c:if test="${!empty restaurant}">
		setOrigin('${restaurant.latitude}', '${restaurant.longitude}');
	</c:if>
});
</script>	
</body>
</html>