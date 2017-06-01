<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>南京晓庄学院学科竞赛管理系统</title>
    <link rel="stylesheet" href="css/index.css">
</head>
<body>
   <div class="top">
       <img src="imgs/logo.png" alt="logo" class="logo">
       
       <div class="aside">
          <input type="button" class="login" value="登录"><br><br><br>
           <div><input type="text" class="text"><input type="button" value="搜索" class="search"></div>
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
       <div>
           <form action="SaveCompetitionInfo.action" enctype="multipart/form-data">
               竞赛队长/项目第一负责人 
                   <input type="text" name="Subcompetition.stuId1">
               第二负责人
                   <input type="text" name="Subcompetition.stuId2">
               <br>
               所在学院
                  
                    <select name = "Subcompetition.college">
                        <option value="">--请选择学院--</option>
                        <option value="xinxi">--信息工程学院--</option>
                        <option value="dianzi">--电子工程学院--</option>
                        <option value="tiyu">--体育学院--</option>
                        <option value="meishu">--美术学院--</option>
                        <option value="jiaoshi">--教师学院--</option>
						<option value="shang">--商学院--</option>
						<option value="huanjing">--环境工程·学院--</option>
                    </select>
               <br>
               团队名称（竞赛可选）
                   <input name="Subcompetition.teamName">
               成员
                   <input name="Subcompetition.workName" />
				<br>
				指导老师
					<input name="Subcompetition.teacher" />
            <hr>
              项目申报书 
                  <input type="file" name="compBook" / >
               <br>
              二级学院协议
                  <input type="file" name="compAgreement" />
               <hr>
               <input type="submit" value="提交"/>
               
           </form>
           
           
       </div>
   </div>
   <div class="foot">
       <pre>方山校区：南京市江宁区弘景大道3601号	邮编：211171	莫愁校区：南京市建邺区北圩路41号	邮编：210017
版本所有  2013 南京晓庄学院   苏ICP备16013351号	 苏公网安备 32011502010053号</pre>
   </div>
    
</body>
</html>
<script src="js/jquery-1.7.min.js"></script>
<script src="js/js.js"></script>