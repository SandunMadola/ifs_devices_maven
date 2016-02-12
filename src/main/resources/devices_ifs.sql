-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 12, 2016 at 12:33 PM
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=178 ;

--
-- Dumping data for table `borrow_device`
--

INSERT INTO `borrow_device` (`transaction_ID`, `transaction_Mode`, `color`, `transaction_Type`, `username`, `device_ID`, `from_Date`, `to_Date`) VALUES
(7, 'booked', 'orange', 'cancel', 'pudhilk', 'D006', '2016-02-18', '2016-05-25'),
(77, 'unavailable', 'red', 'return', 'samalk', 'D010', '2016-01-04', '2016-02-29'),
(87, 'booked', 'orange', 'cancel', 'sanmlk', 'D002', '2016-02-08', '2016-02-15'),
(131, 'booked', 'orange', 'cancel', 'rugulk', 'D002', '2016-02-16', '2016-02-23'),
(136, 'booked', 'orange', 'cancel', 'sufelk', 'D003', '2016-02-22', '2016-02-25'),
(137, 'booked', 'orange', 'cancel', 'nedilk', 'D001', '2016-02-22', '2016-02-29'),
(139, 'booked', 'orange', 'cancel', 'chhelk', 'D005', '2016-02-22', '2016-02-24'),
(146, 'booked', 'orange', 'cancel', 'prpelk', 'D005', '2016-01-28', '2016-02-18'),
(151, 'booked', 'orange', 'cancel', 'kamulk', 'D004', '2016-02-08', '2016-02-13'),
(157, 'booked', 'orange', 'cancel', 'dimilk', 'D001', '2016-02-03', '2016-02-17'),
(159, 'unavailable', 'red', 'return', 'padelk', 'D009', '2016-02-04', '2016-02-11'),
(160, 'unavailable', 'red', 'return', 'nedilk', 'D011', '2016-02-01', '2016-02-15'),
(165, 'booked', 'orange', 'cancel', 'namalk', 'D002', '2016-02-03', '2016-02-07'),
(170, 'booked', 'orange', 'cancel', 'nedilk', 'D_Test21', '2016-03-01', '2016-03-02'),
(173, 'booked', 'orange', 'cancel', 'nedilk', 'D_Test21', '2016-02-15', '2016-02-16'),
(174, 'booked', 'orange', 'cancel', 'nedilk', 'D_Test21', '2016-02-16', '2016-02-17'),
(175, 'booked', 'orange', 'cancel', 'nedilk', 'D_Test21', '2016-02-18', '2016-02-24'),
(177, 'booked', 'orange', 'cancel', 'nedilk', 'D_Test21', '2016-02-25', '2016-03-26');

-- --------------------------------------------------------

--
-- Table structure for table `device`
--

