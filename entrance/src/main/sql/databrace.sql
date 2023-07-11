-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 10.108.2.192    Database: databrace
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `urban_rural`
--

DROP TABLE IF EXISTS `urban_rural`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `urban_rural` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `pid` bigint DEFAULT NULL COMMENT '父ID',
  `area_code` varchar(32) DEFAULT NULL COMMENT '代码',
  `area_name` varchar(32) DEFAULT NULL COMMENT '名称',
  `area_code_parent` varchar(32) DEFAULT NULL COMMENT '上一级代码',
  `abbreviate_en` varchar(32) DEFAULT NULL COMMENT '英文缩写',
  `abbreviate_ch` varchar(32) DEFAULT NULL COMMENT '中文缩写',
  `area_class` char(1) DEFAULT NULL COMMENT '城市等级: 0:国;1:省,自治区,直辖市,特别行政区;2:地级市,地区,自治州,盟;3:市辖区,县级市,县,自治县,旗,自治旗,特区,林区;4:街道,镇,乡,民族乡,苏木,民族苏木,县辖区;5:居委会,村委会;',
  `urban_rural_class` varchar(8) DEFAULT NULL COMMENT '城乡等级: 100:城镇;110:城区;111:主城区;112:城乡结合区;120:镇区;121:镇中心区;122:镇乡结合区;123:特殊区域;200:乡村;210:乡中心区;220:村庄;',
  `postal_code` varchar(16) DEFAULT NULL COMMENT '邮编',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` int DEFAULT NULL COMMENT '创建人',
  `update_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_user` int DEFAULT NULL COMMENT '更新人',
  `normal` char(1) DEFAULT '1' COMMENT '状态: 0:停用;1:启用;',
  PRIMARY KEY (`id`),
  KEY `urban_rural_abbreviate_ch_index` (`abbreviate_ch`),
  KEY `urban_rural_abbreviate_en_index` (`abbreviate_en`),
  KEY `urban_rural_area_code_index` (`area_code`),
  KEY `urban_rural_create_date_index` (`create_date`)
) ENGINE=InnoDB AUTO_INCREMENT=36515 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='城市表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `urban_rural`
--

LOCK TABLES `urban_rural` WRITE;
/*!40000 ALTER TABLE `urban_rural` DISABLE KEYS */;

/*!40000 ALTER TABLE `urban_rural` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-26 16:45:27
