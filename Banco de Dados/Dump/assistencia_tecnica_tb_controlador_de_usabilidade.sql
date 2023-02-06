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
-- Table structure for table `tb_controlador_de_usabilidade`
--

DROP TABLE IF EXISTS `tb_controlador_de_usabilidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_controlador_de_usabilidade` (
  `id_cdu` int NOT NULL AUTO_INCREMENT,
  `telaPrincipal_cadastraOs_cdu` tinyint DEFAULT NULL,
  `telaPrincipal_cadastraConsultaPessoa_cdu` tinyint DEFAULT NULL,
  `telaPrincipal_cadastraAcesso_cdu` tinyint DEFAULT NULL,
  `telaPrincipal_cadastraUsabilidade_cdu` tinyint DEFAULT NULL,
  `telaPrincipal_cadastraSetor_cdu` tinyint DEFAULT NULL,
  `telaPrincipal_relatorioOs_cdu` tinyint DEFAULT NULL,
  `telaPrincipal_relatorioPessoa_cdu` tinyint DEFAULT NULL,
  `telaOs_deletar_cdu` tinyint DEFAULT NULL,
  `telaCadastraConsultaPessoa_dadosCliente_cdu` tinyint DEFAULT NULL,
  `telaCadastraConsultaPessoa_dadosFornecedor_cdu` tinyint DEFAULT NULL,
  `telaCadastraConsultaPessoa_dadosFuncionario_cdu` tinyint DEFAULT NULL,
  `telaCadastraConsultaPessoa_deletar_cdu` tinyint DEFAULT NULL,
  `telaCadastraConsultaPessoa_cadastraTelefone_cdu` tinyint DEFAULT NULL,
  `telaCadastraConsultaPessoa_cadastraEmail_cdu` tinyint DEFAULT NULL,
  `telaCadastraConsultaPessoa_cadastraEndereco_cdu` tinyint DEFAULT NULL,
  `telaCadastraConsultaPessoa_referenciaCliente_cdu` tinyint DEFAULT NULL,
  `telaCadastraConsultaPessoa_referenciaFornecedor_cdu` tinyint DEFAULT NULL,
  `telaCadastraConsultaPessoa_referenciaFuncionario_cdu` tinyint DEFAULT NULL,
  `telaCadastraDadosCliente_deletar_cdu` tinyint DEFAULT NULL,
  `telaCadastraDadosFornecedor_deletar_cdu` tinyint DEFAULT NULL,
  `telaCadastraDadosFuncionario_deletar_cdu` tinyint DEFAULT NULL,
  `telaCadastraTelefone_deletar_cdu` tinyint DEFAULT NULL,
  `telaCadastraEmail_deletar_cdu` tinyint DEFAULT NULL,
  `telaCadastraEndereco_deletar_cdu` tinyint DEFAULT NULL,
  `telaCadastraAcesso_deletar_cdu` tinyint DEFAULT NULL,
  `id_pessoa_fk_cdu` int DEFAULT NULL,
  PRIMARY KEY (`id_cdu`),
  KEY `id_pessoa_fk_cdu` (`id_pessoa_fk_cdu`),
  CONSTRAINT `tb_controlador_de_usabilidade_ibfk_1` FOREIGN KEY (`id_pessoa_fk_cdu`) REFERENCES `tb_pessoa` (`id_pes`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_controlador_de_usabilidade`
--

LOCK TABLES `tb_controlador_de_usabilidade` WRITE;
/*!40000 ALTER TABLE `tb_controlador_de_usabilidade` DISABLE KEYS */;
INSERT INTO `tb_controlador_de_usabilidade` VALUES (1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2);
/*!40000 ALTER TABLE `tb_controlador_de_usabilidade` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-02 23:48:36
