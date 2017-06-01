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
      <meta name="author" content="dcms">
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
<style type="text/css">


.comid{
display:none;
}
.rows {
	display: none;
}



</style>
</head>

<body  class="home">
   <div class="wrap">
	 <header id="header">
            <!-- Header Top Bar Start -->
            <div class="top-bar">
               <div class="slidedown collapse">
                  <div class="container">
                     <div class="phone-email pull-left ">
                        <a><i class="icon-phone"></i> Call Us : 025 - 0000 0000</a>
                        <a href="mail%40example.html"><i class="icon-envelope"></i> Email : njxzc@example.com</a>
                     ${sessionScope.stuMess}<div id="loginid" style="display:none">${sessionScope.sid }</div>
                     
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
                              <a id="islogin" class="pull-right" style="display:none"  href="Student_login.jsp">Login Now</a>
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
                           <a  href="indexshowNews.action">
                          	 首页
                           </a>
                        </li>
                        <li>
                           <a id="current" href="queryNews.action" class="sf-with-ul">
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
	
		 <!-- Content Start -->
         <div id="main">
            <!-- Title, Breadcrumb Start-->
            <div class="breadcrumb-wrapper">
               <div class="container">
                  <div class="row">
                     <div class="col-lg-6 col-md-6 col-xs-12 col-sm-6">
                        <h2 class="title">个人中心</h2>
                     </div>
                     <div class="col-lg-6 col-md-6 col-xs-12 col-sm-6">
                        <div class="breadcrumbs pull-right">
                           <ul>
                              <li>你所在位置：</li>
                              <li><a href="index.jsp">首页</a></li>
                              
                              <li>个人中心</li>
                               <li>竞赛评分页面</li>
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
                     <div class="sidebar col-lg-3 col-md-3 col-sm-4 col-xs-12">
                     <div class="widget category">
                           <h3 class="title">设置</h3>
                          <ul class="category-list slide">
                              <li><a href="mycompetition.jsp">已报名的竞赛</a></li>
                              <li><a href="recommendCometition.jsp">推荐的竞赛</a></li>
                              <li><a href="personcenter.jsp">竞赛评分</a></li>
                              <li><a href="myFocusCompetition.jsp">我关注的竞赛</a></li>
                              <li><a href="personalset.jsp">个人信息设置</a></li>
                              <li><a href="#">系统更新</a></li>
                              <li><a href="#">关&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;于</a></li>
                              <li><a href="#">切换账号</a></li>
                              <li><a href="logout.action">退出登录</a></li>
                           </ul>
                        </div>
                    
                </div>
                     <!-- Sidebar End -->                
                <div class="posts-block col-lg-9 col-md-9 col-sm-8 col-xs-12">
						<div class="table-responsive">
							<div class="row bk-bg-very-light-gray">
								<div class="col-lg-12 ">
									<div class="panel">
										<div class="panel-body bk-bg-very-light-gray">
											<div class="table-responsive bk-vcenter">
												<h3 style="text-align: center">竞赛列表</h3>
												<table
													class="table table-striped  bootstrap-datatable datatable"
													id="mytable">
													<thead>
														<tr>
															<th >竞赛名称</th>
															<th >开始时间</th>
															<th >结束时间</th>
															<th >规模</th>
															<th >点击报名</th>
															<th >评分</th>
														</tr>
													</thead>
													<tbody id="competition">
														<!-- 此处插入 -->
													</tbody>
												</table>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
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
     <%--  <s:debug>y</s:debug> --%>
</body>
 <!-- The Scripts -->
    
 <script src="js/jquery-1.7.min.js"></script>
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
</html>
     
