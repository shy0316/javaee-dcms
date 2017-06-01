<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="antlr.collections.List"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%request.setCharacterEncoding("UTF-8");%>
<%response.setCharacterEncoding("UTF-8");%>
<%String path = request.getContextPath();%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

	<head>
	
		<!-- Basic -->
    	<meta charset="UTF-8" />

		<title>登录 | 学科竞赛信息后台管理</title>
		
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
		
		<!-- Theme CSS -->
		<link href="assets/css/jquery.mmenu.css" rel="stylesheet" />
		
		<!-- Page CSS -->		
		<link href="assets/css/style.css" rel="stylesheet" />
		<link href="assets/css/add-ons.min.css" rel="stylesheet" />
		
		<style>
			footer {
				display: none;
			}
		</style>
		
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
		<!-- Start: Content -->
		<div class="container-fluid content">
			<div class="row">
				<!-- Main Page -->
				<div class="body-login">
					<div class="center-login">
						<a href="#" class="logo pull-left hidden-xs">
							<img src="assets/img/logo.png" height="45" alt="NADHIF Admin" />
						</a>

						<div class="panel panel-login">
							<div class="panel-title-login text-right">
								<h2 class="title"><i class="fa fa-user"></i> 登录</h2>
							</div>
							<div class="panel-body">
								<form action="login_student.action" method="post">
									<div class="form-group">
										<label>账 号</label>
										<div class="input-group input-group-icon">
											<input name="stuId" id"stuId" type="text" class="form-control bk-noradius" />
											<span class="input-group-addon">
												<span class="icon">
													<i class="fa fa-user"></i>
												</span>
											</span>
										</div>
									</div>

									<div class="form-group">
										<label>密 码</label>									
										<div class="input-group input-group-icon">
											<input name="stuPassword" id="stupassword" type="password" class="form-control bk-noradius" />
											<span class="input-group-addon">
												<span class="icon">
													<i class="fa fa-lock"></i>
												</span>
											</span>
										</div>
									</div>
									<br />
									<div class="row">
										<div class="col-sm-8">
											<div class="checkbox-custom checkbox-default bk-margin-bottom-10">
												<input id="RememberMe" name="rememberMe" type="checkbox" />
												<label for="RememberMe">记住密码</label>
											</div>
										</div>
										<div class="col-sm-4 text-right">
											<button href="index_manage.jsp" type="submit" class="btn btn-primary hidden-xs">登 录</button>
											<button href="index_manage.jsp" type="submit" class="btn btn-primary btn-block btn-lg visible-xs bk-margin-top-10">登 录</button>
										</div>
									</div>
									<br />
									<div class="text-with-hr">
										<span>or</span>
									</div>
									<br />
									<div class="bk-margin-bottom-10 bk-margin-top-10 text-center">
										<a href="#" class="fa fa-facebook facebook-bg"></a>
										<a href="#" class="fa fa-twitter twitter-bg"></a>
										<a href="#" class="fa fa-linkedin linkedin-bg"></a>
									</div><br />
									<p class="text-center">还未注册? <a href="page-register.html"><small>注册!</small></a>
								</form>
							</div>
						</div>
					</div>
				</div>
				<!-- End Main Page -->
		
				<!-- Usage -->
				<div id="usage-blank">
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
				</div>
				<!-- End Usage -->					
		
			</div>
		</div><!--/container-->
		
		
		<!-- start: JavaScript-->
		
		<!-- Vendor JS-->				
		<script src="assets/vendor/js/jquery.min.js"></script>
		<script src="assets/vendor/js/jquery-2.1.1.min.js"></script>
		<script src="assets/vendor/js/jquery-migrate-1.2.1.min.js"></script>
		<script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
		<script src="assets/vendor/skycons/js/skycons.js"></script>	
		
		<!-- Plugins JS-->
		
		<!-- Theme JS -->		
		<script src="assets/js/jquery.mmenu.min.js"></script>
		<script src="assets/js/core.min.js"></script>
		
		<!-- Pages JS -->
		<script src="assets/js/pages/page-login.js"></script>
		
		<!-- end: JavaScript-->
		
	</body>
	
</html>