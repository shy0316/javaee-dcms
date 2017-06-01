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
                     <div class="phone-email pull-left">
                        <a><i class="icon-phone"></i> Call Us : 025 - 0000 0000</a>
                        <a href="mail%40example.html"><i class="icon-envelope"></i> Email : njxzc@example.com</a>
                        ${sessionScope.stuMess} 
                        <div id="loginid" style="display:none">${sessionScope.sid }</div>
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
                              <a id="islogin" style="display:none" class="pull-right" href="Student_login.jsp">Login Now</a>
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
                           <a href="indexshowNews.action">
                          	 首页
                           </a>
                        </li>
                        <li>
                           <a href="queryNews.action" class="sf-with-ul">
                           	新闻中心 
                           </a>
                        </li>
                        <li>
                           <a  id="current"  href="anonymousQuery.action" class="sf-with-ul">
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
       <div id="main">
            <!-- Title, Breadcrumb Start-->
            <div class="breadcrumb-wrapper">
               <div class="container">
                  <div class="row">
                     <div class="col-lg-6 col-md-6 col-xs-12 col-sm-6">
                        <h2 class="title">赛事动态</h2>
                     </div>
                     <div class="col-lg-6 col-md-6 col-xs-12 col-sm-6">
                        <div class="breadcrumbs pull-right">
                           <ul>
                              <li>你所在位置:</li>
                              <li><a href="index.jsp">首页</a></li>
                              
                              <li>赛事动态</li>
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
                        <article class="post hentry">
                          <!-- content-top start -->
                        <div class="content-top col-lg-12 col-md-12 col-sm-11 col-xs-12 ">
                          <form action="anonymousSearchComInfo" method="post"> 
                          <div class="col-lg-3 col-md-3 col-xs-12 col-sm-2 ">
   						
   						<input type="text" class="form-control" value=""  name="competition.comName"  placeholder="请输入赛事名称">
   						</div>
   						<div class="col-lg-2 col-md-2 col-xs-12 col-sm-2 ">
					   		<select class="form-control" name="competition.scale">
					                <option value="">请选择竞赛级别</option>
								  	<option value="院级">院级</option>
								    <option value="校级">校级</option>
								    <option value="市级">市级</option>
								    <option value="省级">省级</option>
								    <option value="国家级">国家级</option>	
					              </select>
									        </div>
				   		<div class="col-lg-2 col-md-2 col-xs-12 col-sm-2 ">
				   		<select class="form-control" name="competition.type" >
				                <option value=2>请选择竞赛类型</option>
				   				<option value=0>竞赛</option>
				   				<option value=1>大创</option>	
				              </select>
				        </div>
					   		<div class="col-lg-3 col-md-3 col-xs-12 col-sm-2 ">
					   		<select class="form-control" name="competition.flag" >
					                <option value=2>请选择是否已经立项</option>
					   				<option value=1>已立项</option>
					   				<option value=0>未立项</option>
					              </select>
					        </div>
					        
					        <div class="col-lg-2 col-md-2 col-xs-12 col-sm-2 ">
					   		  <input type="submit"  class="btn-small btn-color  btn-space" value="查询">
					   			</div>
					   		</form>
					                  </div>
                  <!-- content-top end -->
                 <div id="splitline" class=" col-lg-12 col-md-12 col-sm-11 col-xs-12 "></div>
			        <div class=" col-lg-12 col-md-12 col-sm-11 col-xs-12 ">
                       
                        <table id="mytable" class="table table-striped table-bordered">
                           <thead>
                              <tr>
                                 <th class="col-lg-7 col-md-7 col-xs-7 col-sm-7 ">通知</th>
                                 <th class="col-lg-3 col-md-3 col-xs-3 col-sm-3 ">发布时间</th>
                                  <th class="col-lg-3 col-md-3 col-xs-2 col-sm-2 ">操作</th>
                             </tr>
                           </thead>
                           <tbody>
                             
                              <s:iterator value="list" id="x">
    							<tr><td id="comName"><s:property value="#x.comName"/></td>
    								<td id="publishTime"><s:date name="#x.publishTime" format="yyy/MM/dd" /></td>
    								<td><a href="check.action?competition.comId=<s:property value="comId"/>"><input type="button" value="查看" class="btn-small"></a></td>
    							</tr>
    						</s:iterator>
                           </tbody>
                        </table>
                         <div class="list  col-md-12  col-md-offset-2">
				共<span id="sjzl"></span>条
				<span id="btn0"></span> 
				<a href="#" id="btn1">首页</a>
				<a href="#" id="btn2">上一页</a> 
				<a href="#" id="btn3">下一页</a> 
				<a href="#" id="btn4">尾页</a>
				&nbsp;&nbsp;&nbsp;&nbsp;转到
			    <input id="changePage" type="text" size="1" maxlength="4" />&nbsp;页 
				<a href="#" id="btn5">跳转</a>
				
	       </div>
	         <ul class="pager pagerother">
                           <li class="next"><a href="#" >我要报名</a></li>
                  </ul>  
                     </div>
                        </article>
                     </div>
                     <!-- Left Section End -->
                  </div>
               </div>  
               </div>
         <!-- Content End -->
         </div>
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
      <script type="text/javascript" src="js/checklogin.js"></script>
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
     

    <script language="javascript">
            var pageSize = 8;    //每页显示的记录条数
            var curPage=0;        //当前页
            var lastPage;        //最后页
            var direct=0;        //方向
            var len;            //总行数
            var page;            //总页数
            var begin;
            var end;
			$(document).ready(function display(){   
                len =$("#mytable tr").length-1;    // 求这个表的总行数，去掉首航标题行
                page=len % pageSize==0 ? len/pageSize : Math.floor(len/pageSize)+1;//根据记录条数，计算页数
                //floor向下取整函数
                curPage=1;    // 设置当前为第一页
                displayPage(1);//显示第一页

                document.getElementById("btn0").innerHTML="当前 " + curPage + "/" + page + " 页    每页 "; //当前页/总页数
                document.getElementById("sjzl").innerHTML= len + "";        // 显示数据量
                document.getElementById("pageSize").value = pageSize;//每页显示条数
                $("#btn1").click(function firstPage(){    // 首页
                    curPage=1;//当前页
                    direct = 0;//方向
                    displayPage();
                });
                $("#btn2").click(function frontPage(){    // 上一页
                    direct=-1;
                    displayPage();
                });
                $("#btn3").click(function nextPage(){    // 下一页
                    direct=1;
                    displayPage();
                });
                $("#btn4").click(function lastPage(){    // 尾页
                    curPage=page;//总页数，即最后一页
                    direct = 0;
                    displayPage();
                });
                $("#btn5").click(function changePage(){    // 转页
                    curPage=document.getElementById("changePage").value * 1;//输入所需前往的页数
                    if (!/^[1-9]\d*$/.test(curPage)) {  //^[1-9]表示以1到9的某位数字开头    ^匹配开头  $结尾
                    	// \d*表示0-9的任意一位或者多位或者一位    正则表达式 /^[1-9]\d*$/  

                        alert("请输入正整数");
                        return ;
                    }
                    if (curPage > page) {
                        alert("超出数据页面");
                        return ;
                    }
                    direct = 0;
                    displayPage();
                });

                
                $("#pageSizeSet").click(function setPageSize(){    // 设置每页显示多少条记录
                    pageSize = document.getElementById("pageSize").value;    //获取目前每页显示的记录条数
                    if (!/^[1-9]\d*$/.test(pageSize)) {
                        alert("请输入正整数");
                        return ;
                    }
                    len =$("#mytable tr").length-1;
                    page=len % pageSize==0 ? len/pageSize : Math.floor(len/pageSize)+1;//根据记录条数，计算页数
                    curPage=1;        //当前页
                    direct=0;        //方向
                    firstPage();
                });
            });

            function displayPage(){
                if(curPage <=1 && direct==-1){
                    direct=0;
                    alert("已经是第一页了");
                    return;
                } else if (curPage >= page && direct==1) {
                    direct=0;
                    alert("已经是最后一页了");
                    return ;
                }

                lastPage = curPage;

                // 修复当len=1时，curPage计算得0的bug
                if (len > pageSize) {
                    //curPage = ((curPage + direct + len) % len);
                	curPage = curPage + direct;

                } else {
                    curPage = 1;
                }

                
                document.getElementById("btn0").innerHTML="当前 " + curPage + "/" + page + " 页    每页 ";        // 显示当前多少页

                begin=(curPage-1)*pageSize + 1;// 起始记录号
                end = begin + 1*pageSize - 1;    // 末尾记录号

                
                if(end > len ) end=len;
                $("#mytable tr").hide();    // 首先，设置这行为隐藏
                $("#mytable tr").each(function(i){    // 然后，通过条件判断决定本行是否恢复显示
                    if((i>=begin && i<=end) || i==0 )//显示begin<=x<=end的记录
                        $(this).show();
                });
             }
    </script> 