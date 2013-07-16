<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"			prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"			prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" 		prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 	prefix="form"%>
<!doctype html>
<html lang="en">
<head>
<title><spring:message code="restaurant.search"/></title>
<meta name="description" content="<spring:message code="meta.description"/>, <spring:message code="restaurant.search"/>">
</head>
<body>
		<h2><spring:message code="restaurant.search"/></h2>
		<form onsubmit="search(); return false;">
			<div id="search-btn" class="light-green">
				<input id="autocomplete" name="autocomplete" type="text"/>
				&nbsp;<a href="javascript:search(); return false;"><spring:message code="search"/></a></div>
		</form>
		<div id="map-canvas"></div>
		
		<c:choose>
			<c:when test="${!empty restaurants}">
				<section id="comments">
					<c:forEach items="${restaurants}" var="r" varStatus="i">
						<article>
							<div class="resultLeftSearch">
								<p>
									<em>
										<a href="/restaurant/details/${r.id}" title="<spring:message code="details"/>">${r.name}</a>
									</em> 
									<spring:message code="${r.type}"/>
									<span class="ratingDiv rating " id="rating${i.index}"></span>
								</p>
								
								<p>${r.description}</p>
								<p class="address">${r.street} ${r.number} - ${r.postalCode}, ${r.city}, <spring:message code="${r.country.name}"/></p>
								<c:if test="${!empty r.phone}"><p class="phone">${r.phone}</p></c:if>
								<c:if test="${!empty r.website}"><p class="websiteLink"><a href="${r.website}" target="_blank"><spring:message code="website"/></a></p></c:if>
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
						</article>
					</c:forEach>
				</section>
			</c:when>
			<c:otherwise>
				<section>
					<article>
					<c:if test="${!empty origin}">
						<div class="infoMsg">
							<spring:message code="noresults"/>
						</div>
					</c:if>
					</article>
				</section>
			</c:otherwise>
		</c:choose>
		
		
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
