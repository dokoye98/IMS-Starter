drop database testims;

CREATE database IF NOT EXISTS `testims`;

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
drop table if exists `item`;
create table if not exists `item`(
`id` INT(11) NOT NULL AUTO_INCREMENT,
`cost` decimal(10,2),
`name` varchar(45),
primary key(`id`));
drop table if exists `orders`;
CREATE table if not exists `orders`(
`Order_ID` int(11) not null auto_increment,
`Customer_ID` int ,
primary key(`order_id`),
foreign key(`Customer_ID`) references `customers`(`id`) on delete cascade on update cascade);
DROP TABLE IF EXISTS `orderitem`;
create table `orderitem`(
`item_ID` int ,
`order_id` int,
foreign key (`item_ID`) references `item`(`id`) on delete cascade on update cascade,
foreign key (`order_id`) references `orders`(`order_id`) on delete cascade on update cascade);
