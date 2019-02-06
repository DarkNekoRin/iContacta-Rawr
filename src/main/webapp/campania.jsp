<%@ include file="cabecera.jsp" %>

<div class="fixed-navbar">
	<div class="pull-left">
		<button type="button" class="menu-mobile-button glyphicon glyphicon-menu-hamburger js__menu_mobile"></button>
		<h1 class="page-title">Campania</h1>
		<!-- /.page-title -->
	</div>
	<!-- /.pull-left -->
	<div class="pull-right">
		<div class="ico-item">
			<a href="#" class="ico-item mdi mdi-magnify js__toggle_open" data-target="#searchform-header"></a>
			<form action="#" id="searchform-header" class="searchform js__toggle"><input type="search" placeholder="Busqueda..." class="input-search"><button class="mdi mdi-magnify button-search" type="submit"></button></form>
			<!-- /.searchform -->
		</div>
		<!-- /.ico-item -->
		
		<a href="#" class="ico-item mdi mdi-logout js__logout"></a>
	</div>
	<!-- /.pull-right -->
</div>
<!-- /.fixed-navbar -->


<div id="wrapper">
	<div class="main-content">
		<div class="row small-spacing" id="divTblOutput">			
			<div class="col-xs-12" >
		 		<h3 class="box-title">Campa&ntilde;a</h3>
					</br>
    								
				<div class="box-content">
					<h4 class="box-title" id="idTituloGrilla"></h4>
			
					<a class='aLink' href="#"><i class="fa fa-file-excel-o" aria-hidden="true"></i> Exportar </a>
						
					<!-- /.box-title -->

					
					
					<!-- /.dropdown js__dropdown -->
					<table id="tblOutput" class="table table-striped table-bordered displa" style="width:100%">
						<thead>
							<tr>
								<th>Formulario</th>
								<th>Codigo FB</th>
								<th>DNI</th>
								<th>Fecha</th>
							</tr>
						</thead>
					</table>
				</div>
				<!-- /.box-content -->
			</div>
			<!-- /.col-xs-12 -->
		</div>

		<!-- /.row small-spacing -->		
		
		<footer class="footer">
			<ul class="list-inline">
				<li>2019 � Gobierno de Datos </li>
				<li> Interbank</li>
			</ul>
		</footer>
		
		
	</div>
	<!-- /.main-content -->
</div><!--/#wrapper -->
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

	<!-- Dropify -->
	<script src="${contextPath}/assets/plugin/dropify/js/dropify.min.js"></script>
	<script src="${contextPath}/assets/scripts/fileUpload.demo.min.js"></script>


	<!-- Toastr -->
	<script src="${contextPath}/assets/plugin/toastr/toastr.min.js"></script>
	<script src="${contextPath}/assets/scripts/toastr.demo.min.js"></script>

	<script src="${contextPath}/assets/scripts/main.js"></script>
	
	<!-- Data Tables -->
	<script src="${contextPath}/assets/plugin/datatables/media/js/jquery.dataTables.min.js"></script>
	
	<script src="${contextPath}/resources/js/campania.js"></script>
</body>
</html>