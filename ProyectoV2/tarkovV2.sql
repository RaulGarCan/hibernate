CREATE DATABASE  IF NOT EXISTS `tarkov` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `tarkov`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: tarkov
-- ------------------------------------------------------
-- Server version	8.2.0

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
-- Table structure for table `armas`
--

DROP TABLE IF EXISTS `armas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `armas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `tipo` varchar(30) NOT NULL,
  `calibre` varchar(30) NOT NULL,
  `precio` int unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `armas`
--

LOCK TABLES `armas` WRITE;
/*!40000 ALTER TABLE `armas` DISABLE KEYS */;
INSERT INTO `armas` VALUES (7,'arma1','FUSIL','55645',642),(8,'2','FUSIL','2',3),(9,'armanueva','SUBFUSIL','3',1),(11,'a','FUSIL','1',1),(14,'a','FUSIL','1',1),(15,'a','FUSIL','1',1),(16,'a','FUSIL','1',1),(19,'a','FUSIL','1',1),(31,'a','FUSIL','1',1),(32,'a','FUSIL','1',1);
/*!40000 ALTER TABLE `armas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auriculares`
--

DROP TABLE IF EXISTS `auriculares`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auriculares` (
  `nombre` varchar(30) NOT NULL,
  `precio` int unsigned NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auriculares`
--

LOCK TABLES `auriculares` WRITE;
/*!40000 ALTER TABLE `auriculares` DISABLE KEYS */;
INSERT INTO `auriculares` VALUES ('a',1),('auris1',74),('auris2',46);
/*!40000 ALTER TABLE `auriculares` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cascos`
--

DROP TABLE IF EXISTS `cascos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cascos` (
  `nombre` varchar(30) NOT NULL,
  `armorclass` int unsigned NOT NULL,
  `precio` int unsigned NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cascos`
--

LOCK TABLES `cascos` WRITE;
/*!40000 ALTER TABLE `cascos` DISABLE KEYS */;
INSERT INTO `cascos` VALUES ('a',1,1),('casco1',3,64),('casco2',4,3);
/*!40000 ALTER TABLE `cascos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chalecos`
--

DROP TABLE IF EXISTS `chalecos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chalecos` (
  `nombre` varchar(30) NOT NULL,
  `armorclass` int unsigned NOT NULL,
  `precio` int unsigned NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chalecos`
--

LOCK TABLES `chalecos` WRITE;
/*!40000 ALTER TABLE `chalecos` DISABLE KEYS */;
INSERT INTO `chalecos` VALUES ('',1,1),('3',2,1),('a',1,1),('chaleco1',6,54);
/*!40000 ALTER TABLE `chalecos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipamientos`
--

DROP TABLE IF EXISTS `equipamientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipamientos` (
  `nombre` varchar(30) NOT NULL,
  `casco` varchar(30) NOT NULL,
  `auriculares` varchar(30) NOT NULL,
  `chaleco` varchar(30) NOT NULL,
  `idarmaprincipal` int NOT NULL,
  PRIMARY KEY (`nombre`),
  KEY `FK_equipamientosarmaprincipal` (`idarmaprincipal`),
  KEY `FK_equipamientosauriculares` (`auriculares`),
  KEY `FK_equipamientoscascos` (`casco`),
  KEY `FK_equipamientoschalecos` (`chaleco`),
  CONSTRAINT `FK_equipamientosarmaprincipal` FOREIGN KEY (`idarmaprincipal`) REFERENCES `armas` (`id`),
  CONSTRAINT `FK_equipamientosauriculares` FOREIGN KEY (`auriculares`) REFERENCES `auriculares` (`nombre`),
  CONSTRAINT `FK_equipamientoscascos` FOREIGN KEY (`casco`) REFERENCES `cascos` (`nombre`),
  CONSTRAINT `FK_equipamientoschalecos` FOREIGN KEY (`chaleco`) REFERENCES `chalecos` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipamientos`
--

LOCK TABLES `equipamientos` WRITE;
/*!40000 ALTER TABLE `equipamientos` DISABLE KEYS */;
INSERT INTO `equipamientos` VALUES ('prueba','casco1','auris1','chaleco1',7),('prueba2','casco2','auris2','3',8),('pruebaArmas','a','a','a',7),('pruebaArmasNew','a','a','',9);
/*!40000 ALTER TABLE `equipamientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `piezas`
--

DROP TABLE IF EXISTS `piezas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `piezas` (
  `nombre` varchar(30) NOT NULL,
  `ergonomia` int NOT NULL,
  `retroceso` int NOT NULL,
  `tipo` varchar(30) NOT NULL,
  `precio` int unsigned NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piezas`
--

LOCK TABLES `piezas` WRITE;
/*!40000 ALTER TABLE `piezas` DISABLE KEYS */;
INSERT INTO `piezas` VALUES ('a',1,2,'BOCACHA',1),('pieza1',1,1,'BOCACHA',1),('piezanueva',1,2,'BOCACHA',1),('prueba3',1,2,'CULATA',7);
/*!40000 ALTER TABLE `piezas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `piezasarmas`
--

DROP TABLE IF EXISTS `piezasarmas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `piezasarmas` (
  `idarma` int NOT NULL,
  `idpieza` varchar(30) NOT NULL,
  PRIMARY KEY (`idarma`,`idpieza`),
  KEY `FK_piezasarmaspiezas` (`idpieza`),
  CONSTRAINT `FK_piezasarmasarmas` FOREIGN KEY (`idarma`) REFERENCES `armas` (`id`),
  CONSTRAINT `FK_piezasarmaspiezas` FOREIGN KEY (`idpieza`) REFERENCES `piezas` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piezasarmas`
--

LOCK TABLES `piezasarmas` WRITE;
/*!40000 ALTER TABLE `piezasarmas` DISABLE KEYS */;
INSERT INTO `piezasarmas` VALUES (19,'a'),(14,'pieza1'),(15,'pieza1'),(31,'pìeza1'),(11,'piezanueva'),(15,'piezanueva'),(16,'piezanueva'),(32,'prueba3');
/*!40000 ALTER TABLE `piezasarmas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-13 23:02:40
