<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 包含头部信息用于适应不同设备 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 包含 bootstrap 样式表 -->
<link rel="stylesheet"
	href="http://apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap.min.css">

</head>
<body>
	<div class="container">
		<div class="alert alert-success">
			<h2 align="center">${message}</h2>
			<h2 align="center">newsPhotoFileName=${newsPhotoFileName}</h2>
		</div>
		<a class="btn btn-success goto_bt" href="showNews.action"
				role="button" style="margin:20px auto;"> <span class="glyphicon glyphicon-search"></span>&nbsp;&nbsp;返回管理中心
		</a>
	</div> 
	<!-- JavaScript 放置在文档最后面可以使页面加载速度更快 -->
	<!-- 可选: 包含 jQuery 库 -->
	<script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<!-- 可选: 合并了 Bootstrap JavaScript 插件 -->
	<script
		src="http://apps.bdimg.com/libs/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>