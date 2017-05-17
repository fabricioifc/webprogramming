drop database if exists servlet_login_db;
create database if not exists servlet_login_db;
use servlet_login_db;


CREATE TABLE usuarios (
  id int(11) NOT NULL AUTO_INCREMENT,
  nome varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  usuario varchar(45) NOT NULL,
  senha varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);

