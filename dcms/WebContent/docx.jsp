<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>南京晓庄学院学科竞赛管理系统</title>
<link rel="stylesheet" href="css/index.css">
<!-- Ueditor编辑器CSS -->
<link href="css/umeditor.min.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.7.min.js"></script>
<script type="text/javascript" src="js/basevalue.js"></script>
<script>
$(function(){
		<%String body = (String)request.getAttribute("content");
		System.out.println(body);%>
	var body='<%=body%>';
	console.log(body);
		um.setContent(body);
		um.setDisabled();
});

</script>
</head>
<body>
	<div class="top">
		<img src="images/logo.png" alt="logo" class="logo">

		<div class="aside">
			<input type="button" class="login" value="登录"><br>
			<br>
			<br>
			<div>
				<input type="text" class="text"><input type="button"
					value="搜索" class="search">
			</div>
		</div>
		<div class="nav">
			<ul>
				<li><a href="">首页</a></li>
				<li><a href="">新闻中心</a></li>
				<li><a href="">赛事动态</a></li>
				<li><a href="">参赛信息</a></li>
				<li><a href="">成果展示</a></li>
			</ul>
		</div>
	</div>


	<div class="row">
		<div class="col-sm-12">
			<!--- 输入框script的组建。 --->
			<script type="text/plain" id="myEditor"
				style="width: 100%; height: 400px;">
										</script>

			<!--- 输入框 --->
		</div>
	</div>
	<div class="col-sm-7" id='pc_part_5' style='display: none;'>
		<div class="pc_top_third">
			<div class="row">
				<div class="col-xs-9">
					<h3>预览笔记</h3>
				</div>
			</div>
		</div>
		<aside class="side-right" id='fifth_side_right'>
		<div class="module" data-toggle="niceScroll">
			<div class="chat-contact">
				<div class="contact-body clear_margin">
					<h4 id="noput_note_title"></h4>
					<p></p>
				</div>
			</div>
		</div>
		</aside>
	</div>
</body>
<script type="text/javascript" charset="utf-8"
	src="js/ue/umeditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="js/ue/umeditor.min.js"></script>
<script type="text/javascript" src="js/ue/lang/zh-cn.js"></script>


<script>	
var um = UM.getEditor('myEditor');
</script>
<div class="foot">
	<pre>方山校区：南京市江宁区弘景大道3601号	邮编：211171	莫愁校区：南京市建邺区北圩路41号	邮编：210017
版本所有  2013 南京晓庄学院   苏ICP备16013351号	 苏公网安备 32011502010053号</pre>
</div>

</html>
