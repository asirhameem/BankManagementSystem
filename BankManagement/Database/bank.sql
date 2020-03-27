-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 19, 2018 at 03:27 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bank`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `Bank_id` varchar(20) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `DOB` varchar(20) NOT NULL,
  `Gender` varchar(20) NOT NULL,
  `Phone_no` varchar(20) NOT NULL,
  `Address` varchar(30) NOT NULL,
  `NID` int(30) NOT NULL,
  `Join_date` varchar(20) NOT NULL,
  `Salary` double(10,3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`Bank_id`, `Name`, `DOB`, `Gender`, `Phone_no`, `Address`, `NID`, `Join_date`, `Salary`) VALUES
('555555', 'Mr.Bean ', '15-02-1997', 'Male', '+8801862769843', 'Moghbazar', 123000123, '1-1-2017', 20000.000),
('666666', 'Rahi Adnan', '28-10-2008', 'Male', '+8801862769843', 'Moghbazar', 1230123, '1-1-2017', 20000.000),
('777777', 'Anika Tabassum Upoma', '15-02-1997', 'Female', '+8801521432687', 'Soidi Koloni', 1010101, '1-12-2015', 20000.000),
('888888', 'James', '19-12-2017', 'Male', '+8801862769843', 'Moghbazar', 223344, '1-1-2017', 20000.000),
('999999', 'Saif', '19-12-2017', 'Male', '+8801862769843', 'Moghbazar', 999999, '1-1-2017', 20000.000);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `Bank_id` varchar(20) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Father_name` varchar(30) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Date_of_birth` varchar(10) NOT NULL,
  `Phone_number` varchar(20) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `NID` int(20) NOT NULL,
  `Balance` double(10,3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Bank_id`, `Name`, `Father_name`, `Gender`, `Date_of_birth`, `Phone_number`, `Address`, `NID`, `Balance`) VALUES
('999990', 'Aminul islam', 'Abul Kalam', 'Male', '29-11-1989', '+8801765820568', 'Rokeya monjhil', 223344, 20000.000),
('888880', 'Clean Bandit', 'Abdul', 'Female', '5May1954', '+88015236594', 'Chaina', 5632589, 20000.000),
('555550', 'Jesmin', 'Josh', 'Female', '1-12-2013', '+8801523658', 'Rokeya Monjil', 123654789, 12.000),
('777770', 'Jhon cena', 'Jhon Abraham', 'Male', '3Jan2002', '+8801521432687', 'New York', 123456789, 20000.000),
('666660', 'Tariqul islam', 'Abul kalam', 'Male', '04-04-1997', '+8801521432687', 'Rokeya monjhil', 1122334455, 20000.000);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `Bank_id` varchar(10) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Date_of_birth` varchar(20) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Employee_type` varchar(20) NOT NULL,
  `Phone_no` varchar(20) NOT NULL,
  `Address` varchar(30) NOT NULL,
  `NID` int(20) NOT NULL,
  `Join_date` varchar(20) NOT NULL,
  `Salary` double(10,3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`Bank_id`, `Name`, `Date_of_birth`, `Gender`, `Employee_type`, `Phone_no`, `Address`, `NID`, `Join_date`, `Salary`) VALUES
('555551', 'Shirin Akhter', '16-12-1971', 'Female', 'Manager', '+8801911459951', 'Rokeya monjhil', 22334412, '1-1-2017', 20000.000),
('666661', 'Kerl', '29-11-1989', 'Male', 'General', '+8801862769843', 'Moghbazar', 5544000, '1-1-2017', 10000.000),
('777771', 'Ali', '04-04-1997', 'Male', 'General', '+8801862769843', 'Rokeya monjhil', 12012012, '1-1-2017', 20000.000),
('888881', 'Emon', '29-11-1989', 'Male', 'Manager', '+8801862769843', 'Moghbazar', 5544, '1-1-2017', 10000.000),
('999991', 'Rafi hu', '09-12-1997', 'Male', 'General', '+8801862769843', 'Moghbazar', 123456789, '1-1-2017', 10000.000);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `Bank_id` varchar(20) NOT NULL,
  `Password` varchar(10) NOT NULL,
  `Status` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`Bank_id`, `Password`, `Status`) VALUES
('555550', '555550', 0),
('555551', '555551', 1),
('555555', '555555', 2),
('666660', '666660', 0),
('666661', '666661', 1),
('666666', '666666', 2),
('777770', '777770', 0),
('777771', '777771', 1),
('777777', '777777', 2),
('888880', '888880', 0),
('888881', '888881', 1),
('888888', '888888', 2),
('999990', '999990', 0),
('999991', '999991', 1),
('999999', '999999', 2);

-- --------------------------------------------------------

--
-- Table structure for table `recovery`
--

CREATE TABLE `recovery` (
  `Bank_id` varchar(20) NOT NULL,
  `NID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `recovery`
--

INSERT INTO `recovery` (`Bank_id`, `NID`) VALUES
('888880', 5632589),
('999990', 223344);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`Bank_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`Name`),
  ADD UNIQUE KEY `N` (`NID`),
  ADD UNIQUE KEY `bankid` (`Bank_id`),
  ADD UNIQUE KEY `Name` (`Name`),
  ADD KEY `Name_2` (`Name`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD UNIQUE KEY `Employee_ID_2` (`Bank_id`),
  ADD KEY `Employee_ID` (`Bank_id`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`Bank_id`);

--
-- Indexes for table `recovery`
--
ALTER TABLE `recovery`
  ADD PRIMARY KEY (`Bank_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
