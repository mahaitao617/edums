package com.jsoft.edums.classmnt.mapper;

import java.util.List;

import com.jsoft.edums.classmnt.entity.Classes;
import com.jsoft.edums.common.annotation.MyBatisDao;
import com.jsoft.edums.common.entity.Page;

/**
 * 班级的基本操作：增删改查
 * @author 赵开永
 *
 */
@MyBatisDao
public interface ClassMapper {
	/**
	 * 返回所有的班级 需要分页
	 * 需要分页的地方，Mapper里面方法需要以listPage开头
	 * 	并在相应的配置文件中传入参数Page
	 * @param Page 用于分页
	 * @return 返回所有的班级对象
	 */
	public List<Classes> listPageClasses(Page page);
	/**
	 * <br>
	 * <b>功能：</b>查询所有的班级<br>
	 * <b>作者：</b>李成<br>
	 * <b>日期：</b> 2014-11-21 <br>
	 * 返回所有的班级 
	 * @param 
	 * @return 返回所有的班级对象
	 */
	public List<Classes> queryAll();
	
}
