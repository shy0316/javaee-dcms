function CheckStuMail(){
	var mail=document.getElementById("studentEmail").value;
	CheckMail(mail);
}
function checkStuPhone(){
	var phone=document.getElementById("studentPhone").value;
	CheckPhone(phone);
}
//验证邮箱格式
function CheckMail(mail) {
	if(mail==""||mail==null){
		alert("邮箱不能为空");
	}
	///^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/
	///^[A-Za-zd]+([-_.][A-Za-zd]+)*@([A-Za-zd]+[-.])+[A-Za-zd]{2,5}$/
	 var filter  = /^[A-Za-zd]+([-_.][A-Za-zd]+)*@([A-Za-zd]+[-.])+[A-Za-zd]{2,5}$/;
	 if (filter.test(mail)) 
		return true;
	 else {
	 	alert('您的电子邮件格式不正确');
	 	return false;
	 	}
	}
//验证手机格式
function CheckPhone(phone){ 
    var filter = /^1[34578]\d{9}$/;
    if (filter.test(phone)) 
		return true;
	 else {
	 	alert('您的手机格式不正确');
	 	return false;
	 	} 
} 

//更换验证码
$("#changeCode").click(function(){
	$.ajax({
		url:"createCode.action",
		data:"{}",
		type:"post",
		success:function(data){
			document.getElementById("code").src=data;
//			$("#code").attr("src",data);
		},
		error:function(){
		}
	});
	
	
});

function ChangePic(){
	
//	var dt=new Date();
//	document.getElementById('code').src='createCode.action';
}

//function Student_regist(){
//	var stuId=$("#stuId").val();
//	var stupassword=$("#stuPassword").val();
//	//1.非空判断
//	var isLogin=loginNullCheck();
//	//2.用户名是否存在判断
//	var isIdExit=stuIdCheck();
//	//3.验证码判断
//	var isCodeExit=codeCheck;
//	if(isLogin && isIdExit && isCodeExit){
//		$.ajax({
//			url:"regist_Student?stuId="+stuId+"&stuPassord="+stuPassword,
//			data:"{}",
//			type:"post",
//			success:function(){
//				alert("")
//			},
//			error:function(){
//				
//			}
//				
//		});
//	}
//	return false;
//	
//}

//显示学生信息
$("#StuInfocheck").click(function(){
	var name=1;
	$.ajax({
		 url: 'showStuInfo.action',  
         type: 'post',  
         dataType: 'json',  
         data:"{}",
         success:function(result){
        	 //result中为n个对象，proName为第n个对象(学生)
        	 //name取出对象属性，student[name]取出属性值
        	 for(var proName in result){
        		 var student=result[proName];
        		 for(var name in student){
        			var valueStu=student[name];
//	        			$("#studnetName").attr("value",student[studnetName]);
        			if(document.getElementById(name)!=null){
        				document.getElementById(name).value=valueStu;
        			}
        		 }

        	 }
         },
         error:function(XMLHttpRequest,textStatus, errorThrown){
        	 alert(XMLHttpRequest.status);//200正常响应
             alert(XMLHttpRequest.readyState);//4处理状态正常接收
             alert(XMLHttpRequest.responseText);//返回响应文本
             alert(textStatus);
         }
    });
});


//修改学生密码(struts)
function stuModiPass(){
	var stuOldPassword=document.getElementById("stuOldPassword").value;
	var stuNewPassword=document.getElementById("stuNewPassword").value;
	var stuConfirmPassword=document.getElementById("stuConfirmPassword").value;
	if(stuOldPassword==null || stuOldPassword=="" || stuNewPassword==null || stuNewPassword==""|| stuConfirmPassword==null || stuConfirmPassword==""){
		alert("密码不能为空");
		return false;
	}
	if(stuNewPassword!=stuConfirmPassword){
		alert("新密码与确认密码不匹配");
		return false;
	}
	//向StuPasswordcheck发送请求
	$.ajax({
		 url: 'StuPasswordcheck.action',  
         type: 'post',  
         data:{"oldPass":stuOldPassword,"newPass":stuNewPassword,"confirmPass":stuConfirmPassword},  
         cache: false,  
         //beforeSend: LoadFunction, //加载执行方法    
         error: erryFunction,  //错误执行方法    
         success: succFunction //成功执行方法 	         	         
	})
	function erryFunction(XMLHttpRequest,textStatus, errorThrown) {  
        alert("系统异常，修改密码失败");  
        alert(XMLHttpRequest.status);
        alert(XMLHttpRequest.readyState);  
        alert(textStatus);  
    } 
	function succFunction(tt){
		alert(tt);
	}	
}

var stuPassword=document.getElementById("stuPassword");
//var password=$("#stuPassword").val();
//学生登录密码非空判断
function passNullCheck(){
	alert(stuPassword);
	if(password==null|| password==""){
		alert("密码不能为空");
		return false;
	}
	return true;
}

function checkConfirmPass(){
	var stuConfirmPassword=document.getElementById("stuConfirmPassword");
	//var stuConfirmPassword=$("#stuConfirmPassword").val();
	alert("密码"+password+stuConfirmPassword);
	if(stuPassword==stuConfirmPassword){
		return true;
	}else{
		alert("两次密码输入不一致！");
		return false;
	}
}
//判断学生账号是否存在以及非空
function stuIdCheck(){
	var stuId=$("#stuId").val();
	if(stuId==""|| stuId==null){
		alert("用户名不能为空");
		return false;
	}
	$.ajax({
		url:"stuIdCheck.action?stuId="+stuId,
		data:"{}",
		type:"get",
		success:function(data){
			if(data=="true"){
				alert("该用户名已经存在！");
//				document.getElementById("msg_regist").innerHTML="该用户名已经存在！";
//				$("#msg_regist").attr("value",'该用户名已经存在！');
				return false;
			}else if(data=="false"){
				return true;
			}		
		},
		error:function(){
			alert("系统故障，请稍后再试!");
		}
	});
}
//判断验证码是否正确
function codeCheck(){
	var rand=$("#rand").val();
	alert(rand);
	$.ajax({
		url:"codeCheck?rand="+rand,
		data:"{}",
		type:"get",
		success:function(data){
			if(data=="true"){
				document.getElementById("codemsg").innerHTML="验证码正确";
				return true;
			}else if(data=="false"){
				document.getElementById("codemsg").innerHTML="验证码错误";
				return false;
			}
		},
		error:function(){
			
		}
	});
}

