/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50642
 Source Host           : localhost:3306
 Source Schema         : teach

 Target Server Type    : MySQL
 Target Server Version : 50642
 File Encoding         : 65001

 Date: 14/03/2021 13:14:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for foreign_practise
-- ----------------------------
DROP TABLE IF EXISTS `foreign_practise`;
CREATE TABLE `foreign_practise`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job_no` varchar(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '工号',
  `teacher_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '教师姓名',
  `position` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '职称',
  `education` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学历',
  `unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '单位',
  `course` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '主要课程',
  `class_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '主要班级',
  `student_amount` int(255) NULL DEFAULT NULL COMMENT '总人数',
  `place` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '开课地点',
  `teach_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '教学形式',
  `week_hour` int(6) NULL DEFAULT NULL COMMENT '周学时数',
  `weeks` int(4) NULL DEFAULT NULL COMMENT '上课周数',
  `start_date` date NULL DEFAULT NULL COMMENT '开始日期',
  `end_date` date NULL DEFAULT NULL COMMENT '结束日期',
  `class_hour` int(6) NULL DEFAULT NULL COMMENT '总课时',
  `inspect_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '考核方式',
  `result_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '成果形式',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '单课时费用',
  `total_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '总费用',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `teacher_id` int(11) NULL DEFAULT NULL COMMENT '教师id',
  `status` int(1) NULL DEFAULT 0 COMMENT '状态(0 待提交 ,1 待审核,2审核通过,3审核驳回)',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `commit_time` datetime(0) NULL DEFAULT NULL COMMENT '提交时间',
  `audit_time` datetime(0) NULL DEFAULT NULL COMMENT '审核时间',
  `manager_id` int(11) NULL DEFAULT NULL COMMENT '审核人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '外聘工作量汇总表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for foreign_teach
