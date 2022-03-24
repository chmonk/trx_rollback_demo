create database trxDemo;

use trxDemo;

drop table Item;

CREATE TABLE `Item` (
`id` int not null AUTO_INCREMENT,
`price` int NOT NULL,
`describe` varchar(60),
primary key (`id`)
);

INSERT INTO `Item` (`price`,`describe`) values (20000,'item 1 , origin item describe');
INSERT INTO `Item` (`price`,`describe`) values (30000,'item 2 , origin item describe');

UPDATE `Item` set `price`=20001, `describe`="item 1 , updated item describe" where id=1;
update `Item` set `price`=30001, `describe`="item 2 , updated item describe" where id=2;