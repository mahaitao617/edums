<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@include file="/WEB-INF/pages/common/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function getARState(){
		var ARState=document.getElementsByName("ARState")[0].value;
		var leaveReason=document.getElementById("leaveReason");
		if("请假"==ARState){
			leaveReason.readOnly=false;
		}
		if("请假"!=ARState){
			document.getElementById("leaveReason").value="";
			leaveReason.readOnly=true;
		}
	}

</script>
</head>
<body>
<div>
	<form action="update.html" method="post" class="definewidth m20">
		<%-- 学生id：<input name="stuName" type="text" class="input-block-level search-query" value="${attendanceRecordsLs.stu_id }" readonly="readonly"><br>
		
		<select name="ARState" onchange="getARState();">
			<option selected="selected">出勤状态</option>
			<c:forEach var="newls" items="${ARStateLs }">
				<option>${newls.dictionName }</option>
			</c:forEach>
		</select>
		<div id="leaveReason" style="display: none;"><h6>请在这里填写请假原因：</h6><br><textarea name="leaveReason" ></textarea></div>
		<input type="submit" value="提交">
		<input type="hidden" name="ARId" value="${attendanceRecordsLs.ARId }"> --%>
	
	
	<table class="table table-bordered table-hover m10">
		<tbody>
			<tr>
				<td class="tableleft" width="10%">学生id</td>
				<td>
					<input name="stuName" type="text" value="${attendanceRecordsLs.stu_id }" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td class="tableleft">出勤状态</td>
				<td>
					<select name="ARState" onchange="getARState();">
							<option selected="selected">--请选择出勤状态--</option>
							<c:forEach var="newls" items="${ARStateLs }">
								<option>${newls.dictionName }</option>
							</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td class="tableleft" >请假原因</td>
				<td>
					<input type="text" id="leaveReason" name="leaveReason" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="提交"></td>
				<td><input type="hidden" name="ARId" value="${attendanceRecordsLs.ARId }"></td>
			</tr>
		</tbody>
	</table>
	</form>
</div>
</body>
</html>