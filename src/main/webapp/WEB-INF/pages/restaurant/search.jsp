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
	<section>
		<h2><spring:message code="restaurant.search"/></h2>
		
		<form:form method="post" action="/restaurant/results" modelAttribute="filter" cssClass="search-box">
			<p>
				<form:input path="address"/>
				<input type="submit" value="<spring:message code="search"/>">
			</p>
			<label><spring:message code="type"/>:</label>
			<p>
				<form:checkbox path="types" value="VEGETARIAN"/><label for="types1"><spring:message code="VEGETARIAN"/></label>
				<form:checkbox path="types" value="VEGAN"/><label for="types2"><spring:message code="VEGAN"/></label>
				<form:checkbox path="types" value="OVO_LACTO"/><label for="types3"><spring:message code="OVO_LACTO"/></label>
				<form:checkbox path="types" value="LACTO"/><label for="types4"><spring:message code="LACTO"/></label>
			</p>
			<p>
				<label for="limit">Número de resultados:</label>
				<form:input path="limit" type="number"/>
			</p>
			<p>
				<label>
				<spring:message code="price"/>
				<a href="#" class="tooltip">
					<img src="/images/help.png" width="14">
					<span>
						<b></b>
						<spring:message code="price.list"/>
					</span>
				</a>
				:
				</label>
				<span class="price">
					<form:radiobutton path="price" value="0"/><span id="hide"></span>
					<form:radiobutton path="price" value="1"/><span></span>
					<form:radiobutton path="price" value="2"/><span></span>
					<form:radiobutton path="price" value="3"/><span></span>
					<form:radiobutton path="price" value="4"/><span></span>
				</span>
				</p>
		</form:form>
		<div id="map-canvas"></div>
	</section>
		<c:choose>
			<c:when test="${!empty restaurants}">
				<section id="comments">
					<c:forEach items="${restaurants}" var="r" varStatus="i">
						<article>
							<div class="resultLeftSearch">
								
								<h5>
									<a href="/restaurant/${r.nameUrl}" title="<spring:message code="details"/>">${r.name}</a>
									<span class="rating">
									    <input type="radio" name="rating-${r.id}" value="0" checked /><span id="hide"></span>
									    <input type="radio" name="rating-${r.id}" value="1" disabled="disabled"/><span></span>
									    <input type="radio" name="rating-${r.id}" value="2" disabled="disabled"/><span></span>
									    <input type="radio" name="rating-${r.id}" value="3" disabled="disabled"/><span></span>
									    <input type="radio" name="rating-${r.id}" value="4" disabled="disabled"/><span></span>
									    <input type="radio" name="rating-${r.id}" value="5" disabled="disabled"/><span></span>
									</span>
								</h5> 
								<p>
									<spring:message code="${r.type}"/>
								</p>
								
								<p>${r.description}</p>
								<p class="address">${r.street} ${r.number} - ${r.postalCode}, ${r.city}, <spring:message code="${r.country.name}"/></p>
								<c:if test="${!empty r.phone}"><p class="phone">${r.phone}</p></c:if>
								<c:if test="${!empty r.website}"><p class="websiteLink"><a href="${r.website}" target="_blank"><spring:message code="website"/></a></p></c:if>
							</div>
							<div class="resultRight">
								<p>
									<a href="https://www.google.com/maps/dir/${filter.latitude},${filter.longitude}/${r.latitude},${r.longitude}" target="_blank">
										<img src="/images/compass.png" alt="<spring:message code="directions"/>" title="<spring:message code="directions"/>"/>
									</a>
									<br/>${r.distanceString}
								</p>
								<p></p>
							</div>
							<div id="infoWindow${i.index+1}" style="display: none;">
								<span class="infoWindowTitle">${r.name}</span>
								<p><a href="https://www.google.com/maps/dir/${filter.latitude},${filter.longitude}/${r.latitude},${r.longitude}" target="_blank" title="Google Maps">${r.street}, ${r.number} ${r.postalCode}, ${r.city}, <spring:message code="${r.country.name}"/></a></p>
							</div>
						</article>
					</c:forEach>
				</section>
			</c:when>
			<c:otherwise>
				<section>
					<article>
					<c:if test="${!empty filter && !empty filter.address}">
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
			<p>${filter.address}</p>
		</div>

		
	
<script type="text/javascript" src="/js/maps.js"></script>  
<script type="text/javascript">
google.maps.event.addDomListener(window, 'load', initialize);
$(window).load(function () {
	
	$("input[name='_types']").remove();
	
	<c:if test="${!empty filter && !empty filter.address}">
		setOrigin('${filter.latitude}', '${filter.longitude}', 'infoWindowYour');
	</c:if>
	
	<c:forEach items="${restaurants}" var="r" varStatus="i">
		createMark('${i.index+1}', '${r.latitude}', '${r.longitude}', '${r.name}');
		var rate = $('input[name=rating-${r.id}]');
		for(var i = 1; i < 6; i++) {
			if(rate[i].value == '${r.rating}')
				$(rate[i]).attr('checked', 'checked'); 
		}
	</c:forEach>
	
});
</script>	
</body>
</html>
