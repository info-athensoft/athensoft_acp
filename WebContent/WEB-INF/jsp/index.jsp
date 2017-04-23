<%@ page contentType="text/html; charset=utf-8" %>
<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- global variables settings -->
<c:set var="webapp_name" value="/acp"/>


<!-- page variables  -->
<c:set var="inc_dir" value="inc"/>
<!-- ENDS page variables -->

<!DOCTYPE html>
<!-- 
Template Name: Metronic - Responsive Admin Dashboard Template build with Twitter Bootstrap 3.3.4
Version: 3.8.1
Author: KeenThemes
Website: http://www.keenthemes.com/
Contact: support@keenthemes.com
Follow: www.twitter.com/keenthemes
Like: www.facebook.com/keenthemes
Purchase: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
License: You must have a valid license purchased only from themeforest(the above link) in order to legally use the theme for your project.
-->
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8"/>
<title>INF. Athensoft | ACP</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1" name="viewport"/>
<meta content="" name="description"/>
<meta content="" name="author"/>
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css"/>
<link href="${webapp_name}/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<link href="${webapp_name}/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
<link href="${webapp_name}/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="${webapp_name}/assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
<link href="${webapp_name}/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css"/>
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL PLUGIN STYLES -->
<link href="${webapp_name}/assets/global/plugins/bootstrap-daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css"/>
<link href="${webapp_name}/assets/global/plugins/fullcalendar/fullcalendar.min.css" rel="stylesheet" type="text/css"/>
<link href="${webapp_name}/assets/global/plugins/jqvmap/jqvmap/jqvmap.css" rel="stylesheet" type="text/css"/>
<!-- END PAGE LEVEL PLUGIN STYLES -->
<!-- BEGIN PAGE STYLES -->
<link href="${webapp_name}/assets/admin/pages/css/tasks.css" rel="stylesheet" type="text/css"/>
<!-- END PAGE STYLES -->
<!-- BEGIN THEME STYLES -->
<!-- DOC: To use 'rounded corners' style just load 'components-rounded.css' stylesheet instead of 'components.css' in the below style tag -->
<link href="${webapp_name}/assets/global/css/components.css" id="style_components" rel="stylesheet" type="text/css"/>
<link href="${webapp_name}/assets/global/css/plugins.css" rel="stylesheet" type="text/css"/>
<link href="${webapp_name}/assets/admin/layout2/css/layout.css" rel="stylesheet" type="text/css"/>
<link href="${webapp_name}/assets/admin/layout2/css/themes/grey.css" rel="stylesheet" type="text/css" id="style_color"/>
<link href="${webapp_name}/assets/admin/layout2/css/custom.css" rel="stylesheet" type="text/css"/>
<!-- END THEME STYLES -->
<link rel="shortcut icon" href="favicon.ico"/>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<!-- DOC: Apply "page-header-fixed-mobile" and "page-footer-fixed-mobile" class to body element to force fixed header or footer in mobile devices -->
<!-- DOC: Apply "page-sidebar-closed" class to the body and "page-sidebar-menu-closed" class to the sidebar menu element to hide the sidebar by default -->
<!-- DOC: Apply "page-sidebar-hide" class to the body to make the sidebar completely hidden on toggle -->
<!-- DOC: Apply "page-sidebar-closed-hide-logo" class to the body element to make the logo hidden on sidebar toggle -->
<!-- DOC: Apply "page-sidebar-hide" class to body element to completely hide the sidebar on sidebar toggle -->
<!-- DOC: Apply "page-sidebar-fixed" class to have fixed sidebar -->
<!-- DOC: Apply "page-footer-fixed" class to the body element to have fixed footer -->
<!-- DOC: Apply "page-sidebar-reversed" class to put the sidebar on the right side -->
<!-- DOC: Apply "page-full-width" class to the body element to have full width page without the sidebar menu -->
<body class="page-boxed page-header-fixed page-sidebar-closed-hide-logo page-container-bg-solid page-sidebar-closed-hide-logo">

<!-- BEGIN HEADER -->
<div class="page-header navbar navbar-fixed-top">
	<!-- BEGIN HEADER INNER -->
	<div class="page-header-inner container">
		<!-- BEGIN LOGO -->
			<jsp:include page="${inc_dir}/page-logo.jsp"></jsp:include>
		<!-- END LOGO -->
		<!-- BEGIN RESPONSIVE MENU TOGGLER -->
		<a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse">
		</a>
		<!-- END RESPONSIVE MENU TOGGLER -->
		<!-- BEGIN PAGE ACTIONS -->
		<!-- DOC: Remove "hide" class to enable the page header actions -->
			<jsp:include page="${inc_dir}/page-action.jsp"></jsp:include>
		<!-- END PAGE ACTIONS -->
		<!-- BEGIN PAGE TOP -->
			<jsp:include page="${inc_dir}/page-top.jsp"></jsp:include>
		<!-- END PAGE TOP -->
	</div>
	<!-- END HEADER INNER -->
</div>
<!-- END HEADER -->
<div class="clearfix">
</div>
<!-- BEGIN CONTAINER -->
<div class="container">
	<div class="page-container">
		<!-- BEGIN SIDEBAR -->
			<jsp:include page="${inc_dir}/page-sidebar.jsp"></jsp:include>
		<!-- END SIDEBAR -->
		<!-- BEGIN CONTENT -->
		<div class="page-content-wrapper">
			<div class="page-content">
				<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
				<div class="modal fade" id="portlet-config" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
								<h4 class="modal-title">Modal title</h4>
							</div>
							<div class="modal-body">
								 Widget settings form goes here
							</div>
							<div class="modal-footer">
								<button type="button" class="btn blue">Save changes</button>
								<button type="button" class="btn default" data-dismiss="modal">Close</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<!-- /.modal -->
				<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
				<!-- BEGIN STYLE CUSTOMIZER -->
				<div class="theme-panel">
					<div class="toggler tooltips" data-container="body" data-placement="left" data-html="true" data-original-title="Click to open advance theme customizer panel">
						<i class="icon-settings"></i>
					</div>
					<div class="toggler-close">
						<i class="icon-close"></i>
					</div>
					<div class="theme-options">
						<div class="theme-option theme-colors clearfix">
							<span>
							THEME COLOR </span>
							<ul>
								<li class="color-default current tooltips" data-style="default" data-container="body" data-original-title="Default">
								</li>
								<li class="color-grey tooltips" data-style="grey" data-container="body" data-original-title="Grey">
								</li>
								<li class="color-blue tooltips" data-style="blue" data-container="body" data-original-title="Blue">
								</li>
								<li class="color-dark tooltips" data-style="dark" data-container="body" data-original-title="Dark">
								</li>
								<li class="color-light tooltips" data-style="light" data-container="body" data-original-title="Light">
								</li>
							</ul>
						</div>
						<div class="theme-option">
							<span>
							Theme Style </span>
							<select class="layout-style-option form-control input-small">
								<option value="square" selected="selected">Square corners</option>
								<option value="rounded">Rounded corners</option>
							</select>
						</div>
						<div class="theme-option">
							<span>
							Layout </span>
							<select class="layout-option form-control input-small">
								<option value="fluid" selected="selected">Fluid</option>
								<option value="boxed">Boxed</option>
							</select>
						</div>
						<div class="theme-option">
							<span>
							Header </span>
							<select class="page-header-option form-control input-small">
								<option value="fixed" selected="selected">Fixed</option>
								<option value="default">Default</option>
							</select>
						</div>
						<div class="theme-option">
							<span>
							Top Dropdown</span>
							<select class="page-header-top-dropdown-style-option form-control input-small">
								<option value="light" selected="selected">Light</option>
								<option value="dark">Dark</option>
							</select>
						</div>
						<div class="theme-option">
							<span>
							Sidebar Mode</span>
							<select class="sidebar-option form-control input-small">
								<option value="fixed">Fixed</option>
								<option value="default" selected="selected">Default</option>
							</select>
						</div>
						<div class="theme-option">
							<span>
							Sidebar Style</span>
							<select class="sidebar-style-option form-control input-small">
								<option value="default" selected="selected">Default</option>
								<option value="compact">Compact</option>
							</select>
						</div>
						<div class="theme-option">
							<span>
							Sidebar Menu </span>
							<select class="sidebar-menu-option form-control input-small">
								<option value="accordion" selected="selected">Accordion</option>
								<option value="hover">Hover</option>
							</select>
						</div>
						<div class="theme-option">
							<span>
							Sidebar Position </span>
							<select class="sidebar-pos-option form-control input-small">
								<option value="left" selected="selected">Left</option>
								<option value="right">Right</option>
							</select>
						</div>
						<div class="theme-option">
							<span>
							Footer </span>
							<select class="page-footer-option form-control input-small">
								<option value="fixed">Fixed</option>
								<option value="default" selected="selected">Default</option>
							</select>
						</div>
					</div>
				</div>
				<!-- END STYLE CUSTOMIZER -->
				<!-- BEGIN PAGE HEADER-->
				<h3 class="page-title">
				Dashboard</h3>
				<div class="page-bar">
					<ul class="page-breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="index.html">Home</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="#">Dashboard</a>
						</li>
					</ul>
					<div class="page-toolbar">
						<div id="dashboard-report-range" class="tooltips btn btn-fit-height btn-sm green-haze btn-dashboard-daterange" data-container="body" data-placement="left" data-original-title="Change dashboard date range">
							<i class="icon-calendar"></i>
							&nbsp;&nbsp; <i class="fa fa-angle-down"></i>
							<!-- uncomment this to display selected daterange in the button 
