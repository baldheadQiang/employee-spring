/*
Navicat MySQL Data Transfer

Source Server         : zhangsan
Source Server Version : 80026
Source Host           : localhost:3306
Source Database       : employee_manager

Target Server Type    : MYSQL
Target Server Version : 80026
File Encoding         : 65001

Date: 2022-07-01 16:52:04

create database employee_manager DEFAULT CHARSET=utf8mb4 -- UTF-8 Unicode COLLATE utf8mb4_0900_ai_ci ;

use employee_manager;

*/
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `username` varchar(32) NOT NULL,
  `password` varchar(64) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `sex` int NOT NULL,
  `id_number` varchar(18) NOT NULL,
  `status` int NOT NULL DEFAULT '1',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `create_user` bigint NOT NULL,
  `update_user` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Unique` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1542737154308366339 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1542417650076438529', '张三', '葫芦侠', 'e10adc3949ba59abbe56e057f20f883e', '18033654895', '1', '622923200112314596', '1', '2022-06-30 15:59:59', '2022-06-30 15:59:59', '1', '1');

