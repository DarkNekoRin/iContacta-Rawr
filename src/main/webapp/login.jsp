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
    
    <title>Data Enrichment - Login </title>
    
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Log in with your account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/login.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/materialize.css" rel="stylesheet">
    
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
</head>

<body class= 'demo-layout-transparent'>
	
	<div >
	
	<div class="page">
	  <div class="container">
	    <div class="left">
	      <div class="logintxt">Data Enrichment </div>
	        
	        <div class="eula">¡Agregar datos de contacto segun las politicas del banco nunca fue más fácil! </div>
	         
	
	        
	    </div>
	    <div class="right">
	
	      <div class="formfeo">

            <div class="logintxt_bl">Log In </div>

	
	          <!-- LOGIN-->
	
	
	<div class="form">
          
            
            <form method="POST" action="${contextPath}/login"  class="login-form">

             <div class="form-group ${error != null ? 'has-error' : ''}">
	             <span>${message}</span>
	             
	              <input  name="username"  type="text"  class="form-control" placeholder="Username"/>
	              <input name="password"  type="password" class="form-control"  placeholder="Password"/>
	              <span>${error}</span>
	              <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	              <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
	             
              </div>
            
				 <p class="message">¿No tienes cuenta? <a href="/registration">Crea tu cuenta</a></p> 
            </form>
    </div>
          
	          	          <!-- -->
	          
	      </div>
	        
	    </div>
	  </div>
	</div>

    <!-- Form  -->
        <div class="login-page">
          
        </div>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

    
<script> 
    $('.message a').click(function(){
   $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
});
</script>

</body>
</html>
