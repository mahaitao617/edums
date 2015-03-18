package com.jsoft.edums.stumnt.entity;

/**
 * 这个是用来截图的entity
 * @author ysq
 *
 */
public class ImageCutInfo {
	// 点 很坐标
	private int x;
	//截图点纵坐标
	private int y;
	//图片的截图宽度
	private int width;
	//图片的截图高度
	private int height;
	//截图的源地址
	private String src;
	//截图保存的目的地址
	private String detation;
	//图片显示的宽度
	private int seeWidth;
	//图片显示的高度
	private int seeHeight;

	public int getSeeWidth() {
		return seeWidth;
	}
	public void setSeeWidth(int seeWidth) {
		this.seeWidth = seeWidth;
	}
	public int getSeeHeight() {
		return seeHeight;
	}
	public void setSeeHeight(int seeHeight) {
		this.seeHeight = seeHeight;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getDetation() {
		return detation;
	}
	public void setDetation(String detation) {
		this.detation = detation;
	}
	
}