-- ----------------------------
DROP TABLE IF EXISTS `foreign_teach`;
CREATE TABLE `foreign_teach`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job_no` varchar(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '工号',
  `teacher_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '教师姓名',
  `position` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '职称',
  `education` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学历',
  `unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '单位',
  `course` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '主要课程',
  `class_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '主要班级',
  `student_amount` int(4) NULL DEFAULT NULL COMMENT '学生人数',
  `week_class_hour` int(6) NULL DEFAULT NULL COMMENT '周学时数',
  `week` int(4) NULL DEFAULT NULL COMMENT '上课周数',
  `class_hour` int(6) NULL DEFAULT NULL COMMENT '总课时数',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '单课时费用',
  `total_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '总费用',
  `teacher_id` int(11) NULL DEFAULT NULL COMMENT '教师id',
  `status` int(1) NULL DEFAULT 0 COMMENT '状态(0 待提交 ,1 待审核,2审核通过,3审核驳回)',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `commit_time` datetime(0) NULL DEFAULT NULL COMMENT '提交时间',
  `audit_time` datetime(0) NULL DEFAULT NULL COMMENT '审核时间',
  `manager_id` int(11) NULL DEFAULT NULL COMMENT '审核人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '外聘教师教学工作量统计表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for foreign_work
-- ----------------------------
DROP TABLE IF EXISTS `foreign_work`;
CREATE TABLE `foreign_work`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job_no` varchar(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '工号',
  `teacher_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '教师姓名',
  `position` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '职称',
  `education` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学历',
  `unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '单位',
  `course` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '主要课程',
  `class_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '主要班级',
  `class_hour` int(6) NULL DEFAULT NULL COMMENT '总课时',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '单课时费用',
  `total_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '总费用',
  `teacher_id` int(11) NULL DEFAULT NULL COMMENT '教师id',
  `status` int(1) NULL DEFAULT 0 COMMENT '状态(0 待提交 ,1 待审核,2审核通过,3审核驳回)',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `commit_time` datetime(0) NULL DEFAULT NULL COMMENT '提交时间',
  `audit_time` datetime(0) NULL DEFAULT NULL COMMENT '审核时间',
  `manager_id` int(11) NULL DEFAULT NULL COMMENT '审核人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '外聘工作量汇总表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账户名称',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `job_no` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工号',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色id',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '状态',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台管理员' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES (1, '111', '7fa8282ad93047a4d6fe6111c93b308a', 'ML', '111', 1, 1, '2019-08-14 15:48:32');
INSERT INTO `manager` VALUES (5, '222', '7fa8282ad93047a4d6fe6111c93b308a', 'dfasss', '222', 2, 1, '2021-03-14 12:30:41');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NULL DEFAULT 0 COMMENT '父id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `level` tinyint(1) NULL DEFAULT NULL COMMENT '菜单级别',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '跳转路径',
  `is_leaf` tinyint(1) NULL DEFAULT 0 COMMENT '是否叶子节点',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 86 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (5, 0, '教学业绩点统计', 1, 'layui-icon-form', NULL, 0);
INSERT INTO `menu` VALUES (6, 0, '外聘工作量统计', 1, 'layui-icon-form', NULL, 0);
INSERT INTO `menu` VALUES (7, 0, '系统管理', 1, 'layui-icon-form', NULL, 0);
INSERT INTO `menu` VALUES (8, 5, '实践环节业业绩点统计', 2, 'layui-icon-form', NULL, 0);
INSERT INTO `menu` VALUES (51, 5, '教师教学工作量汇总表', 2, NULL, '/modelView/teach/teaching', 1);
INSERT INTO `menu` VALUES (52, 5, '课堂教学及评卷业绩点统计表', 2, NULL, '/modelView/teach/course', 1);
INSERT INTO `menu` VALUES (53, 5, '监考听课业绩点统计表', 2, NULL, '/modelView/teach/exam', 1);
INSERT INTO `menu` VALUES (54, 5, '教学改革增量业绩点统计表', 2, NULL, '/modelView/teach/revolution', 1);
INSERT INTO `menu` VALUES (55, 5, '实践环节业绩点统计表', 2, NULL, '', 1);
INSERT INTO `menu` VALUES (61, 6, '外聘工作量汇总表', 2, NULL, '/modelView/foreign/work', 1);
INSERT INTO `menu` VALUES (62, 6, '外聘教学工作量统计表', 2, NULL, '/modelView/foreign/teach', 1);
INSERT INTO `menu` VALUES (63, 6, '外聘课程实践工作量统计表', 2, NULL, '/modelView/foreign/practice', 1);
INSERT INTO `menu` VALUES (71, 7, '角色列表', 2, NULL, '/modelView/system/role', 1);
INSERT INTO `menu` VALUES (72, 7, '人员列表', 2, NULL, '/modelView/system/manager', 1);
INSERT INTO `menu` VALUES (81, 8, '毕业论文、学年论文、创新创业训练计划项目业绩点', 3, NULL, '/modelView/teach/practice/paper', 1);
INSERT INTO `menu` VALUES (82, 8, '课程设计、项目课程业绩点统计表', 3, NULL, '/modelView/teach/practice/course', 1);
INSERT INTO `menu` VALUES (83, 8, '专业学科竞赛业绩点统计表', 3, NULL, '/modelView/teach/practice/competition', 1);
INSERT INTO `menu` VALUES (84, 8, '实习见习考察业绩点清单', 3, NULL, '/modelView/teach/practice/inspect', 1);
INSERT INTO `menu` VALUES (85, 8, '实习见习考察写生等实践除外业绩点汇总表', 3, NULL, '/modelView/teach/practice/other', 1);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `operate_time` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '管理员', '管理员', '2021-03-05 15:45:18');
INSERT INTO `role` VALUES (2, '教师', '教师', '2021-03-05 15:45:07');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色id',
  `menu_id` int(11) NULL DEFAULT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 171 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色_菜单' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES (67, 1, 5);
