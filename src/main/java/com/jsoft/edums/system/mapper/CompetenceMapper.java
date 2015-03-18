package com.jsoft.edums.system.mapper;

import java.util.List;

import com.jsoft.edums.common.annotation.MyBatisDao;
import com.jsoft.edums.system.entity.Competence;
/**
 * 角色与权限的关系表  对角色权限之间的关系进行操作
 * @author 李成
 *
 */
@MyBatisDao
public interface CompetenceMapper {
	/**
	 * 根据角色id 返回所有这个角色的 对应的角色与权限的关系 从而可以得到所有菜单的id
	 * @param role_id
	 * @return
	 */
	public List<Competence> getCompetenceById(int role_id);
}
