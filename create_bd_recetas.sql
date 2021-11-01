CREATE DATABASE  IF NOT EXISTS `db_recetas_sprang` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `db_recetas_sprang`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: db_recetas_sprang
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `cocineros`
--

DROP TABLE IF EXISTS `cocineros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cocineros` (
  `id` int NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `create_at` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombre` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cocineros`
--

LOCK TABLES `cocineros` WRITE;
/*!40000 ALTER TABLE `cocineros` DISABLE KEYS */;
INSERT INTO `cocineros` VALUES (1,'Díaz','2021-10-30 00:00:00.000000','juan@mail.com','Juan');
/*!40000 ALTER TABLE `cocineros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingredientes`
--

DROP TABLE IF EXISTS `ingredientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingredientes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `acidos_grasos_monoinsaturados` double DEFAULT NULL,
  `acidos_grasos_poliinsaturados` double DEFAULT NULL,
  `acidos_grasos_saturados` double DEFAULT NULL,
  `agua` double DEFAULT NULL,
  `calcio` double DEFAULT NULL,
  `calorias` double DEFAULT NULL,
  `carbohidratos` double DEFAULT NULL,
  `colesterol` double DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fibra` double DEFAULT NULL,
  `folato` double DEFAULT NULL,
  `fosforo` double DEFAULT NULL,
  `grasa` double DEFAULT NULL,
  `hierro` double DEFAULT NULL,
  `ioduro` double DEFAULT NULL,
  `niacina` double DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `potasio` double DEFAULT NULL,
  `proteina` double DEFAULT NULL,
  `riboflavina` double DEFAULT NULL,
  `selenio` double DEFAULT NULL,
  `sodio` double DEFAULT NULL,
  `tiamina` double DEFAULT NULL,
  `vitaminaa` double DEFAULT NULL,
  `vitaminab12` double DEFAULT NULL,
  `vitaminab6` double DEFAULT NULL,
  `vitaminac` double DEFAULT NULL,
  `vitaminad` double DEFAULT NULL,
  `vitaminae` double DEFAULT NULL,
  `zinc` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredientes`
--

LOCK TABLES `ingredientes` WRITE;
/*!40000 ALTER TABLE `ingredientes` DISABLE KEYS */;
INSERT INTO `ingredientes` VALUES (1,NULL,NULL,NULL,1000,0,0,NULL,0,'',NULL,NULL,NULL,0,0,NULL,NULL,'Agua',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(2,NULL,NULL,NULL,0,0,887,NULL,0,'',NULL,NULL,NULL,99.9,0,NULL,NULL,'Aceite de girasol',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(3,NULL,NULL,NULL,0.1,0,887,NULL,0,'',NULL,NULL,NULL,99.9,0,NULL,NULL,'Aceite de oliva',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(4,NULL,NULL,NULL,70.4,17.8,117,NULL,0,'',NULL,NULL,NULL,0.23,1.2,NULL,NULL,'Ajo',NULL,3.9375,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1.1),(5,NULL,NULL,NULL,5.9,10,387,NULL,0,'',NULL,NULL,NULL,0.9,0.5,NULL,NULL,'Arroz',NULL,7,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0.2),(6,NULL,NULL,NULL,0,1,408,NULL,0,'',NULL,NULL,NULL,0,0.1,NULL,NULL,'Azúcar',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0.1),(7,NULL,NULL,NULL,91.1,40,24,NULL,0,'',NULL,NULL,NULL,0.8,1,NULL,NULL,'Brécol hervido',NULL,3.1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0.4),(8,NULL,NULL,NULL,88.4,124,65,NULL,14,'',NULL,NULL,NULL,3.8,0.09,NULL,NULL,'Leche de vaca entera',NULL,3.06,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0.38),(9,NULL,NULL,NULL,89.6,114,46,NULL,5,'',NULL,NULL,NULL,1.6,0.04,NULL,NULL,'Leche semidesnatada',NULL,3.2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0.4),(10,NULL,NULL,NULL,63.7,15,122,NULL,0,'',NULL,NULL,NULL,0.9,1.06,NULL,NULL,'Pasta integral',NULL,4.7,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0.81),(11,NULL,NULL,NULL,0,29,0,NULL,0,'',NULL,NULL,NULL,0,0.2,NULL,NULL,'Sal',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `ingredientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recetas`
--

DROP TABLE IF EXISTS `recetas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recetas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_at` datetime(6) DEFAULT NULL,
  `descripcion` varchar(255) NOT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `total_calorias` double DEFAULT NULL,
  `total_peso` double DEFAULT NULL,
  `cocinero_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKivljv2b54mks8huqkkfrsomke` (`cocinero_id`),
  CONSTRAINT `FKivljv2b54mks8huqkkfrsomke` FOREIGN KEY (`cocinero_id`) REFERENCES `cocineros` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recetas`
--

LOCK TABLES `recetas` WRITE;
/*!40000 ALTER TABLE `recetas` DISABLE KEYS */;
INSERT INTO `recetas` VALUES (1,'2021-10-30 00:00:00.000000','','Arroz con leche',NULL,NULL,1);
/*!40000 ALTER TABLE `recetas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recetas_items`
--

DROP TABLE IF EXISTS `recetas_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recetas_items` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cantidad` int DEFAULT NULL,
  `ingrediente_id` bigint DEFAULT NULL,
  `receta_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK56nkvu8cb4yjqe7hewgo79fjc` (`ingrediente_id`),
  KEY `FKgpbo75cvncu73f5166j3p3lu2` (`receta_id`),
  CONSTRAINT `FK56nkvu8cb4yjqe7hewgo79fjc` FOREIGN KEY (`ingrediente_id`) REFERENCES `ingredientes` (`id`),
  CONSTRAINT `FKgpbo75cvncu73f5166j3p3lu2` FOREIGN KEY (`receta_id`) REFERENCES `recetas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recetas_items`
--

LOCK TABLES `recetas_items` WRITE;
/*!40000 ALTER TABLE `recetas_items` DISABLE KEYS */;
INSERT INTO `recetas_items` VALUES (1,100,5,1);
/*!40000 ALTER TABLE `recetas_items` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-30 23:08:25
