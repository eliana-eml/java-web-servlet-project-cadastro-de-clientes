CREATE DATABASE clientes;
USE clientes;

CREATE TABLE cli (
	id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(120) NOT NULL,
    telefone VARCHAR(11) NOT NULL,
    endereco VARCHAR(200) NOT NULL
);

INSERT INTO cli (nome, telefone, endereco) VALUES ('Ian Clarke', 55554444, 'Rua Sofia, 123');

CREATE TABLE historico_clientes(
	id INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT,
    nome VARCHAR(120) NOT NULL,
    telefone VARCHAR(11) NOT NULL,
    endereco VARCHAR(200) NOT NULL
);

DELIMITER $
CREATE TRIGGER tr_historico_clientes BEFORE DELETE
ON cli
FOR EACH ROW
BEGIN
    INSERT INTO historico_clientes (id_cliente, nome, telefone, endereco) VALUES (OLD.id, OLD.nome, OLD.telefone, OLD.endereco);
END$
DELIMITER ;

SELECT * FROM cli;