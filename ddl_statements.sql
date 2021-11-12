CREATE DATABASE `vmts` ;

CREATE TABLE `address` (
  `EMP_ID` int NOT NULL,
  `LOCALITY` varchar(150) DEFAULT NULL,
  `CITY` varchar(150) DEFAULT NULL,
  `STATE` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`EMP_ID`),
  CONSTRAINT `address_ibfk_1` FOREIGN KEY (`EMP_ID`) REFERENCES `employee` (`EMP_ID`)
);

--
CREATE TABLE `booking` (
  `BOOKING_ID` int NOT NULL AUTO_INCREMENT,
  `VEHICLE_ID` varchar(20) DEFAULT NULL,
  `CUSTOMER_ID` int DEFAULT NULL,
  `DRIVER_ID` int DEFAULT NULL,
  `EXECUTIVE_ID` int DEFAULT NULL,
  `START_DATE` date DEFAULT NULL,
  `END_DATE` date DEFAULT NULL,
  `PENALTY_CHARGE` double DEFAULT NULL,
  `KM_DRIVEN` double DEFAULT NULL,
  `INSURANCE_CLAIM_AMOUNT` double DEFAULT NULL,
  `BOOKING_STATUS` enum('booked','confirmed','cancelled','completed','paid') DEFAULT NULL,
  PRIMARY KEY (`BOOKING_ID`),
  KEY `VEHICLE_ID` (`VEHICLE_ID`),
  KEY `CUSTOMER_ID` (`CUSTOMER_ID`),
  KEY `DRIVER_ID` (`DRIVER_ID`),
  KEY `EXECUTIVE_ID` (`EXECUTIVE_ID`),
  CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`VEHICLE_ID`) REFERENCES `vehicle` (`REG_NO`),
  CONSTRAINT `booking_ibfk_2` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `customer_dtls` (`CUSTOMER_ID`),
  CONSTRAINT `booking_ibfk_3` FOREIGN KEY (`DRIVER_ID`) REFERENCES `driver` (`EMP_ID`),
  CONSTRAINT `booking_ibfk_4` FOREIGN KEY (`EXECUTIVE_ID`) REFERENCES `executive` (`EMP_ID`)
) ;

----
CREATE TABLE `customer_dtls` (
  `CUSTOMER_ID` int NOT NULL AUTO_INCREMENT,
  `CUSTOMER_TYPE` enum('govt','private') DEFAULT NULL,
  `ORG_NAME` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`CUSTOMER_ID`)
) ;
----

