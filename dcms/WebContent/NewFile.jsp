<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>
<form id="test" method="post" action="NewFile.jsp">
<div id="code"  name="plugin" value="123">asd</div>
    
<input type="submit" value="提交">
<br>
<%out.println(request.getParameter("plugin")); %>
</form>
</body>
</html>