DROP SCHEMA IF EXISTS `tea03`;
CREATE SCHEMA `tea03`;
use `tea03`;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `Employee`;
CREATE TABLE `Employee` ( 
	`id` int(10) NOT NULL AUTO_INCREMENT,
	`phone` int(10) DEFAULT NULL,
    `name` varchar(30) NOT NULL,
    `birthday` datetime DEFAULT NULL,
	`timeWork` int(10) NOT NULL,
    `level` varchar(10) NOT NULL,
    `address` varchar(30) DEFAULT NULL,
    `avatar` varchar(30) DEFAULT NULL,
     PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- INSERT INTO Employee (id,phone,name,birthday,timeWork,level) VALUE(1,1,1,1,1,1);

DROP TABLE IF EXISTS `Customer`;
CREATE TABLE `Customer` (
	`phone` int(10) NOT NULL AUTO_INCREMENT,
    `name` varchar(30) NOT NULL,
    `level` int(10) DEFAULT NULL,
    PRIMARY KEY (`phone`)
)ENGINE=InnoDB AUTO_INCREMENT=1, DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `Voucher`;
CREATE TABLE `Voucher` (
	`code` int(10) NOT NULL AUTO_INCREMENT,
	`percent` float(10) DEFAULT NULL,
    `time` datetime NOT NULL,
    `phoneNumber`int(10) NOT NULL,
     PRIMARY KEY (`code`),
     
	 CONSTRAINT FOREIGN KEY (`phoneNumber`)
     REFERENCES `Customer` (`phone`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `Bill`;
CREATE TABLE `Bill`(
	`id` int(10) NOT NULL AUTO_INCREMENT,
    `time` datetime NOT NULL,
    `employeeId` int(10) DEFAULT NULL,
    `customerId` int(10) DEFAULT NULL,
    `codeVoucher` int (100) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FX_DETAIL_idx` (`employeeId`),
    CONSTRAINT `FX_DETAIL` FOREIGN KEY (`employeeId`)
    REFERENCES `Employee` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    
    KEY `FX_CUSTOMER` (`customerId`),
    CONSTRAINT `FX_CUSTOMER_01` FOREIGN KEY (`customerId`)
    REFERENCES `Customer` (`phone`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    
    KEY `FX_VOUCHER` (`codeVoucher`),
    CONSTRAINT `FX_VOUCHER_01` FOREIGN KEY (`codeVoucher`)
    REFERENCES `Voucher` (`code`) ON DELETE NO ACTION ON UPDATE NO ACTION
    
    
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `Tea`;
CREATE TABLE `Tea`(
	`id` int(10) NOT NULL AUTO_INCREMENT,
    `name` varchar(30) NOT NULL,
    `price` int(100) NOT NULL,
    `status` int(1) NOT NULL,
    PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1,DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `TeaBill`;
CREATE TABLE `TeaBill`(
	`teaId` int(10) NOT NULL,
    `billId` int (10) NOT NULL,
	`amount` int (10) NOT NULL,
    `price` int (100) NOT NULL,
    `addRequest` varchar(10) DEFAULT NULL,
    PRIMARY KEY (`teaId`,`billId`),
    CONSTRAINT `FX_TEA` FOREIGN KEY (`teaId`)
    REFERENCES `Tea`(`id`),
    
    CONSTRAINT 	`FX_BILL` FOREIGN KEY(`billId`)
    REFERENCES 	`Bill`(`id`)
    
)ENGINE=InnoDB AUTO_INCREMENT=1,DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `Topping`;
CREATE TABLE `Topping` (
	`id` int(10) NOT NULL AUTO_INCREMENT,
    `price` int (100) NOT NULL,
    PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1,DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `TeaTopping`;
CREATE TABLE `TeaTopping`(
	`teaId` int(10) NOT NULL,
    `toppingId` int(10) NOT NULL,
     PRIMARY KEY (`teaId`,`toppingId`),
     
	CONSTRAINT `FX_TEA_01` FOREIGN KEY (`teaId`)
    REFERENCES `Tea`(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    
    CONSTRAINT `FX_TOPPING_01` FOREIGN KEY (`toppingId`)
    REFERENCES `Topping`(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1,DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `Resource`;
CREATE TABLE `Resource`(
	`id` int(10) NOT NULL AUTO_INCREMENT,
    `date` datetime NOT NULL,
    `amount` int(100) NOT NULL,
    PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1,DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `TeaResource`;
CREATE TABLE `TeaResource`(
	`teaId` int(10) NOT NULL,
    `resourceId` int(10) NOT NULL,
    `amount` int(100) NOT NULL,
    PRIMARY KEY (`teaId`,`resourceId`),
    
    CONSTRAINT `FX_TEA_02` FOREIGN KEY (`teaId`)
    REFERENCES `Tea` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    
    CONSTRAINT `FX_RESOURCE_02` FOREIGN KEY (`resourceId`)
    REFERENCES `Resource` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
    
)ENGINE=InnoDB AUTO_INCREMENT=1, DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `ToppingBill`;
CREATE TABLE `ToppingBill`(
	`toppingId` int(10) NOT NULL,
    `billId` int (10) NOT NULL,
	`amount` int (10) NOT NULL,
    PRIMARY KEY (`toppingId`,`billId`),
    
	CONSTRAINT FOREIGN KEY (`toppingId`)
    REFERENCES `Topping`(`id`),
    
    CONSTRAINT 	FOREIGN KEY(`billId`)
    REFERENCES 	`Bill`(`id`)   
)ENGINE=InnoDB AUTO_INCREMENT=1,DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;

ALTER TABLE Customer
ADD COLUMN birthday datetime DEFAULT NULL;











