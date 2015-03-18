<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>班级管理</title>
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
	<p>欢迎来到班级管理界面</p>
	<!-- 这里的action的URL，也是相当于原来这个页面的URL。如果没有表单，分页Page会自动建造一个a标签来实现，如果写了表单，就会根据这个URL来分页 -->
	<form class="form-inline definewidth m20" action="welcome.html" method="post">    
	   班级类型：
	    <input type="text" name="classType" id="classType" class="abc input-default" placeholder="" value="java">&nbsp;&nbsp;  
	    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; 
	    <button type="button" class="btn btn-success" id="addnew">新增班级</button>
	</form>
	<table class="table table-bordered table-hover definewidth m10">
	    <thead>
		    <tr>
		        <th>班级id</th>
		        <th>班级编号</th>
		        <th>建班时间</th>
		        <th>封班时间</th>
		        <th>班级类型</th>
		        <th>班级人数限制</th>
		        <th>创建人</th>
		        <th>班主任</th>
		        <th>班级描述</th>
		        <th>班级状态</th>
		        <th>是否删除</th>
		        <th>操作</th>
		    </tr>
	    </thead>
	    <tbody>	<!-- JS中，任何的变量都不能取名为保留字，出错了，不容易调试 这里出错了class，调试了半天 -->
		<c:forEach items="${classList}" varStatus="index" var="classes">
	       	 <tr>
	            <td>${index.index + 1}</td>
	            <td>${classes.classesNo}</td>
	            <td>${classes.buildTime}</td>
	            <td>${classes.closeTime}</td>
	            <td>${classes.classesType}</td>
	            <td>${classes.numLimit}</td>
	            <td>${classes.buildPerson}</td>
	            <td>${classes.headerTea}</td>
	            <td>${classes.describle}</td>
	            <td>${classes.classState}</td>
	            <td>${classes.isDelete}</td> 
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
				alert("新建班级");// 测试
				window.location.href="createClass.html";
		 });
    });
</script>
</body>
</html>