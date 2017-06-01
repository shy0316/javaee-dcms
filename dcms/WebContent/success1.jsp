<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/notice.css">
<link rel="stylesheet" href="../css/index.css">
<title>成功</title>
</head>
<body>
	<div class="top">
		<img src="../imgs/logo.png" alt="logo" class="logo">

		<div class="aside">
			<input type="button" class="login" value="登录"> <span
				class="manager"><a href="/competion/index.jsp">管理员</a></span>
			
		</div>
		<div class="noticenav"
			style="width: 100%; height: 100px; background: #09386b; margin-bottom: -20px; color: white; text-align: center; line-height: 90px; font-size: 32px; font-family: 'Microsoft YaHei';">
			公告管理中心</div>
	</div>
	<span
		style="position: absolute; top: 410px; left: 50%; background: #09386b; color: white; text-align: center; border-radius: 50%; line-height: 40px; font-size: 16px; font-family:"
		MicrosoftYaHei""><a href="searchnotice.action">&nbsp;返回&nbsp;</a></span>
	<div
		style="position: relative; top: 180px; left: 45%; color: #09386b; font-size: 24px; font-family: 'Microsoft Yahei'">
		${message}</div>
	<div class="foot" style="position: relative; top:400px;">
		<pre>方山校区：南京市江宁区弘景大道3601号	邮编：211171	莫愁校区：南京市建邺区北圩路41号	邮编：210017
版本所有  2013 南京晓庄学院   苏ICP备16013351号	 苏公网安备 32011502010053号</pre>
	</div>
</body>
</html>