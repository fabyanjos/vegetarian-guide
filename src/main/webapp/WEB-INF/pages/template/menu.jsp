<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 			prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" 			prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" 		prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 	prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" 	prefix="fn" %>
<!doctype html>
<html lang="en">
<body>

	<!--p id="languageBtn">
		<a href="<c:url value='?lang=en'/>" title="<spring:message code="english"/>"><img src="/images/english-icon.png"/></a> 
		<a href="<c:url value='?lang=pt_BR'/>" title="<spring:message code="portuguese"/>"><img src="/images/portuguese-icon.png"/></a>
	</p-->
	<section>
		<c:choose>
			<c:when
				test="${!empty SPRING_SECURITY_CONTEXT.authentication.principal}">
				<div id="userBox">
					<img
						src="https://graph.facebook.com/<c:out value="${SPRING_SECURITY_CONTEXT.authentication.principal.login}"/>/picture?type=square" />
					<div>
						<p>
							<c:out
								value="${SPRING_SECURITY_CONTEXT.authentication.principal.name}" />
						</p>
						<a href="/rest/user/logout">Logout</a>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div style="display: none;" onclick="login();" id="loginBtn">
					<p>
						<spring:message code="facebook.connect" />
					</p>
				</div>
			</c:otherwise>
		</c:choose>
		<div class="fb-like" data-href="<spring:message code="site.url"/>" data-send="false" data-width="250" data-show-faces="true"></div>
	</section>
	
	<section>
		<header>
			<h3><spring:message code="latest.reviews" /></h3>
		</header>
		
		<c:forEach items="${reviewsList}" var="review" varStatus="i">
			<article>
				<h4>
					<a href="/restaurant/details/${review.restaurant.id}#${review.id}">${review.restaurant.name}</a>
					<span class="light-green"><fmt:formatDate pattern="dd/MM/yy HH:mm" value="${review.date}"/></span>
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
		<a class="side-banner recycle-banner" href="http://www.brasil.gov.br/sobre/meio-ambiente/gestao-do-lixo/reciclagem" 
			title="Recicle" target="_blank">
			<img src="/images/recycle.gif" width="100" alt="Recicle" title="Recicle"/>
			<span>Reciclagem</span>
		</a>
	</section>

</body>
</html>