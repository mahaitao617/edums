<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>

	<%@include file="/WEB-INF/pages/common/header.jsp"%>
    <link rel="stylesheet" type="text/css" href="${basePath}static/myframe/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${basePath}static/myframe/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="${basePath}static/myframe/Css/style.css" />
    <script type="text/javascript" src="${basePath}static/myframe/Js/jquery.js"></script>
   
    <script type="text/javascript" src="${basePath}static/myframe/Js/bootstrap.js"></script>
    <script type="text/javascript" src="${basePath}static/myframe/Js/ckform.js"></script>
    <script type="text/javascript" src="${basePath}static/myframe/Js/common.js"></script>

 

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
</head>
<body>

<form class="form-inline definewidth m20" action="user.html" method="post">    
    用户名称：
    <input type="text" name="username" id="username"class="abc input-default" placeholder="" value="">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; <button type="button" class="btn btn-success" id="addnew">新增用户</button>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>用户id</th>
        <th>用户名称</th>
        <th>真实姓名</th>
        <th>最后登录时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
	    <!--  <tr>
            <td>2</td>
            <td>admin</td>
            <td>管理员</td>
            <td></td>
            <td>
                <a href="edit.html">编辑</a>                
            </td>
        </tr>	 -->
        <c:forEach var="user" items="${userList }">
        	 <tr>
	            <td>${user.userId}</td>
	            <td>${user.username}</td>
	            <td>${user.loginname}</td>
	            <td>${user.lastLogTime}</td>
	            <td>
	                <a href="edit.html">编辑</a>                
	            </td>
        	</tr>	
        </c:forEach>
        
     </tbody>
</table>
<div class="page_and_btn">
		${page.pageStr }
</div>
<script>

    $(function () {
        

		$('#addnew').click(function(){
				alert("dd");
				window.location.href="user/add.html";
		 });


    });

	function del(id)
	{
		
		
		if(confirm("确定要删除吗？"))
		{
		
			var url = "index.html";
			
			window.location.href=url;		
		
		}
	
	
	
	
	}
</script>
</body>
</html>