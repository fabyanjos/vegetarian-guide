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
		<h3>
			${restaurant.name}
			<span class="ratingDiv rating " id="rating"></span>
		</h3>
		<c:if test="${!empty success}">
		 <p class="successMsg"><spring:message code="${success}"/></p>
		</c:if>
		<div id="map-canvas"></div>
		<div id="place">
			<div id="detailsDiv">
				<p>
					<em><spring:message code="type"/></em>: 
					<spring:message code="${restaurant.type}"/>
				</p>
				
				<p>${restaurant.description}</p>
				<p class="address">${restaurant.street}, ${restaurant.number} ${restaurant.postalCode}, ${restaurant.city}, <spring:message code="${restaurant.country.name}"/></p>
				<c:if test="${!empty restaurant.phone}"><p class="phone">${restaurant.phone}</p></c:if>
				<c:if test="${!empty restaurant.website}"><p class="websiteLink"><a href="${restaurant.website}" target="_blank"><spring:message code="website"/></a></p></c:if>
			</div>
			
			<div id="infoWindow" style="display: none;">
				<span class="infoWindowTitle">${restaurant.name}</span>
				<p>${restaurant.street}, ${restaurant.number} ${restaurant.postalCode}, ${restaurant.city}, <spring:message code="${restaurant.country.name}"/></p>
			</div>
			<br/>
			<c:if test="${!empty images}">
			<h3>
				<spring:message code="images"/>
				<span id="ratingLink"><a href="/restaurant/image/${restaurant.id}"><spring:message code="addimage"/></a></span>
			</h3>
			<div class="divBox">
			<div id="carousel">
				<ul>
				<c:forEach items="${images}" var="image" varStatus="i">
					<li>
						<a href="${image.filePath}">
							<img src="${image.filePath}" alt="${image.name}"/>
						</a>
					</li>
				</c:forEach>
				</ul>
				<div class="clearfix"></div>
			    <!-- prev and next button -->
			    <a id="prev" class="prev" href="#"><</a>
			    <a id="next" class="next" href="#">></a>
			    <!-- pagination -->
			    <div id="pager" class="pager"></div>
			</div>
			</div>
			</c:if>
			
			<h3>
				<spring:message code="reviews"/>
				<span id="ratingLink"><a href="/restaurant/review/${restaurant.id}"><spring:message code="rating"/></a></span>
			</h3>
			<ul id="listResult">
				<c:forEach items="${reviews}" var="r" varStatus="i">
					<li>
						<div class="reviewLeft">
							<img src="https://graph.facebook.com/${r.user.login}/picture?type=square"/>
							<p>${r.user.login}</p>
						</div>
						<div class="reviewRight">
							<em><a name="${r.id}">${r.title}</a></em>
							<div class="ratingDiv rating " id="rating${i.index}">
							</div>
							<p><fmt:formatDate value="${r.date}" pattern="dd/MM/yyyy HH:mm"/></p>
							<p>${r.description}</p>
							<p class="pros">${r.pros}</p>
							<p class="cons">${r.cons}</p>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>

<script type="text/javascript" src="/js/maps.js"></script>  
<script type="text/javascript">
$(document).ready(function () {
	<c:if test="${!empty restaurant}">
		setOrigin('${restaurant.latitude}', '${restaurant.longitude}', 'infoWindow');
		var style = $('#rating').attr("class");
		style += numberText(${restaurant.rating});
		style += "star";
		$('#rating').attr("class", style); 
	</c:if>
	<c:forEach items="${reviews}" var="r" varStatus="i">
		var style = $('#rating${i.index}').attr("class");
		style += numberText(${r.rating});
		style += "star";
		$('#rating${i.index}').attr("class", style); 
	</c:forEach>
});
</script>	

</body>
</html>