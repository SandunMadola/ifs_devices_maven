-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 15, 2015 at 08:16 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ifs_devices`
--

-- --------------------------------------------------------

--
-- Table structure for table `add_request`
--

CREATE TABLE IF NOT EXISTS `add_request` (
  `request_ID` int(10) NOT NULL AUTO_INCREMENT,
  `device_Name` varchar(30) NOT NULL,
  `type` varchar(20) NOT NULL,
  `platform` varchar(20) NOT NULL,
  `OS` varchar(15) NOT NULL,
  `size` varchar(15) NOT NULL,
  `resolution` varchar(15) NOT NULL,
  `username` varchar(10) NOT NULL,
  `sub_Product_Area` varchar(15) NOT NULL,
  `request_Status` varchar(20) NOT NULL,
  `priority` varchar(5) NOT NULL,
  `location` varchar(20) NOT NULL,
  `comments` text NOT NULL,
  `url` text NOT NULL,
  `project` varchar(40) NOT NULL,
  PRIMARY KEY (`request_ID`),
  UNIQUE KEY `request_ID` (`request_ID`),
  KEY `Emp_id` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `add_request`
--

INSERT INTO `add_request` (`request_ID`, `device_Name`, `type`, `platform`, `OS`, `size`, `resolution`, `username`, `sub_Product_Area`, `request_Status`, `priority`, `location`, `comments`, `url`, `project`) VALUES
(1, 'LG V10', 'Phone', 'Android', 'Android 5.1.1 L', '159.6 x 79.3 x ', '--', 'sanmlk', 'Trainee', 'new', '3', 'CMB', 'Rear camera: 16MP with F1.8 Aperture/OIS 2.0', 'www.androidcentral.com/lg-v10', 'Trainee-Andro'),
(2, 'The Samsung Gear 2', 'wearables ', 'Android', 'lolipop', '1.6-inch', '320x320 pixel', 'sanmlk', 'Mass', 'In progress', '2', 'CMB', 'Latest', 'http://www.androidcentral.com/samsung-gear-2-gear-2-neo-and-gear-fit-review', 'DFD'),
(3, 'D360', 'Phone', 'IOS', 'Kitkat', '1.8', '320x320', 'nedilk', 'Client', 'In progress', '1', 'LKP', 'Upcoming', 'http://www.androidcentral.com/samsung-gear-2-gear-2-neo-and-gear-fit-review', 'Drac'),
(4, 'Lenova bird', 'Laptop', 'Windows', 'Windows 8.1', '32', '640x640', 'sunflk', 'Mass', 'In progress', '1', 'LKP', 'Bird for Chum', 'http://www.androidcentral.com/samsung-gear-2-gear-2-neo-and-gear-fit-review', 'Chum'),
(5, 'Dell Bigbang', 'Laptop', 'Windows', 'Windows 10', '32', '640x640', 'kashlk', 'Mass', 'new', '1', 'LKP', 'Solar enabled', 'http://www.androidcentral.com/samsung-gear-2-gear-2-neo-and-gear-fit-review', 'Sola project'),
(6, 'HP 210 Workstaion', 'Workstation', 'Linux', 'Linux', '32', '640x640', 'kashlk', 'Mass', 'new', '1', 'LKP', 'Linux for begin', 'http://www.androidcentral.com/samsung-gear-2-gear-2-neo-and-gear-fit-review', 'Linux project');

-- --------------------------------------------------------

--
-- Table structure for table `borrow_device`
--

CREATE TABLE IF NOT EXISTS `borrow_device` (
  `transaction_ID` int(20) NOT NULL AUTO_INCREMENT,
  `transaction_Mode` varchar(20) NOT NULL,
  `transaction_Type` varchar(20) NOT NULL,
  `username` varchar(10) NOT NULL,
  `device_ID` varchar(20) NOT NULL,
  `from_Date` date NOT NULL,
  `to_Date` date NOT NULL,
  PRIMARY KEY (`transaction_ID`),
  KEY `username` (`username`),
  KEY `device_ID` (`device_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `borrow_device`
--

INSERT INTO `borrow_device` (`transaction_ID`, `transaction_Mode`, `transaction_Type`, `username`, `device_ID`, `from_Date`, `to_Date`) VALUES
(1, 'green', 'later', 'nedilk', 'D003', '2015-10-07', '2015-10-12'),
(2, 'red', 'return', 'sanmlk', 'D001', '2015-10-19', '2015-10-23'),
(3, 'orange', 'later', 'sufelk', 'D001', '2015-11-23', '2015-11-26'),
(4, 'green', 'now', 'sufelk', 'D002', '2015-11-09', '2015-11-11'),
(5, 'green', 'now', 'chwilk', 'D004', '2015-12-09', '0000-00-00'),
(6, 'red', 'later', 'damalk', 'D005', '2015-12-08', '2015-12-15'),
(7, 'orange', 'cancel booking', 'pudhilk', 'D006', '2015-12-22', '2015-12-24'),
(8, 'green', 'now', 'kadelk', 'D007', '2015-12-10', '0000-00-00'),
(9, 'green', 'later', 'cheplk', 'D008', '2015-12-28', '2015-12-31'),
(10, 'red', 'return', 'ismalk', 'D009', '2015-12-15', '2015-12-16');

-- --------------------------------------------------------

--
-- Table structure for table `device`
--

