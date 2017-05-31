drop database servlet_login_db;
create database servlet_login_db;
use servlet_login_db;

CREATE TABLE usuarios (
  id int(11) NOT NULL AUTO_INCREMENT,
  nome varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  usuario varchar(45) NOT NULL,
  senha varchar(255) NOT NULL,
  PRIMARY KEY (id)
)

CREATE TABLE filmes (
    id INTEGER NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    genero VARCHAR(40) NOT NULL,
    imagem text NOT NULL,
    PRIMARY KEY(id)
);

insert into filmes (nome, genero, imagem) values ('Rei Arthur – A Lenda da Espada', 'Ação', 'https://gds-wifmtpphmjvvgffvmg.netdna-ssl.com/contentFiles/image/opt_w840h0/cinema/2017/janeiro-2017/arthur.jpg');
insert into filmes (nome, genero, imagem) values ('Mulher-Maravilha', 'Qudrinhos', 'http://br.web.img2.acsta.net/videothumbnails/17/01/03/13/26/084343.jpg');
insert into filmes (nome, genero, imagem) values ('Logan', 'Quadrinhos', 'http://s2.glbimg.com/gPIvxBGroxjtNnMovwnb5j3A0co=/620x0/top/s.glbimg.com/jo/eg/f/original/2016/10/20/logan3.jpg');
insert into filmes (nome, genero, imagem) values ('Guardiões da Galáxia 2', 'Quadrinhos', 'http://rollingstone.uol.com.br/media/images/original/2014/07/27/img-1024882-guardioes-da-galaxia.jpg');