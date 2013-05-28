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
		<form onsubmit="search(); return false;">
			<div class="button black" style="width:580px;">
				<input id="autocomplete" name="autocomplete" type="text"/>
				&nbsp;<a href="javascript:codeAddress(search); return false;"><spring:message code="search"/></a></div>
		</form>
		<div id="map-canvas"></div>
		
		<div id="place">
		<c:choose>
		<c:when test="${!empty restaurants}">
			<ul id="listResult">
				<c:forEach items="${restaurants}" var="r" varStatus="i">
					<li>
						<div class="resultLeftSearch">
							<p>
								<em>
									<a href="/restaurant/details/${r.id}" title="<spring:message code="details"/>">${r.name}</a>
								</em> 
								<spring:message code="${r.type}"/>
								<span class="ratingDiv rating " id="rating${i.index}"></span>
							</p>
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
		</c:when>
		<c:otherwise>
			<c:if test="${!empty origin}">
				<div class="infoMsg">
					<spring:message code="noresults"/>
				</div>
			</c:if>
		</c:otherwise>
		</c:choose>
		</div>
		<div id="infoWindowYour" style="display: none;">
			<span class="infoWindowTitle"><spring:message code="your.location"/></span>
			<p>${origin.street}, ${origin.number} ${origin.postalCode}, ${origin.city}, <spring:message code="${origin.country.name}"/></p>
		</div>

		<form:form method="post" action="/restaurant/results" modelAttribute="restaurant" id="search">
			<ul style="display: none;">
				<li><label><spring:message code="address"/>: </label><input type="text" id="street" name="street"/></li>
				<li><input type="submit" value="<spring:message code="save"/>"/></li>
			</ul>
		</form:form>
	
	</div>
<script type="text/javascript" src="/js/maps.js"></script>  
<script type="text/javascript">
google.maps.event.addDomListener(window, 'load', initialize);
$(window).load(function () {
	//navigator.geolocation.getCurrentPosition(showPosition);
	function showPosition(position) {
	   /*  alert(position.coords);
	    alert(position.coords.longitude);     */
	}

	<c:if test="${!empty origin}">
		setOrigin('${origin.latitude}', '${origin.longitude}', 'infoWindowYour');
	</c:if>
	<c:forEach items="${restaurants}" var="r" varStatus="i">
		createMark('${i.index+1}', '${r.latitude}', '${r.longitude}', '${r.name}');
		
		var style = $('#rating${i.index}').attr("class");
		style += numberText(${r.rating});
		style += "star";
		$('#rating${i.index}').attr("class", style); 
	</c:forEach>
});
</script>	
</body>
</html>
