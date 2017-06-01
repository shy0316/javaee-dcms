<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<meta charset="UTF-8">
<title>南京晓庄学院学科竞赛管理系统</title>
<link rel="stylesheet" href="css/index.css">
</head>
<script src="js/jquery-1.7.min.js">
	
</script>
<script>
	$(function() {

		var select = '<s:property value="subCompetion.college"/>';
		console.log(select);
		$("#chooosecollege option[value='" + select + "']").attr("selected",
				true);

		$("#back").click(function() {
			window.history.go(-1);
		});

		var awardpath = '${subCompetion.awardPicpath}';
		if (awardpath != ""&& awardpath!=null) {
	$("#award").show();
		}
		var bookpath = '${subCompetion.compBookpath}';
		if (bookpath != ""&& bookpath!=null) {
	$("#combook").show();
		}
		
		var agreepath = '${subCompetion.compAgreementpath}';
		if (agreepath != ""&& agreepath!=null) {
	$("#agreement").show();
		}
		console.log(awardpath);
		console.log(bookpath);
		console.log(agreepath);
	});
</script>

<body>
	<div class="top">
		<img src="images/logo.png" alt="logo" class="logo">

		<div class="aside">
			<input type="button" class="login" value="登录"><br> <br>
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
	<div class="content">
		<div class="competition">
			<form action="SaveCompetitionInfo.action"
				enctype="multipart/form-data" method="post">
		     <label>竞赛队长/项目第一负责人</label>
		        <input type="text" name="subCompetion.stuId1"
					value=<s:property value="subCompetion.stuId1"/>> 
			<label>第二负责人</label> 
					<input type="text" name="subCompetion.stuId2"
					value=<s:property value="subCompetion.stuId2"/>> <br>
			<label>所在学院</label> 
				<select id="chooosecollege" name="subCompetion.college">
					<option value="">--请选择学院--</option>
					<option value="信息工程学院">--信息工程学院--</option>
					<option value="电子工程学院">--电子工程学院--</option>
					<option value="体育学院">--体育学院--</option>
					<option value="美术学院">--美术学院--</option>
					<option value="教师学院">--教师学院--</option>
					<option value="商学院">--商学院--</option>
					<option value="环境工程学院">--环境工程学院--</option>
				</select> <br> 
			<label>团队名称（竞赛可选）</label> 
				<input name="subCompetion.teamName"
					value=<s:property value="subCompetion.teamName"/>> 
			<label>成员</label>
			 <input	name="subCompetion.workName"
					value=<s:property value="subCompetion.workName"/> /> <br>
			<label>指导老师</label>
				 <input name="subCompetion.teacher"
					value=<s:property value="subCompetion.teacher"/> />
				<hr>
				<div id="combook" style="display: none">
			<label>项目申报书</label> 
					<a  style="color:orange" target="_blank"
						type="application/msword"
						href="http://localhost:8080/dcms/file/<s:property value="subCompetion.compBookName"/>">
						<s:property value="subCompetion.compBookName" />
					</a> <span><a style="color: green" target="_blank"
						href="/dcms/LoadDocx.action?subCompetion.Subcompid=<s:property value="subCompetion.Subcompid"/>
						&subCompetion.compBookName=<s:property value="subCompetion.compBookName"/>">
						预览</a></span>
				</div>
<s:debug></s:debug>
				<div id="agreement" style="display: none">
			<label>二级学院协议 </label>
				<a  style="color:orange"
					type="application/msword" 
						target="_blank"
						href="http://localhost:8080/dcms/file/<s:property value="subCompetion.compAgreementName"/>">
						<s:property value="subCompetion.compAgreementName" />
					</a>
					<a style="color: green" target="_blank"
						href="/dcms/LoadDocx.action?subCompetion.Subcompid=<s:property value="subCompetion.compAgreementName"/>">预览</a></span>
			
					<hr>
			
				</div>
<!-- 修改 -->
				<div id="award" style="display: none">
				<label>获奖图片 :</label>
					<a style="color:green" href="http://localhost:8080/dcms/file/${subCompetion.awardPicName}"  target="_blank">查看</a>
				</div>
					<input id="back" type="button" value="返回" />
			</form>
		</div>

	</div>
	<div class="foot">
		<pre>方山校区：南京市江宁区弘景大道3601号	邮编：211171	莫愁校区：南京市建邺区北圩路41号	邮编：210017
版本所有  2013 南京晓庄学院   苏ICP备16013351号	 苏公网安备 32011502010053号</pre>
	</div>
   	<script type="text/javascript" src="js/checklogin.js"></script>
   	        <div id="loginid" style="display:none">${sessionScope.sid }</div>
</body>
</html>
<script src="js/jquery-1.7.min.js"></script>
<script src="js/js.js"></script>