<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.sql.*"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<!--[if IE 8]>			<html class="ie ie8"> <![endif]-->
<!--[if IE 9]>			<html class="ie ie9"> <![endif]-->
<!--[if gt IE 9]><!-->	<html> <!--<![endif]-->
   <head>
      <meta charset="utf-8">
       <title>南京晓庄学院学科竞赛管理系统</title>
      <meta name="description" content="Pixma Responsive HTML5/CSS3 Template from FIFOTHEMES.COM">
      <meta name="author" content="FIFOTHEMES.COM">
      <!-- Mobile Metas -->
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <!-- Google Fonts  -->
      <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
      <link href='http://fonts.googleapis.com/css?family=Oswald:400,300,700' rel='stylesheet' type='text/css'>
      <script src="js/jquery.min.js"></script>
      <script type="text/javascript" src="js/checklogin.js"></script>
      <!-- Library CSS -->
      <link rel="stylesheet" href="css/bootstrap.css">
      <link rel="stylesheet" href="css/fonts/font-awesome/css/font-awesome.css">
      <link rel="stylesheet" href="css/animations.css" media="screen">
      <link rel="stylesheet" href="css/superfish.css" media="screen">
      <link rel="stylesheet" href="css/prettyPhoto.css" media="screen">
      <!-- Theme CSS -->
      <link rel="stylesheet" href="css/style.css">
      <!-- Skin -->
      <link rel="stylesheet" href="css/colors/blue.css" id="colors">
      <!-- Responsive CSS -->
      <link rel="stylesheet" href="css/theme-responsive.css">
      <!-- Switcher CSS -->
     <link href="css/switcher.css" rel="stylesheet">
     <link href="css/spectrum.css" rel="stylesheet">
      <!-- Favicons -->
      <link rel="shortcut icon" href="img/ico/favicon.ico">
      <link rel="apple-touch-icon" href="img/ico/apple-touch-icon.png">
      <link rel="apple-touch-icon" sizes="72x72" href="img/ico/apple-touch-icon-72.png">
      <link rel="apple-touch-icon" sizes="114x114" href="img/ico/apple-touch-icon-114.png">
      <link rel="apple-touch-icon" sizes="144x144" href="img/ico/apple-touch-icon-144.png">
      <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
      <!--[if lt IE 9]>
      <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
      <script src="js/respond.min.js"></script>
      <![endif]-->
      <!--[if IE]>
      <link rel="stylesheet" href="css/ie.css">
      <![endif]-->
   </head>
   <body class="page">
      <div class="wrap">
         <!-- Header Start -->
         <header id="header">
            <!-- Header Top Bar Start -->
            <div class="top-bar">
               <div class="slidedown collapse">
                  <div class="container">
                     <div class="phone-email pull-left">
                        <a><i class="icon-phone"></i> Call Us :  025 - 0000 0000</a>
                        <a href="mail%40example.html"><i class="icon-envelope"></i> Email : njxzc@example.com</a>
                    	${sessionScope.stuMess}<div id="loginid" style="display:none">${sessionScope.sid }</div>
                    	
                     </div>
                     <div class="pull-right">
                        <ul class="social pull-left">
                           <li class="facebook"><a href="#"><i class="icon-facebook"></i></a></li>
                           <li class="twitter"><a href="#"><i class="icon-twitter"></i></a></li>
                           <li class="dribbble"><a href="#"><i class="icon-dribbble"></i></a></li>
                           <li class="linkedin"><a href="#"><i class="icon-linkedin"></i></a></li>
                           <li class="rss"><a href="#"><i class="icon-rss"></i></a></li>
                        </ul>
                         <div id="search-form" class="pull-left">
                           <form action="#" method="get">
                              <input type="text" class="search-text-box">
                           </form>
                        </div>
                        <div  class="pull-right login" >
                              <a id="islogin"  style="display:none" class="pull-right" href="Student_login.jsp">Login Now</a>
                         </div>
                     </div>
                  </div>
               </div>
            </div>
            <!-- Header Top Bar End -->
            <!-- Main Header Start -->
            <div class="main-header">
               <div class="container">
                  <!-- TopNav Start -->
                  <div class="topnav navbar-header">
                     <a class="navbar-toggle down-button" data-toggle="collapse" data-target=".slidedown">
                     <i class="icon-angle-down icon-current"></i>
                     </a> 
                  </div>
                  <!-- TopNav End -->
                  <!-- Logo Start -->
                  <div class="logo pull-left">
                     <h1>
                        <a href="index-2.html">
                        <img src="img/logo.png" alt="pixma" width="125" height="60">
                        </a>
                     </h1>
                  </div>
                  <!-- Logo End -->
                  <!-- Mobile Menu Start -->
                  <div class="mobile navbar-header">
                     <a class="navbar-toggle" data-toggle="collapse" href=".html">
                     <i class="icon-reorder icon-2x"></i>
                     </a> 
                  </div>
                  <!-- Mobile Menu End -->
                  <!-- Menu Start -->
                  <nav class="collapse navbar-collapse menu">
                     <ul class="nav navbar-nav sf-menu">
                        <li>
                           <a id="current" href="indexshowNews.action">
                          	 首页
                           </a>
                        </li>
                        <li>
                           <a href="queryNews.action" class="sf-with-ul">
                           	新闻中心 
                           </a>
                        </li>
                        <li>
                           <a href="anonymousQuery.action" class="sf-with-ul">
                           	赛事动态
                           </a>
                        </li>
                       
                        <li>
                           <a href="listc.action" class="sf-with-ul">
                           	成果展示
                           </a>
                        </li>
                        <li>
                           <a href="personalset.jsp" class="sf-with-ul">
                          	个人中心
                           </a>
                        </li>
                     </ul>
                  </nav>
                  <!-- Menu End --> 
               </div>
            </div>
            <!-- Main Header End -->
         </header>
         <!-- Header End -->  
         <!-- Content Start -->
         <div id="main">
            <!-- Title, Breadcrumb Start-->
            <div class="breadcrumb-wrapper">
               <div class="container">
                  <div class="row">
                     <div class="col-lg-6 col-md-6 col-xs-12 col-sm-6">
                        <h2 class="title">新闻详情</h2>
                     </div>
                     <div class="col-lg-6 col-md-6 col-xs-12 col-sm-6">
                        <div class="breadcrumbs pull-right">
                           <ul>
                              <li>你所在位置:</li>
                              <li><a href="index.jsp">首页</a></li>
                              <li><a href="queryNews.action">新闻中心</a></li>
                              <li>新闻详情</li>
                           </ul>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
            <!-- Title, Breadcrumb End-->
             <!-- Main Content start-->
            <div class="content">
               <div class="container">
                  <div class="row">
                     <div class="posts-block col-lg-12 col-md-12 col-sm-12 col-xs-12">
                       <article>
                       	<s:iterator value="list" id="x" >
    	 		 		<%-- <img src="<s:property value="#x.newsPhotoPath" />" class="img"> --%>
      
      	 				<h3 class="content-title col-lg-12 col-md-12 col-sm-12 col-xs-12 col-md-offset-3 ">
       	 				<s:property value="newsTitle" /></h3>
     					<hr>
       				    <div class=" col-lg-12 col-md-12 col-sm-12 col-xs-12 col-md-offset-4">
    	 					<i class="icon-calendar-empty "></i>  发布时间: <s:property value="#x.newsIssuedate" />&nbsp;&nbsp;&nbsp;&nbsp;
         					<i class="icon-user"></i>  发布者:<s:property value="#x.newsIssuer" />
       					</div>
        				<div class="post-content"><s:property value="#x.newsContent" /> </div>
           			  </s:iterator>
    				 </article>
                     </div>
                     <!-- Left Section End -->
                  </div>
               </div>
            </div>
            <!-- Main Content end-->
         </div>
         <!-- Content End -->
         <!-- Footer Start -->
         <footer id="footer">
           
            <!-- Footer Bottom Start -->
            <div class="footer-bottom">
               <div class="container">
                  <div class="row">
                     <div class="col-lg-6 col-md-6 col-xs-12 col-sm-6 ">方山校区：南京市江宁区弘景大道3601号	邮编：211171	
						莫愁校区：南京市建邺区北圩路41号	邮编：210017
				Copyright &copy;  2013 南京晓庄学院   苏ICP备16013351号	 苏公网安备 32011502010053号
					</div>
                     <div class="col-lg-6 col-md-6 col-xs-12 col-sm-6 ">
                        <ul class="social social-icons-footer-bottom">
                           <li class="facebook"><a href="#" data-toggle="tooltip" title="Facebook"><i class="icon-facebook"></i></a></li>
                           <li class="twitter"><a href="#" data-toggle="tooltip" title="Twitter"><i class="icon-twitter"></i></a></li>
                           <li class="dribbble"><a href="#" data-toggle="tooltip" title="Dribble"><i class="icon-dribbble"></i></a></li>
                           <li class="linkedin"><a href="#" data-toggle="tooltip" title="LinkedIn"><i class="icon-linkedin"></i></a></li>
                           <li class="rss"><a href="#" data-toggle="tooltip" title="Rss"><i class="icon-rss"></i></a></li>
                        </ul>
                     </div>
                  </div>
               </div>
            </div>
            <!-- Footer Bottom End --> 
         </footer>
         <!-- Scroll To Top --> 
         <a href="#" class="scrollup"><i class="icon-angle-up"></i></a>
      </div>
      
      <!-- The Scripts -->
      
      <script src="js/bootstrap.js"></script>
      <script src="js/jquery.parallax.js"></script> 
      <script src="js/modernizr-2.6.2.min.js"></script> 
      <script src="js/revolution-slider/js/jquery.themepunch.revolution.min.js"></script>
      <script src="js/jquery.nivo.slider.pack.js"></script>
      <script src="js/jquery.prettyPhoto.js"></script>
      <script src="js/superfish.js"></script>
      <script src="js/tweetMachine.js"></script>
      <script src="js/tytabs.js"></script>
      <script src="js/jquery.sticky.js"></script>
      <script src="js/jflickrfeed.js"></script>
      <script src="js/imagesloaded.pkgd.min.js"></script>
      <script src="js/waypoints.min.js"></script>
      <script src="js/spectrum.js"></script>
      <script src="js/switcher.js"></script>
      <script src="js/jquery.gmap.min.js"></script>
      <script src="js/custom.js"></script>
     
      	        
</body>
</html>