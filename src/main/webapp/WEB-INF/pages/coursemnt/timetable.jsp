<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>

	<%@include file="/WEB-INF/pages/common/header.jsp"%>

    <link rel="stylesheet" type="text/css" href="${basePath}static/myframe/Css/style.css" />
	<script type="text/javascript" src="${basePath}static/myframe/Js/ckform.js"></script>
    <script type="text/javascript" src="${basePath}static/myframe/Js/common.js"></script>
    
     <script type="text/javascript" src="${basePath}static/js/coursemnt/timetable.js"></script>
      <link rel="stylesheet" type="text/css" href="${basePath}static/css/coursemnt/timetable.css" />
      
      
</head>
<body>

<span id="zhouyi" style="display: none">${dates[0] }</span>
<form class="form-inline definewidth m20" action="user.html" method="post">
 	<table class="table table-bordered mytable">
 		<thead>
 			<tr>
 				<th colspan="9">
 					学生课表
 					<div class="pull-right">
 						
 						<label class="input">
					   		校区：<select  id="campus1"  class="input-large" placeholder="bb">
		   						<c:forEach items="${campuses}" var="campus1">
		   							<c:if test="${campus1.dictionId == campus.dictionId }">
		   								<option selected="selected" value="${campus1.childId }">${campus1.dictionName }</option>
		   							</c:if>
		   							<c:if test="${campus1.dictionId != campus.dictionId }">
		   								<option value="${campus1.childId }">${campus1.dictionName }</option>
		   							</c:if>
		   						</c:forEach>
		   					</select>
		  			 	</label>
		  			 	<a id="lastWeek" class="btn btn-primary">上周</a>
 						<a id="thisWeek" class="btn btn-primary">本周</a>
 						<a id="nextWeek" class="btn btn-primary">下周</a>
 					</div>
 				</th>
 			</tr>
 		</thead>
		<tbody>
	       <!-- ******************************************************************** -->
		       <c:forEach items="${classTimes}" var="classTime" varStatus="classstate">
		       			<c:if test="${classstate.index == 0 }">
			       			<tr>
					    		<td rowspan="2" colspan="2" class="text"><span >${campus.dictionName }</span></td>   
					    		<c:forEach items="${dates }" var="date">
					    			<td>${date }</td>
					    		</c:forEach>
					       </tr>
					        <tr>  
					    		<td>星期一</td> 
					    		<td>星期二</td>  
					    		<td>星期三</td>  
					    		<td>星期四</td>  
					    		<td>星期五</td>  
					    		<td>星期六</td>  
					    		<td>星期日</td>  
			     			</tr>
		       			</c:if>
		       		
			    <%--    <tr>  
			       		<td rowspan="${fn:length(rooms)}" class="text"><span>${classTime.dictionName }</span></td>
			       		
			       		<td>${rooms[0].dictionName}</td>  
			    		<td class="classes">
			    			<c:if test=""></c:if>
			    		</td> 
			    		<td class="classes"></td> 
			    		<td class="classes"></td> 
			    		<td class="classes"></td> 
			    		<td class="classes"></td> 
			    		<td class="classes"></td> 
			    		<td class="classes"></td> 
			       </tr> --%>
			       <c:forEach items="${rooms }" var="room" begin="0" varStatus="roomstate" >
			       	 <tr>  
			       	 	<c:if test="${roomstate.index ==0 }"><td rowspan="${fn:length(rooms)}" class="text"><span>${classTime.dictionName }</span></td></c:if>
			        	<td>${room.dictionName }</td> 
			    		<c:forEach begin="0" end="6" varStatus="timetableboxstate">
			    			<td class="classes" style="width: 129px;">
			    			
			    			<%-- <span id="tdCampus" style="display: none">{"childId":"${campus.childId }","campusName":"${campus.dictionName}"}</span>
			    			<span id="tdClassTime" style="display: none">{"childId":"${classTime.childId }","classTimeName":"${classTime.dictionName}"}</span>
			    			<span id="tdClassroom" style="display: none">{"childId":"${room.childId }","roomName":"${room.dictionName}"}</span>
			    			<span id="tdDate" style="display: none">${dates[timetableboxstate.index] }</span> --%>
			    			<span id="tdCampus" style="display: none">${campus.dictionName}</span>
			    			<span id="tdClassTime" style="display: none">${classTime.dictionName}</span>
			    			<span id="tdClassroom" style="display: none">${room.dictionName}</span>
			    			<span id="tdDate" style="display: none">${dates[timetableboxstate.index] }</span>
			    			
			    				<c:forEach var="timetable" items="${timetables }">
			    					<%-- ${timetable.campus },${campus.childId }
			    					${timetable.classroom },${room.childId } --%>
			    				<fmt:formatDate pattern="yyyy-MM-dd" value="${timetable.date }" type="both" var="date"/><%-- ${date },${dates[timetableboxstate.index] } --%>
			    					<%-- ${timetable.time },${classTime.childId } --%>
			    					
			    					<c:if test="${(timetable.campus == campus.childId)&&(timetable.classroom == room.childId)&&(date == dates[timetableboxstate.index] )&&(timetable.time == classTime.childId)  }">
			    						<%-- <span id="tdDate" >{"Id":"${timetable.teacher.teaId }","name":"${timetable.teacher.teaName}"}</span>
			    						<span id="tdDate" >{"Id":"${timetable.classes.classId }","name":"${timetable.classes.classesNo}"}</span>
			    						<span id="tdDate" >{"Id":"${timetable.courseInfo.courseId }","name":"${timetable.courseInfo.courseName}"}</span> --%>
			    						<span id="tdTimetableId" style="display: none">${timetable.timeTableId }</span>
			    						<span id="tdTeaId" style="display: none">${timetable.teacher.teaId }</span>
			    						<span id="tdClassesId" style="display: none">${timetable.classes.classesId }</span>
			    						<span id="tdCourseId" style="display: none">${timetable.courseInfo.courseId }</span>
			    						<span id="tdteaName" >${timetable.teacher.teaName }</span>
			    						<span id="tdclassesNo" >${timetable.classes.classesNo }班  </span>
			    						
			    						
			    						<%-- ${timetable.courseInfo.courseName }  --%>
			    					</c:if>
			    		
			    					<%-- <c:if test="${timetable.campus == campus.childId  }">true</c:if>
			    					<c:if test="${timetable.classroom == room.childId  }">true</c:if>
			    					<c:if test="${date == dates[timetableboxstate.index]  }">true</c:if>
			    					<c:if test="${timetable.time == classTime.childId  }">true</c:if> --%>
			    				</c:forEach>
			    			</td> 
			    		</c:forEach>
			       	</tr>
			       </c:forEach>
			    
			     </c:forEach>
	    </tbody>
	</table>
