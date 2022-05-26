drop schema testims;

CREATE SCHEMA IF NOT EXISTS `testims`;

USE `testims` ;
drop table if exists `customers`;
CREATE TABLE IF NOT EXISTS `CUSTOMERS` (
    `ID` INT(11) NOT NULL AUTO_INCREMENT,
    `FIRSTNAME` VARCHAR(40) DEFAULT NULL,
    `SURNAME` VARCHAR(40) DEFAULT NULL,
    `USERNAME` VARCHAR(40) DEFAULT NULL,
    `PASSWORD` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);
