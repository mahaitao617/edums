package com.jsoft.edums.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Tools {
	/**
	 * 检测字符串是否不为空(null,"","null")
	 * @param s
	 * @return 不为空则返回true，否则返回false
	 */
	public static boolean notEmpty(String s){
		return s!=null && !"".equals(s) && !"null".equals(s);
	}
	
	/**
	 * 检测字符串是否为空(null,"","null")
	 * @param s
	 * @return 为空则返回true，不否则返回false
	 */
	public static boolean isEmpty(String s){
		return s==null || "".equals(s) || "null".equals(s);
	}
	
	/**
	 * 字符串转换为字符串数组
	 * @param str 字符串
	 * @param splitRegex 分隔符
	 * @return
	 */
	public static String[] str2StrArray(String str,String splitRegex){
		if(isEmpty(str)){
			return null;
		}
		return str.split(splitRegex);
	}
	
	/**
	 * 用默认的分隔符(,)将字符串转换为字符串数组
	 * @param str	字符串
	 * @return
	 */
	public static String[] str2StrArray(String str){
		return str2StrArray(str,",\\s*");
	}
	
	/**
	 * 按照yyyy-MM-dd HH:mm:ss的格式，日期转字符串
	 * @param date
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String date2Str(Date date){
		return date2Str(date,"yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 按照yyyy-MM-dd HH:mm:ss的格式，字符串转日期
	 * @param date
	 * @return
	 */
	public static Date str2Date(String date){
		if(notEmpty(date)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				return sdf.parse(date);
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			return new Date();
		}else{
			return null;
		}
	}
	
	/**
	 * 按照参数format的格式，日期转字符串
	 * @param date
	 * @param format
	 * @return
	 */
	public static String date2Str(Date date,String format){
		if(date!=null){
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		}else{
			return "";
		}
	}
	/**
	 * 给定一个Int 行的list的集合 然后将这个集合中的数据转换成 1,2,3,4  形式的字符串
	 * @param integers
	 * @return
	 */
	public static String getStringByList(List<Integer> integers){
		String ss = "";
		for (int i = 0; i < integers.size()-1; i++) {
			ss = ss+integers.get(i)+",";
		}
		ss=ss+integers.get(integers.size()-1);
		return ss;
	}
	/**
	 * <br>
	 * <b>功能：</b>得到本周星期一的日期 0时0分0秒<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-17 <br>
	 * <br>
	 * @return 本周星期一的日期  周日为最后一天
	 */
	public static Date getMon(){
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int weekDay = calendar.get(calendar.DAY_OF_WEEK)-1;
		if(weekDay==0){
			weekDay = 7;
		}
	/*	System.out.println(weekDay);
		System.out.println(calendar.get(calendar.DATE));*/
		calendar.set(Calendar.DATE, calendar.get(calendar.DATE)-weekDay+1);
	/*	System.out.println(calendar.get(calendar.DATE));*/
		calendar.set(calendar.HOUR_OF_DAY, 0);
		calendar.set(calendar.MINUTE, 0);
		calendar.set(calendar.SECOND, 0);
		calendar.set(calendar.MILLISECOND, 0);
		date = calendar.getTime();
		return date;
	}
	/**
	 * <br>
	 * <b>功能：</b>根据给定的时间得到那周星期一的日期 0时0分0秒<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-18 <br>
	 * <br>
	 * @return 本周星期一的日期  周日为最后一天
	 */
	public static Date getMon(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int weekDay = calendar.get(calendar.DAY_OF_WEEK)-1;
		if(weekDay==0){
			weekDay = 7;
		}
	/*	System.out.println(weekDay);
		System.out.println(calendar.get(calendar.DATE));*/
		calendar.set(Calendar.DATE, calendar.get(calendar.DATE)-weekDay+1);
	/*	System.out.println(calendar.get(calendar.DATE));*/
		calendar.set(calendar.HOUR_OF_DAY, 0);
		calendar.set(calendar.MINUTE, 0);
		calendar.set(calendar.SECOND, 0);
		calendar.set(calendar.MILLISECOND, 0);
		date = calendar.getTime();
		return date;
	}
	/**
	 * <br>
	 * <b>功能：</b>得到本周星期日的日期 23:59:59<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-17 <br>
	 * <br>
	 * @return 本周星期一的日期  周日为最后一天
	 */
	public static Date getSun(){
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int weekDay = calendar.get(calendar.DAY_OF_WEEK)-1;
		if(weekDay==0){
			weekDay = 7;
		}
	/*	System.out.println(weekDay);
		System.out.println(calendar.get(calendar.DATE));*/
		calendar.set(Calendar.DATE, calendar.get(calendar.DATE)+7-weekDay);
	/*	System.out.println(calendar.get(calendar.DATE));*/
		calendar.set(calendar.HOUR_OF_DAY, 23);
		calendar.set(calendar.MINUTE, 59);
		calendar.set(calendar.SECOND, 59);
		calendar.set(calendar.MILLISECOND, 999);
		date = calendar.getTime();
		return date;
	}
	
	/**
	 * <br>
	 * <b>功能：</b>得到那周星期日的日期 23:59:59<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-21 <br>
	 * <br>
	 * @return 本周星期一的日期  周日为最后一天
	 */
	public static Date getSun(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int weekDay = calendar.get(calendar.DAY_OF_WEEK)-1;
		if(weekDay==0){
			weekDay = 7;
		}
	/*	System.out.println(weekDay);
		System.out.println(calendar.get(calendar.DATE));*/
		calendar.set(Calendar.DATE, calendar.get(calendar.DATE)+7-weekDay);
	/*	System.out.println(calendar.get(calendar.DATE));*/
		calendar.set(calendar.HOUR_OF_DAY, 23);
		calendar.set(calendar.MINUTE, 59);
		calendar.set(calendar.SECOND, 59);
		calendar.set(calendar.MILLISECOND, 999);
		date = calendar.getTime();
		return date;
	}
	/**
	 * <br>
	 * <b>功能：</b>根据一个日期得到那一周所有日期 并以字符串的形式放到集合中  yyyy-mm-dd<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b>2014-11-18<br>
	 * <br>
	 * @return 本周星期一的日期  周日为最后一天
	 */
	public static List<String> getAllDateThisWeek(Date date){
		//System.err.println(date);
		List<String> dates = new ArrayList<String>();
		date = getMon(date);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(calendar.DATE, -1);
		for (int i = 0; i < 7; i++) {
			
			calendar.add(calendar.DATE, 1);
			date = calendar.getTime();
			String date1=date2Str(date, "yyyy-MM-dd");
			dates.add(date1);
		}
		return dates;
	}
	/*public static void main(String[] args) {
		List<String> dates=Tools.getAllDateThisWeek(new Date(114, 10, 01));
		for (int i = 0; i < dates.size(); i++) {
			System.out.println(dates.get(i));
		}
	}*/
}
