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
      
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <meta name="description" content="dcms">
      <meta name="author" content="perany">
      <!-- Mobile Metas -->
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <!-- Google Fonts -->
           
      <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
      <link href='http://fonts.googleapis.com/css?family=Oswald:400,300,700' rel='stylesheet' type='text/css'>
       <script src="js/jquery.min.js"></script>
      <script type="text/javascript" src="js/checklogin.js"></script>
      <!-- Library CSS -->
      <link rel="stylesheet" href="css/bootstrap.css">
      <link rel="stylesheet" href="css/fonts/font-awesome/css/font-awesome.css">
      <link rel="stylesheet" href="css/animations.css" media="screen">
      <link rel="stylesheet" href="css/superfish.css" media="screen">
      <link rel="stylesheet" href="css/revolution-slider/css/settings.css" media="screen">
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
   <body class="home">
      <div class="wrap">
         <!-- Header Start -->
         <header id="header">
            <!-- Header Top Bar Start -->
            <div class="top-bar">
               <div class="slidedown collapse">
                  <div class="container">
                   <div class="phone-email pull-left ">
                        <a><i class="icon-phone"></i> 电话 : 025 - 86178121 0000</a>
                        <a href="mail%40example.html"><i class="icon-envelope"></i> 邮箱 : zhumx@njxzc.edu.cn</a>
                        	${sessionScope.stuMess}
                       	 <div id="loginid" style="display:none">${sessionScope.sid }</div>
                     </div>
                      <div class="pull-right ">
                         <a id="islogin" class=" pull-right"  href="manage_login.jsp"> 登录</a>
                          
                    <%--  <div class="phone-email pull-left ">
                        <a><i class="icon-phone"></i> Call Us : 025 - 0000 0000</a>
                        <a href="mail%40example.html"><i class="icon-envelope"></i> Email : njxzc@example.com</a>
                       	${sessionScope.stuMess}
                       	 <div id="loginid" style="display:none">${sessionScope.sid }</div>
                     </div>
                      <div class="pull-right ">
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
                         
                         
                         </div>--%> 
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
         <!-- 大图展示 Start -->
         <div id="main">
            <!-- Slider Start-->
            <div class="fullwidthbanner-container">
               <div class="fullwidthbanner rslider">
                  <ul>
                     <!-- THE FIRST SLIDE -->
                     <li data-delay="6000" data-masterspeed="300" data-transition="fade">
                        <div class="slotholder"><img src="img/slider/slider-bg-1.jpg" data-fullwidthcentering="on" alt="Pixma"></div>
                        <div class="caption modern_big_bluebg h1 lft tp-caption start"
                           data-x="40"
                           data-y="85"
                           data-speed="700"
                           data-endspeed="800"
                           data-start="1000"
                           data-easing="easeOutQuint"
                           data-endeasing="easeOutQuint">
                           <h3>Discipline Competition Management System</h3>
                        </div>
                        <div class="caption list_slide lfb tp-caption start" 
                           data-easing="easeOutExpo" 
                           data-start="1400" 
                           data-speed="1050" 
                           data-y="180" 
                           data-x="40">
                           <div class="list-slide">
                              <i class="icon-camera slide-icon"></i>
                              <h5 class="dblue"> 学科竞赛新闻动态 </h5>
                           </div>
                        </div>
                        <div class="caption list_slide lfb tp-caption start" 
                           data-easing="easeOutExpo" 
                           data-start="1800" 
                           data-speed="1200" 
                           data-y="220" 
                           data-x="40">
                           <div class="list-slide">
                              <i class="icon-search slide-icon"></i>
                              <h5 class="dblue"> 学科竞赛信息概览 </h5>
                           </div>
                        </div>
                        <div class="caption list_slide lfb tp-caption start" 
                           data-easing="easeOutExpo" 
                           data-start="2200" 
                           data-speed="1350" 
                           data-y="260" 
                           data-x="40">
                           <div class="list-slide">
                              <i class="icon-code slide-icon"></i>
                              <h5 class="dblue"> 最新竞赛成果展示 </h5>
                           </div>
                        </div>
                        <div class="caption lfb caption_button_1 fadeout tp-caption start"
                           data-x="40"
                           data-y="330"
                           data-speed="900"
                           data-endspeed="300"
                           data-start="2700"
                           data-hoffset="-70"
                           data-easing="easeOutExpo">
                           <a class="btn-special hidden-xs btn-grey" href="#">Learn </a>
                        </div>
                        <div class="caption lfb caption_button_2 fadeout tp-caption start"
                           data-x="210"
                           data-y="330"
                           data-speed="800"
                           data-endspeed="300"
                           data-start="2900"
                           data-hoffset="70"
                           data-easing="easeOutExpo">
                           <a class="btn-special hidden-xs btn-color" href="#">More</a>
                        </div>
                     </li>
                     <!-- THE RESPONSIVE SLIDE -->
                     <li data-transition="fade" data-slotamount="1" data-masterspeed="300">
                        <img src="img/slider/slider-bg-2.jpg" data-fullwidthcentering="on" alt="">
                        <div class="caption large_text sft"
                           data-x="660"
                           data-y="54"
                           data-speed="300"
                           data-start="800"
                           data-easing="easeOutExpo"  >KNOW ABOUT</div>
                        <div class="caption medium_text sfl"
                           data-x="689"
                           data-y="92"
                           data-speed="300"
                           data-start="1100"
                           data-easing="easeOutExpo"  >AND</div>
                        <div class="caption large_text sfr"
                           data-x="738"
                           data-y="88"
                           data-speed="300"
                           data-start="1100"
                           data-easing="easeOutExpo"  ><span class="dblue">LEARN MORE</span></div>
                        <div class="caption list_slide lfb tp-caption start" 
                           data-easing="easeOutExpo" 
                           data-start="1400" 
                           data-speed="1050" 
                           data-y="180" 
                           data-x="660">
                           <div class="list-slide">
                              <i class="icon-eye-open slide-icon"></i>
                              <h5> 匿名浏览畅游 </h5>
                           </div>
                        </div>
                        <div class="caption list_slide lfb tp-caption start" 
                           data-easing="easeOutExpo" 
                           data-start="1800" 
                           data-speed="1200" 
                           data-y="220" 
                           data-x="660">
                           <div class="list-slide">
                              <i class="icon-table slide-icon"></i>
                              <h5> 学生登陆平台 </h5>
                           </div>
                        </div>
                        <div class="caption list_slide lfb tp-caption start" 
                           data-easing="easeOutExpo" 
                           data-start="2200" 
                           data-speed="1350" 
                           data-y="260" 
                           data-x="660">
                           <div class="list-slide">
                              <i class="icon-ok slide-icon"></i>
                              <h5> 管理员后台管理 </h5>
                           </div>
                        </div>
                        <div class="caption list_slide lfb tp-caption start" 
                           data-easing="easeOutExpo" 
                           data-start="2600" 
                           data-speed="1350" 
                           data-y="300" 
                           data-x="660">
                           <div class="list-slide">
                              <i class="icon-twitter slide-icon"></i>
                              <h5> 随时随地获取信息 </h5>
                           </div>
                        </div>
                        <div class="caption list_slide lfb tp-caption start" 
                           data-easing="easeOutExpo" 
                           data-start="3000" 
                           data-speed="1350" 
                           data-y="340" 
                           data-x="660">
                           <div class="list-slide">
                              <i class="icon-th slide-icon"></i>
                              <h5> 信息化管理平台 </h5>
                           </div>
                        </div>
                      <div class="caption lfl"
                           data-x="83"
                           data-y="70"
                           data-speed="300"
                           data-start="1400"
                           data-easing="easeOutExpo">
                           <img src="img/show2.png" alt="iMac Responsive">
                        </div>
                        <div class="caption lfl"
                           data-x="253"
                           data-y="185"
                           data-speed="300"
                           data-start="1500"
                           data-easing="easeOutExpo">
                           <img src="img/show1.png" alt="iPad Responsive">
                        </div>
                      
                     </li>
                  </ul>
               </div>
            </div>
            <!-- 大图展示 End--> 
            <!-- 登陆入口 Start-->
            <div class="slogan bottom-pad-small">
               <div class="container">
                  <div class="row">
                     <div class="slogan-content">
                        <!-- <div class="col-lg-9 col-md-9">
                           <h2 class="slogan-title">南京晓庄学院学科竞赛综合平台</h2>
                        </div> -->
                       <!--  <div class="col-lg-3 col-md-3">
                           <div class="get-started">
                              <a class="btn btn-special btn-color pull-right" href="manage_login.jsp">Login Now</a>
                           </div>
                        </div> -->
                         <!-- <div class="get-started">
                              <a class="btn btn-special btn-color pull-right" href="manage_login.jsp">Login Now</a>
                           </div> -->
                        <div class="clearfix"></div>
                     </div>
                  </div>
               </div>
            </div> 
           <!-- 登陆入口 End--> 
          
           <!--新闻 公告通知 start -->  
              <!-- Main Content start-->
            <div class="content">
               <div class="container">
                  <div class="row">
                     <div class="col-lg-6 col-md-6 col-xs-12 col-sm-6">
                         <h3 class="title">新闻动态</h3>
                              <s:iterator value="list" id="x" status="st">
                              <s:if test="#st.Count <= 6">
	                      		  <p><!-- <a  href="news/newsContent.action?news.newsTitle=<s:property value="newsTitle"/>"> </a>-->
	                       			 <s:property value="newsTitle" />
	                       		  </p>
                       		  </s:if> 
            				  </s:iterator>
           			         <!--  <p>第48届国际化学奥赛中国代表队再获全金</p>
                      		  <p>2016年全国中学生学科奥林匹克竞赛管理工作会召开</p>
                      		  <p>关于公示全国中学生五项学科竞赛获奖学生名单的通知</p>
                      		  <p>中国代表队在国际生物学奥林匹克竞赛取得团体第一的优</p>
                      		  <p>关于做好2015年全国中学生五项学科竞赛（决赛）组</p>
                      		  <p>关于公示全国中学生五项学科竞赛获奖学生名单的通知</p>
                      		   -->
                      		  
                              <a href="#">Read More <i class="icon-angle-right"></i><i class="icon-angle-right"></i></a>
                           
                     </div>
                     <div class="col-lg-6 col-md-6 col-xs-12 col-sm-6 ">
                        <h3  class="title">公告通知</h3>
                        <div class="row">
                           <div class="circular-nav">
                              <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12 animate_afl">
                                 <div id="cn-tabs">
                                 <script>
                                 $(function(){
                                	 $.ajax({
                                		 type:'post',
                                		 url:'frontlistnotice.action',
                                		 dataType:'json',
                                		 async:true,
                                		 success:function(data){
                                			 //alert(data);
                                			 //alert("success");
                                			 var html = "";
                                			 $.each(data,function(commentIndex,comment){
                                				 var time = comment["noticeDate"];
                                				 var content = comment["noticeContent"];
                                				 console.log(commentIndex);
                                				 if(commentIndex<=8){
                                					html += "<div class=\"service service-"+(commentIndex+1)+"\"><div class='cn-content'><h4>"+time+"</h4><p>"+content+"</p><div class='clearfix'></div></div></div>"
                                				 	//console.log(html)
                                					$("#cn-tabs").html(html);
                                				 }
                                				 
                                			 })
                                			 
                                		 },
                                		 error:function(XMLHttpRequest,textStatus,error){
                                			 alert(XMLHttpRequest.status);
                                			 alert(textStatus)
                                			 alert("notice load fail");
                                		 }
                                	 });
                                 })
                                 </script>
                                    <!-- <div class="service service-1">
                                       <div class="cn-content">
                                        <h4>2016-10-17</h4>
                                          <p>某某某大赛的报名截止时间为2016-10-25，请同学们抓紧时间填报报名表上交至教务处。</p>
                                          <div class="clearfix"></div>
                                       </div>
                                       <div class="clearfix"></div>
                                    </div>
                                    <div class="service service-2">
                                       <div class="cn-content">
                                          <h4>2016-10-20</h4>
                                          <p>2016-10-24 00：00-4：00未系统维护时间，如带来不便，请谅解！</p>
                                          <div class="clearfix"></div>
                                       </div>
                                    </div>
                                    <div class="service service-3">
                                       <div class="cn-content">
                                          <h4>2016-10-17</h4>
                                          <p>某某某大赛的报名截止时间为2016-10-25，请同学们抓紧时间填报报名表上交至教务处。</p>
                                       </div>
                                       <div class="clearfix"></div>
                                    </div>
                                    <div class="service service-4">
                                       <div class="cn-content">
                                          <h4>2016-10-20</h4>
                                          <p>2016-10-24 00：00-4：00未系统维护时间，如带来不便，请谅解！</p>
                                       </div>
                                       <div class="clearfix"></div>
                                    </div>
                                    <div class="service service-5">
                                       <div class="cn-content">
                                         <h4>2016-10-17</h4>
                                          <p>某某某大赛的报名截止时间为2016-10-25，请同学们抓紧时间填报报名表上交至教务处。</p>
                                       </div>
                                       <div class="clearfix"></div>
                                    </div>
                                    <div class="service service-6">
                                       <div class="cn-content">
                                          <h4>2016-10-20</h4>
                                          <p>2016-10-24 00：00-4：00未系统维护时间，如带来不便，请谅解！</p>
                                       </div>
                                       <div class="clearfix"></div>
                                    </div>
                                    <div class="service service-7">
                                       <div class="cn-content">
                                         <h4>2016-10-17</h4>
                                          <p>某某某大赛的报名截止时间为2016-10-25，请同学们抓紧时间填报报名表上交至教务处。</p>
                                       </div>
                                       <div class="clearfix"></div>
                                    </div>
                                    <div class="service service-8">
                                       <div class="cn-content">
                                         <h4>2016-10-17</h4>
                                          <p>某某某大赛的报名截止时间为2016-10-25，请同学们抓紧时间填报报名表上交至教务处。</p>
                                       </div>
                                       <div class="clearfix"></div>
                                    </div>
                                    <div class="service service-9">
                                       <div class="cn-content">
                                         <h4>2016-10-20</h4>
                                          <p>2016-10-24 00：00-4：00未系统维护时间，如带来不便，请谅解！</p>
                                       </div>
                                       <div class="clearfix"></div>
                                    </div> -->
                                 </div>
                                 <div class="clearfix"></div>
                              </div>
                              <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12 col-lg-offset-1 col-md-offset-1 animate_afr">
                                 <div class="cn-wrapper">
                                    <ul>
                                       <li class="circle-1 circle"><a class="active" href="#"><!--<span class="icon-picture"></span> -->1</a></li>
                                       <li class="circle-2 circle"><a href="#"><!--<span class="icon-rocket"></span>-->2</a></li>
                                       <li class="circle-3 circle"><a href="#"><!--<span class="icon-puzzle-piece"></span> -->3</a></li>
                                       <li class="circle-4 circle"><a href="#"><!--<span class="icon-thumbs-up-alt"></span>-->4</a></li>
                                       <li class="circle-5 circle"><a href="#"><!--<span class="icon-html5"></span>-->5</a></li>
                                       <li class="circle-6 circle"><a href="#"><!--<span class="icon-user"></span>-->6</a></li>
                                       <li class="circle-7 circle"><a href="#"><!--<span class="icon-google-plus"></span> -->7</a></li>
                                       <li class="circle-8 circle"><a href="#"><!--<span class="icon-envelope-alt"></span>-->8</a></li>
                                       <li class="circle-9 circle"><a href="#"><!--<span class="icon-hand-right"></span>-->9</a></li>
                                    </ul>
                                    <div class="clearfix"></div>
                                 </div>
                             </div>
                			 <div class="clearfix"></div>
                      </div>
                  </div>
              </div>
           </div>
      </div>
      </div>
                     
        
            
            
            
             <!-- 成果展示start --> 
            <div class="recentworks no-bottom-pad">
               <div class="container">
                  <div class="row">
                     <div class="col-lg-12 col-md-12 com-sm-12 col-xs-12">
                        <h3 class="title">成果展示</h3>
                     </div>
                     <div class="clearfix"></div>
                     <div class="blog-showcase col-lg-12 col-md-12 col-sm-12 col-xs-12 animate_afb d1">
                        <ul id="comp">
                      <%--  <script type="text/javascript">
