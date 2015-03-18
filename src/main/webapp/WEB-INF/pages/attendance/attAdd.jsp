<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@include file="/WEB-INF/pages/common/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function tijiao(){
		var addAtt=document.getElementsByName("addAtt");
		var temp="";
		for(var i=0;i<addAtt.length;i++){
			if(addAtt[i].checked){
				temp=temp+","+addAtt[i].value;
			}
		}
		document.getElementById("tempString").value=temp;
		alert(temp);
		alert(temp.length);
		document.getElementById("formid").submit();
	}
	function fanhui(){
		window.location.href="../attendance.html";
	}
	
</script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<select>
		<option>19班</option>
		<option>22班</option>
	</select>
	<select>
		<option>java课</option>
	</select>
	<form action="save.html" method="post" id="formid">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td></td><td>学生编号</td>
			</tr>
			<c:forEach var="stu" items="${stuList }">
				<tr>
					<td><input type="checkbox" name="addAtt" value="${stu.stuInfoId }"/></td>
					<td>${stu.stuNo }</td>
				</tr>
			</c:forEach>
			<tr>
				<td><input type="hidden" id="tempString" name="tempString"/></td>
				<td><input type="button" value="提交" onclick="tijiao();" class="btn btn-primary"/>
					<input type="button" value="返回" onclick="fanhui();" class="btn btn-success"/>
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>