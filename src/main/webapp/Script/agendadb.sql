CREATE DATABASE `agendadb` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE IF NOT EXISTS `pessoa` (
  `cod` int(10) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `cpf` varchar(45) DEFAULT NULL,
  `dataNascimento` date DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `telefone` (
  `cod` int(10) NOT NULL AUTO_INCREMENT,
  `ddd` varchar(45) DEFAULT NULL,
  `numero` varchar(45) DEFAULT NULL,
  `cod_pessoa` int(10) DEFAULT NULL,
  PRIMARY KEY (`cod`),
  KEY `cod_pessoa` (`cod_pessoa`),
  CONSTRAINT `telefone_ibfk_1` FOREIGN KEY (`cod_pessoa`) REFERENCES `pessoa` (`cod`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;