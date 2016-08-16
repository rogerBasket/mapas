-- MySQL dump 10.13  Distrib 5.6.30, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: mapbici
-- ------------------------------------------------------
-- Server version	5.6.30-0ubuntu0.14.04.1

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
-- Table structure for table `mapas`
--

DROP TABLE IF EXISTS `mapas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mapas` (
  `id_mapa` int(11) NOT NULL AUTO_INCREMENT,
  `latitud1` double NOT NULL,
  `longitud1` double NOT NULL,
  `latitud2` double NOT NULL,
  `longitud2` double NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `nombre` datetime NOT NULL,
  PRIMARY KEY (`id_mapa`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `mapas_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mapas`
--

LOCK TABLES `mapas` WRITE;
/*!40000 ALTER TABLE `mapas` DISABLE KEYS */;
INSERT INTO `mapas` VALUES (1,19.459147029331085,-99.16912078857422,19.396658607621543,-99.08191680908203,5,'2016-05-28 17:24:37'),(8,19.462707821188026,-99.14817810058594,19.400868427018917,-99.06234741210938,5,'2016-05-29 23:15:41'),(9,19.454291278067455,-99.16740417480469,19.36686292808578,-99.11384582519531,5,'2016-05-29 23:20:04'),(10,19.444741209892165,-99.1431999206543,19.42661072109788,-99.11710739135742,2,'2016-05-29 23:23:31'),(11,19.45008284272312,-99.14594650268555,19.43421929772404,-99.11144256591797,2,'2016-05-29 23:30:57'),(12,19.459470740912835,-99.151611328125,19.442798754361004,-99.12328720092773,2,'2016-05-30 00:10:19'),(13,19.462707821188026,-99.16723251342773,19.42920091485609,-99.10354614257812,2,'2016-05-30 00:30:51'),(14,19.446683642175046,-99.15864944458008,19.406697227887108,-99.12191390991211,5,'2016-05-30 13:34:29');
/*!40000 ALTER TABLE `mapas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paginas`
--

DROP TABLE IF EXISTS `paginas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paginas` (
  `id_pagina` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  PRIMARY KEY (`id_pagina`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paginas`
--

LOCK TABLES `paginas` WRITE;
/*!40000 ALTER TABLE `paginas` DISABLE KEYS */;
INSERT INTO `paginas` VALUES (1,'NuevoMapaJSP'),(2,'GuardarMapaAction'),(3,'ListarMapasAction'),(4,'VerMapaAction'),(5,'BorrarMapaAction'),(6,'SalirAction'),(7,'ListarUsuariosAction'),(8,'BorrarUsuarioAction'),(9,'ContribucionesAction'),(10,'VerUsuarioAction'),(11,'MapasUsuarioAction'),(12,'PerfilJSP'),(13,'PerfilAction');
/*!40000 ALTER TABLE `paginas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfiles`
--

DROP TABLE IF EXISTS `perfiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perfiles` (
  `id_perfil` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(30) NOT NULL,
  PRIMARY KEY (`id_perfil`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfiles`
--

LOCK TABLES `perfiles` WRITE;
/*!40000 ALTER TABLE `perfiles` DISABLE KEYS */;
INSERT INTO `perfiles` VALUES (1,'administrador'),(2,'usuario');
/*!40000 ALTER TABLE `perfiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfiles_paginas`
--

DROP TABLE IF EXISTS `perfiles_paginas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perfiles_paginas` (
  `id_perfil` int(11) NOT NULL,
  `id_pagina` int(11) NOT NULL,
  PRIMARY KEY (`id_perfil`,`id_pagina`),
  KEY `id_pagina` (`id_pagina`),
  CONSTRAINT `perfiles_paginas_ibfk_1` FOREIGN KEY (`id_perfil`) REFERENCES `perfiles` (`id_perfil`),
  CONSTRAINT `perfiles_paginas_ibfk_2` FOREIGN KEY (`id_pagina`) REFERENCES `paginas` (`id_pagina`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfiles_paginas`
--

LOCK TABLES `perfiles_paginas` WRITE;
/*!40000 ALTER TABLE `perfiles_paginas` DISABLE KEYS */;
INSERT INTO `perfiles_paginas` VALUES (2,1),(2,2),(2,3),(2,4),(2,5),(1,6),(2,6),(1,7),(1,8),(2,9),(1,10),(1,11),(2,12),(2,13);
/*!40000 ALTER TABLE `perfiles_paginas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(30) NOT NULL,
  `pass` varchar(30) NOT NULL,
  `id_perfil` int(11) NOT NULL,
  `cumple` date NOT NULL,
  `mail` varchar(40) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `id_perfil` (`id_perfil`),
  CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`id_perfil`) REFERENCES `perfiles` (`id_perfil`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (2,'gama','halo',2,'2016-05-12','gama@gmail.com'),(3,'admin','admin',1,'2016-05-22','admin@gmail.com'),(4,'mirna','anime',2,'2016-05-03','mirna@gmail.com'),(5,'roger13','algo',2,'2016-05-31','roger@gmail.com'),(6,'user','pass',2,'2016-06-27','prueba@gmail.com'),(7,'user1','pass1',2,'2016-06-27','prueba1@gmail.com'),(8,'user1','pass1',2,'2016-06-27','prueba1@gmail.com'),(9,'user1','pass1',2,'2016-06-27','prueba1@gmail.com'),(10,'user1','pass1',2,'2016-06-27','prueba1@gmail.com'),(11,'user1','pass1',2,'2016-06-27','prueba1@gmail.com');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-16 14:43:07
