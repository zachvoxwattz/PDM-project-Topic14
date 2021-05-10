-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 192.168.100.17    Database: pdm_topic14
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounts` (
  `accountID` decimal(12,0) NOT NULL,
  `accountName` varchar(200) NOT NULL,
  `cardsetUUID` varchar(36) NOT NULL,
  PRIMARY KEY (`accountID`,`cardsetUUID`),
  UNIQUE KEY `accountID_UNIQUE` (`accountID`),
  UNIQUE KEY `cardsetUUID_UNIQUE` (`cardsetUUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES (666,'Satan','thisissatancard'),(1765,'Zainey Bingham','thisiszaineycard'),(2710,'Raven Bebe','thisisravencard'),(8888,'Harry Doolie','thisisharrycard');
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `card_status`
--

DROP TABLE IF EXISTS `card_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `card_status` (
  `statusID` varchar(2) NOT NULL,
  `status` varchar(13) NOT NULL,
  PRIMARY KEY (`statusID`),
  UNIQUE KEY `statusID_UNIQUE` (`statusID`),
  UNIQUE KEY `status_UNIQUE` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card_status`
--

LOCK TABLES `card_status` WRITE;
/*!40000 ALTER TABLE `card_status` DISABLE KEYS */;
INSERT INTO `card_status` VALUES ('EX','EXPIRED'),('LK','LOCKED'),('OP','OPERATIONAL'),('ST','STOLEN');
/*!40000 ALTER TABLE `card_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cards`
--

DROP TABLE IF EXISTS `cards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cards` (
  `cardsetUUID` varchar(36) NOT NULL,
  `cardNo` decimal(16,0) NOT NULL,
  `expDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `balance` decimal(16,0) NOT NULL DEFAULT '0',
  `pin` varchar(6) NOT NULL,
  `statusID` varchar(2) NOT NULL DEFAULT 'OP',
  `isDefault` varchar(3) NOT NULL DEFAULT 'NO',
  PRIMARY KEY (`cardNo`),
  UNIQUE KEY `cardNo_UNIQUE` (`cardNo`),
  KEY `test_idx` (`cardsetUUID`),
  KEY `FK_cards_status_idx` (`statusID`),
  CONSTRAINT `FK_cards_accounts` FOREIGN KEY (`cardsetUUID`) REFERENCES `accounts` (`cardsetUUID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_cards_status` FOREIGN KEY (`statusID`) REFERENCES `card_status` (`statusID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cards`
--

LOCK TABLES `cards` WRITE;
/*!40000 ALTER TABLE `cards` DISABLE KEYS */;
INSERT INTO `cards` VALUES ('thisissatancard',1007,'2021-05-07 15:44:50',15000000,'900009','LK','YES'),('thisissatancard',1765,'2021-05-07 15:44:50',3500000,'779807','OP','NO'),('thisiszaineycard',1766,'2021-05-07 15:44:50',6250000,'826173','OP','NO'),('thisissatancard',2004,'2021-05-07 15:44:50',1250000,'322369','OP','NO'),('thisissatancard',2710,'2021-05-07 15:44:50',3745000,'900009','ST','NO'),('thisiszaineycard',2783,'2021-05-07 15:44:50',9805000,'900009','LK','NO'),('thisissatancard',3516,'2021-05-07 15:44:50',246570000,'324085','OP','NO'),('thisisravencard',3981,'2021-05-07 15:44:50',10000000,'539335','OP','YES'),('thisisharrycard',4444,'2021-05-07 17:27:28',67000000,'777777','OP','YES'),('thisissatancard',4681,'2021-05-07 15:44:50',7300000,'447139','OP','NO'),('thisiszaineycard',6573,'2021-05-07 15:44:50',4950000,'381910','OP','NO'),('thisisravencard',6857,'2021-05-07 15:44:50',5525000,'984657','OP','NO'),('thisissatancard',7584,'2021-05-07 15:44:50',8263000,'573564','OP','NO'),('thisiszaineycard',4040505060607070,'2021-05-08 08:10:57',20500000,'017650','OP','YES');
/*!40000 ALTER TABLE `cards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locations`
--

DROP TABLE IF EXISTS `locations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locations` (
  `locationID` varchar(20) NOT NULL,
  `locationName` varchar(100) NOT NULL,
  PRIMARY KEY (`locationID`),
  UNIQUE KEY `locationID_UNIQUE` (`locationID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locations`
--

LOCK TABLES `locations` WRITE;
/*!40000 ALTER TABLE `locations` DISABLE KEYS */;
INSERT INTO `locations` VALUES ('1_3','Warp 1 - District 3'),('2_10','Warp 2 - District 10'),('2_3','Warp 2 - District 3'),('5_10','Warp 5 - District 10'),('6_3','Warp 6 - District 3'),('8_10','Warp 8 - District 10'),('bn_1','Ben Nghe Warp - District 1'),('dk_1','Da Kao Warp - District 1'),('lt_td','Linh Trung Warp - Thu Duc District'),('pm_3','Phu My Warp - District 7'),('tp_3','Tan Phu Warp - District 7'),('tq_3','Tan Quy Warp - District 7');
/*!40000 ALTER TABLE `locations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transactions` (
  `ID` varchar(36) NOT NULL,
  `typeID` varchar(2) NOT NULL,
  `accountID` decimal(12,0) NOT NULL,
  `cardNo` decimal(16,0) NOT NULL,
  `recipientID` decimal(12,0) DEFAULT NULL,
  `locationID` varchar(20) DEFAULT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `amount` decimal(15,2) DEFAULT NULL,
  `comment` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `Trans_Accs_idx` (`accountID`),
  KEY `Trans_Recp_idx` (`recipientID`),
  KEY `Trans_Loca_idx` (`locationID`),
  KEY `Trans_Card_idx` (`cardNo`),
  KEY `Trans_Type_idx` (`typeID`),
  CONSTRAINT `Trans_Accs` FOREIGN KEY (`accountID`) REFERENCES `accounts` (`accountID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Trans_Card` FOREIGN KEY (`cardNo`) REFERENCES `cards` (`cardNo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Trans_Loca` FOREIGN KEY (`locationID`) REFERENCES `locations` (`locationID`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `Trans_Recp` FOREIGN KEY (`recipientID`) REFERENCES `accounts` (`accountID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Trans_Type` FOREIGN KEY (`typeID`) REFERENCES `transtypes` (`typeID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
INSERT INTO `transactions` VALUES ('0242c3f3-d2a6-4b1d-a3f8-8eb6f684e8bc','TS',1765,4040505060607070,2710,'8_10','2021-05-10 06:19:21',600000.00,'Chuyen khoan ve tai khoan cua ban'),('7a304fa3-906b-44cd-b3e7-2893c28e0cf8','TS',1765,4040505060607070,2710,'8_10','2021-05-10 06:18:31',1200000.00,''),('sample','WD',2710,3981,1765,'lt_td','2021-05-10 06:00:37',125000.00,'Sample Test Transaction');
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transtypes`
--

DROP TABLE IF EXISTS `transtypes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transtypes` (
  `typeID` varchar(2) NOT NULL,
  `typeName` varchar(15) NOT NULL,
  PRIMARY KEY (`typeID`),
  UNIQUE KEY `typeID_UNIQUE` (`typeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transtypes`
--

LOCK TABLES `transtypes` WRITE;
/*!40000 ALTER TABLE `transtypes` DISABLE KEYS */;
INSERT INTO `transtypes` VALUES ('DP','DEPOSIT'),('IV','INVOICE'),('MD','MODIFY'),('ST','SETTLE'),('TS','TRANSFER'),('WD','WITHDRAW');
/*!40000 ALTER TABLE `transtypes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-10 14:22:16
