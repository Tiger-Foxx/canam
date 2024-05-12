-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 15 nov. 2023 à 08:49
-- Version du serveur : 8.0.31
-- Version de PHP : 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `canam`
--
CREATE DATABASE IF NOT EXISTS `canam` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `canam`;

-- --------------------------------------------------------

--
-- Structure de la table `shape`
--

CREATE TABLE IF NOT EXISTS `shape` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(70) DEFAULT '''figure_Canam''',
  `type` varchar(70) NOT NULL,
  `color` varchar(150) NOT NULL,
  `is_plain` tinyint(1) NOT NULL,
  `x1` int NOT NULL,
  `y1` int NOT NULL,
  `x2` int NOT NULL,
  `y2` int NOT NULL,
  `r` double DEFAULT NULL,
  `angle` double DEFAULT NULL,
  `DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `shape`
--

INSERT INTO `shape` (`ID`, `name`, `type`, `color`, `is_plain`, `x1`, `y1`, `x2`, `y2`, `r`, `angle`, `DATE`) VALUES
(1, 'fugure Canam', 'Ellipse', '204 0 153', 0, 174, 129, 377, 302, 266, 0.7057796120643616, '2023-11-15 09:45:56'),
(2, 'fugure Canam', 'Hexagon', '204 204 0', 0, 390, 203, 518, 267, 143, 0.46364760398864746, '2023-11-15 09:45:56'),
(3, 'fugure Canam', 'Rectangle', '255 0 0', 0, 215, 102, 691, 262, 502, 0.32426944, '2023-11-15 09:45:56'),
(4, 'fugure Canam', 'Rectangle', '255 0 0', 1, 367, 161, 396, 358, 199, 1.4246379, '2023-11-15 09:45:56'),
(5, 'fugure Canam', 'Rhombus', '51 255 51', 0, 333, 112, 409, 197, 114, 0.84124064, '2023-11-15 09:45:56'),
(7, 'fugure Canam', 'Rectangle', '153 0 153', 1, 166, 79, 712, 321, 597, 0.41720426, '2023-11-15 09:45:56');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