INSERT INTO `role_menu` VALUES (68, 1, 6);
INSERT INTO `role_menu` VALUES (69, 1, 7);
INSERT INTO `role_menu` VALUES (70, 1, 8);
INSERT INTO `role_menu` VALUES (71, 1, 51);
INSERT INTO `role_menu` VALUES (72, 1, 52);
INSERT INTO `role_menu` VALUES (73, 1, 53);
INSERT INTO `role_menu` VALUES (74, 1, 54);
INSERT INTO `role_menu` VALUES (75, 1, 55);
INSERT INTO `role_menu` VALUES (76, 1, 61);
INSERT INTO `role_menu` VALUES (77, 1, 62);
INSERT INTO `role_menu` VALUES (78, 1, 63);
INSERT INTO `role_menu` VALUES (79, 1, 71);
INSERT INTO `role_menu` VALUES (80, 1, 72);
INSERT INTO `role_menu` VALUES (81, 1, 81);
INSERT INTO `role_menu` VALUES (82, 1, 82);
INSERT INTO `role_menu` VALUES (83, 1, 83);
INSERT INTO `role_menu` VALUES (84, 1, 84);
INSERT INTO `role_menu` VALUES (85, 1, 85);
INSERT INTO `role_menu` VALUES (155, 2, 51);
INSERT INTO `role_menu` VALUES (156, 2, 52);
INSERT INTO `role_menu` VALUES (157, 2, 53);
INSERT INTO `role_menu` VALUES (158, 2, 54);
INSERT INTO `role_menu` VALUES (159, 2, 55);
INSERT INTO `role_menu` VALUES (160, 2, 81);
INSERT INTO `role_menu` VALUES (161, 2, 82);
INSERT INTO `role_menu` VALUES (162, 2, 83);
INSERT INTO `role_menu` VALUES (163, 2, 84);
INSERT INTO `role_menu` VALUES (164, 2, 85);
INSERT INTO `role_menu` VALUES (165, 2, 61);
INSERT INTO `role_menu` VALUES (166, 2, 62);
INSERT INTO `role_menu` VALUES (167, 2, 63);
INSERT INTO `role_menu` VALUES (168, 2, 5);
INSERT INTO `role_menu` VALUES (169, 2, 6);
INSERT INTO `role_menu` VALUES (170, 2, 8);

-- ----------------------------
-- Table structure for teach_course
-- ----------------------------
DROP TABLE IF EXISTS `teach_course`;
CREATE TABLE `teach_course`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job_no` varchar(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '工号',
  `teacher_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '教师姓名',
  `course_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '课程名称',
  `class_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '上课班级',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类别(1,课堂;2,课程实践;3,实验课)',
  `course_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '课程类型(1,理科专业理论课;2,文科专业理论课;3,通识教育必修理论课;4,通识教育必修大学英语课;5,理工类实验课;6,通识教育必修大学体育课;7,音乐技巧课;8,美术技巧课;9,体育技能课;10,通识教育选修课;11,外语专业课)\r\n',
  `special_course` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '特殊课程(1,专科专业;2,双语课程;3,网络在线开放课;4,外语听力课;5,计算机上机课;6,无)',
  `week_hour` int(6) NULL DEFAULT NULL COMMENT '周学时数',
  `weeks` int(4) NULL DEFAULT NULL COMMENT '上课周数',
  `original_class_hour` int(6) NULL DEFAULT NULL COMMENT '原始总课时数',
  `student_amount` int(4) NULL DEFAULT NULL COMMENT '选课学生人数',
  `class_coefficient` decimal(10, 2) NULL DEFAULT NULL COMMENT '分班系数',
  `course_coefficient` decimal(10, 2) NULL DEFAULT NULL COMMENT '课程系数',
  `teach_result_coefficient` decimal(10, 2) NULL DEFAULT NULL COMMENT '教学结果系数(1,1.05;2,1;3,0)',
  `course_teach_poing` decimal(10, 2) NULL DEFAULT NULL COMMENT '课堂教学业绩点\r\n',
  `inspect_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '考核类型(1,考试;2,考查;3,无)',
  `inspect_type_coefficient` decimal(10, 2) NULL DEFAULT NULL COMMENT '考核类型系数(1,2.5;2,1;3,0)\r\n',
  `mark_exam_point` decimal(10, 2) NULL DEFAULT NULL COMMENT '评卷业绩点',
  `teacher_id` int(11) NULL DEFAULT NULL COMMENT '教师id',
  `status` int(1) NULL DEFAULT 0 COMMENT '状态(0 待提交 ,1 待审核,2审核通过,3审核驳回)',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `commit_time` datetime(0) NULL DEFAULT NULL COMMENT '提交时间',
  `audit_time` datetime(0) NULL DEFAULT NULL COMMENT '审核时间',
  `manager_id` int(11) NULL DEFAULT NULL COMMENT '审核人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '课堂教学及评卷业绩点统计表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for teach_exam
