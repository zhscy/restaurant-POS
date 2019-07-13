/*
 Navicat Premium Data Transfer

 Source Server         : remoteConnector
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : 47.103.2.194:3306
 Source Schema         : restaurant

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 26/06/2019 16:27:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `ctg_id` int(8) NOT NULL AUTO_INCREMENT,
  `ctg_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单类别',
  `ctg_remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ctg_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '主菜', '');
INSERT INTO `category` VALUES (4, '酒水', '');
INSERT INTO `category` VALUES (6, '甜品', '');
INSERT INTO `category` VALUES (7, '意面', '');
INSERT INTO `category` VALUES (9, '前菜', '');
INSERT INTO `category` VALUES (10, '汤类', NULL);
INSERT INTO `category` VALUES (11, '其他', NULL);
INSERT INTO `category` VALUES (15, '扒类', '');
INSERT INTO `category` VALUES (22, '套餐', NULL);

-- ----------------------------
-- Table structure for dict_data
-- ----------------------------
DROP TABLE IF EXISTS `dict_data`;
CREATE TABLE `dict_data`  (
  `dict_code` int(6) NOT NULL AUTO_INCREMENT,
  `dict_label` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典标签',
  `dict_value` int(6) NOT NULL COMMENT '标签对应的数值',
  `dict_data_type` int(8) NOT NULL COMMENT '字典类型',
  PRIMARY KEY (`dict_code`) USING BTREE,
  INDEX `fk_data_type`(`dict_data_type`) USING BTREE,
  CONSTRAINT `fk_data_type` FOREIGN KEY (`dict_data_type`) REFERENCES `dict_type` (`dict_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dict_data
-- ----------------------------
INSERT INTO `dict_data` VALUES (1, '男', 0, 2);
INSERT INTO `dict_data` VALUES (2, '女', 1, 2);
INSERT INTO `dict_data` VALUES (3, 'tt1', 0, 3);
INSERT INTO `dict_data` VALUES (4, 'tt2', 1, 3);
INSERT INTO `dict_data` VALUES (5, 'tt3', 2, 3);
INSERT INTO `dict_data` VALUES (6, '测试', 666, 7);
INSERT INTO `dict_data` VALUES (7, 'tt1', 0, 3);
INSERT INTO `dict_data` VALUES (8, 'tt2', 1, 3);
INSERT INTO `dict_data` VALUES (9, 'tt3', 2, 3);
INSERT INTO `dict_data` VALUES (51, 'tt1', 0, 3);
INSERT INTO `dict_data` VALUES (52, 'tt2', 1, 3);
INSERT INTO `dict_data` VALUES (53, 'tt3', 2, 3);

-- ----------------------------
-- Table structure for dict_type
-- ----------------------------
DROP TABLE IF EXISTS `dict_type`;
CREATE TABLE `dict_type`  (
  `dict_id` int(8) NOT NULL AUTO_INCREMENT,
  `dict_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典名称',
  `dict_type` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典类型（供表的字段使用）',
  `dict_remark` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述说明',
  PRIMARY KEY (`dict_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dict_type
-- ----------------------------
INSERT INTO `dict_type` VALUES (1, '酱汁', 'sauce', NULL);
INSERT INTO `dict_type` VALUES (2, '性别', 'user_sex', NULL);
INSERT INTO `dict_type` VALUES (3, 'test', 'test', '');
INSERT INTO `dict_type` VALUES (7, 'test2', 't', 'sdf');
INSERT INTO `dict_type` VALUES (36, 'tt', 'tt', NULL);
INSERT INTO `dict_type` VALUES (37, 'tt', 'tt', NULL);

-- ----------------------------
-- Table structure for dinner_table
-- ----------------------------
DROP TABLE IF EXISTS `dinner_table`;
CREATE TABLE `dinner_table`  (
  `dinner_id` int(8) NOT NULL AUTO_INCREMENT,
  `dinner_number` int(8) NOT NULL COMMENT '餐台编号(连续)',
  `dinner_type` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '餐台类型',
  `table_state` int(4) NOT NULL COMMENT '餐台状态(0，1)',
  PRIMARY KEY (`dinner_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dinner_table
-- ----------------------------
INSERT INTO `dinner_table` VALUES (1, 1, '双人桌', 0);
INSERT INTO `dinner_table` VALUES (3, 2, '双人桌', 0);
INSERT INTO `dinner_table` VALUES (4, 3, '双人桌', 0);
INSERT INTO `dinner_table` VALUES (5, 4, '双人桌', 0);
INSERT INTO `dinner_table` VALUES (7, 5, '双人桌', 0);
INSERT INTO `dinner_table` VALUES (9, 6, '四人桌', 0);
INSERT INTO `dinner_table` VALUES (10, 7, '四人桌', 0);
INSERT INTO `dinner_table` VALUES (11, 8, '四人桌', 0);
INSERT INTO `dinner_table` VALUES (12, 9, '四人桌', 0);
INSERT INTO `dinner_table` VALUES (14, 10, '四人桌', 0);
INSERT INTO `dinner_table` VALUES (15, 11, '六人桌', 0);
INSERT INTO `dinner_table` VALUES (16, 12, '六人桌', 0);
INSERT INTO `dinner_table` VALUES (17, 13, '六人桌', 0);
INSERT INTO `dinner_table` VALUES (18, 14, '六人桌', 0);
INSERT INTO `dinner_table` VALUES (19, 15, '六人桌', 0);
INSERT INTO `dinner_table` VALUES (20, 16, '8人桌', 0);
INSERT INTO `dinner_table` VALUES (21, 17, '8人桌', 0);
INSERT INTO `dinner_table` VALUES (22, 18, '8人桌', 0);
INSERT INTO `dinner_table` VALUES (23, 19, '8人桌', 0);
INSERT INTO `dinner_table` VALUES (24, 20, '8人桌', 0);
INSERT INTO `dinner_table` VALUES (25, 21, '8人桌', 0);
INSERT INTO `dinner_table` VALUES (26, 22, '8人桌', 0);

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `menu_id` int(10) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜品名称',
  `menu_price` double(8, 2) NOT NULL COMMENT '菜品价格',
  `menu_category` int(8) NOT NULL,
  `menu_remark` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述说明',
  PRIMARY KEY (`menu_id`) USING BTREE,
  INDEX `fk_menu_category`(`menu_category`) USING BTREE,
  CONSTRAINT `fk_menu_category` FOREIGN KEY (`menu_category`) REFERENCES `category` (`ctg_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '黑椒牛排', 108.00, 1, NULL);
INSERT INTO `menu` VALUES (3, '菇香牛肉意大利面', 28.00, 7, '');
INSERT INTO `menu` VALUES (6, '橙汁', 15.00, 4, NULL);
INSERT INTO `menu` VALUES (7, '肉酱意大利面', 18.00, 7, '');
INSERT INTO `menu` VALUES (8, '茶位', 8.00, 11, NULL);
INSERT INTO `menu` VALUES (9, '草莓酸奶沙拉', 16.00, 6, NULL);
INSERT INTO `menu` VALUES (10, '芝士鸡排', 40.00, 1, NULL);
INSERT INTO `menu` VALUES (11, '牛柳扒', 60.00, 1, NULL);
INSERT INTO `menu` VALUES (12, '鲜蘑菇汤', 35.00, 10, NULL);
INSERT INTO `menu` VALUES (13, '番茄意面', 18.00, 7, NULL);
INSERT INTO `menu` VALUES (14, '蔬菜干果沙拉', 38.00, 6, NULL);
INSERT INTO `menu` VALUES (15, '茄汁猪扒', 99.00, 15, NULL);
INSERT INTO `menu` VALUES (16, '鹅肝酱', 120.00, 9, NULL);
INSERT INTO `menu` VALUES (17, '鱼子酱', 150.00, 9, NULL);
INSERT INTO `menu` VALUES (18, '纸巾', 2.00, 11, NULL);
INSERT INTO `menu` VALUES (19, '罗马风情牛肉炒饭', 36.00, 1, NULL);
INSERT INTO `menu` VALUES (20, '拉菲尚品波尔多红酒', 128.00, 4, '750ml/瓶');
INSERT INTO `menu` VALUES (21, '新英格兰蛤蜊巧达汤', 40.00, 10, NULL);
INSERT INTO `menu` VALUES (22, '西班牙番茄冷汤', 25.00, 10, NULL);
INSERT INTO `menu` VALUES (23, '罗宋汤', 29.00, 10, NULL);
INSERT INTO `menu` VALUES (24, '美式咖啡', 27.00, 4, NULL);
INSERT INTO `menu` VALUES (25, '红茶拿铁', 28.00, 4, NULL);
INSERT INTO `menu` VALUES (26, '香草冰淇淋', 22.00, 6, NULL);
INSERT INTO `menu` VALUES (27, '黑椒鸡扒', 28.00, 15, NULL);
INSERT INTO `menu` VALUES (28, '黑椒猪扒', 25.00, 15, NULL);
INSERT INTO `menu` VALUES (29, '安格斯肉眼牛扒', 99.00, 15, NULL);
INSERT INTO `menu` VALUES (30, '贵妃鸡扒', 58.00, 15, NULL);
INSERT INTO `menu` VALUES (31, '纽西兰西冷牛排', 125.00, 1, NULL);
INSERT INTO `menu` VALUES (32, '澳洲T骨牛排', 158.00, 1, NULL);
INSERT INTO `menu` VALUES (33, '碳烤雪花牛排', 199.00, 1, NULL);
INSERT INTO `menu` VALUES (34, '碳烤雪花牛排+鲜蘑菇汤+草莓酸奶沙拉', 222.00, 22, '套餐A');
INSERT INTO `menu` VALUES (35, '罗马风情牛肉炒饭+菇香牛肉意大利面+罗宋汤+橙汁', 99.00, 22, '套餐B');
INSERT INTO `menu` VALUES (36, '黑椒牛排+肉酱意大利面+香草冰淇淋', 128.00, 22, '套餐C');
INSERT INTO `menu` VALUES (38, '芝士鸡排+美式咖啡+肉酱意大利面', 72.00, 22, '套餐D');
INSERT INTO `menu` VALUES (39, '纽西兰西冷牛排*2+拉菲尚品波尔多红酒+草莓酸奶沙拉', 338.00, 22, '双人情侣套餐');
INSERT INTO `menu` VALUES (40, '安格斯肉眼牛扒+新英格兰蛤蜊巧达汤+香草冰淇淋', 148.00, 22, '套餐E');

-- ----------------------------
-- Table structure for num
-- ----------------------------
DROP TABLE IF EXISTS `num`;
CREATE TABLE `num`  (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of num
-- ----------------------------
INSERT INTO `num` VALUES (1);
INSERT INTO `num` VALUES (2);
INSERT INTO `num` VALUES (3);
INSERT INTO `num` VALUES (4);
INSERT INTO `num` VALUES (5);
INSERT INTO `num` VALUES (6);
INSERT INTO `num` VALUES (7);
INSERT INTO `num` VALUES (8);
INSERT INTO `num` VALUES (9);
INSERT INTO `num` VALUES (10);
INSERT INTO `num` VALUES (11);
INSERT INTO `num` VALUES (12);

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment`  (
  `pay_id` int(12) NOT NULL AUTO_INCREMENT,
  `pay_time` datetime(0) NOT NULL COMMENT '支付时间',
  `pay_way` int(4) NOT NULL DEFAULT 0 COMMENT '支付方式(0 现金，1 微信/支付宝)',
  `pay_total` decimal(10, 2) NOT NULL COMMENT '支付总额',
  `pay_change` decimal(10, 2) NOT NULL COMMENT '找零',
  `pay_actual` decimal(8, 2) NOT NULL COMMENT '实付金额',
  PRIMARY KEY (`pay_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 69 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of payment
-- ----------------------------
INSERT INTO `payment` VALUES (2, '2019-05-11 16:59:47', 0, 110.00, 8.00, 102.00);
INSERT INTO `payment` VALUES (3, '2019-05-12 17:10:56', 0, 500.00, 36.00, 464.00);
INSERT INTO `payment` VALUES (4, '2019-05-12 17:11:29', 1, 231.00, 0.00, 231.00);
INSERT INTO `payment` VALUES (5, '2019-05-12 17:11:41', 1, 306.00, 0.00, 306.00);
INSERT INTO `payment` VALUES (6, '2019-05-12 17:42:10', 0, 100.00, 16.00, 84.00);
INSERT INTO `payment` VALUES (7, '2019-06-24 22:14:56', 0, 220.00, 4.00, 216.00);
INSERT INTO `payment` VALUES (8, '2019-06-24 22:15:45', 1, 212.00, 0.00, 212.00);
INSERT INTO `payment` VALUES (9, '2019-06-24 22:48:01', 0, 300.00, 44.00, 256.00);
INSERT INTO `payment` VALUES (10, '2019-06-24 22:50:59', 0, 10.00, -38.00, 48.00);
INSERT INTO `payment` VALUES (11, '2019-06-24 22:53:37', 0, 1.00, -459.00, 460.00);
INSERT INTO `payment` VALUES (12, '2019-06-24 23:27:03', 0, 10.00, -45.00, 55.00);
INSERT INTO `payment` VALUES (13, '2019-05-10 23:31:41', 0, 20.00, -202.00, 222.00);
INSERT INTO `payment` VALUES (14, '2019-05-10 00:15:36', 0, 162.00, 0.00, 162.00);
INSERT INTO `payment` VALUES (15, '2019-06-25 00:20:47', 0, 150.00, 14.00, 136.00);
INSERT INTO `payment` VALUES (16, '2019-06-25 22:49:02', 0, 14.00, -134.00, 148.00);
INSERT INTO `payment` VALUES (17, '2019-06-25 22:49:51', 0, 20.00, -187.00, 207.00);
INSERT INTO `payment` VALUES (18, '2019-06-25 22:53:51', 1, 148.00, 0.00, 148.00);
INSERT INTO `payment` VALUES (19, '2019-06-26 00:14:59', 0, 233.00, 0.00, 233.00);
INSERT INTO `payment` VALUES (20, '2019-06-26 00:15:15', 0, 60.00, 9.00, 51.00);
INSERT INTO `payment` VALUES (21, '2019-06-26 00:15:25', 1, 384.00, 0.00, 384.00);
INSERT INTO `payment` VALUES (22, '2019-06-26 00:15:33', 1, 232.00, 0.00, 232.00);
INSERT INTO `payment` VALUES (23, '2019-06-26 00:15:46', 0, 250.00, 18.00, 232.00);
INSERT INTO `payment` VALUES (24, '2019-06-26 00:15:55', 0, 70.00, 6.00, 64.00);
INSERT INTO `payment` VALUES (25, '2019-06-26 00:16:10', 0, 80.00, 2.00, 78.00);
INSERT INTO `payment` VALUES (26, '2019-06-26 00:16:19', 1, 78.00, 0.00, 78.00);
INSERT INTO `payment` VALUES (27, '2019-06-26 00:16:35', 1, 93.00, 0.00, 93.00);
INSERT INTO `payment` VALUES (28, '2019-06-26 00:16:45', 1, 64.00, 0.00, 64.00);
INSERT INTO `payment` VALUES (29, '2019-06-26 00:16:59', 1, 108.00, 0.00, 108.00);
INSERT INTO `payment` VALUES (30, '2019-06-26 00:17:27', 0, 330.00, 6.00, 324.00);
INSERT INTO `payment` VALUES (31, '2019-06-26 00:17:35', 1, 46.00, 0.00, 46.00);
INSERT INTO `payment` VALUES (32, '2019-06-26 00:17:44', 1, 163.00, 0.00, 163.00);
INSERT INTO `payment` VALUES (33, '2019-06-26 00:17:55', 0, 260.00, 4.00, 256.00);
INSERT INTO `payment` VALUES (34, '2019-06-26 00:18:03', 1, 148.00, 0.00, 148.00);
INSERT INTO `payment` VALUES (35, '2019-06-26 00:18:11', 1, 148.00, 0.00, 148.00);
INSERT INTO `payment` VALUES (36, '2019-06-26 00:18:22', 0, 148.00, 0.00, 148.00);
INSERT INTO `payment` VALUES (37, '2019-06-26 00:18:31', 1, 108.00, 0.00, 108.00);
INSERT INTO `payment` VALUES (38, '2019-06-26 00:18:40', 0, 110.00, 2.00, 108.00);
INSERT INTO `payment` VALUES (39, '2019-06-26 00:19:11', 0, 100.00, 22.00, 78.00);
INSERT INTO `payment` VALUES (40, '2019-06-26 00:19:23', 0, 50.00, 10.00, 40.00);
INSERT INTO `payment` VALUES (41, '2019-06-26 00:19:32', 0, 100.00, 0.00, 100.00);
INSERT INTO `payment` VALUES (42, '2019-06-26 00:19:49', 0, 150.00, 2.00, 148.00);
INSERT INTO `payment` VALUES (43, '2019-06-26 00:19:58', 1, 148.00, 0.00, 148.00);
INSERT INTO `payment` VALUES (44, '2019-06-26 00:20:09', 0, 148.00, 0.00, 148.00);
INSERT INTO `payment` VALUES (45, '2019-06-26 00:20:20', 1, 216.00, 0.00, 216.00);
INSERT INTO `payment` VALUES (46, '2019-06-26 00:20:25', 1, 60.00, 0.00, 60.00);
INSERT INTO `payment` VALUES (47, '2019-06-26 00:20:33', 0, 20.00, 2.00, 18.00);
INSERT INTO `payment` VALUES (48, '2019-06-26 00:21:03', 0, 180.00, 32.00, 148.00);
INSERT INTO `payment` VALUES (49, '2019-06-26 00:21:11', 0, 160.00, 12.00, 148.00);
INSERT INTO `payment` VALUES (50, '2019-06-26 00:21:18', 0, 20.00, 5.00, 15.00);
INSERT INTO `payment` VALUES (51, '2019-06-26 00:21:29', 0, 200.00, 52.00, 148.00);
INSERT INTO `payment` VALUES (52, '2019-06-26 00:21:39', 1, 30.00, 0.00, 30.00);
INSERT INTO `payment` VALUES (53, '2019-06-26 00:21:47', 0, 50.00, 6.00, 44.00);
INSERT INTO `payment` VALUES (54, '2019-06-26 00:21:55', 0, 60.00, 28.00, 32.00);
INSERT INTO `payment` VALUES (55, '2019-06-26 00:22:04', 0, 260.00, 4.00, 256.00);
INSERT INTO `payment` VALUES (56, '2019-06-26 00:22:12', 0, 360.00, 24.00, 336.00);
INSERT INTO `payment` VALUES (57, '2019-06-26 00:22:21', 1, 143.00, 0.00, 143.00);
INSERT INTO `payment` VALUES (58, '2019-06-26 00:22:32', 0, 80.00, 10.00, 70.00);
INSERT INTO `payment` VALUES (59, '2019-06-26 00:35:46', 0, 1.00, -255.00, 256.00);
INSERT INTO `payment` VALUES (60, '2019-06-26 13:10:00', 0, 200.00, 19.00, 181.00);
INSERT INTO `payment` VALUES (61, '2019-06-26 16:08:18', 0, 60.00, 5.00, 55.00);
INSERT INTO `payment` VALUES (62, '2019-06-26 16:08:29', 1, 48.00, 0.00, 48.00);
INSERT INTO `payment` VALUES (63, '2019-06-26 16:08:42', 0, 500.00, 40.00, 460.00);
INSERT INTO `payment` VALUES (64, '2019-06-26 16:08:49', 1, 460.00, 0.00, 460.00);
INSERT INTO `payment` VALUES (65, '2019-06-26 16:08:57', 0, 230.00, 8.00, 222.00);
INSERT INTO `payment` VALUES (66, '2019-06-26 16:09:10', 1, 207.00, 0.00, 207.00);
INSERT INTO `payment` VALUES (67, '2019-06-26 16:09:19', 1, 148.00, 0.00, 148.00);
INSERT INTO `payment` VALUES (68, '2019-06-26 16:09:27', 1, 256.00, 0.00, 256.00);

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `perms_id` int(8) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_permission` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`perms_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, 'admin', 'user:modify');
INSERT INTO `permission` VALUES (2, 'user', 'menu:modify');
INSERT INTO `permission` VALUES (3, 'user', 'category:modify');
INSERT INTO `permission` VALUES (4, 'admin', 'user:select');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_id` int(8) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色',
  `role_remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色权限附注',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'admin', '');
INSERT INTO `role` VALUES (2, 'user', NULL);
INSERT INTO `role` VALUES (5, 'waiter', '服务员');
INSERT INTO `role` VALUES (11, 'chef', '厨师');

-- ----------------------------
-- Table structure for sales_item
-- ----------------------------
DROP TABLE IF EXISTS `sales_item`;
CREATE TABLE `sales_item`  (
  `order_id` int(12) NOT NULL COMMENT '订单id',
  `item_id` int(20) NOT NULL AUTO_INCREMENT,
  `item_handle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜品处理',
  `item_menu_id` int(8) NOT NULL COMMENT '菜品id',
  `item_amount` int(8) NOT NULL COMMENT '菜品数量',
  `unit_price` decimal(8, 2) NOT NULL COMMENT '菜品单价',
  `total_price` decimal(10, 2) NOT NULL COMMENT '该项总价',
  `item_state` int(4) NULL DEFAULT 0 COMMENT '该项状态，菜品是否准备好（0 准备中，1 准备好 2 上菜）',
  PRIMARY KEY (`item_id`) USING BTREE,
  INDEX `fk_menu_id`(`item_menu_id`) USING BTREE,
  INDEX `fk_order_id`(`order_id`) USING BTREE,
  CONSTRAINT `fk_menu_id` FOREIGN KEY (`item_menu_id`) REFERENCES `menu` (`menu_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_order_id` FOREIGN KEY (`order_id`) REFERENCES `sales_order` (`order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 127 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sales_item
-- ----------------------------
INSERT INTO `sales_item` VALUES (3, 1, NULL, 1, 2, 40.00, 80.00, 2);
INSERT INTO `sales_item` VALUES (3, 2, NULL, 6, 1, 15.00, 15.00, 2);
INSERT INTO `sales_item` VALUES (4, 5, '', 1, 2, 108.00, 216.00, 2);
INSERT INTO `sales_item` VALUES (4, 6, NULL, 6, 1, 15.00, 30.00, 2);
INSERT INTO `sales_item` VALUES (4, 7, NULL, 9, 1, 16.00, 16.00, 2);
INSERT INTO `sales_item` VALUES (4, 8, NULL, 3, 4, 28.00, 28.00, 2);
INSERT INTO `sales_item` VALUES (4, 9, NULL, 8, 1, 8.00, 16.00, 2);
INSERT INTO `sales_item` VALUES (5, 10, NULL, 1, 1, 108.00, 108.00, 2);
INSERT INTO `sales_item` VALUES (5, 11, NULL, 3, 1, 28.00, 28.00, 2);
INSERT INTO `sales_item` VALUES (5, 12, NULL, 7, 1, 18.00, 18.00, 2);
INSERT INTO `sales_item` VALUES (5, 13, NULL, 8, 1, 8.00, 8.00, 2);
INSERT INTO `sales_item` VALUES (6, 14, NULL, 3, 2, 28.00, 56.00, 2);
INSERT INTO `sales_item` VALUES (6, 15, NULL, 6, 2, 15.00, 30.00, 2);
INSERT INTO `sales_item` VALUES (6, 16, NULL, 8, 2, 8.00, 16.00, 2);
INSERT INTO `sales_item` VALUES (12, 20, NULL, 1, 4, 108.00, 432.00, 2);
INSERT INTO `sales_item` VALUES (12, 21, NULL, 8, 4, 8.00, 32.00, 2);
INSERT INTO `sales_item` VALUES (14, 22, NULL, 9, 2, 16.00, 32.00, 2);
INSERT INTO `sales_item` VALUES (14, 23, NULL, 7, 2, 18.00, 36.00, 2);
INSERT INTO `sales_item` VALUES (14, 24, NULL, 8, 2, 8.00, 16.00, 2);
INSERT INTO `sales_item` VALUES (15, 25, NULL, 3, 1, 28.00, 28.00, 2);
INSERT INTO `sales_item` VALUES (15, 26, NULL, 6, 1, 15.00, 15.00, 2);
INSERT INTO `sales_item` VALUES (15, 27, NULL, 8, 1, 8.00, 8.00, 2);
INSERT INTO `sales_item` VALUES (16, 28, NULL, 1, 3, 108.00, 324.00, 2);
INSERT INTO `sales_item` VALUES (16, 29, NULL, 3, 1, 28.00, 28.00, 2);
INSERT INTO `sales_item` VALUES (16, 30, NULL, 8, 4, 8.00, 32.00, 2);
INSERT INTO `sales_item` VALUES (17, 31, NULL, 1, 2, 108.00, 216.00, 2);
INSERT INTO `sales_item` VALUES (17, 32, NULL, 8, 2, 8.00, 16.00, 2);
INSERT INTO `sales_item` VALUES (18, 33, NULL, 10, 3, 40.00, 120.00, 2);
INSERT INTO `sales_item` VALUES (18, 34, NULL, 11, 1, 60.00, 60.00, 2);
INSERT INTO `sales_item` VALUES (18, 35, NULL, 8, 4, 8.00, 32.00, 2);
INSERT INTO `sales_item` VALUES (19, 36, NULL, 10, 2, 40.00, 80.00, 2);
INSERT INTO `sales_item` VALUES (19, 37, NULL, 11, 2, 60.00, 120.00, 2);
INSERT INTO `sales_item` VALUES (19, 38, NULL, 8, 4, 8.00, 32.00, 2);
INSERT INTO `sales_item` VALUES (26, 39, NULL, 3, 1, 28.00, 28.00, 2);
INSERT INTO `sales_item` VALUES (26, 40, NULL, 7, 2, 18.00, 36.00, 2);
INSERT INTO `sales_item` VALUES (27, 41, NULL, 11, 1, 60.00, 60.00, 2);
INSERT INTO `sales_item` VALUES (27, 42, NULL, 7, 1, 18.00, 18.00, 2);
INSERT INTO `sales_item` VALUES (28, 43, NULL, 11, 1, 60.00, 60.00, 2);
INSERT INTO `sales_item` VALUES (28, 44, NULL, 7, 1, 18.00, 18.00, 2);
INSERT INTO `sales_item` VALUES (28, 45, NULL, 6, 1, 15.00, 15.00, 2);
INSERT INTO `sales_item` VALUES (29, 46, NULL, 10, 1, 40.00, 40.00, 2);
INSERT INTO `sales_item` VALUES (29, 47, NULL, 9, 1, 16.00, 16.00, 2);
INSERT INTO `sales_item` VALUES (29, 48, NULL, 8, 1, 8.00, 8.00, 2);
INSERT INTO `sales_item` VALUES (30, 49, NULL, 1, 1, 108.00, 108.00, 2);
INSERT INTO `sales_item` VALUES (31, 50, NULL, 1, 3, 108.00, 324.00, 2);
INSERT INTO `sales_item` VALUES (32, 51, NULL, 6, 2, 15.00, 30.00, 2);
INSERT INTO `sales_item` VALUES (32, 52, NULL, 9, 1, 16.00, 16.00, 2);
INSERT INTO `sales_item` VALUES (33, 53, NULL, 1, 1, 108.00, 108.00, 2);
INSERT INTO `sales_item` VALUES (33, 54, NULL, 10, 1, 40.00, 40.00, 2);
INSERT INTO `sales_item` VALUES (33, 55, NULL, 6, 1, 15.00, 15.00, 2);
INSERT INTO `sales_item` VALUES (34, 56, NULL, 1, 2, 108.00, 216.00, 2);
INSERT INTO `sales_item` VALUES (34, 57, NULL, 10, 1, 40.00, 40.00, 2);
INSERT INTO `sales_item` VALUES (35, 58, NULL, 1, 1, 108.00, 108.00, 2);
INSERT INTO `sales_item` VALUES (35, 59, NULL, 10, 1, 40.00, 40.00, 2);
INSERT INTO `sales_item` VALUES (36, 60, NULL, 1, 1, 108.00, 108.00, 2);
INSERT INTO `sales_item` VALUES (36, 61, NULL, 10, 1, 40.00, 40.00, 2);
INSERT INTO `sales_item` VALUES (37, 62, NULL, 1, 1, 108.00, 108.00, 2);
INSERT INTO `sales_item` VALUES (38, 63, NULL, 7, 1, 18.00, 18.00, 2);
INSERT INTO `sales_item` VALUES (38, 64, NULL, 11, 1, 60.00, 60.00, 2);
INSERT INTO `sales_item` VALUES (39, 65, NULL, 10, 1, 40.00, 40.00, 2);
INSERT INTO `sales_item` VALUES (40, 66, NULL, 10, 1, 40.00, 40.00, 2);
INSERT INTO `sales_item` VALUES (40, 67, NULL, 11, 1, 60.00, 60.00, 2);
INSERT INTO `sales_item` VALUES (41, 68, NULL, 1, 1, 108.00, 108.00, 2);
INSERT INTO `sales_item` VALUES (41, 69, NULL, 10, 1, 40.00, 40.00, 2);
INSERT INTO `sales_item` VALUES (42, 70, NULL, 1, 1, 108.00, 108.00, 2);
INSERT INTO `sales_item` VALUES (42, 71, NULL, 10, 1, 40.00, 40.00, 2);
INSERT INTO `sales_item` VALUES (43, 72, NULL, 1, 1, 108.00, 108.00, 2);
INSERT INTO `sales_item` VALUES (43, 73, NULL, 10, 1, 40.00, 40.00, 2);
INSERT INTO `sales_item` VALUES (44, 74, NULL, 1, 1, 108.00, 108.00, 2);
INSERT INTO `sales_item` VALUES (44, 75, NULL, 10, 1, 40.00, 40.00, 2);
INSERT INTO `sales_item` VALUES (45, 76, NULL, 1, 1, 108.00, 108.00, 2);
INSERT INTO `sales_item` VALUES (45, 77, NULL, 10, 1, 40.00, 40.00, 2);
INSERT INTO `sales_item` VALUES (46, 78, NULL, 6, 1, 15.00, 15.00, 2);
INSERT INTO `sales_item` VALUES (47, 79, NULL, 6, 2, 15.00, 30.00, 2);
INSERT INTO `sales_item` VALUES (48, 80, NULL, 9, 2, 16.00, 32.00, 2);
INSERT INTO `sales_item` VALUES (49, 81, NULL, 8, 2, 8.00, 16.00, 2);
INSERT INTO `sales_item` VALUES (49, 82, NULL, 3, 1, 28.00, 28.00, 2);
INSERT INTO `sales_item` VALUES (50, 83, NULL, 12, 2, 35.00, 70.00, 2);
INSERT INTO `sales_item` VALUES (51, 84, NULL, 6, 1, 15.00, 15.00, 2);
INSERT INTO `sales_item` VALUES (51, 85, NULL, 20, 1, 128.00, 128.00, 2);
INSERT INTO `sales_item` VALUES (52, 86, NULL, 26, 1, 22.00, 22.00, 2);
INSERT INTO `sales_item` VALUES (52, 87, NULL, 17, 1, 150.00, 150.00, 2);
INSERT INTO `sales_item` VALUES (52, 88, NULL, 20, 1, 128.00, 128.00, 2);
INSERT INTO `sales_item` VALUES (52, 89, NULL, 19, 1, 36.00, 36.00, 2);
INSERT INTO `sales_item` VALUES (53, 90, NULL, 1, 2, 108.00, 216.00, 2);
INSERT INTO `sales_item` VALUES (53, 91, NULL, 10, 1, 40.00, 40.00, 2);
INSERT INTO `sales_item` VALUES (54, 92, NULL, 13, 1, 18.00, 18.00, 2);
INSERT INTO `sales_item` VALUES (55, 93, NULL, 11, 1, 60.00, 60.00, 2);
INSERT INTO `sales_item` VALUES (56, 94, NULL, 23, 1, 29.00, 29.00, 2);
INSERT INTO `sales_item` VALUES (56, 95, NULL, 18, 1, 2.00, 2.00, 2);
INSERT INTO `sales_item` VALUES (56, 96, NULL, 8, 1, 8.00, 8.00, 2);
INSERT INTO `sales_item` VALUES (56, 97, NULL, 9, 1, 16.00, 16.00, 2);
INSERT INTO `sales_item` VALUES (57, 98, NULL, 6, 2, 15.00, 30.00, 2);
INSERT INTO `sales_item` VALUES (57, 99, NULL, 13, 1, 18.00, 18.00, 2);
INSERT INTO `sales_item` VALUES (58, 100, NULL, 1, 3, 108.00, 324.00, 2);
INSERT INTO `sales_item` VALUES (58, 101, NULL, 10, 1, 40.00, 40.00, 2);
INSERT INTO `sales_item` VALUES (58, 102, NULL, 11, 1, 60.00, 60.00, 2);
INSERT INTO `sales_item` VALUES (58, 103, NULL, 19, 1, 36.00, 36.00, 2);
INSERT INTO `sales_item` VALUES (59, 104, NULL, 1, 2, 108.00, 216.00, 2);
INSERT INTO `sales_item` VALUES (59, 105, NULL, 10, 1, 40.00, 40.00, 2);
INSERT INTO `sales_item` VALUES (60, 106, NULL, 1, 2, 108.00, 216.00, 2);
INSERT INTO `sales_item` VALUES (61, 107, NULL, 34, 1, 222.00, 222.00, 2);
INSERT INTO `sales_item` VALUES (62, 108, NULL, 10, 1, 40.00, 40.00, 2);
INSERT INTO `sales_item` VALUES (62, 109, NULL, 11, 1, 60.00, 60.00, 2);
INSERT INTO `sales_item` VALUES (62, 110, NULL, 19, 1, 36.00, 36.00, 2);
INSERT INTO `sales_item` VALUES (63, 111, NULL, 1, 1, 108.00, 108.00, 2);
INSERT INTO `sales_item` VALUES (63, 112, NULL, 10, 1, 40.00, 40.00, 2);
INSERT INTO `sales_item` VALUES (64, 113, '6', 24, 1, 27.00, 27.00, 2);
INSERT INTO `sales_item` VALUES (64, 114, '7', 26, 1, 22.00, 22.00, 2);
INSERT INTO `sales_item` VALUES (64, 115, '8', 32, 1, 158.00, 158.00, 2);
INSERT INTO `sales_item` VALUES (65, 116, '七分熟', 10, 2, 40.00, 40.00, 2);
INSERT INTO `sales_item` VALUES (65, 117, NULL, 1, 1, 108.00, 108.00, 2);
INSERT INTO `sales_item` VALUES (66, 118, NULL, 1, 2, 108.00, 216.00, 2);
INSERT INTO `sales_item` VALUES (67, 119, NULL, 1, 1, 108.00, 108.00, 2);
INSERT INTO `sales_item` VALUES (67, 120, '七分熟', 31, 1, 125.00, 125.00, 2);
INSERT INTO `sales_item` VALUES (68, 121, NULL, 1, 2, 108.00, 216.00, 2);
INSERT INTO `sales_item` VALUES (68, 122, NULL, 10, 1, 40.00, 40.00, 2);
INSERT INTO `sales_item` VALUES (69, 123, NULL, 35, 1, 99.00, 99.00, 2);
INSERT INTO `sales_item` VALUES (69, 124, NULL, 38, 1, 72.00, 72.00, 2);
INSERT INTO `sales_item` VALUES (69, 125, NULL, 8, 1, 8.00, 8.00, 2);
INSERT INTO `sales_item` VALUES (69, 126, NULL, 18, 1, 2.00, 2.00, 2);

-- ----------------------------
-- Table structure for sales_order
-- ----------------------------
DROP TABLE IF EXISTS `sales_order`;
CREATE TABLE `sales_order`  (
  `order_id` int(12) NOT NULL AUTO_INCREMENT,
  `order_time` datetime(0) NOT NULL COMMENT '订单时间',
  `order_total_price` decimal(10, 2) NOT NULL COMMENT '总价',
  `table_id` int(8) NOT NULL COMMENT '餐桌id',
  `pay_state` int(8) NULL DEFAULT NULL COMMENT '支付状态',
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `fk_table_id`(`table_id`) USING BTREE,
  INDEX `fk_pay`(`pay_state`) USING BTREE,
  CONSTRAINT `fk_pay` FOREIGN KEY (`pay_state`) REFERENCES `payment` (`pay_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_table_id` FOREIGN KEY (`table_id`) REFERENCES `dinner_table` (`dinner_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 70 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sales_order
-- ----------------------------
INSERT INTO `sales_order` VALUES (3, '2019-04-22 20:37:44', 231.00, 4, 4);
INSERT INTO `sales_order` VALUES (4, '2019-04-24 00:50:58', 306.00, 3, 5);
INSERT INTO `sales_order` VALUES (5, '2019-05-10 19:48:30', 162.00, 3, 14);
INSERT INTO `sales_order` VALUES (6, '2019-05-11 20:44:49', 102.00, 1, 2);
INSERT INTO `sales_order` VALUES (12, '2019-05-12 21:55:17', 464.00, 1, 3);
INSERT INTO `sales_order` VALUES (14, '2019-05-16 22:22:49', 84.00, 1, 6);
INSERT INTO `sales_order` VALUES (15, '2019-05-17 23:41:52', 51.00, 1, 20);
INSERT INTO `sales_order` VALUES (16, '2019-05-18 23:41:59', 384.00, 1, 21);
INSERT INTO `sales_order` VALUES (17, '2019-05-18 23:42:21', 232.00, 3, 22);
INSERT INTO `sales_order` VALUES (18, '2019-05-18 23:42:53', 212.00, 4, 8);
INSERT INTO `sales_order` VALUES (19, '2019-05-18 23:44:22', 232.00, 3, 23);
INSERT INTO `sales_order` VALUES (26, '2019-05-18 23:50:14', 64.00, 3, 24);
INSERT INTO `sales_order` VALUES (27, '2019-05-19 23:54:43', 78.00, 4, 26);
INSERT INTO `sales_order` VALUES (28, '2019-05-19 23:56:17', 93.00, 3, 27);
INSERT INTO `sales_order` VALUES (29, '2019-05-20 00:13:39', 64.00, 4, 28);
INSERT INTO `sales_order` VALUES (30, '2019-05-20 00:14:42', 108.00, 3, 29);
INSERT INTO `sales_order` VALUES (31, '2019-05-21 12:41:13', 324.00, 3, 30);
INSERT INTO `sales_order` VALUES (32, '2019-05-21 13:49:20', 46.00, 5, 31);
INSERT INTO `sales_order` VALUES (33, '2019-05-22 13:49:41', 163.00, 5, 32);
INSERT INTO `sales_order` VALUES (34, '2019-05-22 13:54:05', 256.00, 4, 33);
INSERT INTO `sales_order` VALUES (35, '2019-05-23 14:06:34', 148.00, 5, 35);
INSERT INTO `sales_order` VALUES (36, '2019-05-23 14:09:17', 148.00, 5, 36);
INSERT INTO `sales_order` VALUES (37, '2019-05-23 14:11:24', 108.00, 4, 38);
INSERT INTO `sales_order` VALUES (38, '2019-05-24 14:12:19', 78.00, 4, 39);
INSERT INTO `sales_order` VALUES (39, '2019-05-24 14:13:11', 40.00, 7, 40);
INSERT INTO `sales_order` VALUES (40, '2019-05-25 14:13:21', 100.00, 5, 41);
INSERT INTO `sales_order` VALUES (41, '2019-05-26 14:14:58', 148.00, 3, 43);
INSERT INTO `sales_order` VALUES (42, '2019-05-27 14:16:29', 148.00, 1, 44);
INSERT INTO `sales_order` VALUES (43, '2019-05-27 14:18:50', 148.00, 3, 48);
INSERT INTO `sales_order` VALUES (44, '2019-05-28 14:21:25', 148.00, 5, 49);
INSERT INTO `sales_order` VALUES (45, '2019-05-29 14:22:14', 148.00, 3, 51);
INSERT INTO `sales_order` VALUES (46, '2019-05-30 14:24:11', 15.00, 3, 50);
INSERT INTO `sales_order` VALUES (47, '2019-05-31 14:31:08', 30.00, 3, 52);
INSERT INTO `sales_order` VALUES (48, '2019-06-01 14:33:15', 32.00, 4, 54);
INSERT INTO `sales_order` VALUES (49, '2019-06-02 15:18:23', 44.00, 7, 53);
INSERT INTO `sales_order` VALUES (50, '2019-06-02 15:55:00', 70.00, 1, 58);
INSERT INTO `sales_order` VALUES (51, '2019-06-03 18:27:38', 143.00, 5, 57);
INSERT INTO `sales_order` VALUES (52, '2019-06-03 18:41:11', 336.00, 7, 56);
INSERT INTO `sales_order` VALUES (53, '2019-06-04 19:55:23', 256.00, 4, 55);
INSERT INTO `sales_order` VALUES (54, '2019-06-04 19:56:35', 18.00, 3, 47);
INSERT INTO `sales_order` VALUES (55, '2019-06-05 19:57:49', 60.00, 7, 46);
INSERT INTO `sales_order` VALUES (56, '2019-06-05 20:04:01', 55.00, 4, 61);
INSERT INTO `sales_order` VALUES (57, '2019-06-06 22:18:23', 48.00, 1, 62);
INSERT INTO `sales_order` VALUES (58, '2019-06-06 14:32:39', 460.00, 4, 64);
INSERT INTO `sales_order` VALUES (59, '2019-06-24 21:59:00', 256.00, 5, 9);
INSERT INTO `sales_order` VALUES (60, '2019-06-24 22:03:05', 216.00, 3, 7);
INSERT INTO `sales_order` VALUES (61, '2019-06-24 23:31:29', 222.00, 3, 65);
INSERT INTO `sales_order` VALUES (62, '2019-06-25 00:20:15', 136.00, 5, 15);
INSERT INTO `sales_order` VALUES (63, '2019-06-25 01:20:59', 148.00, 4, 18);
INSERT INTO `sales_order` VALUES (64, '2019-06-25 01:23:02', 207.00, 3, 66);
INSERT INTO `sales_order` VALUES (65, '2019-06-25 22:48:40', 148.00, 7, 67);
INSERT INTO `sales_order` VALUES (66, '2019-06-25 23:12:14', 216.00, 9, 45);
INSERT INTO `sales_order` VALUES (67, '2019-06-26 00:14:08', 233.00, 3, 19);
INSERT INTO `sales_order` VALUES (68, '2019-06-26 00:35:38', 256.00, 1, 68);
INSERT INTO `sales_order` VALUES (69, '2019-06-26 13:09:46', 181.00, 24, 60);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(8) NOT NULL AUTO_INCREMENT,
  `user_tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工手机号，作为账号使用',
  `user_password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工密码',
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工姓名',
  `user_sex` int(6) NULL DEFAULT NULL COMMENT '员工性别(0男，1女)',
  `user_role` int(8) NOT NULL COMMENT '员工角色',
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `fk_user_role`(`user_role`) USING BTREE,
  CONSTRAINT `fk_user_role` FOREIGN KEY (`user_role`) REFERENCES `role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '13666666666', '123456', '张三', 0, 5);
INSERT INTO `user` VALUES (2, '13611111111', '123456', '李四', 0, 2);
INSERT INTO `user` VALUES (12, '15800000000', 'admin', 'admin', 1, 1);
INSERT INTO `user` VALUES (20, '15777777777', '123456', '赵五', 0, 11);
INSERT INTO `user` VALUES (21, '15555555555', '123456', '李六', 1, 5);
INSERT INTO `user` VALUES (22, '15222222222', '123456', '王八', 0, 11);

SET FOREIGN_KEY_CHECKS = 1;