CREATE TABLE IF NOT EXISTS `device` (
  `device_ID` varchar(20) NOT NULL,
  `model_ID` varchar(20) NOT NULL,
  `sub_Product_Area_ID` varchar(10) NOT NULL,
  `product_Area_ID` varchar(10) NOT NULL,
  `location` varchar(20) NOT NULL,
  `comments` text NOT NULL,
  PRIMARY KEY (`device_ID`),
  KEY `fk_devices_1` (`product_Area_ID`),
  KEY `Team_id` (`sub_Product_Area_ID`),
  KEY `Test` (`model_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `device`
--

INSERT INTO `device` (`device_ID`, `model_ID`, `sub_Product_Area_ID`, `product_Area_ID`, `location`, `comments`) VALUES
('D001', 'iPh4', 'TEC', 'TE', 'CMB', ''),
('D002', 'SamGal2', 'TEM', 'TE', 'CMB', ''),
('D003', 'MacMini', 'TET', 'TE', 'CMB', ''),
('D004', 'Nk920', 'TES', 'TE', 'CMB', ''),
('D005', 'MacbkPro', 'TET', 'TE', 'CMB', ''),
('D006', 'HTCDes', 'TEM', 'TE', 'CMB', ''),
('D007', 'iPh6', 'TEC', 'TE', 'CMB', ''),
('D008', 'MsSurfRT', 'TEM', 'TE', 'CMB', ''),
('D009', 'Nex7', 'TEM', 'TE', 'CMB', '');

-- --------------------------------------------------------

--
-- Table structure for table `device_model`
--

CREATE TABLE IF NOT EXISTS `device_model` (
  `model_ID` varchar(20) NOT NULL,
  `name` varchar(40) NOT NULL,
  `image_no` int(5) NOT NULL,
  `type` varchar(20) NOT NULL,
  `platform` varchar(20) NOT NULL,
  `OS` varchar(20) NOT NULL,
  `size` varchar(10) NOT NULL,
  `resolution` varchar(20) NOT NULL,
  `count` int(11) NOT NULL,
  `URL` varchar(100) NOT NULL,
  PRIMARY KEY (`model_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `device_model`
--

INSERT INTO `device_model` (`model_ID`, `name`, `image_no`, `type`, `platform`, `OS`, `size`, `resolution`, `count`, `URL`) VALUES
('HTCDes', 'HTC Desire', 15, 'Phone', 'Android', 'Android 2.3.3', '3.7"', '480x800', 1, ''),
('iPh4', 'Apple iPhone 4s', 18, 'Phone', 'iOS', 'iOS 8.3', '3.5"', '640x960', 2, ''),
('iPh6', 'iPhone 6', 16, 'Phone', 'iOS', 'iOS 8.3', '4.7"', '1334x750', 2, ''),
('MacbkPro', 'Macbook Pro Laptop (with Retina)', 7, 'Laptop', 'Mac', 'OS X 10.10.1 Yosemit', '13.3"', '2560x1600', 1, ''),
('MacMini', 'Mac Mini (2010)', 12, 'Desktop Computer', 'Mac', 'OS X 10.10 Yosemite', 'N/A', 'N/A', 1, ''),
('MsSurfRT', 'Microsoft Surface RT', 19, 'Tablet', 'Windows', 'Windows RT 8.1', '10.6"', '1366x768', 1, ''),
('Nex7', 'Nexus 7', 4, 'Tablet', 'Android', 'Android 5.0.2', '7.0"', '1280x800', 1, ''),
('Nk920', 'Nokia 920', 14, 'Phone', 'Windows Phone', 'Windows Phone', '4.5"', '768x1280', 1, ''),
('SamGal2', 'Samsung Galaxy S II', 2, 'Phone', 'Android', 'Android 4.0.3', '4.3"', '480x800', 4, '');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `username` varchar(10) NOT NULL,
  `product_Area_ID` varchar(10) NOT NULL,
  `sub_Product_Area_ID` varchar(10) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`username`, `product_Area_ID`, `sub_Product_Area_ID`) VALUES
('nedilk', 'TR', 'TR'),
('sanmlk', 'TR', 'TR'),
('sufelk', 'RD', 'RDSA');

-- --------------------------------------------------------

--
-- Table structure for table `product_area`
--

CREATE TABLE IF NOT EXISTS `product_area` (
  `product_Area_ID` varchar(5) NOT NULL,
  `product_Area_Name` varchar(20) NOT NULL,
  PRIMARY KEY (`product_Area_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product_area`
--

INSERT INTO `product_area` (`product_Area_ID`, `product_Area_Name`) VALUES
('FI', 'Finance'),
('HR', 'HR'),
('RD', 'R&D'),
('TE', 'Technology'),
('TR', 'Training');

-- --------------------------------------------------------

--
-- Table structure for table `sub_product_area`
--

CREATE TABLE IF NOT EXISTS `sub_product_area` (
  `sub_Product_Area_ID` varchar(5) NOT NULL,
  `sub_Product_Area_name` varchar(20) NOT NULL,
  `product_Area_ID` varchar(5) NOT NULL,
  PRIMARY KEY (`sub_Product_Area_ID`),
  KEY `product_Area_ID` (`product_Area_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sub_product_area`
--

INSERT INTO `sub_product_area` (`sub_Product_Area_ID`, `sub_Product_Area_name`, `product_Area_ID`) VALUES
('RDPR', 'Projects', 'RD'),
('RDSA', 'Service & Assets', 'RD'),
('TEC', 'Client', 'TE'),
('TEM', 'MaSS', 'TE'),
('TES', 'Server', 'TE'),
('TET', 'Tools', 'TE'),
('TR', 'Training', 'TR');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
