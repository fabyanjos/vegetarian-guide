<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 				prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" 				prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" 			prefix="spring"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<!doctype html>
<html lang="pt-br">
<head> 
	<meta charset="UTF-8">
	<meta http-equiv=”content-language” content="pt-br">
	<title>Veggie Out :: <decorator:title/></title>
	<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon"/> 
	
	<link rel="stylesheet" type="text/css" href="/css/styles.min.css"/>
	
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="//maps.googleapis.com/maps/api/js?libraries=geometry,places&amp;language=${pageContext.response.locale}" ></script>
    
	<decorator:head/>
</head>

<body>
	<div id="fb-root"></div>
	<script>(function(d, s, id) {
	  var js, fjs = d.getElementsByTagName(s)[0];
	  if (d.getElementById(id)) return;
	  js = d.createElement(s); js.id = id;
	  js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&appId=426669610763003&version=v2.0";
	  fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));
	</script>
	<jsp:include page="/WEB-INF/pages/template/header.jsp"/>
	
	<div id="content">
		
		<div id="mainContent">
			<decorator:body/>
		</div>
		
		<aside>
			<jsp:include page="/WEB-INF/pages/template/side.jsp"/>
		</aside>
	</div>

	<jsp:include page="/WEB-INF/pages/template/footer.jsp"/>
	
	

    <script src="/js/jquery.blockUI.js"></script>
    <script src="/js/jquery.slides.min.js"></script>
    <script src="/js/reviews.min.js"></script>
    <script src="/js/custom.min.js"></script>
   </body>
</html>