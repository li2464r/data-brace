-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 10.108.2.192    Database: databrce
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `urban_rural`
--

DROP TABLE IF EXISTS `urban_rural`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `urban_rural`
(
    `id`               int      NOT NULL AUTO_INCREMENT,
    `pid`              int               DEFAULT NULL COMMENT '父ID',
    `area_code`        varchar(32)       DEFAULT NULL COMMENT '代码',
    `area_name`        varchar(32)       DEFAULT NULL COMMENT '名称',
    `area_code_parent` varchar(32)       DEFAULT NULL COMMENT '上一级代码',
    `abbreviate_en`    varchar(32)       DEFAULT NULL COMMENT '英文缩写',
    `abbreviate_ch`    varchar(32)       DEFAULT NULL COMMENT '中文缩写',
    `area_class`       char(1)           DEFAULT NULL COMMENT '城市等级: 0:国;1:省,自治区,直辖市,特别行政区;2:地级市,地区,自治州,盟;3:市辖区,县级市,县,自治县,旗,自治旗,特区,林区;4:街道,镇,乡,民族乡,苏木,民族苏木,县辖区;5:居委会,村委会;',
    `urban_rural_code` varchar(32)       DEFAULT NULL,
    `postal_code`      varchar(16)       DEFAULT NULL COMMENT '邮编',
    `create_date`      datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `create_user`      int               DEFAULT NULL COMMENT '创建人',
    `update_date`      datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `update_user`      int               DEFAULT NULL COMMENT '更新人',
    `normal`           char(1)           DEFAULT '1' COMMENT '状态: 0:停用;1:启用;',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 238
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='城市表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `urban_rural`
--

LOCK TABLES `urban_rural` WRITE;
/*!40000 ALTER TABLE `urban_rural`
    DISABLE KEYS */;
INSERT INTO `urban_rural`
VALUES (1, 0, NULL, '中国', NULL, 'CHN', NULL, '0', NULL, NULL, '2023-04-04 11:23:24', NULL, '2023-04-04 11:25:22',
        NULL, '1'),
       (2, 1, NULL, '北京', NULL, NULL, NULL, '1', NULL, NULL, '2023-04-04 11:23:24', NULL, '2023-04-04 11:25:07', NULL,
        '1'),
       (3, 1, NULL, '天津', NULL, NULL, NULL, '1', NULL, NULL, '2023-04-04 11:23:24', NULL, '2023-04-04 11:25:07', NULL,
        '1'),
       (4, 1, NULL, '河北', NULL, NULL, NULL, '1', NULL, NULL, '2023-04-04 11:23:24', NULL, '2023-04-04 11:25:07', NULL,
        '1'),
       (5, 1, NULL, '山西', NULL, NULL, NULL, '1', NULL, NULL, '2023-04-04 11:23:24', NULL, '2023-04-04 11:25:07', NULL,
        '1'),
       (6, 1, NULL, '内蒙古自治区', NULL, NULL, NULL, '1', NULL, NULL, '2023-04-04 11:23:24', NULL,
        '2023-04-04 11:23:24', NULL, '1'),
       (7, 1, NULL, '辽宁', NULL, NULL, NULL, '1', NULL, NULL, '2023-04-04 11:23:24', NULL, '2023-04-04 11:25:07', NULL,
        '1'),
       (8, 1, NULL, '吉林', NULL, NULL, NULL, '1', NULL, NULL, '2023-04-04 11:23:24', NULL, '2023-04-04 11:25:07', NULL,
        '1'),
       (9, 1, NULL, '黑龙江省', NULL, NULL, NULL, '1', NULL, NULL, '2023-04-04 11:23:24', NULL, '2023-04-04 11:23:24',
        NULL, '1'),
       (10, 1, NULL, '上海', NULL, NULL, NULL, '1', NULL, NULL, '2023-04-04 11:23:24', NULL, '2023-04-04 11:25:07',
        NULL, '1'),
       (11, 1, NULL, '江苏', NULL, NULL, NULL, '1', NULL, NULL, '2023-04-04 11:23:24', NULL, '2023-04-04 11:25:07',
        NULL, '1'),
       (12, 1, NULL, '浙江', NULL, NULL, NULL, '1', NULL, NULL, '2023-04-04 11:23:24', NULL, '2023-04-04 11:25:07',
        NULL, '1'),
       (13, 1, NULL, '安徽', NULL, NULL, NULL, '1', NULL, NULL, '2023-04-04 11:23:24', NULL, '2023-04-04 11:25:07',
        NULL, '1'),
       (14, 1, NULL, '福建', NULL, NULL, NULL, '1', NULL, NULL, '2023-04-04 11:23:24', NULL, '2023-04-04 11:25:07',
        NULL, '1'),
       (15, 1, NULL, '江西', NULL, NULL, NULL, '1', NULL, NULL, '2023-04-04 11:23:24', NULL, '2023-04-04 11:25:07',
        NULL, '1'),
       (16, 1, NULL, '山东', NULL, NULL, NULL, '1', NULL, NULL, '2023-04-04 11:23:24', NULL, '2023-04-04 11:25:07',
        NULL, '1'),
       (17, 1, NULL, '河南', NULL, NULL, NULL, '1', NULL, NULL, '2023-04-04 11:23:24', NULL, '2023-04-04 11:25:07',
        NULL, '1'),
       (18, 1, NULL, '湖北', NULL, NULL, NULL, '1', NULL, NULL, '2023-04-04 11:23:24', NULL, '2023-04-04 11:25:07',
        NULL, '1'),
       (19, 1, NULL, '湖南', NULL, NULL, NULL, '1', NULL, NULL, '2023-04-04 11:23:24', NULL, '2023-04-04 11:25:07',
        NULL, '1'),
       (20, 1, NULL, '广东', NULL, NULL, NULL, '1', NULL, NULL, '2023-04-04 11:23:24', NULL, '2023-04-04 11:25:07',
        NULL, '1'),
       (21, 1, NULL, '广西壮族自治区', NULL, NULL, NULL, '1', NULL, NULL, '2023-04-04 11:23:24', NULL,
        '2023-04-04 11:25:07', NULL, '1'),
       (22, 1, NULL, '海南', NULL, NULL, NULL, '1', NULL, NULL, '2023-04-04 11:23:24', NULL, '2023-04-04 11:25:07',
        NULL, '1'),
       (23, 1, NULL, '重庆', NULL, NULL, NULL, '1', NULL, NULL, '2023-04-04 11:23:24', NULL, '2023-04-04 11:25:07',
        NULL, '1'),
       (24, 1, NULL, '四川', NULL, NULL, NULL, '1', NULL, NULL, '2023-04-04 11:23:24', NULL, '2023-04-04 11:25:07',
        NULL, '1'),
       (25, 1, NULL, '贵州', NULL, NULL, NULL, '1', NULL, NULL, '2023-04-04 11:23:24', NULL, '2023-04-04 11:25:07',
        NULL, '1'),
       (26, 1, NULL, '云南', NULL, NULL, NULL, '1', NULL, NULL, '2023-04-04 11:23:24', NULL, '2023-04-04 11:25:07',
        NULL, '1'),
       (27, 1, NULL, '西藏自治区', NULL, NULL, NULL, '1', NULL, NULL, '2023-04-04 11:23:24', NULL,
        '2023-04-04 11:25:07', NULL, '1'),
       (28, 1, NULL, '陕西', NULL, NULL, NULL, '1', NULL, NULL, '2023-04-04 11:23:24', NULL, '2023-04-04 11:25:07',
        NULL, '1'),
       (29, 1, NULL, '甘肃', NULL, NULL, NULL, '1', NULL, NULL, '2023-04-04 11:23:24', NULL, '2023-04-04 11:25:07',
        NULL, '1'),
       (30, 1, NULL, '青海', NULL, NULL, NULL, '1', NULL, NULL, '2023-04-04 11:23:24', NULL, '2023-04-04 11:25:07',
        NULL, '1'),
       (31, 1, NULL, '宁夏回族自治区', NULL, NULL, NULL, '1', NULL, NULL, '2023-04-04 11:23:24', NULL,
        '2023-04-04 11:25:07', NULL, '1'),
       (32, 1, NULL, '新疆维吾尔自治区', NULL, NULL, NULL, '1', NULL, NULL, '2023-04-04 11:23:24', NULL,
        '2023-04-04 11:23:24', NULL, '1'),
       (33, 1, NULL, '香港特别行政区', NULL, NULL, NULL, '1', NULL, NULL, '2023-04-04 11:23:24', NULL,
        '2023-04-04 11:25:07', NULL, '1'),
       (34, 1, NULL, '澳门特别行政区', NULL, NULL, NULL, '1', NULL, NULL, '2023-04-04 11:23:24', NULL,
        '2023-04-04 11:25:07', NULL, '1'),
       (35, 1, NULL, '台湾', NULL, NULL, NULL, '1', NULL, NULL, '2023-04-04 11:23:24', NULL, '2023-04-04 11:25:07',
        NULL, '1');
/*!40000 ALTER TABLE `urban_rural`
    ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2023-04-12  9:46:19
