<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>查询学生信息</title>
</head>
<body>



	<div class="container">

		<div class="table-responsive">
			<h1>查询学生信息</h1>
			<label>条件查询：</label>

			<%-- <form class="form-search" method="post" action="queryStuInfoByStuNo.html">


				<div class='span3'>

				<input type="text" class="input-block-level search-query" name="stuNo"
					placeholder="学号/姓名/班级">

					

				</div>
				<button type="submit" class="btn btn-primary" >Search</button>
				<c:if test="${result  =='0'}" var="warn" scope="request">不存在</c:if>

				
			</form> --%>
			<form class="form-search" method='get'
				action='queryStuInfoByCondition.html'>

				<div class='span3'>

					<input name='condition' type="text"
						class="input-block-level search-query" placeholder="学号/姓名/班级">

				</div>
				<button type="submit" class="btn btn-primary" >Search</button>
				

				<c:if test="${result =='0'}">输入内容不存在</c:if>
			</form>
<c:if test="${showTable eq true}">



			<table class="table table-striped table-bordered table-hover">
				
					<thead>
						<tr>
							<th>学号</th>
							<th>姓名</th>
							<th>班级</th>
							<th>联系电话</th>
							<th>操作</th>
						</tr>
					</thead>
				

		
				<tbody>
				<c:if test="${stuinfo != null}"> 
					<tr>
						<td>${stuinfo.stuNo }</td>
						<td>${stuinfo.archives.stuName }</td>
						<td><a href='#'>${stuinfo.classes}</a></td>
						<td>${stuinfo.mobilePhone }</td>
						<td><a href='showDetailStuInfoByStuNo.html?stuNo=${stuinfo.stuNo}'>详细信息</a>
								<a href='#'>修改</a></td>
					</tr>

</c:if>
					<c:forEach var="stuinfo" items="${stuinfoList}">
						<tr>
							<td>${stuinfo.stuNo}</td>
							<td>${stuinfo.archives.stuName}</td>
							<td><a href='#'>${stuinfo.classes}</a></td>
							<td>${stuinfo.mobilePhone}</td>
							<td><a
								href='showDetailStuInfoByStuNo.html?stuNo=${stuinfo.stuNo}'>详细信息</a>
								<a href='#'>修改</a></td>
						</tr>
					</c:forEach>

				</tbody>

			</table>

				</c:if>	
		</div>
	</div>
	
</body>
</html>