<%@ page contentType="text/html; charset=utf-8" %>
<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- global variables settings -->
<c:set var="webapp_name" value="/acp"/>

<!-- page variables  -->
<c:set var="inc_dir" value="../inc"/>
<!-- ENDS page variables -->

<!DOCTYPE html>
<!-- 
Template Name: Metronic - Responsive Admin Dashboard Template build with Twitter Bootstrap 3.3.7
Version: 4.7.5
Author: KeenThemes
Website: http://www.keenthemes.com/
Contact: support@keenthemes.com
Follow: www.twitter.com/keenthemes
Dribbble: www.dribbble.com/keenthemes
Like: www.facebook.com/keenthemes
Purchase: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
Renew Support: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
License: You must have a valid license purchased only from themeforest(the above link) in order to legally use the theme for your project.
-->
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
    <!--<![endif]-->
    <!-- BEGIN HEAD -->

    <head>
        <meta charset="utf-8" />
        <title>Athensoft | Event - News Create</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <meta content="Preview page of Metronic Admin Theme #2 for edit product" name="description" />
        <meta content="" name="author" />
        <!-- BEGIN GLOBAL MANDATORY STYLES -->
        <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css" />
        <link href="${webapp_name}/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="${webapp_name}/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
        <link href="${webapp_name}/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${webapp_name}/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
        <!-- END GLOBAL MANDATORY STYLES -->
        <!-- BEGIN PAGE LEVEL PLUGINS -->
        <link href="${webapp_name}/assets/global/plugins/datatables/datatables.min.css" rel="stylesheet" type="text/css" />
        <link href="${webapp_name}/assets/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.css" rel="stylesheet" type="text/css" />
        <link href="${webapp_name}/assets/global/plugins/bootstrap-datepicker/css/bootstrap-datepicker3.min.css" rel="stylesheet" type="text/css" />
        <link href="${webapp_name}/assets/global/plugins/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css" />
        <link href="${webapp_name}/assets/global/plugins/fancybox/source/jquery.fancybox.css" rel="stylesheet" type="text/css" />
        <!-- END PAGE LEVEL PLUGINS -->
        <!-- BEGIN THEME GLOBAL STYLES -->
        <link href="${webapp_name}/assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
        <link href="${webapp_name}/assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
        <!-- END THEME GLOBAL STYLES -->
        <!-- BEGIN THEME LAYOUT STYLES -->
        <link href="${webapp_name}/assets/layouts/layout2/css/layout.min.css" rel="stylesheet" type="text/css" />
        <link href="${webapp_name}/assets/layouts/layout2/css/themes/blue.min.css" rel="stylesheet" type="text/css" id="style_color" />
        <link href="${webapp_name}/assets/layouts/layout2/css/custom.min.css" rel="stylesheet" type="text/css" />
        <!-- END THEME LAYOUT STYLES -->
        <link rel="shortcut icon" href="favicon.ico" /> </head>
    <!-- END HEAD -->

    <body class="page-header-fixed page-sidebar-closed-hide-logo page-container-bg-solid">
        <!-- BEGIN HEADER -->
        <div class="page-header navbar navbar-fixed-top">
            <!-- BEGIN HEADER INNER -->
            <div class="page-header-inner ">
                <!-- BEGIN LOGO -->
                <jsp:include page="${inc_dir}/page-logo.jsp"></jsp:include>
                <!-- END LOGO -->
                <!-- BEGIN RESPONSIVE MENU TOGGLER -->
                <a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse"> </a>
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
        <!-- BEGIN HEADER & CONTENT DIVIDER -->
        <div class="clearfix"> </div>
        <!-- END HEADER & CONTENT DIVIDER -->
        <!-- BEGIN CONTAINER -->
        <div class="page-container">
            <!-- BEGIN SIDEBAR -->
            
                <jsp:include page="${inc_dir}/page-sidebar.jsp"></jsp:include>
            	<!-- END SIDEBAR -->
            <!-- BEGIN CONTENT -->
            <div class="page-content-wrapper">
                <!-- BEGIN CONTENT BODY -->
                <div class="page-content">
                    <!-- BEGIN PAGE HEADER-->
                    <!-- BEGIN THEME PANEL -->
                    <jsp:include page="${inc_dir}/theme-panel.jsp"></jsp:include>
                    <!-- END THEME PANEL -->
                    <h1 class="page-title">Event System <small> manage news</small></h1>
                    <div class="page-bar">
                        <ul class="page-breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="#">Home</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="eventsDashboard">Events</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="#">News</a>
						</li>
					</ul>
                        <div class="page-toolbar">
                            <div class="btn-group pull-right">
                                <button type="button" class="btn btn-fit-height grey-salt dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="1000" data-close-others="true"> Actions
                                    <i class="fa fa-angle-down"></i>
                                </button>
                                <ul class="dropdown-menu pull-right" role="menu">
                                    <li>
                                        <a href="#">
                                            <i class="icon-bell"></i> Action</a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <i class="icon-shield"></i> Another action</a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <i class="icon-user"></i> Something else here</a>
                                    </li>
                                    <li class="divider"> </li>
                                    <li>
                                        <a href="#">
                                            <i class="icon-bag"></i> Separated link</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!-- END PAGE HEADER-->
                    <div class="row">
                        <div class="col-md-12">
                            <form class="form-horizontal form-row-seperated" action="#">
                                <div class="portlet">
                                    <div class="portlet-title">
                                        <div class="caption">
                                            <i class="fa fa-shopping-cart"></i>Edit News<span class="caption-helper"> editing news details, associated medias, reviews, etc.</span> </div>
                                        <div class="actions btn-set">
                                            <button type="button" name="back" class="btn btn-secondary-outline" onclick="backToNewsList(); return false;">
                                                <i class="fa fa-angle-left"></i> Back</button>
                                            <button class="btn btn-secondary-outline" onclick="resetCreateNews(); return false;">
                                                <i class="fa fa-reply"></i> Reset</button>
                                            <button class="btn btn-success" onclick="createNews(); return false;">
                                                <i class="fa fa-check"></i> Save</button>
                                            <button class="btn btn-success" onclick="return false;">
                                                <i class="fa fa-check-circle"></i> Save &amp; Continue Edit</button>
                                            <div class="btn-group">
                                                <a class="btn btn-success dropdown-toggle" href="javascript:;" data-toggle="dropdown">
                                                    <i class="fa fa-share"></i> More
                                                    <i class="fa fa-angle-down"></i>
                                                </a>
                                                <div class="dropdown-menu pull-right">
                                                	<ul>
	                                                    <li><a href="javascript:;"> Duplicate </a></li>
	                                                    <li><a href="javascript:;"> Delete </a></li>
	                                                    <li class="dropdown-divider"> </li>
	                                                    <li><a href="javascript:;"> Print </a></li>
                                                   	</ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="portlet-body">
                                        <div class="tabbable-bordered">
                                            <ul class="nav nav-tabs">
                                                <li class="active"><a href="#tab_general" data-toggle="tab"> General </a></li>
                                            </ul>
                                            <div class="tab-content">
                                                <div class="tab-pane active" id="tab_general">
												<div class="form-body">
													<div class="form-group">
														<label class="col-md-2 control-label">Global ID: <span class="required">
														* </span>
														</label>
														<div class="col-md-10">
															<input type="text" class="form-control" id="globalId" name="globalId" placeholder="" disabled="disabled">
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-2 control-label">Event UUID: <span class="required">
														* </span>
														</label>
														<div class="col-md-10">
															<input type="text" class="form-control" id="eventUUID" name="eventUUID" placeholder="" disabled="disabled">
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-2 control-label">Event Title: <span class="required">
														* </span>
														</label>
														<div class="col-md-10">
															<input type="text" class="form-control" id="title" name="title" placeholder="">
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-2 control-label">Author: <span class="required">
														* </span>
														</label>
														<div class="col-md-10">
															<input type="text" class="form-control" id="author" name="author" placeholder="">
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-2 control-label">Create Datetime: <span class="required">
														* </span>
														</label>
														<div class="col-md-10">
															<div class="input-group input-large date-picker input-daterange" data-date="10/11/2012" data-date-format="mm/dd/yyyy">
																<input type="text" class="form-control" id="postDatetime" name="postDatetime" disabled="disabled">
															</div>
															<span class="help-block">
															availability daterange. </span>
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-2 control-label">Number of Views: <span class="required">
														* </span>
														</label>
														<div class="col-md-10">
															<input type="text" class="form-control" id="viewNum" name="viewNum" placeholder="" disabled="disabled" value="0">
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-2 control-label">Short Description: <span class="required">
														* </span>
														</label>
														<div class="col-md-10">
															<textarea class="form-control" id="descShort" name="descShort"></textarea>
															<span class="help-block">shown in abstract section </span>
														</div>
														
													</div>
													
															<div class="form-group">
														<label class="col-md-2 control-label">Long Description: <span class="required">
														* </span>
														</label>
														<div class="col-md-10">
															<textarea class="form-control" id="descLong" name="descLong" rows="6"></textarea>
															<span class="help-block">shown in detail section </span>
														</div>
														
													</div>
													
													<div class="form-group">
														<label class="col-md-2 control-label">News Class: <span class="required">
														* </span>
														</label>
														<div class="col-md-10">
															<select class="table-group-action-input form-control input-medium" id="eventClass" name="eventClass">
																<option value="0">Select...</option>
																<option value="1">Default</option>
																<option value="2">New</option>
																<option value="3">Hot</option>
															</select>
														</div>
													</div>
													
													<div class="form-group">
														<label class="col-md-2 control-label">News Status: <span class="required">
														* </span>
														</label>
														<div class="col-md-10">
															<select class="table-group-action-input form-control input-medium" id="eventStatus" name="eventStatus">
																<option value="0">Select...</option>
																<option value="1">Published</option>
																<option value="2">Wait to post</option>
																<option value="3">Deleted</option>
																<option value="4">Out of date</option>
																<option value="5">Suspended</option>
															</select>
														</div>
													</div>
												</div>
												</div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- END CONTENT BODY -->
            </div>
            <!-- END CONTENT -->
            <!-- BEGIN QUICK SIDEBAR -->
            <!-- Removed to quick_sidebar.html -->
            <!-- END QUICK SIDEBAR -->
        </div>
      
        <!-- END CONTAINER -->
        <!-- BEGIN FOOTER -->
        <jsp:include page="${inc_dir}/page-footer.jsp"></jsp:include>
        <!-- END FOOTER -->
        <!-- BEGIN QUICK NAV -->
        
        <!-- END QUICK NAV -->