<script type="text/javascript">

	$(function() {
		$.ajax({
					url : "loadcompetition.action",
					type : "post",
					dataType : "json",
					success : function(data) {

						for (var i = 0; i < data.length; i++) {
							var item = data[i];
							$("#competition")
									.append(" <tr>"+ 
											"<td class=\"titletd\">"+item.comName+"</td>"+
											"<td>"+new Date(item.enterStart.time).format("yyyy-MM-dd")+"</td>"+ 
											"<td>"+new Date(item.enterStop.time).format("yyyy-MM-dd")+"</td>"+
											"<td>"+item.scale+"</td>"+ 
											"<td class=\"comid\" >"+item.comId+"</td>"+ 
											"<td>"+
											"    <button type=\"button\" class=\"btn btn-color\"><a class=\"aa\" href=\"addsubcompetition.jsp\">报名</a></button>"+
											"</td>"+
											"<td>"+
											" <button type=\"button\" class=\"btn btn-color click\" id=\"click"+(i+1)+"\" value=\"true\">点评></button>"+ 
											"</td>"+
											"</tr>"+
											"<tr class=\"starimg rows row"+(i+1)+"\">"+
											"    <td colspan=\"5\" class=\"col"+(i+1)+"\"><img src=\"imgs/1.png\"><img src=\"imgs/1.png\"><img src=\"imgs/1.png\"><img src=\"imgs/1.png\"><img src=\"imgs/1.png\"></td><td><input  type=\"button\" class=\"access\" value=\"确认\"/></td>"+
											"</tr>");
							var click = $("#click"+(i+1)+"");
							var row=$(".row"+(i+1)+"");
							var imgs=$(".col"+(i+1)+" img");							
									getrows(imgs,row,click);
							
							//	            $("#mycompetition").append("<tr><td class=\"titletd\"><a href=\"check.action?competition.comId="+competitionlist[i].comId+"\">"+competitionlist[i].comName+"</a></td></tr>");
							//	            $("#myperference").append("<tr><td class=\"titletd\">"+perferencelist[i].perferences+"</td></tr>");

						}
					},
					error : function() {
						alert("服务器繁忙");
					}
				});
		$("#competition").on("click", ".access", function(){
				var id = ${sessionScope.sid};
				var compId = $(this).parent().parent().prev().find(".comid").text();
			
				var perference=$(this).parent().parent().find("img[src=\"imgs/2.png\"]").length;
				$.ajax({
					url : "accesscompetition.action",
					type : "post",
					dataType : "json",
					data:{
						"userId":id,
						"itemId":compId,
						"perference":perference
					},
					success : function(data) {
							alert("评价成功");
					},
					error : function() {
						alert("服务器繁忙");
					}
				});
		});
	});
	function getrows(arg1, arg2, arg3) {
		var flag = true;
		arg3.click(function() {
			arg2.toggle("fast");
		});
		
		arg1.each(function() {

			$(this).mousemove(function() {
				if (flag == true) {
					arg1.attr("src", "imgs/2.png");
					$(this).nextAll().attr("src", "imgs/1.png");
				}
				$(this).click(function() {
					flag = false;
					var index = arg1.index($(this)) + 1;//在这里获取评分的分数
					arg1.attr("src", "imgs/2.png");
					$(this).nextAll().attr("src", "imgs/1.png");
				})
			})
			arg1.mouseleave(function() {
				if (flag == true) {
					arg1.attr("src", "imgs/1.png");
				}
			})
		});
	}
	
	Date.prototype.format = function(format) {

	    /*
	     * format="yyyy-MM-dd hh:mm:ss";
	     */
	    var o = {
	        "M+" : this.getMonth() + 1,
	        "d+" : this.getDate(),
	        "h+" : this.getHours(),
	        "m+" : this.getMinutes(),
	        "s+" : this.getSeconds(),
	        "q+" : Math.floor((this.getMonth() + 3) / 3),
	        "S" : this.getMilliseconds()
	    };
	    if (/(y+)/.test(format)) {
	            format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4- RegExp.$1.length));
	        }
	    for (var k in o) {
	        if (new RegExp("(" + k + ")").test(format)){
	            format = format.replace(RegExp.$1, RegExp.$1.length == 1? o[k]:("00" + o[k]).substr(("" + o[k]).length));
	        }
	    }
	    return format;
	    
	};
</script>