/*
SQLyog v10.2 
MySQL - 5.5.37 : Database - classmanagement
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`classmanagement` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `classmanagement`;

/*Table structure for table `class` */

DROP TABLE IF EXISTS `class`;

CREATE TABLE `class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classname` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `class` */

insert  into `class`(`id`,`classname`) values (1,'A96'),(2,'A97');

/*Table structure for table `jurisdiction` */

DROP TABLE IF EXISTS `jurisdiction`;

CREATE TABLE `jurisdiction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `button` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `qname` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `parentid` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `url` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `js` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `isdelete` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `jurisdiction` */

insert  into `jurisdiction`(`id`,`button`,`qname`,`parentid`,`type`,`url`,`js`,`isdelete`) values (1,NULL,'日常管理',0,1,NULL,NULL,0),(2,NULL,'班级管理',8,2,NULL,NULL,0),(3,NULL,'个人信息',8,2,NULL,NULL,0),(4,NULL,'添加班级',2,3,NULL,NULL,0),(5,NULL,'删除班级',2,3,NULL,NULL,0),(6,NULL,'修改班级',2,3,NULL,NULL,0),(7,NULL,'修改信息',3,3,NULL,NULL,0),(8,NULL,'基础管理',0,1,NULL,NULL,0),(9,NULL,'立即签到',1,2,NULL,NULL,0),(10,NULL,'系统权限',0,1,NULL,NULL,0),(11,NULL,'班级权限',10,2,NULL,NULL,0),(12,NULL,'用户权限',10,2,NULL,NULL,0);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `role` */

insert  into `role`(`id`,`role`) values (1,'老师'),(2,'班长'),(3,'学生');

/*Table structure for table `sign` */

DROP TABLE IF EXISTS `sign`;

CREATE TABLE `sign` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `time` datetime NOT NULL,
  `classid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `sign` */

insert  into `sign`(`id`,`userid`,`time`,`classid`) values (1,1,'2021-04-27 18:37:22',NULL),(2,2,'2021-04-27 18:37:38',NULL),(3,3,'2021-04-27 18:37:46',NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `sex` int(11) NOT NULL,
  `roleid` int(11) NOT NULL,
  `address` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `classid` int(11) DEFAULT NULL,
  `pwd` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '123',
  `userCode` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`sex`,`roleid`,`address`,`classid`,`pwd`,`userCode`,`phone`,`email`) values (1,'张三',1,1,NULL,NULL,'123','zs',NULL,NULL),(2,'李四',0,2,NULL,NULL,'123','lisi',NULL,NULL),(3,'王五',1,3,NULL,NULL,'123','wang',NULL,NULL);

/*Table structure for table `user_menu` */

DROP TABLE IF EXISTS `user_menu`;

CREATE TABLE `user_menu` (
  `userid` int(11) NOT NULL,
  `menuid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user_menu` */

insert  into `user_menu`(`userid`,`menuid`) values (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
