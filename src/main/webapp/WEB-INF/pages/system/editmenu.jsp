<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <%@include file="/WEB-INF/pages/common/header.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${basePath}static/myframe/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="${basePath}static/myframe/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css"
	href="${basePath}static/myframe/Css/style.css" />
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
<c:if test="${menu.fatherId == null}">
<form action="${basePath}menu/edit.html" method="post" class="definewidth m20">
	<input type="hidden" name="menuId" value="${menu.menuId}" />
	<input type="hidden" name="menuUrl" value="${menu.url}" />
	<input type="hidden" name="fatherId" value="${menu.fatherId}" />
	<table class="table table-bordered table-hover m10">
	    <tr>
	        <td class="tableleft">菜单名称</td>
	        <td><input type="text" name="menuName" id="name" value="${menu.menuName}"/></td>        
	    </tr>
	   
	     <tr>
	        <td class="tableleft">菜单说明</td>
	        <td><input type="text" name="remark"  value="${menu.remark}"/></td>
	        
	    </tr>
	    
	    <tr>
	        <td class="tableleft"></td>
	        <td>
	            <button type="submit" class="btn btn-primary" type="button" id="save">保存</button> &nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
	        </td>
	    </tr>
	     
	</table>
	</form>
</c:if>
<c:if test="${menu.fatherId > '0'}">
	<form action="${basePath}menu/edit.html" method="post" class="definewidth m20">
		<input type="hidden" name="menuId" value="${menu.menuId}" />
		<table class="table table-bordered table-hover m10">
		
		   <tr>
		        <td class="tableleft">上级菜单</td>
		        <td>
		            <select name="fatherId">
		            <option value="${menu.parentMenu.menuId}">${menu.parentMenu.menuName}
		             <c:forEach var="pm" items="${menuList }">		       
                     <option value="${pm.menuId }">${pm.menuName }</option> 
                      </c:forEach>
		            </select>
		        </td>
		    </tr>  
		    
		    <tr>
		        <td class="tableleft">菜单名称</td>
		          <td><input type="text" name="menuName" id="name" value="${menu.menuName}"/><span id="err" style="color:red;"></span></td>         
		    </tr>
		   
		    <tr>
		        <td class="tableleft">菜单链接</td>
		        <td><input type="text" name="menuUrl"  value="${menu.url}"/></td>
		    </tr>  
		    
		     <tr>
		        <td class="tableleft">菜单说明</td>
		        <td><input type="text" name="remark" value="${menu.remark}"/></td>
		        
		    </tr>  
		     
		    <tr>
		        <td class="tableleft"></td>
		        <td>
		            <button type="submit" class="btn btn-primary" type="button" id="save">保存</button> &nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
		        </td>
		    </tr>
		     
		</table>
		</form>
</c:if>
<script>

    $(function () {
        

		$('#save').click(function(){
				alert("修改成功");
				window.location.href="menu/edit.html";
		 });


    });
</script>
</body>
</html>