CREATE DATABASE SysBancario;

USE SysBancario;

CREATE TABLE User(
codigo int PRIMARY KEY AUTO_INCREMENT,
login VARCHAR(50) NOT NULL,
senha VARCHAR(50) NOT NULL
); 

CREATE TABLE Nota(
codigo int PRIMARy KEY AUTO_INCREMENT,
nome VARCHAR(50) NOT NULL,
nota VARCHAR(255) NOT NULL
);

INSERT INTO User (login, senha) VALUES("root", "root");
