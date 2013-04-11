<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<!DOCTYPE html>  
<head>
	<meta charset="UTF-8">
	<title><decorator:title default="Fresh Ideas"/></title>
	<link rel="shortcut icon" href="images/favicon.gif" type="image/x-icon"/> 
	<link rel="stylesheet" type="text/css" href="css/styles.css"/>
	<link rel="stylesheet" type="text/css" href="css/custom.css"/>
	<link rel="stylesheet" href="//www.google.com/cse/style/look/default.css" type="text/css" />
    <link href='//fonts.googleapis.com/css?family=Open+Sans:300,400' rel='stylesheet' type='text/css'>
    
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
    <script id="jqueryui" src="//ajax.googleapis.com/ajax/libs/jqueryui/1.8.10/jquery-ui.min.js" defer async></script>
    <script src="//www.google.com/jsapi"></script>
    <script type="text/javascript" src="//maps.googleapis.com/maps/api/js?sensor=false&libraries=places&amp;language=${pageContext.response.locale}"></script>
</head>

<body>
	<script src="js/facebook.js"></script>
   <!--start container-->
   <div id="container">

   <!--start header-->
   <header>

   <!--start logo-->
   <a href="#" id="logo"><img src="images/logo.png" width="221" height="84" alt="logo"/></a>    
   <!--end logo-->

   <!--start menu-->
   <nav>
   <ul>
   <li><a href="#" class="current">Home</a></li>
   <li><a href="#">About us</a></li>
   <li><a href="#">Services</a></li>
   <li><a href="#">Portfolio</a></li>
   <li><a href="#">News</a></li>
   <li><a href="#">Contact</a></li>
   </ul>
   </nav>
   <!--end menu-->

   <!--end header-->
   </header>

   <!--start intro-->

   <div id="intro">
   <!--  img src="images/banner1.png"  alt="baner"-->
   </div>
   <!--end intro-->

   <header class="group_bannner_left">
   <hgroup style="width: 940px;">
	   <h1>We serve fresh ideas</h1>
   </hgroup>
   <div class="button black"><a href="#">Read more about our fresh ideas</a></div>
   </header>

   <!--start holder-->

   <div class="holder_content">

   <section class="group1">
   
   <decorator:body/>
   
   <h3>Services</h3>
   	<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec molestie. Sed aliquam sem ut arcu. Phasellus sollicitudin. 
   Vestibulum condimentum  facilisis nulla. In hac habitasse platea dictumst. Nulla nonummy. Cras quis libero.</p>

   <article class="holder_gallery">
   <a class="photo_hover2" href="#"><img src="images/picture2.jpg" width="150" height="99" alt="picture1"/></a>
   <h2>Lorem ipsum</h2>
   <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec molestie. Sed aliquam sem ut arcu. Phasellus sollicitudin. 
   Vestibulum condimentum  facilisis nulla. In hac habitasse platea dictumst.
   </p> <span class="readmore"><a href="#">Read more..</a></span>
   </article>
    
   </section>

   <aside class="group2">
   
   <p style="text-align: center;">
		<a href="<c:url value='?lang=en'/>"><img src="images/english-icon.png"/></a> 
		<a href="<c:url value='?lang=pt_BR'/>"><img src="images/portuguese-icon.png"/></a>
	</p>
	
	<p style="margin-top: 20px;"><img src="images/facebook.png" height="45" alt="Facebook"/></p>
   
   <h3>Latest news</h3>

   <article class="holder_news">
   <h4>Lorem ipsum
   <span>10.09.2011</span></h4>
   <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec molestie. Sed aliquam sem ut arcu.<span class="readmore">
   <a href="#">Read more..</a></span></p>
   </article>

   <a class="photo_hover2" href="#"><img src="images/picture3.jpg" width="257" height="295" alt="picture"/></a>   </aside>

   <section class="group3">
   <h3>About us</h3>
   <a class="photo_hover2" href="#"><img src="images/picture1.jpg" width="200" height="97" alt="picture1"/></a>

   <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec molestie. Sed aliquam sem ut arcu. Phasellus sollicitudin. 
   Vestibulum condimentum facilisis nulla. In hac habitasse platea dictumst. Nulla nonummy. Cras quis libero.   </p>
   <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec molestie.<span class="readmore"> <a href="#">Read more..</a></span>
   </p>

    <h3>Testimonials</h3>
    <p>"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec molestie. Sed aliquam sem ut arcu. Phasellus sollicitudin. 
   Vestibulum condimentum facilisis nulla. In hac habitasse platea dictumst." - Lorem ipsum  </p>

   <p>"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec molestie. Sed aliquam sem ut arcu. Phasellus sollicitudin. 
   Vestibulum condimentum facilisis nulla. In hac habitasse platea dictumst." - Lorem ipsum  </p>

   </section>

   </div>
   <!--end holder-->

   </div>
   <!--end container-->

   <!--start footer-->
   <footer>
   <div class="container">
   <div id="FooterTwo"> © 2011 Fresh ideas </div>
   <div id="FooterTree"> Valid html5, css3, design and code by <a href="http://www.marijazaric.com">marija zaric</a></div> 
   </div>
   </footer>
   <!--end footer-->
   <!-- Free template distributed by http://freehtml5templates.com -->
   <!-- Flag's icons by http://www.icons-land.com from http://www.iconarchive.com/ -->
   <script type="text/javascript" src="js/maps.js"></script>   
   </body>
</html>
