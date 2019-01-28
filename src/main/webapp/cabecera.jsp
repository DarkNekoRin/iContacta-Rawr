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

	<title>iContacta - Interbank</title>

	<!-- Main Styles -->
	<link rel="stylesheet" href="${contextPath}/assets/styles/style.css">
	
	<!-- Material Design Icon -->
	<link rel="stylesheet" href="${contextPath}/assets/fonts/material-design/css/materialdesignicons.css">

	<!-- mCustomScrollbar -->
	<link rel="stylesheet" href="${contextPath}/assets/plugin/mCustomScrollbar/jquery.mCustomScrollbar.min.css">

	<!-- Waves Effect -->
	<link rel="stylesheet" href="${contextPath}/assets/plugin/waves/waves.min.css">

	<!-- Sweet Alert -->
	<link rel="stylesheet" href="${contextPath}/assets/plugin/sweet-alert/sweetalert.css">
	
	
	<!-- Dropify -->
	<link rel="stylesheet" href="${contextPath}/assets/plugin/dropify/css/dropify.min.css">

	<!-- Data Tables -->
	<link rel="stylesheet" href="${contextPath}/assets/plugin/datatables/media/css/jquery.dataTables.css">
	
	<!-- IBK Themes -->
	<link rel="stylesheet" href="${contextPath}/resources/css/ibk-new.css">
	
	
		<!-- Toastr -->
	<link rel="stylesheet" href="${contextPath}/assets/plugin/toastr/toastr.css">
</head>

<body>
<div class="main-menu">
	<header class="header">
		<a href="index.html" class="logo"><i class="ico mdi mdi-cube-outline"></i> iContacta Interbank</a>
		
		<button type="button" class="button-close fa fa-times js__menu_close"></button>
		
		<div class="user">
		
			<a href="#" class="avatar">
				<!--  img src="${contextPath}/resources/img/rawr.png " alt="" -->
				<img src="${contextPath}/resources/img/rawr.png " alt="">
				<span class="status online"></span></a>
			
			<h5 class="name">
				<a href="#">${pageContext.request.userPrincipal.name}</a>
			</h5>
			
			<c:if test="${pageContext.request.userPrincipal.name != null}">
		        <form id="logoutForm" method="POST" action="${contextPath}/logout">
		            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		        </form>        
		    </c:if>
			
			<h5 class="position">Interbank</h5>
			<!-- /.name -->
			<div class="control-wrap js__drop_down">
				<i class="fa fa-caret-down js__drop_down_button"></i>
				<div class="control-list">
					<div class="control-item"><a href="#"><i class="fa fa-user"></i> Perfil</a></div>
					<div class="control-item "><a href="#" class="js__logout" ><i class="fa fa-sign-out "></i> Log out
									
					</a></div>
				</div>
				<!-- /.control-list -->
			</div>
			<!-- /.control-wrap -->
		
		
		</div>
		<!-- /.user -->
	</header>
	<!-- /.header -->
	<div class="content">

		<div class="navigation">
			<h5 class="title">Panel Navegación</h5>
			<!-- /.title -->
			<ul class="menu js__accordion">
				<li>
					<a class="waves-effect" href="welcome"><i class="menu-icon mdi mdi-account-star-variant"></i><span> Enrequecimiento </span> <span class="notice notice-danger">New</span></a>
				</li>


			</ul>
		</div>
		<!-- /.navigation -->
	</div>
	<!-- /.content -->
</div>
<!-- /.main-menu -->