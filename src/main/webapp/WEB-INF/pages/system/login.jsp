<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/WEB-INF/pages/common/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>后台管理系统</title>
   	<link rel="stylesheet" type="text/css" href="${basePath}static/myframe/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${basePath}static/myframe/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="${basePath}static/myframe/Css/style.css" />
   <%--  <script type="text/javascript" src="${basePath}static/myframe/Js/jquery.js"></script> --%>
<%--     <script type="text/javascript" src="${basePath}static/myframe/Js/jquery.sorted.js"></script> --%>
    <script type="text/javascript" src="${basePath}static/myframe/Js/bootstrap.js"></script>
    <script type="text/javascript" src="${basePath}static/myframe/Js/ckform.js"></script>
    <script type="text/javascript" src="${basePath}static/myframe/Js/common.js"></script>
    
    <style type="text/css">
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
        }

        .form-signin {
            max-width: 300px;
            padding: 19px 29px 29px;
            margin: 0 auto 20px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
        }

        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }

        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }

    </style>  
</head>
<body>



<div class="container"> 
	
	<div class="alert alert-error">
	  <button type="button" class="close" data-dismiss="alert">&times;</button>
	  	${errInfo}
	 </div>

    <form class="form-signin" method="post" action="login.html">
        <h2 class="form-signin-heading">登录系统</h2>
        <input type="text" name="loginname" class="input-block-level" placeholder="请输入你的用户名" value="admin">
        <input type="password" name="password" class="input-block-level" placeholder="请输入你的密码" value="admin">
       	<input type="text" name="code" id="code" class="login_code" placeholder="请输入验证码"/>
       	<img id="codeImg" alt="点击更换" title="点击更换" src=""/>
					
        <p><button class="btn btn-large btn-primary" type="submit">登录</button></p>
    </form>

</div>
<script type="text/javascript">

		var errInfo = "${errInfo}";
		$(document).ready(function(){
			if(errInfo==''){
			
				$(".alert").alert('close');
			}
			changeCode();
			$("#codeImg").bind("click",changeCode);
			if(errInfo!=""){
				if(errInfo.indexOf("验证码")>-1){
					$("#codeerr").show();
					$("#codeerr").html(errInfo);
					$("#code").focus();
				}else{
					$("#nameerr").show();
					$("#nameerr").html(errInfo);
				}
			}
			$("#loginname").focus();
		});
	
		function genTimestamp(){
			var time = new Date();
			return time.getTime();
		}
	
		function changeCode(){
			$("#codeImg").attr("src","code.html?t="+genTimestamp());
		}
		
		function resetErr(){
			$("#nameerr").hide();
			$("#nameerr").html("");
			$("#pwderr").hide();
			$("#pwderr").html("");
			$("#codeerr").hide();
			$("#codeerr").html("");
		}
		
		function check(){
			resetErr();
			if($("#loginname").val()==""){
				$("#nameerr").show();
				$("#nameerr").html("用户名不得为空！");
				$("#loginname").focus();
				return false;
			}
			if($("#password").val()==""){
				$("#pwderr").show();
				$("#pwderr").html("密码不得为空！");
				$("#password").focus();
				return false;
			}
			if($("#code").val()==""){
				$("#codeerr").show();
				$("#codeerr").html("验证码不得为空！");
				$("#code").focus();
				return false;
			}
			return true;
		}
	</script>
</body>
</html>