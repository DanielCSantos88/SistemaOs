-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: assistencia_tecnica
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
-- Table structure for table `tb_os`
--

DROP TABLE IF EXISTS `tb_os`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_os` (
  `id_os` int NOT NULL AUTO_INCREMENT,
  `data_os` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `tipo_os` int NOT NULL,
  `situacao_os` varchar(30) NOT NULL,
  `id_marca_fk_os` int NOT NULL,
  `id_produto_fk_os` int NOT NULL,
  `id_defeito_fk_os` int NOT NULL,
  `id_servico_fk_os` int NOT NULL,
  `id_funcionario_fk_os` int NOT NULL,
  `id_cliente_fk_os` int NOT NULL,
  `valor_os` varchar(15) NOT NULL,
  PRIMARY KEY (`id_os`),
  KEY `id_marca_fk_os` (`id_marca_fk_os`),
  KEY `id_produto_fk_os` (`id_produto_fk_os`),
  KEY `id_defeito_fk_os` (`id_defeito_fk_os`),
  KEY `id_servico_fk_os` (`id_servico_fk_os`),
  KEY `id_funcionario_fk_os` (`id_funcionario_fk_os`),
  KEY `id_cliente_fk_os` (`id_cliente_fk_os`),
  CONSTRAINT `tb_os_ibfk_1` FOREIGN KEY (`id_marca_fk_os`) REFERENCES `tb_marca` (`id_mar`),
  CONSTRAINT `tb_os_ibfk_2` FOREIGN KEY (`id_produto_fk_os`) REFERENCES `tb_produto` (`id_pro`),
  CONSTRAINT `tb_os_ibfk_3` FOREIGN KEY (`id_defeito_fk_os`) REFERENCES `tb_defeito` (`id_def`),
  CONSTRAINT `tb_os_ibfk_4` FOREIGN KEY (`id_servico_fk_os`) REFERENCES `tb_servico` (`id_ser`),
  CONSTRAINT `tb_os_ibfk_5` FOREIGN KEY (`id_funcionario_fk_os`) REFERENCES `tb_pessoa` (`id_pes`),
  CONSTRAINT `tb_os_ibfk_6` FOREIGN KEY (`id_cliente_fk_os`) REFERENCES `tb_pessoa` (`id_pes`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_os`
--

LOCK TABLES `tb_os` WRITE;
/*!40000 ALTER TABLE `tb_os` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_os` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-02 23:48:35
