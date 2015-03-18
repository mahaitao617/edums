package com.jsoft.edums.stumnt.controller;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jsoft.edums.base.controller.BaseController;
import com.jsoft.edums.stumnt.entity.ImageCutInfo;
import com.jsoft.edums.stumnt.service.impl.ImageCutService;


@Controller
public class FileUploadController extends BaseController{
	

	private String advImageFileName;
	private String advImageContentType;
	private ImageCutInfo imageCut;
	private ImageCutService imageCutService = new ImageCutService();
	private String imagePath= "/image";
	


	public String getAdvImageFileName() {
		return advImageFileName;
	}

	public void setAdvImageFileName(String advImageFileName) {
		this.advImageFileName = advImageFileName;
	}

	public String getAdvImageContentType() {
		return advImageContentType;
	}

	public void setAdvImageContentType(String advImageContentType) {
		this.advImageContentType = advImageContentType;
	}

	public ImageCutInfo getImageCut() {
		return imageCut;
	}

	public void setImageCut(ImageCutInfo imageCut) {
		this.imageCut = imageCut;
	}

	public ImageCutService getImageCutService() {
		return imageCutService;
	}

	public void setImageCutService(ImageCutService imageCutService) {
		this.imageCutService = imageCutService;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	
	/**
	 * 
	 * 以上是setget方法
	 * @return
	 */
	

	
	/**
	 * 
	 * 用于跳转
	 * @return
	 */
	@RequestMapping(value="/up")
	public ModelAndView tiaozhuan(){
		System.out.println("输出了up点html");
		ModelAndView model=new ModelAndView();
		model.setViewName("student/archives/upload");
		return model;
		
		
	}
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String uploada(HttpServletRequest request,HttpServletResponse response,@RequestParam MultipartFile[] advImage) {

		StringBuffer string =new StringBuffer();
		System.out.println("调用了uploada方法");
		
		
		//		try {
	//	String basepath=request.getSession().getServletContext().get
		//System.err.println(basepath);
//			File file = new File(basepath, advImageFileName);
//			
//			FileUtils.copyFile(advImage, file);
//			
//			basepath = request.getScheme()+"://"+request
//					.getServerName()+":"+request.getServerPort()+request
//					.getContextPath()+imagePath+"/";
//			System.out.println(basepath);
//			String a = "{\"tmpPath\":\""+basepath+advImageFileName+"\",\"msg\":\"\"}";
//			System.out.println(a);
//			
//			response.getWriter().write(a);
//			response.getWriter().flush();
//			response.getWriter().close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//可以在上传文件的同时接收其它参数
        //如果用的是Tomcat服务器，则文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\upload\\文件夹中
        //这里实现文件上传操作用的是commons.io.FileUtils类,它会自动判断/upload是否存在,不存在会自动创建
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        System.out.println(realPath+".....................");
        //设置响应给前台内容的数据格式
        response.setContentType("text/plain; charset=UTF-8");
        //设置响应给前台内容的PrintWriter对象
        PrintWriter out;
		try {
			out = response.getWriter();
        //上传文件的原名(即上传前的文件名字)
        String originalFilename = null;
        //如果只是上传一个文件,则只需要MultipartFile类型接收文件即可,而且无需显式指定@RequestParam注解
        //如果想上传多个文件,那么这里就要用MultipartFile[]类型来接收文件,并且要指定@RequestParam注解
        //上传多个文件时,前台表单中的所有<input type="file"/>的name都应该是myfiles,否则参数里的myfiles无法获取到所有上传的文件
        for(MultipartFile myfile : advImage){
            if(myfile.isEmpty()){
                out.print("1`请选择文件后上传");
                out.flush();
                return null;
            }else{
                originalFilename = myfile.getOriginalFilename();
                System.out.println("文件原名: " + originalFilename);
                System.out.println("文件名称: " + myfile.getName());
                System.out.println("文件长度: " + myfile.getSize());
                System.out.println("文件类型: " + myfile.getContentType());
                System.out.println("========================================");
                try {
                    //这里不必处理IO流关闭的问题,因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉
                    
                	//此处也可以使用Spring提供的MultipartFile.transferTo(File dest)方法实现文件的上传
                    FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(realPath, originalFilename));
                } catch (IOException e) {
                    System.out.println("文件[" + originalFilename + "]上传失败,堆栈轨迹如下");
                    e.printStackTrace();
                    out.print("1`文件上传失败，请重试！！");
                    out.flush();
                    return null;
                }
            }
            string.append("0`" + request.getContextPath() + "/upload/" + originalFilename+"*");
        }
        out.print(string);
        out.flush();
        //此时在Windows下输出的是[D:\Develop\apache-tomcat-6.0.36\webapps\AjaxFileUpload\\upload\愤怒的小鸟.jpg]
        //System.out.println(realPath + "\\" + originalFilename);
        //此时在Windows下输出的是[/AjaxFileUpload/upload/愤怒的小鸟.jpg]
        //System.out.println(request.getContextPath() + "/upload/" + originalFilename);
        //不推荐返回[realPath + "\\" + originalFilename]的值
        //因为在Windows下<img src="file:///D:/aa.jpg">能被firefox显示,而<img src="D:/aa.jpg">firefox是不认的

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        return null;
        
    }

	@RequestMapping(value="/cut",method=RequestMethod.POST)
	public ModelAndView cut(HttpServletRequest request,HttpServletResponse response){
		try{
		/*System.out.println("haha");
		System.out.println(imageCut);
		System.out.println(x);*/
		System.out.println(imageCut.getSrc());
		System.out.println(imageCut.getSeeWidth());
		System.out.println(imageCut.getSeeHeight());
		//得到穿过来的图片名
		String name = imageCut.getSrc().split("/")[imageCut.getSrc().split("/").length-1];
		//得到传过来的文件的后缀 然后以毫秒数命名
		String pat = System.currentTimeMillis()+name.substring(name.indexOf("."), name.length());
		//剪切图片的路径
		String basepath1=request.getSession().getServletContext().getRealPath(imagePath).replace("\\", "/")+"/"+name;
		System.out.println(basepath1);
		imageCut.setSrc(basepath1);
		
		//剪切后图片的路径
		String basepath2=request.getSession().getServletContext().getRealPath(imagePath).replace("\\", "/")+"/"+pat;
		
		System.out.println(basepath2);
		imageCut.setDetation(basepath2);
		imageCutService.cut(imageCut);
		//传回前台的路径
		String basepath = request.getScheme()+"://"+request
				.getServerName()+":"+request.getServerPort()+request
				.getContextPath()+imagePath+"/";
		
		System.out.println(basepath);
		String a1= "{\"tmpPath\":\""+basepath+pat+"\",\"msg\":\"\"}";
		System.out.println(a1);
		
		
			response.getWriter().write(a1);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				//imageCut.cut(srcpath, subpath, x, y, width, height);
		ModelAndView mod =new ModelAndView();
		return mod;
	}
	

}
