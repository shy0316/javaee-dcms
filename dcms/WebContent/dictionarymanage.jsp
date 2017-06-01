<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script src="js/jquery-1.7.min.js"></script>
<script type="text/javascript">
	$(function() {
		$.ajax({
			url : "loadManage.action",
			type : "post",
			dataType : "json",
			data : {

			},
			success : function(result) {
				var select = $("#dictionary_type");
				select.empty();
				select.append("<option value=\"\">请选择</option>");
				//对象
				for(var i in result){
					var item = result[i];
					select.append("<option value='"+item.className+"'>"+item.chineseName+"</option>");
				}
			},
			error : function() {
				alert("服务器繁忙");
			}
		});
		
		$("#dictionary_type").change(function() {
							var classname = $(this).val();
							$.ajax({
										url : "/dcms/loaddirectionary.action",
										type : "post",
										dataType : "json",
										data : {
											"classname" : classname
										},
										success : function(result) {
											$("#dictionary_list").empty();
											for ( var i in result) {
												var name = result[i].name;
												var sli = "";
												sli += "<li>";
												sli += "<span>" + name
														+ "</span>";
												sli += "<button class=\"dictionary\">修改</button>"
												sli += "<button class=\"dictionary delete\" value=\""
														+ name
														+ "\" onclick=\"fun(this)\">删除</button>";
												sli += "</li>";
												var $li = $(sli);
												$li.data("class", classname);
												$("#dictionary_list").append(
														$li);
											}
										},
										error : function() {
											alert("服务器繁忙");
										}
									});
						});
	});
	function fun(btn) {
		$item = $(btn);
		var classname=$item.parent().data("class");
		var ans = confirm("是否要删除选中的值");
		if (ans == true) {
			//调用ajax
			$.ajax({
				url : "/dcms/deletedictionary.action",
				type : "post",
				dataType : "json",
				async:false, 
				data : {
					"name" : btn.value,
					"classname":classname
				},
				success : function(result) {
						reload(classname);
				},
				error : function() {
					alert("服务器繁忙");
				}
			});
		}
	}
	function reload(classname){
		$.ajax({
			url : "/dcms/loaddirectionary.action",
			type : "post",
			dataType : "json",
			data : {
				"classname" : classname
			},
			success : function(result) {
				$("#dictionary_list").empty();
				for ( var i in result) {
					var name = result[i].name;
					var sli = "";
					sli += "<li>";
					sli += "<span>" + name
							+ "</span>";
					sli += "<button class=\"dictionary\">修改</button>"
					sli += "<button class=\"dictionary delete\" value=\""
							+ name
							+ "\" onclick=\"fun(this)\">删除</button>";
					sli += "</li>";
					var $li = $(sli);
					$li.data("class", classname);
					$("#dictionary_list").append(
							$li);
				}
			},
			error : function() {
				alert("服务器繁忙");
			}
		});
	}
	
	
</script>
<style type="text/css">
ul li {
	list-style: none;
}

.dictionary {
	display: inline-block;
}
</style>
</head>
<body>
	<div id="dictionary_part">
		<div id="dictionary_head">
			<select id="dictionary_type">
				<option value="">请选择</option>
				<!-- 
				<option value="com.nxdcms.entity.compLeveldictionary">竞赛级别</option>
				<option value="com.nxdcms.entity.competitiondictionary">竞赛类型</option>
				<option value="com.nxdcms.entity.collegedictionary">院系类型</option>
				 -->
			</select>
		</div>
		<div id="dictionary_content">
			<ul id="dictionary_list">
			</ul>
		</div>
	</div>
</body>
</html>