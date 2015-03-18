function uploadImage(){
	var div = document.getElementById('img');
	div.innerHTML="";
	var div2 =document.getElementById('result');
	div2.innerHTML="";
	var f= $("#advImage").val();
	var btn=document.getElementById("advImage");
	/*alert(btn);*/
	if(!/.(gif|jpg|jpeg|png|JPG|PNG)$/.test(f)){
		 $('#result').html("图片格式必须为.jpeg jpg png中的一个,上传失败");
		return false;
	}
	$.ajaxFileUpload({
		url:'upload.html',
		type:'post',
		secureuri:false,
        fileElementId:'advImage',
        dataType:'text',
        success:function (data , status) {
        	var a=new Array();
        	/*alert(data);*/
        	data = data.replace("<PRE>", '');  //ajaxFileUpload会对服务器响应回来的text内容加上<pre>text</pre>前后缀
            data = data.replace("</PRE>", '');
            data = data.replace("<pre>", '');
            data = data.replace("</pre>", '');
         /* var a=data.indexOf(">");*/
            a=data.split("*");
           /* alert(a.length);*/
            for (var int = 0; int < a.length-1; int++) {
			  if(a[int].substring(0,1) == "0"){   
            	/*alert("第一位是零~~");*/
            	/*alert(a[int].substring(2));*/
            	//0表示上传成功(后跟上传后的文件路径),1表示失败(后跟失败描述)
            	div.innerHTML += '<img src="'+a[int].substring(2)+'" style="width:200px;height:200px"/> &nbsp';
            	if(int ==4 || int==9){
            		div.innerHTML += "</p>";
            	}
            	/*$("#photo").attr("src", data.substring(2));*/
                $('#result').html("图片上传成功<br/>");
               /* $("#advImage").click();*/
            }else{
                $('#result').html('图片上传失败，请重试！！');
            }
            }
//        	console.log(data.tmpPath);
//        	$("#photo").attr("src",data.tmpPath);
//        
//        	
//        	$('img#photo').imgAreaSelect({
//                handles: true,
//                keys:{
//                	arrows:15,
//                	ctrl:5,
//                	shift:'resize'
//                },
//                onSelectEnd:function(img,selection){
//                	console.log("width: "+selection.width+"  height"+selection.height+" x1 :"+selection.x1);
//                	$("#x1").val(selection.x1);
//                	$("#y1").val(selection.y1);
//                	$("#x2").val(selection.x2);
//                	$("#y2").val(selection.y2);
//                	$("#w").val(selection.width);
//                	$("#h").val(selection.height);
//                }
//         }); 
       },
       error:function (data, status, e) {
       }
	});
}

