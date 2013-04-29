<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"			prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"			prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" 		prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 	prefix="form"%>
<!doctype html>
<html lang="en">
<head>
<title>Restaurant</title>
</head>
<body>
	<div id="main">
		<form onsubmit="codeAddress(search); return false;">
			<div class="button black">
				<input id="autocomplete" name="autocomplete" type="text"/>
				&nbsp;<a href="javascript:codeAddress(search); return false;"><spring:message code="search"/></a></div>
		</form>
		<c:choose>
		<c:when test="${!empty restaurants}">
		<div id="map-canvas"></div>
		<div id="place">
			<br/>
			<ul id="listResult">
				<c:forEach items="${restaurants}" var="r" varStatus="i">
					<li>
						<div class="resultLeft">
							<p><em><a href="/restaurant/details/${r.id}" title="details">${r.name}</a></em> <spring:message code="${r.type}"/></p>
							<p>${r.street} ${r.number} - ${r.postalCode}, ${r.city}, <spring:message code="${r.country.name}"/></p>
							
							<p>${r.description}</p>
							<c:if test="${!empty r.phone}"><p><span class="phone">${r.phone}</span></p></c:if>
							<c:if test="${!empty r.website}"><p><a href="${r.website}" target="_blank" class="websiteLink"><spring:message code="website"/></a></p></c:if>
						</div>
						<div class="resultRight">
							<p>
								<a href="https://maps.google.com/?saddr=${origin.latitude},${origin.longitude}&daddr=${r.latitude},${r.longitude}" target="_blank">
									<img src="/images/compass.png" alt="<spring:message code="directions"/>" title="<spring:message code="directions"/>"/>
								</a>
								<br/>${r.distanceString}
							</p>
							<p></p>
						</div>
						<div id="infoWindow${i.index+1}" style="display: none;">
							<span class="infoWindowTitle">${r.name}</span>
							<p>${r.street}, ${r.number} ${r.postalCode}, ${r.city}, <spring:message code="${r.country.name}"/></p>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
		</c:when>
		<c:otherwise>
			<div>
				Nenhum resultado
			</div>
		</c:otherwise>
		</c:choose>
		<form:form method="post" action="/restaurant/results" modelAttribute="restaurant" id="search">
			<ul style="display: none;">
				<li><label><spring:message code="address"/>: </label><input type="text" id="street" name="street"/></li>
				<li><label><spring:message code="street_number"/>: </label><input type="text" id="number" name="number"/></li>
				<li><label><spring:message code="postal_code"/>: </label><input type="text" id="postalCode" name="postalCode"/></li>
				<li><label><spring:message code="city"/>: </label><input type="text" id="city" name="city"/></li>
				<li><label><spring:message code="state"/>: </label><input type="text" id="state" name="state"/></li>
				<li>
					<label><spring:message code="country"/>: </label>
					<input type="text" id="country.name" name="country.name" style="display: none;"/> 
					<input type="text" id="country_long" name="country_long"/>
				</li>
				<li style="display: ;"><label><spring:message code="lat"/>: </label><input type="text" id="latitude" name="latitude"/></li>
				<li style="display: ;"><label><spring:message code="lng"/>: </label><input type="text" id="longitude" name="longitude"/></li>
				<li><input type="submit" value="<spring:message code="save"/>"/></li>
			</ul>
		</form:form>
	
	</div>
<script type="text/javascript" src="/js/maps.js"></script>  
<script type="text/javascript">
$(window).load(function () {
	navigator.geolocation.getCurrentPosition(showPosition);
	function showPosition(position) {
	   /*  alert(position.coords);
	    alert(position.coords.longitude);     */
	}

	<c:if test="${!empty origin}">
	setOrigin('${origin.latitude}', '${origin.longitude}');
	</c:if>
	<c:forEach items="${restaurants}" var="r" varStatus="i">
		createMark('${i.index+1}', '${r.latitude}', '${r.longitude}', '${r.name}');
	</c:forEach>
});
</script>	
</body>
</html>
