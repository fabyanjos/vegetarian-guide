<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"		prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" 	prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!doctype html>
<html lang="en">
<head>
<title>Home</title>
<meta name="keywords" content="<spring:message code="meta.keywords"/>">
<meta name="description" content="<spring:message code="meta.description"/>">
</head>
<body>
	<div class="container-slides">
		<div id="slides">
			<a href="/restaurant/new">
				<img src="/images/banner.png" alt="Adicionar um novo restaurante">
			</a>
			<a href="/restaurant/new">
				<img src="/images/banner.png" alt="Adicionar um novo restaurante">
			</a>
		</div>
	</div>	
	<section>
		<h2><spring:message code="latest.restaurants"/></h2>
		<c:forEach items="${restaurants}" var="r" varStatus="i">
			<article>
				<c:if test="${!empty r.imageUrl}">
					<a href="/restaurant/${r.nameUrl}" class="photo">
						<img alt="${r.name}" src="${r.imageUrl}">
					</a>
				</c:if>
				<h4><a href="/restaurant/${r.nameUrl}">${r.name}</a></h4>
				<p>
					${fn:substring(r.description, 0, 250)}
					<c:if test="${fn:length(r.description) > 250}">...</c:if>
				</p>
			</article>
		</c:forEach>
	</section>
    
    <section>
	<h3><spring:message code="about.us"/></h3>
	<article>
		<a class="photo" href="/about"><img src="/images/map-with-pin.jpg" alt="<spring:message code="about.us"/>"></a>
		<p>&nbsp;</p>
		<p><spring:message code="about.one"/></p>
		<p><spring:message code="about.two"/><span class="readmore"> <a href="/about"><spring:message code="read.more"/>..</a></span>
		</p>
	</article>
	</section>
</body>
</html>