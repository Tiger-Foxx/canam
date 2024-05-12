-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mar. 14 nov. 2023 à 13:35
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
-- Base de données : `shapes`
--
CREATE DATABASE IF NOT EXISTS `shapes` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `shapes`;

-- --------------------------------------------------------

--
-- Structure de la table `shape`
--

DROP TABLE IF EXISTS `shape`;
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
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
