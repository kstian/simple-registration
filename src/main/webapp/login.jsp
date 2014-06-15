<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<script src="/js/jquery-1.8.2.min.js" type="text/javascript"></script>
<script src="/js/jquery.validationEngine-en.js" type="text/javascript"></script>
<script src="/js/jquery.validationEngine.js" type="text/javascript"></script>
<link rel="stylesheet" href="/css/validationEngine.jquery.css"	type="text/css" />
<link rel="stylesheet" href="/css/style.css" type="text/css" />
</head>
<script type="text/javascript">
	$(document).ready(function() {
		$("#registerForm").validationEngine("attach");			
	});
	
</script>
<body>
<div class="page-wrap">
	<div id="registerBox" class="login">
		<form id="registerForm" action="/register.html" name="registerForm" method="post" >
			<h1 id="message">Login</h1><br /> 
			<input class="validate[required]" type="text" name="username" placeholder="Username"/><br />
			<input class="validate[required]" type="password" name="password" placeholder="*********" /><br /> 
			<input class="button" type="submit" value="Login" id="registerButton"/>
		</form>
	</div>
	</div>
	<div id="footer">
		<s:include value="/commons/footer.jsp"></s:include>
	</div>
	
</body>
</html>