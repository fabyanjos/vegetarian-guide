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
	
	<link rel="stylesheet" type="text/css" href="/css/styles.css"/>
	<link rel="stylesheet" type="text/css" href="/css/custom.css"/>
	<link rel="stylesheet" href="//www.google.com/cse/style/look/default.css" type="text/css" />
    <link href='//fonts.googleapis.com/css?family=Open+Sans:300,400' rel='stylesheet' type='text/css'>
    
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script id="jqueryui" src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" defer async></script>
    <script src="//www.google.com/jsapi"></script>
    <script type="text/javascript" src="//maps.googleapis.com/maps/api/js?sensor=false&libraries=geometry,places&amp;language=${pageContext.response.locale}"></script>
    
    <script type="text/javascript">
    	var lang = '${pageContext.response.locale}';
    </script>
    <script src="/js/jquery.sharrre-1.3.4.min.js"></script>
    <script src="/js/custom.js"></script>
    <script src="/js/facebook.js"></script>
    <script src="/js/hello.js"></script>
    <script src="/js/jquery.blockUI.js"></script>
    <script src="/js/social-network.js"></script>
    <script src="/js/jquery.slides.min.js"></script>

	<decorator:head/>
</head>

<body>
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
	
   </body>
</html>