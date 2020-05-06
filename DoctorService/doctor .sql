-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 04, 2020 at 07:26 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `doctor`
--

-- --------------------------------------------------------

--
-- Table structure for table `doctors`
--

CREATE TABLE `doctors` (
  `doctorID` int(12) NOT NULL,
  `doctorCode` varchar(50) NOT NULL,
  `doctorNic` varchar(200) NOT NULL,
  `doctorName` varchar(200) NOT NULL,
  `doctorDesc` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `doctors`
--

INSERT INTO `doctors` (`doctorID`, `doctorCode`, `doctorNic`, `doctorName`, `doctorDesc`) VALUES
(2, 'D002', '676548365V', 'dr.Kemal Deen', ' Sri Lankan academic surgeon, and a consultant in GastroIntestinal Surgery. Currently, he is the chairman and senior professor of surgery at the University of Kelaniya Medical School, Sri Lanka. '),
(3, 'D003', '874563754V', 'dr.udaya senawirathna', 'MBBS, MSc, MD, FRCP (Lon) (born 13 June 1965) is a Sri Lankan Academic and Consultant Gastroenterologist. He is the Head of the Department of Medicine, Faculty of Medicine University of Kelaniya and C'),
(4, 'D021', 'dr.oshini malsha', 'dr.oshini malsha', 'spe'),
(5, 'D005', '876543895V', 'dr.rachini bawani', ' He is the Head of the Department of Medicine, Faculty of Medicine University of Kelaniya and Chairman of the Sri Lanka Anti-Doping Agency (SLADA).'),
(6, 'D006', '653743895V', 'dr.kasuni ishanga', '  Faculty of Medicine University of Kelaniya and Chairman of the Sri Lanka Anti-Doping Agency (SLADA).'),
(12, 'D029', '986575763V', 'dr.sajeentha ', 'radiologist'),
(13, 'D021', '786773728v', 'dr.oshini malsha', 'radiologist'),
(14, 'D076', '9876356416V', 'dr.ishani', 'psychologist'),
(15, 'D021', '786773728v', 'dr.oshini malsha', 'psychologist');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `doctors`
--
ALTER TABLE `doctors`
  ADD PRIMARY KEY (`doctorID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `doctors`
--
ALTER TABLE `doctors`
  MODIFY `doctorID` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
