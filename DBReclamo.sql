-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: reclamo
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `id` int DEFAULT NULL,
  `dia` date DEFAULT NULL,
  `hora` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'2022-11-25','22:10:05'),(2,'2022-11-25','22:10:10'),(1,'2022-05-03','11:52:45'),(1,'2022-05-03','11:52:45'),(3,'2020-11-05','19:30:00'),(3,'2020-11-05','19:30:00'),(3,'2020-11-05','19:30:00'),(3,'2020-11-05','19:30:20'),(1,'2022-11-25','13:17:59'),(1,'2022-11-25','13:18:13'),(1,'2022-11-25','13:24:17'),(1,'2022-11-25','13:25:01'),(1,'2022-11-25','13:25:06'),(1,'2022-11-25','13:25:51'),(1,'2022-11-25','13:25:55'),(3,'2022-11-25','13:26:00'),(3,'2022-11-25','13:27:43'),(3,'2022-11-25','13:28:18'),(3,'2022-11-25','13:30:07'),(3,'2022-11-25','14:25:23'),(3,'2022-11-25','14:32:47'),(3,'2022-11-25','14:32:56'),(3,'2022-11-25','14:39:11'),(3,'2022-11-25','14:40:49'),(3,'2022-11-25','14:41:08'),(1,'2022-11-25','14:41:18'),(1,'2022-11-25','14:44:57'),(1,'2022-11-25','14:45:12'),(1,'2022-11-25','14:46:58'),(3,'2022-11-25','14:47:03'),(1,'2022-11-25','14:54:41'),(1,'2022-11-25','14:55:12'),(1,'2022-11-25','14:55:14'),(1,'2022-11-25','14:55:59'),(1,'2022-11-25','14:56:06'),(1,'2022-11-25','14:57:23'),(1,'2022-11-25','14:58:43'),(1,'2022-11-25','14:59:27'),(1,'2022-11-25','15:00:28'),(3,'2022-11-25','15:00:34'),(1,'2022-11-25','15:01:49'),(1,'2022-11-25','15:02:27'),(1,'2022-11-25','15:03:34'),(1,'2022-11-25','15:18:31'),(1,'2022-11-25','15:19:12'),(1,'2022-11-25','15:19:32'),(1,'2022-11-25','15:20:18'),(3,'2022-11-25','15:26:13'),(1,'2022-11-25','15:26:42'),(1,'2022-11-25','15:27:25'),(1,'2022-11-25','15:30:33'),(1,'2022-11-25','15:32:43'),(1,'2022-11-25','15:32:45'),(1,'2022-11-25','15:33:35'),(1,'2022-11-25','15:35:46'),(1,'2022-11-25','15:36:09'),(1,'2022-11-25','15:37:13'),(3,'2022-11-25','15:37:20'),(1,'2022-11-25','15:37:40'),(1,'2022-11-25','15:39:57'),(1,'2022-11-25','15:43:25'),(1,'2022-11-25','15:43:53'),(1,'2022-11-27','15:36:27'),(1,'2022-11-27','18:20:41'),(1,'2022-11-27','18:21:16'),(1,'2022-11-27','18:22:44'),(1,'2022-11-27','18:23:21'),(1,'2022-11-27','18:36:45'),(1,'2022-11-27','18:37:50'),(1,'2022-11-27','18:38:04'),(3,'2022-11-27','18:38:09'),(3,'2022-11-27','18:38:19'),(3,'2022-12-10','16:23:43'),(1,'2022-12-10','16:23:50'),(3,'2022-12-11','23:20:43'),(3,'2022-12-11','23:23:36'),(3,'2022-12-11','23:26:01'),(1,'2022-12-11','23:30:04'),(3,'2022-12-11','23:31:35'),(3,'2022-12-11','23:33:00'),(3,'2022-12-11','23:34:20'),(3,'2022-12-11','23:36:51'),(3,'2022-12-11','23:37:03'),(3,'2022-12-11','23:40:36'),(3,'2022-12-11','23:49:43'),(3,'2022-12-11','23:49:49'),(3,'2022-12-11','23:56:47'),(3,'2022-12-11','23:58:40'),(3,'2022-12-11','23:58:44'),(3,'2022-12-11','23:59:38'),(3,'2022-12-12','00:02:47'),(3,'2022-12-12','00:05:43'),(3,'2022-12-12','00:06:21'),(3,'2022-12-12','00:09:37'),(3,'2022-12-12','00:11:42'),(3,'2022-12-12','00:12:26'),(3,'2022-12-12','00:12:28'),(1,'2022-12-12','00:38:28'),(3,'2022-12-12','00:38:45'),(3,'2022-12-13','23:53:21'),(3,'2022-12-13','23:53:53'),(1,'2022-12-14','00:04:52'),(1,'2022-12-14','00:08:24'),(1,'2022-12-14','00:08:29'),(1,'2022-12-15','00:46:49'),(1,'2022-12-15','00:47:22'),(1,'2022-12-15','00:49:27'),(1,'2022-12-15','00:50:47'),(1,'2022-12-15','00:52:08'),(1,'2022-12-15','01:03:37'),(1,'2022-12-15','01:04:50'),(1,'2022-12-15','01:05:52'),(1,'2022-12-15','01:06:53'),(1,'2022-12-15','01:07:17'),(1,'2022-12-15','01:07:49'),(1,'2022-12-15','01:09:03'),(1,'2022-12-16','00:25:02'),(1,'2022-12-16','00:40:06'),(3,'2022-12-16','00:40:16'),(3,'2022-12-16','00:40:33'),(1,'2022-12-16','00:40:45'),(0,'2022-12-16','00:42:52'),(1,'2022-12-16','00:43:57'),(1,'2022-12-16','01:35:52'),(1,'2022-12-16','01:40:01'),(1,'2022-12-16','01:40:14'),(1,'2022-12-16','01:41:42'),(1,'2022-12-16','01:42:34'),(0,'2022-12-16','01:43:09'),(0,'2022-12-16','01:43:12'),(0,'2022-12-16','01:43:14'),(0,'2022-12-16','01:43:15'),(1,'2022-12-16','01:43:19'),(1,'2022-12-16','01:46:35'),(1,'2022-12-16','01:47:56'),(1,'2022-12-16','01:49:04'),(0,'2022-12-16','01:50:26'),(0,'2022-12-16','01:50:31'),(0,'2022-12-16','01:50:36'),(1,'2022-12-16','01:50:44'),(0,'2022-12-16','01:55:20'),(0,'2022-12-16','01:55:24'),(0,'2022-12-16','01:55:50'),(1,'2022-12-16','02:01:18'),(1,'2022-12-16','02:05:11'),(1,'2022-12-16','02:20:35'),(1,'2022-12-16','02:22:31'),(1,'2022-12-16','04:25:40'),(0,'2022-12-16','04:26:28'),(1,'2022-12-16','04:26:33'),(1,'2022-12-16','04:29:24'),(3,'2022-12-16','04:29:37'),(0,'2022-12-16','04:32:53'),(0,'2022-12-16','04:33:54'),(1,'2022-12-16','04:36:10'),(3,'2022-12-16','04:36:43'),(3,'2022-12-16','04:37:37'),(1,'2022-12-16','04:37:50'),(1,'2022-12-16','04:41:19'),(2,'2022-12-16','04:41:35'),(2,'2022-12-16','04:45:21'),(2,'2022-12-16','04:47:27'),(2,'2022-12-16','04:47:45'),(1,'2022-12-16','04:52:53'),(1,'2022-12-16','04:53:06'),(1,'2022-12-16','04:53:25'),(2,'2022-12-16','04:54:18'),(2,'2022-12-16','14:33:03'),(1,'2022-12-16','14:33:16'),(2,'2022-12-16','14:48:34'),(3,'2022-12-16','14:48:50'),(1,'2022-12-16','14:49:34'),(1,'2024-07-20','20:46:53'),(3,'2024-07-20','20:47:49'),(3,'2024-07-20','22:23:37'),(3,'2024-07-20','22:49:40'),(3,'2024-07-20','23:21:09'),(3,'2024-07-20','23:32:32'),(1,'2024-07-20','23:32:46'),(1,'2024-07-20','23:42:24'),(1,'2024-07-20','23:43:31'),(1,'2024-07-20','23:45:59'),(1,'2024-07-20','23:46:35'),(1,'2024-07-20','23:50:30'),(1,'2024-07-21','15:46:21'),(1,'2024-07-21','15:49:18'),(1,'2024-07-21','15:54:24'),(1,'2024-07-21','15:54:46'),(1,'2024-07-21','15:57:07'),(1,'2024-07-21','15:58:09'),(3,'2024-07-21','15:58:55'),(3,'2024-07-21','16:10:08'),(1,'2024-07-21','16:11:42'),(1,'2024-07-21','16:12:55'),(1,'2024-07-21','16:13:01'),(3,'2024-07-21','16:13:08'),(3,'2024-07-21','16:17:22'),(1,'2024-07-21','16:17:28'),(1,'2024-07-21','16:31:55'),(1,'2024-07-21','16:35:58'),(1,'2024-07-21','16:41:43'),(1,'2024-07-21','16:42:48'),(3,'2024-07-21','16:42:54'),(3,'2024-07-21','16:43:12'),(3,'2024-07-21','16:43:16'),(1,'2024-07-21','16:43:21'),(1,'2024-07-21','16:43:56'),(1,'2024-07-21','16:44:02'),(3,'2024-07-21','16:44:05'),(1,'2024-07-22','14:36:02'),(3,'2024-07-22','14:37:04'),(3,'2024-07-22','14:39:18'),(1,'2024-07-22','14:39:33'),(1,'2024-07-22','14:47:55'),(1,'2024-07-22','14:51:05'),(1,'2024-07-22','14:51:34'),(1,'2024-07-22','14:52:45'),(1,'2024-07-22','14:53:09'),(1,'2024-07-22','14:55:27'),(1,'2024-07-22','15:02:09'),(1,'2024-07-22','15:08:02'),(1,'2024-07-22','15:08:09'),(1,'2024-07-22','15:09:04'),(1,'2024-07-22','15:12:50'),(1,'2024-07-22','15:35:38'),(1,'2024-07-22','15:39:15'),(1,'2024-07-22','15:39:54'),(1,'2024-07-22','15:42:57'),(1,'2024-07-22','15:43:10'),(1,'2024-07-22','15:45:07'),(1,'2024-07-28','18:32:56'),(1,'2024-07-28','18:33:09'),(1,'2024-07-28','18:36:17'),(1,'2024-07-28','18:45:01'),(1,'2024-07-28','18:47:48'),(1,'2024-07-28','18:52:57'),(3,'2024-07-28','18:53:10'),(3,'2024-07-28','19:17:08'),(1,'2024-07-28','19:17:20'),(1,'2024-07-28','20:09:01'),(1,'2024-07-28','20:13:18'),(1,'2024-07-28','20:15:59'),(1,'2024-07-28','20:39:56'),(1,'2024-07-28','21:24:37'),(1,'2024-07-28','21:24:43'),(1,'2024-07-28','21:25:05'),(1,'2024-07-28','21:25:17'),(1,'2024-07-28','22:48:13'),(1,'2024-07-28','22:48:28'),(1,'2024-07-28','22:49:10'),(1,'2024-07-28','23:19:44'),(1,'2024-07-28','23:39:55'),(1,'2024-07-28','23:40:20'),(1,'2024-07-28','23:45:30'),(1,'2024-07-28','23:46:03'),(1,'2024-07-28','23:48:21'),(1,'2024-07-28','23:49:19'),(1,'2024-07-28','23:49:43'),(1,'2024-07-29','01:20:03'),(1,'2024-07-29','01:24:11'),(1,'2024-07-29','01:24:40'),(1,'2024-07-29','01:27:25'),(1,'2024-07-29','01:28:17'),(1,'2024-07-29','01:28:22'),(1,'2024-07-29','01:28:32'),(1,'2024-07-29','01:29:55'),(1,'2024-07-29','01:31:06'),(1,'2024-07-29','01:33:07'),(1,'2024-07-29','01:34:59'),(1,'2024-07-29','01:39:50'),(2,'2024-07-29','01:39:58'),(2,'2024-07-29','01:40:28'),(3,'2024-07-29','01:41:54'),(3,'2024-07-29','01:42:48'),(1,'2024-07-29','01:43:33'),(1,'2024-07-29','01:43:44'),(1,'2024-07-29','01:45:28'),(1,'2024-07-29','01:45:42'),(1,'2024-07-29','14:30:01'),(1,'2024-08-24','23:02:50'),(1,'2024-08-25','23:07:14'),(3,'2024-08-25','23:07:21'),(1,'2024-08-25','23:14:47'),(1,'2024-08-25','23:15:15'),(1,'2024-08-25','23:18:06'),(8,'2024-08-25','23:18:18'),(8,'2024-08-25','23:24:34'),(8,'2024-08-25','23:24:35'),(8,'2024-08-25','23:24:35'),(8,'2024-08-25','23:24:36'),(8,'2024-08-25','23:24:36'),(8,'2024-08-25','23:24:43'),(8,'2024-08-25','23:26:58'),(8,'2024-08-25','23:26:59'),(8,'2024-08-25','23:27:00'),(8,'2024-08-25','23:27:31'),(12,'2024-11-07','23:27:45'),(1,'2024-11-16','22:19:01'),(1,'2024-11-16','22:20:07'),(31,'2024-11-16','22:53:18'),(9,'2024-11-19','00:30:51'),(9,'2024-11-19','00:32:29'),(9,'2024-11-19','00:34:06'),(9,'2024-11-19','00:34:50'),(9,'2024-11-19','00:38:30'),(9,'2024-11-19','00:39:11'),(1,'2024-11-19','00:39:20'),(9,'2024-11-19','00:41:54'),(1,'2024-11-20','22:53:16'),(35,'2024-11-20','22:54:12'),(1,'2024-11-20','23:04:12'),(35,'2024-11-20','23:04:27'),(37,'2024-11-20','23:16:48'),(37,'2024-11-21','18:14:53'),(1,'2024-11-21','18:14:57'),(21,'2024-11-21','22:01:24'),(41,'2024-11-21','22:43:39'),(42,'2024-11-21','22:57:08'),(43,'2024-11-21','23:02:44'),(44,'2024-11-21','23:05:48'),(47,'2024-11-21','23:36:44'),(48,'2024-11-22','00:21:49'),(49,'2024-11-22','00:22:38'),(1,'2024-11-22','15:27:24'),(64,'2024-11-22','15:42:35'),(65,'2024-11-22','15:43:52'),(65,'2024-11-22','15:45:18'),(65,'2024-11-22','15:46:26'),(65,'2024-11-22','15:48:01'),(65,'2024-11-22','15:57:02'),(1,'2024-11-23','23:47:35'),(1,'2024-11-23','23:47:58'),(1,'2024-11-23','23:48:18'),(65,'2024-11-23','23:49:21'),(65,'2024-11-23','23:58:32'),(65,'2024-11-24','00:09:27'),(65,'2024-11-24','00:20:07'),(1,'2024-11-24','00:21:24'),(1,'2024-11-24','00:24:32'),(65,'2024-11-24','00:32:12'),(65,'2024-11-24','00:38:01'),(65,'2024-11-24','00:38:30'),(65,'2024-11-24','00:45:49'),(1,'2024-11-24','00:46:05'),(1,'2024-11-24','00:56:31'),(65,'2024-11-24','15:40:34'),(65,'2024-11-24','15:42:24'),(65,'2024-11-24','15:43:20'),(65,'2024-11-24','15:44:48'),(65,'2024-11-24','16:18:02'),(65,'2024-11-24','16:18:16'),(1,'2024-11-24','16:18:24'),(1,'2024-11-24','16:52:44'),(1,'2024-11-24','23:16:58'),(1,'2024-11-24','23:24:26'),(1,'2024-11-24','23:36:43'),(1,'2024-11-24','23:49:43'),(1,'2024-11-27','22:51:04'),(1,'2024-11-27','22:55:01'),(1,'2024-11-27','22:56:58'),(1,'2024-11-27','23:23:04'),(1,'2024-11-27','23:28:49'),(1,'2024-11-27','23:34:21'),(1,'2024-11-27','23:35:11'),(1,'2024-11-27','23:36:42'),(1,'2024-11-27','23:39:07'),(1,'2024-11-27','23:39:28'),(1,'2024-11-27','23:39:29'),(1,'2024-11-27','23:46:25'),(1,'2024-11-27','23:49:12'),(1,'2024-11-27','23:49:40'),(1,'2024-11-27','23:52:40'),(1,'2024-11-27','23:55:33'),(1,'2024-11-27','23:58:46'),(1,'2024-11-27','23:59:53'),(1,'2024-11-28','00:13:14'),(1,'2024-11-28','00:14:28'),(1,'2024-11-28','00:16:10'),(1,'2024-11-28','00:21:58'),(1,'2024-11-28','00:23:23'),(1,'2024-11-28','00:25:26'),(1,'2024-11-28','00:28:03'),(1,'2024-11-28','00:30:03'),(1,'2024-11-28','00:31:15'),(1,'2024-11-28','00:31:25'),(1,'2024-11-28','00:32:37'),(1,'2024-11-28','00:32:53'),(1,'2024-11-28','00:38:20'),(1,'2024-11-28','00:40:12'),(1,'2024-11-28','00:40:31'),(1,'2024-11-28','00:41:34'),(1,'2024-11-28','00:43:12'),(1,'2024-11-28','00:44:38'),(1,'2024-11-28','00:45:05'),(1,'2024-11-28','00:46:30'),(1,'2024-11-28','00:48:54'),(1,'2024-11-28','00:49:25'),(1,'2024-11-28','00:52:00'),(1,'2024-11-28','00:52:00'),(1,'2024-11-28','00:55:21'),(1,'2024-11-28','00:56:44'),(1,'2024-11-28','00:57:13'),(1,'2024-11-28','00:57:39'),(1,'2024-11-28','00:57:50'),(1,'2024-11-28','00:58:13'),(1,'2024-11-28','00:59:06'),(1,'2024-11-28','00:59:10'),(1,'2024-11-28','00:59:16'),(1,'2024-11-28','01:05:08'),(1,'2024-11-28','01:06:40'),(1,'2024-12-08','14:02:23'),(1,'2024-12-08','14:15:01'),(1,'2024-12-08','14:22:40'),(1,'2024-12-08','14:24:55'),(1,'2024-12-08','14:39:26'),(1,'2024-12-08','14:39:57'),(1,'2024-12-08','14:59:35'),(1,'2024-12-08','15:00:21'),(1,'2024-12-08','15:05:56'),(1,'2024-12-08','15:09:41'),(1,'2024-12-08','15:52:15'),(1,'2024-12-08','15:56:46'),(1,'2024-12-08','16:20:56'),(1,'2024-12-08','16:31:40'),(1,'2024-12-08','16:45:09'),(1,'2024-12-08','18:41:34'),(1,'2024-12-08','18:44:57'),(3,'2024-12-08','23:33:40'),(3,'2024-12-08','23:33:56'),(3,'2024-12-08','23:34:04'),(3,'2024-12-08','23:34:20'),(3,'2024-12-08','23:37:18'),(1,'2024-12-08','23:37:27'),(1,'2024-12-08','23:39:12'),(1,'2024-12-08','23:44:27'),(1,'2024-12-08','23:47:01'),(1,'2024-12-08','23:48:27'),(1,'2024-12-08','23:52:12'),(1,'2024-12-08','23:59:06'),(1,'2024-12-09','00:08:36'),(1,'2024-12-09','00:08:44'),(1,'2024-12-09','00:11:32'),(66,'2024-12-09','00:12:48'),(66,'2024-12-09','00:13:00'),(67,'2024-12-09','00:14:31'),(1,'2024-12-09','00:29:02'),(1,'2024-12-09','01:08:27'),(1,'2024-12-09','01:09:23'),(3,'2024-12-09','01:12:37'),(3,'2024-12-09','01:41:50'),(3,'2024-12-09','01:43:31'),(3,'2024-12-09','01:49:33'),(3,'2024-12-09','01:52:07'),(3,'2024-12-09','01:52:36'),(1,'2024-12-09','01:57:29'),(1,'2024-12-09','02:28:18'),(1,'2024-12-09','02:30:13'),(1,'2024-12-09','02:31:14'),(1,'2024-12-09','02:31:57'),(1,'2024-12-09','02:33:02'),(1,'2024-12-09','02:34:10'),(1,'2024-12-09','02:35:59'),(1,'2024-12-09','02:37:25'),(1,'2024-12-09','02:38:17'),(1,'2024-12-09','02:39:02'),(1,'2024-12-09','02:40:27'),(1,'2024-12-09','02:45:54'),(1,'2024-12-09','02:53:55'),(1,'2024-12-09','02:55:41'),(1,'2024-12-09','02:56:16'),(1,'2024-12-09','02:59:29'),(1,'2024-12-09','03:06:02'),(1,'2024-12-09','03:08:27'),(1,'2024-12-09','03:18:17'),(1,'2024-12-09','03:20:20'),(1,'2024-12-09','03:24:08'),(1,'2024-12-09','03:26:09'),(1,'2024-12-09','03:26:35'),(1,'2024-12-09','05:03:19'),(1,'2024-12-09','05:06:28'),(1,'2024-12-09','05:08:34'),(3,'2024-12-09','05:10:58'),(68,'2024-12-09','05:13:45'),(68,'2024-12-09','05:15:49'),(68,'2024-12-09','05:16:20');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `apellido` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `dni` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `mail` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `telefono` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `id_usuario` int NOT NULL,
  `esta_completa` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`,`id_usuario`),
  KEY `fk_persona_usuario_idx` (`id_usuario`),
  CONSTRAINT `fk_persona_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'marii','pia','789456','lala@gmail.com','11223344',3,1),(2,'Pepe','Pompin','12300500','pepepompin@gmail.com','4807-6023',2,1),(3,'admin','admin','12345678','admin@gmail.com','4807-6023',1,1),(4,'pan','chita','7898','oo','4423',8,1),(52,NULL,NULL,NULL,NULL,NULL,68,0),(53,NULL,NULL,NULL,NULL,NULL,69,0),(54,NULL,NULL,NULL,NULL,NULL,70,0);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reclamo`
--

DROP TABLE IF EXISTS `reclamo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reclamo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  `persona_id` int NOT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `categoria` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_reclamo_persona_idx` (`persona_id`),
  CONSTRAINT `fk_reclamo_persona` FOREIGN KEY (`persona_id`) REFERENCES `persona` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reclamo`
