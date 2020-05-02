-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: charity
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `amount`
--

DROP TABLE IF EXISTS `amount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `amount` (
  `aID` int NOT NULL,
  `customerID` int DEFAULT NULL,
  `monthly` tinyint(1) DEFAULT '0',
  `value` decimal(4,2) NOT NULL,
  PRIMARY KEY (`aID`),
  KEY `customerID` (`customerID`),
  CONSTRAINT `amount_ibfk_1` FOREIGN KEY (`customerID`) REFERENCES `customer` (`customerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amount`
--

LOCK TABLES `amount` WRITE;
/*!40000 ALTER TABLE `amount` DISABLE KEYS */;
/*!40000 ALTER TABLE `amount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `amountpledge`
--

DROP TABLE IF EXISTS `amountpledge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `amountpledge` (
  `pledgeID` int DEFAULT NULL,
  `aID` int DEFAULT NULL,
  KEY `pledgeID` (`pledgeID`),
  KEY `aID` (`aID`),
  CONSTRAINT `amountpledge_ibfk_1` FOREIGN KEY (`pledgeID`) REFERENCES `pledges` (`pledgeID`),
  CONSTRAINT `amountpledge_ibfk_2` FOREIGN KEY (`aID`) REFERENCES `amount` (`aID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amountpledge`
--

LOCK TABLES `amountpledge` WRITE;
/*!40000 ALTER TABLE `amountpledge` DISABLE KEYS */;
/*!40000 ALTER TABLE `amountpledge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appeals`
--

DROP TABLE IF EXISTS `appeals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appeals` (
  `appealID` int NOT NULL,
  `name` varchar(56) NOT NULL,
  `country` varchar(32) NOT NULL,
  `region` varchar(32) NOT NULL,
  `monthly_price` decimal(4,2) DEFAULT NULL,
  PRIMARY KEY (`appealID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appeals`
--

LOCK TABLES `appeals` WRITE;
/*!40000 ALTER TABLE `appeals` DISABLE KEYS */;
/*!40000 ALTER TABLE `appeals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appealspledge`
--

DROP TABLE IF EXISTS `appealspledge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appealspledge` (
  `pledgeID` int DEFAULT NULL,
  `appealID` int DEFAULT NULL,
  KEY `pledgeID` (`pledgeID`),
  KEY `appealID` (`appealID`),
  CONSTRAINT `appealspledge_ibfk_1` FOREIGN KEY (`pledgeID`) REFERENCES `pledges` (`pledgeID`),
  CONSTRAINT `appealspledge_ibfk_2` FOREIGN KEY (`appealID`) REFERENCES `appeals` (`appealID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appealspledge`
--

LOCK TABLES `appealspledge` WRITE;
/*!40000 ALTER TABLE `appealspledge` DISABLE KEYS */;
/*!40000 ALTER TABLE `appealspledge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customerID` int NOT NULL,
  `first_name` varchar(120) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `address1` varchar(150) NOT NULL,
  `address2` varchar(50) DEFAULT NULL,
  `city` varchar(36) NOT NULL,
  `postcode` varchar(16) NOT NULL,
  PRIMARY KEY (`customerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pledges`
--

DROP TABLE IF EXISTS `pledges`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pledges` (
  `pledgeID` int NOT NULL,
  `customerID` int DEFAULT NULL,
  `date_placed` date NOT NULL,
  PRIMARY KEY (`pledgeID`),
  KEY `customerID` (`customerID`),
  CONSTRAINT `pledges_ibfk_1` FOREIGN KEY (`customerID`) REFERENCES `customer` (`customerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pledges`
--

LOCK TABLES `pledges` WRITE;
/*!40000 ALTER TABLE `pledges` DISABLE KEYS */;
/*!40000 ALTER TABLE `pledges` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-02  8:57:33
