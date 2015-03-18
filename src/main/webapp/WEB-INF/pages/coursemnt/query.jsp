<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/pages/common/header.jsp"%>
<!-- 查询课程页面的样式 -->
<link type="text/css" rel="stylesheet" href="${basePath}static/css/coursemnt/queryCourse.css"/>
<!-- 查询课程页面的js -->
   <script type="text/javascript" src="${basePath}static/js/coursemnt/queryCourse.js" ></script>
</head>
<body>
<br>
<form action="${basePath}course/queryByKeys.html"  method="get">
<center><input type="text" name="key"><input type="submit" value="模糊查询"></center><br>
</form>
<form action="" style="width: 100%">
<table class="toptable_style">
			<tr>
				<td width="85%">
					<span class="title_style">课程信息列表</span></td>
				<td><span class="title_style"> <input type="checkbox"
						name="selectall" id="selectall" onclick="selectAll()"/> 全选/全不选
				</span> &nbsp;
				<span><a href="" class="checkItem" id="aset">删除</a></span>
				<span class="title_style"><a href="#" class="aset"  onclick="popwinEn()"> 打印</a> </span> </td>
			</tr>
		</table>
		<br>
		<table class="centtable_style" cellspacing="1px">
			<tr class="toptr">
				<td>选定</td>
				<td>课程名称</td>
				<td>课时</td>
				<td>课程类型</td> 
				<td>课程状态</td>
				<td>课程描述</td>
				<td>基本操作</td>
			</tr>
		<c:forEach var="var" items="${courseList}">
			<tr class="centtr">
				<td><input type="checkbox" name="checkbox" class="checkbox" id="checkbox" /></td>
				<td>${var.courseName}</td>
				<td>${var.courseHour}小时</td>
				<td>${var.courseType}</td>
				<td>${var.courseState}</td>
				<td>${var.describe}</td>
				<td><a href="${basePath}course/delete.html?method=get&&courseId=${var.courseId }">删除</a></td>
			</tr>
			</c:forEach>
		</table>
		</form>
</body>
<script>
$(document).ready(
		function() {
			//标题栏上的删除控制 
			$("a.checkItem").click(function() {
				var flag = true;
				if ($("input[name=checkbox]:checked").length == 0) {
					alert("对不起 请选中需要删除的项)");
					flag = false;
				}
				if (flag) {
					//form表单提交
					$("form").attr("action", "course/delete.html?method=get");
					$("form").submit();
				}
				return false;
			});
		});

</script>
</html>