-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 27, 2016 at 09:51 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `devices_ifs`
--

-- --------------------------------------------------------

--
-- Table structure for table `add_request`
--

CREATE TABLE IF NOT EXISTS `add_request` (
  `request_ID` int(10) NOT NULL AUTO_INCREMENT,
  `device_Name` text NOT NULL,
  `type` varchar(50) NOT NULL,
  `platform` varchar(50) NOT NULL,
  `OS` varchar(50) NOT NULL,
  `size` varchar(50) NOT NULL,
  `resolution` varchar(50) NOT NULL,
  `username` varchar(10) NOT NULL,
  `sub_Product_Area` varchar(50) NOT NULL,
  `request_Status` varchar(50) NOT NULL,
  `priority` varchar(5) NOT NULL,
  `location` varchar(50) NOT NULL,
  `comments` text NOT NULL,
  `url` text NOT NULL,
  `project` varchar(40) NOT NULL,
  `date` date NOT NULL,
  `reject_comment` varchar(100) NOT NULL,
  PRIMARY KEY (`request_ID`),
  UNIQUE KEY `request_ID` (`request_ID`),
  KEY `Emp_id` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=61 ;

--
-- Dumping data for table `add_request`
--

INSERT INTO `add_request` (`request_ID`, `device_Name`, `type`, `platform`, `OS`, `size`, `resolution`, `username`, `sub_Product_Area`, `request_Status`, `priority`, `location`, `comments`, `url`, `project`, `date`, `reject_comment`) VALUES
(1, 'Samsung Samsung', 'Phone', 'Android', 'Android 5.1.1 LLBB', '', '25', 'sanmlk', 'Trainee', 'Rejected', '3', 'CMB', 'Rear camera: 16MP with F1.8 Aperture/OIS 2.0', 'www.androidcentral.com/lg-v1055', 'Trainee-Andro', '2015-12-01', ''),
(2, 'The Samsung Gear 3', 'Wearables', 'MAC', 'lolipop', '1.6-inche', '320x320 pixellllsss', 'sanmlk', 'Mass', 'In Progress', '1', 'CMB', 'Latest', 'http://www.androidcentral.com/samsung-gear-2-gear-2-neo-and-gear-fit-review', 'Test', '2015-12-10', ''),
(3, 'D450', 'Tablet', 'Windows Phone', 'Kitkat', '1.8', '320x320', 'nedilk', 'Client', 'In Progress', '1', 'LKP', 'Upcoming', 'http://www.androidcentral.com/samsung-gear-2-gear-2-neo-and-gear-fit-review', 'Drac', '2015-12-15', ''),
(4, 'Lenova bird', 'Laptop', 'Windows', 'Windows 8.1', '32', '640x640', 'sunflk', 'Mass', 'In Progress', '1', 'LKP', 'Bird for Chum', 'http://www.androidcentral.com/samsung-gear-2-gear-2-neo-and-gear-fit-review', 'Chum', '2015-12-16', ''),
(5, 'Dell Bigbang', 'Laptop', 'Windows', 'Windows 10', '32', '640x640', 'kashlk', 'Mass', 'Completed', '1', 'LKP', 'Solar enabled', 'http://www.androidcentral.com/samsung-gear-2-gear-2-neo-and-gear-fit-review', 'Sola project', '2015-12-17', ''),
(6, 'HP 210 Workstaion', 'Workstation', 'Linux', 'Linux', '32', '640x640', 'kashlk', 'Mass', 'Complete', '1', 'LKP', 'Linux for begin', 'http://www.androidcentral.com/samsung-gear-2-gear-2-neo-and-gear-fit-review', 'Linux project', '2015-12-18', ''),
(52, 'Samsung GT-100', 'phone', 'android', 'Gingerbread', '32 x 32', '16', 'yoyolk', 'Trainee', 'In Progress', '4', 'cmb', 'Testing purposes', 'www.google.lk', 'IFS_DEVICES', '2015-12-28', ''),
(53, 'Apple SS', 'phone', 'mac', 'IOS', '25', '69', 'kkkklk', 'Mass', 'New', '2', 'lkp', 'Test', 'test.lk', 'Test', '2015-12-29', ''),
(54, 'Toshiba', 'laptop', 'windows', 'win 10', '35', '38', 'ssmmlk', 'Mass', 'New', '4', 'lkp', 'test', 'www.test.com', 'Test', '2015-12-29', ''),
(55, 'Oska', 'laptop', 'mac', 'OSS', '11', '12', 'kkkklk', 'Mass', 'New', '3', 'cmb', 'test', 'test.lk', 'Test', '2015-12-29', ''),
(60, 'MegaBox1', 'Laptop', 'Android', 'Gingerbread', '34', '34', 'sanmlk', 'Trainee', 'Rejected', '1', 'LKP', 'Test', 'San.lk', 'Devices', '2015-12-30', 'Details Less');

-- --------------------------------------------------------

--
-- Table structure for table `borrow_device`
--

CREATE TABLE IF NOT EXISTS `borrow_device` (
  `transaction_ID` int(20) NOT NULL AUTO_INCREMENT,
  `transaction_Mode` varchar(20) NOT NULL DEFAULT 'green',
  `color` varchar(15) NOT NULL,
  `transaction_Type` varchar(20) NOT NULL,
  `username` varchar(10) NOT NULL,
  `device_ID` varchar(40) NOT NULL,
  `from_Date` date NOT NULL,
  `to_Date` date NOT NULL,
  PRIMARY KEY (`transaction_ID`),
  KEY `username` (`username`),
  KEY `device_ID` (`device_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=151 ;

--
-- Dumping data for table `borrow_device`
--

INSERT INTO `borrow_device` (`transaction_ID`, `transaction_Mode`, `color`, `transaction_Type`, `username`, `device_ID`, `from_Date`, `to_Date`) VALUES
(7, 'booked', 'orange', 'cancel', 'pudhilk', 'D006', '2016-01-18', '2016-01-25'),
(77, 'unavailable', 'red', 'return', 'samalk', 'D010', '2016-01-04', '2016-02-29'),
(87, 'booked', 'orange', 'cancel', 'sanmlk', 'D002', '2016-01-18', '2016-01-24'),
(131, 'booked', 'orange', 'cancel', 'rugulk', 'D002', '2016-01-28', '2016-01-29'),
(136, 'booked', 'orange', 'cancel', 'sufelk', 'D003', '2016-01-21', '2016-01-25'),
(137, 'booked', 'orange', 'cancel', 'nedilk', 'D001', '2016-01-26', '2016-01-29'),
(139, 'booked', 'orange', 'cancel', 'chhelk', 'D005', '2016-01-21', '2016-01-22'),
(140, 'booked', 'orange', 'cancel', 'chhelk', 'D005', '2016-01-29', '2016-02-05'),
(146, 'booked', 'orange', 'cancel', 'prpelk', 'D005', '2016-01-28', '2016-02-18'),
(147, 'booked', 'orange', 'cancel', 'nedilk', 'D002', '2016-01-25', '2016-01-26'),
(149, 'unavailable', 'red', 'return', 'sufelk', 'D003', '2016-01-25', '2016-01-29'),
(150, 'booked', 'orange', 'cancel', 'rufelk', 'D002', '2016-01-20', '2016-01-22');

-- --------------------------------------------------------

--
-- Table structure for table `device`
--

CREATE TABLE IF NOT EXISTS `device` (
  `device_ID` varchar(20) DEFAULT NULL,
  `sub_Product_Area` varchar(10) NOT NULL,
  `product_Area` varchar(10) NOT NULL,
  `location` varchar(20) NOT NULL,
  `comments` text NOT NULL,
  `device_Name` text NOT NULL,
  `image_no` int(5) NOT NULL DEFAULT '0',
  `type` varchar(50) NOT NULL,
  `platform` varchar(50) NOT NULL,
  `os` varchar(50) NOT NULL,
  `size` varchar(20) NOT NULL,
  `resolution` varchar(20) NOT NULL,
  `url` text NOT NULL,
  `username` varchar(10) NOT NULL,
  `priority` varchar(6) NOT NULL,
  `project` varchar(40) NOT NULL,
  `requested_Date` date NOT NULL,
  `reject_comment` text NOT NULL,
  `request_Status` varchar(20) NOT NULL,
  `request_ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`request_ID`),
  UNIQUE KEY `request_ID` (`request_ID`),
  KEY `fk_devices_1` (`product_Area`),
  KEY `Team_id` (`sub_Product_Area`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Dumping data for table `device`
--

INSERT INTO `device` (`device_ID`, `sub_Product_Area`, `product_Area`, `location`, `comments`, `device_Name`, `image_no`, `type`, `platform`, `os`, `size`, `resolution`, `url`, `username`, `priority`, `project`, `requested_Date`, `reject_comment`, `request_Status`, `request_ID`) VALUES
('D001', 'TEC', 'TE', 'CMB', '', 'Apple iPhone 4s', 18, 'Phone', 'IOS', 'IOS 8.3', '22"', '240x230', '', '', '', '', '0000-00-00', '', 'Available', 1),
('D002', 'TEM', 'TE', 'CMB', '', 'Samsung Galaxy S II', 2, 'Phone', 'Android', 'Kitkat', '13"', '140x86', '', '', '', '', '0000-00-00', '', 'Available', 2),
('D003', 'TET', 'TE', 'CMB', '', 'Mac Mini (2010)', 12, 'Desktop', 'MAC', 'S X 10.10 Yosemite', '15"', '120x45', '', '', '', '', '0000-00-00', '', 'Available', 3),
('D004', 'TES', 'TE', 'CMB', '', 'Nokia 920', 14, 'Phone', 'Windows', 'Windows 8', '14"', '15x36', '', '', '', '', '0000-00-00', '', 'Available', 4),
('D005', 'TET', 'TE', 'CMB', '', 'Macbook Pro Laptop (with Retina)', 7, 'Laptop', 'MAC', 'OS X 10.10 Yosemite', '', '', '', '', '', '', '0000-00-00', '', 'Available', 5),
('D006', 'TEM', 'TE', 'CMB', '', 'HTC Desire', 15, 'Phone', 'Android', 'Android 2.3.3', '3.7"\n', '480x800', '', '', '', '', '0000-00-00', '', 'Available', 6),
('D007', 'TEC', 'TE', 'CMB', '', 'iPhone 6', 16, 'Phone', 'IOS', 'IOS 8', '2.3"', '500x502', '', '', '', '', '0000-00-00', '', 'Available', 7),
('D008', 'TEM', 'TE', 'CMB', '', 'Microsoft Surface RT', 19, 'Tablet', 'Windows', 'Windows 7', '21"', '240x36', '', '', '', '', '0000-00-00', '', 'Available', 8),
('D009', 'TEM', 'TE', 'CMB', '', 'Nexus 7', 4, 'Tablet', 'Android', 'Kitkat', '21"', '210x369', '', '', '', '', '0000-00-00', '', 'Available', 9),
('D010', 'TEM', 'TE', 'CMB', 'testing', 'Apple iPhone 4s', 18, 'Phone', 'IOS', 'IOS 8', '22"', '240x230', '', '', '', '', '0000-00-00', '', 'Available', 10),
('D011', 'TEM', 'TE', 'LKP', 'TEST', 'iPhone 6', 16, 'Phone', 'IOS', 'IOS 2.3', '23"', '256x456', '', '', '', '', '0000-00-00', '', 'Available', 11),
('', 'Tools', 'Technology', 'CMB', 'Test', 'NOKIA 210', 0, 'Phone', 'Windows', 'win 8', '21', '65*65', 'text.xom', 'kselkd', '3', 'test', '2016-01-27', '', 'Approved', 12),
('', 'Tools', 'Technology', 'CMB', 'Test', 'NOKIA 210', 0, 'Phone', 'Windows', 'win 8', '21', '65*65', 'text.xom', 'kselkd', '3', 'test', '2016-01-27', 'Test', 'Rejected', 13),
(NULL, 'HR', 'q', 'CMB', 'Test', 'Samsung S5', 0, 'Phone', 'Android', 'Gingerbread', '23', '12', 'Test.lk', 'q', '2', 'SLASCOMM', '2016-01-27', 'Rejected Since :', 'Requested', 14);

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
('SamGal2', 'Samsung Galaxy S II', 2, 'Phone', 'Android', 'Android 4.0.3', '4.3"', '480x800', 1, '');

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
-- Table structure for table `returned_devices`
--

CREATE TABLE IF NOT EXISTS `returned_devices` (
  `transaction_ID` int(20) NOT NULL,
  `transaction_Mode` varchar(20) NOT NULL,
  `color` varchar(15) NOT NULL,
  `transaction_Type` varchar(20) NOT NULL,
  `username` varchar(10) NOT NULL,
  `device_ID` varchar(40) NOT NULL,
  `from_Date` date NOT NULL,
  `to_Date` date NOT NULL,
  `returned_Date` date NOT NULL,
  PRIMARY KEY (`transaction_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `returned_devices`
--

INSERT INTO `returned_devices` (`transaction_ID`, `transaction_Mode`, `color`, `transaction_Type`, `username`, `device_ID`, `from_Date`, `to_Date`, `returned_Date`) VALUES
(75, 'unavailable', 'red', 'return', 'nedilk', 'D010', '2015-12-29', '2016-01-08', '2016-01-07'),
(78, 'unavailable', 'red', 'return', 'chwilk', 'D011', '2015-12-31', '2016-01-13', '2016-01-12'),
(129, 'unavailable', 'red', 'return', 'nedilk', 'D002', '2016-01-07', '2016-01-19', '2016-01-08'),
(134, 'unavailable', 'red', 'return', 'sanmlk', 'D001', '2016-01-07', '2016-01-08', '2016-01-08');

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
