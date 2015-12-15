/*
Navicat MySQL Data Transfer

Source Server         : my
Source Server Version : 50509
Source Host           : 127.0.0.1:3306
Source Database       : sso

Target Server Type    : MYSQL
Target Server Version : 50509
File Encoding         : 65001

Date: 2015-12-15 20:38:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys`
-- ----------------------------
DROP TABLE IF EXISTS `sys`;
CREATE TABLE `sys` (
  `id` bigint(20) NOT NULL DEFAULT '0' COMMENT 'id',
  `sysName` varchar(100) NOT NULL DEFAULT '' COMMENT '系统名称',
  `sysChName` varchar(100) NOT NULL DEFAULT '' COMMENT '系统中文名',
  `indexStr` varchar(50) NOT NULL DEFAULT '' COMMENT '索引id',
  `defUrl` varchar(100) NOT NULL DEFAULT '' COMMENT '默认主页',
  `sysLev` int(11) NOT NULL DEFAULT '0' COMMENT '系统等级',
  `sysType` int(11) NOT NULL COMMENT '系统类型 1admin 2other',
  `crTime` date NOT NULL DEFAULT '0000-00-00' COMMENT '创建时间',
  `regPw` varchar(50) NOT NULL DEFAULT '' COMMENT '自动注册url时密码',
  `regPrefix` varchar(100) NOT NULL DEFAULT 'http://www.***.cn' COMMENT '自动追加前缀',
  `regNullUrl` varchar(100) NOT NULL DEFAULT 'javascript:void(0);' COMMENT '注册空url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys
-- ----------------------------
INSERT INTO `sys` VALUES ('1', 'adminsso', '权限管理', 'SSO', 'http://sso.vko.cn', '1', '1', '0000-00-00', '123456', 'http://', 'javascript:void(0);');
INSERT INTO `sys` VALUES ('2', 'cms', '内容系统', 'CMS', 'http://cms.vko.cn', '2', '2', '0000-00-00', '123456', 'http://', 'javascript:void(0);');
INSERT INTO `sys` VALUES ('3', 'video', '视频系统', 'VIDEO', 'http://video.vko.cn', '3', '2', '0000-00-00', '123456', 'http://', 'javascript:void(0);');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL,
  `roleName` varchar(50) NOT NULL,
  `roleType` int(11) NOT NULL DEFAULT '2' COMMENT '角色类型  (0 superAdmin 1 admin  2 other )',
  `roleDefUrl` varchar(100) NOT NULL,
  `sysId` bigint(20) NOT NULL,
  `sysName` varchar(50) NOT NULL,
  `sn` int(11) NOT NULL,
  `crTime` date NOT NULL DEFAULT '0000-00-00',
  `deleted` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_role_url`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_url`;
CREATE TABLE `sys_role_url` (
  `id` bigint(20) NOT NULL,
  `roleId` bigint(20) NOT NULL,
  `urlId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_url
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_url`
-- ----------------------------
DROP TABLE IF EXISTS `sys_url`;
CREATE TABLE `sys_url` (
  `id` bigint(20) NOT NULL,
  `urlName` varchar(50) NOT NULL,
  `indexStr` varchar(50) NOT NULL,
  `url` varchar(100) NOT NULL,
  `urlLev` int(11) NOT NULL,
  `pid` bigint(20) NOT NULL,
  `pids` varchar(100) NOT NULL,
  `pidsStr` varchar(200) NOT NULL,
  `sysId` bigint(20) NOT NULL,
  `sn` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_url
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `userName` varchar(20) NOT NULL DEFAULT '',
  `passWord` varchar(50) NOT NULL DEFAULT '',
  `token` varchar(50) NOT NULL DEFAULT '',
  `info` varchar(100) NOT NULL DEFAULT '' COMMENT '用户备注信息',
  `resetHint` varchar(50) NOT NULL DEFAULT '' COMMENT '重置pw 提示',
  `resetPw` varchar(50) NOT NULL DEFAULT '' COMMENT '重置pw 口令',
  `email` varchar(50) NOT NULL DEFAULT '' COMMENT '邮箱',
  `phone` varchar(20) NOT NULL DEFAULT '' COMMENT '手机',
  `crTime` date NOT NULL DEFAULT '0000-00-00' COMMENT '创建时间',
  `deleted` int(11) NOT NULL DEFAULT '2' COMMENT '删除状态 1 是 2 否 3 禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'user1', '', '', '', '', '', '', '', '0000-00-00', '2');
INSERT INTO `user` VALUES ('2', 'user2', '', '', '', '', '', '', '', '0000-00-00', '2');
INSERT INTO `user` VALUES ('3', 'user3', '', '', '', '', '', '', '', '0000-00-00', '2');
INSERT INTO `user` VALUES ('4', 'user4', '', '', '', '', '', '', '', '0000-00-00', '2');
INSERT INTO `user` VALUES ('5', 'user5', '', '', '', '', '', '', '', '0000-00-00', '2');
INSERT INTO `user` VALUES ('6', 'user6', '', '', '', '', '', '', '', '0000-00-00', '2');
INSERT INTO `user` VALUES ('7', 'user7', '', '', '', '', '', '', '', '0000-00-00', '2');
INSERT INTO `user` VALUES ('8', 'user8', '', '', '', '', '', '', '', '0000-00-00', '2');
INSERT INTO `user` VALUES ('9', 'user9', '', '', '', '', '', '', '', '0000-00-00', '2');
INSERT INTO `user` VALUES ('10', 'user10', '', '', '', '', '', '', '', '0000-00-00', '2');
INSERT INTO `user` VALUES ('11', 'user11', '', '', '', '', '', '', '', '0000-00-00', '2');
INSERT INTO `user` VALUES ('12', 'user12', '', '', '', '', '', '', '', '0000-00-00', '2');
INSERT INTO `user` VALUES ('13', 'user13', '', '', '', '', '', '', '', '0000-00-00', '2');
INSERT INTO `user` VALUES ('14', 'user14', '', '', '', '', '', '', '', '0000-00-00', '2');
INSERT INTO `user` VALUES ('15', 'user15', '', '', '', '', '', '', '', '0000-00-00', '2');
INSERT INTO `user` VALUES ('16', 'user16', '', '', '', '', '', '', '', '0000-00-00', '2');
INSERT INTO `user` VALUES ('17', 'user17', '', '', '', '', '', '', '', '0000-00-00', '2');
INSERT INTO `user` VALUES ('18', 'user18', '', '', '', '', '', '', '', '0000-00-00', '2');
INSERT INTO `user` VALUES ('19', 'user19', '', '', '', '', '', '', '', '0000-00-00', '2');
INSERT INTO `user` VALUES ('20', 'user20', '', '', '', '', '', '', '', '0000-00-00', '2');
INSERT INTO `user` VALUES ('21', 'user21', '', '', '', '', '', '', '', '0000-00-00', '2');
INSERT INTO `user` VALUES ('22', 'user22', '', '', '', '', '', '', '', '0000-00-00', '2');
INSERT INTO `user` VALUES ('23', 'user23', '', '', '', '', '', '', '', '0000-00-00', '2');
INSERT INTO `user` VALUES ('24', 'user24', '', '', '', '', '', '', '', '0000-00-00', '2');
INSERT INTO `user` VALUES ('1001', 'zs', '', '', '', '', '', 'qingguang686@163.com', '', '0000-00-00', '2');
INSERT INTO `user` VALUES ('1011', '张三', '', '', '', '', '', '', '', '2015-12-15', '2');
INSERT INTO `user` VALUES ('1012', '张三2', '', '', '', '', '', 'zhangsan@vko.cn', '12312312344', '2015-12-15', '2');
INSERT INTO `user` VALUES ('1013', '张三222', '123456', '', '', '', '', '', '', '2015-12-15', '2');
INSERT INTO `user` VALUES ('1021', '曹庆光', '123456', '', '', '', '', 'qingguang686@163.com', '15127199399', '2015-12-15', '2');

-- ----------------------------
-- Table structure for `user_sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_sys_role`;
CREATE TABLE `user_sys_role` (
  `id` bigint(20) NOT NULL,
  `roleId` bigint(20) NOT NULL,
  `roleName` varchar(50) NOT NULL,
  `roleType` int(11) NOT NULL,
  `sysId` bigint(20) NOT NULL,
  `sysLev` int(11) NOT NULL,
  `defUrl` varchar(100) NOT NULL,
  `userId` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_sys_role
-- ----------------------------
