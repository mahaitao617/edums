<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
    <%@include file="/WEB-INF/pages/common/header.jsp"%>
    <link rel="stylesheet" type="text/css" href="${basePath}static/myframe/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${basePath}static/myframe/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="${basePath}static/myframe/Css/style.css" />
    <script type="text/javascript" src="${basePath}static/myframe/Js/jquery.js"></script>
   
    <script type="text/javascript" src="${basePath}static/myframe/Js/bootstrap.js"></script>
    <script type="text/javascript" src="${basePath}static/myframe/Js/ckform.js"></script>
    <script type="text/javascript" src="${basePath}static/myframe/Js/common.js"></script>

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

<form class="form-inline definewidth m20" action="#" method="post">    
    档案编号：
    <input type="text" name="archivesno" id="archivesno" class="abc input-medium" placeholder="" value="">&nbsp;&nbsp;  
    姓名：
    <input type="text" name="stuname" id="stuname" class="abc input-small" placeholder="" value="">&nbsp;&nbsp;  
    性别：
    <select class="abc input-mini" name="sex" id="sex">
    	<option value ="无">无</option>
    	<c:forEach var="MenuList" items="${MenuList.getSex()}" varStatus="name">
    	<option value ="${MenuList.getDictionName()} ">${MenuList.getDictionName()}</option>
    	</c:forEach>
    </select>&nbsp;&nbsp;
    班级类型：
    <select class="abc input-mini" name="classtype" id="classtype">
    	<option value ="无">无</option>
    	<c:forEach var="MenuList" items="${MenuList.getClasstype()}" varStatus="name">
    	<option value ="${MenuList.getDictionName()} ">${MenuList.getDictionName()}</option>
    	</c:forEach>
    </select>&nbsp;&nbsp;
    班级：
    <select class="abc input-small" name="classes" id="classes">
    	<option value ="无">无</option>
    	<c:forEach var="MenuList" items="${MenuList.getClasses()}" varStatus="name">
    	<option value ="${MenuList} ">${MenuList}</option>
    	</c:forEach>
    </select>&nbsp;&nbsp;
    学校：
    <select class="abc input-small" name="university" id="university">
    	<option value ="无">无</option>
    	<c:forEach var="MenuList" items="${MenuList.getUniversity()}" varStatus="name">
    	<option value ="${MenuList.getDictionName()} ">${MenuList.getDictionName()}</option>
    	</c:forEach>
    </select>&nbsp;&nbsp;
    学院：
    <select class="abc input-small" name="college" id="college">
    	<option value ="无">无</option>
    	<c:forEach var="MenuList" items="${MenuList.getCollege()}" varStatus="name">
    	<option value ="${MenuList.getDictionName()} ">${MenuList.getDictionName()}</option>
    	</c:forEach>
    </select>&nbsp;&nbsp;
    专业：
    <select class="abc input-small" name="major" id="major">
    	<option value ="无">无</option>
    	<c:forEach var="MenuList" items="${MenuList.getMajor()}" varStatus="name">
    	<option value ="${MenuList.getDictionName()} ">${MenuList.getDictionName()}</option>
    	</c:forEach>
    </select>&nbsp;&nbsp;
    学生状态：
    <select class="abc input-mini" name="stustate" id="stustate">
    	<option value ="无">无</option>
    	<c:forEach var="MenuList" items="${MenuList.getStustate()}" varStatus="name">
    	<option value ="${MenuList.getDictionName()} ">${MenuList.getDictionName()}</option>
    	</c:forEach>
    </select>&nbsp;&nbsp;
     档案状态：
    <select class="abc input-mini" name="archiversstate" id="archiversstate">
    	<option value ="无">无</option>
    	<c:forEach var="MenuList" items="${MenuList.getArchivesstate()}" varStatus="name">
    	<option value ="${MenuList.getDictionName()} ">${MenuList.getDictionName()}</option>
    	</c:forEach>
    </select>&nbsp;&nbsp;
    <div class="pull-right">
    <button type="submit" class="btn btn-primary ">筛选</button>&nbsp;&nbsp; 
    <button type="button" class="btn btn-success " id="addnew">新建档案</button>
    </div>
</form>
<form class="" action="#" method="post">
<table class="table table-bordered table-hover definewidth m10">
    <thead>
        <tr>
        	<th>勾选</th>
            <th>档案编号</th>
            <th>学号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>班级</th>
            <th>学校</th>
            <th>入档时间</th>
            <th>档案状态</th>
            <th>具体操作</th>
        </tr>
    </thead>
    <tbody>
        <tr>
        	<td>
        	<input type="checkbox" id="inlineCheckbox2" value="档案id">
        	</td>
            <td>1</td>
            <td>123</td>
            <td>lzx</td>
            <td>男</td>
            <td>19</td>
            <td>吉大</td>
            <td>2014/1</td>
            <td>在档</td>
            <td><a href="#">查看</a>|<a href="#">编辑</a>|<a href="#">删除</a></td>
        </tr>
     </tbody>
</table>
<br>
<div class="pull-right" style="margin-right:30px">
	<button type="submit" class="btn btn-primary">打印详细信息</button>
	<button type="submit" class="btn btn-success">打印信息表</button>
</div>
<div class="page_and_btn">
	${page.pageStr }
</div>
</form>
<script>
    $(function () {
        $('#addnew').click(function(){
                alert("dd");
             //   window.location.href="user/add.html";
         });
    });

    function del(id)
    {
        if(confirm("确定要删除吗？"))
        {
            var url = "index.html";
            window.location.href=url;       
        }
    }
</script>
</body>
</html>