/*
MySQL Data Transfer
Source Host: localhost
Source Database: myedums
Target Host: localhost
Target Database: myedums
Date: 2014/11/21 9:02:06
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for diction
-- ----------------------------
DROP TABLE IF EXISTS `diction`;
CREATE TABLE `diction` (
  `dictionId` int(11) NOT NULL auto_increment,
  `childId` varchar(64) default NULL,
  `fatherId` varchar(64) default NULL,
  `dictionName` varchar(64) default NULL,
  `describle` varchar(200) default NULL,
  `buildTime` datetime default NULL,
  `isDelete` int(11) default '0',
  PRIMARY KEY  (`dictionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `diction` VALUES ('1', '1001', null, '性别', null, '2014-11-16 10:26:26', '0');
INSERT INTO `diction` VALUES ('2', '100101', '1001', '男', null, '2014-11-16 10:11:02', '0');
INSERT INTO `diction` VALUES ('3', '100102', '1001', '女', null, '2014-11-16 10:10:56', '0');
INSERT INTO `diction` VALUES ('4', '1002', null, '学校', null, '2014-11-16 10:26:50', '0');
INSERT INTO `diction` VALUES ('5', '100201', '1002', '吉林大学', null, '2014-11-16 10:29:59', '0');
INSERT INTO `diction` VALUES ('6', '100202', '1002', '东北师范大学', null, '2014-11-16 10:30:23', '0');
INSERT INTO `diction` VALUES ('7', '100203', '1002', '长春大学', null, '2014-11-16 10:30:50', '0');
INSERT INTO `diction` VALUES ('8', '100204', '1002', '长春理工大学', null, '2014-11-16 10:31:40', '0');
INSERT INTO `diction` VALUES ('9', '100205', '1002', '长春工业大学', null, '2014-11-16 10:31:55', '0');
INSERT INTO `diction` VALUES ('10', '100206', '1002', '长春工程大学', null, '2014-11-16 10:33:20', '0');
INSERT INTO `diction` VALUES ('11', '100207', '1002', '长春师范学院', null, '2014-11-16 10:39:28', '0');
INSERT INTO `diction` VALUES ('12', '100208', '1002', '长春职业技术学校', null, '2014-11-16 10:39:31', '0');
INSERT INTO `diction` VALUES ('13', '100209', '1002', '吉林农业大学', null, '2014-11-16 10:39:34', '0');
INSERT INTO `diction` VALUES ('14', '100210', '1002', '吉林建筑工程学院', null, '2014-11-16 10:39:37', '0');
INSERT INTO `diction` VALUES ('15', '100211', '1002', '吉林建筑工程师范学院', null, '2014-11-16 10:39:39', '0');
INSERT INTO `diction` VALUES ('16', '100212', '1002', '长春人文学院', null, '2014-11-16 10:39:42', '0');
INSERT INTO `diction` VALUES ('17', '1003', null, '学院', null, '2014-11-16 10:40:05', '0');
INSERT INTO `diction` VALUES ('18', '100301', '1003', '计算机科学与技术', null, '2014-11-16 10:59:07', '0');
INSERT INTO `diction` VALUES ('19', '100302', '1003', '软件工程', null, '2014-11-16 10:59:10', '0');
INSERT INTO `diction` VALUES ('20', '100303', '1003', '数学', null, '2014-11-16 10:59:12', '0');
INSERT INTO `diction` VALUES ('21', '100304', '1003', '金融', null, '2014-11-16 10:59:14', '0');
INSERT INTO `diction` VALUES ('22', '100304', '1003', '电子技术', null, '2014-11-16 10:59:18', '0');
INSERT INTO `diction` VALUES ('23', '1004', '', '专业', null, '2014-11-16 10:59:20', '0');
INSERT INTO `diction` VALUES ('24', '100401', '1004', '计算机科学与技术', null, '2014-11-16 10:59:23', '0');
INSERT INTO `diction` VALUES ('25', '100402', '1004', '网络信息与安全', null, '2014-11-16 10:59:25', '0');
INSERT INTO `diction` VALUES ('26', '100403', '1004', '物联网', null, '2014-11-16 10:59:28', '0');
INSERT INTO `diction` VALUES ('27', '100404', '1004', '软件工程', null, '2014-11-16 10:59:30', '0');
INSERT INTO `diction` VALUES ('28', '100405', '1004', '基础数学', null, '2014-11-16 10:59:34', '0');
INSERT INTO `diction` VALUES ('29', '100406', '1004', '应用数学', null, '2014-11-16 10:59:36', '0');
INSERT INTO `diction` VALUES ('30', '100407', '1004', '金融管理', null, '2014-11-16 10:59:39', '0');
INSERT INTO `diction` VALUES ('31', '100408', '1004', '国际金融', null, '2014-11-16 10:59:44', '0');
INSERT INTO `diction` VALUES ('32', '100409', '1004', '微电子', null, '2014-11-16 10:59:47', '0');
INSERT INTO `diction` VALUES ('33', '100410', '1004', '电子科技', null, '2014-11-16 10:59:49', '0');
INSERT INTO `diction` VALUES ('34', '1005', null, '政治身份', null, '2014-11-16 10:59:52', '0');
INSERT INTO `diction` VALUES ('35', '100501', '1005', '党员', null, '2014-11-16 10:59:55', '0');
INSERT INTO `diction` VALUES ('36', '100502', '1005', '团员', null, '2014-11-16 10:59:57', '0');
INSERT INTO `diction` VALUES ('37', '100503', '1005', '群众', null, '2014-11-16 11:00:00', '0');
INSERT INTO `diction` VALUES ('38', '100504', '1005', '预备党员', null, '2014-11-16 11:00:03', '0');
INSERT INTO `diction` VALUES ('39', '100505', '1005', '罪犯', null, '2014-11-16 11:00:05', '0');
INSERT INTO `diction` VALUES ('40', '100506', '1005', '民主党派', null, '2014-11-16 11:00:09', '0');
INSERT INTO `diction` VALUES ('41', '1006', null, '学历', null, '2014-11-16 11:24:04', '0');
INSERT INTO `diction` VALUES ('42', '100601', '1006', '本科', null, '2014-11-16 11:24:07', '0');
INSERT INTO `diction` VALUES ('43', '100602', '1006', '专科', null, '2014-11-16 11:24:10', '0');
INSERT INTO `diction` VALUES ('44', '100603', '1006', '硕士研究生', null, '2014-11-16 11:24:12', '0');
INSERT INTO `diction` VALUES ('45', '100604', '1006', '博士研究生', null, '2014-11-16 11:24:15', '0');
INSERT INTO `diction` VALUES ('46', '100605', '1006', '大专', null, '2014-11-16 11:24:17', '0');
INSERT INTO `diction` VALUES ('47', '100606', '1006', '中专', null, '2014-11-16 11:24:21', '0');
INSERT INTO `diction` VALUES ('48', '100607', '1006', '高中', null, '2014-11-16 11:24:23', '0');
INSERT INTO `diction` VALUES ('49', '1007', null, 'EnglishCet', null, '2014-11-16 11:24:28', '0');
INSERT INTO `diction` VALUES ('50', '100701', '1007', '四级', null, '2014-11-16 11:24:31', '0');
INSERT INTO `diction` VALUES ('51', '100702', '1007', '六级', null, '2014-11-16 11:24:33', '0');
INSERT INTO `diction` VALUES ('52', '100703', '1007', '专业四级', null, '2014-11-16 11:24:37', '0');
INSERT INTO `diction` VALUES ('53', '100704', '1007', '专业六级', null, '2014-11-16 11:24:39', '0');
INSERT INTO `diction` VALUES ('54', '100705', '1007', '专业八级', null, '2014-11-16 11:24:43', '0');
INSERT INTO `diction` VALUES ('55', '1008', null, '民族', null, '2014-11-16 11:24:45', '0');
INSERT INTO `diction` VALUES ('56', '100801', '1008', '汉族', null, '2014-11-16 11:24:48', '0');
INSERT INTO `diction` VALUES ('57', '100802', '1008', '壮族', null, '2014-11-16 11:24:51', '0');
INSERT INTO `diction` VALUES ('58', '100803', '1008', '满族', null, '2014-11-16 11:24:53', '0');
INSERT INTO `diction` VALUES ('59', '100804', '1008', '回族', null, '2014-11-16 11:24:56', '0');
INSERT INTO `diction` VALUES ('60', '100805', '1008', '苗族', null, '2014-11-16 11:24:57', '0');
INSERT INTO `diction` VALUES ('61', '100806', '1008', '维吾尔族', null, '2014-11-16 11:25:00', '0');
INSERT INTO `diction` VALUES ('62', '100807', '1008', '土家族', null, '2014-11-16 11:25:02', '0');
INSERT INTO `diction` VALUES ('63', '100808', '1008', '彝族', null, '2014-11-16 11:25:04', '0');
INSERT INTO `diction` VALUES ('64', '100809', '1008', '蒙古族', null, '2014-11-16 11:25:05', '0');
INSERT INTO `diction` VALUES ('65', '100810', '1008', '藏族', null, '2014-11-16 11:25:07', '0');
INSERT INTO `diction` VALUES ('66', '100811', '1008', '布依族', null, '2014-11-16 11:25:08', '0');
INSERT INTO `diction` VALUES ('67', '100812', '1008', '侗族', null, '2014-11-16 11:25:12', '0');
INSERT INTO `diction` VALUES ('68', '100813', '1008', '瑶族', null, '2014-11-16 11:25:17', '0');
INSERT INTO `diction` VALUES ('69', '100814', '1008', '朝鲜族', null, '2014-11-16 11:25:18', '0');
INSERT INTO `diction` VALUES ('70', '100815', '1008', '白族', null, '2014-11-16 11:25:19', '0');
INSERT INTO `diction` VALUES ('71', '100816', '1008', '哈尼族', null, '2014-11-16 11:25:20', '0');
INSERT INTO `diction` VALUES ('72', '100817', '1008', '哈萨克族', null, '2014-11-16 11:25:20', '0');
INSERT INTO `diction` VALUES ('73', '100818', '1008', '黎族', null, '2014-11-16 11:25:22', '0');
INSERT INTO `diction` VALUES ('74', '100819', '1008', '傣族', null, '2014-11-16 11:25:23', '0');
INSERT INTO `diction` VALUES ('75', '100820', '1008', '畲族', null, '2014-11-16 11:25:25', '0');
INSERT INTO `diction` VALUES ('76', '100821', '1008', '傈僳族', null, '2014-11-16 11:25:34', '0');
INSERT INTO `diction` VALUES ('77', '100822', '1008', '仡佬族', null, '2014-11-16 11:25:35', '0');
INSERT INTO `diction` VALUES ('78', '100823', '1008', '东乡族', null, '2014-11-16 11:25:36', '0');
INSERT INTO `diction` VALUES ('79', '100824', '1008', '高山族', null, '2014-11-16 11:25:37', '0');
INSERT INTO `diction` VALUES ('80', '100825', '1008', '拉祜族', null, '2014-11-16 11:25:38', '0');
INSERT INTO `diction` VALUES ('81', '100826', '1008', '水族', null, '2014-11-16 11:25:38', '0');
INSERT INTO `diction` VALUES ('82', '100827', '1008', '佤族', null, '2014-11-16 11:25:39', '0');
INSERT INTO `diction` VALUES ('83', '100828', '1008', '纳西族', null, '2014-11-16 11:25:40', '0');
INSERT INTO `diction` VALUES ('84', '100829', '1008', '羌族', null, '2014-11-16 11:25:41', '0');
INSERT INTO `diction` VALUES ('85', '100830', '1008', '土族', null, '2014-11-16 11:25:43', '0');
INSERT INTO `diction` VALUES ('86', '100831', '1008', '仫佬族', null, '2014-11-16 11:25:44', '0');
INSERT INTO `diction` VALUES ('87', '100832', '1008', '锡伯族', null, '2014-11-16 11:25:45', '0');
INSERT INTO `diction` VALUES ('88', '100833', '1008', '柯尔克孜族', null, '2014-11-16 11:25:45', '0');
INSERT INTO `diction` VALUES ('89', '100834', '1008', '达斡尔族', null, '2014-11-16 11:25:46', '0');
INSERT INTO `diction` VALUES ('90', '100835', '1008', '景颇族', null, '2014-11-16 11:25:47', '0');
INSERT INTO `diction` VALUES ('91', '100836', '1008', '毛南族', '', '2014-11-16 11:25:48', '0');
INSERT INTO `diction` VALUES ('92', '100837', '1008', '撒拉族', null, '2014-11-16 11:25:49', '0');
INSERT INTO `diction` VALUES ('93', '100838', '1008', '布朗族', null, '2014-11-16 11:25:50', '0');
INSERT INTO `diction` VALUES ('94', '100839', '1008', '塔吉克族', null, '2014-11-16 11:25:52', '0');
INSERT INTO `diction` VALUES ('95', '100840', '1008', '阿昌族', null, '2014-11-16 11:25:53', '0');
INSERT INTO `diction` VALUES ('96', '100841', '1008', '普米族', null, '2014-11-16 11:25:54', '0');
INSERT INTO `diction` VALUES ('97', '100842', '1008', '鄂温克族', null, '2014-11-16 11:25:54', '0');
INSERT INTO `diction` VALUES ('98', '100844', '1008', '京族', null, '2014-11-16 11:25:57', '0');
INSERT INTO `diction` VALUES ('99', '100843', '1008', '怒族', null, '2014-11-16 11:25:55', '0');
INSERT INTO `diction` VALUES ('100', '100845', '1008', '基诺族', null, '2014-11-16 11:25:58', '0');
INSERT INTO `diction` VALUES ('101', '100846', '1008', '德昂族', null, '2014-11-16 11:25:59', '0');
INSERT INTO `diction` VALUES ('102', '100847', '1008', '保安族', null, '2014-11-16 11:26:00', '0');
INSERT INTO `diction` VALUES ('103', '100848', '1008', '俄罗斯族', null, '2014-11-16 11:26:06', '0');
INSERT INTO `diction` VALUES ('104', '100849', '1008', '裕固族', null, '2014-11-16 11:26:07', '0');
INSERT INTO `diction` VALUES ('105', '100850', '1008', '乌孜别克族', null, '2014-11-16 11:26:08', '0');
INSERT INTO `diction` VALUES ('106', '100851', '1008', '门巴族', null, '2014-11-16 11:26:08', '0');
INSERT INTO `diction` VALUES ('107', '100852', '1008', '鄂伦春族', null, '2014-11-16 11:26:09', '0');
INSERT INTO `diction` VALUES ('108', '100853', '1008', '独龙族', null, '2014-11-16 11:26:10', '0');
INSERT INTO `diction` VALUES ('109', '100854', '1008', '塔塔尔族', null, '2014-11-16 11:26:11', '0');
INSERT INTO `diction` VALUES ('110', '100855', '1008', '赫哲族', null, '2014-11-16 11:26:12', '0');
INSERT INTO `diction` VALUES ('111', '100856', '1008', '珞巴族', null, '2014-11-16 11:26:13', '0');
INSERT INTO `diction` VALUES ('112', '1009', null, '档案状态', null, '2014-11-16 11:26:47', '0');
INSERT INTO `diction` VALUES ('113', '100901', '1009', '在档', null, '2014-11-16 11:28:42', '0');
INSERT INTO `diction` VALUES ('114', '100902', '1009', '删档', null, '2014-11-16 11:29:31', '0');
INSERT INTO `diction` VALUES ('115', '100903', '1009', '弃档', null, '2014-11-16 11:29:32', '0');
INSERT INTO `diction` VALUES ('116', '1010', null, '学生状态', null, '2014-11-16 11:49:42', '0');
INSERT INTO `diction` VALUES ('117', '101001', '1010', '在读', null, '2014-11-16 11:49:42', '0');
INSERT INTO `diction` VALUES ('118', '101002', '1010', '毕业', null, '2014-11-16 11:49:41', '0');
INSERT INTO `diction` VALUES ('119', '101003', '1010', '开除', null, '2014-11-16 11:49:40', '0');
INSERT INTO `diction` VALUES ('120', '1011', null, '班级类型', null, '2014-11-16 11:49:39', '0');
INSERT INTO `diction` VALUES ('121', '101101', '1011', 'Java', null, '2014-11-16 11:49:39', '0');
INSERT INTO `diction` VALUES ('122', '101102', '1011', '美工', null, '2014-11-16 11:49:38', '0');
INSERT INTO `diction` VALUES ('123', '101103', '1011', '嵌入式', null, '2014-11-16 11:49:37', '0');
INSERT INTO `diction` VALUES ('124', '101104', '1011', 'Web前端', null, '2014-11-16 11:49:37', '0');
INSERT INTO `diction` VALUES ('125', '1012', null, '班级状态', null, '2014-11-16 11:49:36', '0');
INSERT INTO `diction` VALUES ('126', '101201', '1012', '开班', null, '2014-11-16 11:49:35', '0');
INSERT INTO `diction` VALUES ('127', '101202', '1012', '结班', null, '2014-11-16 11:49:34', '0');
INSERT INTO `diction` VALUES ('128', '1013', '', '教师等级', null, '2014-11-16 11:49:33', '0');
INSERT INTO `diction` VALUES ('129', '101301', '1013', '教授', null, '2014-11-16 11:49:33', '0');
INSERT INTO `diction` VALUES ('130', '101302', '1013', '副教授', null, '2014-11-16 11:49:32', '0');
INSERT INTO `diction` VALUES ('131', '101303', '1013', '讲师', null, '2014-11-16 11:49:31', '0');
INSERT INTO `diction` VALUES ('132', '1014', null, '教师状态', null, '2014-11-16 11:49:24', '0');
INSERT INTO `diction` VALUES ('133', '101401', '1014', '在职', null, '2014-11-16 11:49:23', '0');
INSERT INTO `diction` VALUES ('134', '101402', '1014', '离职', null, '2014-11-16 11:49:22', '0');
INSERT INTO `diction` VALUES ('135', '101403', '1014', '退休', null, '2014-11-16 11:49:21', '0');
INSERT INTO `diction` VALUES ('136', '1015', null, '课时', null, '2014-11-16 11:49:20', '0');
INSERT INTO `diction` VALUES ('137', '101501', '1015', '64课时', null, '2014-11-16 11:49:19', '0');
INSERT INTO `diction` VALUES ('138', '101502', '1015', '32课时', null, '2014-11-16 11:49:18', '0');
INSERT INTO `diction` VALUES ('139', '101601', '1016', '开课', null, '2014-11-16 11:49:17', '0');
INSERT INTO `diction` VALUES ('140', '1016', null, '课程状态', null, '2014-11-16 11:49:18', '0');
INSERT INTO `diction` VALUES ('141', '101602', '1016', '未开课', null, '2014-11-16 11:49:16', '0');
INSERT INTO `diction` VALUES ('142', '101603', '1016', '结课', null, '2014-11-16 11:49:15', '0');
INSERT INTO `diction` VALUES ('143', '1017', null, '校区', null, '2014-11-16 11:49:14', '0');
INSERT INTO `diction` VALUES ('144', '101701', '1017', '吉大校区', null, '2014-11-16 11:49:13', '0');
INSERT INTO `diction` VALUES ('145', '101702', '1017', '净月校区', null, '2014-11-16 11:49:11', '0');
INSERT INTO `diction` VALUES ('146', '101703', '1017', '卫星广场校区', null, '2014-11-16 11:49:10', '0');
INSERT INTO `diction` VALUES ('147', '1018', null, '教室', null, '2014-11-16 11:49:09', '0');
INSERT INTO `diction` VALUES ('148', '101801', '1018', '409', null, '2014-11-16 11:49:09', '0');
INSERT INTO `diction` VALUES ('149', '101802', '1018', '410', null, '2014-11-16 11:49:08', '0');
INSERT INTO `diction` VALUES ('150', '101803', '1018', '1535', null, '2014-11-16 11:49:07', '0');
INSERT INTO `diction` VALUES ('151', '101804', '1018', '1537', null, '2014-11-16 11:49:06', '0');
INSERT INTO `diction` VALUES ('152', '101805', '1018', '1542', null, '2014-11-16 11:49:05', '0');
INSERT INTO `diction` VALUES ('153', '1019', null, '上课时间', null, '2014-11-16 11:49:04', '0');
INSERT INTO `diction` VALUES ('154', '101901', '1019', '上午', null, '2014-11-16 11:49:03', '0');
INSERT INTO `diction` VALUES ('155', '101902', '1019', '下午', null, '2014-11-16 11:49:02', '0');
INSERT INTO `diction` VALUES ('156', '101903', '1019', '晚上', null, '2014-11-16 11:49:01', '0');
INSERT INTO `diction` VALUES ('157', '1020', null, '出勤状态', null, '2014-11-16 11:49:00', '0');
INSERT INTO `diction` VALUES ('158', '102001', '1020', '请假', null, '2014-11-16 11:49:00', '0');
INSERT INTO `diction` VALUES ('159', '102002', '1020', '旷课', null, '2014-11-16 11:48:58', '0');
INSERT INTO `diction` VALUES ('160', '102003', '1020', '迟到', null, '2014-11-16 11:48:57', '0');
INSERT INTO `diction` VALUES ('161', '102004', '1020', '早退', null, '2014-11-16 11:48:56', '0');
INSERT INTO `diction` VALUES ('162', '102005', '1020', '迟到+早退', null, '2014-11-16 11:48:55', '0');
INSERT INTO `diction` VALUES ('163', '101704', '1017', '高新校区', null, '2014-11-16 11:48:50', '0');
INSERT INTO `diction` VALUES ('164', '', '', null, null, null, null);
