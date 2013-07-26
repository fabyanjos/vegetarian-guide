<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div id="loadingMessage" style="display:none;"> 
    <strong><img src="/images/loading.gif">&nbsp;Loading</strong> 
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