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
  `balance` decimal(15,2) DEFAULT '0.00',
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
INSERT INTO `accounts` VALUES (666,'Satan','thisissatancard',0.00),(1765,'Zainey Bingham','thisiszaineycard',0.00),(2710,'Raven Bebe','thisisravencard',0.00),(8888,'Harry Doolie','thisisharrycard',0.00);
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
  `balance` decimal(15,2) NOT NULL DEFAULT '0.00',
  `pin` decimal(6,0) NOT NULL,
  `statusID` varchar(2) NOT NULL DEFAULT 'OP',
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
INSERT INTO `cards` VALUES ('thisissatancard',1007,'2021-05-07 15:44:50',5637.00,900009,'LK'),('thisissatancard',1765,'2021-05-07 15:44:50',2101.00,779807,'OP'),('thisiszaineycard',1766,'2021-05-07 15:44:50',9467.00,826173,'OP'),('thisissatancard',2004,'2021-05-07 15:44:50',4992.00,322369,'OP'),('thisissatancard',2710,'2021-05-07 15:44:50',8188.00,900009,'ST'),('thisiszaineycard',2783,'2021-05-07 15:44:50',5637.00,900009,'LK'),('thisissatancard',3516,'2021-05-07 15:44:50',1790.00,324085,'OP'),('thisisravencard',3981,'2021-05-07 15:44:50',2724.00,539335,'OP'),('thisisharrycard',4444,'2021-05-07 17:27:28',90.00,777777,'OP'),('thisissatancard',4681,'2021-05-07 15:44:50',9223.00,447139,'OP'),('thisiszaineycard',6573,'2021-05-07 15:44:50',5637.00,381910,'OP'),('thisisravencard',6857,'2021-05-07 15:44:50',5637.00,984657,'OP'),('thisissatancard',7584,'2021-05-07 15:44:50',5637.00,573564,'OP');
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

-- Dump completed on 2021-05-08 13:55:09
