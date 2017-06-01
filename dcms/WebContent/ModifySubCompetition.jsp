<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Date,java.text.SimpleDateFormat
	"%>
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
	$(function(){
	var select = '<s:property value="subCompetion.college"/>';
	$("#chooosecollege option[value='"+select+"']").attr("selected",true);
	$("#back").click(function(){
		window.history.go(-1);
	});

	

	//格式检查
	$("#person1").change(function(){
		$("#person1Info").html("");
	});
	$("#chooosecollege").change(function(){
		$("#collegeInfo").html("");
	});
	$("#teacher").change(function(){
		$("#teacherInfo").html("");
	});

	//修改
	$("#subintro").val('<s:property value="subCompetion.awardIntr"/>');


	var timestr = '<s:date name="subCompetion.awarddate" format="yyyy-MM-dd" />';
	if(timestr!=null||timestr!=""){
		
		$("#time").attr("value",timestr);
		
	};
	$("#modify").click(function(){
		var flag=true;
		
		//格式检查
		//1.person
    	var person1 = $("#person1").val();
		if(person1==""||person1==null)
			{
			$("#person1Info").html('<font style="color:red">竞赛/项目参与人不能为空</font>');
			$("#person1").trigger("focus");
			flag=false;				
			console.log(flag);
			}
		//2.学院
		var college = $("#chooosecollege").val();
		if(college==""||college==null){
			$("#collegeInfo").html('<font style="color:red">学院不能为空</font>');
			$("#college").trigger("focus");
			flag=false;				
		}
		//3.指导老师
		var teacher = $("#teacher").val();
		if(teacher==""||teacher==null){
			$("#teacher").trigger("focus");
			flag=false;				
			$("#teacherInfo").html('<font style="color:red">指导老师不能为空</font>');
		}
		//4.申报书格式
		var book=$("#book").val();
		var patrn = /^.+(.doc|.docx)$/; 
		if(book!=null&&book!=""){
			if (!patrn.exec(book)) 
			{
				alert("上传文件格式不正确/doc/docx");
				flag=false;
			}
			
		}

		var agree=$("#agreement").val();
		if(agree!=null&&agree!=""){
			if (!patrn.exec(agree)) 
			{
				alert("上传文件格式不正确/doc/docx");
				flag=false;
			}
		}
		
		var pic=$("#award_pic").val();		
		var patrn2 = /^.+(.png|.jpeg|.jpg|.gif)$/; 
		if(pic!=null&&pic!=""){
			if (!patrn2.exec(pic)) 
			{
				alert("上传图片格式不正确");
				flag=false;
			}
		}
		//检查agreement
		return flag; 
		
    }); 	
	
	
	
	});
	
</script>

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
	<div class="content">
		<div class="competition">
		<!-- 这个是修改的action -->
			<form action="/dcms/modifySubcompStep2.action"
				enctype="multipart/form-data" method="post">
				<input  type="hidden" name="subCompetion.Subcompid" value=<s:property value="subCompetion.Subcompid"/>>
			<label>竞赛队长/项目第一负责人</label> 
				
				<!-- 这个是主键 给隐藏了这个一定要传过去的 修改的话 一定要用post -->
				
				<input id="person1" type="text" name="subCompetion.stuId1"
					value=<s:property value="subCompetion.stuId1"/>> 
					<span id="person1Info"></span>
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
				</select> 
								<span id="collegeInfo"></span>
				<br> 
			<label>团队名称（竞赛可选）</label>
				 <input name="subCompetion.teamName"
					value=<s:property value="subCompetion.teamName"/>> 
			<label>成员</label> 
					<input name="subCompetion.workName"
					value=<s:property value="subCompetion.workName"/> /> <br> 
			<label>指导老师</label>
				<input id="teacher" name="subCompetion.teacher"
					value=<s:property value="subCompetion.teacher"/> />
<span id="teacherInfo"></span>
					
				<div id="combook">
			<label>项目申报书</label>
                        <input id="book" type="file" name="compBook" value=<s:property value="subCompetion.compAgreementpath"/> >
         
                </div>
               <br>
         
               
				<div id="agreement">
				<label>	二级学院协议 </label>
				     <input id="agreement" type="file" name="compAgreement" value="compBook" />
					<hr>
				
                </div>
                <div>
   <label>获奖名称</label>
                        <input type="text" name="subCompetion.awardName" value=<s:property value="subCompetion.awardName"/> >
    <label>获奖等级</label>
                        <input type="text" name="subCompetion.awardGrade" value=<s:property value="subCompetion.awardGrade"/>>
                        <br>
       
       <!-- 修改 -->
             <label>获奖简介</label>
                        <textarea id="subintro" cols="20" 
                        name="subCompetion.awardIntr"></textarea>
                    <br>
                     <label>获奖时间</label>
                   <input id="time" type="date"  name="subCompetion.awarddate"/>
               <label>获奖图片</label>
                        <input id="award_pic" type="file" name="awardPic">
                </div>
                <hr>
                
                <div>
                <label>提示：若要更新文件、图片请选择文件、图片</label>
                <br>
                	<input id="modify" type="submit" value="提交" />
                	<input id="back" type="button" value="返回"/>
				</div>
			</form>
		</div>

	</div>
	<div class="foot">
		<pre>方山校区：南京市江宁区弘景大道3601号	邮编：211171	莫愁校区：南京市建邺区北圩路41号	邮编：210017
版本所有  2013 南京晓庄学院   苏ICP备16013351号	 苏公网安备 32011502010053号</pre>
	</div>
   	<script type="text/javascript" src="js/checklogin.js"></script>
</body>
</html>
<script src="js/jquery-1.7.min.js"></script>
<script src="js/js.js"></script>