<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/WEB-INF/pages/common/header.jsp"%>
<link rel="stylesheet" type="text/css" href="${basePath}static/myframe/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${basePath}static/myframe/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="${basePath}static/myframe/Css/style.css" />

<script type="text/javascript">

function attAdd() {
	window.location.href="attendance/showClass.html";
}

</script>

<title>查询学生信息</title>
</head>
<body>
<br>

	<div class="container">

		<div class="table-responsive">
			<form class="form-search" action="attendance/listRequiredAttendance.html"
				method="post">
				<div class='span3'>
					<input type="text" name="requiredInfo" class="input-block-level search-query" placeholder="  学号/姓名/班级">
				</div>
				&nbsp;
				<button type="submit" class="btn btn-primary">Search</button>
				<button type="button" class="btn btn-success" onclick="attAdd();">新增出勤</button>

			</form>

			<c:if test="${ empty requestScope.attendanceRecords }">
				<div class="nullList">没有任何出勤记录</div>
			</c:if>

			<c:if test="${! empty requestScope.attendanceRecords }">

				<table class="table table-bordered table-hover definewidth m10">

					<thead>
						<tr>
							<th>学生编号</th>
							<th>排课id</th>
							<th>教室编号</th>
							<th>出勤状态</th>
							<th>请假原因</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="as" items="${requestScope.attendanceRecords }">
							<tr>
								<td>${as.stuinfo.stuNo }</td>
								<td>${as.timetable.timeTableId }</td>
								<td>${as.timetable.classroom }</td>
								<td>${as.ARState }</td>
								<td>${as.leaveReason }</td>
								<td>
								    <a href="attendance/findSingle.html?ARId=${as.ARId }">修改</a>
								    <a href="#">删除</a>
								</td>
							</tr>
						</c:forEach>

					</tbody>

				</table>

			</c:if>
			<div class="page_and_btn">${page.pageStr }</div>


			
		</div>
	</div>
</body>
</html>