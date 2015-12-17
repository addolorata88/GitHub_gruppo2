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
-- Table structure for table `scheda_riparazione`
--

DROP TABLE IF EXISTS `scheda_riparazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scheda_riparazione` (
  `idintervento_riparazione` int(11) NOT NULL AUTO_INCREMENT,
  `marca_veicolo` varchar(45) NOT NULL,
  `modello_veicolo` varchar(45) NOT NULL,
  `data_entrata_officina` varchar(20) NOT NULL,
  `data_immatricolazione` varchar(20) NOT NULL,
  `descrizione_intervento` varchar(45) NOT NULL,
  `data_evasione_richiesta` varchar(45) DEFAULT NULL,
  `nome_cliente` varchar(45) NOT NULL,
  `cognome_cliente` varchar(45) NOT NULL,
  `tel_cliente` varchar(45) NOT NULL,
  `email_cliente` varchar(45) NOT NULL,
  `id_meccanico` int(11) NOT NULL,
  PRIMARY KEY (`idintervento_riparazione`),
  UNIQUE KEY `email_cliente_UNIQUE` (`email_cliente`),
  UNIQUE KEY `idintervento_riparazione_UNIQUE` (`idintervento_riparazione`),
  KEY `idmeccanico_idx` (`id_meccanico`),
  CONSTRAINT `idmeccanico` FOREIGN KEY (`id_meccanico`) REFERENCES `meccanico` (`idmeccanico`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scheda_riparazione`
--

LOCK TABLES `scheda_riparazione` WRITE;
/*!40000 ALTER TABLE `scheda_riparazione` DISABLE KEYS */;
INSERT INTO `scheda_riparazione` VALUES (1,'volkswagen','polo','2015-12-11','2011-01-01','revisione freni','2015-12-15','Eleonora','Ricci','518651','e.r@gmail.com',1),(2,'fiat','bravo','2015-12-01','2015-06-01','cambio olio','2015-12-05','Domenico','Sangiuliano','652656','d.s@hotmail.it',2),(3,'citroen','c4','2015-11-28','2011-05-01','sostituzione faro ant dx','2015-12-01','Addolorata','Montaquila','516531','a.m@gmail.com',1),(4,'ford','fiesta','2015-12-15','2014-04-01','regolazione fari','2015-12-16','Pino','Di Meo','184684','p.d@hotmail.it',3),(5,'opel','meriva','2015-11-22','2012-01-01','cambio pneumatici','2015-11-28','Simona','Valentino','514684','s.v@gmail.com',2),(6,'dacia','duster','2015-11-26','2010-09-01','revisione centralina','2015-12-05','Luca','Abete','561466','l.a@hotmail.it',4);
/*!40000 ALTER TABLE `scheda_riparazione` ENABLE KEYS */;
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
