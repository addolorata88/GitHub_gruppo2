CREATE DATABASE  IF NOT EXISTS `officina_meccanica` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `officina_meccanica`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: officina_meccanica
-- ------------------------------------------------------
-- Server version	5.7.9-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `meccanico`
--

DROP TABLE IF EXISTS `meccanico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meccanico` (
  `idmeccanico` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `data_assunzione` varchar(45) NOT NULL,
  `scadenza_contratto` varchar(45) NOT NULL,
  `carico_lavoro(num auto)` int(11) DEFAULT NULL,
  PRIMARY KEY (`idmeccanico`,`email`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meccanico`
--

LOCK TABLES `meccanico` WRITE;
/*!40000 ALTER TABLE `meccanico` DISABLE KEYS */;
INSERT INTO `meccanico` VALUES (1,'Simone','Lanni','536146846','s.l@hotmail.it','2011-01-10','2021-01-10',2),(2,'Anna','Mignelli','851481648','a.m@hotmail.it','2012-02-10','2022-02-10',2),(3,'Paolo','Ferruccio','268136884','p.f@hotmail.it','2009-03-10','2019-03-10',1),(4,'Carlo','Conti','514568414','c.c@gmail.com','2012-06-10','2022-06-10',1),(5,'Paolo','Bonolis','563161484','p.b@gmail.com','2011-07-10','2021-07-10',3),(6,'Enzo','Salvi','416542455','e.s@gmail.com','2012-02-15','2015-02-15',2);
/*!40000 ALTER TABLE `meccanico` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-17 20:01:54
