/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 50643
 Source Host           : localhost:3306
 Source Schema         : hotelmanagementsystem

 Target Server Type    : MySQL
 Target Server Version : 50643
 File Encoding         : 65001

 Date: 04/05/2019 20:55:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_bill_info
-- ----------------------------
DROP TABLE IF EXISTS `t_bill_info`;
CREATE TABLE `t_bill_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `bill_num` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '账单编号',
  `guestroom_num` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '客房编号',
  `customer_id` int(11) NOT NULL COMMENT '客户编号，用“,”隔开',
  `checkin_time` datetime(6) NOT NULL COMMENT '入住时间',
  `checkout_time` datetime(6) NOT NULL COMMENT '退房时间',
  `pay_price` decimal(10, 2) NOT NULL COMMENT '付款金额',
  `remanks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `is_pay` bit(1) NOT NULL COMMENT '0代表为未付款，1为以付款',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_checkin_info
-- ----------------------------
DROP TABLE IF EXISTS `t_checkin_info`;
CREATE TABLE `t_checkin_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `guestroom_id` int(11) NULL DEFAULT NULL COMMENT '房间编号',
  `customer_id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '客户编号，可多个逗号隔开“,”',
  `user_id` int(11) NOT NULL COMMENT '处理入住登记操作员编号',
  `checkin_time` datetime(6) NOT NULL COMMENT '入住时间',
  `checkout_time` datetime(6) NOT NULL COMMENT '预订退房时间',
  `bill_num` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '账单编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_customer_info
-- ----------------------------
DROP TABLE IF EXISTS `t_customer_info`;
CREATE TABLE `t_customer_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `customer_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '客户名称',
  `sex` bit(1) NOT NULL COMMENT '客户性别',
  `tele_num` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '联系电话',
  `certificates_num` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '证件号码',
  `creation_time` datetime(0) NOT NULL COMMENT '创建时间',
  `remanks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `first_index`(`customer_name`(191)) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_guestroom_info
-- ----------------------------
DROP TABLE IF EXISTS `t_guestroom_info`;
CREATE TABLE `t_guestroom_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `room_id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '房间编号',
  `room_type_id` int(11) NOT NULL COMMENT '房间类型编号',
  `room_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '客房名称',
  `floor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '楼层',
  `state` int(255) NOT NULL COMMENT '客房状态，0为空闲，1为预订，2为已入住',
  `is_enable` bit(1) NOT NULL COMMENT '是否可使用，0为不可使用，1为可使用',
  `tele_num` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '分机电话',
  `admin_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '负责人',
  `remanks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `date` date NOT NULL COMMENT '日期，为未来三天的日期',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `guestroomIndex`(`room_id`, `date`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 149 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_reservation_info
-- ----------------------------
DROP TABLE IF EXISTS `t_reservation_info`;
CREATE TABLE `t_reservation_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `guestroom_id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '客房信息编号,用逗号隔开',
  `reservation_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '预订人名称',
  `tele_num` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '联系电话',
  `checkin_time` date NOT NULL COMMENT '预计入住时间',
  `checkout_time` date NOT NULL COMMENT '预计退房时间',
  `remanks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `guestroom_type_id` int(11) NOT NULL COMMENT '客房类型编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_room_type
-- ----------------------------
DROP TABLE IF EXISTS `t_room_type`;
CREATE TABLE `t_room_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `room_type_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '客房类型名称',
  `price` decimal(10, 2) NOT NULL COMMENT '价钱',
  `discount` int(11) NOT NULL COMMENT '折扣，百分比表示',
  `is_window` bit(1) NOT NULL COMMENT '是否有窗，0为没有，1为有',
  `remanks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_user_info
-- ----------------------------
DROP TABLE IF EXISTS `t_user_info`;
CREATE TABLE `t_user_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `account` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '密码',
  `job_num` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '工号',
  `is_admin` bit(1) NOT NULL COMMENT '是否为管理员，1为管理员，0为操作员',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '姓名',
  `sex` bit(1) NULL DEFAULT NULL COMMENT '性别，1为男，0为女',
  `tele_num` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '联系电话',
  `is_enable` bit(1) NOT NULL COMMENT '是否可用',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`, `account`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
