INSERT INTO TB_USUARIO(NOME, EMAIL, LOGIN, SENHA, ATIVO) VALUES('Usuário teste 1', 'teste@email.com', 'user1', '12345', TRUE);
INSERT INTO TB_USUARIO(NOME, EMAIL, LOGIN, SENHA, ATIVO) VALUES('Usuário teste 2', 'teste2@email.com', 'user2', '12345', TRUE);

INSERT INTO TB_CATEGORIA(ID, DESCRICAO, USUARIO_ID) VALUES(1, 'Alimentação', 1);
INSERT INTO TB_CATEGORIA(ID, DESCRICAO, USUARIO_ID) VALUES(2, 'Moradia', 1);
INSERT INTO TB_CATEGORIA(ID, DESCRICAO, USUARIO_ID) VALUES(3, 'Transporte', 1);
INSERT INTO TB_CATEGORIA(ID, DESCRICAO, USUARIO_ID) VALUES(4, 'Higiene', 1);
INSERT INTO TB_CATEGORIA(ID, DESCRICAO, USUARIO_ID) VALUES(5, 'Limpeza', 1);
INSERT INTO TB_CATEGORIA(ID, DESCRICAO, USUARIO_ID) VALUES(6, 'Salário', 1);

INSERT INTO TB_CATEGORIA(ID, DESCRICAO, USUARIO_ID) VALUES(1, 'Empréstimos', 2);
INSERT INTO TB_CATEGORIA(ID, DESCRICAO, USUARIO_ID) VALUES(2, 'Locações', 2);

INSERT INTO TB_CONTA(ID, CATEGORIA_ID, DESCRICAO, USUARIO_ID) VALUES(1, 1, 'Refrigerante', 1);
INSERT INTO TB_CONTA(ID, CATEGORIA_ID, DESCRICAO, USUARIO_ID) VALUES(2, 1, 'Bolacha', 1);
INSERT INTO TB_CONTA(ID, CATEGORIA_ID, DESCRICAO, USUARIO_ID) VALUES(3, 1, 'Pães', 1);
INSERT INTO TB_CONTA(ID, CATEGORIA_ID, DESCRICAO, USUARIO_ID) VALUES(4, 2, 'Internet', 1);
INSERT INTO TB_CONTA(ID, CATEGORIA_ID, DESCRICAO, USUARIO_ID) VALUES(5, 2, 'Aluguel', 1);
INSERT INTO TB_CONTA(ID, CATEGORIA_ID, DESCRICAO, USUARIO_ID) VALUES(6, 2, 'Conta de Energia', 1);
INSERT INTO TB_CONTA(ID, CATEGORIA_ID, DESCRICAO, USUARIO_ID) VALUES(7, 6, 'Adiantamento', 1);
INSERT INTO TB_CONTA(ID, CATEGORIA_ID, DESCRICAO, USUARIO_ID) VALUES(8, 6, '2º parcela Salário', 1);
INSERT INTO TB_CONTA(ID, CATEGORIA_ID, DESCRICAO, USUARIO_ID) VALUES(9, 3, 'Uber', 1);

INSERT INTO TB_CONTA(ID, CATEGORIA_ID, DESCRICAO, USUARIO_ID) VALUES(1, 2, 'Casa 2', 2);
INSERT INTO TB_CONTA(ID, CATEGORIA_ID, DESCRICAO, USUARIO_ID) VALUES(2, 2, 'Apartamento 111', 2);
INSERT INTO TB_CONTA(ID, CATEGORIA_ID, DESCRICAO, USUARIO_ID) VALUES(3, 1, 'Compra de carro', 2);
INSERT INTO TB_CONTA(ID, CATEGORIA_ID, DESCRICAO, USUARIO_ID) VALUES(4, 2, 'Casa 1', 2);