<!--[if lt IE 9]>
<script src="${webapp_name}/assets/global/plugins/respond.min.js"></script>
<script src="${webapp_name}/assets/global/plugins/excanvas.min.js"></script> 
<script src="${webapp_name}/assets/global/plugins/ie8.fix.min.js"></script> 
<![endif]-->
<!-- BEGIN CORE PLUGINS -->
<script src="${webapp_name}/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/js.cookie.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="${webapp_name}/assets/global/scripts/datatable.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/datatables/datatables.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/bootstrap-maxlength/bootstrap-maxlength.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/fancybox/source/jquery.fancybox.pack.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/global/plugins/plupload/js/plupload.full.min.js" type="text/javascript"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN THEME GLOBAL SCRIPTS -->
<script src="${webapp_name}/assets/global/scripts/app.min.js" type="text/javascript"></script>
<!-- END THEME GLOBAL SCRIPTS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script type="text/javascript" src="${webapp_name}/assets/pages/scripts-local/event-news.js"></script>
<script type="text/javascript" src="${webapp_name}/assets/pages/scripts-local/global-validate.js"></script>
<script type="text/javascript" src="${webapp_name}/assets/pages/scripts-local/event-news-create.js"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<!-- BEGIN THEME LAYOUT SCRIPTS -->
<script src="${webapp_name}/assets/layouts/layout2/scripts/layout.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/layouts/layout2/scripts/demo.min.js" type="text/javascript"></script>
<!-- 
<script src="${webapp_name}/assets/layouts/global/scripts/quick-sidebar.min.js" type="text/javascript"></script>
<script src="${webapp_name}/assets/layouts/global/scripts/quick-nav.min.js" type="text/javascript"></script>
 -->
<!-- END THEME LAYOUT SCRIPTS -->
<script>

</script>
</body>

</html>