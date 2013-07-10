<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"			prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" 		prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 	prefix="form"%>
<!doctype html>
<html lang="en">
<head>
	
</head>
<body>
	<div id="main">
		<h3><spring:message code="about"/></h3>	
		<p>
			Veggie Out sua ferramenta para busca de restaurantes Vegetarianos e Veganos.
			Compartilhe e avalie opções para comer para pessoas como você e ajude para que novas opções sejam descobertas.
		</p>
		<p>
			Possui sugestões para melhorar a ferramenta? Entre em contato conosco pelo formulário de <a href="contact">contato</a>.
		</p>
		<ul class=" aboutList">
			<li>Acesse com sua conta do Facebook</li>
			<li>Compartilhe sua opnião sobre os locais</li>
			<li>Compartilhe fotos</li>
			<li>Pesquise pelos locais próximos</li>
		</ul>
		<br/>
		<div class="fb-comments" data-href="http://veggie-out.herokuapp.com" data-width="640" data-num-posts="10"></div>
		
		<!--div onclick="share();" id="share"><p><spring:message code="share"/></p></div-->

		<script type="text/javascript">
			function share() {
				window.open(
			      'https://www.facebook.com/sharer/sharer.php?u='+encodeURIComponent(location.href), 
			      'facebook-share-dialog', 
			      'width=626,height=436'); 
				 return false;
			}
		</script>
	</div>
</body>
</html>