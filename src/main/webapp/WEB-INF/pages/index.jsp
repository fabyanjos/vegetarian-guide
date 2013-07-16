<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"		prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" 	prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!doctype html>
<html lang="en">


<head>
	<section id="intro">
		<header>
			<h2>Veggie Out</h2>
		</header>
		<p>Sua ferramenta para busca de restaurantes Vegetarianos e Veganos.</p>
		<img src="http://veggie-out.herokuapp.com/images/map-with-pin.jpg" alt="Veggie Out" />
	</section>
</head>
<body>
	
	<section>
		<h2><spring:message code="latest.restaurants"/></h2>
		<c:forEach items="${restaurants}" var="r" varStatus="i">
			<article>
				<c:if test="${!empty r.imageUrl}">
					<a href="/restaurant/details/${r.id}" class="photo">
						<img alt="${r.name}" src="${r.imageUrl}">
					</a>
				</c:if>
				<h4><a href="/restaurant/details/${r.id}">${r.name}</a></h4>
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
		<p>Veggie Out sua ferramenta para busca de restaurantes Vegetarianos e Veganos.</p>
		<p>Compartilhe e avalie opções para comer com outras pessoas e ajude para que novas opções sejam descobertas.<span class="readmore"> <a href="/about"><spring:message code="read.more"/>..</a></span>
		</p>
	</article>
	</section>
   
</body>
</html>