-- ----------------------------
DROP TABLE IF EXISTS `teach_exam`;
CREATE TABLE `teach_exam`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job_no` varchar(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '工号',
  `teacher_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '教师姓名',
  `exam_first_exam_amount` int(4) NULL DEFAULT NULL COMMENT '上半年监考场次',
  `exam_first_inspect_point` decimal(10, 2) NULL DEFAULT NULL COMMENT '上半年监考业绩点',
  `exam_second_exam_amount` int(4) NULL DEFAULT NULL COMMENT '下半年监考场次',
  `exam_second_inspect_point` decimal(10, 2) NULL DEFAULT NULL COMMENT '下半年监考业绩点',
  `listen_first_listen_amount` int(4) NULL DEFAULT NULL COMMENT '上半年听课场次',
  `listen_first_listen_point` decimal(10, 2) NULL DEFAULT NULL COMMENT '上半年听课业绩点',
  `listen_second_listen_amount` int(4) NULL DEFAULT NULL COMMENT '下半年听课场次',
  `listen_second_listen_point` decimal(10, 2) NULL DEFAULT NULL COMMENT '下半年听课业绩点',
  `teacher_id` int(11) NULL DEFAULT NULL COMMENT '教师id',
  `status` int(1) NULL DEFAULT 0 COMMENT '状态(0 待提交 ,1 待审核,2审核通过,3审核驳回)',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `commit_time` datetime(0) NULL DEFAULT NULL COMMENT '提交时间',
  `audit_time` datetime(0) NULL DEFAULT NULL COMMENT '审核时间',
  `manager_id` int(11) NULL DEFAULT NULL COMMENT '审核人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '监考听课业绩点统计表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for teach_practise_competition
