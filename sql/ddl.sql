CREATE TABLE categoria (
     id int NOT NULL AUTO_INCREMENT,
     nome varchar(50) NOT NULL,
     PRIMARY KEY (id)
);

CREATE TABLE solicitante (
   id int NOT NULL AUTO_INCREMENT,
   nome varchar(200) NOT NULL,
   cpf_cnpj varchar(14) NOT NULL,
   PRIMARY KEY (id)
);

CREATE TABLE solicitacao (
   id int NOT NULL AUTO_INCREMENT,
   solicitante_id int NOT NULL,
   categoria_id int NOT NULL,
   descricao varchar(200) NOT NULL,
   valor decimal(10,2) NOT NULL,
   data_solicitacao date NOT NULL,
   status_id int NOT NULL,
   PRIMARY KEY (id),
   KEY fk_solicitante (solicitante_id),
   KEY fk_categoria (categoria_id),
   CONSTRAINT fk_categoria FOREIGN KEY (categoria_id) REFERENCES categoria (id),
   CONSTRAINT fk_solicitante FOREIGN KEY (solicitante_id) REFERENCES solicitante (id)
);