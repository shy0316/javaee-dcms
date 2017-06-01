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
      <script src="js/jquery-1.7.min.js"></script>
      <script>
	$(function() {
		//初始化加载
			$.ajax({
				url:"loaddirectionary.action",
				type:"post",
				dataType:"json",
				data:{
					"classname":"com.nxdcms.entity.collegedictionary"
				},
				success : function(result) {
						for(var i in result){
							$("#college").append("<option value="+result[i].name+">--"+result[i].name+"--</option>");
						}
				},
				error:function(){
					alert("服务器繁忙");
				}
			});
		$("#add_info").click(
				function() {
					var flag = true;
					//格式检查
					//1.person
					var person1 = $("#person1").val();
					if (person1 == "" || person1 == null) {
						$("#person1Info").html(
								'<font style="color:red">竞赛/项目参与人不能为空</font>');
						$("#person1").trigger("focus");
						flag = false;
					}
					//2.学院
					var college = $("#college").val();
					if (college == "" || college == null) {
						$("#college").trigger("focus");
						flag = false;
						$("#collegeInfo").html(
								'<font style="color:red">学院不能为空</font>');
					}
					//3.指导老师
					var teacher = $("#teacher").val();
					if (teacher == "" || teacher == null) {
						$("#teacher").trigger("focus");
						flag = false;
						$("#teacherInfo").html(
								'<font style="color:red">指导老师不能为空</font>');
					}
					//4.申报书格式
					var book = $("#book").val();
					console.log(book);
					var patrn = /^.+(.doc|.docx)$/;
					if (book != "" && book != null) {
						if (!patrn.exec(book)) {
							alert("项目申报书文件格式不正确/doc/docx");
							flag = false;
						}

					}

					var agree = $("#agreement").val();
					if (agree != "" && agree != null) {
						if (!patrn.exec(agree)) {
							alert("二级学院协议文件格式不正确/doc/docx");
							flag = false;
						}
					}

					//检查agreement
					return flag;

				});
		//格式检查
		$("#person1").change(function() {
			$("#person1Info").html("");
		});
		$("#college").change(function() {
			$("#collegeInfo").html("");
		});
		$("#teacher").change(function() {
			$("#teacherInfo").html("");
		});
	});
</script>
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
                           <a  href="indexshowNews.action">
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
                           <a href="modifys1.action" class="sf-with-ul">
                           	参赛信息
                           </a>                        
                        </li>
                        <li>
                           <a href="listc.action" class="sf-with-ul">
                           	成果展示
                           </a>
                        </li>
                        <li>
                           <a id="current" href="personalset.jsp" class="sf-with-ul">
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
              <!-- Title, Breadcrumb Start-->
            <div class="breadcrumb-wrapper">
               <div class="container">
                  <div class="row">
                     <div class="col-lg-6 col-md-6 col-xs-12 col-sm-6">
                        <h2 class="title">报名信息</h2>
                     </div>
                     <div class="col-lg-6 col-md-6 col-xs-12 col-sm-6">
                        <div class="breadcrumbs pull-right">
                           <ul>
                              <li>你所在位置：</li>
                              
                              <li>报名信息录入</li>
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
            <!-- Sidebar srart -->       
                     <div class="sidebar col-lg-2 col-md-2 col-sm-4 col-xs-12">
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
                  
                  <div class="posts-block col-lg-10 col-md-10 col-sm-8 col-xs-12">
                  <form action="SaveCompetitionInfo.action" enctype="multipart/form-data" method="post"> 
                        <div class="table-responsive">
                         <!--  -->
                <div class="row bk-bg-very-light-gray">
                    <div class="col-lg-10 col-lg-offset-1 ">
                        
                              <h3 class="title">报名信息录入</h3>
                        <div class="row">
                             <div class="submitInfo" >
                                
                           <div class="col-lg-6 col-md-6 col-xs-12 col-sm-6 ">
                         
                               <label>作品名称: <span style="color: red">*</span></label>
                      <input class="form-control inputwidth"  id="name" name="subCompetion.production"  type="text" value=""  required>
                   <span id="person1Info"></span>
                             
                              <!-- /input-group -->
                              <br>
                          <label>竞赛队长/项目第一负责人: <span style="color: red">*</span></label>
                       <input class="form-control inputwidth"  id="person1" type="text" name="subCompetion.stuId1" value=""  required>
                    
                              <br>
                               <label>指导老师: <span style="color: red">*</span></label>
                      <input class="form-control inputwidth" id="teacher" name="subCompetion.teacher" type="text" value="" required>
                      <span id="teacherInfo"></span>
                              <br>
                            	
                             
                               <label>所在学院</label> <span style="color: red">*</span> 
								<select id="college"
									name="subCompetion.college"  class="form-control1 inputwidth1" data-toggle="dropdown">
								
									<option value="">--请选择学院--</option>
								<!-- 
									<option value="信息工程学院">--信息工程学院--</option>
									<option value="电子工程学院">--电子工程学院--</option>
									<option value="体育学院">--体育学院--</option>
									<option value="美术学院">--美术学院--</option>
									<option value="教师学院">--教师学院--</option>
									<option value="商学院">--商学院--</option>
									<option value="环境工程学院">--环境工程学院--</option>
								 -->
								</select><span id="collegeInfo"></span>
                                 <br>
                            	  <br>
                              
                               <label>项目申报书:&nbsp;&nbsp;</label> 
                    <input type="text"  name="upfile" id="upfile" >
								<input type="button" class="view"  value="浏览" onclick="book.click()"> 
								<input type="file" style="display: none" name="compBook" id="book" onchange="upfile.value=this.value">
                    <br>
                    <br>
                    
                      <label>二级学院协议:</label> <input type="text"
									name="upfile2" id="upfile2" style="border: 1px dotted #ccc">
								<input type="button" class="view"  value="浏览" onclick="book.click()">
								<input type="file" style="display: none" name="compAgreement" id="agreement" onchange="upfile2.value=this.value">
                      <br>
                      <br>
                           
                              
                           </div>
                           <div class="col-lg-6 col-md-6 col-xs-12 col-sm-6 ">
                            <label>团队名称(竞赛可选): <span style="color: red">*</span></label>
                      <input class="form-control" id="name" name="subCompetion.teamName" type="text" value="" required>
                    <br>
                           
                             
                             <label>第二负责人: </label>     
                     <input class="form-control" id="name" name="subCompetion.stuId2"  value="" required>
                     
                              <br>
                                
                              
                              <label>成员: </label>     
                    
                             <textarea class="form-control" rows="3" id="name" name="subCompetion.workName"  required></textarea>
                           <br>
                          <br>
                            
                           </div>
                          
                        </div>
                        </div>
                        
                         <div class="blog-divider col-md-12 bottom3"></div>
                    </div>
                    
                </div>
            </div>
                       <div class="pagination-centered bottom30px">
                       
                        <input type="button" id="add_info" class="btn btn-color btn-pad" value="提交">
                        </div>  
                       </form> 
                     </div>
                     
                    </div>
                   
                 </div>
                 
               
            </div>
             <!--  </form> -->
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
              <div id="loginid" style="display:none">${sessionScope.sid }</div>
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
      	<script type="text/javascript" src="js/checklogin.js"></script>
</body>
</html>
     
