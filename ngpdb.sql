-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 30, 2024 at 11:35 AM
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
-- Database: `ngpdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin_details`
--

CREATE TABLE `admin_details` (
  `name` varchar(1000) NOT NULL,
  `password` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin_details`
--

INSERT INTO `admin_details` (`name`, `password`) VALUES
('Vishnu', 'vk'),
('Vinith', 'vk');

-- --------------------------------------------------------

--
-- Table structure for table `bookreq`
--

CREATE TABLE `bookreq` (
  `Book Name` varchar(1000) NOT NULL,
  `Author Name` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `bookreq`
--

INSERT INTO `bookreq` (`Book Name`, `Author Name`) VALUES
('Forrest Gump', 'NA'),
('vtv', 'gvm');

-- --------------------------------------------------------

--
-- Table structure for table `library`
--

CREATE TABLE `library` (
  `Book Name` varchar(1000) NOT NULL,
  `Author Name` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `library`
--

INSERT INTO `library` (`Book Name`, `Author Name`) VALUES
('War and Peace', 'Leo Tolstoy'),
('The Three Musketeers', 'Alexandre Dumas'),
('The White Company', 'Arthur Conan Doyle'),
('Forrest Gump', 'NA'),
('Forrest Gump', 'NA'),
('Forrest Gump', 'NA'),
('Forrest Gump', 'NA'),
('Forrest Gump', 'NA'),
('Forrest Gump', 'NA'),
('Forrest Gump', 'NA'),
('Forrest Gump', 'NA'),
('Forrest Gump', 'NA'),
('Forrest Gump', 'NA'),
('rtgrtrg', 'trgrg');

-- --------------------------------------------------------

--
-- Table structure for table `user_details`
--

CREATE TABLE `user_details` (
  `Name` varchar(1000) NOT NULL,
  `Password` varchar(1000) NOT NULL,
  `Email` varchar(1000) NOT NULL,
  `Phone_no` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_details`
--

INSERT INTO `user_details` (`Name`, `Password`, `Email`, `Phone_no`) VALUES
('Vishnu K', 'hello', 'vishnuvirat.201@gmail.com', '+918778925410'),
('Swathika M', 'swa', 'swa@gmail.com', '9080617685'),
('Anu', 'aaa', 'anu@gmail.com', '9894562024'),
('Abi', 'aaa', 'anu@gmail.com', '9894562024'),
('subramani', 'sss', 's@gmail.com', '8994583893'),
('vijay', 'vijay123', 'vijay@gmai.com', '9508787687'),
('Vishnu K', 'hello', 'vishnuvirat.201@gmail.com', '8778925410'),
('SRK', 'SRK', 'SRK@GMAIL.COM', '1234567890');

-- --------------------------------------------------------

--
-- Table structure for table `user_reviews`
--

CREATE TABLE `user_reviews` (
  `username` varchar(1000) NOT NULL,
  `rating` varchar(1000) NOT NULL,
  `review` varchar(10000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_reviews`
--

INSERT INTO `user_reviews` (`username`, `rating`, `review`) VALUES
('Arav', '2', 'Good\r\n'),
('Arav', '1', 'Good\r\n'),
('Arav', '1', 'Good\r\n'),
('vishnukumak__56', '1', 'ok'),
('vishnukumak__56', '1', 'ok'),
('710721243058@ngp', '2', 'ho\r\n'),
('ikrishnan1960', '1', 'bad'),
('vinith', '4', 'could have been better'),
('SRK', '1', 'GOOD');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
