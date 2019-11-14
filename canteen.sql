/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50506
Source Host           : localhost:3306
Source Database       : canteen

Target Server Type    : MYSQL
Target Server Version : 50506
File Encoding         : 65001

Date: 2019-08-16 13:45:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `address`
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `address_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `user_phone` varchar(255) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `user_address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('2', '李春', '13307504369', '2150866957@qq.com', '75', '四川西南科技大学新区东四宿舍楼');
INSERT INTO `address` VALUES ('3', '张张aa', '18281635009', '759646095@qq.com', '75', '西南科技大学老区西一宿舍楼');
INSERT INTO `address` VALUES ('6', 'y', '18281635009', null, '84', '海滨烧烤广场');
INSERT INTO `address` VALUES ('7', 'sansan', '177', null, '84', '蜀锦上渟');

-- ----------------------------
-- Table structure for `canteen`
-- ----------------------------
DROP TABLE IF EXISTS `canteen`;
CREATE TABLE `canteen` (
  `canteen_id` int(11) NOT NULL AUTO_INCREMENT,
  `canteen_label` varchar(255) DEFAULT NULL,
  `canteen_name` varchar(255) DEFAULT NULL,
  `canteen_des` varchar(255) DEFAULT NULL,
  `canteen_image` varchar(255) DEFAULT NULL,
  `canteen_mark_number` int(11) DEFAULT NULL,
  `sales` bigint(20) DEFAULT NULL,
  `canteen_mark` double DEFAULT NULL,
  `takeout_money` int(11) DEFAULT NULL,
  PRIMARY KEY (`canteen_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of canteen
-- ----------------------------
INSERT INTO `canteen` VALUES ('8', '好好吃', '二食堂', '呵呵', 'http://image.xikecanteen.com/canteen/8/4.png', '1', '20', '4.5', '1');
INSERT INTO `canteen` VALUES ('9', '女生多', '一食堂', '色香味俱全哈哈哈哈哈啊哈哈哈', 'http://image.xikecanteen.com/canteen/9/1.png', '1', '20', '3.5', '2');
INSERT INTO `canteen` VALUES ('10', '快餐', '三食堂', '速度快', 'http://image.xikecanteen.com/canteen/10/3.png', '1', '20', '3', '1');
INSERT INTO `canteen` VALUES ('11', '肠粉主打', '四食堂', '好吃不贵', 'http://image.xikecanteen.com/canteen/11/2.png', '1', '20', '3.5', '1');
INSERT INTO `canteen` VALUES ('12', null, '五食堂', null, 'http://image.xikecanteen.com/canteen/12/4.png', '1', '20', '3.5', '1');
INSERT INTO `canteen` VALUES ('13', null, '六食堂', null, 'http://image.xikecanteen.com/canteen/13/6.png', '1', '20', '3.5', '1');
INSERT INTO `canteen` VALUES ('14', null, '七食堂', null, 'http://image.xikecanteen.com/canteen/14/7.png', '1', '40', '3.5', '1');
INSERT INTO `canteen` VALUES ('20', null, '八食堂', null, 'http://image.xikecanteen.com/canteen/20/8.png', '1', '50', '3.5', '1');
INSERT INTO `canteen` VALUES ('21', null, '九食堂', null, 'http://image.xikecanteen.com/canteen/21/9.png', '1', '20', '3.5', '1');
INSERT INTO `canteen` VALUES ('22', null, '十食堂', null, 'http://image.xikecanteen.com/canteen/22/8.png', null, '30', '4.5', null);

-- ----------------------------
-- Table structure for `cart`
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `cart_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) DEFAULT NULL,
  `all_price` int(11) DEFAULT NULL,
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('1', '75', '0');
INSERT INTO `cart` VALUES ('5', '84', '0');
INSERT INTO `cart` VALUES ('7', '86', '0');
INSERT INTO `cart` VALUES ('8', '87', '0');
INSERT INTO `cart` VALUES ('9', '88', '0');
INSERT INTO `cart` VALUES ('10', '89', '0');
INSERT INTO `cart` VALUES ('15', '91', '0');
INSERT INTO `cart` VALUES ('16', '92', '0');
INSERT INTO `cart` VALUES ('17', '93', '0');
INSERT INTO `cart` VALUES ('18', '94', '0');
INSERT INTO `cart` VALUES ('19', '95', '0');
INSERT INTO `cart` VALUES ('20', '96', '0');
INSERT INTO `cart` VALUES ('21', '97', '0');
INSERT INTO `cart` VALUES ('22', '98', '0');
INSERT INTO `cart` VALUES ('23', '99', '0');
INSERT INTO `cart` VALUES ('24', '100', '0');
INSERT INTO `cart` VALUES ('25', '101', '19');
INSERT INTO `cart` VALUES ('26', '102', '13');
INSERT INTO `cart` VALUES ('27', '103', '0');

-- ----------------------------
-- Table structure for `cart_info`
-- ----------------------------
DROP TABLE IF EXISTS `cart_info`;
CREATE TABLE `cart_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cart_id` int(11) DEFAULT NULL,
  `food_id` bigint(20) DEFAULT NULL,
  `food_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart_info
-- ----------------------------
INSERT INTO `cart_info` VALUES ('40', '26', '1', '1');
INSERT INTO `cart_info` VALUES ('47', '25', '102', '1');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comment_content` varchar(255) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `canteen_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('4', 'haochi', '19', '75', '9');
INSERT INTO `comment` VALUES ('5', '鸡排好吃', '21', '75', '8');
INSERT INTO `comment` VALUES ('6', '鸡排真好吃', '22', '75', '8');
INSERT INTO `comment` VALUES ('7', '太好吃了', '18', '75', '9');
INSERT INTO `comment` VALUES ('8', '配送速度快', '22', '75', '8');
INSERT INTO `comment` VALUES ('9', 'zz', '19', '75', '9');
INSERT INTO `comment` VALUES ('10', 'cc', '20', '75', '8');

-- ----------------------------
-- Table structure for `food`
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food` (
  `food_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `food_describe` varchar(255) DEFAULT NULL,
  `food_price` int(11) DEFAULT NULL,
  `food_image` varchar(255) DEFAULT NULL,
  `canteen_id` int(11) DEFAULT NULL,
  `food_name` varchar(255) DEFAULT NULL,
  `food_rate` double DEFAULT NULL,
  `food_rate_number` bigint(20) DEFAULT NULL,
  `created_time` date DEFAULT NULL,
  `food_sale` int(11) DEFAULT NULL,
  PRIMARY KEY (`food_id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of food
-- ----------------------------
INSERT INTO `food` VALUES ('1', '好吃', '13', 'http://image.xikecanteen.com/canteen/8/1/1.png', '8', '卤肉饭', '4.2', '10', null, '6');
INSERT INTO `food` VALUES ('2', '多', '15', 'http://image.xikecanteen.com/canteen/8/2/shuangpin.png', '8', '双拼', '3.5', '10', null, '9');
INSERT INTO `food` VALUES ('6', '好吃', '2', 'http://image.xikecanteen.com/canteen/8/6/kaochang.png', '8', '烤肠', '4.2', '10', null, '0');
INSERT INTO `food` VALUES ('7', '量多', '15', 'http://image.xikecanteen.com/canteen/8/7/1.png', '8', '鸡排饭', '4.5', '10', null, '3');
INSERT INTO `food` VALUES ('8', '汤好', '16', 'http://image.xikecanteen.com/canteen/8/8/2.png', '8', '土鸡汤饭', '4.7', '10', null, '0');
INSERT INTO `food` VALUES ('9', '骨头多', '12', 'http://image.xikecanteen.com/canteen/8/9/3.png', '8', '排骨汤饭', '4.8', '10', null, '0');
INSERT INTO `food` VALUES ('101', '辣', '15', 'http://image.xikecanteen.com/canteen/9/101/1.png', '9', '竹笋鸡米', '4.8', '10', null, '1');
INSERT INTO `food` VALUES ('102', '好吃', '19', 'http://image.xikecanteen.com/canteen/9/102/8.png', '9', '铁板牛肉饭', '4.8', '10', null, '11');

-- ----------------------------
-- Table structure for `ord`
-- ----------------------------
DROP TABLE IF EXISTS `ord`;
CREATE TABLE `ord` (
  `order_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(255) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `all_price` int(11) DEFAULT NULL,
  `user_address` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `order_remark` varchar(255) DEFAULT NULL,
  `order_time` varchar(255) DEFAULT NULL,
  `user_phone` varchar(255) DEFAULT NULL,
  `order_state` int(11) DEFAULT NULL,
  `created_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ord
-- ----------------------------
INSERT INTO `ord` VALUES ('18', '75', null, '19', '四川西南科技大学新区东四宿舍楼', '李春位', '不要辣', '2019/5/17:04:04', '13307504369', '3', '2019-05-17 20:46:30');
INSERT INTO `ord` VALUES ('19', '75', null, '34', '西科大', '杨来为哈哈', 'z', '2019/5/17:05:04', '18281635009', '3', '2019-05-17 20:46:53');
INSERT INTO `ord` VALUES ('20', '75', null, '15', '西南科技大学老区西一宿舍楼', '张张', 'c', '2019/5/17:03:04', '18281635009', '3', '2019-05-17 21:44:01');
INSERT INTO `ord` VALUES ('21', '75', null, '15', '四川西南科技大学新区东四宿舍楼', '李春位', '不要土豆', '2019/5/17:00:02', '13307504369', '1', '2019-05-17 23:05:52');
INSERT INTO `ord` VALUES ('22', '75', null, '15', '西南科技大学老区西一宿舍楼', '张张', 'b', '2019/5/17:02:03', '18281635009', '3', '2019-05-17 23:51:27');
INSERT INTO `ord` VALUES ('23', '75', null, '28', '西南科技大学老区西一宿舍楼', '张张', 'p', '2019/5/18:00:02', '18281635009', '2', '2019-05-18 22:19:39');
INSERT INTO `ord` VALUES ('24', '75', null, '39', '四川西南科技大学新区东四宿舍楼', '李春', 'p', '2019/5/18:02:03', '13307504369', '1', '2019-05-18 22:20:28');
INSERT INTO `ord` VALUES ('25', '75', null, '19', '四川西南科技大学新区东四宿舍楼', '李春', '不要辣', '2019/5/19:03:04', '13307504369', '1', '2019-05-19 11:03:52');
INSERT INTO `ord` VALUES ('26', '75', null, '47', '四川西南科技大学新区东四宿舍楼', '李春哈哈', 'cc', '2019/6/2:02:03', '13307504369', '1', '2019-06-02 19:05:04');
INSERT INTO `ord` VALUES ('27', '75', null, '38', '西科大东三宿舍楼', '杨gg', 'b', '2019/6/2:01:03', '18281635009', '0', '2019-06-02 19:07:21');
INSERT INTO `ord` VALUES ('28', '75', null, '15', '四川西南科技大学新区东四宿舍楼', '李春哈哈', 'x', '2019/6/2:02:02', '13307504369', '0', '2019-06-02 20:22:54');
INSERT INTO `ord` VALUES ('29', '75', null, '19', '四川西南科技大学新区东四宿舍楼', '李春哈哈', 'p', '2019/6/2:03:09', '13307504369', '0', '2019-06-02 20:27:22');
INSERT INTO `ord` VALUES ('30', '75', null, '19', '四川西南科技大学新区东四宿舍楼', '李春哈哈', 'm', '2019/6/2:01:03', '13307504369', '0', '2019-06-02 20:30:22');
INSERT INTO `ord` VALUES ('31', '75', null, '15', '四川西南科技大学新区东四宿舍楼', '李春哈哈', 'k', '2019/6/2:02:03', '13307504369', '0', '2019-06-02 20:31:16');
INSERT INTO `ord` VALUES ('32', '75', null, '19', '四川西南科技大学新区东四宿舍楼', '李春哈哈', 'l', '2019/6/2:02:03', '13307504369', '0', '2019-06-02 20:31:28');
INSERT INTO `ord` VALUES ('33', '75', null, '34', '四川西南科技大学新区东四宿舍楼', '李春哈哈', '9', '2019/6/2:03:03', '13307504369', '0', '2019-06-02 20:31:53');
INSERT INTO `ord` VALUES ('34', '75', null, '30', '四川西南科技大学新区东四宿舍楼', '李春哈哈', '不要辣', '2019/6/6:05:04', '13307504369', '0', '2019-06-06 11:31:34');
INSERT INTO `ord` VALUES ('35', '75', null, '19', '四川西南科技大学新区东四宿舍楼', '李春哈哈', 'vv', '2019/6/6:02:03', '13307504369', '0', '2019-06-06 11:35:00');
INSERT INTO `ord` VALUES ('36', '75', null, '15', '四川西南科技大学新区东四宿舍楼', '李春哈哈', 'c', '2019/6/6:01:03', '13307504369', '0', '2019-06-06 11:42:18');
INSERT INTO `ord` VALUES ('37', '75', null, '28', '四川西南科技大学新区东四宿舍楼', '李春哈哈', '辣', '2019/6/6:03:04', '13307504369', '0', '2019-06-06 11:44:09');

-- ----------------------------
-- Table structure for `order_info`
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) DEFAULT NULL,
  `food_id` bigint(20) DEFAULT NULL,
  `food_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES ('18', '18', '102', '1');
INSERT INTO `order_info` VALUES ('19', '19', '102', '1');
INSERT INTO `order_info` VALUES ('20', '19', '2', '1');
INSERT INTO `order_info` VALUES ('21', '20', '2', '1');
INSERT INTO `order_info` VALUES ('22', '21', '7', '1');
INSERT INTO `order_info` VALUES ('23', '22', '2', '1');
INSERT INTO `order_info` VALUES ('24', '23', '2', '1');
INSERT INTO `order_info` VALUES ('25', '23', '1', '1');
INSERT INTO `order_info` VALUES ('26', '24', '1', '3');
INSERT INTO `order_info` VALUES ('27', '25', '102', '1');
INSERT INTO `order_info` VALUES ('28', '26', '1', '1');
INSERT INTO `order_info` VALUES ('29', '26', '2', '1');
INSERT INTO `order_info` VALUES ('30', '26', '102', '1');
INSERT INTO `order_info` VALUES ('31', '27', '102', '2');
INSERT INTO `order_info` VALUES ('32', '28', '7', '1');
INSERT INTO `order_info` VALUES ('33', '29', '102', '1');
INSERT INTO `order_info` VALUES ('34', '30', '102', '1');
INSERT INTO `order_info` VALUES ('35', '31', '2', '1');
INSERT INTO `order_info` VALUES ('36', '32', '102', '1');
INSERT INTO `order_info` VALUES ('37', '33', '101', '1');
INSERT INTO `order_info` VALUES ('38', '33', '102', '1');
INSERT INTO `order_info` VALUES ('39', '34', '2', '1');
INSERT INTO `order_info` VALUES ('40', '34', '7', '1');
INSERT INTO `order_info` VALUES ('41', '35', '102', '1');
INSERT INTO `order_info` VALUES ('42', '36', '2', '1');
INSERT INTO `order_info` VALUES ('43', '37', '2', '1');
INSERT INTO `order_info` VALUES ('44', '37', '1', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_phone` varchar(255) DEFAULT NULL,
  `user_pwd` varchar(255) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_status` int(11) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `canteen_id` int(11) DEFAULT NULL,
  `verify_code` varchar(255) DEFAULT NULL,
  `cart_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('57', '111', '698d51a19d8a121ce581499d7b701668', '111', '1', '111', null, null, '2');
INSERT INTO `user` VALUES ('62', '222', 'bcbe3365e6ac95ea2c0343a2395834dd', '222', '2', 'haha', null, null, null);
INSERT INTO `user` VALUES ('63', '333', '310dcbbf4cce62f762a2aaa148d556bd', '333', '3', '333', null, null, null);
INSERT INTO `user` VALUES ('67', '123', '202cb962ac59075b964b07152d234b70', '123', null, '大头', null, null, null);
INSERT INTO `user` VALUES ('68', 'xx', '9336ebf25087d91c818ee6e9ec29f8c1', 'xx', null, 'xx', null, null, null);
INSERT INTO `user` VALUES ('69', '777', 'd79c8788088c2193f0244d8f1f36d2db', '777', '2', 'haha', '8', null, null);
INSERT INTO `user` VALUES ('72', '哈哈', 'de156e39c8481df78050021b1ffcd425', '777@qq.com', '1', '小可爱', '9', null, null);
INSERT INTO `user` VALUES ('74', '999', '310dcbbf4cce62f762a2aaa148d556bd', '759646095@qq.com', '2', '杨yy', '11', null, null);
INSERT INTO `user` VALUES ('75', '188', '310dcbbf4cce62f762a2aaa148d556bd', '2150866957@qq.com', '3', 'zz', '9', 'Gh10U7', '1');
INSERT INTO `user` VALUES ('76', '199', '310dcbbf4cce62f762a2aaa148d556bd', '544262072@qq.com', '2', '芳芳', '8', 'z2n838', null);
INSERT INTO `user` VALUES ('77', '1073365038', '18cb29f5cf6f512555656d420743f9b0', '1073365038@qq.com', '1', '大宝贝', '10', 'cL49pc', null);
INSERT INTO `user` VALUES ('80', '333', '310dcbbf4cce62f762a2aaa148d556bd', '333@qq.com', '2', '三三', '8', null, null);
INSERT INTO `user` VALUES ('84', null, null, 'oYozN4mtf-bSuByIIBtEAWFNA014', null, '超高校级的饭桶', null, null, '5');
INSERT INTO `user` VALUES ('85', '144', '310dcbbf4cce62f762a2aaa148d556bd', '888@qq.com', '3', 'sansan', null, null, null);
INSERT INTO `user` VALUES ('87', '888', '0a113ef6b61820daa5611c870ed8d5ee', '888@qq.com', '3', '888', null, null, null);
INSERT INTO `user` VALUES ('88', '3333', '310dcbbf4cce62f762a2aaa148d556bd', '3333@qq.com', '3', '3333', null, null, null);
INSERT INTO `user` VALUES ('89', '666', 'fae0b27c451c728867a567e8c1bb4e53', '666@qq.com', '3', '666', null, null, null);
INSERT INTO `user` VALUES ('90', '777', 'f1c1592588411002af340cbaedd6fc33', '777@qq.com', '3', '777', null, null, null);
INSERT INTO `user` VALUES ('91', '999', 'b706835de79a2b4e80506f582af3676a', '999@qq.com', '3', '999', null, null, '15');
INSERT INTO `user` VALUES ('92', '000', 'c6f057b86584942e415435ffb1fa93d4', '000@qq.com', '3', '000', null, null, '16');
INSERT INTO `user` VALUES ('94', '55', '310dcbbf4cce62f762a2aaa148d556bd', '66666@qq.com', '3', 'gg', null, null, '18');
INSERT INTO `user` VALUES ('95', 'hh', '310dcbbf4cce62f762a2aaa148d556bd', 'hh@qq.com', '3', 'hh', null, null, '19');
INSERT INTO `user` VALUES ('96', '000', '310dcbbf4cce62f762a2aaa148d556bd', '0000@qq.com', '3', 'hh', null, null, '20');
INSERT INTO `user` VALUES ('97', '666', '310dcbbf4cce62f762a2aaa148d556bd', '1818@qq.com', '3', '000', null, null, '21');
INSERT INTO `user` VALUES ('98', '123', '310dcbbf4cce62f762a2aaa148d556bd', '1212@qq.com', '3', '1212', null, null, '22');
INSERT INTO `user` VALUES ('99', '13', '310dcbbf4cce62f762a2aaa148d556bd', '13@qq.com', '3', '13', null, null, '23');
INSERT INTO `user` VALUES ('100', '999', '310dcbbf4cce62f762a2aaa148d556bd', '6767@qq.com', '3', '6767', null, null, '24');
INSERT INTO `user` VALUES ('101', 'jj', '310dcbbf4cce62f762a2aaa148d556bd', 'jj@qq.com', '3', 'jj', null, null, '25');
INSERT INTO `user` VALUES ('102', '333', '310dcbbf4cce62f762a2aaa148d556bd', 'kk@163.com', '3', 'kk', null, null, '26');
INSERT INTO `user` VALUES ('103', '333', '310dcbbf4cce62f762a2aaa148d556bd', 'as@qq.com', '3', 'as', null, null, '27');

-- ----------------------------
-- Table structure for `user_collect`
-- ----------------------------
DROP TABLE IF EXISTS `user_collect`;
CREATE TABLE `user_collect` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `canteen_id` int(11) DEFAULT NULL,
  `user_id` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_collect
-- ----------------------------
INSERT INTO `user_collect` VALUES ('5', '8', '80');
INSERT INTO `user_collect` VALUES ('15', '8', '75');
INSERT INTO `user_collect` VALUES ('17', '8', '101');
INSERT INTO `user_collect` VALUES ('18', '8', '103');
