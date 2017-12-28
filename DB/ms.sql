/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50634
Source Host           : localhost:3306
Source Database       : ms

Target Server Type    : MYSQL
Target Server Version : 50634
File Encoding         : 65001

Date: 2017-12-29 00:03:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` varchar(20) DEFAULT '20140000',
  `name` varchar(50) DEFAULT '张三',
  `s_class` varchar(30) DEFAULT '软件工程',
  `sex` varchar(4) DEFAULT '男',
  `age` varchar(11) DEFAULT '18'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('20140000', '张三', '软件工程', '男', '18');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `name` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('admin', 'admin');
