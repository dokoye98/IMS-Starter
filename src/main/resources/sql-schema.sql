drop database `ims`;

CREATE database IF NOT EXISTS `ims`;

USE `ims` ;
drop table if exists `client`;
CREATE TABLE IF NOT EXISTS `client` (
    `ID` INT(11) NOT NULL AUTO_INCREMENT,
    `FIRSTNAME` VARCHAR(40) DEFAULT NULL,
    `SURNAME` VARCHAR(40) DEFAULT NULL,
    `USERNAME` VARCHAR(40) DEFAULT NULL,
    `PASSWORD` VARCHAR(40) DEFAULT NULL,
    `membership` boolean DEFAULT null,
    PRIMARY KEY (`id`)
);
drop table if exists `product`;
create table if not exists `product`(
`product_id` int(11) not null AUTO_INCREMENT,
`cost` decimal (10,2),
`addons` varchar(45),
primary key(`product_id`));