-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: gym
-- ------------------------------------------------------
-- Server version	8.0.41

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
-- Table structure for table `members`
--

DROP TABLE IF EXISTS `members`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `members` (
  `id` varchar(20) NOT NULL,
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `phone_number` varchar(15) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `address` text,
  `city` varchar(100) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  `postal_code` varchar(20) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `members`
--

LOCK TABLES `members` WRITE;
/*!40000 ALTER TABLE `members` DISABLE KEYS */;
INSERT INTO `members` VALUES ('GYM001','Arun','Kumar','arun.kumar@example.com','9876543210','MALE','1990-05-15','123 Purasawalkam','Chennai','India','600007',1,'2025-04-11 11:22:03','2025-04-11 11:22:03'),('GYM002','Priya','Sharma','priya.sharma@example.com','9876543211','FEMALE','1988-07-20','456 Anna Nagar','Chennai','India','600040',1,'2025-04-11 11:22:03','2025-04-11 11:22:03'),('GYM003','Suresh','Reddy','suresh.reddy@example.com','9876543212','MALE','1992-09-25','789 T. Nagar','Chennai','India','600017',1,'2025-04-11 11:22:03','2025-04-11 11:22:03'),('GYM004','Nithya','Ravi','nithya.ravi@example.com','9876543213','FEMALE','1995-12-10','101 West Mambalam','Chennai','India','600033',1,'2025-04-11 11:22:03','2025-04-11 11:22:03'),('GYM005','Rajesh','Babu','rajesh.babu@example.com','9876543214','MALE','1985-11-11','202 Kotturpuram','Chennai','India','600085',1,'2025-04-11 11:22:03','2025-04-11 11:22:03'),('GYM006','Meera','Ranganathan','meera.ranganathan@example.com','9876543215','FEMALE','1993-02-15','303 Perungudi','Chennai','India','600096',1,'2025-04-11 11:22:03','2025-04-11 11:22:03'),('GYM007','Vijay','Krishnan','vijay.krishnan@example.com','9876543216','MALE','1990-06-30','404 Mount Road','Chennai','India','600016',1,'2025-04-11 11:22:03','2025-04-11 11:22:03'),('GYM008','Anjali','Venkatesh','anjali.venkatesh@example.com','9876543217','FEMALE','1987-08-05','505 Kottur','Chennai','India','600075',1,'2025-04-11 11:22:03','2025-04-11 11:22:03'),('GYM009','Karthik','Sundaram','karthik.sundaram@example.com','9876543218','MALE','1994-01-28','606 Adyar','Chennai','India','600020',1,'2025-04-11 11:22:03','2025-04-11 11:22:03');
/*!40000 ALTER TABLE `members` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscriptions`
--

DROP TABLE IF EXISTS `subscriptions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subscriptions` (
  `id` varchar(20) NOT NULL,
  `member_id` varchar(20) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `payment_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `member_id` (`member_id`),
  CONSTRAINT `subscriptions_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `members` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscriptions`
--

LOCK TABLES `subscriptions` WRITE;
/*!40000 ALTER TABLE `subscriptions` DISABLE KEYS */;
INSERT INTO `subscriptions` VALUES ('SUB001','GYM001','2025-01-01','2025-03-31',1200.00,'ACTIVE','2025-04-11 11:22:26'),('SUB002','GYM002','2025-02-01','2025-04-30',1500.00,'ACTIVE','2025-04-11 11:22:26'),('SUB003','GYM003','2025-01-15','2025-04-14',1800.00,'ACTIVE','2025-04-11 11:22:26'),('SUB004','GYM004','2025-01-10','2025-03-10',1000.00,'EXPIRED','2025-04-11 11:22:26'),('SUB005','GYM005','2025-03-01','2025-05-31',2200.00,'ACTIVE','2025-04-11 11:22:26'),('SUB006','GYM006','2025-01-05','2025-04-05',2000.00,'ACTIVE','2025-04-11 11:22:26'),('SUB007','GYM007','2025-02-10','2025-05-10',1600.00,'ACTIVE','2025-04-11 11:22:26'),('SUB008','GYM008','2025-02-15','2025-05-15',2500.00,'ACTIVE','2025-04-11 11:22:26'),('SUB009','GYM009','2025-03-01','2025-06-01',1900.00,'ACTIVE','2025-04-11 11:22:26');
/*!40000 ALTER TABLE `subscriptions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-11 16:53:08