</form>
<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <form action="timetable/save.html" class="form-inline">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	    <h3 id="myModalLabel">请输入课程信息</h3>
	  </div>
		  <div class="modal-body">
		  <!-- 
		  	校区 campus  
		  	教室 classroom
		  	日期 date
		  	时间 time
		  	教师 teacher
		  	班级 classes
		  	课程 course
		  	备注 remark
		   -->
		   <input type="hidden" id="modelTimetableId" name="timetableId" class="input-large" >
		  	<label class="input">
		   		校区：<input type="text" id="modelCampus" name="campus" class="input-large" placeholder="校区">
		   	</label>
		   	<label class="input">
		   		教室：<input type="text" id="modelClassroom" name="classroom" class="input-large" placeholder="教室">
		   	</label>
		   	<label class="input">
		   		日期：<input type="text" id="modelDate" name="date" class="input-large" placeholder="日期">
		   	</label>
		   	<label class="input">
		   		时间：<input type="text" id="modelClassTime" name="classTime" class="input-large" placeholder="时间">
		   	</label>
		   		<label class="input">
		   		教师：
		   		<select  id="modelTeacher" name="teacher" class="input-large" placeholder="aaa" >
		   		</select>
		   	</label>
		   	<label class="input">
		   		班级：
		   		<select  id="modelClasses" name="classes"  class="input-large" placeholder="bb">
		   		</select>
		   	</label>
		  
		   	<label class="input">
		   		备注：
		   		<textarea rows="" id="modelRemark" name="remark" cols="" style="width: 468px;"></textarea>
		   	</label>
	 	 </div>
	  <div class="modal-footer">
	    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
	    <input type="submit" class="btn btn-primary" id="savechanges"  value="save Changes"/>
  </div>
  </form>
</div>
</body>
</html>