-- ----------------------------
DROP TABLE IF EXISTS `teach_practise_competition`;
CREATE TABLE `teach_practise_competition`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job_no` varchar(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '工号',
  `teacher_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '教师姓名',
  `competition_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '专业学科竞赛名称',
  `competition_level` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '指导专业学科竞赛级别(1,省级;2,国家级)',
  `competition_amount` int(6) NULL DEFAULT NULL COMMENT '指导专业学科竞赛参赛人数',
  `competition_point` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '指导专业学科竞赛业绩点',
  `teacher_id` int(11) NULL DEFAULT NULL COMMENT '教师id',
  `status` int(1) NULL DEFAULT 0 COMMENT '状态(0 待提交 ,1 待审核,2审核通过,3审核驳回)',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `commit_time` datetime(0) NULL DEFAULT NULL COMMENT '提交时间',
  `audit_time` datetime(0) NULL DEFAULT NULL COMMENT '审核时间',
  `manager_id` int(11) NULL DEFAULT NULL COMMENT '审核人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '实践环节专业学科竞赛业绩点统计表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for teach_practise_course
-- ----------------------------
DROP TABLE IF EXISTS `teach_practise_course`;
CREATE TABLE `teach_practise_course`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job_no` varchar(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '工号',
  `teacher_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '教师姓名',
  `course_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '课程设计/项目课程名称',
  `credit` int(4) NULL DEFAULT NULL COMMENT '学分',
  `course_hour` int(6) NULL DEFAULT NULL COMMENT '学时（或折合学时）(1学分折合16学时\r)',
  `class_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学生对象（班级名称）',
  `student_amount` int(11) NULL DEFAULT NULL COMMENT '课程设计/项目课程学生人数',
  `course_coefficient` decimal(10, 2) NULL DEFAULT NULL COMMENT '课程设计/项目课程的系数(=0.05*学生人数。当0.05*学生人数>2时，取值为2\r)',
  `course_point` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '课程设计/项目课程业绩点(学时*系数)',
  `teacher_id` int(11) NULL DEFAULT NULL COMMENT '教师id',
  `status` int(1) NULL DEFAULT 0 COMMENT '状态(0 待提交 ,1 待审核,2审核通过,3审核驳回)',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `commit_time` datetime(0) NULL DEFAULT NULL COMMENT '提交时间',
  `audit_time` datetime(0) NULL DEFAULT NULL COMMENT '审核时间',
  `manager_id` int(11) NULL DEFAULT NULL COMMENT '审核人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '实践环节课程设计/项目课程等业绩点统计表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for teach_practise_inspect
-- ----------------------------
DROP TABLE IF EXISTS `teach_practise_inspect`;
CREATE TABLE `teach_practise_inspect`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job_no` varchar(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '工号',
  `teacher_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '教师姓名',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '实习/见习/考察等名称(1,教育实习;2,专业实习;3,教育见习;4,专业见习;5,考察;6,写生)',
  `score` decimal(10, 2) NULL DEFAULT NULL COMMENT '学分',
  `class_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '实习学生对象（班级名称）',
  `student` int(4) NULL DEFAULT NULL COMMENT '指导实习/见习/考察等人数',
  `coefficient` decimal(10, 2) NULL DEFAULT NULL COMMENT '实习/见习/考察/写生等系数',
  `point` decimal(10, 2) NULL DEFAULT NULL COMMENT '指导实习/见习/考察/写生等业绩点',
  `teacher_id` int(11) NULL DEFAULT NULL COMMENT '教师id',
  `status` int(1) NULL DEFAULT 0 COMMENT '状态(0 待提交 ,1 待审核,2审核通过,3审核驳回)',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `commit_time` datetime(0) NULL DEFAULT NULL COMMENT '提交时间',
  `audit_time` datetime(0) NULL DEFAULT NULL COMMENT '审核时间',
  `manager_id` int(11) NULL DEFAULT NULL COMMENT '审核人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '实践环节专业学科竞赛业绩点统计表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for teach_practise_other
-- ----------------------------
DROP TABLE IF EXISTS `teach_practise_other`;
CREATE TABLE `teach_practise_other`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job_no` varchar(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '工号',
  `teacher_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '教师姓名',
  `first_graduation_point` decimal(10, 2) NULL DEFAULT NULL COMMENT '上半年指导毕业论文业绩点',
  `first_year_point` decimal(10, 2) NULL DEFAULT NULL COMMENT '上半年指导学年论文业绩点',
  `first_revolution_point` decimal(10, 2) NULL DEFAULT NULL COMMENT '上半年指导创新创业训练业绩点',
  `first_course_point` decimal(10, 2) NULL DEFAULT NULL COMMENT '上半年课程设计/项目课程业绩点',
  `first_practise_point` decimal(10, 2) NULL DEFAULT NULL COMMENT '上半年实践环节业绩点合计(指导创新创业训练业绩点+课程设计/项目课程业绩点+指导实习/见习/考察/写生等业绩点+指导专业学科竞赛业绩点\r)',
  `second_graduation_point` decimal(10, 2) NULL DEFAULT NULL COMMENT '下半年指导毕业论文业绩点',
  `second_year_point` decimal(10, 2) NULL DEFAULT NULL COMMENT '下半年指导学年论文业绩点',
  `second_revolution_point` decimal(10, 2) NULL DEFAULT NULL COMMENT '下半年指导创新创业训练业绩点',
  `second_course_point` decimal(10, 2) NULL DEFAULT NULL COMMENT '下半年课程设计/项目课程业绩点',
  `second_practise_point` decimal(10, 2) NULL DEFAULT NULL COMMENT '下半年实践环节业绩点合计(指导创新创业训练业绩点+课程设计/项目课程业绩点+指导实习/见习/考察/写生等业绩点+指导专业学科竞赛业绩点\r)',
  `total_point` decimal(10, 2) NULL DEFAULT NULL COMMENT '全年合计',
  `teacher_id` int(11) NULL DEFAULT NULL COMMENT '教师id',
  `status` int(1) NULL DEFAULT 0 COMMENT '状态(0 待提交 ,1 待审核,2审核通过,3审核驳回)',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `commit_time` datetime(0) NULL DEFAULT NULL COMMENT '提交时间',
  `audit_time` datetime(0) NULL DEFAULT NULL COMMENT '审核时间',
  `manager_id` int(11) NULL DEFAULT NULL COMMENT '审核人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '实践环节专业学科竞赛业绩点统计表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for teach_practise_paper
-- ----------------------------
DROP TABLE IF EXISTS `teach_practise_paper`;
CREATE TABLE `teach_practise_paper`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job_no` varchar(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '工号',
  `teacher_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '教师姓名',
  `link_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '环节类型(1,指导创新创业训练;2,指导毕业论文;3,指导学年论文)',
  `class_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学生对象（班级名称）',
  `student_amount` int(6) NULL DEFAULT NULL COMMENT '指导毕业论文人数',
  `design_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '毕业设计类型',
  `paper_point` decimal(10, 2) NULL DEFAULT NULL COMMENT '指导毕业论文业绩点',
  `paper_student_amount` int(11) NULL DEFAULT NULL COMMENT '指导学年论文人数',
  `total_paper_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '指导学年论文业绩点',
  `innovative_level` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '指导创新创业训练级别(1,国家级立项;2,校级一等奖;3,校级二等奖;4,校级三等奖;5,校级结项)',
  `innovative_point` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '指导创新创业训练业绩点',
  `teacher_id` int(11) NULL DEFAULT NULL COMMENT '教师id',
  `status` int(1) NULL DEFAULT 0 COMMENT '状态(0 待提交 ,1 待审核,2审核通过,3审核驳回)',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `commit_time` datetime(0) NULL DEFAULT NULL COMMENT '提交时间',
  `audit_time` datetime(0) NULL DEFAULT NULL COMMENT '审核时间',
  `manager_id` int(11) NULL DEFAULT NULL COMMENT '审核人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '实践环节毕业论文、学年论文、创新创业训练计划项目等业绩点统计表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for teach_revolution
-- ----------------------------
DROP TABLE IF EXISTS `teach_revolution`;
CREATE TABLE `teach_revolution`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型(1,教学改革项目类;2,新专业申报建设;3,安师讲坛;4,政治理论报告;5,教研成果类)',
  `course` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '本科教学工程类别(1,专业综合改革试点;2,人才培养模式改革试点;3,卓越计划项目;4,专业核心课程示范群;5,精品资源共享课;7精品视频公开课;8,双语教学示范课\r\n教学团队;9,大学生校外实践基地;10,实验教学示范中心;11,精品在线开放课程;12,基层教学组织;13,特色专业\r\n教学研究项目;14,教学成果奖;15,虚拟仿真实验教学中心;16,无)',
  `level` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '级别(1,国家级;2,省级;3,地厅级;4,校级)',
  `project_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '项目名称',
  `approval_date` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '立项年月',
  `build_period` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '建设周期',
  `year_finish_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '年度建设任务完成情况(1,是;2,否)',
  `project_build_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '项目建设情况(1,在建;2,结项)',
  `charge_man` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '项目负责人',
  `year_point` decimal(10, 2) NULL DEFAULT NULL COMMENT '当年业绩点',
  `project_point` decimal(10, 2) NULL DEFAULT NULL COMMENT '本项目总业绩点',
  `teacher_id` int(11) NULL DEFAULT NULL COMMENT '教师id',
  `status` int(1) NULL DEFAULT 0 COMMENT '状态(0 待提交 ,1 待审核,2审核通过,3审核驳回)',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `commit_time` datetime(0) NULL DEFAULT NULL COMMENT '提交时间',
  `audit_time` datetime(0) NULL DEFAULT NULL COMMENT '审核时间',
  `manager_id` int(11) NULL DEFAULT NULL COMMENT '审核人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '教学改革增量业绩点统计表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for teach_teaching
-- ----------------------------
DROP TABLE IF EXISTS `teach_teaching`;
CREATE TABLE `teach_teaching`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job_no` varchar(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '工号',
  `teacher_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '教师姓名',
  `first_teach_point` decimal(10, 2) NULL DEFAULT NULL COMMENT '上半年课堂教学业绩点',
  `first_inspect_point` decimal(10, 2) NULL DEFAULT NULL COMMENT '上半年监考业绩点',
  `first_other_point` decimal(10, 2) NULL DEFAULT NULL COMMENT '上半年实践教学业绩点',
  `first_total_point` decimal(10, 2) NULL DEFAULT NULL COMMENT '上半年合计业绩点',
  `second_teach_point` decimal(10, 2) NULL DEFAULT NULL COMMENT '下半年课堂教学业绩点',
  `second_inspect_point` decimal(10, 2) NULL DEFAULT NULL COMMENT '下半年监考业绩点',
  `second_other_point` decimal(10, 2) NULL DEFAULT NULL COMMENT '下半年实践教学业绩点',
  `second_total_point` decimal(10, 2) NULL DEFAULT NULL COMMENT '下半年合计业绩点',
  `total_point` decimal(10, 2) NULL DEFAULT NULL COMMENT '全年合计业绩点',
  `teacher_id` int(11) NULL DEFAULT NULL COMMENT '教师id',
  `status` int(1) NULL DEFAULT 0 COMMENT '状态(0 待提交 ,1 待审核,2审核通过,3审核驳回)',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `commit_time` datetime(0) NULL DEFAULT NULL COMMENT '提交时间',
  `audit_time` datetime(0) NULL DEFAULT NULL COMMENT '审核时间',
  `manager_id` int(11) NULL DEFAULT NULL COMMENT '审核人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '教师教学工作量汇总表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of teach_teaching
-- ----------------------------
INSERT INTO `teach_teaching` VALUES (8, '111', 'ML', 1.00, 1.00, 1.00, 3.00, 1.00, 1.00, 1.00, 3.00, 6.00, 1, 0, '2021-03-14 13:03:11', NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
