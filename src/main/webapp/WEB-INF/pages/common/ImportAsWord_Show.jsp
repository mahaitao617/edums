<%@ page language="java" contentType="application/vnd.ms-word; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%  
    String fileName = "导出word.doc" ; 
    byte[] yte = fileName.getBytes( "utf-8" ); 
    String unicoStr = new String(yte, "utf-8" );
    response.setHeader( "Content-disposition", "attachment; filename=" + unicoStr); 
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name = "ProgId" content = "Word.Document" > 
<meta name = "Generator" content = "Microsoft Word 12"> 
<meta name = "Originator" content = "Microsoft Word 12">  
<title>Insert title here</title>
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
</body>
</html>
 




