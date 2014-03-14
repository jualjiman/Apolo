-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.19


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema sadinbd
--

CREATE DATABASE IF NOT EXISTS sadinbd;
USE sadinbd;

--
-- Definition of table `costohabitaciones`
--

DROP TABLE IF EXISTS `costohabitaciones`;
CREATE TABLE `costohabitaciones` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idHabitacion` int(10) unsigned NOT NULL,
  `fini` date NOT NULL,
  `ffin` date NOT NULL,
  `costo` decimal(10,2) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `idUsuarioMod` int(10) unsigned NOT NULL,
  `fechaHora` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `costohabitaciones`
--

/*!40000 ALTER TABLE `costohabitaciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `costohabitaciones` ENABLE KEYS */;


--
-- Definition of table `habitaciones`
--

DROP TABLE IF EXISTS `habitaciones`;
CREATE TABLE `habitaciones` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) NOT NULL,
  `capMax` int(10) unsigned NOT NULL,
  `descripcion` text NOT NULL,
  `vista` int(10) unsigned NOT NULL,
  `idUsuarioMod` int(10) unsigned NOT NULL,
  `fechaHora` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `habitaciones`
--

/*!40000 ALTER TABLE `habitaciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `habitaciones` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
