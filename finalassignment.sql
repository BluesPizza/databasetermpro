/*
 Navicat Premium Data Transfer

 Source Server         : MySQLassignment
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : finalassignment

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 26/05/2022 23:50:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for accommodation
-- ----------------------------
DROP TABLE IF EXISTS `accommodation`;
CREATE TABLE `accommodation`  (
  `scheduleID3` int(0) NOT NULL,
  `hotelID` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`scheduleID3`) USING BTREE,
  INDEX `hotelID`(`hotelID`) USING BTREE,
  CONSTRAINT `hotelID` FOREIGN KEY (`hotelID`) REFERENCES `hotel` (`hotelID`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `scheduleID3` FOREIGN KEY (`scheduleID3`) REFERENCES `schedule` (`scheduleID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of accommodation
-- ----------------------------
INSERT INTO `accommodation` VALUES (1, 1);
INSERT INTO `accommodation` VALUES (2, 1);

-- ----------------------------
-- Table structure for guide
-- ----------------------------
DROP TABLE IF EXISTS `guide`;
CREATE TABLE `guide`  (
  `guideID` int(0) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(0) NULL DEFAULT NULL,
  `gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `IDnum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rank` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`guideID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of guide
-- ----------------------------
INSERT INTO `guide` VALUES (1, '人类1', 21, '男', '00001', '13658589595', 5);
INSERT INTO `guide` VALUES (2, '人类2', 20, '男', '00002', '13658547859', 5);
INSERT INTO `guide` VALUES (3, '人类3', 20, '男', '00003', '13245698745', 5);
INSERT INTO `guide` VALUES (4, '人类4', 20, '男', '00004', '13526547895', 5);
INSERT INTO `guide` VALUES (5, '人类5', 18, '男', '10000', '12345678912', 5);
INSERT INTO `guide` VALUES (6, '人类6', 24, '男', '00005', '13658585757', 5);
INSERT INTO `guide` VALUES (7, '人类7', 55, '男', '00000', '13695854658', 5);
INSERT INTO `guide` VALUES (8, '人类8', 74, '男', '10001', '13658589598', 5);
INSERT INTO `guide` VALUES (9, '人类9', 18, '女', '00006', '13569595698', 5);
INSERT INTO `guide` VALUES (10, '雪之下雪乃', 19, '女', '00007', '15965958785', 5);
INSERT INTO `guide` VALUES (11, '人类10', 18, '女', '00008', '13658745968', 5);

-- ----------------------------
-- Table structure for hotel
-- ----------------------------
DROP TABLE IF EXISTS `hotel`;
CREATE TABLE `hotel`  (
  `hotelID` int(0) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rank` int(0) NULL DEFAULT NULL,
  `standard_price` decimal(10, 2) NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`hotelID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hotel
-- ----------------------------
INSERT INTO `hotel` VALUES (1, '专家公寓', '天津市', 5, 114514.00, '147258369', '津南区1919号');
INSERT INTO `hotel` VALUES (2, '会员制餐厅', '下北泽', 5, 114514.00, '19878451258', '下北泽林擒路810号');

-- ----------------------------
-- Table structure for insurance
-- ----------------------------
DROP TABLE IF EXISTS `insurance`;
CREATE TABLE `insurance`  (
  `insuranceID` int(0) NOT NULL,
  `teamID1` int(0) NULL DEFAULT NULL,
  `premium` decimal(10, 2) NULL DEFAULT NULL,
  `date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`insuranceID`) USING BTREE,
  INDEX `teamID1`(`teamID1`) USING BTREE,
  CONSTRAINT `teamID1` FOREIGN KEY (`teamID1`) REFERENCES `team` (`teamID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of insurance
-- ----------------------------
INSERT INTO `insurance` VALUES (1, 1, 810.00, '1919-08-10');
INSERT INTO `insurance` VALUES (2, 2, 1919.00, '1919-08-10');

-- ----------------------------
-- Table structure for leading
-- ----------------------------
DROP TABLE IF EXISTS `leading`;
CREATE TABLE `leading`  (
  `scheduleID2` int(0) NULL DEFAULT NULL,
  `guideID` int(0) NOT NULL,
  `guideID1` int(0) NULL DEFAULT NULL COMMENT '需要和guideID始终保持一致',
  PRIMARY KEY (`guideID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of leading
-- ----------------------------
INSERT INTO `leading` VALUES (1, 1, 1);
INSERT INTO `leading` VALUES (2, 2, 2);
INSERT INTO `leading` VALUES (3, 3, 3);
INSERT INTO `leading` VALUES (4, 4, 4);
INSERT INTO `leading` VALUES (5, 5, 5);
INSERT INTO `leading` VALUES (6, 6, 6);
INSERT INTO `leading` VALUES (NULL, 7, 7);
INSERT INTO `leading` VALUES (8, 9, 9);
INSERT INTO `leading` VALUES (9, 10, 10);
INSERT INTO `leading` VALUES (NULL, 11, 11);

-- ----------------------------
-- Table structure for route
-- ----------------------------
DROP TABLE IF EXISTS `route`;
CREATE TABLE `route`  (
  `routeID` int(0) NOT NULL,
  `starting` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '起点',
  `terminal` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '终点',
  `day` int(0) NULL DEFAULT NULL COMMENT '用时',
  `scenic_point` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`routeID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of route
-- ----------------------------
INSERT INTO `route` VALUES (1, '南开大学津南校区', '南开大学八里台校区', 6, '津南图书馆-八里台主楼');
INSERT INTO `route` VALUES (2, '南开大学八里台校区', '南开大学津南校区', 1, '津南图书馆-八里台主楼');
INSERT INTO `route` VALUES (3, '天津南开大学', '成都青城山', 4, '津南图书馆-青城山');
INSERT INTO `route` VALUES (4, '天津滨海国际机场', '成都双流机场', 10, '九寨沟-天津之眼');
INSERT INTO `route` VALUES (5, '北京天安门', '天津南开大学', 1, '天安门-南开图书馆');

-- ----------------------------
-- Table structure for schedule
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule`  (
  `scheduleID` int(0) NOT NULL AUTO_INCREMENT,
  `routeID` int(0) NULL DEFAULT NULL,
  `departure_date` int(0) NULL DEFAULT NULL COMMENT '出发日期 格式YYYY-MM-DD',
  `return_date` int(0) NULL DEFAULT NULL COMMENT '返程日期',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '报价',
  PRIMARY KEY (`scheduleID`) USING BTREE,
  INDEX `routeID`(`routeID`) USING BTREE,
  CONSTRAINT `routeID` FOREIGN KEY (`routeID`) REFERENCES `route` (`routeID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of schedule
-- ----------------------------
INSERT INTO `schedule` VALUES (1, 1, 20220519, 20220525, 114514.00);
INSERT INTO `schedule` VALUES (2, 2, 20220609, 20220610, 114514.00);
INSERT INTO `schedule` VALUES (3, 3, 20220609, 20220613, 114514.00);
INSERT INTO `schedule` VALUES (4, 1, 20220609, 20220615, 114514.00);
INSERT INTO `schedule` VALUES (5, 1, 20220609, 20220615, 114514.00);
INSERT INTO `schedule` VALUES (6, 2, 20220609, 20220610, 114514.00);
INSERT INTO `schedule` VALUES (7, 1, 20220609, 20220615, 114514.00);

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team`  (
  `teamID` int(0) NOT NULL,
  `scheduleID` int(0) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `count` int(0) NULL DEFAULT NULL,
  `leader` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`teamID`) USING BTREE,
  INDEX `scheduleID`(`scheduleID`) USING BTREE,
  CONSTRAINT `scheduleID` FOREIGN KEY (`scheduleID`) REFERENCES `schedule` (`scheduleID`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of team
-- ----------------------------
INSERT INTO `team` VALUES (1, 1, '啊对对队', 4, '人类1', '13695987458');
INSERT INTO `team` VALUES (2, 2, '对不队', 10, '人类2', '15488956325');

-- ----------------------------
-- Table structure for tourist
-- ----------------------------
DROP TABLE IF EXISTS `tourist`;
CREATE TABLE `tourist`  (
  `touristID` int(0) NOT NULL,
  `teamID` int(0) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(0) NULL DEFAULT NULL,
  `gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `IDnum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`touristID`) USING BTREE,
  INDEX `teamID`(`teamID`) USING BTREE,
  CONSTRAINT `teamID` FOREIGN KEY (`teamID`) REFERENCES `team` (`teamID`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tourist
-- ----------------------------
INSERT INTO `tourist` VALUES (1, 1, '人类1', 20, '男', '12345', '13695847852');
INSERT INTO `tourist` VALUES (2, 1, '人类2', 20, '男', '12346', '13655899787');
INSERT INTO `tourist` VALUES (3, 1, '人类3', 20, '男', '12347', '13698785852');
INSERT INTO `tourist` VALUES (4, 1, '人类4', 20, '男', '12348', '13698596585');
INSERT INTO `tourist` VALUES (5, 2, '人类5', 24, '男', '12349', '12595636975');

-- ----------------------------
-- Table structure for transportation
-- ----------------------------
DROP TABLE IF EXISTS `transportation`;
CREATE TABLE `transportation`  (
  `scheduleID1` int(0) NOT NULL,
  `departure_trans` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `departure_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出发时间 格式 HH:MM:SS',
  `return_trans` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `return_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '返程时间',
  PRIMARY KEY (`scheduleID1`) USING BTREE,
  CONSTRAINT `scheduleID1` FOREIGN KEY (`scheduleID1`) REFERENCES `schedule` (`scheduleID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of transportation
-- ----------------------------
INSERT INTO `transportation` VALUES (1, '火车', '2020-01-05', '飞机', '2020-01-06');
INSERT INTO `transportation` VALUES (2, '火车', '2020-10-06', '飞机', '2020-10-07');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `ID` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Pass` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('root', 'root');

-- ----------------------------
-- View structure for fastqueryview
-- ----------------------------
DROP VIEW IF EXISTS `fastqueryview`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `fastqueryview` AS select `tourist`.`name` AS `touristname`,`team`.`name` AS `teamname`,`schedule`.`scheduleID` AS `scheduleID`,`route`.`routeID` AS `routeID` from (((`tourist` join `team` on((`tourist`.`teamID` = `team`.`teamID`))) join `schedule` on((`team`.`scheduleID` = `schedule`.`scheduleID`))) join `route` on((`schedule`.`routeID` = `route`.`routeID`)));

-- ----------------------------
-- Procedure structure for my_process
-- ----------------------------
DROP PROCEDURE IF EXISTS `my_process`;
delimiter ;;
CREATE PROCEDURE `my_process`(IN IDroute INT, IN Days INT, IN starting1 VARCHAR(255), IN terminal1 VARCHAR(255), IN scenic VARCHAR(255))
BEGIN
DECLARE msg char(20);
IF Days<=0 or Days>30 THEN
SET msg = "数据错误";
SIGNAL SQLSTATE 'HY000' SET MESSAGE_TEXT = msg;
ELSE
UPDATE `route` set `route`.`day`=Days, `route`.`starting`=`starting1`, `route`.scenic_point=scenic, `route`.terminal=terminal1 WHERE `route`.routeID=IDroute;
UPDATE `schedule` set `schedule`.return_date = `schedule`.departure_date+Days where `schedule`.routeID=IDroute;
END IF; 
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table guide
-- ----------------------------
DROP TRIGGER IF EXISTS `my_trigger`;
delimiter ;;
CREATE TRIGGER `my_trigger` BEFORE INSERT ON `guide` FOR EACH ROW begin
DECLARE msg char(20);
IF new.age>80 or new.age<=17 or new.rank<=0 or new.rank>5 THEN
SET msg = "数据错误";
SIGNAL SQLSTATE 'HY000' SET MESSAGE_TEXT = msg;
END IF; 
end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table guide
-- ----------------------------
DROP TRIGGER IF EXISTS `my_trigger1`;
delimiter ;;
CREATE TRIGGER `my_trigger1` AFTER INSERT ON `guide` FOR EACH ROW begin
INSERT INTO `leading` VALUES(NULL,new.guideID,new.guideID);
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
