<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>后台管理系统</title>
     <%@include file="/WEB-INF/pages/common/header.jsp"%>
    <link href="${basePath}static/myframe/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="${basePath}static/myframe/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="${basePath}static/myframe/assets/css/main-min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="header">
    <div class="dl-title">
      <%--   <img src="/chinapost/Public/${basePath}static/myframe/assets/img/top.png"> --%>
    </div>

    <div class="dl-log">欢迎您，<span class="dl-log-user">root</span><a href="logout.html" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>
<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform"><div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div></div>
        <ul id="J_Nav"  class="nav-list ks-clear">
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-home">系统管理</div></li>		
           <!--  <li class="nav-item dl-selected"><div class="nav-item-inner nav-order">业务管理</div></li> -->
		</ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
</div>
 <script type="text/javascript" src="${basePath}static/myframe/assets/js/jquery-1.8.1.min.js"></script>  
<script type="text/javascript" src="${basePath}static/myframe/assets/js/bui-min.js"></script>
<script type="text/javascript" src="${basePath}static/myframe/assets/js/common/main-min.js"></script>
<script type="text/javascript" src="${basePath}static/myframe/assets/js/config-min.js"></script>
<script>
     BUI.use('common/main',function(){
    	 var menu = '${menuStr}';
    	 var data = $.parseJSON(menu);
    	/*  alert(data.length);
    	 alert(data[0].subMenu.length); */
    	 /*  var k =  [{id:'1', menu:
         	[
         	{text:'系统管理',collapsed:true,items:
 					        	 [{id:'12',text:'机构管理',href:'user.html'},
 					             {id:'3',text:'角色管理',href:'Role/index.html'},
 					             {id:'4',text:'用户管理',href:'User/index.html'},
 					             {id:'6',text:'菜单管理',href:'Menu/index.html'}]
         
         	 },
         	 ]
        
         },
     
          {id:'7',homePage : '9',menu:[{text:'业务管理',items:[{id:'9',text:'查询业务',href:'Node/index.html'}]}]} 
         
         ];  */
      /*    var menus = '[{"id":"1","menu":[';
    	for (var int = 0; int < 2; int++) {
    		
			var menus =menus+	'{"text":"系统管理","collapsed":"true","items":[{"id":"12","text":"机构管理","href":"user.html"},{"id":"3","text":"角色管理","href":"Role/index.html"},{"id":"4","text":"用户管理","href":"User/index.html"}] },'
		}
    	 menus = menus+'{}]}]';
         alert(menus);
         console.log(menus);
         str = JSON.parse(menus);
         console.log(str); */
         var menus = '[{"id":"1","menu":[';
       for (var i = 0; i <data.length; i++) {
    	   if(i!=data.length-1){
    		   menus = menus+'{"text":'+'"'+data[i].menuName+'",'+'"collapsed":"true","items":[';
	   			for (var j = 0; j < data[i].subMenu.length; j++) {
	   				/* alert(data[i].menuName+ data[i].subMenu[j].menuName); */
	   				if(j!=data[i].subMenu.length-1){
	   					menus=menus+'{"id":'+'"'+data[i].subMenu[j].menuId+'",'+'"text":'+'"'+data[i].subMenu[j].menuName+'",'+'"href":'+'"'+data[i].subMenu[j].url+'"},';
	   				}else{
	   					menus=menus+'{"id":'+'"'+data[i].subMenu[j].menuId+'",'+'"text":'+'"'+data[i].subMenu[j].menuName+'",'+'"href":'+'"'+data[i].subMenu[j].url+'"}';
	   				}
	   			}
	   			menus = menus+']},';
    	   }else{
    		   menus = menus+'{"text":'+'"'+data[i].menuName+'",'+'"collapsed":"true","items":[';
	   			for (var j = 0; j < data[i].subMenu.length; j++) {
	   				/* alert(data[i].menuName+ data[i].subMenu[j].menuName); */
	   				if(j!=data[i].subMenu.length-1){
	   					menus=menus+'{"id":'+'"'+data[i].subMenu[j].menuId+'",'+'"text":'+'"'+data[i].subMenu[j].menuName+'",'+'"href":'+'"'+data[i].subMenu[j].url+'"},';
	   				}else{
	   					menus=menus+'{"id":'+'"'+data[i].subMenu[j].menuId+'",'+'"text":'+'"'+data[i].subMenu[j].menuName+'",'+'"href":'+'"'+data[i].subMenu[j].url+'"}';
	   				}
	   			}
	   			menus = menus+']}';
    	   }
    	  
		}
       menus = menus+']}]';
       console.log(menus);
       str = JSON.parse(menus);
       console.log(str);
 		var config =str;
        new PageUtil.MainPage({
            modulesConfig : config
            
        });
    }); 
</script>
</body>
</html>