-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 31, 2019 at 08:34 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `javasuperproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `a_id` int(50) NOT NULL,
  `a_password` varchar(50) NOT NULL,
  `a_name` varchar(50) NOT NULL,
  `a_address` varchar(62) NOT NULL,
  `a_phone` int(20) NOT NULL,
  `u_type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`a_id`, `a_password`, `a_name`, `a_address`, `a_phone`, `u_type`) VALUES
(15308973, '#include2', 'ovi', '103 canada', 1681730008, 'admin'),
(15308003, '#include2', 'Alavi', '101 Canada', 1715792838, 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `c_id` int(50) NOT NULL,
  `p_id` int(50) NOT NULL,
  `p_name` varchar(50) NOT NULL,
  `p_brand` varchar(50) NOT NULL,
  `p_price` int(50) NOT NULL,
  `p_qnty` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`c_id`, `p_id`, `p_name`, `p_brand`, `p_price`, `p_qnty`) VALUES
(1234568, 1, 'iphone7', 'Apple', 80000, 1),
(11246508, 308, 'samsung a1', 'samsung', 42000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `c_id` int(50) NOT NULL,
  `c_password` varchar(50) NOT NULL,
  `c_name` varchar(50) NOT NULL,
  `c_address` varchar(50) NOT NULL,
  `c_phone` int(50) NOT NULL,
  `c_cardNo` varchar(50) NOT NULL,
  `u_type` varchar(50) NOT NULL,
  `cash` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`c_id`, `c_password`, `c_name`, `c_address`, `c_phone`, `c_cardNo`, `u_type`, `cash`) VALUES
(11246484, '#include2', 'Ovi', '103 canada', 1681730008, '2147483647', 'customer', 40000),
(11246508, '#include2', 'Alavi', '102 canada', 1681730008, '2147483647', 'customer', 78000);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `m_name` varchar(50) NOT NULL,
  `m_id` int(50) NOT NULL,
  `display_size` int(50) NOT NULL,
  `ram` int(50) NOT NULL,
  `rear_camera_Resolution` int(50) NOT NULL,
  `selfie_camera_Resolution` int(50) NOT NULL,
  `os` varchar(50) NOT NULL,
  `brand` varchar(50) NOT NULL,
  `unitPrice` int(50) NOT NULL,
  `availablity` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`m_name`, `m_id`, `display_size`, `ram`, `rear_camera_Resolution`, `selfie_camera_Resolution`, `os`, `brand`, `unitPrice`, `availablity`) VALUES
('iphone7', 1, 6, 3, 12, 5, 'MacIos', 'Apple', 80000, 66),
('iphone6', 2, 6, 2, 10, 5, 'MacIos', 'Apple', 70000, 55),
('iphone7 plus', 3, 7, 3, 12, 5, 'MacIos', 'Apple', 81000, 478),
('samsung a1', 308, 6, 4, 13, 6, 'android', 'samsung', 42000, 124);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD UNIQUE KEY `c_id` (`c_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
