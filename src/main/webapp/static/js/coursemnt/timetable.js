$(document).ready(function(){
	var zhouyi = $("#zhouyi").text();
	console.log(zhouyi);
	$("td.classes").dblclick(function(){
		var campus=$(this).children("#tdCampus").text();
		var classTime=$(this).children("#tdClassTime").text(); 
		var classroom =$(this).children("#tdClassroom").text();
		var date=$(this).children("#tdDate").text();
		var timetableId = $(this).children("#tdTimetableId").text();
		console.log(timetableId);
		//modelTeacher  modelClasses tdteaName tdclassesNo
		var teaId=$(this).children("#tdTeaId").text();
		var classesId=$(this).children("#tdClassesId").text();
		var courseId=$(this).children("#tdCourseId").text();
		var teaName = $(this).children("#tdteaName").text();
		var classesNo=$(this).children("#tdclassesNo").text();
		//接下来做到是就应该是得到  在这个时间地点可以上课的老师    以及在这个时间地点可以上课的班级 以及可以上课的
		$.ajax({
			type:"POST",
			url:"timetable/dataCanArrang.html",
			data:"campus="+campus+"&classTime="+classTime+"&classroom="+classroom+"&date="+date,
			success:function(data, textStatus, jqXHR){
				data = $.parseJSON(data);
				console.log(data[0].length);
				console.log(data[1].length);
				console.log($("#modelTeacher").attr("placeholder"));
				/*if(data[0].length==0){
					$("#modelTeacher").attr("placeholder","暂时没有可以上课的老师");
					console.log($("#modelTeacher").attr("placeholder"));
				}
				if(data[1].length==0){
					$("#modelClasses").attr("placeholder","暂时没有可以上课的班级");
				}*/
				var teacher="";
				var classes="";
				/*alert(data[0].length);*/
				for (var int = 0; int < data[0].length; int++) {
					teacher=teacher+" <option value=\""+data[0][int].teaId+"\">"+data[0][int].teaName+"</option>";
				}
				/*alert(data[1].length);*/
				for (var int = 0; int < data[1].length; int++) {
					classes=classes+" <option value=\""+data[1][int].classesId+"\">"+data[1][int].classesNo+"</option>";
				}
				$("#modelTeacher").append(teacher);
				$("#modelClasses").append(classes);
				console.log(data);
				console.log(textStatus);
				console.log(jqXHR);
			}
		});
		console.log(campus+"dd "+classTime+"a "+classroom+"x " +date);
		console.log("teaId="+teaId+" classesId="+classesId+" courseId="+courseId);
		
		$("#modelCampus").val(campus);
		$("#modelClassroom").val(classroom);
		$("#modelDate").val(date);
		$("#modelClassTime").val(classTime);
		$("#modelTimetableId").val(timetableId);
		if(teaName!=""&&teaName!=null){
			$("#modelTeacher").append("<option selected=\"selected\" value=\""+teaId+"\">"+teaName+"</option>");
		}
		if(classesId!=""&&classesId!=null){
			$("#modelClasses").append("<option selected=\"selected\" value=\""+classesId+"\">"+classesNo+"</option>");
		}
		console.log(this);
		/*console.log(this.children("#tdCampus"))*/
		$('#myModal').modal({backdrop:'static'});
		$('#myModal').modal('show');
	});
	
	$("#campus1").change(function(){
		console.log($("#campus1").val());
		document.location="timetable.html?givecampus="+$("#campus1").val()+"&givedate="+zhouyi;
	});
	$("#lastWeek").click(function(){
		console.log($("#campus1").val());
		var tt = zhouyi.split("-");
		var lastWeek ="";
		tt[tt.length-1]=tt[tt.length-1]-7;
		for (var int = 0; int < tt.length; int++) {
			lastWeek=lastWeek+tt[int]+"-";
		}
		lastWeek=lastWeek.substring(0,lastWeek.length-1);
		console.log(lastWeek);
		document.location="timetable.html?givecampus="+$("#campus1").val()+"&givedate="+lastWeek;
	});
	$("#thisWeek").click(function(){
		document.location="timetable.html?givecampus="+$("#campus1").val();
	});
	$("#nextWeek").click(function(){
		console.log($("#campus1").val());
		var nt = zhouyi.split("-");
		var nextWeek ="";
		nt[nt.length-1]=Number(nt[nt.length-1])+7;
		for (var int = 0; int <nt.length; int++) {
			
			nextWeek=nextWeek+nt[int]+"-";
		}
		nextWeek=nextWeek.substring(0,nextWeek.length-1);
		console.log(nextWeek);
		document.location="timetable.html?givecampus="+$("#campus1").val()+"&givedate="+nextWeek;
		
	});
	
	$('#myModal').on('hidden', function () {
		$("#modelTeacher").empty();
		$("#modelClasses").empty();
	})
});