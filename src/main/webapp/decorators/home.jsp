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
	<link rel="shortcut icon" href="favicon.ico" type="image/x-icon"/> 
	
	<link rel="stylesheet" type="text/css" href="/css/styles.css"/>
	<link rel="stylesheet" type="text/css" href="/css/custom.css"/>
	<link rel="stylesheet" type="text/css" href="/css/rating.css"/>
	<link rel="stylesheet" type="text/css" href="/css/photobox.css"/>
	<link rel="stylesheet" href="//www.google.com/cse/style/look/default.css" type="text/css" />
    <link href='//fonts.googleapis.com/css?family=Open+Sans:300,400' rel='stylesheet' type='text/css'>
    
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script id="jqueryui" src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" defer async></script>
    <script src="//www.google.com/jsapi"></script>
    <script type="text/javascript" src="//maps.googleapis.com/maps/api/js?sensor=false&libraries=geometry,places&amp;language=${pageContext.response.locale}"></script>
    
    <script type="text/javascript">
    	var lang = '${pageContext.response.locale}';
    </script>
    
    <script src="/js/custom.js"></script>
    <script src="/js/facebook.js"></script>
    <script src="/js/hello.js"></script>
    <script src="/js/social-network.js"></script>
    <script type="text/javascript">
	  (function() {
	    var po = document.createElement('script'); po.type = 'text/javascript'; po.async = true;
	    po.src = 'https://apis.google.com/js/plusone.js';
	    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(po, s);
	  })();
	</script>

</head>

<body>
	<jsp:include page="/WEB-INF/pages/template/header.jsp"/>
	
	<decorator:head/>
	
	<div id="content">
		
		<div id="mainContent">
			<decorator:body/>
		</div>
		
		<aside>
			<jsp:include page="/WEB-INF/pages/template/side.jsp"/>
		</aside>
	</div>
	<footer>
		<div id="footer-left">Created by fabyanjos | © 2013 Veggie Out</div>
		<div id="footer-right">
			
			<p id="languageBtn">
				<a href="<c:url value='?lang=en'/>" title="<spring:message code="english"/>"><img src="/images/english-icon.png"/></a> 
				<a href="<c:url value='?lang=pt_BR'/>" title="<spring:message code="portuguese"/>"><img src="/images/portuguese-icon.png"/></a>
			</p>
		</div>
	</footer>
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