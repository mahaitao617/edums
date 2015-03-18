<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单管理</title>
<%@include file="/WEB-INF/pages/common/header.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${basePath}static/myframe/Css/style.css" />

<link type="text/css" rel="stylesheet" href="css/main.css" />
<script type="text/javascript">
	$(function() {
		$('span').click(function() { // 获取所谓的父行
			$('tr.child_' + this.id).toggle(); // 隐藏/显示所谓的子行
			var cur = $(this)[0];
			if (cur.className == "icon-minus") {
				$(this)[0].className = "icon-plus";
			} else {
				$(this)[0].className = "icon-minus";
			}
		}).click();
	})
</script>
<style type="text/css">
.bgRed {
	background-color: #FF0000;
}

.tdstytle {
	margin-left: 50px;
	padding-left: 30px;
}

#menuswidth {
	padding-top: 30px;
}
</style>
<body onload="chCell();">
	<div id="menuswidth">
		<table class="definewidth">
			<tr>

				<td><a class="add" href="${basePath}menu/toAdd.html"><input type="button"
						class="btn" value="添加"></a> <a class="del" href=""><input
						type="button" class="btn" value="删除"></a> <a class="edit"
					href="menu/edit.html"><input type="button" class="btn" value="编辑"></a><a
					class="quary" href="#"><input type="button" class="btn"
						value="查询"></a></td>
			</tr>
		</table>
		<table class="table table-bordered definewidth m10" id="tbl">
			<thead>
				<tr>

					<th width="20%">菜单名称</th>
					<th width="20%">菜单地址</th>
					<th width="15%">上级菜单</th>
					<th width="10%">菜单编号</th>
					<th width="25%">创建时间</th>
					<th width="10%">操作</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${menuList}" var="menu">

					<tr>
						<td><a href="#"><span id="${menu.menuId }"
								class="icon-minus"></span></a>${menu.menuName}</td>
						<td colspan="2">----</td>

						<td class="getmenuid">${menu.menuId}</td>
						<td>${menu.buildTime}</td>
						<td><a href="menu/deleteMenu.html?menuId=${menu.menuId}">删除|</a><a
							href="menu/edit.html?menuId=${menu.menuId}">编辑</a></td>
					</tr>
					<c:forEach items="${menu.subMenu}" var="sonmenu">
						<tr class="child_${menu.menuId }">
							<td class="tdstytle" style="text-align: center;">${sonmenu.menuName}</td>
							<td>${sonmenu.url}</td>
							<td>${menu.menuName}</td>
							<td class="getmenuid">${sonmenu.menuId}</td>
							<td>${sonmenu.buildTime}</td>
							<td><a href="menu/deleteMenu.html?menuId=${sonmenu.menuId}">删除|</a><a
								href="menu/edit.html?menuId=${sonmenu.menuId}">编辑</a></td>
						</tr>
					</c:forEach>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script type="text/javascript">
		function chCell() {
			//获取DOM
			var tbl = document.getElementById('tbl');
			var rows = tbl.rows; //得到当前的表格的row数组
			var len = tbl.rows.length; //当前的行数
			for (var i = 0; i < len; i++) { //遍历所有行
				var r = rows[i]; //当前行
				r.onclick = function() { //定义鼠标click事件
					//如果已经是粉红色，则变回白色
					for (var j = 0; j < len; j++) { //遍历所有行
						var r2 = rows[j]; //当前行
						r2.style.backgroundColor = 'white';
					}
					if (this.style.backgroundColor == 'pink') {
						this.style.backgroundColor = 'white';
					} else {
						//否则就让背景色变成粉红色
						this.style.backgroundColor = 'pink';
						$("a.del").attr(
								"href",
								"${basePath}menu/deleteMenu.html?menuId="
										+ $(this).children('td.getmenuid')
												.text());
						$("a.edit").attr(
								"href",
								"${basePath}menu/edit.html?menuId="
										+ $(this).children('td.getmenuid')
												.text());
						$("a.quary").attr(
								"href",
								"${basePath}menu/quary.html?menuId="
										+ $(this).children('td.getmenuid')
												.text());
						/* alert($("a.add").attr("href")); */
					}
				};
			}
		}
	</script>

</body>
</html>