<%@ include file="cabecera.jsp" %>

<div class="fixed-navbar">
	<div class="pull-left">
		<button type="button" class="menu-mobile-button glyphicon glyphicon-menu-hamburger js__menu_mobile"></button>
		<h1 class="page-title">Carga de Datos</h1>
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
		<div class="row small-spacing" id="divFormulario">
			<!-- /.col-xs-12 -->
  				<form data-toggle="validator" id="fileUploadForm" method="POST" action="/upload?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data">  
    			
   
    			<div class="col-md-12 ">
    			 			<h3 class="box-title">Enriquecimiento de Datos </h3>
    								</br>
		    		<div class="col-md-8 col-xs-12">						
						<div class="box-content">
		
							<h5 >Subir Archivo</h5>
							<input type="hidden" id="idSolicitud" name="idSolicitud"/>
							
							<!-- /.dropdown js__dropdown -->
							<input type="file" name="file" id="input-file-to-destroy" class="dropify" data-allowed-formats="portrait square" data-max-file-size="2M" data-max-height="2000" required/>
		                    <p class="help margin-top-10">Se acepta dos campos <b>Tipdoc y CodDoc.</b> </br> 
		                     El formato debe ser delimitado por <b>comas</b>.	
		                    </br> El peso máximo es de 2M. </p>
							</br> 
						<!-- /.dropdown js__dropdown -->
						
						
									<h5 >Datos Necesarios</h5>		
						<div class="box-content">
						
							<div class="switch success"><input type="checkbox" name="telefono" id="switch-1"><label for="switch-1">Tel&eacute;fono</label></div>
							<!-- /.switch -->
							<div class="switch success"><input type="checkbox" name="email" id="switch-2"><label for="switch-2">Email</label></div>
							<!-- /.switch -->
							<div class="switch success"><input type="checkbox" name="direccion" id="switch-3"><label for="switch-3">Direcci&oacute;n</label></div>
							<!-- /.box-content -->
							
						</div>	
						
					
						
						</div>
												
						<button type="button" id="procesar" class="btnForm btncolor">Procesar</button>
						</br> 
					</div>
					
				</div>
		</form>			<!-- /.col-md-6 col-xs-12 -->
		</div>
		
		<div class="row small-spacing" id="divTblOutput">			
			<div class="col-xs-12" >
		 		<h3 class="box-title">Enrequecimiento de Datos </h3>
					</br>
    								
				<div class="box-content">
					<h4 class="box-title" id="idTituloGrilla"></h4>
			
					<a class='aLink' href="#"><i class="fa fa-file-excel-o" aria-hidden="true"></i> Exportar </a>
						
					<!-- /.box-title -->

					
					
					<!-- /.dropdown js__dropdown -->
					<table id="tblOutput" class="table table-striped table-bordered displa" style="width:100%">
						<thead>
							<tr>
								<th>Tipo Doc</th>
								<th>Documento</th>
								<th>Nombres</th>
								<th>1° Número Cel</th>													
								<th>Número Telefono</th>
								<th>1° Email</th>								
								<th>Dirección</th>
								<th>Distrito</th>
								<th>Provincia</th>
								<th>Departamento</th>
								<th>LPDP</th>
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
				<li>2019 © Gobierno de Datos </li>
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
	
	<script src="${contextPath}/resources/js/subirarchivo.js"></script>
</body>
</html>