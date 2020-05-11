DROP SCHEMA IF EXISTS `school`;
CREATE SCHEMA `school`;
USE `school`;

DROP TABLE IF EXISTS `school`;

CREATE TABLE `class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(45) NOT NULL,
  `address` varchar(45) DEFAULT NULL,
  `math` double DEFAULT NULL,
  `chemistry` double DEFAULT NULL,
  `physical` double DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `class_student`;
CREATE TABLE `class_student`(
	`student_id` int(11) NOT NULL,
    `class_id` int(11) NOT NULL,
    PRIMARY KEY (`student_id`,`class_id`),
    KEY `FK_STUDENT` (`student_id`),
    
    CONSTRAINT `FX_STUDENT`	FOREIGN KEY(`student_id`) REFERENCES `student`(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT `FX_CLASS` FOREIGN KEY(`class_id`) REFERENCES `class`(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