--

LOCK TABLES `reclamo` WRITE;
/*!40000 ALTER TABLE `reclamo` DISABLE KEYS */;
INSERT INTO `reclamo` VALUES (1,'CHIMPUMpum','2022-10-11','2024-12-08',2,'asaf','limpieza'),(2,'afoaisf','2022-10-11',NULL,1,'aasf','Alumbrado'),(3,'pppp','2022-10-11',NULL,2,'ppp','alumbrado'),(9,'kk','2024-12-09',NULL,1,'triunvirto pluvial','alumbrado'),(11,'jjj','2024-12-11',NULL,1,'kkk','pluvial'),(12,'kkk','2024-12-09',NULL,1,'mm','Limpieza'),(13,'Faro de luz rotowowowow','2024-12-09',NULL,3,'sdfsdf','Arbolado'),(14,'reclamo de marai','2024-12-07',NULL,1,'en la direccion de maria','Arbolado');
/*!40000 ALTER TABLE `reclamo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre_usuario` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `pass` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `es_admin` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'admin','admin',1),(2,'pepe','pepe',0),(3,'maria','maria',0),(4,'juan','juan',0),(5,'usuario','pass',0),(6,'usuario','pass',0),(7,'user','pass',0),(8,'prueba123','ABC',0),(9,'pia','pia',0),(10,'','',0),(11,'nuevo ','nuevopass',0),(12,'super','duper',0),(13,'usercito','passcita',0),(14,'usercito2','passcita',0),(15,'3','passcita',0),(16,'tetete','passcita',0),(17,'tet','passcita',0),(18,'tetpo','passcita',0),(19,'tetpo078','passcita',0),(20,'tetpo078888','passcita',0),(21,'yyyy','passcita',0),(22,'yyuyy','passcita',0),(23,'pppppp','passcita',0),(24,'65465654','passcita',0),(25,'654685654','passcita',0),(26,'wewe','passcita',0),(27,'werter','passcita',0),(29,'admin','admin',0),(30,'admin','admin',0),(31,'pepe_pompin','pepe_pompin',0),(32,'admincito','admin',0),(33,'amigooo','amigoo',0),(34,'superduper','admin',0),(35,'potonete','potonete',0),(36,'papanatass','papanatass',0),(37,'manzana','manzana',0),(38,'650','650',0),(39,'99','99',0),(40,'1','1',0),(41,'abc','abc',0),(42,'2','2',0),(43,'89879','987987',0),(44,'adminasas','as',0),(45,'Ã±mÃ±am','Ã±maÃ±ma',0),(46,'adminsdfsdf','adminsdf',0),(47,'adminafasf','adminafsasf',0),(48,'adminsdgsdgsgsdg','admin',0),(49,'adminafas','admin',0),(50,'adminfsfsdafdasdf','admin',0),(51,'adminddddsfsgdsg','admin',0),(52,'fafafsfdgsdvz','admin',0),(53,'Ã±aÃ±maÃ±maÃ±ma','admin',0),(54,'poroto','poroto',0),(55,'ifuoufdoiu','oiusdogusdlk',0),(56,'hhrhrht','trhrhrhh',0),(57,'565555','555555',0),(58,'sdsgsg','sdfgdsfgdsh',0),(59,'fgfdhfndgf','dgsfdsfgdsfg',0),(60,'dfsdfg','dsfgsdfg',0),(61,'sdfsfsf','asdfasfdasfd',0),(62,'ew234234','admi23424n',0),(63,'adminsfsfsdf','adminsfdsdsf',0),(64,'eeeeee','admineeeee',0),(65,'SUPERUPER','SUPERUPER',0),(66,'nop','nop',0),(67,'ppp','ppp',0),(68,'Mariana','nanis',0),(69,'mariammb','maria',0),(70,'abcqeeq','abcbc',0);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-09  5:27:31