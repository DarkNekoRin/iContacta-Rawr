<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>iContacta - Creación de Cuenta</title>


	<link href="${contextPath}/resources/css/register.css" rel="stylesheet">
	
	
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body class="demo-layout-transparent">



		<div class="wrapper" >
			<div class="inner" >
				<div class="image-holder">
					<img src="${contextPath}/resources/img/lol.PNG" alt="">
				</div>
				
				
				<form:form method="POST" modelAttribute="userForm" class="form-signin">
					<h3 class="logintxt">Creación de Cuenta</h3>

					<div class="form-wrapper">

				        <spring:bind path="username">
				            <div class="form-group ${status.error ? 'has-error' : ''}">
				                <form:input type="text" path="username" class="form-control" placeholder="Registro"
				                            autofocus="true"></form:input>
				                <form:errors path="username"></form:errors>
				            </div>
				        </spring:bind>
				        				        
					</div>
					
					<div class="form-wrapper">

				        <spring:bind path="nombres">
				            <div class="form-group ${status.error ? 'has-error' : ''}">
				                <form:input type="text" path="nombres" class="form-control" placeholder="Nombres"
				                            autofocus="true"></form:input>
				                <form:errors path="nombres"></form:errors>
				            </div>
				        </spring:bind>
				        				        
					</div>
					<div class="form-wrapper">

				        <spring:bind path="apePaterno">
				            <div class="form-group ${status.error ? 'has-error' : ''}">
				                <form:input type="text" path="apePaterno" class="form-control" placeholder="Apellido Paterno"
				                            autofocus="true"></form:input>
				                <form:errors path="apePaterno"></form:errors>
				            </div>
				        </spring:bind>
				        				        
					</div>
					<div class="form-wrapper">

				        <spring:bind path="apeMaterno">
				            <div class="form-group ${status.error ? 'has-error' : ''}">
				                <form:input type="text" path="apeMaterno" class="form-control" placeholder="Apellido Materno"
				                            autofocus="true"></form:input>
				                <form:errors path="apeMaterno"></form:errors>
				            </div>
				        </spring:bind>
				        				        
					</div>

                    
					<button  type="submit" >Registrar </button>
					<br>
					 <p class="message">Ya tienes una <a href="login"> cuenta</a></p> 
				</form:form>
			</div>
		</div>
		
		


</body>
</html>
