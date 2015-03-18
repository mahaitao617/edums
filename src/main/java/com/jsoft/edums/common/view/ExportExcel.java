package com.jsoft.edums.common.view;


import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/**
* <p>File Name: ExportExcel.java</p>
* <p>Description: 利用开源组件POI3.0.2动态导出多个EXCEL文档 ！
* <p>Copyright(c) 2010-2013 yutian.com Inc. All Rights Reserved. </p>
* <p>Other: </p>
* <p>Date：2013-10-25</p>
* <p>Modification Record 1: </p>
* <pre>
*    Modified Date：
*    Version：
*    Modifier：
*    Modification Content：
* </pre>
* <p>Modification Record 2：…</p>
* @version 1.0
* @author <a href="707616465@qq.com">LiQing</a>
* @param <T>
*               应用泛型，代表任意一个符合javabean风格的类
*            注意这里为了简单起见，boolean型的属性xxx的get器方式为getXxx(),而不是isXxx()
*            byte[]表jpg格式的图片数据
*/
public class ExportExcel<T>{
private final static Logger log = Logger.getLogger(ExportExcel.class);

// 声明一个工作薄
private static HSSFWorkbook workbook = null;
// 生成一个表格
private static HSSFSheet sheet = null;
// 产生表格标题行
private static HSSFRow row = null;
// 声明一个画图的顶级管理器
private static HSSFPatriarch patriarch = null;
//定义一个excel所容纳的初始数据量(防止数据过多，因为一个excel表格最多只能存65535行记录(excel2003的))，所以这里取40000
private static Integer initial_data = 40000;
//累计遍历的数量，用来判断是否超过初始数据，如果超过则新建一个sheet
private int length = 0;

public void exportExcel(String headerName,Collection<T> dataset, OutputStream out) {
   exportExcel(headerName, null, dataset, out, "yyyy-MM-dd");
}
public void exportExcel(String headerName,String[] headers, Collection<T> dataset,
       OutputStream out) {
   exportExcel(headerName, headers, dataset, out, "yyyy-MM-dd");
}
/**
* 这是一个通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出到指定IO设备上
* 
* @param title
*            表格标题名
* @param headers
*            表格属性列名数组
* @param dataset
*            需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的
*            javabean属性的数据类型有基本数据类型及String,Date,byte[](图片数据)
* @param out
*            与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
* @param pattern
*            如果有时间数据，设定输出格式。默认为"yyy-MM-dd"
*/

@SuppressWarnings("unchecked")
public void exportExcel(String title, String[] headers,
       Collection<T> dataset, OutputStream out, String pattern) {
   workbook = new HSSFWorkbook();
   sheet = workbook.createSheet(title);
   // 设置表格默认列宽度为15个字节
   sheet.setDefaultColumnWidth(15);
   row = sheet.createRow(0);
   for (int i = 0; i < headers.length; i++) {
       HSSFCell cell = row.createCell(i);
       HSSFRichTextString text = new HSSFRichTextString(headers[i]);
       cell.setCellValue(text);
   }
   patriarch = sheet.createDrawingPatriarch();
   // 遍历集合数据，产生数据行
   Iterator<T> it = dataset.iterator();
   int index = 0;
   while (it.hasNext()) {
       index++;
       length++;
       row = sheet.createRow(index);
       T t = (T) it.next();
       // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
       Field[] fields = t.getClass().getDeclaredFields();
       for (int i = 0; i < fields.length; i++) {
           HSSFCell cell = row.createCell(i);
           Field field = fields[i];
           String fieldName = field.getName();
           String getMethodName = "get"
                   + fieldName.substring(0, 1).toUpperCase()
                   + fieldName.substring(1);
           try {
               Class tCls = t.getClass();
               Method getMethod = tCls.getMethod(getMethodName,
                       new Class[] {});
               Object value = getMethod.invoke(t, new Object[] {});
               // 判断值的类型后进行强制类型转换
               String textValue = null;
               if (null != value) {
                   if (value instanceof Integer) {
                       int intValue = (Integer) value;
                       cell.setCellValue(intValue);
                   } else if (value instanceof Float) {
                       float fValue = (Float) value;
                       textValue = Float.toString(fValue);
                       cell.setCellValue(textValue);
                   } else if (value instanceof Double) {
                       double dValue = (Double) value;
                       textValue = Double.toString(dValue);
                       cell.setCellValue(textValue);
                   } else if (value instanceof Long) {
                       long longValue = (Long) value;
                       cell.setCellValue(longValue);
                   } else if (value instanceof byte[]) {
                       // 有图片时，设置行高为60px;
                       row.setHeightInPoints(60);
                       // 设置图片所在列宽度为80px,注意这里单位的一个换算
                       sheet.setColumnWidth(i, (short) (35.7 * 80));
                       // sheet.autoSizeColumn(i);
                       byte[] bsValue = (byte[]) value;
                       HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0,
                               1023, 255, (short) 6, index, (short) 6, index);
                       anchor.setAnchorType(2);
                       patriarch.createPicture(anchor, workbook.addPicture(
                               bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
                   }else {
                       // 其它数据类型都当作字符串简单处理
                       textValue = value.toString();
                   }
               }else{
                   textValue = "";
               }
               // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
               if (textValue != null) {
                   Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                   Matcher matcher = p.matcher(textValue);
                   if (matcher.matches()) {
                       // 是数字当作double处理
                       cell.setCellValue(Double.parseDouble(textValue));
                   } else {
                       HSSFRichTextString richString = new HSSFRichTextString(textValue);
                       cell.setCellValue(richString);
                   }
               }
           } catch (Exception e) {
               log.error( ExceptionUtils.getStackTrace(e));
           }
       }
       if(length%initial_data ==0){
           sheet = workbook.createSheet(title+length);
           // 设置表格默认列宽度为15个字节
           sheet.setDefaultColumnWidth(15);
           row = sheet.createRow(0);
           for (int i = 0; i < headers.length; i++) {
               HSSFCell cell = row.createCell(i);
               HSSFRichTextString text = new HSSFRichTextString(headers[i]);
               cell.setCellValue(text);
           }
           patriarch = sheet.createDrawingPatriarch();
           index = 0;
       }
   }
   try {
       workbook.write(out);
   } catch (IOException e) {
       log.error( ExceptionUtils.getStackTrace(e));
       log.error( "导出数据出错");
   }
}
}



