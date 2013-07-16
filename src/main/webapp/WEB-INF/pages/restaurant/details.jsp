<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"			prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"			prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" 		prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 	prefix="form"%>
<!doctype html>
<html lang="en">
<head>
	<title><spring:message code="restaurant"/> :: ${restaurant.name}</title>
	<meta name="description" content="<spring:message code="meta.description"/>, ${restaurant.name}, ${restaurant.street} ${restaurant.number}, ${restaurant.city}">
	<link rel="stylesheet" type="text/css" href="/css/photobox.css"/>
	<link rel="stylesheet" type="text/css" href="/css/carousel.css"/>
	<script src="/js/photobox.js"></script>
	<script src="/js/jquery.carouFredSel-6.2.1.js"></script>
</head>
<body>
	<h2>
		${restaurant.name}
		<span class="ratingDiv rating " id="rating"></span>
	</h2>
	<section>
		<c:if test="${!empty success}">
		 <p class="successMsg"><spring:message code="${success}"/></p>
		</c:if>
		<div id="map-canvas"></div>
	</section>
	<section>
		<p>
			<em><spring:message code="type"/></em>: 
			<spring:message code="${restaurant.type}"/>
		</p>
		
		<p>${restaurant.description}</p>
		<p class="address">${restaurant.street}, ${restaurant.number} ${restaurant.postalCode}, ${restaurant.city}, <spring:message code="${restaurant.country.name}"/></p>
		<c:if test="${!empty restaurant.phone}"><p class="phone">${restaurant.phone}</p></c:if>
		<c:if test="${!empty restaurant.website}"><p class="websiteLink"><a href="${restaurant.website}" target="_blank"><spring:message code="website"/></a></p></c:if>
		
		<div id="infoWindow" style="display: none;">
			<span class="infoWindowTitle">${restaurant.name}</span>
			<p>${restaurant.street}, ${restaurant.number} ${restaurant.postalCode}, ${restaurant.city}, <spring:message code="${restaurant.country.name}"/></p>
		</div>
	</section>
	
	<section>
		<h3>
			<spring:message code="images"/>
			<span class="light-green"><a href="/restaurant/image/${restaurant.id}"><spring:message code="addimage"/></a></span>
		</h3>
		<c:if test="${!empty images}">
		<div class="image-box">
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
	</section>
	
	<section id="comments">
		<h3>
			<spring:message code="reviews"/>
			<span class="light-green"><a href="/restaurant/review/${restaurant.id}"><spring:message code="rating"/></a></span>
		</h3>
		<c:forEach items="${reviews}" var="r" varStatus="i">
			<article>
				<header>
					<a href="https://www.facebook.com/${r.user.login}" target="_blank">
						<img src="https://graph.facebook.com/${r.user.login}/picture?type=square"/>
						<span>${r.user.name}</span>
					</a> 
				</header>
				<section>
					<h5>
						<a name="${r.id}">${r.title}</a>
						<span class="rating " id="rating${i.index}"></span>
					</h5>
					<div style="width: 480px;">
						<spring:message code="on"/>
						<time datetime="2009-06-29T23:35:20+01:00"><fmt:formatDate value="${r.date}" pattern="dd/MM/yyyy HH:mm"/> </time>
						<p>${r.description}</p>
						<p class="pros">${r.pros}</p>
						<p class="cons">${r.cons}</p>
					</div>
				</section>
			</article>
		</c:forEach>
		
	</section>
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