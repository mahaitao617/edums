# edums
学生信息管理系统，项目原托管于svnchina上。
#项目开发需求
#
1:系统管理
#
包括登录登出
#
系统菜单增删改查，对菜单的维护。可以根据不同的角色权限查询出相应的菜单
#
对于用户的增删改查，同时对于角色的增删改查
#
对于角色权限的设置，可以让用户选择这个角色可以访问的菜单
#
对于字典的维护 可以对字典进行增删改查
#
对于用户访问的控制，如果用户没有对一个菜单或者请求的访问权限，则禁止用户访问
#
2:学生档案管理
#
对于学生档案信息的基本维护，对于学生信息的维护，包括增删改查等等等
#
学生档案中图片可以批量上传 并且可以对图片进行截取
#
可批量导入学生的档案信息，包括可以批量导入学生的基本信息
#
录取学生的基本信息的时候是否血药验证其邮箱是否可用
#
基本方法中的导入导出功能 写成一个通用模块，导入功能可以让用户选择他是导入本页数据还是导入所有页的数据
#
3：学生出勤管理
#
包括对学生出勤信息的维护，增删改查等等等，
#
发邮件功能的模板 学生每次出现缺勤（请假，旷课，迟到等）都想学生的邮箱发送邮件。
#
设置学生缺勤次数，到达次数，多次发邮件提醒
#
4：班级管理
#
对于班级信息的维护 包括对于班级的增删改查等等
#
可以为班级分配学员，可以为班级分配教师。分配学员的时候需要能够批量分配，列出所有未分配班级的学员，让用户选择将那些学生分配到班级。
#
转班管理，可以记录学生转班的信息
#
5：教师管理
#
对于教师的基本信息的维护，包括增删改查等等
#
对于课时的统计（暂定）
#数据库表结构
用户表(user)
#	
角色表(role)
#	
权限表(competence)
#
菜单表(menu)	
#
档案表（archives）	
#
学生信息表（stuInfo）	
#
班级表（classes）	
#
教师表（teacher）	
#
课程信息表（courseInfo）	
#
排课表（timetable）	
#
出勤记录表（attendanceRecords）	
#
字典表（diction）	
#
#项目技术说明
#
1:本项目使用了spring+springMVC+mybatis 的框架组合 
#
2:前台页面使用了BUI框架来搭建菜单目录（上下左右）的结构层次
#
3:页面使用的是BootStrap 的框架，版本为BootStrap2
#
4:项目管理使用的是maven 以及svn 进行的
#项目组成员
51jsoft,hcc,river,zhangxiaowei001,zhuyuwaiting,dongge,xining,wsl,976441364,zhangjk007,xufudong2012,michaelLychee,che,szy,shuang,ysq,kino,yoyiuy,123Yu,wsc1995,wch,zhouchen,xiaomeng123,yuanxin,sunrunze,architecture,sukki
