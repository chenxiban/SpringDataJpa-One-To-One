/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.1.73-community : Database - springbootjpamanytomany
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`springbootjpamanytomany` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `springbootjpamanytomany`;

/*Table structure for table `cattb` */

DROP TABLE IF EXISTS `cattb`;

CREATE TABLE `cattb` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:猫自动增长主键',
  `age` int(10) unsigned DEFAULT '0' COMMENT '备注:猫年龄',
  `birthday` datetime DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL COMMENT '备注:猫姓名',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `cattb` */

insert  into `cattb`(`id`,`age`,`birthday`,`name`,`sex`,`update_time`) values (1,18,'2017-11-15 09:58:33','张三','男','2017-11-15 09:58:33'),(2,20,'2017-11-15 09:58:33','李四','女','2017-11-15 09:58:55'),(3,16,'2017-11-15 09:58:33','王武','男','2017-11-15 09:59:26'),(4,100,'2017-11-15 09:58:33','赵六','女','2017-11-15 09:59:43'),(5,99,'2017-11-15 09:58:33','田七','女','2017-11-15 10:00:17'),(6,25,'2017-11-15 09:58:33','Tom','男','2017-11-15 10:20:06');

/*Table structure for table `clazztb` */

DROP TABLE IF EXISTS `clazztb`;

CREATE TABLE `clazztb` (
  `clazz_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:班级自动增长主键',
  `clazz_name` varchar(10) DEFAULT NULL,
  `clazz_number` int(10) unsigned DEFAULT '0' COMMENT '备注:班级总人数',
  PRIMARY KEY (`clazz_id`),
  UNIQUE KEY `UK_c8epkpb9w48re4txbfe6o0wbl` (`clazz_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `clazztb` */

insert  into `clazztb`(`clazz_id`,`clazz_name`,`clazz_number`) values (1,'1501',10),(2,'1502',20),(3,'1503',30),(4,'1504',40),(5,'1505',50);

/*Table structure for table `roletb` */

DROP TABLE IF EXISTS `roletb`;

CREATE TABLE `roletb` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_pay` int(11) NOT NULL,
  `role_post` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `roletb` */

insert  into `roletb`(`role_id`,`role_pay`,`role_post`) values (1,1000000000,'管理员'),(2,10000000,'副总'),(3,100,'财务'),(4,500,'人事专员');

/*Table structure for table `studenttb` */

DROP TABLE IF EXISTS `studenttb`;

CREATE TABLE `studenttb` (
  `student_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:学生自动增长主键',
  `student_age` int(10) unsigned DEFAULT '0' COMMENT '备注:学生年龄',
  `student_birthday` datetime DEFAULT NULL,
  `student_name` varchar(20) DEFAULT NULL,
  `student_sex` char(1) DEFAULT NULL COMMENT '备注:学生姓名',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `student_clazz_id` int(10) unsigned NOT NULL COMMENT '备注:班级自动增长主键',
  PRIMARY KEY (`student_id`),
  KEY `FK5b7xcolb8db97ru3s6l1o584y` (`student_clazz_id`),
  CONSTRAINT `FK5b7xcolb8db97ru3s6l1o584y` FOREIGN KEY (`student_clazz_id`) REFERENCES `clazztb` (`clazz_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `studenttb` */

insert  into `studenttb`(`student_id`,`student_age`,`student_birthday`,`student_name`,`student_sex`,`update_time`,`student_clazz_id`) values (1,18,'2017-11-15 09:58:33','张三','男','2017-11-15 12:37:25',1),(2,20,'2017-11-15 09:58:33','李四','女','2017-11-15 12:37:51',1),(3,25,'2017-11-15 09:58:33','王武','男','2017-11-15 12:38:17',3);

/*Table structure for table `user_role_tb` */

DROP TABLE IF EXISTS `user_role_tb`;

CREATE TABLE `user_role_tb` (
  `user_role_tb_role_id` bigint(20) NOT NULL,
  `user_role_tb_user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_role_tb_user_id`,`user_role_tb_role_id`),
  KEY `FKjl70nqo3ej72spynxjhavbau1` (`user_role_tb_role_id`),
  CONSTRAINT `FKjl70nqo3ej72spynxjhavbau1` FOREIGN KEY (`user_role_tb_role_id`) REFERENCES `roletb` (`role_id`),
  CONSTRAINT `FKgfviiaquy1uoew036o4lmdi1c` FOREIGN KEY (`user_role_tb_user_id`) REFERENCES `usertb` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_role_tb` */

insert  into `user_role_tb`(`user_role_tb_role_id`,`user_role_tb_user_id`) values (1,1),(1,2),(1,4),(4,1),(4,4);

/*Table structure for table `usertb` */

DROP TABLE IF EXISTS `usertb`;

CREATE TABLE `usertb` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `user_sex` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `usertb` */

insert  into `usertb`(`user_id`,`user_name`,`user_sex`) values (1,'张三','男'),(2,'李四','女'),(3,'王武','男'),(4,'田七','女'),(5,'赵六','男');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
