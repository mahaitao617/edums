<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>老师管理</title>
<%@include file="/WEB-INF/pages/common/header.jsp"%>
<link href="${basePath}static/myframe/assets/css/dpl-min.css"
	rel="stylesheet" type="text/css" />
<link href="${basePath}static/myframe/assets/css/bui-min.css"
	rel="stylesheet" type="text/css" />
<link href="${basePath}static/myframe/assets/css/main-min.css"
	rel="stylesheet" type="text/css" />
<link href="${basePath}static/css/teachermnt/teacherIndex.css"
	rel="stylesheet" type="text/css"/>
<link href="${basePath}static/css/teachermnt/teacher.css"
	rel="stylesheet" type="text/css"/>
</head>
<body>
	<form class="form-inline definewidth m20" action="teacherIndex.html" method="post" id="findtea">
		教师编号:<input type="text" name="teaNo" class="abc input-default" /> 
		教师姓名:<input type="text" name="teaName" class="abc input-default" />
		性别:<input type="text" name="sex" class="abc input-default" />
		<button type="submit" class="btn btn-primary">查询</button>
	</form>
	<form class="form-inline definewidth m20"  action="addTeacher1.html" method="post" id="addnew">
		<button type="submit" class="btn btn-success">新增教师</button>
	</form>
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th>序号</th>
				<th>教师编号</th>
				<th>教师姓名</th>
				<th>性别</th>
				<th>课程编号</th>
				<th>课程名</th>
				<th>特长</th>
				<th>电话号码</th>
				<th>教师等级</th>
				<th>教师状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${teachers }" var="teacher" varStatus="s">
				<tr>
					<td>${s.index+1 }</td>
					<td>${teacher.teaNo }</td>
					<td>${teacher.teaName }</td>
					<td>${teacher.sex }</td>
					<td>${teacher.courseId }</td>
					<td>${teacher.course.courseName }</td>
					<td>${teacher.specialty }</td>
					<td>${teacher.telephone }</td>
					<td>${teacher.teaLevel }</td>
					<td>${teacher.teaState }</td>
					<td><a href="./teaUpdate.jsp?teacher=${teacher }">编辑</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="page_and_btn">${page.pageStr }</div>
</body>
</html>