-- --------------------------------------------------------
-- Hôte :                        127.0.0.1
-- Version du serveur:           5.7.14 - MySQL Community Server (GPL)
-- SE du serveur:                Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Export de la structure de la base pour openpms
CREATE DATABASE IF NOT EXISTS `openpms` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `openpms`;

-- Export de la structure de la table openpms. prj_project
CREATE TABLE IF NOT EXISTS `prj_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `short_name` varchar(5) NOT NULL,
  `description` text NOT NULL,
  `prj_status_id` int(11) NOT NULL,
  `expected_start_date` date NOT NULL,
  `expected_end_date` date NOT NULL,
  `actual_start_date` date DEFAULT NULL,
  `actual_end_date` date DEFAULT NULL,
  `open_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` date DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `update_by` int(11) DEFAULT NULL,
  `assigned_to` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_STATUS` (`prj_status_id`),
  KEY `FK_PRJ_ASSIGN` (`assigned_to`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Export de données de la table openpms.prj_project : 0 rows
/*!40000 ALTER TABLE `prj_project` DISABLE KEYS */;
/*!40000 ALTER TABLE `prj_project` ENABLE KEYS */;

-- Export de la structure de la table openpms. prj_project_history
CREATE TABLE IF NOT EXISTS `prj_project_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prj_project_id` int(11) NOT NULL,
  `short_name` varchar(5) NOT NULL,
  `description` text NOT NULL,
  `prj_status_id` int(11) NOT NULL,
  `assigned_to` int(11) NOT NULL,
  `expected_start_date` date DEFAULT NULL,
  `expected_end_date` date DEFAULT NULL,
  `actual_start_date` date DEFAULT NULL,
  `actual_end_date` date DEFAULT NULL,
  `open_date` timestamp NULL DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `update_by` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Export de données de la table openpms.prj_project_history : 0 rows
/*!40000 ALTER TABLE `prj_project_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `prj_project_history` ENABLE KEYS */;

-- Export de la structure de la table openpms. prj_status
CREATE TABLE IF NOT EXISTS `prj_status` (
  `id` int(11) NOT NULL,
  `description` varchar(50) NOT NULL,
  `archived` char(1) NOT NULL,
  `sortingKey` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Export de données de la table openpms.prj_status : 0 rows
/*!40000 ALTER TABLE `prj_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `prj_status` ENABLE KEYS */;

-- Export de la structure de la table openpms. tsk_status
CREATE TABLE IF NOT EXISTS `tsk_status` (
  `id` int(11) NOT NULL,
  `description` varchar(50) NOT NULL,
  `archived` char(1) NOT NULL,
  `sortingKey` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Export de données de la table openpms.tsk_status : 0 rows
/*!40000 ALTER TABLE `tsk_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `tsk_status` ENABLE KEYS */;

-- Export de la structure de la table openpms. tsk_task
CREATE TABLE IF NOT EXISTS `tsk_task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `short_name` varchar(5) NOT NULL,
  `description` text NOT NULL,
  `tsk_status_id` int(11) NOT NULL,
  `prj_project_id` int(11) NOT NULL,
  `assigned_to` int(11) NOT NULL,
  `expected_start_date` date NOT NULL,
  `expected_end_date` date NOT NULL,
  `actual_start_date` date DEFAULT NULL,
  `actual_end_date` date DEFAULT NULL,
  `open_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` date DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `update_by` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_TSK_STATUS` (`tsk_status_id`),
  KEY `FK_TSK_PROJECT` (`prj_project_id`),
  KEY `FK_TSK_ASSIGN` (`assigned_to`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Export de données de la table openpms.tsk_task : 0 rows
/*!40000 ALTER TABLE `tsk_task` DISABLE KEYS */;
/*!40000 ALTER TABLE `tsk_task` ENABLE KEYS */;

-- Export de la structure de la table openpms. tsk_task_history
CREATE TABLE IF NOT EXISTS `tsk_task_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tsk_task_id` int(11) NOT NULL,
  `short_name` varchar(5) NOT NULL,
  `description` text NOT NULL,
  `tsk_status_id` int(11) NOT NULL,
  `prj_project_id` int(11) NOT NULL,
  `assigned_to` int(11) NOT NULL,
  `expected_start_date` date NOT NULL,
  `expected_end_date` date NOT NULL,
  `actual_start_date` date DEFAULT NULL,
  `actual_end_date` date DEFAULT NULL,
  `open_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` date DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `update_by` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Export de données de la table openpms.tsk_task_history : 0 rows
/*!40000 ALTER TABLE `tsk_task_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `tsk_task_history` ENABLE KEYS */;

-- Export de la structure de la table openpms. us_status
CREATE TABLE IF NOT EXISTS `us_status` (
  `id` int(11) NOT NULL,
  `description` varchar(50) NOT NULL,
  `archived` char(1) NOT NULL,
  `sortingKey` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Export de données de la table openpms.us_status : 0 rows
/*!40000 ALTER TABLE `us_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `us_status` ENABLE KEYS */;

-- Export de la structure de la table openpms. us_users
CREATE TABLE IF NOT EXISTS `us_users` (
  `id` int(11) NOT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `us_status_id` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `family_name` varchar(50) DEFAULT NULL,
  `adress` varchar(200) DEFAULT NULL,
  `tel` varchar(10) DEFAULT NULL,
  `url_picture` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_US_STATUS` (`us_status_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Export de données de la table openpms.us_users : 0 rows
/*!40000 ALTER TABLE `us_users` DISABLE KEYS */;
/*!40000 ALTER TABLE `us_users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
