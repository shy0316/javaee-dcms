<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">

	<head>
	
		<!-- Basic -->
    	<meta charset="UTF-8" />

		<title>学科竞赛管理系统</title>
		
		<!-- Mobile Metas -->
	    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		
		<!-- Favicon and touch icons -->
		<link rel="shortcut icon" href="assets/ico/favicon.ico" type="image/x-icon" />
		<link rel="apple-touch-icon" href="assets/ico/apple-touch-icon.png" />
		<link rel="apple-touch-icon" sizes="57x57" href="assets/ico/apple-touch-icon-57x57.png" />
		<link rel="apple-touch-icon" sizes="72x72" href="assets/ico/apple-touch-icon-72x72.png" />
		<link rel="apple-touch-icon" sizes="76x76" href="assets/ico/apple-touch-icon-76x76.png" />
		<link rel="apple-touch-icon" sizes="114x114" href="assets/ico/apple-touch-icon-114x114.png" />
		<link rel="apple-touch-icon" sizes="120x120" href="assets/ico/apple-touch-icon-120x120.png" />
		<link rel="apple-touch-icon" sizes="144x144" href="assets/ico/apple-touch-icon-144x144.png" />
		<link rel="apple-touch-icon" sizes="152x152" href="assets/ico/apple-touch-icon-152x152.png" />
		
	    <!-- start: CSS file-->
		
		<!-- Vendor CSS-->
		<link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
		<link href="assets/vendor/skycons/css/skycons.css" rel="stylesheet" />
		<link href="assets/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
		
		<!-- Plugins CSS-->
		<link href="assets/plugins/bootkit/css/bootkit.css" rel="stylesheet" />	
		<link href="assets/plugins/bootstrap-datepicker/css/datepicker3.css" rel="stylesheet" />
		<link href="assets/plugins/bootstrap-datepicker/css/datepicker-theme.css" rel="stylesheet" />
		<link href="assets/plugins/bootstrap-timepicker/css/bootstrap-timepicker.css" rel="stylesheet" />
		<link href="assets/plugins/bootstrap-colorpicker/css/bootstrap-colorpicker.css" rel="stylesheet" />
		<link href="assets/plugins/bootstrap-tagsinput/css/bootstrap-tagsinput.css" rel="stylesheet" />
		
		<!-- Theme CSS -->
		<link href="assets/css/jquery.mmenu.css" rel="stylesheet" />
		
		<!-- Page CSS -->
		<link href="assets/css/style.css" rel="stylesheet" />		
		
		<!-- end: CSS file-->	
	    
		
		<!-- Head Libs -->
		<script src="assets/plugins/modernizr/js/modernizr.js"></script>
		
		<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
			<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
			<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->		
		
	</head>
	
	<body>
	
		<!-- Start: Header -->
		<div class="navbar" role="navigation">
			<div class="container-fluid container-nav">
				<!-- Navbar Action -->
				<ul class="nav navbar-nav navbar-actions navbar-left">
					<li class="visible-md visible-lg"><a href="index_manage.jsp#" id="main-menu-toggle"><i class="fa fa-th-large"></i></a></li>
					<li class="visible-xs visible-sm"><a href="index_manage.jsp#" id="sidebar-menu"><i class="fa fa-navicon"></i></a></li>			
				</ul>
				<!-- Navbar Left -->
				<div class="navbar-left">
					<!-- Search Form -->					
					<form class="search navbar-form">
						<div class="input-group input-search">
							<input type="text" class="form-control" name="q" id="q" placeholder="Search...">
							<span class="input-group-btn">
								<button class="btn btn-default" type="submit"><i class="fa fa-search"></i></button>
							</span>
						</div>						
					</form>
				</div>
				<!-- Navbar Right -->
				<div class="navbar-right">
					<!-- Notifications -->
					<ul class="notifications hidden-sm hidden-xs">
						<li>
							<a href="#" class="dropdown-toggle notification-icon" data-toggle="dropdown">
								<i class="fa fa-tasks"></i>
								<span class="badge">10</span>
							</a>
							<ul class="dropdown-menu update-menu" role="menu">
								<li><a href="#"><i class="fa fa-database bk-fg-primary"></i> Database </a></li>
								<li><a href="#"><i class="fa fa-bar-chart-o bk-fg-primary"></i> Connection </a></li>
								<li><a href="#"><i class="fa fa-bell bk-fg-primary"></i> Notification </a></li>
								<li><a href="#"><i class="fa fa-envelope bk-fg-primary"></i> Message </a></li>
								<li><a href="#"><i class="fa fa-flash bk-fg-primary"></i> Traffic </a></li>
								<li><a href="#"><i class="fa fa-credit-card bk-fg-primary"></i> Invoices </a></li>
								<li><a href="#"><i class="fa fa-dollar bk-fg-primary"></i> Finances </a></li>
								<li><a href="#"><i class="fa fa-thumbs-o-up bk-fg-primary"></i> Orders </a></li>
								<li><a href="#"><i class="fa fa-folder bk-fg-primary"></i> Directories </a></li>
								<li><a href="#"><i class="fa fa-users bk-fg-primary"></i> Users </a></li>		
							</ul>
						</li>
						<li>
							<a href="#" class="dropdown-toggle notification-icon" data-toggle="dropdown">
								<i class="fa fa-envelope"></i>
								<span class="badge">5</span>
							</a>
							<ul class="dropdown-menu">
								<li class="dropdown-menu-header">
									<strong>Messages</strong>
									<div class="progress progress-xs  progress-striped active">
										<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
											60%
										</div>
									</div>
								</li>
								<li class="avatar">
									<a href="page-inbox.html">
										<img class="avatar" src="assets/img/avatar1.jpg" alt="" />
										<div><div class="point point-primary point-lg"></div>New message</div>
										<span><small>1 minute ago</small></span>							
									</a>
								</li>
								<li class="avatar">
									<a href="page-inbox.html">
										<img class="avatar" src="assets/img/avatar2.jpg" alt="" />
										<div><div class="point point-primary point-lg"></div>New message</div>
										<span><small>3 minute ago</small></span>								
									</a>
								</li>
								<li class="avatar">
									<a href="page-inbox.html">
										<img class="avatar" src="assets/img/avatar3.jpg" alt="" />
										<div><div class="point point-primary point-lg"></div>New message</div>
										<span><small>4 minute ago</small></span>								
									</a>
								</li>
								<li class="avatar">
									<a href="page-inbox.html">
										<img class="avatar" src="assets/img/avatar4.jpg" alt="" />
										<div><div class="point point-primary point-lg"></div>New message</div>
										<span><small>30 minute ago</small></span>
									</a>
								</li>
								<li class="avatar">
									<a href="page-inbox.html">
										<img class="avatar" src="assets/img/avatar5.jpg" alt="" />
										<div><div class="point point-primary point-lg"></div>New message</div>
										<span><small>1 hours ago</small></span>
									</a>
								</li>						
								<li class="dropdown-menu-footer text-center">
									<a href="page-inbox.html">View all messages</a>
								</li>	
							</ul>
						</li>
						<li>
							<a href="#" class="dropdown-toggle notification-icon" data-toggle="dropdown">
								<i class="fa fa-bell"></i>
								<span class="badge">3</span>
							</a>
							<ul class="dropdown-menu list-group">
								<li class="dropdown-menu-header">
									<strong>Notifications</strong>
									<div class="progress progress-xs  progress-striped active">
										<div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
											60%
										</div>
									</div>
								</li>
								<li class="list-item">
									<a href="page-inbox.html">
										<div class="pull-left">
										   <i class="fa fa-envelope-o bk-fg-primary"></i>
										</div>
										<div class="media-body clearfix">
											<div>Unread Message</div>
											<h6>You have 10 unread message</h6>
										</div>								
									</a>
								</li>
								<li class="list-item">
									<a href="#">
										<div class="pull-left">
										   <i class="fa fa-cogs bk-fg-primary"></i>
										</div>
										<div class="media-body clearfix">
											<div>New Settings</div>
											<h6>There are new settings available</h6>
										</div>								
									</a>
								</li>
								<li class="list-item">
									<a href="#">
										<div class="pull-left">
										   <i class="fa fa-fire bk-fg-primary"></i>
										</div>
										<div class="media-body clearfix">
											<div>Update</div>
											<h6>There are new updates available</h6>
										</div>								
									</a>
								</li>
								<li class="list-item-last">
									<a href="#">
									  <h6>Unread notifications</h6>
									  <span class="badge">15</span>
								   </a>
								</li>
							</ul>
						</li>
					</ul>
					<!-- End Notifications -->
					<!-- Userbox -->
					<div class="userbox">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							<div class="profile-info">
								<span class="name">赵小明</span>
								<span class="role">管理员</span>
							</div>			
							<i class="fa custom-caret"></i>
						</a>
						<div class="dropdown-menu">
							<ul class="list-unstyled">
								<li class="dropdown-menu-header bk-bg-white bk-margin-top-15">						
									<div class="progress progress-xs  progress-striped active">
										<div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
											60%
										</div>
									</div>							
								</li>	
								<li>
									<a href="page-profile.html"><i class="fa fa-user"></i> Profile</a>
								</li>
								<li>
									<a href="#"><i class="fa fa-wrench"></i> Settings</a>
								</li>
								<li>
									<a href="page-invoice"><i class="fa fa-usd"></i> Payments</a>
								</li>
								<li>
									<a href="#"><i class="fa fa-file"></i> File</a>
								</li>
								<li>
									<a href="indexshowNews.action"><i class="fa fa-power-off"></i> Logout</a>
								</li>
							</ul>
						</div>						
					</div>
					<!-- End Userbox -->
				</div>
				<!-- End Navbar Right -->
			</div>		
		</div>
		<!-- End: Header -->
		
		<!-- Start: Content -->
		<div class="container-fluid content">	
			<div class="row">
			
				<!-- Sidebar -->
				<div class="sidebar">
					<div class="sidebar-collapse">
						<!-- Sidebar Header Logo-->
						<div class="sidebar-header">
							<img src="assets/img/logo.png" class="img-responsive" alt="" />
						</div>
						<!-- Sidebar Menu-->
						<div class="sidebar-menu">						
							<nav id="menu" class="nav-main" role="navigation">
								<ul class="nav nav-sidebar">
									<div class="panel-body text-center">								
										<div class="bk-avatar">
											<img src="assets/img/avatar.jpg" class="img-circle bk-img-60" alt="" />
										</div>
										<div class="bk-padding-top-10">
											<i class="fa fa-circle text-success"></i> <small>管理员</small>
										</div>
									</div>
									<div class="divider2"></div>
									<li>
										<a href="index_manage.jsp">
											<i class="icon fa fa-home" aria-hidden="true"></i><span>首页</span>
										</a>
									</li>
									<li>
										<a href="">
											<span class="pull-right label label-primary">3</span>
											<i class="fa fa-envelope" aria-hidden="true"></i><span>消息</span>
										</a>
									</li>
									<li class="nav-parent">
										<a>
											<i class="fa fa-copy" aria-hidden="true"></i><span>公告信息</span>
										</a>
										<ul class="nav nav-children">
											<li><a href="noticemanage_add.jsp"><span class="text"> 公告录入</span></a></li>
											<li><a href="searchnotice.action"><span class="text"> 公告管理</span></a></li>						
										</ul>
									</li>
									<li class="nav-parent nav-expanded active">
										<a>
											<i class="fa fa-list-alt" aria-hidden="true"></i><span>新闻信息</span>
										</a>
										<ul class="nav nav-children">
											<li><a href="newsManage_add.jsp"><span class="text"> 新闻录入</span></a></li>
											<li><a href="showNews.action"><span class="text"> 新闻管理</span></a></li>
										</ul>
									</li>
									<li class="nav-parent">
										<a>
											<i class="fa fa-random" aria-hidden="true"></i><span>学科竞赛</span>
										</a>
										<ul class="nav nav-children">
											<li><a href="Competition-add.jsp"><span class="text"> 竞赛录入</span></a></li>
											<li><a href="Competition-index.jsp"><span class="text"> 竞赛管理</span></a></li>
											<li><a href="discipline"><span class="text"> 竞赛推荐</span></a></li>
										</ul>
									</li>
									<li class="nav-parent">
										<a>
											<i class="fa fa-tasks" aria-hidden="true"></i><span>参赛学生</span>
										</a>
										<ul class="nav nav-children">
											<li><a href="joinComQuery"><span class="text"> 参赛查询</span></a></li>
										</ul>
									</li>
									<li>
										<a href="">
											<i class="fa fa-life-bouy" aria-hidden="true"></i><span>账户设置</span>
										</a>
									</li>
								</ul>
							</nav>
						</div>
						<!-- End Sidebar Menu-->
					</div>
					<!-- Sidebar Footer-->
					<div class="sidebar-footer">		
						<ul class="sidebar-terms">
							<li><a href="index.html#">Terms</a></li>
							<li><a href="index.html#">Privacy</a></li>
							<li><a href="index.html#">Help</a></li>
							<li><a href="index.html#">About</a></li>
						</ul>
						<div class="copyright text-center">
							<small><a href="http://http://www.njxzc.edu.cn/" target="_blank">南京晓庄学院</a>信息工程学院 <a href="http://http://www.njxzc.edu.cn/" target="_blank"><br>学科竞赛管理系统</a> </small>
						</div>					
					</div>
					<!-- End Sidebar Footer-->
				</div>
				<!-- End Sidebar -->			
		
				<!-- Main Page -->
				<div class="main ">
					<!-- Page Header -->
					<div class="page-header">
						<div class="pull-left">
							<ol class="breadcrumb visible-sm visible-md visible-lg">								
								<li><a href="index_manage.jsp"><i class="icon fa fa-home"></i>首页</a></li>
							</ol>						
						</div>
						<div class="pull-right">
							<h2>Home</h2>
						</div>					
					</div>
					<!-- End Page Header -->
					<div class="row">
						<!-- 新闻模块 开始 -->
						<div class="col-md-7 col-xs-7">
							<div class="panel bk-widget bk-border-off bk-noradius">
								<div class="panel-body bk-bg-very-light-gray text-center bk-padding-top-10 bk-padding-bottom-10">
									<div class="row">
										<div class="col-xs-8 text-left bk-vcenter">
											<h6 class="bk-margin-off">新闻动态</h6>
										</div>
										<div class="col-xs-4 bk-vcenter text-right">
											<i class="fa fa-file-text-o"></i>
										</div>
									</div>
								</div>
								<hr class="bk-margin-off">
								<!-- <s:iterator value="list" id="x" status="st">
	                              <s:if test="#st.Count <= 6">
		                       		  <a class="panel-body bk-bg-very-light-gray bk-bg-lighten bk-padding-off-top bk-padding-off-bottom">
										<div class="row">
											<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12 bk-vcenter bk-padding-top-10 bk-padding-bottom-10">
												<div class="bk-round bk-border-off bk-bg-darken bk-icon bk-icon-x bk-icon-default bk-bg-primary">
													<i class="fa fa-chevron-right fa-x"></i>
												</div>
											</div>
											<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 bk-vcenter">
												<div class="row">
													<div class="col-xs-7 text-left bk-fg-primary bk-fg-darken bk-margin-off-bottom">
													<h6>
														<a href="news/newsContent.action?news.newsTitle=<s:property value="newsTitle"/>"> <s:property value="newsTitle" /></a>
													</h6></div>
													<div class="col-xs-2 text-left"><span><s:property value="#x.newsIssuer" /></span></div>
													<div class="col-xs-3 text-left"><span><s:property value="#x.newsIssuedate" /></span></div>
												</div>
											</div>
										</div>
									 </a>
									 <hr class="bk-margin-off">
	                       		  </s:if> 
	            				</s:iterator>-->
								<a class="panel-body bk-bg-very-light-gray bk-bg-lighten bk-padding-off-top bk-padding-off-bottom">
									<div class="row">
										<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12 bk-vcenter bk-padding-top-10 bk-padding-bottom-10">
											<div class="bk-round bk-border-off bk-bg-darken bk-icon bk-icon-x bk-icon-default bk-bg-primary">
												<i class="fa fa-chevron-right fa-x"></i>
											</div>
										</div>
										<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 bk-vcenter">
											<div class="row">
												<div class="col-xs-7 text-left bk-fg-primary bk-fg-darken bk-margin-off-bottom">
												<h6>关于2016年全国中学生学科奥林匹克竞赛管理工作会召开</h6></div>
												<div class="col-xs-2 text-left"><span>教务处</span></div>
												<div class="col-xs-3 text-left"><span>2016-10-02</span></div>
											</div>
										</div>
									</div>
								</a>
								<hr class="bk-margin-off" />
								<a class="panel-body bk-bg-very-light-gray bk-bg-lighten bk-padding-off-top bk-padding-off-bottom">
									<div class="row">
										<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12 bk-vcenter bk-padding-top-10 bk-padding-bottom-10">
											<div class="bk-round bk-border-off bk-bg-darken bk-icon bk-icon-x bk-icon-default bk-bg-primary">
												<i class="fa fa-chevron-right fa-x"></i>
											</div>
										</div>
										<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 bk-vcenter">
											<div class="row">
												<div class="col-xs-7 text-left bk-fg-primary bk-fg-darken bk-margin-off-bottom">
												<h6>关于2016年全国中学生学科奥林匹克竞赛管理工作会召开</h6></div>
												<div class="col-xs-2 text-left"><span>教务处</span></div>
												<div class="col-xs-3 text-left"><span>2016-10-02</span></div>
											</div>
										</div>
									</div>
								</a>
								<hr class="bk-margin-off" />
								<a class="panel-body bk-bg-very-light-gray bk-bg-lighten bk-padding-off-top bk-padding-off-bottom">
									<div class="row">
										<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12 bk-vcenter bk-padding-top-10 bk-padding-bottom-10">
											<div class="bk-round bk-border-off bk-bg-darken bk-icon bk-icon-x bk-icon-default bk-bg-primary">
												<i class="fa fa-chevron-right fa-x"></i>
											</div>
										</div>
										<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 bk-vcenter">
											<div class="row">
												<div class="col-xs-7 text-left bk-fg-primary bk-fg-darken bk-margin-off-bottom">
												<h6>关于2016年全国中学生学科奥林匹克竞赛管理工作会召开</h6></div>
												<div class="col-xs-2 text-left"><span>教务处</span></div>
												<div class="col-xs-3 text-left"><span>2016-10-02</span></div>
											</div>
										</div>
									</div>
								</a>
								<hr class="bk-margin-off" />
								<a class="panel-body bk-bg-very-light-gray bk-bg-lighten bk-padding-off-top bk-padding-off-bottom">
									<div class="row">
										<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12 bk-vcenter bk-padding-top-10 bk-padding-bottom-10">
											<div class="bk-round bk-border-off bk-bg-darken bk-icon bk-icon-x bk-icon-default bk-bg-primary">
												<i class="fa fa-chevron-right fa-x"></i>
											</div>
										</div>
										<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 bk-vcenter">
											<div class="row">
												<div class="col-xs-7 text-left bk-fg-primary bk-fg-darken bk-margin-off-bottom">
												<h6>关于2016年全国中学生学科奥林匹克竞赛管理工作会召开</h6></div>
												<div class="col-xs-2 text-left"><span>教务处</span></div>
												<div class="col-xs-3 text-left"><span>2016-10-02</span></div>
											</div>
										</div>
									</div>
								</a>
								<hr class="bk-margin-off" />
								<a class="panel-body bk-bg-very-light-gray bk-bg-lighten bk-padding-off-top bk-padding-off-bottom">
									<div class="row">
										<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12 bk-vcenter bk-padding-top-10 bk-padding-bottom-10">
											<div class="bk-round bk-border-off bk-bg-darken bk-icon bk-icon-x bk-icon-default bk-bg-primary">
												<i class="fa fa-chevron-right fa-x"></i>
											</div>
										</div>
										<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 bk-vcenter">
											<div class="row">
												<div class="col-xs-7 text-left bk-fg-primary bk-fg-darken bk-margin-off-bottom">
												<h6>关于公示全国中学生五项学科竞赛获奖学生名单的通知</h6></div>
												<div class="col-xs-2 text-left"><span>教务处</span></div>
												<div class="col-xs-3 text-left"><span>2016-10-02</span></div>
											</div>
										</div>
									</div>
								</a>
								<hr class="bk-margin-off" />
								<a class="panel-body bk-bg-very-light-gray bk-bg-lighten bk-padding-off-top bk-padding-off-bottom">
									<div class="row">
										<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12 bk-vcenter bk-padding-top-10 bk-padding-bottom-10">
											<div class="bk-round bk-border-off bk-bg-darken bk-icon bk-icon-x bk-icon-default bk-bg-primary">
												<i class="fa fa-chevron-right fa-x"></i>
											</div>
										</div>
										<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 bk-vcenter">
											<div class="row">
												<div class="col-xs-7 text-left bk-fg-primary bk-fg-darken bk-margin-off-bottom">
												<h6>关于做好2015年全国中学生五项学科竞赛（决赛）组</h6></div>
												<div class="col-xs-2 text-left"><span>教务处</span></div>
												<div class="col-xs-3 text-left"><span>2016-10-02</span></div>
											</div>
										</div>
									</div>
								</a>
								<hr class="bk-margin-off" />
								<a class="panel-body bk-bg-very-light-gray bk-bg-lighten bk-padding-off-top bk-padding-off-bottom">
									<div class="row">
										<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12 bk-vcenter bk-padding-top-10 bk-padding-bottom-10">
											<div class="bk-round bk-border-off bk-bg-darken bk-icon bk-icon-x bk-icon-default bk-bg-primary">
												<i class="fa fa-chevron-right fa-x"></i>
											</div>
										</div>
										<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 bk-vcenter">
											<div class="row">
												<div class="col-xs-7 text-left bk-fg-primary bk-fg-darken bk-margin-off-bottom">
												<h6>关于做好2015年全国中学生五项学科竞赛（决赛）组</h6></div>
												<div class="col-xs-2 text-left"><span>教务处</span></div>
												<div class="col-xs-3 text-left"><span>2016-10-02</span></div>
											</div>
										</div>
									</div>
								</a>
								<hr class="bk-margin-off" />
								<a class="panel-body bk-bg-very-light-gray bk-bg-lighten bk-padding-off-top bk-padding-off-bottom">
									<div class="row">
										<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12 bk-vcenter bk-padding-top-10 bk-padding-bottom-10">
											<div class="bk-round bk-border-off bk-bg-darken bk-icon bk-icon-x bk-icon-default bk-bg-primary">
												<i class="fa fa-chevron-right fa-x"></i>
											</div>
										</div>
										<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 bk-vcenter">
											<div class="row">
												<div class="col-xs-7 text-left bk-fg-primary bk-fg-darken bk-margin-off-bottom">
												<h6>关于做好2015年全国中学生五项学科竞赛（决赛）组</h6></div>
												<div class="col-xs-2 text-left"><span>教务处</span></div>
												<div class="col-xs-3 text-left"><span>2016-10-02</span></div>
											</div>
										</div>
									</div>
								</a>
								<hr class="bk-margin-off" /> 
								
								<div class="panel-body bk-bg-very-light-gray bk-padding-top-5 bk-padding-bottom-5 ">
									<div class="row">
										<div class="col-xs-6 text-right">
											<a href="showNews.action" class="bk-fg-textcolor"><small>more <i class="fa fa-angle-right"></i></small></a>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- 新闻模块 结束 -->
						<!-- 公告模块 开始 -->
						<div class="col-md-5">
							<!-- 公告模块 开始 -->
							<div class="row">
								<div class="col-md-12">
									<div class="panel bk-widget bk-border-off bk-noradius bk-webkit-fix">
										<div class="panel-body bk-bg-very-light-gray text-center bk-padding-top-10 bk-padding-bottom-10">
											<div class="row">
												<div class="col-xs-8 text-left bk-vcenter">
													<h6 class="bk-margin-off"><i class="fa fa-bullhorn"></i> 公告信息</h6>
												</div>
												<div class="col-xs-4 bk-vcenter text-right">
													<a class="right carousel-control bk-carousel-control bk-carousel-control-white bk-carousel-left" href="#carousel-example-generic2" role="button" data-slide="prev">
														<span class="fa fa-arrow-circle-o-left icon-prev"></span>
													</a>
													<a class="right carousel-control bk-carousel-control bk-carousel-control-white bk-carousel-right" href="#carousel-example-generic2" role="button" data-slide="next">
														<span class="fa fa-angle-right icon-next"></span>
													</a>
												</div>
											</div>
										</div>
										<hr class="bk-margin-off" />
										<div class="bs-example">
											<div id="carousel-example-generic2" class="carousel slide" data-ride="carousel">
												<div class="carousel-inner">
													<div class="item active">
														<a class="panel-body bk-bg-very-light-gray bk-bg-lighten bk-padding-off-top bk-padding-off-bottom">
															<div class="pull-left bk-margin-top-10 bk-margin-right-10">
																<div class="bk-round bk-bg-darken bk-border-off bk-icon bk-icon-x bk-icon-default bk-bg-primary">
																	<i class="fa fa-facebook fa-x"></i>
																</div>
															</div>
															<h5 class="bk-fg-primary bk-fg-darken bk-margin-off-bottom"><strong>2016-09-01</strong></h5>
															<p>
																<small>2016-10-24 00：00-4：00未系统维护时间，如带来不便，请谅解！</small>
															</p>
														</a>
														<hr class="bk-margin-off" />
														<div class="panel-body bk-bg-very-light-gray bk-padding-5 text-center">
															<a href="#" class="bk-fg-primary bk-fg-lighten"><small><i class="fa fa-file-text-o"></i> MORE UPDATE</small></a>
														</div>
													</div>
													<div class="item">
														<a class="panel-body bk-bg-very-light-gray bk-bg-lighten bk-padding-off-top bk-padding-off-bottom">
															<div class="pull-left bk-margin-top-10 bk-margin-right-10">
																<div class="bk-round bk-bg-darken bk-border-off bk-icon bk-icon-x bk-icon-default bk-bg-info">
																	<i class="fa fa-twitter fa-x"></i>
																</div>
															</div>
															<h5 class="bk-fg-info bk-fg-darken bk-margin-off-bottom"><strong>2016-10-12</strong></h5>
															<p>
																<small>某某某大赛的报名截止时间为2016-10-25，请同学们抓紧时间填报报名表上交至教务处。</small>
															</p>
														</a>
														<hr class="bk-margin-off" />
														<div class="panel-body bk-bg-very-light-gray bk-padding-5 text-center">
															<a href="#" class="bk-fg-info bk-fg-lighten"><small><i class="fa fa-file-text-o"></i> MORE UPDATE</small></a>
														</div>
													</div>
													<div class="item">
														<a class="panel-body bk-bg-very-light-gray bk-bg-lighten bk-padding-off-top bk-padding-off-bottom">
															<div class="pull-left bk-margin-top-10 bk-margin-right-10">
																<div class="bk-round bk-bg-darken bk-border-off bk-icon bk-icon-x bk-icon-default bk-bg-danger">
																	<i class="fa fa-google-plus fa-x"></i>
																</div>
															</div>
															<h5 class="bk-fg-danger bk-fg-darken bk-margin-off-bottom"><strong>2016-10-20</strong></h5>
															<p>
																<small>学生登录的用户名是学号，密码为身份证后六位。请及时修改密码，若有疑问请咨询王老师。</small>
															</p>
														</a>
														<hr class="bk-margin-off" />
														<div class="panel-body bk-bg-very-light-gray bk-padding-5 text-center">
															<a href="#" class="bk-fg-danger bk-fg-lighten"><small><i class="fa fa-file-text-o"></i> MORE UPDATE</small></a>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- 公告模块 结束 -->
							<!-- 竞赛信息模块 开始 -->
							<div class="row">
								<div class="col-md-12">
									<div class="panel bk-widget bk-border-off bk-noradius">
										<div class="panel-body bk-bg-very-light-gray text-center bk-padding-top-10 bk-padding-bottom-10">
											<div class="row">
												<div class="col-xs-8 text-left bk-vcenter">
													<h6 class="bk-margin-off">竞赛信息</h6>
												</div>
												<div class="col-xs-4 bk-vcenter text-right">
													<i class="fa fa-file-text-o"></i>
												</div>
											</div>
										</div>
										<hr class="bk-margin-off" />
										<a class="panel-body bk-bg-very-light-gray bk-bg-lighten bk-padding-off-top bk-padding-off-bottom">
											<div class="row">
												<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12 bk-vcenter bk-padding-top-10 bk-padding-bottom-10">
													<div class="bk-round bk-border-off bk-bg-darken bk-icon bk-icon-x bk-icon-default bk-bg-danger">
														<i class="fa fa-hand-o-right fa-x"></i>
													</div>
												</div>
												<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 bk-vcenter">
													<div class="row">
														<div class="col-xs-7 text-left bk-fg-primary bk-fg-darken bk-margin-off-bottom">
														<h6>江苏省软件设计大赛</h6></div>
														<div class="col-xs-3 text-left"><span>2016-10-02</span></div>
													</div>
												</div>
											</div>
										</a>
										<hr class="bk-margin-off" />
										<a class="panel-body bk-bg-very-light-gray bk-bg-lighten bk-padding-off-top bk-padding-off-bottom">
											<div class="row">
												<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12 bk-vcenter bk-padding-top-10 bk-padding-bottom-10">
													<div class="bk-round bk-border-off bk-bg-darken bk-icon bk-icon-x bk-icon-default bk-bg-danger">
														<i class="fa fa-hand-o-right fa-x"></i>
													</div>
												</div>
												<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 bk-vcenter">
													<div class="row">
														<div class="col-xs-7 text-left bk-fg-primary bk-fg-darken bk-margin-off-bottom">
														<h6>中国高校挑战杯大赛</h6></div>
														<div class="col-xs-3 text-left"><span>2016-10-02</span></div>
													</div>
												</div>
											</div>
										</a>
										<hr class="bk-margin-off" />
										<a class="panel-body bk-bg-very-light-gray bk-bg-lighten bk-padding-off-top bk-padding-off-bottom">
											<div class="row">
												<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12 bk-vcenter bk-padding-top-10 bk-padding-bottom-10">
													<div class="bk-round bk-border-off bk-bg-darken bk-icon bk-icon-x bk-icon-default bk-bg-danger">
														<i class="fa fa-hand-o-right fa-x"></i>
													</div>
												</div>
												<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 bk-vcenter">
													<div class="row">
														<div class="col-xs-7 text-left bk-fg-primary bk-fg-darken bk-margin-off-bottom">
														<h6>acm国际大赛</h6></div>
														<div class="col-xs-3 text-left"><span>2016-10-02</span></div>
													</div>
												</div>
											</div>
										</a>
										<hr class="bk-margin-off" />
										<a class="panel-body bk-bg-very-light-gray bk-bg-lighten bk-padding-off-top bk-padding-off-bottom">
											<div class="row">
												<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12 bk-vcenter bk-padding-top-10 bk-padding-bottom-10">
													<div class="bk-round bk-border-off bk-bg-darken bk-icon bk-icon-x bk-icon-default bk-bg-danger">
														<i class="fa fa-hand-o-right fa-x"></i>
													</div>
												</div>
												<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 bk-vcenter">
													<div class="row">
														<div class="col-xs-7 text-left bk-fg-primary bk-fg-darken bk-margin-off-bottom">
														<h6>蓝桥杯大赛江苏赛区</h6></div>
														<div class="col-xs-3 text-left"><span>2016-10-02</span></div>
													</div>
												</div>
											</div>
										</a>
										<hr class="bk-margin-off" />
										<a class="panel-body bk-bg-very-light-gray bk-bg-lighten bk-padding-off-top bk-padding-off-bottom">
											<div class="row">
												<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12 bk-vcenter bk-padding-top-10 bk-padding-bottom-10">
													<div class="bk-round bk-border-off bk-bg-darken bk-icon bk-icon-x bk-icon-default bk-bg-danger">
														<i class="fa fa-hand-o-right fa-x"></i>
													</div>
												</div>
												<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 bk-vcenter">
													<div class="row">
														<div class="col-xs-7 text-left bk-fg-primary bk-fg-darken bk-margin-off-bottom">
														<h6>中国计算机大赛</h6></div>
														<div class="col-xs-3 text-left"><span>2016-10-02</span></div>
													</div>
												</div>
											</div>
										</a>
										
										<hr class="bk-margin-off" />
										<div class="panel-body bk-bg-very-light-gray bk-padding-top-5 bk-padding-bottom-5 ">
											<div class="row">
												<div class="col-xs-6 text-right">
													<a href="#" class="bk-fg-textcolor"><small>more <i class="fa fa-angle-right"></i></small></a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- 竞赛信息模块 结束 -->	
						</div>
						<!-- 成果模块 开始 -->
						<div class="row">
								<div class="col-md-12">
									<div class="panel bk-widget bk-border-off bk-noradius">
										<div class="panel-body bk-bg-very-light-gray text-center bk-padding-top-10 bk-padding-bottom-10">
											<div class="row">
												<div class="col-xs-8 text-left bk-vcenter">
													<h6 class="bk-margin-off">成果模块</h6>
												</div>
												<div class="col-xs-4 bk-vcenter text-right">
													<i class="fa  fa-angle-double-right"></i>
													<a href="">MORE</a>
												</div>
											</div>
										</div>
										<hr class="bk-margin-off" />
										<div class="row panel-body bk-bg-very-light-gray text-center bk-padding-top-10 bk-padding-bottom-10">
												<div class="col-md-3">
													<div class="panel bk-widget bk-border-off bk-noradius">
														<div class="panel-body text-center bk-padding-off bk-wrapper">
															<img src="assets/img/a1.jpg" alt="" class="img-responsive" />
															<div class="bk-avatar bk-avatar80-halfdown">
																<div class="bk-vcenter"></div>
																<a href="#">
																	<img src="assets/img/avatar1.jpg" alt="" class="img-circle bk-img-80 bk-border-info bk-border-darken bk-border-3x" />
																</a>
															</div>
														</div>
														<div class="panel-body bk-ltr bk-padding-bottom-3 bk-avatar80-halfdown-after text-center bk-bg-white">
															<h3 class="bk-margin-off"><strong>学科竞赛系统</strong></h3>
															<small class="bk-fg-inverse">Team DCMS</small>
															<p class="bk-margin-off-bottom bk-fg-gray">
																<em>基于Java EE框架设计实现一个以二级学院为目标的Java EE 学科竞赛管理系统。 </em>
															</p>
														</div>
													</div>
												</div>
												<div class="col-md-3">
													<div class="panel bk-widget bk-border-off bk-noradius">
														<div class="panel-body text-center bk-padding-off bk-wrapper">
															<img src="assets/img/a2.png" alt="" class="img-responsive" />
															<div class="bk-avatar bk-avatar80-halfdown">
																<div class="bk-vcenter"></div>
																<a href="#">
																	<img src="assets/img/avatar1.jpg" alt="" class="img-circle bk-img-80 bk-border-info bk-border-darken bk-border-3x" />
																</a>
															</div>
														</div>
														<div class="panel-body bk-ltr bk-padding-bottom-3 bk-avatar80-halfdown-after text-center bk-bg-white">
															<h3 class="bk-margin-off"><strong>SRTP</strong></h3>
															<small class="bk-fg-inverse">Team DCMS</small>
															<p class="bk-margin-off-bottom bk-fg-gray">
																<em>基于Java EE框架设计实现一个以二级学院为目标的Java EE 学科竞赛管理系统。 </em>
															</p>
														</div>
													</div>
												</div>
												<div class="col-md-3">
													<div class="panel bk-widget bk-border-off bk-noradius">
														<div class="panel-body text-center bk-padding-off bk-wrapper">
															<img src="assets/img/a3.jpg" alt="" class="img-responsive" />
															<div class="bk-avatar bk-avatar80-halfdown">
																<div class="bk-vcenter"></div>
																<a href="#">
																	<img src="assets/img/avatar1.jpg" alt="" class="img-circle bk-img-80 bk-border-info bk-border-darken bk-border-3x" />
																</a>
															</div>
														</div>
														<div class="panel-body bk-ltr bk-padding-bottom-3 bk-avatar80-halfdown-after text-center bk-bg-white">
															<h3 class="bk-margin-off"><strong>Android移动应用开发</strong></h3>
															<small class="bk-fg-inverse">Team DCMS</small>
															<p class="bk-margin-off-bottom bk-fg-gray">
																<em>基于Java EE框架设计实现一个以二级学院为目标的Java EE 学科竞赛管理系统。 </em>
															</p>
														</div>
													</div>
												</div>
												<div class="col-md-3">
													<div class="panel bk-widget bk-border-off bk-noradius">
														<div class="panel-body text-center bk-padding-off bk-wrapper">
															<img src="assets/img/a4.jpg" alt="" class="img-responsive" />
															<div class="bk-avatar bk-avatar80-halfdown">
																<div class="bk-vcenter"></div>
																<a href="#">
																	<img src="assets/img/avatar1.jpg" alt="" class="img-circle bk-img-80 bk-border-info bk-border-darken bk-border-3x" />
																</a>
															</div>
														</div>
														<div class="panel-body bk-ltr bk-padding-bottom-3 bk-avatar80-halfdown-after text-center bk-bg-white">
															<h3 class="bk-margin-off"><strong>iOS移动app</strong></h3>
															<small class="bk-fg-inverse">Team DCMS</small>
															<p class="bk-margin-off-bottom bk-fg-gray">
																<em>基于Java EE框架设计实现一个以二级学院为目标的Java EE 学科竞赛管理系统。 </em>
															</p>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						<!-- 成果模块 结束 -->
						
					</div>	
					
							
					<div class="row">
						
					</div>
				</div>
				<!-- End Main Page -->			
		
				<!-- Usage
				<div id="usage">
					<ul>
						<li>
							<div class="title">Memory</div>
							<div class="bar">
								<div class="progress progress-md  progress-striped active">
									<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 50%"></div>
								</div>
							</div>			
							<div class="desc">4GB of 8GB</div>
						</li>
						<li>
							<div class="title">HDD</div>
							<div class="bar">
								<div class="progress progress-md  progress-striped active">
									<div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%"></div>
								</div>
							</div>			
							<div class="desc">250GB of 1TB</div>
						</li>
						<li>
							<div class="title">SSD</div>
							<div class="bar">
								<div class="progress progress-md  progress-striped active">
									<div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width: 70%"></div>
								</div>
							</div>			
							<div class="desc">700GB of 1TB</div>
						</li>
						<li>
							<div class="title">Bandwidth</div>
							<div class="bar">
								<div class="progress progress-md  progress-striped active">
									<div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100" style="width: 90%"></div>
								</div>
							</div>			
							<div class="desc">90TB of 100TB</div>
						</li>				
					</ul>	
				</div> -->
				<!-- End Usage -->
			
			</div>
		</div><!--/container-->
		
		
		<!-- Modal Dialog -->
		<div class="modal fade" id="myModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title bk-fg-primary">Modal title</h4>
					</div>
					<div class="modal-body">
						<p class="bk-fg-danger">Here settings can be configured...</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary">Save changes</button>
					</div>
				</div>
			</div>
		</div><!-- End Modal Dialog -->		
		
		<div class="clearfix"></div>		
		
		
		<!-- start: JavaScript-->
		
		<!-- Vendor JS-->				
		<script src="assets/vendor/js/jquery.min.js"></script>
		<script src="assets/vendor/js/jquery-2.1.1.min.js"></script>
		<script src="assets/vendor/js/jquery-migrate-1.2.1.min.js"></script>
		<script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
		<script src="assets/vendor/skycons/js/skycons.js"></script>	
		
		<!-- Plugins JS-->
		<script src="assets/plugins/jquery-ui/js/jquery-ui-1.10.4.min.js"></script>
		<script src="assets/plugins/touchpunch/js/jquery.ui.touch-punch.min.js"></script>		
		<script src="assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
		<script src="assets/plugins/bootstrap-timepicker/js/bootstrap-timepicker.js"></script>
		<script src="assets/plugins/bootstrap-colorpicker/js/bootstrap-colorpicker.js"></script>
		<script src="assets/plugins/bootstrap-tagsinput/js/bootstrap-tagsinput.js"></script>
		<script src="assets/plugins/maskedinput/js/jquery.maskedinput.js"></script>

		<!-- Theme JS -->		
		<script src="assets/js/jquery.mmenu.min.js"></script>
		<script src="assets/js/core.min.js"></script>
		
		<!-- Pages JS -->
		<script src="assets/js/pages/form-elements.js"></script>
		
		<!-- end: JavaScript-->
		
	</body>
	
</html>