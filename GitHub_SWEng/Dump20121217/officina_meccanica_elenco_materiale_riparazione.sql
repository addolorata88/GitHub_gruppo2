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
-- Table structure for table `elenco_materiale_riparazione`
--

DROP TABLE IF EXISTS `elenco_materiale_riparazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `elenco_materiale_riparazione` (
  `scheda_riparazione_idintervento_riparazione` int(11) NOT NULL,
  `ricambio_idricambio` int(11) NOT NULL,
  `quantità` int(11) DEFAULT NULL,
  `magazziniere_idmagazziniere` int(11) NOT NULL,
  PRIMARY KEY (`scheda_riparazione_idintervento_riparazione`,`ricambio_idricambio`,`magazziniere_idmagazziniere`),
  KEY `fk_scheda_riparazione_has_ricambio_ricambio1_idx` (`ricambio_idricambio`),
  KEY `fk_scheda_riparazione_has_ricambio_scheda_riparazione1_idx` (`scheda_riparazione_idintervento_riparazione`),
  KEY `fk_elenco_materiale_riparazione_magazziniere1_idx` (`magazziniere_idmagazziniere`),
  CONSTRAINT `fk_elenco_materiale_riparazione_magazziniere1` FOREIGN KEY (`magazziniere_idmagazziniere`) REFERENCES `magazziniere` (`idmagazziniere`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_scheda_riparazione_has_ricambio_ricambio1` FOREIGN KEY (`ricambio_idricambio`) REFERENCES `ricambio` (`idricambio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_scheda_riparazione_has_ricambio_scheda_riparazione1` FOREIGN KEY (`scheda_riparazione_idintervento_riparazione`) REFERENCES `scheda_riparazione` (`idintervento_riparazione`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elenco_materiale_riparazione`
--

LOCK TABLES `elenco_materiale_riparazione` WRITE;
/*!40000 ALTER TABLE `elenco_materiale_riparazione` DISABLE KEYS */;
INSERT INTO `elenco_materiale_riparazione` VALUES (1,2,2,0),(1,3,1,0),(2,1,1,0),(2,2,1,0),(4,3,2,0);
/*!40000 ALTER TABLE `elenco_materiale_riparazione` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-17 20:01:55