&nbsp; <span class="thin uppercase visible-lg-inline-block"></span>&nbsp;
<i class="fa fa-angle-down"></i>
 -->
						</div>
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<!-- BEGIN DASHBOARD STATS -->
				<div class="row">
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<a class="dashboard-stat dashboard-stat-light blue-soft" href="javascript:;">
						<div class="visual">
							<i class="fa fa-comments"></i>
						</div>
						<div class="details">
							<div class="number">
								 1349
							</div>
							<div class="desc">
								 New Feedbacks
							</div>
						</div>
						</a>
					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<a class="dashboard-stat dashboard-stat-light red-soft" href="javascript:;">
						<div class="visual">
							<i class="fa fa-trophy"></i>
						</div>
						<div class="details">
							<div class="number">
								 12,5M$
							</div>
							<div class="desc">
								 Total Profit
							</div>
						</div>
						</a>
					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<a class="dashboard-stat dashboard-stat-light green-soft" href="javascript:;">
						<div class="visual">
							<i class="fa fa-shopping-cart"></i>
						</div>
						<div class="details">
							<div class="number">
								 549
							</div>
							<div class="desc">
								 New Orders
							</div>
						</div>
						</a>
					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<a class="dashboard-stat dashboard-stat-light purple-soft" href="javascript:;">
						<div class="visual">
							<i class="fa fa-globe"></i>
						</div>
						<div class="details">
							<div class="number">
								 +89%
							</div>
							<div class="desc">
								 Brand Popularity
							</div>
						</div>
						</a>
					</div>
				</div>
				<!-- END DASHBOARD STATS -->
				<div class="clearfix">
				</div>
				<div class="row">
					<div class="col-md-6 col-sm-6">
						<!-- BEGIN PORTLET-->
						<div class="portlet light ">
							<div class="portlet-title">
								<div class="caption">
									<i class="icon-bar-chart font-green-sharp hide"></i>
									<span class="caption-subject font-green-sharp bold uppercase">Site Visits</span>
									<span class="caption-helper">weekly stats...</span>
								</div>
								<div class="actions">
									<div class="btn-group btn-group-devided" data-toggle="buttons">
										<label class="btn btn-transparent grey-salsa btn-circle btn-sm active">
										<input type="radio" name="options" class="toggle" id="option1">New</label>
										<label class="btn btn-transparent grey-salsa btn-circle btn-sm">
										<input type="radio" name="options" class="toggle" id="option2">Returning</label>
									</div>
								</div>
							</div>
							<div class="portlet-body">
								<div id="site_statistics_loading">
									<img src="${webapp_name}/assets/admin/layout2/img/loading.gif" alt="loading"/>
								</div>
								<div id="site_statistics_content" class="display-none">
									<div id="site_statistics" class="chart">
									</div>
								</div>
							</div>
						</div>
						<!-- END PORTLET-->
					</div>
					<div class="col-md-6 col-sm-6">
						<!-- BEGIN PORTLET-->
						<div class="portlet light ">
							<div class="portlet-title">
								<div class="caption">
									<i class="icon-share font-red-sunglo hide"></i>
									<span class="caption-subject font-red-sunglo bold uppercase">Revenue</span>
									<span class="caption-helper">monthly stats...</span>
								</div>
								<div class="actions">
									<div class="btn-group">
										<a href="" class="btn grey-salsa btn-circle btn-sm dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
										Filter Range&nbsp;<span class="fa fa-angle-down">
										</span>
										</a>
										<ul class="dropdown-menu pull-right">
											<li>
												<a href="javascript:;">
												Q1 2014 <span class="label label-sm label-default">
												past </span>
												</a>
											</li>
											<li>
												<a href="javascript:;">
												Q2 2014 <span class="label label-sm label-default">
												past </span>
												</a>
											</li>
											<li class="active">
												<a href="javascript:;">
												Q3 2014 <span class="label label-sm label-success">
												current </span>
												</a>
											</li>
											<li>
												<a href="javascript:;">
												Q4 2014 <span class="label label-sm label-warning">
												upcoming </span>
												</a>
											</li>
										</ul>
									</div>
								</div>
							</div>
							<div class="portlet-body">
								<div id="site_activities_loading">
									<img src="${webapp_name}/assets/admin/layout2/img/loading.gif" alt="loading"/>
								</div>
								<div id="site_activities_content" class="display-none">
									<div id="site_activities" style="height: 228px;">
									</div>
								</div>
								<div style="margin: 20px 0 10px 30px">
									<div class="row">
										<div class="col-md-3 col-sm-3 col-xs-6 text-stat">
											<span class="label label-sm label-success">
											Revenue: </span>
											<h3>$13,234</h3>
										</div>
										<div class="col-md-3 col-sm-3 col-xs-6 text-stat">
											<span class="label label-sm label-danger">
											Shipment: </span>
											<h3>$1,134</h3>
										</div>
										<div class="col-md-3 col-sm-3 col-xs-6 text-stat">
											<span class="label label-sm label-primary">
											Orders: </span>
											<h3>235090</h3>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- END PORTLET-->
					</div>
				</div>
				<div class="clearfix">
				</div>
				<div class="row">
					<div class="col-md-6 col-sm-6">
						<div class="portlet light ">
							<div class="portlet-title">
								<div class="caption">
									<i class="icon-share font-blue-steel hide"></i>
									<span class="caption-subject font-blue-steel bold uppercase">Recent Activities</span>
								</div>
								<div class="actions">
									<div class="btn-group">
										<a class="btn btn-sm btn-default btn-circle" href="javascript:;" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
										Filter By <i class="fa fa-angle-down"></i>
										</a>
										<div class="dropdown-menu hold-on-click dropdown-checkboxes pull-right">
											<label><input type="checkbox"/> Finance</label>
											<label><input type="checkbox" checked=""/> Membership</label>
											<label><input type="checkbox"/> Customer Support</label>
											<label><input type="checkbox" checked=""/> HR</label>
											<label><input type="checkbox"/> System</label>
										</div>
									</div>
									<a class="btn btn-circle btn-icon-only btn-default fullscreen" href="javascript:;">
									</a>
								</div>
							</div>
							<div class="portlet-body">
								<div class="scroller" style="height: 300px;" data-always-visible="1" data-rail-visible="0">
									<ul class="feeds">
										<li>
											<div class="col1">
												<div class="cont">
													<div class="cont-col1">
														<div class="label label-sm label-info">
															<i class="fa fa-check"></i>
														</div>
													</div>
													<div class="cont-col2">
														<div class="desc">
															 You have 4 pending tasks. <span class="label label-sm label-warning ">
															Take action <i class="fa fa-share"></i>
															</span>
														</div>
													</div>
												</div>
											</div>
											<div class="col2">
												<div class="date">
													 Just now
												</div>
											</div>
										</li>
										<li>
											<a href="javascript:;">
											<div class="col1">
												<div class="cont">
													<div class="cont-col1">
														<div class="label label-sm label-success">
															<i class="fa fa-bar-chart-o"></i>
														</div>
													</div>
													<div class="cont-col2">
														<div class="desc">
															 Finance Report for year 2013 has been released.
														</div>
													</div>
												</div>
											</div>
											<div class="col2">
												<div class="date">
													 20 mins
												</div>
											</div>
											</a>
										</li>
										<li>
											<div class="col1">
												<div class="cont">
													<div class="cont-col1">
														<div class="label label-sm label-danger">
															<i class="fa fa-user"></i>
														</div>
													</div>
													<div class="cont-col2">
														<div class="desc">
															 You have 5 pending membership that requires a quick review.
														</div>
													</div>
												</div>
											</div>
											<div class="col2">
												<div class="date">
													 24 mins
												</div>
											</div>
										</li>
										<li>
											<div class="col1">
												<div class="cont">
													<div class="cont-col1">
														<div class="label label-sm label-info">
															<i class="fa fa-shopping-cart"></i>
														</div>
													</div>
													<div class="cont-col2">
														<div class="desc">
															 New order received with <span class="label label-sm label-success">
															Reference Number: DR23923 </span>
														</div>
													</div>
												</div>
											</div>
											<div class="col2">
												<div class="date">
													 30 mins
												</div>
											</div>
										</li>
										<li>
											<div class="col1">
												<div class="cont">
													<div class="cont-col1">
														<div class="label label-sm label-success">
															<i class="fa fa-user"></i>
														</div>
													</div>
													<div class="cont-col2">
														<div class="desc">
															 You have 5 pending membership that requires a quick review.
														</div>
													</div>
												</div>
											</div>
											<div class="col2">
												<div class="date">
													 24 mins
												</div>
											</div>
										</li>
										<li>
											<div class="col1">
												<div class="cont">
													<div class="cont-col1">
														<div class="label label-sm label-default">
															<i class="fa fa-bell-o"></i>
														</div>
													</div>
													<div class="cont-col2">
														<div class="desc">
															 Web server hardware needs to be upgraded. <span class="label label-sm label-default ">
															Overdue </span>
														</div>
													</div>
												</div>
											</div>
											<div class="col2">
												<div class="date">
													 2 hours
												</div>
											</div>
										</li>
										<li>
											<a href="javascript:;">
											<div class="col1">
												<div class="cont">
													<div class="cont-col1">
														<div class="label label-sm label-default">
															<i class="fa fa-briefcase"></i>
														</div>
													</div>
													<div class="cont-col2">
														<div class="desc">
															 IPO Report for year 2013 has been released.
														</div>
													</div>
												</div>
											</div>
											<div class="col2">
												<div class="date">
													 20 mins
												</div>
											</div>
											</a>
										</li>
										<li>
											<div class="col1">
												<div class="cont">
													<div class="cont-col1">
														<div class="label label-sm label-info">
															<i class="fa fa-check"></i>
														</div>
													</div>
													<div class="cont-col2">
														<div class="desc">
															 You have 4 pending tasks. <span class="label label-sm label-warning ">
															Take action <i class="fa fa-share"></i>
															</span>
														</div>
													</div>
												</div>
											</div>
											<div class="col2">
												<div class="date">
													 Just now
												</div>
											</div>
										</li>
										<li>
											<a href="javascript:;">
											<div class="col1">
												<div class="cont">
													<div class="cont-col1">
														<div class="label label-sm label-danger">
															<i class="fa fa-bar-chart-o"></i>
														</div>
													</div>
													<div class="cont-col2">
														<div class="desc">
															 Finance Report for year 2013 has been released.
														</div>
													</div>
												</div>
											</div>
											<div class="col2">
												<div class="date">
													 20 mins
												</div>
											</div>
											</a>
										</li>
										<li>
											<div class="col1">
												<div class="cont">
													<div class="cont-col1">
														<div class="label label-sm label-default">
															<i class="fa fa-user"></i>
														</div>
													</div>
													<div class="cont-col2">
														<div class="desc">
															 You have 5 pending membership that requires a quick review.
														</div>
													</div>
												</div>
											</div>
											<div class="col2">
												<div class="date">
													 24 mins
												</div>
											</div>
										</li>
										<li>
											<div class="col1">
												<div class="cont">
													<div class="cont-col1">
														<div class="label label-sm label-info">
															<i class="fa fa-shopping-cart"></i>
														</div>
													</div>
													<div class="cont-col2">
														<div class="desc">
															 New order received with <span class="label label-sm label-success">
															Reference Number: DR23923 </span>
														</div>
													</div>
												</div>
											</div>
											<div class="col2">
												<div class="date">
													 30 mins
												</div>
											</div>
										</li>
										<li>
											<div class="col1">
												<div class="cont">
													<div class="cont-col1">
														<div class="label label-sm label-success">
															<i class="fa fa-user"></i>
														</div>
													</div>
													<div class="cont-col2">
														<div class="desc">
															 You have 5 pending membership that requires a quick review.
														</div>
													</div>
												</div>
											</div>
											<div class="col2">
												<div class="date">
													 24 mins
												</div>
											</div>
										</li>
										<li>
											<div class="col1">
												<div class="cont">
													<div class="cont-col1">
														<div class="label label-sm label-warning">
															<i class="fa fa-bell-o"></i>
														</div>
													</div>
													<div class="cont-col2">
														<div class="desc">
															 Web server hardware needs to be upgraded. <span class="label label-sm label-default ">
															Overdue </span>
														</div>
													</div>
												</div>
											</div>
											<div class="col2">
												<div class="date">
													 2 hours
												</div>
											</div>
										</li>
										<li>
											<a href="javascript:;">
											<div class="col1">
												<div class="cont">
													<div class="cont-col1">
														<div class="label label-sm label-info">
															<i class="fa fa-briefcase"></i>
														</div>
													</div>
													<div class="cont-col2">
														<div class="desc">
															 IPO Report for year 2013 has been released.
														</div>
													</div>
												</div>
											</div>
											<div class="col2">
												<div class="date">
													 20 mins
												</div>
											</div>
											</a>
										</li>
									</ul>
								</div>
								<div class="scroller-footer">
									<div class="btn-arrow-link pull-right">
										<a href="javascript:;">See All Records</a>
										<i class="icon-arrow-right"></i>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-6 col-sm-6">
						<div class="portlet light tasks-widget">
							<div class="portlet-title">
								<div class="caption">
									<i class="icon-share font-green-haze hide"></i>
									<span class="caption-subject font-green-haze bold uppercase">Tasks</span>
									<span class="caption-helper">tasks summary...</span>
								</div>
								<div class="actions">
									<div class="btn-group">
										<a class="btn green-haze btn-circle btn-sm" href="javascript:;" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
										More <i class="fa fa-angle-down"></i>
										</a>
										<ul class="dropdown-menu pull-right">
											<li>
												<a href="javascript:;">
												<i class="i"></i> All Project </a>
											</li>
											<li class="divider">
											</li>
											<li>
												<a href="javascript:;">
												AirAsia </a>
											</li>
											<li>
												<a href="javascript:;">
												Cruise </a>
											</li>
											<li>
												<a href="javascript:;">
												HSBC </a>
											</li>
											<li class="divider">
											</li>
											<li>
												<a href="javascript:;">
												Pending <span class="badge badge-danger">
												4 </span>
												</a>
											</li>
											<li>
												<a href="javascript:;">
												Completed <span class="badge badge-success">
												12 </span>
												</a>
											</li>
											<li>
												<a href="javascript:;">
												Overdue <span class="badge badge-warning">
												9 </span>
												</a>
											</li>
										</ul>
									</div>
									<a class="btn btn-circle btn-icon-only btn-default fullscreen" href="javascript:;">
									</a>
								</div>
							</div>
							<div class="portlet-body">
								<div class="task-content">
									<div class="scroller" style="height: 305px;" data-always-visible="1" data-rail-visible1="1">
										<!-- START TASK LIST -->
										<ul class="task-list">
											<li>
												<div class="task-checkbox">
													<input type="checkbox" class="liChild" value=""/>
												</div>
												<div class="task-title">
													<span class="task-title-sp">
													Present 2013 Year IPO Statistics at Board Meeting </span>
													<span class="label label-sm label-success">Company</span>
													<span class="task-bell">
													<i class="fa fa-bell-o"></i>
													</span>
												</div>
												<div class="task-config">
													<div class="task-config-btn btn-group">
														<a class="btn btn-xs default" href="javascript:;" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
														<i class="fa fa-cog"></i><i class="fa fa-angle-down"></i>
														</a>
														<ul class="dropdown-menu pull-right">
															<li>
																<a href="javascript:;">
																<i class="fa fa-check"></i> Complete </a>
															</li>
															<li>
																<a href="javascript:;">
																<i class="fa fa-pencil"></i> Edit </a>
															</li>
															<li>
																<a href="javascript:;">
																<i class="fa fa-trash-o"></i> Cancel </a>
															</li>
														</ul>
													</div>
												</div>
											</li>
											<li>
												<div class="task-checkbox">
													<input type="checkbox" class="liChild" value=""/>
												</div>
												<div class="task-title">
													<span class="task-title-sp">
													Hold An Interview for Marketing Manager Position </span>
													<span class="label label-sm label-danger">Marketing</span>
												</div>
												<div class="task-config">
													<div class="task-config-btn btn-group">
														<a class="btn btn-xs default" href="javascript:;" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
														<i class="fa fa-cog"></i><i class="fa fa-angle-down"></i>
														</a>
														<ul class="dropdown-menu pull-right">
															<li>
																<a href="javascript:;">
																<i class="fa fa-check"></i> Complete </a>
															</li>
															<li>
																<a href="javascript:;">
																<i class="fa fa-pencil"></i> Edit </a>
															</li>
															<li>
																<a href="javascript:;">
																<i class="fa fa-trash-o"></i> Cancel </a>
															</li>
														</ul>
													</div>
												</div>
											</li>
											<li>
												<div class="task-checkbox">
													<input type="checkbox" class="liChild" value=""/>
												</div>
												<div class="task-title">
													<span class="task-title-sp">
													AirAsia Intranet System Project Internal Meeting </span>
													<span class="label label-sm label-success">AirAsia</span>
													<span class="task-bell">
													<i class="fa fa-bell-o"></i>
													</span>
												</div>
												<div class="task-config">
													<div class="task-config-btn btn-group">
														<a class="btn btn-xs default" href="javascript:;" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
														<i class="fa fa-cog"></i><i class="fa fa-angle-down"></i>
														</a>
														<ul class="dropdown-menu pull-right">
															<li>
																<a href="javascript:;">
																<i class="fa fa-check"></i> Complete </a>
															</li>
															<li>
																<a href="javascript:;">
																<i class="fa fa-pencil"></i> Edit </a>
															</li>
															<li>
																<a href="javascript:;">
																<i class="fa fa-trash-o"></i> Cancel </a>
															</li>
														</ul>
													</div>
												</div>
											</li>
											<li>
												<div class="task-checkbox">
													<input type="checkbox" class="liChild" value=""/>
												</div>
												<div class="task-title">
													<span class="task-title-sp">
													Technical Management Meeting </span>
													<span class="label label-sm label-warning">Company</span>
												</div>
												<div class="task-config">
													<div class="task-config-btn btn-group">
														<a class="btn btn-xs default" href="javascript:;" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
														<i class="fa fa-cog"></i><i class="fa fa-angle-down"></i>
														</a>
														<ul class="dropdown-menu pull-right">
															<li>
																<a href="javascript:;">
																<i class="fa fa-check"></i> Complete </a>
															</li>
															<li>
																<a href="javascript:;">
																<i class="fa fa-pencil"></i> Edit </a>
															</li>
															<li>
																<a href="javascript:;">
																<i class="fa fa-trash-o"></i> Cancel </a>
															</li>
														</ul>
													</div>
												</div>
											</li>
											<li>
												<div class="task-checkbox">
													<input type="checkbox" class="liChild" value=""/>
												</div>
												<div class="task-title">
													<span class="task-title-sp">
													Kick-off Company CRM Mobile App Development </span>
													<span class="label label-sm label-info">Internal Products</span>
												</div>
												<div class="task-config">
													<div class="task-config-btn btn-group">
														<a class="btn btn-xs default" href="javascript:;" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
														<i class="fa fa-cog"></i><i class="fa fa-angle-down"></i>
														</a>
														<ul class="dropdown-menu pull-right">
															<li>
																<a href="javascript:;">
																<i class="fa fa-check"></i> Complete </a>
															</li>
															<li>
																<a href="javascript:;">
																<i class="fa fa-pencil"></i> Edit </a>
															</li>
															<li>
																<a href="javascript:;">
																<i class="fa fa-trash-o"></i> Cancel </a>
															</li>
														</ul>
													</div>
												</div>
											</li>
											<li>
												<div class="task-checkbox">
													<input type="checkbox" class="liChild" value=""/>
												</div>
												<div class="task-title">
													<span class="task-title-sp">
													Prepare Commercial Offer For SmartVision Website Rewamp </span>
													<span class="label label-sm label-danger">SmartVision</span>
												</div>
												<div class="task-config">
													<div class="task-config-btn btn-group">
														<a class="btn btn-xs default" href="javascript:;" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
														<i class="fa fa-cog"></i><i class="fa fa-angle-down"></i>
														</a>
														<ul class="dropdown-menu pull-right">
															<li>
																<a href="javascript:;">
																<i class="fa fa-check"></i> Complete </a>
															</li>
															<li>
																<a href="javascript:;">
																<i class="fa fa-pencil"></i> Edit </a>
															</li>
															<li>
																<a href="javascript:;">
																<i class="fa fa-trash-o"></i> Cancel </a>
															</li>
														</ul>
													</div>
												</div>
											</li>
											<li>
												<div class="task-checkbox">
													<input type="checkbox" class="liChild" value=""/>
												</div>
												<div class="task-title">
													<span class="task-title-sp">
													Sign-Off The Comercial Agreement With AutoSmart </span>
													<span class="label label-sm label-default">AutoSmart</span>
													<span class="task-bell">
													<i class="fa fa-bell-o"></i>
													</span>
												</div>
												<div class="task-config">
													<div class="task-config-btn btn-group">
														<a class="btn btn-xs default" href="javascript:;" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
														<i class="fa fa-cog"></i><i class="fa fa-angle-down"></i>
														</a>
														<ul class="dropdown-menu pull-right">
															<li>
																<a href="javascript:;">
																<i class="fa fa-check"></i> Complete </a>
															</li>
															<li>
																<a href="javascript:;">
																<i class="fa fa-pencil"></i> Edit </a>
															</li>
															<li>
																<a href="javascript:;">
																<i class="fa fa-trash-o"></i> Cancel </a>
															</li>
														</ul>
													</div>
												</div>
											</li>
											<li>
												<div class="task-checkbox">
													<input type="checkbox" class="liChild" value=""/>
												</div>
												<div class="task-title">
													<span class="task-title-sp">
													Company Staff Meeting </span>
													<span class="label label-sm label-success">Cruise</span>
													<span class="task-bell">
													<i class="fa fa-bell-o"></i>
													</span>
												</div>
												<div class="task-config">
													<div class="task-config-btn btn-group">
														<a class="btn btn-xs default" href="javascript:;" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
														<i class="fa fa-cog"></i><i class="fa fa-angle-down"></i>
														</a>
														<ul class="dropdown-menu pull-right">
															<li>
																<a href="javascript:;">
																<i class="fa fa-check"></i> Complete </a>
															</li>
															<li>
																<a href="javascript:;">
																<i class="fa fa-pencil"></i> Edit </a>
															</li>
															<li>
																<a href="javascript:;">
																<i class="fa fa-trash-o"></i> Cancel </a>
															</li>
														</ul>
													</div>
												</div>
											</li>
											<li class="last-line">
												<div class="task-checkbox">
													<input type="checkbox" class="liChild" value=""/>
												</div>
												<div class="task-title">
													<span class="task-title-sp">
													KeenThemes Investment Discussion </span>
													<span class="label label-sm label-warning">KeenThemes </span>
												</div>
												<div class="task-config">
													<div class="task-config-btn btn-group">
														<a class="btn btn-xs default" href="javascript:;" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
														<i class="fa fa-cog"></i><i class="fa fa-angle-down"></i>
														</a>
														<ul class="dropdown-menu pull-right">
															<li>
																<a href="javascript:;">
																<i class="fa fa-check"></i> Complete </a>
															</li>
															<li>
																<a href="javascript:;">
																<i class="fa fa-pencil"></i> Edit </a>
															</li>
															<li>
																<a href="javascript:;">
																<i class="fa fa-trash-o"></i> Cancel </a>
															</li>
														</ul>
													</div>
												</div>
											</li>
										</ul>
										<!-- END START TASK LIST -->
									</div>
								</div>
								<div class="task-footer">
									<div class="btn-arrow-link pull-right">
										<a href="javascript:;">See All Records</a>
										<i class="icon-arrow-right"></i>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="clearfix">
				</div>
				<div class="row">
					<div class="col-md-6 col-sm-6">
						<div class="portlet light ">
							<div class="portlet-title">
								<div class="caption">
									<i class="icon-cursor font-purple-intense hide"></i>
									<span class="caption-subject font-purple-intense bold uppercase">General Stats</span>
								</div>
								<div class="actions">
									<a href="javascript:;" class="btn btn-sm btn-circle btn-default easy-pie-chart-reload">
									<i class="fa fa-repeat"></i> Reload </a>
								</div>
							</div>
							<div class="portlet-body">
								<div class="row">
									<div class="col-md-4">
										<div class="easy-pie-chart">
											<div class="number transactions" data-percent="55">
												<span>
												+55 </span>
												%
											</div>
											<a class="title" href="javascript:;">
											Transactions <i class="icon-arrow-right"></i>
											</a>
										</div>
									</div>
									<div class="margin-bottom-10 visible-sm">
									</div>
									<div class="col-md-4">
										<div class="easy-pie-chart">
											<div class="number visits" data-percent="85">
												<span>
												+85 </span>
												%
											</div>
											<a class="title" href="javascript:;">
											New Visits <i class="icon-arrow-right"></i>
											</a>
										</div>
									</div>
									<div class="margin-bottom-10 visible-sm">
									</div>
									<div class="col-md-4">
										<div class="easy-pie-chart">
											<div class="number bounce" data-percent="46">
												<span>
												-46 </span>
												%
											</div>
											<a class="title" href="javascript:;">
											Bounce <i class="icon-arrow-right"></i>
											</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-6 col-sm-6">
						<div class="portlet light ">
							<div class="portlet-title">
								<div class="caption">
									<i class="icon-equalizer font-purple-plum hide"></i>
									<span class="caption-subject font-red-sunglo bold uppercase">Server Stats</span>
									<span class="caption-helper">monthly stats...</span>
								</div>
								<div class="tools">
									<a href="" class="collapse">
									</a>
									<a href="#portlet-config" data-toggle="modal" class="config">
									</a>
									<a href="" class="reload">
									</a>
									<a href="" class="remove">
									</a>
								</div>
							</div>
							<div class="portlet-body">
								<div class="row">
									<div class="col-md-4">
										<div class="sparkline-chart">
											<div class="number" id="sparkline_bar"></div>
											<a class="title" href="javascript:;">
											Network <i class="icon-arrow-right"></i>
											</a>
										</div>
									</div>
									<div class="margin-bottom-10 visible-sm">
									</div>
									<div class="col-md-4">
										<div class="sparkline-chart">
											<div class="number" id="sparkline_bar2"></div>
											<a class="title" href="javascript:;">
											CPU Load <i class="icon-arrow-right"></i>
											</a>
										</div>
									</div>
									<div class="margin-bottom-10 visible-sm">
									</div>
									<div class="col-md-4">
										<div class="sparkline-chart">
											<div class="number" id="sparkline_line"></div>
											<a class="title" href="javascript:;">
											Load Rate <i class="icon-arrow-right"></i>
											</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="clearfix">
				</div>
				<div class="row">
					<div class="col-md-6 col-sm-6">
						<!-- BEGIN REGIONAL STATS PORTLET-->
						<div class="portlet light ">
							<div class="portlet-title">
								<div class="caption">
									<i class="icon-share font-red-sunglo"></i>
									<span class="caption-subject font-red-sunglo bold uppercase">Regional Stats</span>
								</div>
								<div class="actions">
									<a class="btn btn-circle btn-icon-only btn-default" href="javascript:;">
									<i class="icon-cloud-upload"></i>
									</a>
									<a class="btn btn-circle btn-icon-only btn-default" href="javascript:;">
									<i class="icon-wrench"></i>
									</a>
									<a class="btn btn-circle btn-icon-only btn-default fullscreen" href="javascript:;">
									</a>
									<a class="btn btn-circle btn-icon-only btn-default" href="javascript:;">
									<i class="icon-trash"></i>
									</a>
								</div>
							</div>
							<div class="portlet-body">
								<div id="region_statistics_loading">
									<img src="${webapp_name}/assets/admin/layout2/img/loading.gif" alt="loading"/>
								</div>
								<div id="region_statistics_content" class="display-none">
									<div class="btn-toolbar margin-bottom-10">
										<div class="btn-group btn-group-circle" data-toggle="buttons">
											<a href="" class="btn grey-salsa btn-sm active">
											Users </a>
											<a href="" class="btn grey-salsa btn-sm">
											Orders </a>
										</div>
										<div class="btn-group pull-right">
											<a href="" class="btn btn-circle grey-salsa btn-sm dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
											Select Region <span class="fa fa-angle-down">
											</span>
											</a>
											<ul class="dropdown-menu pull-right">
												<li>
													<a href="javascript:;" id="regional_stat_world">
													World </a>
												</li>
												<li>
													<a href="javascript:;" id="regional_stat_usa">
													USA </a>
												</li>
												<li>
													<a href="javascript:;" id="regional_stat_europe">
													Europe </a>
												</li>
												<li>
													<a href="javascript:;" id="regional_stat_russia">
													Russia </a>
												</li>
												<li>
													<a href="javascript:;" id="regional_stat_germany">
													Germany </a>
												</li>
											</ul>
										</div>
									</div>
									<div id="vmap_world" class="vmaps display-none">
									</div>
									<div id="vmap_usa" class="vmaps display-none">
									</div>
									<div id="vmap_europe" class="vmaps display-none">
									</div>
									<div id="vmap_russia" class="vmaps display-none">
									</div>
									<div id="vmap_germany" class="vmaps display-none">
									</div>
								</div>
							</div>
						</div>
						<!-- END REGIONAL STATS PORTLET-->
					</div>
					<div class="col-md-6 col-sm-6">
						<!-- BEGIN PORTLET-->
						<div class="portlet light">
							<div class="portlet-title tabbable-line">
								<div class="caption">
									<i class="icon-globe font-green-sharp"></i>
									<span class="caption-subject font-green-sharp bold uppercase">Feeds</span>
								</div>
								<ul class="nav nav-tabs">
									<li class="active">
										<a href="#tab_1_1" data-toggle="tab">
										System </a>
									</li>
									<li>
										<a href="#tab_1_2" data-toggle="tab">
										Activities </a>
									</li>
									<li>
										<a href="#tab_1_3" data-toggle="tab">
										Recent Users </a>
									</li>
								</ul>
							</div>
							<div class="portlet-body">
								<!--BEGIN TABS-->
								<div class="tab-content">
									<div class="tab-pane active" id="tab_1_1">
										<div class="scroller" style="height: 339px;" data-always-visible="1" data-rail-visible="0">
											<ul class="feeds">
												<li>
													<div class="col1">
														<div class="cont">
															<div class="cont-col1">
																<div class="label label-sm label-success">
																	<i class="fa fa-bell-o"></i>
																</div>
															</div>
															<div class="cont-col2">
																<div class="desc">
																	 You have 4 pending tasks. <span class="label label-sm label-info">
																	Take action <i class="fa fa-share"></i>
																	</span>
																</div>
															</div>
														</div>
													</div>
													<div class="col2">
														<div class="date">
															 Just now
														</div>
													</div>
												</li>
												<li>
													<a href="javascript:;">
													<div class="col1">
														<div class="cont">
															<div class="cont-col1">
																<div class="label label-sm label-success">
																	<i class="fa fa-bell-o"></i>
																</div>
															</div>
															<div class="cont-col2">
																<div class="desc">
																	 New version v1.4 just lunched!
																</div>
															</div>
														</div>
													</div>
													<div class="col2">
														<div class="date">
															 20 mins
														</div>
													</div>
													</a>
												</li>
												<li>
													<div class="col1">
														<div class="cont">
															<div class="cont-col1">
																<div class="label label-sm label-danger">
																	<i class="fa fa-bolt"></i>
																</div>
															</div>
															<div class="cont-col2">
																<div class="desc">
																	 Database server #12 overloaded. Please fix the issue.
																</div>
															</div>
														</div>
													</div>
													<div class="col2">
														<div class="date">
															 24 mins
														</div>
													</div>
												</li>
												<li>
													<div class="col1">
														<div class="cont">
															<div class="cont-col1">
																<div class="label label-sm label-info">
																	<i class="fa fa-bullhorn"></i>
																</div>
															</div>
															<div class="cont-col2">
																<div class="desc">
																	 New order received. Please take care of it.
																</div>
															</div>
														</div>
													</div>
													<div class="col2">
														<div class="date">
															 30 mins
														</div>
													</div>
												</li>
												<li>
													<div class="col1">
														<div class="cont">
															<div class="cont-col1">
																<div class="label label-sm label-success">
																	<i class="fa fa-bullhorn"></i>
																</div>
															</div>
															<div class="cont-col2">
																<div class="desc">
																	 New order received. Please take care of it.
																</div>
															</div>
														</div>
													</div>
													<div class="col2">
														<div class="date">
															 40 mins
														</div>
													</div>
												</li>
												<li>
													<div class="col1">
														<div class="cont">
															<div class="cont-col1">
																<div class="label label-sm label-warning">
																	<i class="fa fa-plus"></i>
																</div>
															</div>
															<div class="cont-col2">
																<div class="desc">
																	 New user registered.
																</div>
															</div>
														</div>
													</div>
													<div class="col2">
														<div class="date">
															 1.5 hours
														</div>
													</div>
												</li>
												<li>
													<div class="col1">
														<div class="cont">
															<div class="cont-col1">
																<div class="label label-sm label-success">
																	<i class="fa fa-bell-o"></i>
																</div>
															</div>
															<div class="cont-col2">
																<div class="desc">
																	 Web server hardware needs to be upgraded. <span class="label label-sm label-default ">
																	Overdue </span>
																</div>
															</div>
														</div>
													</div>
													<div class="col2">
														<div class="date">
															 2 hours
														</div>
													</div>
												</li>
												<li>
													<div class="col1">
														<div class="cont">
															<div class="cont-col1">
																<div class="label label-sm label-default">
																	<i class="fa fa-bullhorn"></i>
																</div>
															</div>
															<div class="cont-col2">
																<div class="desc">
																	 New order received. Please take care of it.
																</div>
															</div>
														</div>
													</div>
													<div class="col2">
														<div class="date">
															 3 hours
														</div>
													</div>
												</li>
												<li>
													<div class="col1">
														<div class="cont">
															<div class="cont-col1">
																<div class="label label-sm label-warning">
																	<i class="fa fa-bullhorn"></i>
																</div>
															</div>
															<div class="cont-col2">
																<div class="desc">
																	 New order received. Please take care of it.
																</div>
															</div>
														</div>
													</div>
													<div class="col2">
														<div class="date">
															 5 hours
														</div>
													</div>
												</li>
												<li>
													<div class="col1">
														<div class="cont">
															<div class="cont-col1">
																<div class="label label-sm label-info">
																	<i class="fa fa-bullhorn"></i>
																</div>
															</div>
															<div class="cont-col2">
																<div class="desc">
																	 New order received. Please take care of it.
																</div>
															</div>
														</div>
													</div>
													<div class="col2">
														<div class="date">
															 18 hours
														</div>
													</div>
												</li>
												<li>
													<div class="col1">
														<div class="cont">
															<div class="cont-col1">
																<div class="label label-sm label-default">
																	<i class="fa fa-bullhorn"></i>
																</div>
															</div>
															<div class="cont-col2">
																<div class="desc">
																	 New order received. Please take care of it.
																</div>
															</div>
														</div>
													</div>
													<div class="col2">
														<div class="date">
															 21 hours
														</div>
													</div>
												</li>
												<li>
													<div class="col1">
														<div class="cont">
															<div class="cont-col1">
																<div class="label label-sm label-info">
																	<i class="fa fa-bullhorn"></i>
																</div>
															</div>
															<div class="cont-col2">
																<div class="desc">
																	 New order received. Please take care of it.
																</div>
															</div>
														</div>
													</div>
													<div class="col2">
														<div class="date">
															 22 hours
														</div>
													</div>
												</li>
												<li>
													<div class="col1">
														<div class="cont">
															<div class="cont-col1">
																<div class="label label-sm label-default">
																	<i class="fa fa-bullhorn"></i>
																</div>
															</div>
															<div class="cont-col2">
																<div class="desc">
																	 New order received. Please take care of it.
																</div>
															</div>
														</div>
													</div>
													<div class="col2">
														<div class="date">
															 21 hours
														</div>
													</div>
												</li>
												<li>
													<div class="col1">
														<div class="cont">
															<div class="cont-col1">
																<div class="label label-sm label-info">
																	<i class="fa fa-bullhorn"></i>
																</div>
															</div>
															<div class="cont-col2">
																<div class="desc">
																	 New order received. Please take care of it.
																</div>
															</div>
														</div>
													</div>
													<div class="col2">
														<div class="date">
															 22 hours
														</div>
													</div>
												</li>
												<li>
													<div class="col1">
														<div class="cont">
															<div class="cont-col1">
																<div class="label label-sm label-default">
																	<i class="fa fa-bullhorn"></i>
																</div>
															</div>
															<div class="cont-col2">
																<div class="desc">
																	 New order received. Please take care of it.
																</div>
															</div>
														</div>
													</div>
													<div class="col2">
														<div class="date">
															 21 hours
														</div>
													</div>
												</li>
												<li>
													<div class="col1">
														<div class="cont">
															<div class="cont-col1">
																<div class="label label-sm label-info">
																	<i class="fa fa-bullhorn"></i>
																</div>
															</div>
															<div class="cont-col2">
																<div class="desc">
																	 New order received. Please take care of it.
																</div>
															</div>
														</div>
													</div>
													<div class="col2">
														<div class="date">
															 22 hours
														</div>
													</div>
												</li>
												<li>
													<div class="col1">
														<div class="cont">
															<div class="cont-col1">
																<div class="label label-sm label-default">
																	<i class="fa fa-bullhorn"></i>
																</div>
															</div>
															<div class="cont-col2">
																<div class="desc">
																	 New order received. Please take care of it.
																</div>
															</div>
														</div>
													</div>
													<div class="col2">
														<div class="date">
															 21 hours
														</div>
													</div>
												</li>
												<li>
													<div class="col1">
														<div class="cont">
															<div class="cont-col1">
																<div class="label label-sm label-info">
																	<i class="fa fa-bullhorn"></i>
																</div>
															</div>
															<div class="cont-col2">
																<div class="desc">
																	 New order received. Please take care of it.
																</div>
															</div>
														</div>
													</div>
													<div class="col2">
														<div class="date">
															 22 hours
														</div>
													</div>
												</li>
											</ul>
										</div>
									</div>
									<div class="tab-pane" id="tab_1_2">
										<div class="scroller" style="height: 290px;" data-always-visible="1" data-rail-visible1="1">
											<ul class="feeds">
												<li>
													<a href="javascript:;">
													<div class="col1">
														<div class="cont">
															<div class="cont-col1">
																<div class="label label-sm label-success">
																	<i class="fa fa-bell-o"></i>
																</div>
															</div>
															<div class="cont-col2">
																<div class="desc">
																	 New user registered
																</div>
															</div>
														</div>
													</div>
													<div class="col2">
														<div class="date">
															 Just now
														</div>
													</div>
													</a>
												</li>
												<li>
													<a href="javascript:;">
													<div class="col1">
														<div class="cont">
															<div class="cont-col1">
																<div class="label label-sm label-success">
																	<i class="fa fa-bell-o"></i>
																</div>
															</div>
															<div class="cont-col2">
																<div class="desc">
																	 New order received
																</div>
															</div>
														</div>
													</div>
													<div class="col2">
														<div class="date">
															 10 mins
														</div>
													</div>
													</a>
												</li>
												<li>
													<div class="col1">
														<div class="cont">
															<div class="cont-col1">
																<div class="label label-sm label-danger">
																	<i class="fa fa-bolt"></i>
																</div>
															</div>
															<div class="cont-col2">
																<div class="desc">
																	 Order #24DOP4 has been rejected. <span class="label label-sm label-danger ">
																	Take action <i class="fa fa-share"></i>
																	</span>
																</div>
															</div>
														</div>
													</div>
													<div class="col2">
														<div class="date">
															 24 mins
														</div>
													</div>
												</li>
												<li>
													<a href="javascript:;">
													<div class="col1">
														<div class="cont">
															<div class="cont-col1">
																<div class="label label-sm label-success">
																	<i class="fa fa-bell-o"></i>
																</div>
															</div>
															<div class="cont-col2">
																<div class="desc">
																	 New user registered
																</div>
															</div>
														</div>
													</div>
													<div class="col2">
														<div class="date">
															 Just now
														</div>
													</div>
													</a>
												</li>
												<li>
													<a href="javascript:;">
													<div class="col1">
														<div class="cont">
															<div class="cont-col1">
																<div class="label label-sm label-success">
																	<i class="fa fa-bell-o"></i>
																</div>
															</div>
															<div class="cont-col2">
																<div class="desc">
																	 New user registered
																</div>
															</div>
														</div>
													</div>
													<div class="col2">
														<div class="date">
															 Just now
														</div>
													</div>
													</a>
												</li>
												<li>
													<a href="javascript:;">
													<div class="col1">
														<div class="cont">
															<div class="cont-col1">
																<div class="label label-sm label-success">
																	<i class="fa fa-bell-o"></i>
																</div>
															</div>
															<div class="cont-col2">
																<div class="desc">
																	 New user registered
																</div>
															</div>
														</div>
													</div>
													<div class="col2">
														<div class="date">
															 Just now
														</div>
													</div>
													</a>
												</li>
												<li>
													<a href="javascript:;">
													<div class="col1">
														<div class="cont">
															<div class="cont-col1">
																<div class="label label-sm label-success">
																	<i class="fa fa-bell-o"></i>
																</div>
															</div>
															<div class="cont-col2">
																<div class="desc">
																	 New user registered
																</div>
															</div>
														</div>
													</div>
													<div class="col2">
														<div class="date">
															 Just now
														</div>
													</div>
													</a>
												</li>
												<li>
													<a href="javascript:;">
													<div class="col1">
														<div class="cont">
															<div class="cont-col1">
																<div class="label label-sm label-success">
																	<i class="fa fa-bell-o"></i>
																</div>
															</div>
															<div class="cont-col2">
																<div class="desc">
																	 New user registered
																</div>
															</div>
														</div>
													</div>
													<div class="col2">
														<div class="date">
															 Just now
														</div>
													</div>
													</a>
												</li>
												<li>
													<a href="javascript:;">
													<div class="col1">
														<div class="cont">
															<div class="cont-col1">
																<div class="label label-sm label-success">
																	<i class="fa fa-bell-o"></i>
																</div>
															</div>
															<div class="cont-col2">
																<div class="desc">
																	 New user registered
																</div>
															</div>
														</div>
													</div>
													<div class="col2">
														<div class="date">
															 Just now
														</div>
													</div>
													</a>
												</li>
												<li>
													<a href="javascript:;">
													<div class="col1">
														<div class="cont">
															<div class="cont-col1">
																<div class="label label-sm label-success">
																	<i class="fa fa-bell-o"></i>
																</div>
															</div>
															<div class="cont-col2">
																<div class="desc">
																	 New user registered
																</div>
															</div>
														</div>
													</div>
													<div class="col2">
														<div class="date">
															 Just now
														</div>
													</div>
													</a>
												</li>
											</ul>
										</div>
									</div>
									<div class="tab-pane" id="tab_1_3">
										<div class="scroller" style="height: 290px;" data-always-visible="1" data-rail-visible1="1">
											<div class="row">
												<div class="col-md-6 user-info">
													<img alt="" src="${webapp_name}/assets/admin/layout2/img/avatar.png" class="img-responsive"/>
													<div class="details">
														<div>
															<a href="javascript:;">
															Robert Nilson </a>
															<span class="label label-sm label-success label-mini">
															Approved </span>
														</div>
														<div>
															 29 Jan 2013 10:45AM
														</div>
													</div>
												</div>
												<div class="col-md-6 user-info">
													<img alt="" src="${webapp_name}/assets/admin/layout2/img/avatar.png" class="img-responsive"/>
													<div class="details">
														<div>
															<a href="javascript:;">
															Lisa Miller </a>
															<span class="label label-sm label-info">
															Pending </span>
														</div>
														<div>
															 19 Jan 2013 10:45AM
														</div>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-6 user-info">
													<img alt="" src="${webapp_name}/assets/admin/layout2/img/avatar.png" class="img-responsive"/>
													<div class="details">
														<div>
															<a href="javascript:;">
															Eric Kim </a>
															<span class="label label-sm label-info">
															Pending </span>
														</div>
														<div>
															 19 Jan 2013 12:45PM
														</div>
													</div>
												</div>
												<div class="col-md-6 user-info">
													<img alt="" src="${webapp_name}/assets/admin/layout2/img/avatar.png" class="img-responsive"/>
													<div class="details">
														<div>
															<a href="javascript:;">
															Lisa Miller </a>
															<span class="label label-sm label-danger">
															In progress </span>
														</div>
														<div>
															 19 Jan 2013 11:55PM
														</div>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-6 user-info">
													<img alt="" src="${webapp_name}/assets/admin/layout2/img/avatar.png" class="img-responsive"/>
													<div class="details">
														<div>
															<a href="javascript:;">
															Eric Kim </a>
															<span class="label label-sm label-info">
															Pending </span>
														</div>
														<div>
															 19 Jan 2013 12:45PM
														</div>
													</div>
												</div>
												<div class="col-md-6 user-info">
													<img alt="" src="${webapp_name}/assets/admin/layout2/img/avatar.png" class="img-responsive"/>
													<div class="details">
														<div>
															<a href="javascript:;">
															Lisa Miller </a>
															<span class="label label-sm label-danger">
															In progress </span>
														</div>
														<div>
															 19 Jan 2013 11:55PM
														</div>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-6 user-info">
													<img alt="" src="${webapp_name}/assets/admin/layout2/img/avatar.png" class="img-responsive"/>
													<div class="details">
														<div>
															<a href="javascript:;">
															Eric Kim </a>
															<span class="label label-sm label-info">
															Pending </span>
														</div>
														<div>
															 19 Jan 2013 12:45PM
														</div>
													</div>
												</div>
												<div class="col-md-6 user-info">
													<img alt="" src="${webapp_name}/assets/admin/layout2/img/avatar.png" class="img-responsive"/>
													<div class="details">
														<div>
															<a href="javascript:;">
															Lisa Miller </a>
															<span class="label label-sm label-danger">
															In progress </span>
														</div>
														<div>
															 19 Jan 2013 11:55PM
														</div>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-6 user-info">
													<img alt="" src="${webapp_name}/assets/admin/layout2/img/avatar.png" class="img-responsive"/>
													<div class="details">
														<div>
															<a href="javascript:;">
															Eric Kim </a>
															<span class="label label-sm label-info">
															Pending </span>
														</div>
														<div>
															 19 Jan 2013 12:45PM
														</div>
													</div>
												</div>
												<div class="col-md-6 user-info">
													<img alt="" src="${webapp_name}/assets/admin/layout2/img/avatar.png" class="img-responsive"/>
													<div class="details">
														<div>
															<a href="javascript:;">
															Lisa Miller </a>
															<span class="label label-sm label-danger">
															In progress </span>
														</div>
														<div>
															 19 Jan 2013 11:55PM
														</div>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-6 user-info">
													<img alt="" src="${webapp_name}/assets/admin/layout2/img/avatar.png" class="img-responsive"/>
													<div class="details">
														<div>
															<a href="javascript:;">
															Eric Kim </a>
															<span class="label label-sm label-info">
															Pending </span>
														</div>
														<div>
															 19 Jan 2013 12:45PM
														</div>
													</div>
												</div>
												<div class="col-md-6 user-info">
													<img alt="" src="${webapp_name}/assets/admin/layout2/img/avatar.png" class="img-responsive"/>
													<div class="details">
														<div>
															<a href="javascript:;">
															Lisa Miller </a>
															<span class="label label-sm label-danger">
															In progress </span>
														</div>
														<div>
															 19 Jan 2013 11:55PM
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!--END TABS-->
							</div>
						</div>
						<!-- END PORTLET-->
					</div>
				</div>
				<div class="clearfix">
				</div>
				<div class="row">
					<div class="col-md-6 col-sm-6">
						<!-- BEGIN PORTLET-->
						<div class="portlet light calendar ">
							<div class="portlet-title ">
								<div class="caption">
									<i class="icon-calendar font-green-sharp"></i>
									<span class="caption-subject font-green-sharp bold uppercase">Calendar</span>
								</div>
							</div>
							<div class="portlet-body">
								<div id="calendar">
								</div>
							</div>
						</div>
						<!-- END PORTLET-->
					</div>
					<div class="col-md-6 col-sm-6">
						<!-- BEGIN PORTLET-->
						<div class="portlet light ">
							<div class="portlet-title">
								<div class="caption">
									<i class="icon-bubble font-red-sunglo"></i>
									<span class="caption-subject font-red-sunglo bold uppercase">Chats</span>
								</div>
								<div class="inputs">
									<div class="portlet-input input-inline input-small">
										<div class="input-icon right">
											<i class="icon-magnifier"></i>
											<input type="text" class="form-control input-circle" placeholder="search...">
										</div>
									</div>
								</div>
							</div>
							<div class="portlet-body" id="chats">
								<div class="scroller" style="height: 353px;" data-always-visible="1" data-rail-visible1="1">
									<ul class="chats">
										<li class="in">
											<img class="avatar" alt="" src="${webapp_name}/assets/admin/layout2/img/avatar1.jpg"/>
											<div class="message">
												<span class="arrow">
												</span>
												<a href="javascript:;" class="name">
												Bob Nilson </a>
												<span class="datetime">
												at 20:09 </span>
												<span class="body">
												Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. </span>
											</div>
										</li>
										<li class="out">
											<img class="avatar" alt="" src="${webapp_name}/assets/admin/layout2/img/avatar2.jpg"/>
											<div class="message">
												<span class="arrow">
												</span>
												<a href="javascript:;" class="name">
												Lisa Wong </a>
												<span class="datetime">
												at 20:11 </span>
												<span class="body">
												Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. </span>
											</div>
										</li>
										<li class="in">
											<img class="avatar" alt="" src="${webapp_name}/assets/admin/layout2/img/avatar1.jpg"/>
											<div class="message">
												<span class="arrow">
												</span>
												<a href="javascript:;" class="name">
												Bob Nilson </a>
												<span class="datetime">
												at 20:30 </span>
												<span class="body">
												Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. </span>
											</div>
										</li>
										<li class="out">
											<img class="avatar" alt="" src="${webapp_name}/assets/admin/layout2/img/avatar3.jpg"/>
											<div class="message">
												<span class="arrow">
												</span>
												<a href="javascript:;" class="name">
												Richard Doe </a>
												<span class="datetime">
												at 20:33 </span>
												<span class="body">
												Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. </span>
											</div>
										</li>
										<li class="in">
											<img class="avatar" alt="" src="${webapp_name}/assets/admin/layout2/img/avatar3.jpg"/>
											<div class="message">
												<span class="arrow">
												</span>
												<a href="javascript:;" class="name">
												Richard Doe </a>
												<span class="datetime">
												at 20:35 </span>
												<span class="body">
												Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. </span>
											</div>
										</li>
										<li class="out">
											<img class="avatar" alt="" src="${webapp_name}/assets/admin/layout2/img/avatar1.jpg"/>
											<div class="message">
												<span class="arrow">
												</span>
												<a href="javascript:;" class="name">
												Bob Nilson </a>
												<span class="datetime">
												at 20:40 </span>
												<span class="body">
												Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. </span>
											</div>
										</li>
										<li class="in">
											<img class="avatar" alt="" src="${webapp_name}/assets/admin/layout2/img/avatar3.jpg"/>
											<div class="message">
												<span class="arrow">
												</span>
												<a href="javascript:;" class="name">
												Richard Doe </a>
												<span class="datetime">
												at 20:40 </span>
												<span class="body">
												Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. </span>
											</div>
										</li>
										<li class="out">
											<img class="avatar" alt="" src="${webapp_name}/assets/admin/layout2/img/avatar1.jpg"/>
											<div class="message">
												<span class="arrow">
												</span>
												<a href="javascript:;" class="name">
												Bob Nilson </a>
												<span class="datetime">
												at 20:54 </span>
												<span class="body">
												Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. sed diam nonummy nibh euismod tincidunt ut laoreet. </span>
											</div>
										</li>
									</ul>
								</div>
								<div class="chat-form">
									<div class="input-cont">
										<input class="form-control" type="text" placeholder="Type a message here..."/>
									</div>
									<div class="btn-cont">
										<span class="arrow">
										</span>
										<a href="" class="btn blue icn-only">
										<i class="fa fa-check icon-white"></i>
										</a>
									</div>
								</div>
							</div>
						</div>
						<!-- END PORTLET-->
					</div>
				</div>
			</div>
		</div>
		<!-- END CONTENT -->
		<!-- BEGIN QUICK SIDEBAR -->
		<!--Cooming Soon...-->
		<!-- END QUICK SIDEBAR -->
	</div>
	<!-- END CONTAINER -->
	<!-- BEGIN FOOTER -->
		<jsp:include page="${inc_dir}/page-footer.jsp"></jsp:include>
	<!-- END FOOTER -->
