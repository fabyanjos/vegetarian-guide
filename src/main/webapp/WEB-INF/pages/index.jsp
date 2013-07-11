<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"				prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" 	prefix="spring"%>
<!doctype html>
<html lang="en">

<head>
	<!--start intro-->
	
	<div id="intro">
		<div>
			<img src="/images/map-with-pin.jpg" alt="baner">
		</div>
	</div>
	<!--end intro-->
	
	<header class="group_bannner_left">
		<hgroup>
			<h1>Veggie Out</h1>
			<h2>sua ferramenta para busca de restaurantes Vegetarianos e Veganos.</h2>
		</hgroup>
		<div class="button black banner">
			<a href="/restaurant/search">Pesquisar</a>
		</div>
	</header>
</head>

<body>
	<h3><spring:message code="latest.restaurants"/></h3>

	<div id="restaurantsListHome">
	</div>
    
	<h3><spring:message code="about.us"/></h3>
	<a class="photo_hover2" href="/about"><img src="/images/map-with-pin.jpg" width="200" height="97" alt="picture1"/></a>
	<br/>
	<p>Veggie Out sua ferramenta para busca de restaurantes Vegetarianos e Veganos.</p>
	<p>Compartilhe e avalie opções para comer com outras pessoas e ajude para que novas opções sejam descobertas.<span class="readmore"> <a href="/about"><spring:message code="read.more"/>..</a></span>
	</p>

    <!--h3>Testimonials</h3>
    <p>"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec molestie. Sed aliquam sem ut arcu. Phasellus sollicitudin. 
   Vestibulum condimentum facilisis nulla. In hac habitasse platea dictumst." - Lorem ipsum  </p>

   <p>"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec molestie. Sed aliquam sem ut arcu. Phasellus sollicitudin. 
   Vestibulum condimentum facilisis nulla. In hac habitasse platea dictumst." - Lorem ipsum  </p-->
   
   <script type="text/javascript" src="/js/restaurants.js"></script>
</body>
</html>