<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <%@include file="/WEB-INF/pages/common/header.jsp"%>
 <link rel="stylesheet" type="text/css"
	href="${basePath}static/myframe/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="${basePath}static/myframe/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css"
	href="${basePath}static/myframe/Css/style.css" />
	<!-- <script>
	function check(){
		var v=document.getElementById("name").value;
		if(v==""){
			document.getElementById("err").innerHTML="菜單名稱不能為空 ！ ";
			
			return false;
		}
		return true;
	  }
	</script>  -->
 <script type="text/javascript" src="../Js/jquery.js"></script>
  <script type="text/javascript" src="${basePath}static/myframe/assets/js/jquery-1.8.1.min.js"></script>  
 
    <script type="text/javascript" src="../Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="../Js/bootstrap.js"></script>
    <script type="text/javascript" src="../Js/ckform.js"></script>
    <script type="text/javascript" src="../Js/common.js"></script>

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style> 

</head>
<body>

<form action="saveEdit.html" method="post" class="definewidth m20">
<input type="hidden" name="childId" value="${diction.childId }"/>
<table class="table table-bordered table-hover m10">

    <tr >
        <td width="15%"  class="tableleft">父项名称</td>
        <td>
        
            <input type="text" name="fatherName" value="${father.dictionName }"/>
        </td>
    </tr>
    <tr>
        <td class="tableleft">字典项名称</td>
        <td><input type="text" name="dictionName" value="${diction.dictionName }"/></td>
    </tr>
    <tr>
        <td class="tableleft">描述</td>
        <td><input type="text" name="remark" value="${diction.describle }"/></td>
    </tr>
    
    <tr>
        <td class="tableleft"></td>
        <td>
            <input type="submit" class="btn btn-primary" value="保存" />
        </td>
    </tr>
</table>
${s }
</form>
 <%--<span id="savesuccess" style=" display:none;">${s }</span>
<script>
$(document).ready(function() {
	if ($("#savesuccess").text() != "")
		alert($("#savesuccess").text());
 
 })


</script>   --%>



</body>
</html>

