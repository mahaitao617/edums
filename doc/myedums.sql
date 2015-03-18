/*
Navicat MySQL Data Transfer

Source Server         : MyNewConnector
Source Server Version : 50142
Source Host           : localhost:3306
Source Database       : edums

Target Server Type    : MYSQL
Target Server Version : 50142
File Encoding         : 65001

Date: 2014-11-21 23:41:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `archives`
-- ----------------------------
DROP TABLE IF EXISTS `archives`;
CREATE TABLE `archives` (
  `archivesId` int(11) NOT NULL AUTO_INCREMENT,
  `archivesNo` varchar(64) DEFAULT NULL,
  `stuName` varchar(32) DEFAULT NULL,
  `sex` varchar(64) DEFAULT NULL,
  `IDCardNo` varchar(18) DEFAULT NULL,
  `university` varchar(64) DEFAULT NULL,
  `college` varchar(64) DEFAULT NULL,
  `major` varchar(64) DEFAULT NULL,
  `inTime` datetime DEFAULT NULL,
  `buildTime` datetime DEFAULT NULL,
  `politicalAffiliation` varchar(64) DEFAULT NULL,
  `eduBackground` varchar(64) DEFAULT NULL,
  `englishLevel` varchar(64) DEFAULT NULL,
  `nation` varchar(64) DEFAULT NULL,
  `birthplace` varchar(200) DEFAULT NULL,
  `photo` varchar(64) DEFAULT NULL,
  `address` varchar(64) DEFAULT NULL,
  `archivesState` varchar(64) DEFAULT NULL,
  `isDelete` int(11) DEFAULT NULL,
  PRIMARY KEY (`archivesId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of archives
-- ----------------------------

-- ----------------------------
-- Table structure for `attendancerecords`
-- ----------------------------
DROP TABLE IF EXISTS `attendancerecords`;
CREATE TABLE `attendancerecords` (
  `ARId` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) DEFAULT NULL,
  `timetable_id` int(11) DEFAULT NULL,
  `ARState` varchar(64) DEFAULT NULL,
  `leaveReason` varchar(200) DEFAULT NULL,
  `isDelete` int(11) DEFAULT NULL,
  PRIMARY KEY (`ARId`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attendancerecords
-- ----------------------------
INSERT INTO `attendancerecords` VALUES ('1', '1', '1', '102001', '请假原因不详', '0');
INSERT INTO `attendancerecords` VALUES ('14', '1', '1', '102002', '', '0');
INSERT INTO `attendancerecords` VALUES ('15', '2', '1', '102003', '', '0');

-- ----------------------------
-- Table structure for `changeclass`
-- ----------------------------
DROP TABLE IF EXISTS `changeclass`;
CREATE TABLE `changeclass` (
  `changeId` int(11) NOT NULL AUTO_INCREMENT,
  `stuNo` varchar(255) NOT NULL COMMENT '学号，转班学号不变',
  `oldClassNo` int(11) NOT NULL COMMENT '班转之前的班级编号',
  `curClassNo` int(11) NOT NULL COMMENT '现在的班级编号',
  `changeTime` datetime NOT NULL COMMENT '认默系统时间',
  `comment` varchar(255) NOT NULL COMMENT '注备，转班原因等',
  `isDelete` int(11) NOT NULL DEFAULT '0' COMMENT '0 不删 1删除',
  PRIMARY KEY (`changeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of changeclass
-- ----------------------------

-- ----------------------------
-- Table structure for `classes`
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
  `classesId` int(11) NOT NULL AUTO_INCREMENT,
  `classesNo` int(11) DEFAULT NULL,
  `buildTime` datetime DEFAULT NULL,
  `closeTime` datetime DEFAULT NULL,
  `classesType` varchar(64) DEFAULT NULL,
  `numLimit` int(11) DEFAULT NULL,
  `buildPerson` int(11) DEFAULT NULL,
  `headerTea` int(11) DEFAULT NULL,
  `describle` varchar(200) DEFAULT NULL,
  `classState` varchar(64) DEFAULT NULL,
  `isDelete` int(11) DEFAULT NULL,
  PRIMARY KEY (`classesId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES ('1', '1', '2014-11-18 08:51:00', '2014-11-18 08:51:04', '101101', '30', '1', '1', 'java班', '101201', '0');
INSERT INTO `classes` VALUES ('2', '2', '2014-11-29 22:56:47', '2014-11-29 22:56:52', '101101', '30', '2', '2', 'java班', '101201', '0');
INSERT INTO `classes` VALUES ('3', '3', '2014-11-20 22:59:08', '2014-11-20 22:59:11', '101101', '30', '3', '3', 'java班', '101201', '0');
INSERT INTO `classes` VALUES ('4', '4', '2014-11-20 22:59:57', '2014-11-20 23:00:00', '101101', '30', '4', '4', 'java班', '101201', '0');
INSERT INTO `classes` VALUES ('5', '5', '2014-11-20 23:02:32', '2014-11-20 23:02:35', '101101', '30', '5', '5', 'java班', '101201', '0');
INSERT INTO `classes` VALUES ('6', '6', '2014-11-20 23:03:00', '2014-11-20 23:03:02', '101101', '30', '6', '6', 'java班', '101201', '0');
INSERT INTO `classes` VALUES ('7', '7', '2014-11-20 23:03:17', '2014-11-20 23:03:20', '101101', '30', '7', '7', 'java班', '101201', '0');
INSERT INTO `classes` VALUES ('8', '8', '2014-11-20 23:03:35', '2014-11-20 23:03:37', '101101', '30', '8', '8', 'java班', '101201', '0');
INSERT INTO `classes` VALUES ('9', '10', '2014-11-20 23:03:50', '2014-11-20 23:03:52', '101101', '30', '10', '10', 'java班', '101201', '0');
INSERT INTO `classes` VALUES ('10', '11', '2014-11-20 23:04:08', '2014-11-20 23:04:10', '101101', '30', '11', '11', 'java班', '101201', '0');
INSERT INTO `classes` VALUES ('11', '12', '2014-11-20 23:04:24', '2014-11-20 23:04:27', '101101', '30', '12', '12', 'java班', '101201', '0');
INSERT INTO `classes` VALUES ('12', '9', '2014-11-20 23:05:13', '2014-11-20 23:05:17', '101101', '30', '9', '9', 'java班', '101201', '0');
INSERT INTO `classes` VALUES ('13', '13', '2014-11-20 23:05:58', '2014-11-20 23:06:02', '101101', '30', '13', '13', 'java班', '101201', '0');

-- ----------------------------
-- Table structure for `competence`
-- ----------------------------
DROP TABLE IF EXISTS `competence`;
CREATE TABLE `competence` (
  `competenceId` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  `isDelete` int(11) DEFAULT NULL,
  PRIMARY KEY (`competenceId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of competence
-- ----------------------------
INSERT INTO `competence` VALUES ('1', '1', '2', '0');
INSERT INTO `competence` VALUES ('2', '1', '3', '0');
INSERT INTO `competence` VALUES ('3', '1', '4', '0');
INSERT INTO `competence` VALUES ('4', '1', '5', '0');
INSERT INTO `competence` VALUES ('5', '1', '7', '0');
INSERT INTO `competence` VALUES ('6', '2', '7', '0');
INSERT INTO `competence` VALUES ('7', '1', '8', '0');
INSERT INTO `competence` VALUES ('9', '1', '10', '0');
INSERT INTO `competence` VALUES ('10', '1', '14', '0');
INSERT INTO `competence` VALUES ('11', '1', '17', '0');
INSERT INTO `competence` VALUES ('12', '1', '18', '0');
INSERT INTO `competence` VALUES ('13', '1', '19', '0');
INSERT INTO `competence` VALUES ('14', '1', '20', '0');

-- ----------------------------
-- Table structure for `courseinfo`
-- ----------------------------
DROP TABLE IF EXISTS `courseinfo`;
CREATE TABLE `courseinfo` (
  `courseId` int(11) NOT NULL AUTO_INCREMENT,
  `courseNo` varchar(64) DEFAULT NULL,
  `courseName` varchar(64) DEFAULT NULL,
  `courseHour` int(11) DEFAULT NULL,
  `describle` varchar(200) DEFAULT NULL,
  `courseType` varchar(64) DEFAULT NULL,
  `courseState` varchar(64) DEFAULT NULL,
  `isDelete` int(11) DEFAULT NULL,
  PRIMARY KEY (`courseId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of courseinfo
-- ----------------------------
INSERT INTO `courseinfo` VALUES ('1', '10000', 'java', '120', 'javaweb开发', 'java', null, '0');
INSERT INTO `courseinfo` VALUES ('2', '10001', '嵌入式', '130', '嵌入式开发', '嵌入式', null, '0');

-- ----------------------------
-- Table structure for `diction`
-- ----------------------------
DROP TABLE IF EXISTS `diction`;
CREATE TABLE `diction` (
  `dictionId` int(11) NOT NULL AUTO_INCREMENT,
  `childId` varchar(64) DEFAULT NULL,
  `fatherId` varchar(64) DEFAULT NULL,
  `dictionName` varchar(64) DEFAULT NULL,
  `describle` varchar(200) DEFAULT NULL,
  `buildTime` datetime DEFAULT NULL,
  `isDelete` int(11) DEFAULT '0',
  PRIMARY KEY (`dictionId`)
) ENGINE=InnoDB AUTO_INCREMENT=165 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of diction
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
INSERT INTO `diction` VALUES ('148', '101801', '101701', '409', null, '2014-11-16 11:49:09', '0');
INSERT INTO `diction` VALUES ('149', '101802', '101701', '410', null, '2014-11-16 11:49:08', '0');
INSERT INTO `diction` VALUES ('150', '101803', '101703', '1535', null, '2014-11-16 11:49:07', '0');
INSERT INTO `diction` VALUES ('151', '101804', '101703', '1537', null, '2014-11-16 11:49:06', '0');
INSERT INTO `diction` VALUES ('152', '101805', '101703', '1542', null, '2014-11-16 11:49:05', '0');
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

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menuId` int(11) NOT NULL AUTO_INCREMENT,
  `menuName` varchar(64) DEFAULT NULL,
  `fatherId` int(64) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `buildTime` datetime DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `isDelete` int(11) DEFAULT NULL,
  PRIMARY KEY (`menuId`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '系统管理', null, null, '2014-11-11 12:48:47', '系统模块', '0');
INSERT INTO `menu` VALUES ('2', '用户管理', '1', 'user.html', '2014-11-11 12:49:43', '对用户的增删改查', '0');
INSERT INTO `menu` VALUES ('3', '菜单管理', '1', 'menu.html', '2014-11-20 18:05:00', '对菜单的增删改查', '0');
INSERT INTO `menu` VALUES ('4', '角色管理', '1', 'role.html', '2014-11-11 12:51:10', '对角色的增删改查', '0');
INSERT INTO `menu` VALUES ('5', '字典管理', '1', 'diction.html', '2014-11-15 15:32:59', '对字典维护', '0');
INSERT INTO `menu` VALUES ('6', '学生管理', null, null, '2014-11-15 15:33:30', '学生模块', '0');
INSERT INTO `menu` VALUES ('7', '档案管理', '6', 'archives.html', '2014-11-15 15:34:30', '档案维护', '0');
INSERT INTO `menu` VALUES ('8', '学生信息管理', '6', 'stuInfo.html', '2014-11-12 15:35:22', '学生信息管理', '0');
INSERT INTO `menu` VALUES ('9', '出勤管理', null, null, '2014-11-15 15:35:41', '出勤模块', '0');
INSERT INTO `menu` VALUES ('10', '出勤统计', '9', 'attendance.html', '2014-11-15 15:39:45', null, '0');
INSERT INTO `menu` VALUES ('11', '课程管理', null, '', '2014-11-21 23:33:09', '课程管理模块', '0');
INSERT INTO `menu` VALUES ('12', '班级管理', null, null, null, '班级管理模块', '0');
INSERT INTO `menu` VALUES ('13', '教师管理', null, null, null, '教师管理模块', '0');
INSERT INTO `menu` VALUES ('14', '排课管理', '11', 'timetable.html', '2014-11-16 13:30:50', '排课主页面', '0');
INSERT INTO `menu` VALUES ('15', '排课管理', '11', 'timetable.html', '2014-11-18 11:22:55', null, '0');
INSERT INTO `menu` VALUES ('17', '基本操作', '12', 'class/welcome.html', '2014-11-20 22:17:52', '班级管理基本操作', '0');
INSERT INTO `menu` VALUES ('18', '教师管理', '13', 'teacher/teacherIndex.html', '2014-11-20 22:33:43', '教师管理基本操作', '0');
INSERT INTO `menu` VALUES ('19', '新建班级', '12', 'class/add.html', '2014-11-20 22:34:52', '新建班级', '0');
INSERT INTO `menu` VALUES ('20', '基础课程管理', '11', 'course.html', '2014-11-21 23:32:19', '基础课程管理模块', '0');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(64) DEFAULT NULL,
  `describe` varchar(200) DEFAULT NULL,
  `isDelete` int(11) DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员', '拥有全部权限', '0');
INSERT INTO `role` VALUES ('2', '系统管理员', '拥有对系统的设置', '0');

-- ----------------------------
-- Table structure for `stuinfo`
-- ----------------------------
DROP TABLE IF EXISTS `stuinfo`;
CREATE TABLE `stuinfo` (
  `stuInfoId` int(11) NOT NULL AUTO_INCREMENT,
  `stuNo` varchar(64) DEFAULT NULL,
  `archives_id` int(11) DEFAULT NULL,
  `classes` int(11) DEFAULT NULL,
  `qqNumber` varchar(64) DEFAULT NULL,
  `mobilePhone` varchar(11) DEFAULT NULL,
  `telephone` varchar(11) DEFAULT NULL,
  `emergencyContact` varchar(64) DEFAULT NULL,
  `emergencyContactPhone` varchar(11) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  `stuState` varchar(64) DEFAULT NULL,
  `isDelete` int(11) DEFAULT NULL,
  PRIMARY KEY (`stuInfoId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stuinfo
-- ----------------------------
INSERT INTO `stuinfo` VALUES ('1', '100001', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0');
INSERT INTO `stuinfo` VALUES ('2', '100002', '2', '2', '2', '2', '2', '2', '2', '2', '2', '0');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teaId` int(11) NOT NULL AUTO_INCREMENT,
  `teaNo` varchar(64) DEFAULT NULL,
  `teaName` varchar(64) DEFAULT NULL,
  `sex` varchar(64) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `specialty` varchar(200) DEFAULT NULL,
  `telephone` varchar(11) DEFAULT NULL,
  `teaLevel` varchar(64) DEFAULT NULL,
  `teaState` varchar(200) DEFAULT NULL,
  `isDelete` int(11) DEFAULT NULL,
  PRIMARY KEY (`teaId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '213019', 'ivan', '男', '1', null, null, null, null, '0');

-- ----------------------------
-- Table structure for `timetable`
-- ----------------------------
DROP TABLE IF EXISTS `timetable`;
CREATE TABLE `timetable` (
  `timeTableId` int(11) NOT NULL AUTO_INCREMENT,
  `classes_id` int(11) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `tea_id` int(11) DEFAULT NULL,
  `campus` varchar(200) DEFAULT NULL,
  `classroom` varchar(64) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `time` varchar(20) DEFAULT NULL,
  `buildTime` datetime DEFAULT NULL,
  `buildUserId` int(11) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `isDelete` int(11) DEFAULT NULL,
  PRIMARY KEY (`timeTableId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of timetable
-- ----------------------------
INSERT INTO `timetable` VALUES ('1', '1', '1', '1', '101701', '101801', '2014-11-18 08:52:06', '101901', '2014-11-18 08:52:16', '1', '2014-11-18 08:52:22', null, '0');
INSERT INTO `timetable` VALUES ('2', '8', null, '1', '101701', '101801', '2014-11-17 00:00:00', '101902', '2014-11-21 22:18:11', '1', null, '', '0');
INSERT INTO `timetable` VALUES ('3', '9', null, '1', '101701', '101801', '2014-11-18 00:00:00', '101902', '2014-11-21 22:56:33', '1', null, '', '0');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(64) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `registerTime` datetime DEFAULT NULL,
  `lastLogTime` datetime DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `isDelete` int(11) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', 'admin', '2014-11-11 19:30:04', '2014-11-21 23:37:17', '1', '0');
INSERT INTO `user` VALUES ('2', 'system1', 'system1', 'system', '2014-11-11 19:40:12', '2014-11-12 15:04:48', '2', '0');
INSERT INTO `user` VALUES ('4', 'system1', 'system', 'system', '2014-11-11 19:40:12', '2014-11-12 15:04:48', '2', '0');
INSERT INTO `user` VALUES ('5', 'system1', 'system', 'system', '2014-11-11 19:40:12', '2014-11-12 15:04:48', '2', '0');
INSERT INTO `user` VALUES ('6', 'system1', 'system', 'system', '2014-11-11 19:40:12', '2014-11-12 15:04:48', '2', '0');
INSERT INTO `user` VALUES ('7', 'system1', 'system', 'system', '2014-11-11 19:40:12', '2014-11-12 15:04:48', '2', '0');
INSERT INTO `user` VALUES ('8', 'system1', 'system', 'system', '2014-11-11 19:40:12', '2014-11-12 15:04:48', '2', '0');
INSERT INTO `user` VALUES ('9', 'system1', 'system', 'system', '2014-11-11 19:40:12', '2014-11-12 15:04:48', '2', '0');
INSERT INTO `user` VALUES ('10', 'system1', 'system', 'system', '2014-11-11 19:40:12', '2014-11-12 15:04:48', '2', '0');
INSERT INTO `user` VALUES ('11', 'system1', 'system', 'system', '2014-11-11 19:40:12', '2014-11-12 15:04:48', '2', '0');
INSERT INTO `user` VALUES ('12', 'system1', 'system', 'system', '2014-11-11 19:40:12', '2014-11-12 15:04:48', '2', '0');
INSERT INTO `user` VALUES ('13', 'system1', 'system', 'system', '2014-11-11 19:40:12', '2014-11-12 15:04:48', '2', '0');
INSERT INTO `user` VALUES ('14', 'system1', 'system', 'system', '2014-11-11 19:40:12', '2014-11-12 15:04:48', '2', '0');
INSERT INTO `user` VALUES ('15', 'system1', 'system', 'system', '2014-11-11 19:40:12', '2014-11-12 15:04:48', '2', '0');
INSERT INTO `user` VALUES ('16', 'system', 'system', 'system', '2014-11-11 19:40:12', '2014-11-15 09:33:14', '2', '0');