CREATE TABLE `customer_dtls` (
  `CUSTOMER_ID` int NOT NULL AUTO_INCREMENT,
  `CUSTOMER_TYPE` enum('govt','private') DEFAULT NULL,
  `ORG_NAME` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`CUSTOMER_ID`)
);
----
CREATE TABLE `driver` (
  `EMP_ID` int NOT NULL,
  `LICENSE_NO` varchar(32) DEFAULT NULL,
  `LICENSE_TYPE` enum('lmv','hmv') DEFAULT NULL,
  `RATING` double DEFAULT NULL,
  PRIMARY KEY (`EMP_ID`),
  CONSTRAINT `driver_ibfk_1` FOREIGN KEY (`EMP_ID`) REFERENCES `employee` (`EMP_ID`)
);
----
CREATE TABLE `driver_rating` (
  `DRIVER_ID` int NOT NULL,
  `BOOKING_ID` int NOT NULL,
  `RATING` double DEFAULT NULL,
  PRIMARY KEY (`DRIVER_ID`,`BOOKING_ID`),
  KEY `BOOKING_ID` (`BOOKING_ID`),
  CONSTRAINT `driver_rating_ibfk_1` FOREIGN KEY (`DRIVER_ID`) REFERENCES `employee` (`EMP_ID`),
  CONSTRAINT `driver_rating_ibfk_2` FOREIGN KEY (`BOOKING_ID`) REFERENCES `booking` (`BOOKING_ID`)
) ;
------
CREATE TABLE `employee` (
  `EMP_ID` int NOT NULL AUTO_INCREMENT,
  `FNAME` varchar(150) DEFAULT NULL,
  `LNAME` varchar(150) DEFAULT NULL,
  `DOJ` date DEFAULT NULL,
  `PHONE` int DEFAULT NULL,
  `job_type` varchar(150) DEFAULT NULL,
  `SALARY` int DEFAULT NULL,
  PRIMARY KEY (`EMP_ID`)
) ;
------
CREATE TABLE `executive` (
  `EMP_ID` int NOT NULL,
  `RATING` double DEFAULT NULL,
  PRIMARY KEY (`EMP_ID`),
  CONSTRAINT `executive_ibfk_1` FOREIGN KEY (`EMP_ID`) REFERENCES `employee` (`EMP_ID`)
) ;
-----
CREATE TABLE `executive_rating` (
  `EXECUTIVE_ID` int NOT NULL,
  `BOOKING_ID` int NOT NULL,
  `RATING` double DEFAULT NULL,
  PRIMARY KEY (`EXECUTIVE_ID`,`BOOKING_ID`),
  KEY `BOOKING_ID` (`BOOKING_ID`),
  CONSTRAINT `executive_rating_ibfk_1` FOREIGN KEY (`EXECUTIVE_ID`) REFERENCES `employee` (`EMP_ID`),
  CONSTRAINT `executive_rating_ibfk_2` FOREIGN KEY (`BOOKING_ID`) REFERENCES `booking` (`BOOKING_ID`)
);
-----
CREATE TABLE `fuel_dtls` (
  `VEHICLE_ID` varchar(10) NOT NULL,
  `FUEL_FILLED_AMOUNT` double DEFAULT NULL,
  `DATE_OF_FILLING` date NOT NULL,
  `fuel_filled` double DEFAULT NULL,
  PRIMARY KEY (`VEHICLE_ID`,`DATE_OF_FILLING`),
  CONSTRAINT `fuel_dtls_ibfk_1` FOREIGN KEY (`VEHICLE_ID`) REFERENCES `vehicle` (`REG_NO`)
) ;
-----
CREATE TABLE `insurance_dtls` (
  `INSURANCE_ID` varchar(20) NOT NULL,
  `DATE_TAKEN` date DEFAULT NULL,
  `EXPIRY_DATE` date DEFAULT NULL,
  `AMOUNT` double DEFAULT NULL,
  `NO_OF_CLAIMS` int DEFAULT NULL,
  PRIMARY KEY (`INSURANCE_ID`),
  CONSTRAINT `insurance_dtls_ibfk_1` FOREIGN KEY (`INSURANCE_ID`) REFERENCES `vehicle` (`INSURANCE_NO`)
);
------
CREATE TABLE `vehicle` (
  `REG_NO` varchar(10) NOT NULL,
  `FUEL_TYPE` varchar(20) DEFAULT NULL,
  `INSURANCE_NO` varchar(150) DEFAULT NULL,
  `VEHICLE_TYPE` enum('LMV','HMV') DEFAULT NULL,
  `RENT_PER_DAY` double DEFAULT NULL,
  PRIMARY KEY (`REG_NO`),
  KEY `INSURANCE_NO` (`INSURANCE_NO`)
);
------
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_driver_rating`()
BEGIN
 update vmts.driver d set d.rating =  round((select avg(r.rating)
 from vmts.driver_rating r where r.driver_id=d.emp_id group by r.driver_id ),2) ;
END$$
DELIMITER ;
-----
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_executive_rating`()
BEGIN
 update vmts.executive e set e.rating =  round((select avg(r.rating)
 from vmts.executive_rating r where r.executive_id=e.emp_id group by r.executive_id ),2) ;
END$$
DELIMITER ;
-----
DELIMITER $$
CREATE TRIGGER vmts.update_driver
    AFTER INSERT
    ON vmts.driver_rating FOR EACH ROW
BEGIN
    call vmts.update_driver_rating();
END$$
DELIMITER ;
-----
DELIMITER $$
CREATE TRIGGER vmts.update_executive
    AFTER INSERT
    ON vmts.executive_rating FOR EACH ROW
BEGIN
    call vmts.update_executive_rating();
ENDD$$
DELIMITER ;