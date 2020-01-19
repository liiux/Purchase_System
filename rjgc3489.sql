/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : rjgc3489

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2019-12-09 21:28:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for authority
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `authority_name` varchar(40) DEFAULT NULL COMMENT '权限名',
  `authority_url` varchar(255) DEFAULT NULL COMMENT '权限地址',
  `parent` bigint(20) DEFAULT NULL COMMENT '权限父级 记住上级的主键 0为一级节点',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of authority
-- ----------------------------
INSERT INTO `authority` VALUES ('1', '计划员管理', '#', '0');
INSERT INTO `authority` VALUES ('2', '采购员管理', '#', '0');
INSERT INTO `authority` VALUES ('3', '采购主管', '#', '0');
INSERT INTO `authority` VALUES ('4', '接收员管理', '#', '0');
INSERT INTO `authority` VALUES ('6', '制定采购计划', '/addPlan_first.do', '1');
INSERT INTO `authority` VALUES ('7', '我的采购计划', '/getPlanInfo.do', '1');
INSERT INTO `authority` VALUES ('8', '制定采购订单', '/buyPlanInfo.do', '2');
INSERT INTO `authority` VALUES ('9', '我的采购订单', '/getMyBuyPlanInfo.do', '2');
INSERT INTO `authority` VALUES ('10', '审核采购计划', '/checkPlanInfo.do', '3');
INSERT INTO `authority` VALUES ('11', '审核采购订单', '/checkBuyPlanInfo.do', '3');
INSERT INTO `authority` VALUES ('12', '接收货物', '/receiveInfo.do', '4');
INSERT INTO `authority` VALUES ('13', '查看供应商', '/getSupplierInfo.do', '15');
INSERT INTO `authority` VALUES ('15', '供应商管理', '#', '0');
INSERT INTO `authority` VALUES ('16', '添加供应商', '/addSupplierInfo_main.do', '15');

