# MySQL-Front 5.1  (Build 4.2)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: localhost    Database: edums
# ------------------------------------------------------
# Server version 5.1.36-community-log

DROP DATABASE IF EXISTS `edums`;
CREATE DATABASE `edums` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `edums`;

#
# Source for table tb_info
#

DROP TABLE IF EXISTS `tb_info`;
CREATE TABLE `tb_info` (
  `info_id` int(10) NOT NULL AUTO_INCREMENT,
  `info1` varchar(100) DEFAULT NULL,
  `info2` varchar(100) DEFAULT NULL,
  `info3` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`info_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

#
# Dumping data for table tb_info
#

LOCK TABLES `tb_info` WRITE;
/*!40000 ALTER TABLE `tb_info` DISABLE KEYS */;
INSERT INTO `tb_info` VALUES (1,'a1','a2','a3');
INSERT INTO `tb_info` VALUES (2,'b1','b2','b3');
INSERT INTO `tb_info` VALUES (3,'c1','c2','c3');
INSERT INTO `tb_info` VALUES (4,'d1','d2','d3');
INSERT INTO `tb_info` VALUES (5,'e1','e2','e3');
INSERT INTO `tb_info` VALUES (6,'f1','f2','f3');
INSERT INTO `tb_info` VALUES (7,'g1','g2','g3');
INSERT INTO `tb_info` VALUES (8,'h1','h2','h3');
INSERT INTO `tb_info` VALUES (9,'i1','i2','i3');
INSERT INTO `tb_info` VALUES (10,'j1','j2','j3');
INSERT INTO `tb_info` VALUES (11,'k1','k2','k3');
INSERT INTO `tb_info` VALUES (12,'l1','l2','l3');
INSERT INTO `tb_info` VALUES (13,'m1','m2','m3');
INSERT INTO `tb_info` VALUES (14,'n1','n2','n3');
INSERT INTO `tb_info` VALUES (15,'o1','o2','o3');
INSERT INTO `tb_info` VALUES (16,'p1','p2','p3');
INSERT INTO `tb_info` VALUES (17,'q1','q2','q3');
INSERT INTO `tb_info` VALUES (18,'r1','r2','r3');
INSERT INTO `tb_info` VALUES (19,'s1','s2','s3');
INSERT INTO `tb_info` VALUES (20,'t1','t2','t3');
INSERT INTO `tb_info` VALUES (21,'u1','u2','u3');
INSERT INTO `tb_info` VALUES (22,'v1','v2','v3');
INSERT INTO `tb_info` VALUES (23,'w1','w2','w3');
INSERT INTO `tb_info` VALUES (24,'x1','x2','x3');
INSERT INTO `tb_info` VALUES (25,'y1','y2','y3');
INSERT INTO `tb_info` VALUES (26,'z1','z2','z3');
/*!40000 ALTER TABLE `tb_info` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table tb_menu
#

DROP TABLE IF EXISTS `tb_menu`;
CREATE TABLE `tb_menu` (
  `menu_id` int(10) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(20) DEFAULT NULL,
  `menu_url` varchar(100) DEFAULT NULL,
  `parent_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

#
# Dumping data for table tb_menu
#

LOCK TABLES `tb_menu` WRITE;
/*!40000 ALTER TABLE `tb_menu` DISABLE KEYS */;
INSERT INTO `tb_menu` VALUES (1,'系统管理','',NULL);
INSERT INTO `tb_menu` VALUES (2,'业务管理','',NULL);
INSERT INTO `tb_menu` VALUES (3,'XX管理','',NULL);
INSERT INTO `tb_menu` VALUES (5,'用户管理','user.html',1);
INSERT INTO `tb_menu` VALUES (6,'角色管理','role.html',1);
INSERT INTO `tb_menu` VALUES (7,'菜单管理','menu.html',1);
INSERT INTO `tb_menu` VALUES (8,'分页','info.html',2);
INSERT INTO `tb_menu` VALUES (9,'bbb','',2);
INSERT INTO `tb_menu` VALUES (10,'分页测试','info.html',3);
INSERT INTO `tb_menu` VALUES (11,'dfsdf','',3);
INSERT INTO `tb_menu` VALUES (12,'e','',3);
INSERT INTO `tb_menu` VALUES (15,'ccc','',2);
INSERT INTO `tb_menu` VALUES (16,'YY管理','',NULL);
INSERT INTO `tb_menu` VALUES (17,'11111','',16);
INSERT INTO `tb_menu` VALUES (18,'22222','',16);
INSERT INTO `tb_menu` VALUES (19,'33333','',16);
INSERT INTO `tb_menu` VALUES (20,'44444','',16);
/*!40000 ALTER TABLE `tb_menu` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table tb_role
#

DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `role_id` int(10) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) DEFAULT NULL,
  `rights` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Dumping data for table tb_role
#

LOCK TABLES `tb_role` WRITE;
/*!40000 ALTER TABLE `tb_role` DISABLE KEYS */;
INSERT INTO `tb_role` VALUES (1,'系统管理员','35822');
INSERT INTO `tb_role` VALUES (2,'普通用户','2038792');
INSERT INTO `tb_role` VALUES (3,'系统用户','230374');
/*!40000 ALTER TABLE `tb_role` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table tb_user
#

DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `rights` varchar(100) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `role_id` int(10) DEFAULT NULL,
  `last_login` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

#
# Dumping data for table tb_user
#

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES (1,'admin','admin','管理员','38894',0,1,'2011-07-05 10:35:35');
INSERT INTO `tb_user` VALUES (2,'user1','111111','用户A1a','40716',0,2,NULL);
INSERT INTO `tb_user` VALUES (3,'user2','111111','用户B',NULL,0,NULL,'2011-06-13 15:39:08');
INSERT INTO `tb_user` VALUES (4,'user3','111111','用户3',NULL,0,NULL,'2011-06-13 15:35:42');
INSERT INTO `tb_user` VALUES (5,'aaa','1111','aaa',NULL,0,NULL,NULL);
INSERT INTO `tb_user` VALUES (6,'bbb','111111','dsfdsf2',NULL,0,2,NULL);
INSERT INTO `tb_user` VALUES (7,'fffff','1','ddds',NULL,0,NULL,NULL);
INSERT INTO `tb_user` VALUES (10,'abc','111111','dsfdsf2x',NULL,0,NULL,NULL);
INSERT INTO `tb_user` VALUES (11,'user4','111111','afdsf',NULL,0,1,NULL);
INSERT INTO `tb_user` VALUES (12,'test1','111111','aaa',NULL,0,NULL,NULL);
INSERT INTO `tb_user` VALUES (13,'test2','222222','222',NULL,0,NULL,NULL);
INSERT INTO `tb_user` VALUES (14,'tes3','333333','333',NULL,0,NULL,NULL);
INSERT INTO `tb_user` VALUES (15,'test4','222222','somebody',NULL,0,NULL,NULL);
INSERT INTO `tb_user` VALUES (16,'test5','111111','dsfdsf',NULL,0,NULL,NULL);
INSERT INTO `tb_user` VALUES (17,'test6','111111','1',NULL,0,NULL,NULL);
INSERT INTO `tb_user` VALUES (18,'test7','111111','dsfdsf',NULL,0,NULL,NULL);
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
