<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"			prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" 		prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 	prefix="form"%>
<!doctype html>
<html lang="en">
<head>
<script type="text/javascript" src="http://connect.facebook.net/en_US/all.js"></script>
</head>

<body>
		<div class="error">
			Your login attempt was not successful, try again.<br /> Caused :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
    <form method="post" action="<c:url value='j_spring_security_check' />" id="loginForm">
    	<fieldset id="place">
			<ul>
				<li>
		  			<label>j_username: <span class="mandatory">*</span> </label>
					<input type="text" id="j_username" name="j_username"/>
				</li>
				
				<li>
		  			<label>j_password: <span class="mandatory">*</span> </label>
					<input type="password" id="j_password" name="j_password"/>
				</li>
				
				<li>
		  			<label>_spring_security_remember_me: </label>
					<input type="checkbox" id="_spring_security_remember_me" name="_spring_security_remember_me"/>
				</li>
				
				<li>
					<input type="submit" value="login"/>
				</li>
			</ul>
		</fieldset>
		<p style="margin-top: 20px; cursor: pointer;" onclick="login();"><img src="/images/facebook.png" height="45" alt="Facebook"/></p>
	</form>
	<fb:facepile href="http://localhost:8080" 
action="og_recipebox:planning_to_make" width="300" max_rows="1"></fb:facepile>
	<fb:registration redirect-uri="http://localhost:8080/user/login/facebook"
	  fields='[
   			{"name":"name"},
   			{"name":"birthday"},
   			{"name":"location"},
   			{"name":"email"}
   			]' 
	  
	  width="600">
	</fb:registration>
</body>
</html>