-- ----------------------------
-- Table structure for food
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(40) DEFAULT NULL,
  `num` bigint(20) DEFAULT NULL,
  `price` float(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of food
-- ----------------------------
INSERT INTO `food` VALUES ('1', '香蕉', '20', '120.00');
INSERT INTO `food` VALUES ('2', '鸡蛋', '20', '100.00');
INSERT INTO `food` VALUES ('3', '食盐', '20', '100.00');
INSERT INTO `food` VALUES ('4', '大米', '100', '10.00');
INSERT INTO `food` VALUES ('5', '大米', '100', '1000.00');
INSERT INTO `food` VALUES ('6', '牛奶', '10', '100.00');
INSERT INTO `food` VALUES ('7', '味精', '20', '100.00');
INSERT INTO `food` VALUES ('8', '雪莲果', '10', '100.00');
INSERT INTO `food` VALUES ('9', '香蕉', '10', '20.00');
INSERT INTO `food` VALUES ('10', '水蜜桃', '10', '120.00');
INSERT INTO `food` VALUES ('11', '白砂糖', '10', '100.00');
INSERT INTO `food` VALUES ('12', '西瓜', '10', '120.00');
INSERT INTO `food` VALUES ('13', '牛奶', '10', '100.00');
INSERT INTO `food` VALUES ('14', '香蕉', '10', '101.00');
INSERT INTO `food` VALUES ('15', '白砂糖', '10', '120.00');
INSERT INTO `food` VALUES ('16', '牛奶', '10', '130.00');
INSERT INTO `food` VALUES ('17', '鸡蛋', '10', '120.00');
INSERT INTO `food` VALUES ('18', '面粉', '10', '140.00');
INSERT INTO `food` VALUES ('19', '鸡蛋', '10', '100.00');
INSERT INTO `food` VALUES ('20', '牛奶', '10', '120.00');
INSERT INTO `food` VALUES ('21', '面粉', '10', '120.00');
INSERT INTO `food` VALUES ('22', '牛奶', '10', '100.00');
INSERT INTO `food` VALUES ('23', '味精', '10', '300.00');
INSERT INTO `food` VALUES ('24', '香蕉', '10', '100.00');
INSERT INTO `food` VALUES ('25', '面粉', '20', '100.00');
INSERT INTO `food` VALUES ('26', '牛奶', '10', '100.00');
INSERT INTO `food` VALUES ('27', '榴莲', '10', '300.00');
INSERT INTO `food` VALUES ('28', '牛奶', '20', '100.00');
INSERT INTO `food` VALUES ('29', '鸭蛋', '10', '100.00');
INSERT INTO `food` VALUES ('30', '牛奶', '10', '10.00');
INSERT INTO `food` VALUES ('31', '白砂糖', '10', '201.00');
INSERT INTO `food` VALUES ('32', '鸡蛋', '10', '100.00');
INSERT INTO `food` VALUES ('33', '苹果', '10', '100.00');
INSERT INTO `food` VALUES ('34', '鸡蛋', '10', '120.00');
INSERT INTO `food` VALUES ('35', '食盐', '10', '100.00');
INSERT INTO `food` VALUES ('36', '鸡蛋', '10', '100.00');
INSERT INTO `food` VALUES ('37', '火腿', '10', '400.00');
INSERT INTO `food` VALUES ('38', '面粉', '10', '100.00');
INSERT INTO `food` VALUES ('39', '面粉', '10', '100.00');
INSERT INTO `food` VALUES ('40', '面粉', '10', '100.00');
INSERT INTO `food` VALUES ('41', '鸡蛋', '10', '100.00');
INSERT INTO `food` VALUES ('42', '白菜', '10', '50.00');
INSERT INTO `food` VALUES ('43', '白菜', '10', '50.00');
INSERT INTO `food` VALUES ('44', '火龙果', '10', '141.00');
INSERT INTO `food` VALUES ('45', '牛奶', '10', '100.00');
INSERT INTO `food` VALUES ('46', '白砂糖', '10', '20.00');
INSERT INTO `food` VALUES ('47', '鸡蛋', '10', '100.00');
INSERT INTO `food` VALUES ('48', '火腿', '10', '100.00');
INSERT INTO `food` VALUES ('49', '手抓饼', '10', '100.00');
INSERT INTO `food` VALUES ('50', '鸡蛋', '10', '100.00');
INSERT INTO `food` VALUES ('51', '牛奶', '10', '100.00');
INSERT INTO `food` VALUES ('52', '燕麦', '10', '100.00');
INSERT INTO `food` VALUES ('53', '鸡蛋', '10', '100.00');
INSERT INTO `food` VALUES ('54', '火腿', '10', '120.00');
INSERT INTO `food` VALUES ('55', '手抓饼', '10', '100.00');
INSERT INTO `food` VALUES ('56', '鸡蛋', '10', '10.00');
INSERT INTO `food` VALUES ('57', '牛奶', '10', '100.00');
INSERT INTO `food` VALUES ('58', '芒果', '10', '100.00');
INSERT INTO `food` VALUES ('59', '鸡蛋', '10', '100.00');
INSERT INTO `food` VALUES ('60', '火腿', '10', '100.00');
INSERT INTO `food` VALUES ('61', '牛奶', '10', '10.00');
INSERT INTO `food` VALUES ('63', '哈密瓜', '10', '100.00');
INSERT INTO `food` VALUES ('64', '牛奶', '10', '100.00');
INSERT INTO `food` VALUES ('65', '鸡蛋', '10', '110.00');
INSERT INTO `food` VALUES ('66', '鸡蛋', '10', '100.00');
INSERT INTO `food` VALUES ('67', '牛奶', '10', '100.00');
INSERT INTO `food` VALUES ('68', '面粉', '10', '100.00');
INSERT INTO `food` VALUES ('69', null, '10', '100.00');
INSERT INTO `food` VALUES ('70', '鸡蛋', '10', '100.00');
INSERT INTO `food` VALUES ('71', '牛奶', '10', '200.00');
INSERT INTO `food` VALUES ('72', '面粉', '20', '140.00');
INSERT INTO `food` VALUES ('73', null, '20', '140.00');
INSERT INTO `food` VALUES ('74', null, '20', '140.00');
INSERT INTO `food` VALUES ('75', null, '20', '140.00');
INSERT INTO `food` VALUES ('76', '西瓜', '10', '100.00');
INSERT INTO `food` VALUES ('77', '阿斯巴甜', '10', '200.00');
INSERT INTO `food` VALUES ('78', '鸡蛋', '10', '100.00');
INSERT INTO `food` VALUES ('79', '面粉', '10', '100.00');
INSERT INTO `food` VALUES ('80', '香蕉', '10', '100.00');
INSERT INTO `food` VALUES ('81', null, '10', '100.00');
INSERT INTO `food` VALUES ('82', null, '10', '100.00');
INSERT INTO `food` VALUES ('83', '鸡蛋', '10', '100.00');
INSERT INTO `food` VALUES ('84', '火腿', '10', '100.00');
INSERT INTO `food` VALUES ('85', '培根', '10', '100.00');
INSERT INTO `food` VALUES ('86', '手抓饼', '10', '20.00');
INSERT INTO `food` VALUES ('87', '鸡柳', '10', '100.00');
INSERT INTO `food` VALUES ('88', '牛奶', '10', '100.00');
INSERT INTO `food` VALUES ('89', '鸡蛋', '10', '120.00');
INSERT INTO `food` VALUES ('90', '面粉', '10', '130.00');
INSERT INTO `food` VALUES ('91', '白砂糖', '10', '110.00');
INSERT INTO `food` VALUES ('92', '味精', '10', '150.00');
INSERT INTO `food` VALUES ('93', '苹果', '10', '100.00');
INSERT INTO `food` VALUES ('94', '牛奶', '10', '100.00');
INSERT INTO `food` VALUES ('95', '鸡蛋', '10', '100.00');

-- ----------------------------
-- Table structure for food_plan
-- ----------------------------
DROP TABLE IF EXISTS `food_plan`;
CREATE TABLE `food_plan` (
  `plan_id` bigint(20) NOT NULL,
  `plan_food_id` bigint(20) NOT NULL,
  PRIMARY KEY (`plan_id`,`plan_food_id`),
  KEY `plan_food_id` (`plan_food_id`),
  CONSTRAINT `plan_food_id` FOREIGN KEY (`plan_food_id`) REFERENCES `food` (`id`),
  CONSTRAINT `plan_id` FOREIGN KEY (`plan_id`) REFERENCES `plan` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of food_plan
-- ----------------------------
INSERT INTO `food_plan` VALUES ('1', '1');
INSERT INTO `food_plan` VALUES ('1', '2');
INSERT INTO `food_plan` VALUES ('2', '3');
INSERT INTO `food_plan` VALUES ('28', '8');
INSERT INTO `food_plan` VALUES ('29', '9');
INSERT INTO `food_plan` VALUES ('30', '12');
INSERT INTO `food_plan` VALUES ('31', '13');
INSERT INTO `food_plan` VALUES ('31', '14');
INSERT INTO `food_plan` VALUES ('31', '15');
INSERT INTO `food_plan` VALUES ('32', '16');
INSERT INTO `food_plan` VALUES ('32', '17');
INSERT INTO `food_plan` VALUES ('32', '18');
INSERT INTO `food_plan` VALUES ('33', '19');
INSERT INTO `food_plan` VALUES ('33', '20');
INSERT INTO `food_plan` VALUES ('33', '21');
INSERT INTO `food_plan` VALUES ('35', '22');
INSERT INTO `food_plan` VALUES ('36', '23');
INSERT INTO `food_plan` VALUES ('36', '24');
INSERT INTO `food_plan` VALUES ('36', '25');
INSERT INTO `food_plan` VALUES ('37', '26');
INSERT INTO `food_plan` VALUES ('27', '28');
INSERT INTO `food_plan` VALUES ('38', '29');
INSERT INTO `food_plan` VALUES ('38', '30');
INSERT INTO `food_plan` VALUES ('38', '31');
INSERT INTO `food_plan` VALUES ('39', '33');
INSERT INTO `food_plan` VALUES ('39', '34');
INSERT INTO `food_plan` VALUES ('40', '35');
INSERT INTO `food_plan` VALUES ('40', '36');
INSERT INTO `food_plan` VALUES ('41', '39');
INSERT INTO `food_plan` VALUES ('41', '40');
INSERT INTO `food_plan` VALUES ('42', '42');
INSERT INTO `food_plan` VALUES ('42', '43');
INSERT INTO `food_plan` VALUES ('43', '44');
INSERT INTO `food_plan` VALUES ('43', '45');
INSERT INTO `food_plan` VALUES ('43', '46');
INSERT INTO `food_plan` VALUES ('44', '47');
INSERT INTO `food_plan` VALUES ('44', '48');
INSERT INTO `food_plan` VALUES ('44', '49');
INSERT INTO `food_plan` VALUES ('45', '50');
INSERT INTO `food_plan` VALUES ('45', '51');
INSERT INTO `food_plan` VALUES ('45', '52');
INSERT INTO `food_plan` VALUES ('46', '53');
INSERT INTO `food_plan` VALUES ('46', '54');
INSERT INTO `food_plan` VALUES ('46', '55');
INSERT INTO `food_plan` VALUES ('47', '56');
INSERT INTO `food_plan` VALUES ('47', '57');
INSERT INTO `food_plan` VALUES ('47', '58');
INSERT INTO `food_plan` VALUES ('48', '59');
INSERT INTO `food_plan` VALUES ('48', '60');
INSERT INTO `food_plan` VALUES ('48', '61');
INSERT INTO `food_plan` VALUES ('50', '63');
INSERT INTO `food_plan` VALUES ('50', '64');
INSERT INTO `food_plan` VALUES ('50', '65');
INSERT INTO `food_plan` VALUES ('51', '66');
INSERT INTO `food_plan` VALUES ('51', '67');
INSERT INTO `food_plan` VALUES ('51', '68');
INSERT INTO `food_plan` VALUES ('52', '70');
INSERT INTO `food_plan` VALUES ('52', '71');
INSERT INTO `food_plan` VALUES ('52', '72');
INSERT INTO `food_plan` VALUES ('52', '73');
INSERT INTO `food_plan` VALUES ('52', '74');
INSERT INTO `food_plan` VALUES ('52', '75');
INSERT INTO `food_plan` VALUES ('53', '76');
INSERT INTO `food_plan` VALUES ('53', '77');
INSERT INTO `food_plan` VALUES ('54', '78');
INSERT INTO `food_plan` VALUES ('54', '79');
INSERT INTO `food_plan` VALUES ('54', '80');
INSERT INTO `food_plan` VALUES ('54', '81');
INSERT INTO `food_plan` VALUES ('54', '82');
INSERT INTO `food_plan` VALUES ('55', '83');
INSERT INTO `food_plan` VALUES ('55', '84');
INSERT INTO `food_plan` VALUES ('55', '85');
INSERT INTO `food_plan` VALUES ('55', '86');
INSERT INTO `food_plan` VALUES ('55', '87');
INSERT INTO `food_plan` VALUES ('56', '88');
INSERT INTO `food_plan` VALUES ('56', '89');
INSERT INTO `food_plan` VALUES ('56', '90');
INSERT INTO `food_plan` VALUES ('56', '91');
INSERT INTO `food_plan` VALUES ('56', '92');
INSERT INTO `food_plan` VALUES ('33', '93');
INSERT INTO `food_plan` VALUES ('58', '94');
INSERT INTO `food_plan` VALUES ('58', '95');

-- ----------------------------
-- Table structure for plan
-- ----------------------------
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `plan_date` date DEFAULT NULL COMMENT '创建日期',
  `buy_date` date DEFAULT NULL,
  `planer_id` bigint(20) DEFAULT NULL COMMENT '计划员ID',
  `buyer_id` bigint(20) DEFAULT NULL COMMENT '采购员ID',
  `is_plan_check` varchar(2) DEFAULT '0' COMMENT '是否已审核 0未审核 1已审核',
  `is_order_check` varchar(2) DEFAULT '0' COMMENT '是否已审核 0未审核 1已审核',
  `is_buy` varchar(2) DEFAULT '0' COMMENT '是否已采购',
  `supplier_id` bigint(20) DEFAULT NULL,
  `is_receive` varchar(2) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `planer_id` (`planer_id`),
  CONSTRAINT `planer_id` FOREIGN KEY (`planer_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plan
-- ----------------------------
INSERT INTO `plan` VALUES ('1', '2019-12-07', '2019-12-10', '1', '2', '1', '1', '1', '1', '0');
INSERT INTO `plan` VALUES ('2', '2019-12-08', '2019-12-08', '6', '2', '1', '1', '1', '16', '0');
INSERT INTO `plan` VALUES ('27', '2019-12-07', '2019-12-08', '1', '2', '1', '1', '1', '14', '0');
INSERT INTO `plan` VALUES ('28', '2019-12-07', '2019-12-08', '1', '2', '1', '1', '1', '1', '0');
INSERT INTO `plan` VALUES ('29', '2019-12-07', '2019-12-08', '1', '2', '1', '0', '1', '13', '0');
INSERT INTO `plan` VALUES ('30', '2019-12-07', '2019-12-09', '1', '2', '1', '0', '1', '16', '0');
INSERT INTO `plan` VALUES ('31', '2019-12-07', null, '1', null, '1', '0', '0', null, '0');
INSERT INTO `plan` VALUES ('32', '2019-12-07', '2019-12-08', '1', '7', '1', '0', '1', '14', '0');
INSERT INTO `plan` VALUES ('33', '2019-12-07', null, '1', null, '0', '0', '0', null, '0');
INSERT INTO `plan` VALUES ('34', '2019-12-07', null, '1', null, '0', '0', '0', null, '0');
INSERT INTO `plan` VALUES ('35', '2019-12-07', null, '1', null, '0', '0', '0', null, '0');
INSERT INTO `plan` VALUES ('36', '2019-12-07', null, '1', null, '0', '0', '0', null, '0');
INSERT INTO `plan` VALUES ('37', '2019-12-07', null, '1', null, '0', '0', '0', null, '0');
INSERT INTO `plan` VALUES ('38', '2019-12-08', null, '1', null, '0', '0', '0', null, '0');
INSERT INTO `plan` VALUES ('39', '2019-12-08', null, '1', null, '0', '0', '0', null, '0');
INSERT INTO `plan` VALUES ('40', '2019-12-08', null, '1', null, '0', '0', '0', null, '0');
INSERT INTO `plan` VALUES ('41', '2019-12-08', null, '1', null, '0', '0', '0', null, '0');
INSERT INTO `plan` VALUES ('42', '2019-12-08', null, '1', null, '1', '0', '0', null, '0');
INSERT INTO `plan` VALUES ('43', '2019-12-08', null, '1', null, '0', '0', '0', null, '0');
INSERT INTO `plan` VALUES ('44', '2019-12-08', null, '1', null, '0', '0', '0', null, '0');
INSERT INTO `plan` VALUES ('45', '2019-12-08', null, '1', null, '0', '0', '0', null, '0');
INSERT INTO `plan` VALUES ('46', '2019-12-08', null, '1', null, '0', '0', '0', null, '0');
INSERT INTO `plan` VALUES ('47', '2019-12-08', null, '1', null, '0', '0', '0', null, '0');
INSERT INTO `plan` VALUES ('48', '2019-12-08', null, '1', null, '0', '0', '0', null, '0');
INSERT INTO `plan` VALUES ('49', '2019-12-08', null, '1', null, '0', '0', '0', null, '0');
INSERT INTO `plan` VALUES ('50', '2019-12-08', null, '1', null, '1', '0', '0', null, '0');
INSERT INTO `plan` VALUES ('51', '2019-12-08', null, '1', null, '0', '0', '0', null, '0');
INSERT INTO `plan` VALUES ('52', '2019-12-08', null, '1', null, '0', '0', '0', null, '0');
INSERT INTO `plan` VALUES ('53', '2019-12-08', null, '1', null, '0', '0', '0', null, '0');
INSERT INTO `plan` VALUES ('54', '2019-12-08', null, '1', null, '0', '0', '0', null, '0');
INSERT INTO `plan` VALUES ('55', '2019-12-08', null, '1', null, '0', '0', '0', null, '0');
INSERT INTO `plan` VALUES ('56', '2019-12-09', null, '1', null, '0', '0', '0', null, '0');
INSERT INTO `plan` VALUES ('57', '2019-12-09', null, null, null, '0', '0', '0', null, '0');
INSERT INTO `plan` VALUES ('58', '2019-12-09', null, '1', null, '0', '0', '0', null, '0');

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `linkman` varchar(40) DEFAULT NULL COMMENT '联系人',
  `phone` varchar(40) DEFAULT NULL COMMENT '联系电话',
  `status` varchar(2) DEFAULT '1' COMMENT '是否存在 0不存在 1存在',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES ('1', '供应商A', '广东省广州市番禺区', '刘先生', '13413972544', '1');
INSERT INTO `supplier` VALUES ('2', '供应商B', '广东省揭阳市', '林先生', '13484562475', '1');
INSERT INTO `supplier` VALUES ('3', '供应商C', '上海市黄浦区', '王先生', '13549575235', '1');
INSERT INTO `supplier` VALUES ('4', '供应商D', '北京市朝阳区', '颜先生', '13718615441', '1');
INSERT INTO `supplier` VALUES ('5', '供应商E', '广东省广州市番禺区', '刘先生', '13718615487', '1');
INSERT INTO `supplier` VALUES ('6', '供应商F', '广东省广州市番禺区', '刘先生', '13549575298', '1');
INSERT INTO `supplier` VALUES ('7', '供应商G', '广东省汕头市', '林小姐', '13845965774', '1');
INSERT INTO `supplier` VALUES ('11', '供应商X', '广东省深圳市', '王先生', '15487469441', '1');
INSERT INTO `supplier` VALUES ('13', '供应商P', '广东省深圳市', '林先生', '17854948774', '1');
INSERT INTO `supplier` VALUES ('14', '供应商Q', '广东省深圳市', '刘先生', '18945687669', '1');
INSERT INTO `supplier` VALUES ('16', '供应商Y', '北京市朝阳区', '林达', '19854687116', '1');
INSERT INTO `supplier` VALUES ('17', '供应商L', '广东省深圳市', '林达', '15487924874', '1');
INSERT INTO `supplier` VALUES ('18', '供应商U', '广东省珠海市', '王先生', '13578945884', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `job_num` varchar(40) DEFAULT NULL,
  `user_name` varchar(40) DEFAULT NULL COMMENT '姓名',
  `pwd` varchar(40) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'JH001', '小明', '27b35d45cea533a0552f8efeab5ccbda');
INSERT INTO `user` VALUES ('2', 'CG001', '小强', '27b35d45cea533a0552f8efeab5ccbda');
INSERT INTO `user` VALUES ('3', 'ZG001', '小刚', '27b35d45cea533a0552f8efeab5ccbda');
INSERT INTO `user` VALUES ('4', 'JS001', '小红', '27b35d45cea533a0552f8efeab5ccbda');
INSERT INTO `user` VALUES ('6', 'JH002', '小鬼', '27b35d45cea533a0552f8efeab5ccbda');
INSERT INTO `user` VALUES ('7', 'CG002', '小美', '27b35d45cea533a0552f8efeab5ccbda');
INSERT INTO `user` VALUES ('8', 'ZG002', '小林', '27b35d45cea533a0552f8efeab5ccbda');
INSERT INTO `user` VALUES ('9', 'JS002', '小王', '27b35d45cea533a0552f8efeab5ccbda');

-- ----------------------------
-- Table structure for user_authority
-- ----------------------------
DROP TABLE IF EXISTS `user_authority`;
CREATE TABLE `user_authority` (
  `user_id` bigint(20) DEFAULT NULL,
  `authority_id` bigint(20) DEFAULT NULL,
  KEY `user_id` (`user_id`),
  KEY `authority_id` (`authority_id`),
  CONSTRAINT `authority_id` FOREIGN KEY (`authority_id`) REFERENCES `authority` (`id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_authority
-- ----------------------------
INSERT INTO `user_authority` VALUES ('1', '1');
INSERT INTO `user_authority` VALUES ('1', '6');
INSERT INTO `user_authority` VALUES ('1', '7');
INSERT INTO `user_authority` VALUES ('2', '2');
INSERT INTO `user_authority` VALUES ('2', '8');
INSERT INTO `user_authority` VALUES ('2', '9');
INSERT INTO `user_authority` VALUES ('3', '3');
INSERT INTO `user_authority` VALUES ('3', '10');
INSERT INTO `user_authority` VALUES ('3', '11');
INSERT INTO `user_authority` VALUES ('4', '4');
INSERT INTO `user_authority` VALUES ('4', '12');
INSERT INTO `user_authority` VALUES ('2', '13');
INSERT INTO `user_authority` VALUES ('2', '15');
INSERT INTO `user_authority` VALUES ('2', '16');
INSERT INTO `user_authority` VALUES ('3', '15');
INSERT INTO `user_authority` VALUES ('3', '13');
INSERT INTO `user_authority` VALUES ('3', '16');
INSERT INTO `user_authority` VALUES ('7', '2');
INSERT INTO `user_authority` VALUES ('7', '8');
INSERT INTO `user_authority` VALUES ('7', '9');
INSERT INTO `user_authority` VALUES ('7', '13');
INSERT INTO `user_authority` VALUES ('7', '15');
INSERT INTO `user_authority` VALUES ('7', '16');
