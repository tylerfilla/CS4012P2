-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Oct 26, 2018 at 07:21 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `enterprise`
--

-- --------------------------------------------------------

--
-- Table structure for table `edu`
--

CREATE TABLE `edu` (
  `id` int(10) UNSIGNED NOT NULL COMMENT 'The unique ID',
  `user` int(10) UNSIGNED NOT NULL COMMENT 'ID of the user',
  `institution` varchar(256) NOT NULL COMMENT 'The institution name',
  `degree_type` varchar(64) NOT NULL COMMENT 'The degree type',
  `degree_discipline` varchar(64) NOT NULL COMMENT 'The degree discipline',
  `year` int(11) NOT NULL COMMENT 'The year of achievement'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='A table of education history';

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(10) UNSIGNED NOT NULL COMMENT 'The unique ID',
  `username` varchar(64) NOT NULL COMMENT 'The username',
  `password` varchar(256) NOT NULL COMMENT 'The password (insecure)',
  `fname` varchar(64) NOT NULL COMMENT 'The user first name',
  `lname` varchar(64) NOT NULL COMMENT 'The user last name',
  `addr_body` varchar(512) NOT NULL COMMENT 'The address body',
  `addr_city` varchar(32) NOT NULL COMMENT 'The address city',
  `addr_state` varchar(32) NOT NULL COMMENT 'The address state',
  `addr_zip` varchar(32) NOT NULL COMMENT 'The address ZIP',
  `birthday` date NOT NULL COMMENT 'The user birthday',
  `phone_home` varchar(32) NOT NULL COMMENT 'The user home phone number',
  `phone_cell` varchar(32) NOT NULL COMMENT 'The user cell phone number',
  `time_zone` varchar(32) NOT NULL COMMENT 'The user time zone',
  `profile_image` longblob NOT NULL COMMENT 'The user profile image'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='User information table';

-- --------------------------------------------------------

--
-- Table structure for table `work`
--

CREATE TABLE `work` (
  `id` int(10) UNSIGNED NOT NULL COMMENT 'The unique ID',
  `user` int(10) UNSIGNED NOT NULL COMMENT 'ID of the user',
  `company` varchar(256) NOT NULL COMMENT 'The company name',
  `title` varchar(256) NOT NULL COMMENT 'The title held',
  `years` int(11) NOT NULL COMMENT 'Years of service'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='A table of work history';

--
-- Indexes for dumped tables
--

--
-- Indexes for table `edu`
--
ALTER TABLE `edu`
  ADD PRIMARY KEY (`id`),
  ADD KEY `edu_user` (`user`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `USERNAME` (`username`);

--
-- Indexes for table `work`
--
ALTER TABLE `work`
  ADD PRIMARY KEY (`id`),
  ADD KEY `work_user` (`user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `edu`
--
ALTER TABLE `edu`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'The unique ID';

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'The unique ID';

--
-- AUTO_INCREMENT for table `work`
--
ALTER TABLE `work`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'The unique ID';

--
-- Constraints for dumped tables
--

--
-- Constraints for table `edu`
--
ALTER TABLE `edu`
  ADD CONSTRAINT `edu_user` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `work`
--
ALTER TABLE `work`
  ADD CONSTRAINT `work_user` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
