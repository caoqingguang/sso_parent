/*

MySQL Data Transfer

Source Host: localhost

Source Database: sso

Target Host: localhost

Target Database: sso

Date: 2015/12/9 23:31:35

*/



SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------

-- Table structure for sys

-- ----------------------------

DROP TABLE IF EXISTS `sys`;

CREATE TABLE `sys` (
  `id` bigint(20) NOT NULL DEFAULT '0' COMMENT 'id',
  `sysName` varchar(100) NOT NULL DEFAULT '' COMMENT '系统名称',
  `indexStr` varchar(50) NOT NULL DEFAULT '' COMMENT '索引id',
  `defUrl` varchar(100) NOT NULL DEFAULT '' COMMENT '默认主页',
  `sysLev` int(11) NOT NULL DEFAULT '0' COMMENT '系统等级',
  `sysType` int(11) NOT NULL COMMENT '系统类型 1admin 2other',
  `crTime` date NOT NULL DEFAULT '0000-00-00' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------

-- Table structure for sys_role

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

-- Table structure for sys_role_url

-- ----------------------------

DROP TABLE IF EXISTS `sys_role_url`;

CREATE TABLE `sys_role_url` (
  `id` bigint(20) NOT NULL,
  `roleId` bigint(20) NOT NULL,
  `urlId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------

-- Table structure for sys_url

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

-- Table structure for user

-- ----------------------------

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `enName` varchar(20) NOT NULL,
  `chName` varchar(20) NOT NULL,
  `email` varchar(40) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `crTime` date NOT NULL,
  `deleted` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------

-- Table structure for user_sys_role

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

-- Records 

-- ----------------------------

INSERT INTO `sys` VALUES ('1', 'adminsso', 'SSO', 'http://sso.vko.cn', '1', '1', '0000-00-00');

INSERT INTO `sys` VALUES ('2', 'cms', 'CMS', 'http://cms.vko.cn', '2', '2', '0000-00-00');

INSERT INTO `sys` VALUES ('3', 'video', 'VIDEO', 'http://video.vko.cn', '3', '2', '0000-00-00');