<!--

//-->
 $(function(){
	$.ajax({
		  type:"get",
		  url:"indexAjax.action",
		  dataType:"json",
		  success:function(data){
			  console.log(data);
			  for (var i = 0; i < data.length; i++) {
				var html = "";
				html += "<li>";
				html += "<div class='blog-showcase-thumb col-lg-4'>";
				html += "<div class='post-body'>";
				html += "<a class='post-item-link' href='img/portfolio/portfolio-5.jpg' data-rel='prettyPhoto'>";
				html += "<span class='post-item-hover'></span>";
				html += "<span class='fullscreen'><i class='icon-search'></i></span>";
				html += "<img src='img/portfolio/portfolio-5.jpg'></a>";
				html += "</div>";
				html += "</div>";
				html += "<div class='blog-showcase-extra-info col-lg-4'>";
				html += "<span><a href='#'>2016-10-08</a></span>";
				html += "<h4><a href='#' class='title'>"+ data[i].awardName + "</a></h4>";
				html += "<p>" + data[i].awardIntr + "</p>";
				html += "<a href='content.action?Subcompid="+data[i].subcompid+"'>Read more <i class='icon-double-angle-right'></i></a>";
				html += "</div>";
				html += "</li>";
				$("#comp").append(html);
			  }
			  
			  
		  },
		  error:function(XMLHttpRequest, textStatus, errorThrown){
			  alert("error");                
			} 
	});
	
})
</script> --%>
                            <li class="">
                              <div class="blog-showcase-thumb col-lg-4">
                                 <div class="post-body">
                                    <a class="post-item-link" href="img/portfolio/portfolio-5.jpg" data-rel="prettyPhoto">
                                    <span class="post-item-hover"></span>
                                    <span class="fullscreen"><i class="icon-search"></i></span>
                                    <img alt="" src="img/portfolio/portfolio-5.jpg"></a>
                                 </div>
                              </div>
                              <div class="blog-showcase-extra-info col-lg-4">
                                 <span><a href="#">2016-10-08</a></span>
                                 <h4><a href="#" class="title">ACM大赛</a></h4>
                                 <p>于2016-10-8我校某某某同学再指导老师慕某某的带领下参加了某某大赛，荣获什么什么大奖。作品内容是什么什么什么。</p>
                                 <a href="#">Read more <i class="icon-double-angle-right"></i></a>
                              </div>
                           </li>
                           <li>
                              <div class="blog-showcase-thumb col-lg-4">
                                 <div class="post-body">
                                    <a class="post-item-link" href="img/portfolio/portfolio-6.jpg" data-rel="prettyPhoto"><span class="post-item-hover"></span><span class="fullscreen"><i class="icon-search"></i></span><img alt="" src="img/portfolio/portfolio-6.jpg"></a>
                                 </div>
                              </div>
                              <div class="blog-showcase-extra-info col-lg-4">
                                 <span><a href="#">2016-09-03</a></span>
                                 <h4><a href="#" class="title">ACM大赛</a></h4>
                                 <p>于2016-09-03我校某某某同学再指导老师慕某某的带领下参加了某某大赛，荣获什么什么大奖。作品内容是什么什么什么。</p>
                                 <a href="#">Read more <i class="icon-double-angle-right"></i></a>
                              </div>
                           </li>
                           <li class="blog-first-el">
                              <div class="blog-showcase-thumb col-lg-4">
                                 <div class="post-body">
                                    <a class="post-item-link" href="img/portfolio/portfolio-7.jpg" data-rel="prettyPhoto">
                                    <span class="post-item-hover"></span>
                                    <span class="fullscreen"><i class="icon-search"></i></span>
                                    <img alt="" src="img/portfolio/portfolio-7.jpg">
                                    </a>
                                 </div>
                              </div>
                              <div class="blog-showcase-extra-info col-lg-4">
                                 <span><a href="#">2016-08-25</a></span>
                                 <h4><a href="#" class="title">ACM大赛</a></h4>
                                 <p>于2016-08-25我校某某某同学再指导老师慕某某的带领下参加了某某大赛，荣获什么什么大奖。作品内容是什么什么什么。</p>
                                 <a href="#">Read more <i class="icon-double-angle-right"></i></a>
                              </div>
                           </li> 
                        </ul>
                        <div class="clearfix"></div>
                     </div>
                  </div>
                  <div class="divider"></div>
               </div>
            </div>
            <!-- 成果展示 End -->
           
 
                        

           
            <!-- Our Clients Start-->
            <div class="our-clients">
               <div class="container">
                  <div class="row">
                     <div class="client">
                        <div class="client-logo">
                           <div class="col-lg-8 col-md-8 col-sm-6 col-xs-12">
                              <div class="clients-title">
                                 <h3 class="title">友情链接</h3>
                                 <div class="carousel-controls pull-right">
                                    <a class="prev" href="#client-carousel" data-slide="prev"><i class="icon-angle-left"></i></a>
                                    <a class="next" href="#client-carousel" data-slide="next"><i class="icon-angle-right"></i></a>
                                    <div class="clearfix"></div>
                                 </div>
                              </div>
                              <div class="clearfix"></div>
                              <div class="row">
                                 <div id="client-carousel" class="client-carousel slide">
                                    <div class="carousel-inner">
                                       <div class="item active">
                                          <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 item animate_afc d1">
                                             <div class="item-inner"><a href="#"><img alt="Upportdash" src="img/clientslogo/logo-1.png"></a></div>
                                          </div>
                                          <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 item animate_afc d2">
                                             <div class="item-inner"><a href="#"><img alt="Upportdash" src="img/clientslogo/logo-2.png"></a></div>
                                          </div>
                                          <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 item animate_afc d3">
                                             <div class="item-inner"><a href="#"><img alt="Upportdash" src="img/clientslogo/logo-3.jpg"></a></div>
                                          </div>
                                          <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 item animate_afc d4">
                                             <div class="item-inner"><a href="#"><img alt="Upportdash" src="img/clientslogo/logo-4.jpg"></a></div>
                                          </div>
                                       </div>
                                       <div class="item">
                                          <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 item">
                                             <div class="item-inner"><a href="#"><img alt="Upportdash" src="img/clientslogo/logo-5.jpg"></a></div>
                                          </div>
                                          <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 item">
                                             <div class="item-inner"><a href="#"><img alt="Upportdash" src="img/clientslogo/logo-4.jpg"></a></div>
                                          </div>
                                          <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 item">
                                             <div class="item-inner"><a href="#"><img alt="Upportdash" src="img/clientslogo/logo-3.jpg"></a></div>
                                          </div>
                                          <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 item">
                                             <div class="item-inner"><a href="#"><img alt="Upportdash" src="img/clientslogo/logo-2.png"></a></div>
                                          </div>
                                       </div>
                                    </div>
                                 </div>
                              </div>
                           </div>
                           <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                              <!-- Testimonials Widget Start -->
                              <div class="row ">
                                 <div class="testimonials widget">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                       <div class="testimonials-title">
                                          <h3 class="title">系统服务</h3>
                                       </div>
                                    </div>
                                    <div class="clearfix"></div>
                                    <div id="testimonials-carousel" class="testimonials-carousel slide animate_afr d5">
                                       <div class="carousel-inner">
                                          <div class="item active">
                                             <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                <div class="testimonial item">
                                                   <p>
                                                      学生登录的用户名是学号，密码为身份证后六位。登陆后请及时修改密码，若有疑问请咨询王老师。QQ：12345678
                                                   </p>
                                                   <div class="testimonials-arrow">
                                                   </div>
                                                   <div class="author">
                                                      <div class="testimonial-image "><img alt="" src="img/testimonial/team-member-1.jpg"></div>
                                                      <div class="testimonial-author-info">
                                                         <a href="#"><span class="color">王小明老师</span></a> TEL:13800000000
                                                      </div>
                                                   </div>
                                                </div>
                                             </div>
                                          </div>
                                          <div class="item">
                                             <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                <div class="testimonial item">
                                                   <p>
                                                      若系统操作有任何问题都可咨询张老师，欢迎致电：13888888888.
                                                   </p>
                                                   <div class="testimonials-arrow">
                                                   </div>
                                                   <div class="author">
                                                      <div class="testimonial-image "><img alt="" src="img/testimonial/team-member-2.jpg"></div>
                                                      <div class="testimonial-author-info">
                                                         <a href="#"><span class="color">张小明老师</span></a> TEL:13388888888
                                                      </div>
                                                   </div>
                                                </div>
                                             </div>
                                          </div>
                                          <div class="item">
                                             <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                <div class="testimonial item">
                                                   <p>
                                                      每月最后一天凌晨00：00-4：00为系统维护时间，如给您带来不便，敬请原谅。
                                                   </p>
                                                   <div class="testimonials-arrow">
                                                   </div>
                                                   <div class="author">
                                                      <div class="testimonial-image "><img alt="" src="img/testimonial/team-member-3.jpg"></div>
                                                      <div class="testimonial-author-info">
                                                          <a href="#"><span class="color">李小明老师</span></a> TEL:13666666666
                                                      </div>
                                                   </div>
                                                </div>
                                             </div>
                                          </div>
                                       </div>
                                    </div>
                                 </div>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
            <!-- Our Clients End -->  
         </div>
         <!-- Content End -->
         <!-- Footer Start -->
         <footer id="footer">
            <!-- Footer Top Start -->
           <%--  <div class="footer-top">
               <div class="container">
                  <div class="row">
                     <section class="col-lg-3 col-md-3 col-xs-12 col-sm-3 footer-one">
                        <h3>关于平台</h3>
                        <p> 
                           平台创建于2016年10月，主服务器运行Windows Server或Linux，客户端为个人电脑，一般要求浏览器IE6.0版本以上。
                        </p>
                     </section>
                     <section class="col-lg-3 col-md-3 col-xs-12 col-sm-3 footer-two">
                        <h3>系统首页</h3>
                        <ul id="tweets">
                        </ul>
                     </section>
                     <section class="col-lg-3 col-md-3 col-xs-12 col-sm-3 footer-three">
                        <h3>联系我们</h3>
                        <ul class="contact-us">
                           <li>
                              <i class="icon-map-marker"></i>
                              <p> 
                                 <strong>地址:</strong> 南京晓庄学院 <br>
                                 教务办223号办公室
                              </p>
                           </li>
                           <li>
                              <i class="icon-phone"></i>
                              <p><strong>电话:</strong> 025-0000 0000</p>
                           </li>
                           <li>
                              <i class="icon-envelope"></i>
                              <p><strong>邮箱:</strong><a href="mailto:info@fifothemes.com">njxzc@outlook.com</a></p>
                           </li>
                        </ul>
                     </section>
                     <section class="col-lg-3 col-md-3 col-xs-12 col-sm-3 footer-four">
                        <h3>系统帮助</h3>
                        <ul id="flickrfeed" class="thumbs"></ul>
                     </section>
                  </div>
               </div>
            </div> --%>
            <!-- Footer Top End --> 
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

</body>
</html>
     