/*
 Navicat Premium Data Transfer

 Source Server         : azhou
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : 20250306zxs

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 07/03/2025 00:25:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `stu_id` bigint(20) NULL DEFAULT NULL COMMENT '学生编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物品名称',
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物品图片',
  `info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简介',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '借还管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of borrow
-- ----------------------------
INSERT INTO `borrow` VALUES (1, 11, '马克思主义', 'http://localhost:8092/zxs/0f86eef0-24cd-4d15-b7ae-ebd9b54ebeb6.png', '马克思在《资本论》中运用辩证唯物主义与历史唯物主义方法，深入剖析资本主义经济运行规律。他从商品这一资本主义社会最基本的元素入手，揭示了商品二重性 —— 使用价值和价值，进而引出劳动二重性理论，指出具体劳动创造使用价值，抽象劳动形成价值。在此基础上，马克思详细阐述了货币的产生与本质，货币是商品交换发展到一定阶段的产物，其本质是固定充当一般等价物的商品，具备价值尺度、流通手段等职能。', '2025-03-06 22:39:14', '15616181764');
INSERT INTO `borrow` VALUES (2, 12, 'JAVA基础', 'http://localhost:8092/zxs/18e62538-fc97-4ce9-9afb-3a0a078e4f08.png', '高等数学', '2025-03-06 22:51:19', '1008611');
INSERT INTO `borrow` VALUES (3, 12, 'MySQL书', 'http://localhost:8092/zxs/d148a93e-6b6f-4f5b-8c6c-766272d335c7.png', 'mysql书籍简介', '2025-03-06 22:52:03', '1001011');

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '贴吧编号',
  `from_stu_id` bigint(20) NULL DEFAULT NULL COMMENT '评论学生编号',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '评论内容',
  `to_stu_id` bigint(20) NULL DEFAULT NULL COMMENT '回复人编号',
  `parent_id` bigint(20) NULL DEFAULT 0 COMMENT '父级评论编号',
  `img_list` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '图片列表',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '评论时间',
  `type` int(11) NULL DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '贴吧评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES (49, 11, '哈哈哈哈哈，真好看啊', NULL, 0, 'http://localhost:8092/zxs/67f3ba92-547e-44c4-a9cb-efb518b50abc.png,http://localhost:8092/zxs/11eebf59-d6c4-460b-b466-8dcffc73a2c0.jpeg,http://localhost:8092/zxs/49858495-9773-4740-9e99-99c1268fea01.jpeg,http://localhost:8092/zxs/ed234f28-8d32-45f7-97bf-b2c55bdbb63d.jpeg', '2025-03-06 18:20:02', 0);
INSERT INTO `comments` VALUES (51, 11, '666', 11, 49, NULL, '2025-03-06 18:21:32', NULL);
INSERT INTO `comments` VALUES (52, 12, '哇哦', 11, 49, NULL, '2025-03-06 18:22:25', NULL);
INSERT INTO `comments` VALUES (53, 12, '这个书籍怎么看啊', NULL, 0, 'http://localhost:8092/zxs/c285b5a7-6ee6-4493-b79a-10dc62daa729.jpeg,http://localhost:8092/zxs/5540d6bd-03c4-46b7-aa26-f1d0e646f5ea.jpeg,http://localhost:8092/zxs/eb7ae1a1-18da-47ea-b4a9-55d004ee6612.png', '2025-03-06 18:22:56', 0);
INSERT INTO `comments` VALUES (54, 12, '今日书籍视频分享', NULL, 0, 'http://localhost:8092/zxs/c3b7b79c-0e48-4c59-9302-bad65a6c576d.mp4', '2025-03-06 18:23:21', 1);
INSERT INTO `comments` VALUES (55, 11, '666', 12, 54, NULL, '2025-03-07 00:14:44', NULL);

-- ----------------------------
-- Table structure for manage
-- ----------------------------
DROP TABLE IF EXISTS `manage`;
CREATE TABLE `manage`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '管理员编号',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `pass_word` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `photo_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manage
-- ----------------------------
INSERT INTO `manage` VALUES (1, 'admin', 'admin', 'http://localhost:8092/zxs/124e6c03-957d-4ac5-b456-95f6661bb57d.jpg', 'admin');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '公告编号',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `notice_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '封面图片',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简介',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态[0:隐藏,1:正常]',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 112 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '公告管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (109, '自习室预约小程序平台维护通知', 'http://localhost:8092/file/0a5a2559-74e1-465b-97d6-f45ac09791b1.jpg', '尊敬的用户：\n\n您好！\n\n为了给您提供更优质、高效、稳定的垃圾回收服务，我们将于[具体维护日期]对垃圾回收平台进行全面维护升级。在此期间，平台的各项功能将暂时无法正常使用，由此给您带来的不便，我们深表歉意。\n\n![zs.png](http://localhost:8092/ljhs/3fca7b62-4d8e-4147-8562-f784af8faa6b.png)\n\n此次维护主要涉及平台的系统优化、数据更新以及安全性能提升等方面。我们将对平台的数据库进行深度清理和整理，确保数据的准确性和完整性，同时修复已知的一些系统漏洞，增强平台的稳定性和安全性，保障您的信息安全和交易安全。\n\n在维护期间，您将无法通过平台提交垃圾回收订单、查询回收进度以及进行相关的账户操作等。请您提前做好安排，如有紧急的垃圾回收需求，可拨打我们的客服热线[电话号码]，我们将尽力为您提供线下协助解决方案。\n\n预计维护时间将持续[X]小时，我们将尽最大努力缩短维护时长，争取尽快完成维护工作并恢复平台的正常运行。维护完成后，平台将以全新的面貌为您服务，届时您将享受到更加流畅、便捷的操作体验，以及更丰富、精准的垃圾回收信息和服务。\n\n感谢您一直以来对垃圾回收平台的支持与理解，我们会持续努力，不断优化平台功能，为环保事业贡献更多力量，也期待在维护完成后继续为您提供优质的垃圾回收服务。\n\n[垃圾回收平台名称]\n\n[通知发布日期]', '系统维护公告', 1, '2025-02-17 08:10:30');
INSERT INTO `notice` VALUES (111, '健康活动活动报名', 'http://localhost:8092/file/4a72513e-2e4a-4dfe-8362-5fcdc80a007f.png', '公司将于2023年11月5日至11月10日举办环保公益活动。欢迎大家报名参加，共同为环境保护贡献力量。', '环保活动报名', 1, '2025-02-17 08:10:30');

-- ----------------------------
-- Table structure for seat
-- ----------------------------
DROP TABLE IF EXISTS `seat`;
CREATE TABLE `seat`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '座位编号',
  `hall_id` bigint(20) NULL DEFAULT NULL COMMENT '所属自习室',
  `qr_code` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '二维码图片',
  `status` int(11) NULL DEFAULT NULL COMMENT '当前状态[0:空闲,1:已预约,2:占用,3维修]',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '座位管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of seat
-- ----------------------------
INSERT INTO `seat` VALUES (2, '1001', 1, 'http://localhost:8092/zxs/82bb60da-f4ee-4df1-b01a-9d5901277a83.jpg', 1, '2025-03-06 14:29:55');
INSERT INTO `seat` VALUES (3, '1002', 1, '', 0, '2025-03-06 14:30:37');
INSERT INTO `seat` VALUES (4, '1003', 1, 'http://localhost:8092/zxs/6e0be5e4-c3f8-4230-a132-c15157855a9b.jpg', 0, '2025-03-06 14:30:44');
INSERT INTO `seat` VALUES (5, '1004', 1, 'http://localhost:8092/zxs/e41769fe-b3d4-4d99-9638-aa900c77b6e8.jpg', 0, '2025-03-06 14:30:50');
INSERT INTO `seat` VALUES (6, '1005', 1, NULL, 0, '2025-03-06 14:30:56');
INSERT INTO `seat` VALUES (7, '1006', 1, NULL, 0, '2025-03-06 14:31:01');
INSERT INTO `seat` VALUES (8, '1007', 1, NULL, 0, '2025-03-06 14:31:08');
INSERT INTO `seat` VALUES (9, '1008', 1, NULL, 0, '2025-03-06 14:31:26');
INSERT INTO `seat` VALUES (10, '1009', 1, NULL, 0, '2025-03-06 14:31:30');
INSERT INTO `seat` VALUES (11, '1010', 1, NULL, 0, '2025-03-06 14:31:34');
INSERT INTO `seat` VALUES (12, '2001', 2, NULL, 0, '2025-03-06 14:31:39');
INSERT INTO `seat` VALUES (13, '2002', 2, NULL, 0, '2025-03-06 14:31:43');
INSERT INTO `seat` VALUES (14, '2003', 2, NULL, 0, '2025-03-06 14:31:49');
INSERT INTO `seat` VALUES (15, '2004', 2, NULL, 0, '2025-03-06 14:31:54');
INSERT INTO `seat` VALUES (16, '2005', 2, NULL, 0, '2025-03-06 14:31:59');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '学生编号',
  `stu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生姓名',
  `stu_age` int(20) NULL DEFAULT NULL COMMENT '年龄',
  `stu_sex` int(20) NULL DEFAULT NULL COMMENT '性别[0:男,1:女]',
  `stu_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `stu_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家庭住址',
  `stu_class_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属班级',
  `stu_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '照片',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录密码',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态[0:待审核,1:可用,2:停用]',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学生表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (11, 'azhou', 26, 0, '10086', '湖南长沙', NULL, 'http://localhost:8092/zxs/c8cd50ac-1740-495a-a3c0-a2ab6f1de5a2.jpeg', 'azhou', 1);
INSERT INTO `student` VALUES (12, 'aneng', 28, 1, '10010', '广东深圳', NULL, 'http://localhost:8092/zxs/c67f6e15-4620-45e0-ac86-7e33a821a075.png', '123456', 1);

-- ----------------------------
-- Table structure for studyhall
-- ----------------------------
DROP TABLE IF EXISTS `studyhall`;
CREATE TABLE `studyhall`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自习室编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简介',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在位置',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态[0:正常,1:维修]',
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '封面图片',
  `num` int(11) NULL DEFAULT NULL COMMENT '座位数',
  `current_num` int(11) NULL DEFAULT NULL COMMENT '当前空闲',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `type_id` bigint(20) NULL DEFAULT NULL COMMENT '所属分类',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '自习室管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of studyhall
-- ----------------------------
INSERT INTO `studyhall` VALUES (1, '教学楼101自习室', '环境安静，适合单人学习', '第一教学楼1层', 0, 'http://localhost:8092/zxs/6df8889a-47cf-4b0c-9bf0-b08274a4adb3.png', 10, 9, '2024-09-01 08:00:00', 1);
INSERT INTO `studyhall` VALUES (2, '教学楼102自习室', '空间宽敞，采光良好', '第一教学楼1层', 0, 'http://localhost:8092/zxs/6df8889a-47cf-4b0c-9bf0-b08274a4adb3.png', 5, 5, '2024-09-02 09:00:00', 2);
INSERT INTO `studyhall` VALUES (3, '教学楼103自习室', '配备多媒体设备', '第一教学楼1层', 0, 'http://localhost:8092/zxs/6df8889a-47cf-4b0c-9bf0-b08274a4adb3.png', 0, 0, '2024-09-03 10:00:00', 3);
INSERT INTO `studyhall` VALUES (4, '教学楼201自习室', '位置隐蔽，不受干扰', '第二教学楼2层', 0, 'http://localhost:8092/zxs/6df8889a-47cf-4b0c-9bf0-b08274a4adb3.png', 0, 0, '2024-09-04 11:00:00', 1);
INSERT INTO `studyhall` VALUES (5, '教学楼202自习室', '桌椅舒适，学习氛围好', '第二教学楼2层', 0, 'http://localhost:8092/zxs/6df8889a-47cf-4b0c-9bf0-b08274a4adb3.png', 0, 0, '2024-09-05 12:00:00', 2);
INSERT INTO `studyhall` VALUES (6, '教学楼203自习室', '临近洗手间，方便使用', '第二教学楼2层', 0, 'http://localhost:8092/zxs/6df8889a-47cf-4b0c-9bf0-b08274a4adb3.png', 0, 0, '2024-09-06 13:00:00', 3);
INSERT INTO `studyhall` VALUES (7, '图书馆101自习室', '书籍资源丰富，便于查阅', '图书馆1层', 0, 'http://localhost:8092/zxs/6df8889a-47cf-4b0c-9bf0-b08274a4adb3.png', 0, 0, '2024-09-07 14:00:00', 1);
INSERT INTO `studyhall` VALUES (8, '图书馆102自习室', '有独立的阅读区域', '图书馆1层', 0, 'http://localhost:8092/zxs/6df8889a-47cf-4b0c-9bf0-b08274a4adb3.png', 0, 0, '2024-09-08 15:00:00', 2);
INSERT INTO `studyhall` VALUES (9, '图书馆103自习室', '可使用电子资源学习', '图书馆1层', 0, 'http://localhost:8092/zxs/6df8889a-47cf-4b0c-9bf0-b08274a4adb3.png', 0, 0, '2024-09-09 16:00:00', 3);
INSERT INTO `studyhall` VALUES (10, '图书馆201自习室', '安静且视野开阔', '图书馆2层', 0, 'http://localhost:8092/zxs/6df8889a-47cf-4b0c-9bf0-b08274a4adb3.png', 0, 0, '2024-09-10 17:00:00', 1);
INSERT INTO `studyhall` VALUES (11, '图书馆202自习室', '适合小组讨论学习', '图书馆2层', 0, 'http://localhost:8092/zxs/6df8889a-47cf-4b0c-9bf0-b08274a4adb3.png', 0, 0, '2024-09-11 18:00:00', 2);
INSERT INTO `studyhall` VALUES (12, '图书馆203自习室', '有充电设施，方便使用电子设备', '图书馆2层', 0, 'http://localhost:8092/zxs/6df8889a-47cf-4b0c-9bf0-b08274a4adb3.png', 0, 0, '2024-09-12 19:00:00', 3);
INSERT INTO `studyhall` VALUES (13, '书院A自习室', '书院氛围浓厚，同学交流方便', '书院A区', 0, 'http://localhost:8092/zxs/6df8889a-47cf-4b0c-9bf0-b08274a4adb3.png', 0, 0, '2024-09-13 20:00:00', 1);
INSERT INTO `studyhall` VALUES (14, '书院A自习室2', '环境温馨，适合长时间学习', '书院A区', 0, 'http://localhost:8092/zxs/6df8889a-47cf-4b0c-9bf0-b08274a4adb3.png', 0, 0, '2024-09-14 21:00:00', 2);
INSERT INTO `studyhall` VALUES (15, '书院B自习室', '靠近书院活动区，学习之余可参与活动', '书院B区', 0, 'http://localhost:8092/zxs/6df8889a-47cf-4b0c-9bf0-b08274a4adb3.png', 0, 0, '2024-09-15 22:00:00', 3);
INSERT INTO `studyhall` VALUES (16, '书院B自习室2', '采光好，空气流通', '书院B区', 0, 'http://localhost:8092/zxs/6df8889a-47cf-4b0c-9bf0-b08274a4adb3.png', 0, 0, '2024-09-16 23:00:00', 1);
INSERT INTO `studyhall` VALUES (17, '书院C自习室', '有专门的研讨区域', '书院C区', 0, 'http://localhost:8092/zxs/6df8889a-47cf-4b0c-9bf0-b08274a4adb3.png', 0, 0, '2024-09-17 00:00:00', 2);
INSERT INTO `studyhall` VALUES (18, '书院C自习室2', '装修风格独特，学习体验好', '书院C区', 0, 'http://localhost:8092/zxs/6df8889a-47cf-4b0c-9bf0-b08274a4adb3.png', 0, 0, '2024-09-18 01:00:00', 3);
INSERT INTO `studyhall` VALUES (19, '教学楼301自习室', '新装修，环境优美', '第三教学楼3层', 0, 'http://localhost:8092/zxs/6df8889a-47cf-4b0c-9bf0-b08274a4adb3.png', 0, 0, '2024-09-19 02:00:00', 1);
INSERT INTO `studyhall` VALUES (20, '教学楼302自习室', '配备智能学习设备', '第三教学楼3层', 0, 'http://localhost:8092/zxs/6df8889a-47cf-4b0c-9bf0-b08274a4adb3.png', 0, 0, '2024-09-20 03:00:00', 2);
INSERT INTO `studyhall` VALUES (21, '教学楼303自习室', '临近电梯，交通便利', '第三教学楼3层', 0, 'http://localhost:8092/zxs/6df8889a-47cf-4b0c-9bf0-b08274a4adb3.png', 0, 0, '2024-09-21 04:00:00', 3);
INSERT INTO `studyhall` VALUES (22, '图书馆301自习室', '安静私密，适合深度思考', '图书馆3层', 0, 'http://localhost:8092/zxs/6df8889a-47cf-4b0c-9bf0-b08274a4adb3.png', 0, 0, '2024-09-22 05:00:00', 1);
INSERT INTO `studyhall` VALUES (23, '图书馆302自习室', '可预约独立学习空间', '图书馆3层', 0, 'http://localhost:8092/zxs/6df8889a-47cf-4b0c-9bf0-b08274a4adb3.png', 0, 0, '2024-09-23 06:00:00', 2);
INSERT INTO `studyhall` VALUES (24, '图书馆303自习室', '有专业的学习指导服务', '图书馆3层', 0, 'http://localhost:8092/zxs/6df8889a-47cf-4b0c-9bf0-b08274a4adb3.png', 0, 0, '2024-09-24 07:00:00', 3);
INSERT INTO `studyhall` VALUES (25, '书院D自习室', '与书院导师交流方便', '书院D区', 0, 'http://localhost:8092/zxs/6df8889a-47cf-4b0c-9bf0-b08274a4adb3.png', 0, 0, '2024-09-25 08:00:00', 1);
INSERT INTO `studyhall` VALUES (26, '书院D自习室2', '有丰富的文化活动资源', '书院D区', 0, 'http://localhost:8092/zxs/6df8889a-47cf-4b0c-9bf0-b08274a4adb3.png', 0, 0, '2024-09-26 09:00:00', 2);
INSERT INTO `studyhall` VALUES (27, '书院E自习室', '靠近食堂，用餐方便', '书院E区', 0, 'http://localhost:8092/zxs/6df8889a-47cf-4b0c-9bf0-b08274a4adb3.png', 0, 0, '2024-09-27 10:00:00', 3);
INSERT INTO `studyhall` VALUES (28, '书院E自习室2', '环境优雅，宁静舒适', '书院E区', 0, 'http://localhost:8092/zxs/6df8889a-47cf-4b0c-9bf0-b08274a4adb3.png', 0, 0, '2024-09-28 11:00:00', 1);
INSERT INTO `studyhall` VALUES (29, '教学楼401自习室', '视野好，可俯瞰校园风景', '第四教学楼4层', 0, 'http://localhost:8092/zxs/6df8889a-47cf-4b0c-9bf0-b08274a4adb3.png', 0, 0, '2024-09-29 12:00:00', 2);
INSERT INTO `studyhall` VALUES (30, '教学楼402自习室', '有良好的隔音效果', '第四教学楼4层', 0, 'http://localhost:8092/zxs/6df8889a-47cf-4b0c-9bf0-b08274a4adb3.png', 0, 0, '2024-09-30 13:00:00', 3);

-- ----------------------------
-- Table structure for subscribe
-- ----------------------------
DROP TABLE IF EXISTS `subscribe`;
CREATE TABLE `subscribe`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `stu_id` bigint(20) NULL DEFAULT NULL COMMENT '学生编号',
  `hall_id` bigint(20) NULL DEFAULT NULL COMMENT '自习室编号',
  `seat_id` bigint(20) NULL DEFAULT NULL COMMENT '座位编号',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态[0:已预约,1:已签到,2:已取消]',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `sub_time` datetime(0) NULL DEFAULT NULL COMMENT '预约时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '预约管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subscribe
-- ----------------------------
INSERT INTO `subscribe` VALUES (4, 11, 1, 3, 2, '2025-03-06 18:00:22', '2025-03-07 10:00:00');
INSERT INTO `subscribe` VALUES (5, 11, 1, 2, 3, '2025-03-06 20:47:55', '2025-03-01 00:00:00');
INSERT INTO `subscribe` VALUES (6, 11, 1, 2, 0, '2025-03-07 00:14:28', '2025-08-09 00:00:00');

-- ----------------------------
-- Table structure for types
-- ----------------------------
DROP TABLE IF EXISTS `types`;
CREATE TABLE `types`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '分类编号',
  `type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '自习室分类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of types
-- ----------------------------
INSERT INTO `types` VALUES (1, '公共自习室', '2025-03-06 14:07:50');
INSERT INTO `types` VALUES (2, '专业自习室', '2025-03-06 14:07:57');
INSERT INTO `types` VALUES (3, '考研自习室', '2025-03-06 14:08:03');

SET FOREIGN_KEY_CHECKS = 1;
