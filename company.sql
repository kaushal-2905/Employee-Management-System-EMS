-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 31, 2024 at 01:23 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `company`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_resign_emp` (INOUT `id1` INT, INOUT `name1` VARCHAR(50), INOUT `mail1` VARCHAR(50), INOUT `experience1` INT(50), INOUT `developer_type1` VARCHAR(50))   BEGIN
	INSERT INTO `resigned_employee`(`id`, `name`, `e-mail`, `experience`, `developer_type`) VALUES (id1,name1,mail1,experience1,developer_type1);
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  `role` varchar(30) NOT NULL,
  `e-mail` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `name`, `password`, `role`, `e-mail`) VALUES
(111, 'Admin', 'admin123', 'CEO', 'admin@gmail.com'),
(112, 'Kartik', 'k123', 'Director', 'kartik@gmail.com'),
(113, 'Abhisek', 'abc123', 'ProjectManager', 'abhisek@gmail.com'),
(114, 'Nitish', '123n10', 'Director', 'nitish@gmail.com'),
(115, 'Sunil', 's123', 'ProjectManager', 'sunil@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `project` varchar(50) NOT NULL,
  `experience` int(11) NOT NULL,
  `resignation` tinyint(1) NOT NULL,
  `e-mail` varchar(50) NOT NULL,
  `developer_type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `name`, `project`, `experience`, `resignation`, `e-mail`, `developer_type`) VALUES
(1111, 'Harry', 'SchoolApp', 5, 0, 'harry@gmail.com', 'Backend'),
(1112, 'Mayank', 'SchoolApp', 6, 0, 'mayank@gmail.com', 'Frontend'),
(1113, 'Ashwin', 'SchoolApp', 5, 1, 'ashwin@gmail.com', 'FullStack'),
(1114, 'Shivam', 'SchoolApp', 5, 0, 'shivam@gmail.com', 'Frontend'),
(1115, 'Nitish', 'SchoolApp', 7, 0, 'nitish@gmail.com', 'Frontend'),
(1116, 'Sunil', 'SchoolApp', 6, 0, 'sunil@gmail.com', 'Backend'),
(1117, 'Varun', 'ShoppingMartApp', 8, 0, 'varun@gmail.com', 'Frontend'),
(1118, 'Rahul', 'ShoppingMartApp', 7, 0, 'rahul@gmail.com', 'Backend'),
(1119, 'Ravi', 'ShoppingMartApp', 8, 0, 'ravi@gmail.com', 'Frontend'),
(1120, 'Jayant', 'ShoppingMartApp', 6, 1, 'jayant@gmail.com', 'Backend'),
(1121, 'Arjun', 'ShoppingMartApp', 7, 0, 'arjun@gmail.com', 'FullStack'),
(1122, 'Jitesh', 'GameApp', 10, 0, 'jitesh@gmail.com', 'Frontend'),
(1123, 'Rishi', 'GameApp', 10, 0, 'rishi@gmail.com', 'Backend'),
(1124, 'Ashwin', 'GameApp', 11, 0, 'ashwin@gmail.com', 'Backend'),
(1125, 'Navdeep', 'GameApp', 13, 0, 'navdeep@gmail.com', 'Frontend');

-- --------------------------------------------------------

--
-- Table structure for table `resigned_employee`
--

CREATE TABLE `resigned_employee` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `e-mail` varchar(50) NOT NULL,
  `experience` int(11) NOT NULL,
  `developer_type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `resigned_employee`
--

INSERT INTO `resigned_employee` (`id`, `name`, `e-mail`, `experience`, `developer_type`) VALUES
(1126, 'Arjun', 'arjun@gmail.com', 11, 'FullStack');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=116;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1131;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
