<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>成果展示</title>
    <link rel="stylesheet"  type="text/css" href="css/showoutcome.css">
    <style type="text/css">
       a{
         color:#999;
       }
    </style>

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
       <div class="ppt">
            <div class="li"></div>
       </div>   
       <div class="left">
         <form action=""> 
           <ul class="messsage">
               <li class="out1">
                   <input type="button" value="+ACM竞赛">
                   <ul>
                       <li class="in1">&nbsp;&nbsp;<input type="button" value="2016年"></li>
                       <li class="in1">&nbsp;&nbsp;<input type="button" value="2015年"></li>
                       <li class="in1">&nbsp;&nbsp;<input type="button" value="2016年"></li>
                   </ul>
               </li>
               <li class="out2">
                   <input type="button" value="+蓝桥杯">
                   <ul>
                       <li class="in2">&nbsp;&nbsp;<input type="button" value="2016年"></li>
                       <li class="in2">&nbsp;&nbsp;<input type="button" value="2015年"></li>
                       <li class="in2">&nbsp;&nbsp;<input type="button" value="2016年"></li>
                   </ul>
               </li>
               <li class="out3">
                   <input type="button" value="+程序设计大赛">
                   <ul>
                       <li class="in3">&nbsp;&nbsp;<input type="button" value="2016年"></li>
                       <li class="in3">&nbsp;&nbsp;<input type="button" value="2015年"></li>
                       <li class="in3">&nbsp;&nbsp;<input type="button" value="2016年"></li>
                   </ul>
               </li>
           </ul>
        </form>
       </div>
       <div class="right">
           <p2 class="p01">优秀作品展示</p2>
           <table  cellspacing="0" cellpadding="0">
               <tr>
                   <td>队伍名称</td>
                   <td>获奖等级</td>
                   <td>指导老师</td>
                   <td>作品简介</td>
               </tr>
               <s:iterator value="list" id="x">
               
               <tr>
               <td><s:property value="id"/></td>
                   <td><s:property value="#x.awardGrade"/></td>
                   <td><s:property value="#x.teacher"/></td>
                   <td><s:property value="#x.workName"/></td>
                   <td><a href="###">修改</a></td>
               </tr>
               </s:iterator>  
           </table>
       </div>     
    </div>
   <div class="foot">
       <pre>方山校区：南京市江宁区弘景大道3601号	邮编：211171	莫愁校区：南京市建邺区北圩路41号	邮编：210017
版本所有  2013 南京晓庄学院   苏ICP备16013351号	 苏公网安备 32011502010053号</pre>
   </div>
</body>
</html>
<script src="js/jquery-1.7.min.js"></script>
<script src="js/showoutcome.js"></script>