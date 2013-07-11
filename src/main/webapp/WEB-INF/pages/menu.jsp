<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html lang="en">
<body>

	<!--p id="languageBtn">
		<a href="<c:url value='?lang=en'/>" title="<spring:message code="english"/>"><img src="/images/english-icon.png"/></a> 
		<a href="<c:url value='?lang=pt_BR'/>" title="<spring:message code="portuguese"/>"><img src="/images/portuguese-icon.png"/></a>
	</p-->
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
	<div class="fb-like" data-href="<spring:message code="site.url"/>"
		data-send="false" data-width="250" data-show-faces="true"></div>

	<h3>
		<spring:message code="latest.reviews" />
	</h3>
	<div id="lastReviews"></div>

	<!--article class="holder_news">
   <h4>Try @Home</h4>
   <ul>
   	<li>teste 01</li>
   	<li>teste 02</li>
   	<li>teste 03</li>
   </ul>
   </article-->

	<!-- a class="photo_hover2" href="#"><img src="/images/picture3.jpg" width="257" height="295" alt="picture"/></a-->

</body>
</html>