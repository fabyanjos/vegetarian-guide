<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 			prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" 			prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" 		prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 	prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" 	prefix="fn" %>

<section>
	<c:choose>
		<c:when test="${!empty SPRING_SECURITY_CONTEXT.authentication.principal}">
			<div id="userBox">
				<div class="user-image">
					<img src="${SPRING_SECURITY_CONTEXT.authentication.principal.imageUrl}" />
					<div class="user-${SPRING_SECURITY_CONTEXT.authentication.principal.network}"></div>
				</div>
				<div>
					<p>
						<c:out value="${SPRING_SECURITY_CONTEXT.authentication.principal.name}" />
					</p>
					<a href="/rest/user/logout">Logout</a>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<h3><spring:message code="login.with"/>:</h3>
			<a href="/socialauth?id=facebook" onclick="_gaq.push(['_trackEvent', 'Side', 'Login', 'Facebook']);" id="facebook-login">
				<p>
					Facebook
				</p>
			</a>
			<a href="/socialauth?id=googleplus" onclick="_gaq.push(['_trackEvent', 'Side', 'Login', 'Google']);" id="google-login">
				<p>
					Google
				</p>
			</a>
		</c:otherwise>
	</c:choose>
</section>

<section>
	<h3><spring:message code="share"/>:</h3>
	<!--div class="fb-like" data-href="<spring:message code="site.url"/>" data-send="false" data-width="50" data-show-faces="false"></div>
	<div class="g-plusone" data-size="tall" data-href="<spring:message code="site.url"/>"></div-->
	
	<div id="shareme" data-url="<spring:message code="site.url"/>" data-text="Veggie Out: <spring:message code="share.text"/>"></div>
	
</section>

<section>
	<header>
		<h3><spring:message code="latest.reviews" /></h3>
	</header>
	
	<c:forEach items="${reviewsList}" var="review" varStatus="i">
		<article>
			<h4>
				<a href="/restaurant/${review.restaurant.nameUrl}#review-${review.id}">${review.restaurant.name}</a>
			</h4>
			<p>
				${fn:substring(review.description, 0, 150)}
				<c:if test="${fn:length(review.description) > 150}">...</c:if>
			</p>
		</article>
	</c:forEach>
</section>

<section>
	<h3>Links</h3>
	<ul class="arrow-list">
		<li><a href="http://composicao-alimentos.herokuapp.com" target="_blank">Composição dos Alimentos</a></li>
	</ul>
	<a class="side-banner recycle-banner" href="http://www.brasil.gov.br/sobre/meio-ambiente/gestao-do-lixo/reciclagem" 
		title="Recicle" target="_blank">
		<img src="/images/recycle.gif" width="100" alt="Recicle" title="Recicle"/>
		<span>Reciclagem</span>
	</a>
</section>
