create database db_clinica;
use db_clinica;


create table tb_usuarios(
idUsuario int primary key,
usuario varchar(50) not null,
foneUsuario varchar(15),
loginUsuario varchar(15) not null unique,
senhaUsuario nvarchar(80)
);

select * from tb_usuarios;

insert into tb_usuarios
(idUsuario,usuario,foneUsuario,loginUsuario,senhaUsuario) 
values (4, 'User','99999-9999','teste','teste');
select * from tb_usuarios;

create table tb_clientes(
idCli int primary key auto_increment,
nomeCli varchar(50) not null,
cep varchar(10),
logradouro varchar(200) not null,
numero varchar(10) not null,
complemento varchar(30),
bairro varchar(50) not null,
cidade varchar(100) not null,
uf char(2) not null,
fone1 varchar(15) not null,
fone2 varchar(15),
cpfCli varchar(20),
emailCli varchar(200)
);
ALTER TABLE tb_clientes DROP COLUMN tipoLogradouro;

select * from tb_clientes;

insert into tb_clientes
(nomeCli, cep, logradouro, numero, complemento, bairro, cidade, uf, fone1, fone2, cpfCli, emailCli ) 
values ('Murillo','0546986','rua tres','54','casa','sao joao','são paulo','SP','356787545','5456454','54544666464','mu@gmail.com');

insert into tb_clientes
(nomeCli, cep, logradouro, numero, complemento, bairro, cidade, uf, fone1, fone2, cpfCli, emailCli ) 
values ('Luiz','0546986','rua tres','54','casa','sao joao','são paulo','SP','356787545','56545','54544666464','mu@gmail.com');

insert into tb_clientes
(nomeCli, cep, logradouro, numero, complemento, bairro, cidade, uf, fone1, fone2, cpfCli, emailCli ) 
values ('Leandro','0546986','rua tres','54','casa','sao joao','são paulo','SP','356787545','11212','123456','mu@gmail.com');
select * from tb_clientes;


create table tb_profissional(
idPro int primary key auto_increment,
nomePro varchar(50) not null,
funcao varchar(50) not null,
cep varchar(10),
logradouro varchar(200) not null,
numero varchar(10) not null,
complemento varchar(30),
bairro varchar(50) not null,
cidade varchar(100) not null,
uf char(2) not null,
fone1 varchar(15) not null,
fone2 varchar(15),
cpfPro varchar(20),
emailPro varchar(200)
);

ALTER TABLE tb_profissional DROP COLUMN tipoLogradouro;

insert into tb_profissional
(nomePro, funcao, cep, tipoLogradouro, logradouro, numero, complemento, bairro, cidade, uf, fone1, fone2, cpfPro, emailPro ) 
values ('Leandro','Fonoaudiologo','0546986','rua','rua tres','54','casa','sao joao','são paulo','SP','356787545','545444544','54544666464','mu@gmail.com');
select * from tb_profissional;


create table tb_consulta(
idCli int primary key auto_increment,
dataConsulta varchar(50) not null,
horarioConsulta varchar(10),
tipoEspecialista varchar(50),
nomeEspecialista varchar(100) not null,
preco varchar(10) not null,
situacaoConsulta varchar(20) not null
);

insert into tb_consulta
(dataConsulta, horarioConsulta, tipoEspecialista, nomeEspecialista, preco, situacaoConsulta) 
values ('22/07/2019','18:00','Fonoauldiologo','Leandro','200,00','aprovada');
select * from tb_consulta;


