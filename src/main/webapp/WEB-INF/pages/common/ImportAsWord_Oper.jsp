<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ taglib prefix ="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ImportAsWord</title>
<!-- 这里先把值写死了，需要调用导出的只需要把list对象传过来即可 -->
</head>
<body>
           <%
              List<Integer> list = new ArrayList<Integer>();
              list.add(1);
              list.add(2);
              list.add(3);
              list.add(4);
              list.add(5);
              list.add(6);
              request.setAttribute( "list", list);
           %>
           <c:forEach var ="var" items="${list}">
               <c:out value ="${var}" />
               <br >
           </c:forEach>
<a href="ImportAsWord_Show.jsp">Print Word Doc</a>
</body>
</html>