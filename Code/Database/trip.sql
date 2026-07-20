-- MySQL dump 10.13  Distrib 8.0.41, for macos15 (arm64)
--
-- Host: localhost    Database: trip
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
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrator` (
  `User_ID` int NOT NULL,
  `Permissions` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`User_ID`),
  CONSTRAINT `administrator_ibfk_1` FOREIGN KEY (`User_ID`) REFERENCES `user` (`User_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrator`
--

LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
INSERT INTO `administrator` VALUES (3,'Full Access');
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `Booking_ID` int NOT NULL AUTO_INCREMENT,
  `User_ID` int DEFAULT NULL,
  `Event_ID` int DEFAULT NULL,
  `Booking_Status` varchar(50) DEFAULT NULL,
  `Payment_Status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Booking_ID`),
  KEY `booking_ibfk_1` (`User_ID`),
  KEY `booking_ibfk_2` (`Event_ID`),
  CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`User_ID`) REFERENCES `user` (`User_ID`) ON DELETE CASCADE,
  CONSTRAINT `booking_ibfk_2` FOREIGN KEY (`Event_ID`) REFERENCES `tripevent` (`Event_ID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (1,1,1,'Confirmed','Paid'),(2,4,2,'Pending','Unpaid'),(3,5,7,'Confirmed','Paid'),(4,6,8,'Confirmed','Paid'),(6,12,5,'Confirmed','Paid'),(7,13,4,'Confirmed','Paid');
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `City_ID` int NOT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `Country` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`City_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Riyadh','Saudi Arabia'),(2,'Jeddah','Saudi Arabia'),(3,'AlKhobar','Saudi Arabia'),(4,'AlUla','Saudi Arabia');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight` (
  `Flight_ID` int NOT NULL AUTO_INCREMENT,
  `Airline_Name` varchar(100) DEFAULT NULL,
  `Flight_Num` varchar(20) DEFAULT NULL,
  `Departure_APT` varchar(50) DEFAULT NULL,
  `Arrival_APT` varchar(50) DEFAULT NULL,
  `Event_ID` int DEFAULT NULL,
  PRIMARY KEY (`Flight_ID`),
  KEY `flight_ibfk_1` (`Event_ID`),
  CONSTRAINT `flight_ibfk_1` FOREIGN KEY (`Event_ID`) REFERENCES `tripevent` (`Event_ID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES (1,'Saud Airlines','SV101','DMM','ULA',1),(2,'Saud Airlines','SV101','RUH','RUH',4),(3,'Saud Airlines','SV101','RUH','DMM',8),(4,'Saud Airlines','SV101','JED','ULA',2),(6,'Saud Airlines','SV101','ULA','JED',6);
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notifications`
--

DROP TABLE IF EXISTS `notifications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notifications` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `message` text NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `is_read` tinyint(1) DEFAULT '0',
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `notifications_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`User_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notifications`
--

LOCK TABLES `notifications` WRITE;
/*!40000 ALTER TABLE `notifications` DISABLE KEYS */;
INSERT INTO `notifications` VALUES (1,'hi','hope you are doing good','2025-05-03 01:29:15',1,7),(2,'hello','hi, hope you are doing good','2025-05-03 01:30:59',1,7);
/*!40000 ALTER TABLE `notifications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organizer`
--

DROP TABLE IF EXISTS `organizer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `organizer` (
  `User_ID` int NOT NULL,
  `Description` text,
  PRIMARY KEY (`User_ID`),
  CONSTRAINT `organizer_ibfk_1` FOREIGN KEY (`User_ID`) REFERENCES `user` (`User_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organizer`
--

LOCK TABLES `organizer` WRITE;
/*!40000 ALTER TABLE `organizer` DISABLE KEYS */;
INSERT INTO `organizer` VALUES (2,'Organizes hiking and adventure trips'),(8,'Provides guided city tours'),(9,'Specializes in AlUla tourism'),(10,'Entertainment events in Riyadh'),(11,'Watersports and diving in Jeddah');
/*!40000 ALTER TABLE `organizer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `Payment_ID` int NOT NULL,
  `Booking_ID` int DEFAULT NULL,
  `Amount` decimal(10,2) DEFAULT NULL,
  `Payment_Method` varchar(50) DEFAULT NULL,
  `Status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Payment_ID`),
  KEY `Booking_ID` (`Booking_ID`),
  CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`Booking_ID`) REFERENCES `booking` (`Booking_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,1,250.00,'Credit Card','Completed'),(2,3,250.00,'Cash','Pending');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reviewrating`
--

DROP TABLE IF EXISTS `reviewrating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reviewrating` (
  `Review_ID` int NOT NULL,
  `User_ID` int DEFAULT NULL,
  `Event_ID` int DEFAULT NULL,
  `Rating` int DEFAULT NULL,
  `Comment` text,
  `Date` date DEFAULT NULL,
  PRIMARY KEY (`Review_ID`),
  KEY `User_ID` (`User_ID`),
  KEY `Event_ID` (`Event_ID`),
  CONSTRAINT `reviewrating_ibfk_1` FOREIGN KEY (`User_ID`) REFERENCES `user` (`User_ID`),
  CONSTRAINT `reviewrating_ibfk_2` FOREIGN KEY (`Event_ID`) REFERENCES `tripevent` (`Event_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviewrating`
--

LOCK TABLES `reviewrating` WRITE;
/*!40000 ALTER TABLE `reviewrating` DISABLE KEYS */;
INSERT INTO `reviewrating` VALUES (1,1,5,5,'Amazing experience!','2025-06-11'),(2,1,4,4,'Very informative tour.','2025-07-16');
/*!40000 ALTER TABLE `reviewrating` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service` (
  `Service_ID` int NOT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `Price` decimal(10,2) DEFAULT NULL,
  `Description` text,
  `Event_ID` int DEFAULT NULL,
  PRIMARY KEY (`Service_ID`),
  KEY `Event_ID` (`Event_ID`),
  CONSTRAINT `service_ibfk_1` FOREIGN KEY (`Event_ID`) REFERENCES `tripevent` (`Event_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES (1,'Photography Package',50.00,'Professional photography during the event.',1),(2,'VIP Transport',100.00,'Luxury transportation for the tour.',2);
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `traintrip`
--

DROP TABLE IF EXISTS `traintrip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `traintrip` (
  `TrainTrip_ID` int NOT NULL AUTO_INCREMENT,
  `TrainTrip_Num` varchar(20) DEFAULT NULL,
  `Departure_STN` varchar(50) DEFAULT NULL,
  `Arrival_STN` varchar(50) DEFAULT NULL,
  `Event_ID` int DEFAULT NULL,
  PRIMARY KEY (`TrainTrip_ID`),
  KEY `Event_ID` (`Event_ID`),
  CONSTRAINT `traintrip_ibfk_1` FOREIGN KEY (`Event_ID`) REFERENCES `tripevent` (`Event_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `traintrip`
--

LOCK TABLES `traintrip` WRITE;
/*!40000 ALTER TABLE `traintrip` DISABLE KEYS */;
INSERT INTO `traintrip` VALUES (1,'SAR','AlKhobar Station','Riyadh Station',5),(2,'SAR','Riyadh Station','AlKhobar Station',7);
/*!40000 ALTER TABLE `traintrip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tripevent`
--

DROP TABLE IF EXISTS `tripevent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tripevent` (
  `Event_ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `City_ID` int DEFAULT NULL,
  `Price` decimal(10,2) DEFAULT NULL,
  `Category` varchar(50) DEFAULT NULL,
  `Available_Seat` int DEFAULT NULL,
  `User_ID` int DEFAULT NULL,
  PRIMARY KEY (`Event_ID`),
  KEY `City_ID` (`City_ID`),
  KEY `User_ID` (`User_ID`),
  CONSTRAINT `tripevent_ibfk_1` FOREIGN KEY (`City_ID`) REFERENCES `city` (`City_ID`),
  CONSTRAINT `tripevent_ibfk_2` FOREIGN KEY (`User_ID`) REFERENCES `organizer` (`User_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tripevent`
--

LOCK TABLES `tripevent` WRITE;
/*!40000 ALTER TABLE `tripevent` DISABLE KEYS */;
INSERT INTO `tripevent` VALUES (1,'Rock Climbing','2025-08-20',4,250.00,'Adventure',15,2),(2,'Dadan Tour','2025-07-15',4,60.00,'Adventure',25,2),(4,'National Museum','2025-06-30',1,10.00,'Cultural',50,10),(5,'Riyadh Season','2025-11-30',1,200.00,'Entertainment',40,10),(6,'Diving Trips','2025-06-29',2,365.00,'Adventure',10,11),(7,'Ithra Visit','2025-07-14',3,35.00,'Cultural',20,8),(8,'Escape Room','2025-09-10',3,260.00,'Entertainment',10,8),(9,'Maraya Hall Tour','2025-07-22',4,50.00,'Adventure',50,9),(10,'Climbing','2025-10-10',1,50.00,'Adventure',50,9);
/*!40000 ALTER TABLE `tripevent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `User_ID` int NOT NULL,
  `First_Name` varchar(50) DEFAULT NULL,
  `Last_Name` varchar(50) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `Password` varchar(100) DEFAULT NULL,
  `Phone` varchar(10) DEFAULT NULL,
  `Role` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`User_ID`),
  UNIQUE KEY `Email` (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Ali','Ahmed','ali@email.com','password123','0501234567','Customer'),(2,'Sara','Khalid','sara@email.com','securepass','0509876543','Organizer'),(3,'Admin','User','admin@email.com','adminpass','0512345678','Admin'),(4,'Mohammed','Salman','mohammed@email.com','pass123','0523456789','Customer'),(5,'Fatima','Hassan','fatima@email.com','securepass','0539876543','Customer'),(6,'Yousef','AlHarbi','yousef@email.com','pass456','0548765432','Customer'),(7,'Layla','Nasser','layla@email.com','mypass','0557654321','Customer'),(8,'Ahmed','Tariq','ahmedtariq@email.com','pass1','0500000001','Organizer'),(9,'Nora','Faisal','nora@email.com','pass2','0500000002','Organizer'),(10,'Omar','Yazid','omaryazid@email.com','pass3','0500000003','Organizer'),(11,'Lina','Saeed','lina@email.com','pass4','0500000004','Organizer'),(12,'Shekha','Sami','Shekhasgmail.com','SSDQW123!','0500100304','Customer'),(13,'Saude','Saleh','Sudez@gmai.com','SSSZ96','0500107304','Customer');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-03  4:44:10