</div>
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="${webapp_name}/assets/global/plugins/respond.min.js"></script>
<script src="${webapp_name}/assets/global/plugins/excanvas.min.js"></script> 
<![endif]-->
<script src="${webapp_name}/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/jquery-migrate.min.js" type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="${webapp_name}/assets/global/plugins/jquery-ui/jquery-ui.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="${webapp_name}/assets/global/plugins/jqvmap/jqvmap/jquery.vmap.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.russia.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.world.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.europe.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.germany.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.usa.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/jqvmap/jqvmap/data/jquery.vmap.sampledata.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/flot/jquery.flot.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/flot/jquery.flot.resize.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/flot/jquery.flot.categories.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/jquery.pulsate.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/bootstrap-daterangepicker/moment.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/bootstrap-daterangepicker/daterangepicker.js" type="text/javascript"></script>
<!-- IMPORTANT! fullcalendar depends on jquery-ui.min.js for drag & drop support -->
<script src="${webapp_name}/assets/global/plugins/fullcalendar/fullcalendar.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/jquery-easypiechart/jquery.easypiechart.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/jquery.sparkline.min.js" type="text/javascript"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${webapp_name}/assets/global/scripts/metronic.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/admin/layout2/scripts/layout.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/admin/layout2/scripts/demo.js" type="text/javascript"></script>

<script src="${webapp_name}/assets/admin/pages/scripts-local/index.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/admin/pages/scripts/tasks.js" type="text/javascript"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script>
jQuery(document).ready(function() {    
   Metronic.init(); // init metronic core componets
   Layout.init(); // init layout
   Demo.init(); // init demo features 
   Index.init();   
   Index.initDashboardDaterange();
   Index.initJQVMAP(); // init index page's custom scripts
   Index.initCalendar(); // init index page's custom scripts
   Index.initCharts(); // init index page's custom scripts
   Index.initChat();
   Index.initMiniCharts();
   Tasks.initDashboardWidget();
});
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
