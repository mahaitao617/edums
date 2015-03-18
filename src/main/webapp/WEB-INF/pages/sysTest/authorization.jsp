<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Test</title>
</head>
<body>
	<div>
		<ul id="tree" class="tree" style="overflow:auto;"></ul>
	</div>
	<script type="text/javascript">
		var dg;
		$(document).ready(function(){
			dg = frameElement.lhgDG;
			dg.addBtn('ok','保存',function(){
				var nodes = zTree.getCheckedNodes();
				var tmpNode;
				var ids = "";
				for(var i=0; i<nodes.length; i++){
					tmpNode = nodes[i];
					if(i!=nodes.length-1){
						ids += tmpNode.id+",";
					}else{
						ids += tmpNode.id;
					}
				}
				var userId = "${userId}";
				var roleId = "${roleId}";
				var url = "auth/save.html";
				var postData;
				if(userId!=""){
					postData = {"userId":userId,"menuIds":ids};
				}else{
					postData = {"roleId":roleId,"menuIds":ids};
				}
				$.post(url,postData,function(data){
					if(data && data=="success"){
						dg.cancel();
					}
				});
			});
			var setting = {
			    showLine: true,
			    checkable: true
			};
			var zn = '${zTreeNodes}';
			var zTreeNodes = eval(zn);
			var zTree = $("#tree").zTree(setting, zTreeNodes);
		});
	</script>
</body>
</html>