INSERT INTO TB_LANCAMENTO(ID, DATA, CATEGORIA_ID, CONTA_ID, VALOR, OPERACAO, OBSERVACAO, USUARIO_ID) VALUES(1, '2019-05-21', 1, 3, 5.69, 'DEBITO', '', 1);
INSERT INTO TB_LANCAMENTO(ID, DATA, CATEGORIA_ID, CONTA_ID, VALOR, OPERACAO, OBSERVACAO, USUARIO_ID) VALUES(2, '2019-05-20', 1, 2, 1.69, 'DEBITO', '', 1);
INSERT INTO TB_LANCAMENTO(ID, DATA, CATEGORIA_ID, CONTA_ID, VALOR, OPERACAO, OBSERVACAO, USUARIO_ID) VALUES(3, '2018-05-01', 2, 5, 500.00, 'DEBITO', '', 1);
INSERT INTO TB_LANCAMENTO(ID, DATA, CATEGORIA_ID, CONTA_ID, VALOR, OPERACAO, OBSERVACAO, USUARIO_ID) VALUES(4, '2018-01-11', 1, 3, 2.65, 'DEBITO', '', 1);
INSERT INTO TB_LANCAMENTO(ID, DATA, CATEGORIA_ID, CONTA_ID, VALOR, OPERACAO, OBSERVACAO, USUARIO_ID) VALUES(5, '2019-01-20', 6, 8, 1200.00, 'CREDITO', '', 1);
INSERT INTO TB_LANCAMENTO(ID, DATA, CATEGORIA_ID, CONTA_ID, VALOR, OPERACAO, OBSERVACAO, USUARIO_ID) VALUES(7, '2019-02-10', 3, 9, 11.60, 'DEBITO', '', 1);
INSERT INTO TB_LANCAMENTO(ID, DATA, CATEGORIA_ID, CONTA_ID, VALOR, OPERACAO, OBSERVACAO, USUARIO_ID) VALUES(8, '2019-03-10', 3, 9, 9.69, 'DEBITO', '', 1);
INSERT INTO TB_LANCAMENTO(ID, DATA, CATEGORIA_ID, CONTA_ID, VALOR, OPERACAO, OBSERVACAO, USUARIO_ID) VALUES(9, '2019-03-20', 6, 7, 968.00, 'CREDITO', '', 1);
INSERT INTO TB_LANCAMENTO(ID, DATA, CATEGORIA_ID, CONTA_ID, VALOR, OPERACAO, OBSERVACAO, USUARIO_ID) VALUES(10, '2019-05-05', 1, 3, 1.69, 'DEBITO', '', 1);
INSERT INTO TB_LANCAMENTO(ID, DATA, CATEGORIA_ID, CONTA_ID, VALOR, OPERACAO, OBSERVACAO, USUARIO_ID) VALUES(11, '2019-05-06', 1, 3, 3.79, 'DEBITO', '', 1);
INSERT INTO TB_LANCAMENTO(ID, DATA, CATEGORIA_ID, CONTA_ID, VALOR, OPERACAO, OBSERVACAO, USUARIO_ID) VALUES(12, '2019-06-01', 2, 5, 500.00, 'DEBITO', '', 1);

INSERT INTO TB_LANCAMENTO(ID, DATA, CATEGORIA_ID, CONTA_ID, VALOR, OPERACAO, OBSERVACAO, USUARIO_ID) VALUES(1, '2019-03-20', 1, 1, 968.00, 'CREDITO', '', 2);
INSERT INTO TB_LANCAMENTO(ID, DATA, CATEGORIA_ID, CONTA_ID, VALOR, OPERACAO, OBSERVACAO, USUARIO_ID) VALUES(2, '2019-05-05', 1, 2, 11.69, 'CREDITO', '', 2);
INSERT INTO TB_LANCAMENTO(ID, DATA, CATEGORIA_ID, CONTA_ID, VALOR, OPERACAO, OBSERVACAO, USUARIO_ID) VALUES(3, '2019-05-06', 1, 3, 1000.00, 'CREDITO', '', 2);
INSERT INTO TB_LANCAMENTO(ID, DATA, CATEGORIA_ID, CONTA_ID, VALOR, OPERACAO, OBSERVACAO, USUARIO_ID) VALUES(4, '2019-06-01', 2, 3, 500.00, 'CREDITO', '', 2);