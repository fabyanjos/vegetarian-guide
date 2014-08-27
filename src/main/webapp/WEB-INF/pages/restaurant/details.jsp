<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"			prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"			prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" 		prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 	prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" 	prefix="fn" %>
<!doctype html>
<html lang="en">
<head>
	<title><spring:message code="restaurant"/> ${restaurant.name} - ${restaurant.city}, ${restaurant.state}</title>
	<meta content="${fn:substring(restaurant.description, 0, 250)}<c:if test="${fn:length(restaurant.description) > 250}">...</c:if>" name="description" />
	<meta content="<spring:message code="restaurant"/>, ${restaurant.name}, ${restaurant.street}, ${restaurant.number}, ${restaurant.city}, ${restaurant.state}, <spring:message code="${restaurant.type}"/>" name="keywords" />
	<meta content="<spring:message code="restaurant"/> ${restaurant.name}" property="og:title" />
	<meta content="<spring:message code="restaurant"/> <spring:message code="${restaurant.type}"/> em  ${restaurant.city}, ${restaurant.state}" property="og:description" />
	
	<meta property="place:location:latitude" content="${restaurant.latitude}"/>
	<meta property="place:location:longitude" content="${restaurant.longitude}"/>
	<meta property="business:contact_data:street_address" content="${restaurant.street}"/>
	<meta property="business:contact_data:locality" content="${restaurant.city}"/>
	<meta property="business:contact_data:postal_code" content="${restaurant.postalCode}"/>
	<meta property="business:contact_data:country_name" content="<spring:message code="${restaurant.country.name}"/>"/>
		
	<link rel="stylesheet" type="text/css" href="/css/photobox.css"/>
	<link rel="stylesheet" type="text/css" href="/css/carousel.css"/>
	<script src="/js/photobox.js"></script>
	<script src="/js/jquery.carouFredSel-6.2.1.js"></script>
</head>
<body>
	<h2>
		${restaurant.name}
		<span class="rating">
		    <input type="radio" name="rating-main" value="0" checked /><span id="hide"></span>
		    <input type="radio" name="rating-main" value="1" disabled="disabled"/><span></span>
		    <input type="radio" name="rating-main" value="2" disabled="disabled"/><span></span>
		    <input type="radio" name="rating-main" value="3" disabled="disabled"/><span></span>
		    <input type="radio" name="rating-main" value="4" disabled="disabled"/><span></span>
		    <input type="radio" name="rating-main" value="5" disabled="disabled"/><span></span>
		</span>
	</h2>
	
	<section>
		<c:if test="${!empty success}">
		 <p class="successMsg"><spring:message code="${success}"/></p>
		</c:if>
		<div id="map-canvas"></div>
	</section>
	<section>
		<p>
			<strong><spring:message code="type"/></strong>: 
			<spring:message code="${restaurant.type}"/>
		</p>
		<p>
			<strong><spring:message code="delivery"/></strong>: 
			<spring:message code="${restaurant.delivery}"/>
		</p>
		<p>
			<strong><spring:message code="price"/></strong>
			<a href="#" class="tooltip">
				<img src="/images/help.png" width="14">
				<span>
					<b></b>
					<spring:message code="price.list"/>
				</span>
			</a>
			:
			<span class="price">
			    <input type="radio" name="price" value="0" checked /><span id="hide"></span>
			    <input type="radio" name="price" value="1" disabled="disabled"/><span></span>
			    <input type="radio" name="price" value="2" disabled="disabled"/><span></span>
			    <input type="radio" name="price" value="3" disabled="disabled"/><span></span>
			    <input type="radio" name="price" value="4" disabled="disabled"/><span></span>
			</span>
		</p>
		<p>
			<strong><spring:message code="openingTimes"/></strong>:
			${restaurant.openingTimes}
		</p>
		<p>
			<strong><spring:message code="description"/></strong>:
			${restaurant.description}
		</p>
		<p class="address">${restaurant.street}, ${restaurant.number} ${restaurant.postalCode}, ${restaurant.city}, <spring:message code="${restaurant.country.name}"/></p>
		<c:if test="${!empty restaurant.phone}"><p class="phone">${restaurant.phone}</p></c:if>
		<c:if test="${!empty restaurant.website}"><p class="websiteLink"><a href="${restaurant.website}" target="_blank">${restaurant.website}</a></p></c:if>
		
		<div id="infoWindow" style="display: none;">
			<span class="infoWindowTitle">${restaurant.name}</span>
			<p>
				<a href="https://www.google.com/maps/place/${restaurant.street}+${restaurant.number}+${restaurant.city}+${restaurant.state}+<spring:message code="${restaurant.country.name}"/>" target="_blank" title="Google Maps">
					${restaurant.street}, ${restaurant.number}  ${restaurant.postalCode}, ${restaurant.city}, <spring:message code="${restaurant.country.name}"/>
				</a>
			</p>
		</div>
	</section>
	
	<section>
		<h3>
			<a name="images"><spring:message code="images"/></a>
			<span class="light-green"><a href="/restaurant/image/${restaurant.id}"><spring:message code="addimage"/></a></span>
		</h3>
		<c:choose>
			<c:when test="${!empty images}">
			<div class="image-box">
				<div id="carousel">
					<ul>
					<c:forEach items="${images}" var="image" varStatus="i">
						<li>
							<a href="${image.filePath}">
								<img src="${image.filePath}" alt="${image.name}" title="${image.name}"/>
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
			</c:when>
			<c:otherwise>
				<p class="infoMsg">
	    			<spring:message code="images.empty"/>
	    		</p>
			</c:otherwise>
		</c:choose>
	</section>
	
	<section id="comments">
		<h3>
			<a name="reviews"><spring:message code="reviews"/></a>
			<span class="light-green"><a href="/restaurant/review/${restaurant.id}"><spring:message code="rating"/></a></span>
		</h3>
		<c:if test="${empty reviews}">
			<p class="infoMsg">
    			<spring:message code="reviews.empty"/>
    		</p>
		</c:if>
		<c:forEach items="${reviews}" var="r" varStatus="i">
			<article>
				<header>
					<a href="https://www.facebook.com/${r.user.login}" target="_blank">
						<img src="${r.user.imageUrl}"/>
						<span>${r.user.name}</span>
					</a> 
				</header>
				<section>
					<h5>
						<a name="review-${r.id}">${r.title}</a>
						<span class="rating">
						    <input type="radio" name="rating-${r.id}" value="0" checked /><span id="hide"></span>
						    <input type="radio" name="rating-${r.id}" value="1" disabled="disabled"/><span></span>
						    <input type="radio" name="rating-${r.id}" value="2" disabled="disabled"/><span></span>
						    <input type="radio" name="rating-${r.id}" value="3" disabled="disabled"/><span></span>
						    <input type="radio" name="rating-${r.id}" value="4" disabled="disabled"/><span></span>
						    <input type="radio" name="rating-${r.id}" value="5" disabled="disabled"/><span></span>
						</span>
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
		var rating = $('input[name=rating-main]');
		for(var i = 1; i < 6; i++) {
			if(rating[i].value == '${restaurant.rating}')
				$(rating[i]).attr('checked', 'checked'); 
		}
		var price = $('input[name=price]');
		for(var i = 1; i < 5; i++) {
			if(price[i].value == '${restaurant.price}')
				$(price[i]).attr('checked', 'checked'); 
		}
	</c:if>
	<c:forEach items="${reviews}" var="r" varStatus="i">
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