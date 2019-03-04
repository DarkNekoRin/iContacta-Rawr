<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<title>Felicitaciones</title>
	
	<link rel="stylesheet" href="${contextPath}/assets/styles/style-ibk.css">

	<!-- Waves Effect -->
	<link rel="stylesheet" href="${contextPath}/assets/plugin/waves/waves.min.css">

	<!-- IBK Themes -->
	<link rel="stylesheet" href="${contextPath}/resources/css/ibk-new.css">
	
	
</head>

<body>
<div id="page-solicitud">
	<div class="content">
		<div class="title-on-desktop">
			<svg style="width: 600px; height: 200px" alignment-baseline="middle">
				<defs>
					<clipPath id="clip2">
						<path d="M 0 0 L 600 0 L 600 80 L 0 80 L 0 0 L 0 125 L 600 125 L 600 200 L 0 200 Z" />
					</clipPath>
				</defs>
				<text x="300" y="190" style="width: 600px; height: 200px" text-anchor="middle" font-family="Omnes-Regular" font-weight="700" font-size="250" fill="#505458" clip-path="url(#clip2)">4<tspan fill="#00AA4A">0</tspan>4</text>
			</svg>
			<div class="title">${titulo} ${username}</div>
		</div>
		<h1 class="title-on-mobile"></h1>
		<p>Muy Pronto será activado su cuentaPor favor espere. </p>
		<a href="/login" class="btn btn-info">Regresar</a>
		
	</div>
</div><!--/#single-wrapper -->

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
		<script src="assets/script/html5shiv.min.js"></script>
		<script src="assets/script/respond.min.js"></script>
	<![endif]-->
	<!-- 
	================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="assets/scripts/jquery.min.js"></script>
	<script src="assets/scripts/modernizr.min.js"></script>
	<script src="assets/plugin/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/plugin/nprogress/nprogress.js"></script>
	<script src="assets/plugin/waves/waves.min.js"></script>

	<script src="assets/scripts/main.min.js"></script>
</body>
</html>