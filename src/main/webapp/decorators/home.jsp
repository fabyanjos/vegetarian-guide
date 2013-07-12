<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 				prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" 				prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" 			prefix="spring"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<!doctype html>
<html lang="en">
<head> 
	<meta charset="UTF-8">
	<meta http-equiv=”content-language” content="en">
	<meta name="description" content="<spring:message code="meta.description"/>">
	<meta name="keywords" content="<spring:message code="meta.keywords"/>">
	<meta name="author" content="Fabiana Anjos">
	<title>Veggie Out :: <decorator:title/></title>
	<link rel="shortcut icon" href="/images/favicon.png" type="image/x-icon"/> 
	
	<link rel="stylesheet" type="text/css" href="/css/styles.css"/>
	<link rel="stylesheet" type="text/css" href="/css/custom.css"/>
	<link rel="stylesheet" type="text/css" href="/css/rating.css"/>
	<link rel="stylesheet" type="text/css" href="/css/photobox.css"/>
	<link rel="stylesheet" href="//www.google.com/cse/style/look/default.css" type="text/css" />
    <link href='//fonts.googleapis.com/css?family=Open+Sans:300,400' rel='stylesheet' type='text/css'>
    
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script id="jqueryui" src="//ajax.googleapis.com/ajax/libs/jqueryui/1.8.10/jquery-ui.min.js" defer async></script>
    <script src="//www.google.com/jsapi"></script>
    <script type="text/javascript" src="//maps.googleapis.com/maps/api/js?sensor=false&libraries=geometry,places&amp;language=${pageContext.response.locale}"></script>
    
    <script type="text/javascript">
    	var lang = '${pageContext.response.locale}';
    </script>
    
    <script src="/js/photobox.js"></script>
    <script src="/js/jquery.carouFredSel-6.2.1.js"></script>
    <script src="/js/date.js"></script>
    <script src="/js/custom.js"></script>
    <script src="/js/facebook.js"></script>

</head>

<body>
	<div id="fb-root"></div>
	<!--start container-->
	<div id="container">
		<!--start header-->
		<header>

			<!--start logo-->
			<a href="/" id="logo"><img src="/images/logo.png" alt="logo" /></a>
			<!--end logo-->

			<!--start menu-->
			<nav>
				<ul id="menu">
				   <li><a href="/" <c:if test="${current eq 'home'}">class="current"</c:if>><spring:message code="home"/></a></li>
				   <li><a href="/restaurant/search" <c:if test="${current eq 'search'}">class="current"</c:if>><spring:message code="search"/></a></li>
				   <li><a href="/restaurant/new" <c:if test="${current eq 'add'}">class="current"</c:if>><spring:message code="add"/></a></li>
				   <li><a href="/about" <c:if test="${current eq 'about'}">class="current"</c:if>><spring:message code="about"/></a></li>
				   <li><a href="/contact" <c:if test="${current eq 'contact'}">class="current"</c:if>><spring:message code="contact"/></a></li>
			   </ul>
			</nav>
			<!--end menu-->

			<!--end header-->
		</header>

		<decorator:head />
		<!--start holder-->

		<div class="holder_content">

			<section class="group1">

				<decorator:body />

			</section>

			<aside class="group2">

				<jsp:include page="/WEB-INF/pages/menu.jsp"></jsp:include>

			</aside>

		</div>
		<!--end holder-->

	</div>
	<!--end container-->

	<!--start footer-->
   <footer>
   <div class="container">
   <div id="FooterTwo"> © 2013 Veggie Out </div>
   <div id="FooterTree"> Design and code by <a href="http://www.marijazaric.com">marija zaric</a>, customized by fabyanjos</div> 
   </div>
   </footer>
   <!--end footer-->
   <!-- Free template distributed by http://freehtml5templates.com -->
   <!-- Flag's icons by http://www.icons-land.com from http://www.iconarchive.com/ -->
   <script type="text/javascript" src="/js/reviews.js"></script>
   <script type="text/javascript">
	  var _gaq = _gaq || [];
	  _gaq.push(['_setAccount', 'UA-40354748-1']);
	  _gaq.push(['_trackPageview']);

	  (function() {
	    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
	    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
	    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
	  })();
	</script>
   </body>
</html>