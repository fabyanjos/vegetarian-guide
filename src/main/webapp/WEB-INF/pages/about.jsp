<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"			prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" 		prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 	prefix="form"%>
<!doctype html>
<html lang="en">
<head>
	<title><spring:message code="about"/></title>
	<meta name="keywords" content="<spring:message code="meta.keywords"/>">
	<meta name="description" content="<spring:message code="meta.description"/>, <spring:message code="about"/>">
</head>
<body>
	<h2><spring:message code="about.us"/></h2>
	<section>
		<article>
			<p>
				Veggie Out sua ferramenta para busca de restaurantes Vegetarianos e Veganos.
				Compartilhe e avalie opções para comer com outras pessoas e ajude para que novas opções sejam descobertas.
			</p>
			<p>
				Possui sugestões para melhorar a ferramenta? Entre em contato conosco pelo <a href="contact">formulário</a>.
			</p>
			<ul class="arrow-list">
				<li>Pesquisa simples por endereço</li>
				<li>Filtros simples de usar</li>
				<li>Acesse com sua conta do Facebook ou Google</li>
				<li>Compartilhe sua opnião sobre os locais</li>
				<li>Compartilhe fotos</li>
				<li>Em breve versão mobile, leve seu guia no bolso</li>
			</ul>
		</article>
	</section>
	
	<div class="fb-comments" data-href="http://veggie-out.herokuapp.com" data-width="660" data-num-posts="10"></div>
		
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
	
	
	

</body>
</html>