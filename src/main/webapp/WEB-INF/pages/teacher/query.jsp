<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>老师管理</title>
    <%@include file="/WEB-INF/pages/common/header.jsp"%>
    <link href="${basePath}static/myframe/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="${basePath}static/myframe/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="${basePath}static/myframe/assets/css/main-min.css" rel="stylesheet" type="text/css" />
</head>
<body>
		<table>
			<tr>
				<td>序号</td>
				<td>教师实体类表的id</td>
				<td>教师编号</td>
				<td>教师姓名</td>
				<td>性别</td>
				<td>课程编号</td>
				<td>特长</td>
				<td>电话号码</td>
				<td>教师等级</td>
				<td>教师状态</td>
			</tr>
			<c:forEach items="${teachers }" var="teacher" varStatus="s">
				<tr>
					<td>${s.index+1 }</td>
					<td>${teacher.teaId }</td>
					<td>${teacher.teaNo }</td>
					<td>${teacher.teaName }</td>
					<td>${teacher.sex }</td>
					<td>${teacher.courseId }</td>
					<td>${teacher.specialty }</td>
					<td>${teacher.telephone }</td>
					<td>${teacher.teaLevel }</td>
					<td>${teacher.teaState }</td>
				</tr>
			</c:forEach>
		</table>
		<div class="page_and_btn">
			${tea.page.pageStr }
		</div>
</body>
</html>