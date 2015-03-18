工程结构：
base --基类
common --通用组件
	annotation --注解自定义
	interceptor --拦截器
	listener --监听
	plugin --插件，分页插件
	resolver --自定义异常
	util --自定义工具类，字符串转换，日期处理等
	view --用户导出exelc
system --系统设置
	controlller --控制层
	service --业务层
	dao/mapper --对象持久化层
	entity --实体层
webapp --前台视图层
	error --错误页面
	static --静态文件
		--css
		--js
		--images
	userfiles --用户上传附件
	WEB-INF/pages  jsp页面
		common --通用包含的页面
		system --系统设置页面
		student --学生信息
		
	
jsp -> controller -> service -> dao(mapper) -> db(entity)

数据展现 -> 页面转发,数据转换  -> 业务  -> 实体对象的(增删改查) - 持久化