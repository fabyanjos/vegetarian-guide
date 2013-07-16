<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html lang="en">
<body>

	<div id="fb-root"></div>
	<!--[if lte IE 7]>
		<script src="ie6/warning.js"></script><script>window.onload=function(){e("js/ie6/")}</script>
	<![endif]-->
	<header>
		<a href="/" id="logo">
			<h1>Veggie Out</h1>
		</a>
	</header>
	<nav>
		<ul>
		   <li <c:if test="${current eq 'home'}">class="selected"</c:if>><a href="/" onclick="_gaq.push(['_trackEvent', 'Superior', 'Menu', 'Home']);"><spring:message code="home"/></a></li>
		   <li <c:if test="${current eq 'search'}">class="selected"</c:if>><a href="/restaurant/search" onclick="_gaq.push(['_trackEvent', 'Superior', 'Menu', 'Search']);"><spring:message code="search"/></a></li>
		   <li <c:if test="${current eq 'add'}">class="selected"</c:if>><a href="/restaurant/new" onclick="_gaq.push(['_trackEvent', 'Superior', 'Menu', 'New']);"><spring:message code="add"/></a></li>
		   <li <c:if test="${current eq 'about'}">class="selected"</c:if>><a href="/about" onclick="_gaq.push(['_trackEvent', 'Superior', 'Menu', 'About']);"><spring:message code="about"/></a></li>
		   <li <c:if test="${current eq 'contact'}">class="selected"</c:if>><a href="/contact" onclick="_gaq.push(['_trackEvent', 'Superior', 'Menu', 'Contact']);"><spring:message code="contact"/></a></li>
		</ul>
	</nav>

</body>
</html>