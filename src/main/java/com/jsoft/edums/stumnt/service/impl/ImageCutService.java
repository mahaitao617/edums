package com.jsoft.edums.stumnt.service.impl;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import com.jsoft.edums.stumnt.entity.ImageCutInfo;

/**
 * 这是用来截图的方法
 * @author ysq
 *
 */
public class ImageCutService {
	/**
	 * 给定一个 imageCutInfo  进行截图保存 并且 返回保存后的文件名
	 * @param imageCutInfo
	 * @return
	 */
	public void cut(ImageCutInfo imageCutInfo){
		
		System.out.println(imageCutInfo.getSrc());
		System.out.println(imageCutInfo.getDetation());
		System.out.println(imageCutInfo.getHeight());
		System.out.println(imageCutInfo.getSeeHeight());
		System.out.println(imageCutInfo.getSeeWidth());
		System.out.println(imageCutInfo.getWidth());
		System.out.println(imageCutInfo.getX());
		System.out.println(imageCutInfo.getY());
		FileInputStream is = null;
		ImageInputStream iis=null;
		try {
			is = new FileInputStream(imageCutInfo.getSrc());
			reset(imageCutInfo);
			System.out.println("-------------------");
			System.out.println(imageCutInfo.getSrc());
			System.out.println(imageCutInfo.getDetation());
			System.out.println(imageCutInfo.getHeight());
			System.out.println(imageCutInfo.getSeeHeight());
			System.out.println(imageCutInfo.getSeeWidth());
			System.out.println(imageCutInfo.getWidth());
			System.out.println(imageCutInfo.getX());
			System.out.println(imageCutInfo.getY());
			System.out.println("--------------------");
			
			//以上是回溯比例 
			//一下开始截取图片
			String postFix = getPostfix(imageCutInfo.getSrc());
			//得到图片偏离解析器
			Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName(postFix);
			ImageReader reader = it.next();
			//得到图片的输入流
			iis = ImageIO.createImageInputStream(is);
			//读入
			System.out.println(postFix);
			reader.setInput(iis, true);
			ImageReadParam param = reader.getDefaultReadParam();
			System.out.println(param);
			System.out.println(iis);
			 Rectangle rect = new Rectangle(imageCutInfo.getX(),imageCutInfo.getY(),imageCutInfo.getWidth(),imageCutInfo.getHeight());
			 param.setSourceRegion(rect);
			BufferedImage bi = reader.read(0, param);
				//ImageIO.write(bi, postFix, new File(subpath + "_" + new Date().getTime() + "." + postFix));
			
			ImageIO.write(bi, postFix, new File(imageCutInfo.getDetation()));
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(is!=null){
				is.close();
				}
				if(iis!=null){
				iis.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//得到文件后缀
	public String getPostfix(String inputFilePath){
		return inputFilePath.substring(inputFilePath.lastIndexOf(".") + 1);
	}
	
	public void reset(ImageCutInfo imageCutInfo){
		FileInputStream is = null;
		try {
			is = new FileInputStream(imageCutInfo.getSrc());
			BufferedImage bufferedImg = ImageIO.read(is);
			//图片本身的高度和宽度
			int imgWidth = bufferedImg.getWidth();
			int imgHeight = bufferedImg.getHeight();
			System.out.println("imagew:"+imgWidth);
			System.out.println("imageh:"+imgHeight);
			//得到对应缩小的比例
			if(imgWidth>=imageCutInfo.getSeeWidth()){
				//表示宽度缩小 缩小的倍数
				imageCutInfo.setX(imageCutInfo.getX()*(imgWidth/imageCutInfo.getSeeWidth()+1));
				imageCutInfo.setWidth(imageCutInfo.getWidth()*(imgWidth/imageCutInfo.getSeeWidth()+1));
			}else{
				imageCutInfo.setX(imageCutInfo.getX()/(imageCutInfo.getSeeWidth()/imgWidth));
				imageCutInfo.setWidth(imageCutInfo.getWidth()/(imageCutInfo.getSeeWidth()/imgWidth));
			}
			if(imgHeight>imageCutInfo.getSeeHeight()){
				//表示高度缩小 缩小的倍数
				imageCutInfo.setY(imageCutInfo.getY()*(imgHeight/imageCutInfo.getSeeHeight()+1));
				imageCutInfo.setHeight(imageCutInfo.getHeight()*(imgHeight/imageCutInfo.getSeeHeight()+1));
			}else{
				imageCutInfo.setY(imageCutInfo.getY()/(imageCutInfo.getSeeHeight()/imgHeight));
				imageCutInfo.setHeight(imageCutInfo.getHeight()/(imageCutInfo.getSeeHeight()/imgHeight));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}}
