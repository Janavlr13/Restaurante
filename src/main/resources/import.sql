-- UTILIZADORES
INSERT INTO utilizador (nome, email, senha, perfil)
VALUES ('Joana', 'teste@email.com', '123', 'ADMIN');

-- MESAS
INSERT INTO mesa (numero_mesa, capacidade, situacao)
VALUES (1, 4, 'LIVRE'),
       (2, 2, 'OCUPADA'),
       (3, 4, 'Ocupada'),
       (4, 4, 'Disponível'),
       (5, 6, 'Reservada'),
       (6, 6, 'Disponível'),
       (7, 8, 'Disponível'),
       (8, 2, 'Ocupada'),
       (9, 4, 'Disponível'),
       (10, 10, 'Disponível');

-- CLIENTE
INSERT INTO cliente (nome, contato, email, data_nascimento)
VALUES ('João Modesto', '921111111', 'joao@email.com', '1990-01-10'),
       ('Maria Santos', '922222222', 'maria@email.com', '1995-03-15'),
       ('Pedro Oliveira', '923333333', 'pedro@email.com', '1988-07-20'),
       ('Sofia Costa', '924444444', 'sofia@email.com', '1992-11-30'),
       ('Ricardo Ramos', '925555555', 'ricardo@email.com', '1985-05-12'),
       ('Beatriz Dias', '926666666', 'beatriz@email.com', '2000-09-05'),
       ('Miguel Sousa', '927777777', 'miguel@email.com', '1993-12-25'),
       ('Catarina Martins', '928888888', 'catarina@email.com', '1997-02-14'),
       ('Tiago Ferreira', '929999999', 'tiago@email.com', '1991-06-18'),
       ('Inês Lopes', '920000000', 'ines@email.com', '1994-10-08');

-- GERENTE
INSERT INTO gerente (nome, data_nascimento, contato, endereco, email) VALUES
        ('Ana Martins', '1985-03-22', '912345678', 'Rua das Flores 123, Porto', 'ana.martins@restaurante.pt'),
       ('Ricardo Jorge', '1992-11-05', '933456789', 'Avenida Central 45, Braga', 'ricardo.jorge@restaurante.pt'),
       ('Sofia Oliveira', '1978-07-14', '966789012', 'Praça da Liberdade 10, Lisboa', 'sofia.oliveira@restaurante.pt');

-- FUNCIONÁRIOS
INSERT INTO funcionario (nome, cargo, data_nascimento, contato, endereco, email) VALUES
('Pedro Santos', 'Empregado de Mesa', '1995-10-12', '910111222', 'Rua de Cedofeita 50, Porto', 'pedro.santos@restaurante.pt'),
('Marta Costa', 'Cozinheira', '1988-02-28', '922333444', 'Rua Direita 15, Matosinhos', 'marta.costa@restaurante.pt'),
('Tiago Silva', 'Barman', '2001-05-20', '933444555', 'Largo do Amparo 8, Maia', 'tiago.silva@restaurante.pt');

-- RESERVAS
INSERT INTO reserva (data, hora, num_pessoas, estado, id_cliente, id_funcionario, id_gerente, id_mesa) VALUES
('2026-05-20', '12:30:00', 4, 'Confirmada', 1, 1, 1, 1),
('2026-05-20', '20:00:00', 2, 'Pendente', 2, 2, 1, 2),
('2026-05-21', '13:00:00', 6, 'Confirmada', 3, 1, 2, 1),
('2026-05-22', '19:30:00', 3, 'Cancelada', 1, 3, 3, 2),
('2026-05-23', '21:00:00', 5, 'Confirmada', 2, 2, 2, 1);