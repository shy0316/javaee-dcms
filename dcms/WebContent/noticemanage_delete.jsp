<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/index.css">
<title>删除公告</title>
</head>
<body>
<div class="top">
		<img src="imgs/logo.png" alt="logo" class="logo">

		<div class="aside">
			<input type="button" class="login" value="登录">
			<span class="manager"><a href="noticemanage.jsp">管理员</a></span>
			<div>
				<input type="text" class="text"><input type="button"
					value="搜索" class="search">
			</div>
		</div>
		<div class="noticenav" style="width: 100%;
	height: 100px;
	background: #09386b;
	margin-bottom: -20px;color:white;text-align:center;line-height:90px;
	font-size:32px;
	font-family: 'Microsoft YaHei';">
			公告管理中心
		</div>
	</div>
	<div style="height:400px;width:1000px;margin-top:100px;">
	<div style="position:absolute;top:200px;left:40%"><img src="imgs/6.png" ></div>
	<span class="back1"><a href="noticemanage.jsp">&nbsp;返回&nbsp;</a></span>
	<span class="back"><a href="notice/listnotice.action">&nbsp;查询&nbsp;</a></span>
	<div class="notice-a" style="position:absolute;left:400px;top:400px;">
<form action="notice/delnotice.action" method="post" >
<table style="border-collapse:separate;border-spacing:10px;"><!-- 边框分开 -->

<tr><td style="width:150px;height:50px;background:#09386b;color:white;text-align:center;line-height:30px;
	font-size:18px;
	font-family: 'Microsoft YaHei';">要删除的公告号</td><td><input type="text" name="notice.noticeId" style="width:150px;height:50px"></td></tr>
<tr><td><input type="submit" value="确认删除" style="font-family: 'Microsoft YaHei';width:120px;height:50px;background:#09386b;color:white;text-align:center;line-height:30px;position:absolute;top:100px;left:170px;border-radius:30%"></td> </tr>
</table>

</form>
</div>
</div>
	<div class="foot">
		<pre>方山校区：南京市江宁区弘景大道3601号	邮编：211171	莫愁校区：南京市建邺区北圩路41号	邮编：210017
版本所有  2013 南京晓庄学院   苏ICP备16013351号	 苏公网安备 32011502010053号</pre>
	</div>
</body>
</html>