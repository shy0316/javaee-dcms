<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="com.nxdcms.dao.impl.PageBean"%>
<%@page import="antlr.collections.List"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%request.setCharacterEncoding("UTF-8");%>
<%response.setCharacterEncoding("UTF-8");%>
<%String path = request.getContextPath();%> 

<!DOCTYPE html>
<!--[if IE 8]>			<html class="ie ie8"> <![endif]-->
<!--[if IE 9]>			<html class="ie ie9"> <![endif]-->
<!--[if gt IE 9]><!-->	<html> <!--<![endif]-->
   <head>
      <meta charset="utf-8">
      <title>成果展示</title>
      <meta name="description" content="Pixma Responsive HTML5/CSS3 Template from FIFOTHEMES.COM">
      <meta name="author" content="FIFOTHEMES.COM">
      <!-- Mobile Metas -->
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <!-- Google Fonts  -->
      <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
      <link href='http://fonts.googleapis.com/css?family=Oswald:400,300,700' rel='stylesheet' type='text/css'>
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
  <%--  <style type="text/css">
   body {
		height:10px;
		min-height: 10px;
	}
   </style> --%>
   <body class="page">
      <div class="wrap">
         <!-- Header Start -->
         <header id="header">
            <!-- Header Top Bar Start -->
           <div class="top-bar">
               <div class="slidedown collapse">
                  <div class="container">
                     <div class="phone-email pull-left ">
                        <a><i class="icon-phone"></i> Call Us : 025 - 86178121 0000</a>
                        <a href="mail%40example.html"><i class="icon-envelope"></i> Email : zhumx@njxzc.edu.cn</a>
                        	${sessionScope.stuMess}
                       	 <div id="loginid" style="display:none">${sessionScope.sid }</div>
                     </div>
                      <div class="pull-right ">
                         <a id="islogin" class=" pull-right"  href="manage_login.jsp">Login Now</a>
                          
                          
                    
                       
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
                         <a href="query.jsp" class="sf-with-ul">
                      
                           <!-- <a href="modifys1.action" class="sf-with-ul"> -->
                          	 成果展示
                           </a>                        
                        </li>
                        <li>
                             <a href="personcenter.jsp" class="sf-with-ul">
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
                        <h2 class="title">成果展示</h2>
                     </div>
                     <div class="col-lg-6 col-md-6 col-xs-12 col-sm-6">
                        <div class="breadcrumbs pull-right">
                           <ul>
                              <li>你所在位置：</li>
                              <li><a href="index.jsp">首页</a></li>
                              <li>成果展示</li>
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
                    
                     <div class="posts-block col-lg-12 col-md-12 col-sm-11 col-xs-12 ">
                       
                          
                            <div class="sidebar col-lg-3 col-md-3 col-sm-3 col-xs-12">
                        <!-- Category Widget Start -->
                        <div class="widget tabs">
                           <h3 class="title">成果查询</h3>
                             <form  action="likesearch.action" method="post">
                           <ul class="posts">
                             
			
			<li ><div class="query_l">获奖等级：</div></li>
			<!-- <li><input type="text"  name="awardGrade"  class="form-control"  id="grade"></li> -->
			
			<li><select class="form-control" name="competition.scale">
					                <option value="">竞赛级别</option>
								  	<option value="院级">院级</option>
								    <option value="校级">校级</option>
								    <option value="市级">市级</option>
								    <option value="省级">省级</option>
								    <option value="国家级">国家级</option>	
					              </select>
		     </li>
			<li><div class="query_l">指导老师：</div></li>
			 <li><input type="text"  name="teacher" class="form-control" id="teacher">
			</li>
			<li><div class="query_l">获奖时间 ：</div></li>
			<li>
			<input type="date" class="form-control" name="awarddate" id="college">
					
			 <!-- <font id="tips" color="red">学院不能为空</font> -->
			</li>
			 
			<li>
			<!--  <div class="sidebar col-lg-1 col-md-1 col-sm-1 col-xs-1 col-md-offset-3">
			<input class="btn-small btn-color btn-pad" type="submit" value="查询" id="submit"></div>-->
			<div class="sidebar col-lg-1 col-md-1 col-sm-1 col-xs-1 col-md-offset-3">
			<input class="btn-small btn-color btn-pad" type="button" value="查询" id="submit"></div>
			</li>
			</ul>
                            </form>
                        </div>
                        <!-- Category Widget End -->
                       
                     </div>
                     <!-- Sidebar End -->
                                                     
                           <div class="col-lg-9 col-md-9 col-xs-12 col-sm-12 ">
                        <h3 class="title">优秀作品展示</h3>
                        <div>
                        <ul class="pager">
                           <li class="next"><a href="export.action" >导出  <i class="icon-signout icon"></i>
							
							</a>
							</li>
                       </ul>  
                      
                        <table id="mytable" class="table table-striped table-bordered" border="0" id="mytable">
                           <thead>
                              <tr>
                                 <!-- <th>获奖id</th> -->
                                 <th>作品名称</th>
								 <th>获奖等级</th>
								 <th>获奖名称</th>
								 <th>团队名称</th>
					           	 <th>操作</th>
                              </tr>
                           </thead>
                          <tbody>
                          
   							<s:iterator value="list" id="x" status='st'>
   							<s:if test="#st.Count<=6">
					<tr class="tr">
						<%-- <td><s:property value="#x.Subcompid" /></td> --%>
						<td><s:property value="#x.production" />基于javaee的学科竞赛管理系统</td>
						<td><s:property value="#x.awardGrade" /></td>
						<td><s:property value="#x.awardName" /></td>
						<td><s:property value="#x.teamName" /></td>
						<td><s:property value="#x.teacher" /></td>
					
						<!--  <td><s:date name="#x.awarddate"  format="yyyy/MM/dd" /></td>-->
						<td><a
							href="content.action?Subcompid=<s:property value="Subcompid"/>">详情</a></td>
					</tr>
					</s:if>
				</s:iterator>
				</tbody>

                        </table>
                    <div class="list1 col-md-9  col-md-offset-3" >
				
					<input type="button" id="b1" value="首页" class="own-btn"/>
					<input type="button" id="b2" value="上一页" class="own-btn"/>
					<input type="button" id="b3" value="下一页" class="own-btn"/>
					<input type="button" id="b4" value="尾页" class="own-btn"/>
					共<input type="text" id="allpage" disabled="disabled" class="own-text"/>页
				
			</div>
			
                         
                     </div>
                    
                  </div>
                  
       
			
			
				
			
     
   
                       
                      
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
                     <div class="col-lg-8 col-md-8 col-xs-12 col-sm-8 ">
						方山校区：南京市江宁区弘景大道3601号	邮编：211171	
						莫愁校区：南京市建邺区北圩路41号	邮编：210017
				Copyright &copy;  2013 南京晓庄学院   苏ICP备16013351号	 苏公网安备 32011502010053号
					</div>
                     <div class="col-lg-4 col-md-4 col-xs-12 col-sm-4 ">
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
      <!-- Wrap End -->
      
      <!-- The Scripts -->
      <script src="js/jquery.min.js"></script>
      <script src="js/bootstrap.js"></script>
      <script src="js/jquery.parallax.js"></script> 
      <script src="js/modernizr-2.6.2.min.js"></script> 
      <script src="js/revolution-slider/js/jquery.themepunch.revolution.min.js"></script>
      <script src="js/jquery.nivo.slider.pack.js"></script>
      <script src="js/jquery.prettyPhoto.js"></script>
      <script src="js/superfish.js"></script>
      <script src="js/tweetMachine.js"></script>
      <script src="js/tytabs.js"></script>
      <script src="js/jquery.gmap.min.js"></script>
      <script src="js/circularnav.js"></script>
      <script src="js/jquery.sticky.js"></script>
      <script src="js/jflickrfeed.js"></script>
      <script src="js/imagesloaded.pkgd.min.js"></script>
      <script src="js/waypoints.min.js"></script>
      <script src="js/spectrum.js"></script>
      <script src="js/switcher.js"></script>
      <script src="js/custom.js"></script>
   <script type="text/javascript" src="js/page.js"></script>
</body>
</html>

<script src="js/jquery-1.7.min.js"></script>
<script src="js/showoutcome.js"></script>
