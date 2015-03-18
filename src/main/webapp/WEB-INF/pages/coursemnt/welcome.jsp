<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<br>
<form action="course/queryAll.html" method="get">
<input type="submit" value="查询页面"/>
</form> 
<form action="course/addCourse.html" method="get">
<input type="submit" value="增加一门课程"/>
</form> 
批量删除课程方法有待修改<br>
修改某门课程信息,controller方法有待修改
<form action="course/update.html" method="get">
<input type="submit" value="updateCourse"/>
</form>
<br>
按条件查询课程，不定项条件<br>
<form action="course/queryByParams.html" method="get">
courseNo:<input type="text" name="courseNo"><br>
courseName:<input type="text" name="courseName"><br>
courseType:<input type="text" name="courseType"><br>
courseState:<input type="text" name="courseState"><br>
<input type="submit" value="queryByParams"/>
</form>
<br>
模糊查询
<form action="course/queryByKeys.html" method="get">
key:<input type="text" name="key"><br>
<input type="submit" value="queryByKeys"/>
</form>
<br>
查询课程的具体信息
<form action="course/queryOneInfo.html" method="get">
courseNo:<input type="text" name="courseNo">
<input type="submit" value="queryById"/>
</form>
</body>
</html>