<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<h1>学生详细信息</h1>
<body>
	<label>学生详细信息</label>
	<div class="container span2">
		<table class="table table-striped table-bordered table-hover">
			<tr>
				<td>学号</td>
				<td>${stuinfo.stuNo}</td>
			</tr>
			<tr>
				<td>档案号</td>
				<td>${stuinfo.archives_id}</td>
			</tr>
			<tr>
				<td>班级</td>
				<td>${stuinfo.classes}</td>
			</tr>
			<tr>
				<td>qq号</td>
				<td>${stuinfo.qqNumber}</td>
			</tr>
			<tr>
				<td>电话号</td>
				<td>${stuinfo.mobilePhone}</td>
			</tr>
			<tr>
				<td>固定电话</td>
				<td>${stuinfo.telephone}</td>
			</tr>
			<tr>
				<td>紧急联系人</td>
				<td>${stuinfo.emergencyContact}</td>
			</tr>
			<tr>
				<td>紧急联系人联系方式</td>
				<td>${stuinfo.emergencyContactPhone}</td>
			</tr>
			<tr>
				<td>email</td>
				<td>${stuinfo.email}</td>
			</tr>
			<tr>
				<td>学生状态</td>
				<td>${stuinfo.stuState}</td>
			</tr>
		</table>

	</div>
	

</body>
</html>