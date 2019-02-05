<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<title>iContacta - Creación Éxitosa</title>
	
	<link href="${contextPath}/resources/css/register.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/materialize.css" rel="stylesheet">
    	<!-- IBK Themes -->
	<link rel="stylesheet" href="${contextPath}/resources/css/ibk-new.css">
	
	
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body  class="demo-layout-transparent">


	<div class="wrapper" >
			<div class="inner" >
				<div class="image-holder">
					<img src="${contextPath}/resources/img/lol.PNG" alt="">
				</div>
				
				<form class="class="form-signin" > 
					<h3 class="logintxt">${titulo} ${username} </h3>
					
					<div class="form-wrapper">
											
						<p>Muchas gracias por registrarte, muy pronto será activado tu usuario </p>
						<br>
						<p> Por favor comuniquese con nosotros, para acelerar el proceso. </p>
						<br>
					</div>
                    
					<a href="/login" class="btn apachurrame">Regresar</a>
					
					
				</form>
				
			</div>
		</div>
		
		


</body>
</html>