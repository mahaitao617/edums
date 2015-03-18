<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <%@include file="/WEB-INF/pages/common/header.jsp"%>
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="${basePath}static/css/coursemnt/addCourse.css" />
</head>
<body>
<center>
	增加一门课程，（cs没有起作用）
	<br>
	<form action="${basePath}course/add.html" method="post">
	
		<table>
			<tr>
				<td class="tdLeft">课程名称:</td>
				<td class="tdRight"><input type="text" name="name"></td>
			</tr>
			<tr>
				<td class="tdLeft">课时:</td>
				<td class="tdRight"><input type="text" name="courseHour"></td>
			</tr>
			<tr>
				<td class="tdLeft">课程状态：</td>
				<td class="tdRight"><select name="state"><option value="即将开课">即将开课</option>
						<option value="正在上课">正在上课</option>
						<option  value="结课">结课</option></select><!-- <input type="text"name="state" > --></td>
			</tr>
			<tr>
				<td class="tdLeft">课程类型:</td>
				<td class="tdRight"><select name="type"><option value="java">java</option>
						<option value="web">web</option>
						<option value="美工">美工</option></select><!-- <input type="text" name="type"> --></td>
			</tr>
			<tr>
				<td class="tdLeft">简介:</td>
				<td class="tdRight"><input type="text" name="describe"></td>
			</tr>
			<tr>
				<td class="tdLeft">课程编号:</td>
				<td class="tdRight"><input type="text" name="no"></td>
			</tr>
		</table><br>
		<input type="submit" value="添加" />
	</form></center>
	<br>
</body>
</html>