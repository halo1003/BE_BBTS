-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 05, 2018 at 11:55 AM
-- Server version: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `hf18bbts`
--

-- --------------------------------------------------------

--
-- Table structure for table `bus`
--

CREATE TABLE IF NOT EXISTS `bus` (
  `idbus` int(11) NOT NULL,
  `busnumber` varchar(45) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bus`
--

INSERT INTO `bus` (`idbus`, `busnumber`) VALUES
(13, 'So 8'),
(14, 'So 7');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(175);

-- --------------------------------------------------------

--
-- Table structure for table `persistentlogins`
--

CREATE TABLE IF NOT EXISTS `persistentlogins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM AUTO_INCREMENT=151 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'ROLE_CUSTOMER'),
(2, 'ROLE_SELLER'),
(3, 'ROLE_ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE IF NOT EXISTS `ticket` (
  `idticket` int(11) NOT NULL,
  `timecreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `isavailable` tinyint(1) NOT NULL,
  `numberseat` int(11) NOT NULL,
  `bus_idbus` int(11) NOT NULL,
  `tour_idtour` int(11) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ticket`
--

INSERT INTO `ticket` (`idticket`, `timecreate`, `isavailable`, `numberseat`, `bus_idbus`, `tour_idtour`, `user_id`) VALUES
(1, '2018-09-05 06:15:23', 1, 2, 14, 6, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tour`
--

CREATE TABLE IF NOT EXISTS `tour` (
  `idtour` int(11) NOT NULL,
  `startplace` varchar(255) NOT NULL,
  `endplace` varchar(255) NOT NULL,
  `starttime` datetime DEFAULT NULL,
  `endtime` datetime DEFAULT NULL,
  `totalseats` int(11) NOT NULL,
  `isavailable` tinyint(4) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tour`
--

INSERT INTO `tour` (`idtour`, `startplace`, `endplace`, `starttime`, `endtime`, `totalseats`, `isavailable`) VALUES
(5, 'HCM', 'HN', '2018-09-04 00:00:00', '2018-09-07 00:00:00', 45, 1),
(6, 'Q1', 'Q9', '2018-09-04 00:00:00', '2018-09-06 00:00:00', 45, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `active`, `age`, `email`, `name`, `password`, `phone`, `username`) VALUES
(1, b'1', 12, 'localhost@example.com', 'Chau Qui', '123456789', '123123', 'buontaochoi');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE IF NOT EXISTS `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(175, 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bus`
--
ALTER TABLE `bus`
  ADD PRIMARY KEY (`idbus`);

--
-- Indexes for table `persistentlogins`
--
ALTER TABLE `persistentlogins`
  ADD PRIMARY KEY (`series`,`user_id`), ADD KEY `token_user` (`user_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`idticket`), ADD KEY `fk_ticket_bus` (`bus_idbus`), ADD KEY `fk_ticket_tour` (`tour_idtour`), ADD KEY `fk_ticket_user` (`user_id`);

--
-- Indexes for table `tour`
--
ALTER TABLE `tour`
  ADD PRIMARY KEY (`idtour`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `UniqueUsername` (`username`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`user_id`,`role_id`), ADD KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bus`
--
ALTER TABLE `bus`
  MODIFY `idbus` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=151;
--
-- AUTO_INCREMENT for table `ticket`
--
ALTER TABLE `ticket`
  MODIFY `idticket` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tour`
--
ALTER TABLE `tour`
  MODIFY `idtour` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `persistentlogins`
--
ALTER TABLE `persistentlogins`
ADD CONSTRAINT `token_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `ticket`
--
ALTER TABLE `ticket`
ADD CONSTRAINT `FKdvt57mcco3ogsosi97odw563o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
ADD CONSTRAINT `FKh60faup2utamjsas76ukdps2e` FOREIGN KEY (`bus_idbus`) REFERENCES `bus` (`idbus`),
ADD CONSTRAINT `FKtdx2r8tqoucg3yd25yvhe36pq` FOREIGN KEY (`tour_idtour`) REFERENCES `tour` (`idtour`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
