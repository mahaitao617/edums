<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html">
<head>
<title></title>
<link href="${basePath}static/myframe/assets/css/dpl-min.css"
	rel="stylesheet" type="text/css" />
<link href="${basePath}static/myframe/assets/css/bui-min.css"
	rel="stylesheet" type="text/css" />
<link href="${basePath}static/myframe/assets/css/main-min.css"
	rel="stylesheet" type="text/css" />
<link href="${basePath}static/css/teachermnt/teacher.css"
	rel="stylesheet" type="text/css"/>
</head>
<body>
	<form action="addTeacher2.html" method="post" class="definewidth m20">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td width="10%" class="tableleft">教师姓名</td>
				<td><input type="text" name="teaName" required="required"
					oninput="validateOut1(this)" maxlength="20"
					pattern="([\u4E00-\u9FA5]{2,5}(?:·[\u4E00-\u9FA5]{2,5})*)|([a-zA-z'. ]*)" /></td>
			</tr>
			<tr>
				<td width="10%" class="tableleft">性别</td>
				<td><c:forEach var="sex" items="${sex }">
						<label class="radio.inline"><input type="radio" name="sex"
							value="M" required="required" />${sex.dictionName } </label>

					</c:forEach></td>
			</tr>
			<tr>
				<td width="10%" class="tableleft">授课内容</td>
				<!-- 外键 已完成！！ -->
				<td><select name="courseId">
						<c:forEach var="course" items="${course }">
							<option value="${course.courseId }">${course.courseName }</option>
						</c:forEach>
						<option value="0">JAVA</option>
						<option value='1'>&nbsp;ORACLE</option>
						<option value='7'>&nbsp;C++</option>
				</select></td>
			</tr>

			<tr>
				<td class="tableleft">教师等级</td>
				<td><select name="teaLevel">
						<c:forEach var="teaLevel" items="${teaLevel }">
							<option value="${teaLevel.dictionName }">${teaLevel.dictionName }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="tableleft">教师状态</td>
				<td><select name="teaState">
						<c:forEach var="teaState" items="${teaState }">
							<option value="${teaState.dictionName }">${teaState.dictionName }</option>
						</c:forEach>
						<option>其他</option>
				</select></td>
			</tr>

			<tr>
				<td class="tableleft">手机号码</td>
				<td><input type="text" name="telephone" required="required"
					oninput="validateOut2(this)" maxlength="11"
					pattern="(^((\(\d{3}\))|(\d{3}\-))?(1[358]\d{9})$)" /></td>
			</tr>
			<tr>
				<td class="tableleft">特长</td>
				<td><textarea name="specialty" rows="5" required="required"
						maxlength="100" placeholder="简要说明您的特长，在100个字以内"></textarea></td>
			</tr>
			<tr>
				<td class="tableleft"></td>
				<td>
					<button type="submit" class="btn btn-primary">保存</button>
					&nbsp;&nbsp;
					<button type="reset" class="btn btn-success">重置</button>
					<!-- 回退怎么解决？ -->
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		function validateOut1(i) {
			var v = i.validity;
			if (true === v.valueMissing) {
				i.setCustomValidity("名字不能为空");
			} else {
				if (true === v.patternMismatch) {
					i.setCustomValidity("请填写您的中文或英文名");
				} else {
					i.setCustomValidity("");
				}
			}
		}
		function validateOut2(i) {
			var v = i.validity;
			if (true === v.valueMissing) {
				i.setCustomValidity("电话号码不能为空");
			} else {
				if (true === v.patternMismatch) {
					i.setCustomValidity("请填写11位电话号码");
				} else {
					i.setCustomValidity("");
				}
			}
		}
	</script>
</body>
</html>
