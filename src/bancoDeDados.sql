create database db_clinica;
use db_clinica;


create table tb_usuario(
id int auto_increment primary key,
usuario varchar (50) not null,
foneUsuario varchar (20),
login varchar(20) not null unique,
senha varchar(200) not null
);

insert into tb_usuario
(id, usuario, foneUsuario, login,  senha)
values (1, 'Administrador', '9999-9999', 'admin', 'admin');


create table tb_endereco(
id int auto_increment primary key,
tipo varchar(20) not null,
logradouro varchar(100) not null,
numero varchar(10) not null,
complemento varchar(30),
bairro varchar(40) not null,
cidade varchar(50) not null,
estado char (3) not null
);
describe tb_endereco;

create table tb_preco(
id int auto_increment primary key,
preco decimal(10,2) not null
);

create table tb_contato(
id int auto_increment primary key,
telefone varchar(20) not null,
email varchar(100) not null
);

create table tb_cliente(
id int auto_increment primary key,
nome varchar(200) not null,
cpf varchar(15) not null,
sexo char(2) not null,
idendereco int not null,
idcontato int not null,
idusuario int unique not null
);

create table tb_profissional(
id int auto_increment primary key,
nome varchar(200) not null,
funcao varchar(50) not null,
idendereco int not null,
idcontato int not null,
idusuario int unique not null
);

create table tb_servico(
id int auto_increment primary key,
tiposervico varchar(50) not null,
idpreco int not null
);


create table tb_horario(
id int auto_increment primary key,
idcliente int not null,
idservico int not null,
idprofissional int not null,
dia date not null,
hora time not null
); 

ALTER TABLE `db_clinica`.`tb_horario` 
CHANGE COLUMN `hora4` `hora5` VARCHAR(45) NULL DEFAULT NULL ;


create table tb_consulta(
id int primary key auto_increment,
tiposervico varchar(30) not null,
idcliente int not null,
idhorario int not null,
idservico int not null,	
idprofissional int not null,
idpreco int not null,
observacao varchar(200)
);
select * from tb_consulta;
describe tb_consulta;




