<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/WEB-INF/pages/common/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

	<script type="text/javascript" src="${basePath}static/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${basePath}static/js/jquery/ajaxfileupload.js"></script>
	<script type="text/javascript" src="${basePath}static/js/jquery/my.js" ></script>
	<link rel="stylesheet" type="text/css" href="${basePath}static/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${basePath}static/easyui/themes/icon.css" />
</head>

<body>
<div id="tip" class="text-center"><h4> Tip</h4> </div> <div id="text" class="text-center"><strong>点击浏览上传图片，按住ctrl可以多个图片一起上传哦~ 但是最多不要超过10张图片，服务器会傲娇的</strong></div> 
  
  <div class="text-center"><input id="advImage" name="advImage" type="file" multiple=""  onchange="uploadImage()" value="上传图片"/></div>
   	<!-- <img id="photo" src="" style="width:300px;height:200px"/> -->
   	<div id="result" class="text-center text-error" ></div>
   	<div id=img class="text-center">  </div>
    

</body>
</html>