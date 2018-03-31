/*
Navicat MySQL Data Transfer

Source Server         : mysql_local
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : dms

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2018-04-01 00:03:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '123', '123', '111', '111');

-- ----------------------------
-- Table structure for dorm
-- ----------------------------
DROP TABLE IF EXISTS `dorm`;
CREATE TABLE `dorm` (
  `dorm_id` int(11) NOT NULL AUTO_INCREMENT,
  `dorm_num` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL COMMENT '宿舍类型：如是男生宿舍还是女生宿舍或者本科宿舍 研究生宿舍',
  `capacity` varchar(255) DEFAULT NULL COMMENT '宿舍容纳人数',
  `telephone` varchar(255) DEFAULT NULL,
  `head_id` int(11) DEFAULT NULL COMMENT '宿舍长的学生id',
  `create_time` varchar(255) DEFAULT NULL COMMENT '宿舍创建时间',
  `score` varchar(255) DEFAULT NULL COMMENT '宿舍评分',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dorm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dorm
-- ----------------------------
INSERT INTO `dorm` VALUES ('1', '613', '男生宿舍', '4', '123456', '12', '02/19/2018', '100', '好评宿舍');
INSERT INTO `dorm` VALUES ('2', '614', '男生宿舍', '4', '123456', null, '01/25/2018', '59', '差评宿舍');
INSERT INTO `dorm` VALUES ('3', '1', '男生宿舍', '1', '1', null, '02/19/2018', '1', '1');
INSERT INTO `dorm` VALUES ('4', '615', '男生宿舍', '1', '1', null, '03/14/2018', '1', '1');
INSERT INTO `dorm` VALUES ('7', '618', '男生宿舍', '', '', null, '', '', '');

-- ----------------------------
-- Table structure for dorm_manager
-- ----------------------------
DROP TABLE IF EXISTS `dorm_manager`;
CREATE TABLE `dorm_manager` (
  `dm_id` int(11) NOT NULL AUTO_INCREMENT,
  `dm_num` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `birth_date` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dorm_manager
-- ----------------------------
INSERT INTO `dorm_manager` VALUES ('1', '1', '1', '1', '1', '女', '1', '1');
INSERT INTO `dorm_manager` VALUES ('3', '1111', '11111', '小明', '小明', '女', '小明', '小明');
INSERT INTO `dorm_manager` VALUES ('4', '123', '123', '', '', '男', '', '');

-- ----------------------------
-- Table structure for dorm_student
-- ----------------------------
DROP TABLE IF EXISTS `dorm_student`;
CREATE TABLE `dorm_student` (
  `ds_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `dorm_id` int(11) DEFAULT NULL,
  `join_time` varchar(255) DEFAULT NULL COMMENT '学生初次入住宿舍报道时间',
  `leave_time` varchar(255) DEFAULT NULL,
  `leave_reason` varchar(255) DEFAULT NULL COMMENT '离开时间：如毕业 退学 出国 辍学 等',
  `create_time` varchar(255) DEFAULT NULL COMMENT '学生分配宿舍关系创建时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ds_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dorm_student
-- ----------------------------
INSERT INTO `dorm_student` VALUES ('6', '11', '1', '1', null, null, null, '1');
INSERT INTO `dorm_student` VALUES ('7', '12', '1', '02/28/2018', null, null, null, '11');
INSERT INTO `dorm_student` VALUES ('8', '10', '1', '03/06/2018', null, null, null, '141');
INSERT INTO `dorm_student` VALUES ('9', '13', '1', '03/06/2018', null, null, null, '1');
INSERT INTO `dorm_student` VALUES ('10', '14', '2', '04/25/2018', null, null, null, '77');

-- ----------------------------
-- Table structure for fee
-- ----------------------------
DROP TABLE IF EXISTS `fee`;
CREATE TABLE `fee` (
  `f_id` int(11) NOT NULL AUTO_INCREMENT,
  `dorm_num` varchar(255) DEFAULT NULL,
  `electricity_fee` varchar(255) DEFAULT NULL,
  `water_fee` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `pay_time` varchar(255) DEFAULT NULL,
  `end_time` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fee
-- ----------------------------
INSERT INTO `fee` VALUES ('1', '613', '1', '1', null, '03/07/2018', '02/27/2018', '已缴费', '1');
INSERT INTO `fee` VALUES ('4', '613', '111', '1111', null, '', '', '未缴费', '');
INSERT INTO `fee` VALUES ('5', '613', '11', '111', '03/31/2018', '', '', '未缴费', '11');
INSERT INTO `fee` VALUES ('6', '613', '11', '11', '03/31/2018', '', '', '未缴费', '');
INSERT INTO `fee` VALUES ('7', '613', '111', '111', '03/31/2018', '', '', '未缴费', '1111');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_num` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `birth_date` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL COMMENT '学生状态 如 注册中 已注册 入读',
  `location` varchar(255) DEFAULT NULL COMMENT '家庭住址',
  `phone` varchar(255) DEFAULT NULL,
  `student_class` varchar(255) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL,
  `getup_time` varchar(255) DEFAULT NULL,
  `sleep_time` varchar(255) DEFAULT NULL,
  `hobby` varchar(255) DEFAULT NULL,
  `habit` varchar(255) DEFAULT NULL,
  `emergency_contact` varchar(255) DEFAULT NULL COMMENT '紧急联系人',
  `emergency_phone` varchar(255) DEFAULT NULL COMMENT '紧急联系人电话',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '1405551201', '12345678', 'WayLeung', '1994-11-13', '男', '注册', '肇庆', '15521608979', '外包142班', '计算机科学与技术', '09:00', '00:30', '电影、音乐', '运动', 'WayLeung', '15521608979', '优秀学生');
INSERT INTO `student` VALUES ('10', '888', '888', '88', '88', '男', '8', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `student` VALUES ('11', '1', '1', '1', '1', '男', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `student` VALUES ('12', '123', '123', '', '', '男', '', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `student` VALUES ('13', '222', '', '', '', '男', '', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `student` VALUES ('14', '77', '77', '', '', '男', '', '', '', '', '', '', '', '', '', '', '', '');
