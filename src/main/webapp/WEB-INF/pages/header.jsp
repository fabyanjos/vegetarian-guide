<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html lang="en">
<body>

	<header>

		<!--start logo-->
		<a href="/" id="logo" onclick="_gaq.push(['_trackEvent', 'Superior', 'Logo', 'Logo']);"><img src="/images/logo.png" alt="logo" /></a>
		<!--end logo-->

		<!--start menu-->
		<nav>
			<ul id="menu">
			   <li><a href="/" onclick="_gaq.push(['_trackEvent', 'Superior', 'Menu', 'Home']);" <c:if test="${current eq 'home'}">class="current"</c:if>><spring:message code="home"/></a></li>
			   <li><a href="/restaurant/search" onclick="_gaq.push(['_trackEvent', 'Superior', 'Menu', 'Search']);" <c:if test="${current eq 'search'}">class="current"</c:if>><spring:message code="search"/></a></li>
			   <li><a href="/restaurant/new" onclick="_gaq.push(['_trackEvent', 'Superior', 'Menu', 'New']);" <c:if test="${current eq 'add'}">class="current"</c:if>><spring:message code="add"/></a></li>
			   <li><a href="/about" onclick="_gaq.push(['_trackEvent', 'Superior', 'Menu', 'About']);" <c:if test="${current eq 'about'}">class="current"</c:if>><spring:message code="about"/></a></li>
			   <li><a href="/contact" onclick="_gaq.push(['_trackEvent', 'Superior', 'Menu', 'Contact']);" <c:if test="${current eq 'contact'}">class="current"</c:if>><spring:message code="contact"/></a></li>
			</ul>
		</nav>
		<!--end menu-->

		<!--end header-->
	</header>

</body>
</html>