CREATE TABLE IF NOT EXISTS `device` (
  `device_ID` varchar(20) DEFAULT NULL,
  `sub_Product_Area` varchar(20) NOT NULL,
  `product_Area` varchar(20) NOT NULL,
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=43 ;

--
-- Dumping data for table `device`
--

INSERT INTO `device` (`device_ID`, `sub_Product_Area`, `product_Area`, `location`, `comments`, `device_Name`, `image_no`, `type`, `platform`, `os`, `size`, `resolution`, `url`, `username`, `priority`, `project`, `requested_Date`, `reject_comment`, `request_Status`, `request_ID`) VALUES
('D001', 'Client', 'Technology', 'CMB', '', 'Apple iPhone 4s', 18, 'Phone', 'IOS', 'IOS 8.3', '22"', '240x230', '', '', '', '', '0000-00-00', '', 'Available', 1),
('D002', 'Mass', 'Technology', 'CMB', '', 'Samsung Galaxy S II', 2, 'Phone', 'Android', 'Kitkat', '13"', '140x86', '', '', '', '', '0000-00-00', '', 'Available', 2),
('D003', 'Mass', 'Technology', 'CMB', '', 'Mac Mini (2010)', 12, 'Desktop', 'MAC', 'S X 10.10 Yosemite', '15"', '120x45', '', '', '', '', '0000-00-00', '', 'Available', 3),
('D004', 'Server', 'Technology', 'CMB', '', 'Nokia 920', 14, 'Phone', 'Windows', 'Windows 8', '14"', '15x36', '', '', '', '', '0000-00-00', '', 'Available', 4),
('D005', 'Mass', 'Technology', 'CMB', '', 'Macbook Pro Laptop (with Retina)', 7, 'Laptop', 'MAC', 'OS X 10.10 Yosemite', '', '', '', '', '', '', '0000-00-00', '', 'Available', 5),
('D006', 'Mass', 'Technology', 'CMB', '', 'HTC Desire', 15, 'Phone', 'Android', 'Android 2.3.3', '3.7"\n', '480x800', '', '', '', '', '0000-00-00', '', 'Available', 6),
('D007', 'Client', 'Technology', 'CMB', '', 'iPhone 6', 16, 'Phone', 'IOS', 'IOS 8', '2.3"', '500x502', '', '', '', '', '0000-00-00', '', 'Available', 7),
('D008', 'Mass', 'Technology', 'CMB', '', 'Microsoft Surface RT', 19, 'Tablet', 'Windows', 'Windows 7', '21"', '240x36', '', '', '', '', '0000-00-00', '', 'Available', 8),
('D009', 'Mass', 'Technology', 'CMB', '', 'Nexus 7', 4, 'Tablet', 'Android', 'Kitkat', '21"', '210x369', '', '', '', '', '0000-00-00', '', 'Available', 9),
('D010', 'Mass', 'Technology', 'CMB', 'testing', 'Apple iPhone 4s', 18, 'Phone', 'IOS', 'IOS 8', '22"', '240x230', '', '', '', '', '0000-00-00', '', 'Available', 10),
('D011', 'Mass', 'Technology', 'LKP', 'TEST', 'iPhone 6', 16, 'Phone', 'IOS', 'IOS 2.3', '23"', '256x456', '', '', '', '', '0000-00-00', '', 'Available', 11),
('D_Test', 'Room1', 'Training', 'LKP', 'Test', 'NOKIA 210', 0, 'Phone', 'Windows Phone', 'win 8', '21', '65*65', 'text.xom', 'kselkd', '3', 'test', '2016-01-27', '', 'Available', 12),
(NULL, 'Server', 'Technology', 'CMB', 'Test', 'Samsung S56', 0, 'Phone', 'Android', 'Gingerbread', '23', '12', 'Test.lk', 'q', '2', 'SLASCOMM', '2016-01-27', 'Rejected Since :', 'Requested', 14),
(NULL, 'Client', 'Technology', 'CMB', 'Test', 'Samsung chump', 0, 'Wearables', 'Android', 'Windows 10', '23"', '34x45', 'http://www.sanduntech.bolgspot.com', 'sanmlk', '4', 'IFS_DEVICES', '2016-01-27', 'null', 'In Progress', 15),
(NULL, 'Tools', 'Technology', 'CMB', 'Test', 'Samsung duos 2', 0, 'Laptop', 'Android', 'Windows 10', '23"', '34x45', 'http://www.sanduntech.bolgspot.com', 'sanmlk', '2', 'IFS_DEVICES', '2016-01-27', 'Data inconsistance. Please fill them again.', 'Rejected', 16),
('D_Test21', 'Client', 'Technology', 'LKP', 'Test', 'Iphone plus', 0, 'Phone', 'Windows', 'Windows 10', '23"', '34x45', 'http://www.sanduntech.bolgspot.com', 'sanmlk', '4', 'IFS_DEVICES', '2016-01-27', 'Rejected Since :', 'Available', 17),
('TECM0023', 'Mass', 'Technology', 'LKP', 'Test', 'Dell 3125', 0, 'Laptop', 'Windows', 'Windows 10', '23"', '34x45', 'http://www.sanduntech.bolgspot.com', 'sanmlk', '1', 'IFS_DEVICES', '2016-01-27', 'null', 'Available', 18),
(NULL, 'Mass', 'Technology', 'CMB', 'Test', 'HP 210', 0, 'Laptop', 'Windows', 'Windows 10', '23"', '34x45', 'http://www.sanduntech.bolgspot.com', 'sanmlk', '3', 'IFS_DEVICES', '2016-01-27', 'null', 'In Progress', 19),
(NULL, 'Client', 'Technology', 'CMB', 'Test', 'ASUS s3', 0, 'Laptop', 'Windows', 'Windows 10', '23"', '34x45', 'http://www.sanduntech.bolgspot.com', 'sanmlk', '2', 'IFS_DEVICES', '2016-01-27', 'Not needed.', 'Rejected', 20),
('null', 'Tools', 'Technology', 'CMB', 'Tested', 'Acer s1', 0, 'Laptop', 'Windows', 'Windows 10', '23"', '34x45', 'http://www.sanduntech.bolgspot.com', 'sanmlk', '2', 'IFS_DEVICES', '2016-01-27', 'Rejected Since :', 'Confirmed', 21),
(NULL, 'Client', 'Technology', 'CMB', 'Test', 'Lenova SG', 0, 'Laptop', 'Windows', 'Windows 10', '23"', '34x45', 'http://www.sanduntech.bolgspot.com', 'sanmlk', '2', 'IFS_DEVICES', '2016-01-27', 'null', 'Requested', 22),
(NULL, 'Mass', 'Technology', 'CMB', 'Test', 'Samsung s2', 0, 'Laptop', 'Windows', 'Windows 10', '23"', '34x45', 'http://www.sanduntech.bolgspot.com', 'sanmlk', '1', 'IFS_DEVICES', '2016-01-27', 'Rejected Since :', 'Requested', 23),
(NULL, 'Support', 'Technology', 'CMB', 'Test', 'Lenova SG', 0, 'Laptop', 'Windows', 'Windows 10', '23"', '34x45', 'http://www.sanduntech.bolgspot.com', 'sanmlk', '2', 'IFS_DEVICES', '2016-01-27', 'Rejected Since :', 'Confirmed', 24),
('D055', 'Client', 'Technology', 'CMB', 'Tested', 'Megabox s12', 0, 'Laptop', 'Linux', 'Ubuntu', '23"', '34x45', 'http://www.sanduntech.bolgspot.com', 'sanmlk', '2', 'IFS_DEVICES', '2016-01-27', 'Rejected Since :', 'Confirmed', 25),
(NULL, 'Server', 'Technology', 'CMB', 'Test', 'Lenova SG', 0, 'Laptop', 'Windows', 'Windows 10', '23"', '34x45', 'http://www.sanduntech.bolgspot.com', 'sanmlk', '2', 'IFS_DEVICES', '2016-01-27', 'Rejected Since :', 'Requested', 26),
(NULL, 'Trainee', 'Trainee', 'CMB', 'Test', 'Samsung Galaxy', 0, 'Laptop', 'IOS', 'Mac 3.3', '45"', '12x56', 'Sandun.lk', 'nedilk', '1', 'Sample', '2016-01-27', 'null', 'Requested', 27),
(NULL, 'Services', 'R&D', 'CMB', 'Test', 'Robot 123', 0, 'Wearables', 'Android', 'Lolipop', '12"', '12x34', 'madola.lk', 'sunflk', '2', 'Training', '2016-01-27', 'null', 'Requested', 28),
('TecM0021', 'Mass', 'Technology', 'CMB', 'null', 'Lenovo A32', 0, 'null', 'null', 'null', 'null', 'null', 'null', 'sandlk', 'null', 'Test', '2016-02-11', 'null', 'Available', 30),
('null', 'Server', 'Technology', 'CMB', 'For test', 'HP 3521', 0, 'Desktop', 'Windows', 'Windows 10', '23"', '55 x 23', 'https://www.google.lk/', 'nekilk', '2', 'Test', '2016-02-11', 'null', 'In Progress', 31),
('null', 'Tools', 'Technology', 'CMB', 'For test', 'Acer 3521', 0, 'Desktop', 'Windows', 'Windows 10', '23"', '55 x 23', 'https://www.google.lk/', 'nekilk', '4', 'Test', '2016-02-11', 'Rejected Since :', 'Requested', 32),
('null', 'Tools', 'Technology', 'CMB', 'For test', 'Samsung A5', 0, 'Desktop', 'Windows', 'Windows 10', '23"', '55 x 23', 'https://www.google.lk/', 'nekilk', '3', 'Test', '2016-02-11', 'null', 'Confirmed', 33),
(NULL, 'Mass', 'Technology', 'CMB', 'For test', 'Dell 3521', 0, 'Desktop', 'Windows', 'Windows 10', '23"', '55 x 23', 'https://www.google.lk/', 'nekilk', '2', 'Test', '2016-02-11', 'null', 'Requested', 34),
('null', 'Sever', 'Technology', 'CMB', 'For test', 'Megabox 3521', 0, 'Desktop', 'Windows', 'Windows 10', '23"', '55 x 23', 'https://www.google.lk/', 'nekilk', '4', 'Test', '2016-02-11', 'Rejected Since :', 'Requested', 35),
(NULL, 'Mass', 'Technology', 'CMB', 'For test', 'Dell 3521', 0, 'Desktop', 'Windows', 'Windows 10', '23"', '55 x 23', 'https://www.google.lk/', 'nekilk', '2', 'Test', '2016-02-11', 'null', 'Requested', 36),
('null', 'Tools', 'Technology', 'CMB', 'For test', 'HTC c23', 0, 'Desktop', 'Windows', 'Windows 10', '23"', '55 x 23', 'https://www.google.lk/', 'nekilk', '3', 'Test', '2016-02-11', 'Rejected Since :', 'Requested', 37),
(NULL, 'Mass', 'Technology', 'CMB', 'For test', 'Dell 3521', 0, 'Desktop', 'Windows', 'Windows 10', '23"', '55 x 23', 'https://www.google.lk/', 'nekilk', '2', 'Test', '2016-02-11', 'null', 'Requested', 38),
('null', 'Tools', 'Technology', 'CMB', 'For test', 'Nexus 5', 0, 'Desktop', 'Windows', 'Windows 10', '23"', '55 x 23', 'https://www.google.lk/', 'nekilk', '2', 'Test', '2016-02-11', 'null', 'In Progress', 39),
('null', 'Mass', 'Technology', 'CMB', 'For test', 'Asus 3521', 0, 'Desktop', 'Windows', 'Windows 10', '23"', '55 x 23', 'https://www.google.lk/', 'nekilk', '2', 'Client', '2016-02-11', 'null', 'Confirmed', 40),
('null', 'Server', 'Technology', 'CMB', 'For test', 'Dell 3521', 0, 'Desktop', 'Windows', 'Windows 10', '23"', '55 x 23', 'https://www.google.lk/', 'nekilk', '2', 'Test', '2016-02-11', 'Available', 'Rejected', 41),
('null', 'Mass', 'Technology', 'CMB', 'null', 'Samsung A5', 0, 'null', 'null', 'Windows 8', 'null', 'null', 'null', 'sanmlk', 'null', 'Test', '2016-02-11', 'null', 'In Progress', 42);

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
(134, 'unavailable', 'red', 'return', 'sanmlk', 'D001', '2016-01-07', '2016-01-08', '2016-01-08'),
(149, 'unavailable', 'red', 'return', 'sufelk', 'D003', '2016-01-25', '2016-01-29', '2016-01-29'),
(176, 'unavailable', 'red', 'return', 'nedilk', 'D_Test21', '2016-02-11', '2016-02-15', '2016-02-11'),
(178, 'unavailable', 'red', 'return', 'nedilk', 'D003', '2016-02-11', '2016-02-12', '2016-02-11'),
(179, 'unavailable', 'red', 'return', 'nedilk', 'D008', '2016-02-11', '2016-02-12', '2016-02-11');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
