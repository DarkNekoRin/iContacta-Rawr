<%@ include file="cabecera.jsp" %>

<div class="fixed-navbar">
	<div class="pull-left">
		<button type="button" class="menu-mobile-button glyphicon glyphicon-menu-hamburger js__menu_mobile"></button>
		<h1 class="page-title">iContacta</h1>
		<!-- /.page-title -->
	</div>
	<!-- /.pull-left -->
	<div class="pull-right">
		<div class="ico-item">
			<a href="#" class="ico-item mdi mdi-magnify js__toggle_open" data-target="#searchform-header"></a>
			<form action="#" id="searchform-header" class="searchform js__toggle"><input type="search" placeholder="Search..." class="input-search"><button class="mdi mdi-magnify button-search" type="submit"></button></form>
			<!-- /.searchform -->
		</div>
		
		<a href="#" class="ico-item mdi mdi-logout js__logout"></a>
	</div>
	<!-- /.pull-right -->
</div>
<!-- /.fixed-navbar -->


<div id="wrapper">
	<div class="main-content">
		
	<div class="alert alert-success">
	    <strong>¡¡¡Un Exito!!! </strong> Proceso Ejecutado Correctamente
	 </div>
		
		
		
		<footer class="footer">
			<ul class="list-inline">
				<li>2019 © Gobierno de Datos </li>
				<li> Interbank</li>
			</ul>
		</footer>
	</div>

</div>

<!--/#wrapper -->
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
		<script src="${contextPath}/assets/script/html5shiv.min.js"></script>
		<script src="${contextPath}/assets/script/respond.min.js"></script>
	<![endif]-->
	<!-- 
	================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="${contextPath}/assets/scripts/jquery.min.js"></script>
	<script src="${contextPath}/assets/scripts/modernizr.min.js"></script>
	<script src="${contextPath}/assets/plugin/bootstrap/js/bootstrap.min.js"></script>
	<script src="${contextPath}/assets/plugin/mCustomScrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
	<script src="${contextPath}/assets/plugin/nprogress/nprogress.js"></script>
	<script src="${contextPath}/assets/plugin/sweet-alert/sweetalert.min.js"></script>
	<script src="${contextPath}/assets/plugin/waves/waves.min.js"></script>

	<script src="${contextPath}/assets/scripts/main.js"></script>
</body>
</html>