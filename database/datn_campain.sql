-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: datn
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `campain`
--

DROP TABLE IF EXISTS `campain`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `campain` (
  `Id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `Campain Type Id` int(10) unsigned zerofill NOT NULL,
  `Start` timestamp NOT NULL,
  `End` timestamp NOT NULL,
  `Status` varchar(255) NOT NULL,
  `Metadata` varchar(255) NOT NULL,
  `Result` varchar(255) NOT NULL,
  `Owner Id` int(10) unsigned zerofill NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `campainTypeKey_idx` (`Campain Type Id`),
  KEY `userKey_idx` (`Owner Id`),
  CONSTRAINT `campainTypeKey` FOREIGN KEY (`Campain Type Id`) REFERENCES `campaintype` (`Id`),
  CONSTRAINT `userKey` FOREIGN KEY (`Owner Id`) REFERENCES `user` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campain`
--

LOCK TABLES `campain` WRITE;
/*!40000 ALTER TABLE `campain` DISABLE KEYS */;
INSERT INTO `campain` VALUES (0000000001,'Bình chọn Môn học','Bình chọn môn học yêu thích trong trường',0000000002,'2024-02-01 10:00:00','2024-03-30 03:00:00','opend','huce','Giải tích',0000000001),(0000000002,'Bình chọn mở lớp vi sử lý','Lượng sinh viên có nhu cầu học vi sử lý tăng cần mở thêm lớp',0000000001,'2024-03-23 10:00:00','2024-03-27 10:00:00','opend','Huce','Yes',0000000001),(0000000003,'Đi ăn','Tán lộc trúng số',0000000002,'2024-04-03 10:00:00','2024-04-10 10:00:00','opend','huce','Yes',0000000001);
/*!40000 ALTER TABLE `campain` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-09 15:15:18
