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

	<title>Multiple File Upload - My Admin Template</title>

	<!-- Main Styles -->
	<link rel="stylesheet" href="${contextPath}/assets/styles/style.min.css">
	
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

	<!-- Dark Themes -->
	<link rel="stylesheet" href="${contextPath}/assets/styles/style-dark.min.css">
</head>

<body>
<div class="main-menu">
	<header class="header">
		<a href="index.html" class="logo"><i class="ico mdi mdi-cube-outline"></i>Rawr</a>
		<button type="button" class="button-close fa fa-times js__menu_close"></button>
		<div class="user">
			<a href="#" class="avatar"><img src="${contextPath}/assets/images/avatar-sm-5.jpg" alt=""><span class="status online"></span></a>
			<h5 class="name">
				<a href="profile.html">${pageContext.request.userPrincipal.name}</a>
			</h5>
			<c:if test="${pageContext.request.userPrincipal.name != null}">
		        <form id="logoutForm" method="POST" action="${contextPath}/logout">
		            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		        </form>        
		    </c:if>
			
			<h5 class="position">Administrator</h5>
			<!-- /.name -->
			<div class="control-wrap js__drop_down">
				<i class="fa fa-caret-down js__drop_down_button"></i>
				<div class="control-list">
					<div class="control-item"><a href="profile.html"><i class="fa fa-user"></i> Profile</a></div>
					<div class="control-item"><a href="#"><i class="fa fa-gear"></i> Settings</a></div>
					<div class="control-item"><a href="#"><i class="fa fa-sign-out"></i> Log out</a></div>
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
			<h5 class="title">Navigation</h5>
			<!-- /.title -->
			<ul class="menu js__accordion">
				<li>
					<a class="waves-effect" href="welcome"><i class="menu-icon mdi mdi-view-dashboard"></i><span>CargaArchivo</span></a>
				</li>
				<li>
					<a class="waves-effect parent-item js__control" href="#"><i class="menu-icon mdi mdi-desktop-mac"></i><span>User Interface</span><span class="menu-arrow fa fa-angle-down"></span></a>
					<ul class="sub-menu js__content">
						<li><a href="ui-buttons.html">Buttons</a></li>
						<li><a href="ui-cards.html">Cards</a></li>
						<li><a href="ui-checkbox-radio.html">Checkboxs-Radios</a></li>
						<li><a href="ui-components.html">Components</a></li>
						<li><a href="ui-draggable-cards.html">Draggable Cards</a></li>
						<li><a href="ui-modals.html">Modals</a></li>
						<li><a href="ui-typography.html">Typography</a></li>
					</ul>
					<!-- /.sub-menu js__content -->
				</li>
				<li>
					<a class="waves-effect parent-item js__control" href="#"><i class="menu-icon mdi mdi-cube-outline"></i><span>Admin UI</span><span class="menu-arrow fa fa-angle-down"></span></a>
					<ul class="sub-menu js__content">
						<li><a href="ui-notification.html">Notification</a></li>
						<li><a href="profile.html">Profile</a></li>
						<li><a href="ui-range-slider.html">Range Slider</a></li>
						<li><a href="ui-sweetalert.html">Sweet Alert</a></li>
						<li><a href="ui-treeview.html">Tree view</a></li>
						<li><a href="widgets.html">Widget</a></li>
					</ul>
					<!-- /.sub-menu js__content -->
				</li>
				<li>
					<a class="waves-effect" href="calendar.html"><i class="menu-icon mdi mdi-calendar"></i><span>Calendar</span></a>
				</li>
				<li>
					<a class="waves-effect parent-item js__control" href="#"><i class="menu-icon mdi mdi-fire"></i><span>Icons</span><span class="menu-arrow fa fa-angle-down"></span></a>
					<ul class="sub-menu js__content">
						<li><a href="icons-font-awesome-icons.html">Font Awesome</a></li>
						<li><a href="icons-fontello.html">Fontello</a></li>
						<li><a href="icons-material-icons.html">Material Design Icons</a></li>
						<li><a href="icons-material-design-iconic.html">Material Design Iconic Font</a></li>
						<li><a href="icons-themify-icons.html">Themify Icons</a></li>
					</ul>
					<!-- /.sub-menu js__content -->
				</li>
				<li>
					<a class="waves-effect" href="inbox.html"><i class="menu-icon mdi mdi-email"></i><span>Mail</span><span class="notice notice-danger">New</span></a>
				</li>
			</ul>
		</div>
		<!-- /.navigation -->
	</div>
	<!-- /.content -->
</div>
<!-- /.main-menu -->