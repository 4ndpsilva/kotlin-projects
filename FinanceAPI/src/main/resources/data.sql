INSERT INTO TB_CATEGORIA(ID, DESCRICAO) VALUES(1, 'Alimentação');
INSERT INTO TB_CATEGORIA(ID, DESCRICAO) VALUES(2, 'Moradia');
INSERT INTO TB_CATEGORIA(ID, DESCRICAO) VALUES(3, 'Transporte');
INSERT INTO TB_CATEGORIA(ID, DESCRICAO) VALUES(4, 'Higiene');
INSERT INTO TB_CATEGORIA(ID, DESCRICAO) VALUES(5, 'Limpeza');
INSERT INTO TB_CATEGORIA(ID, DESCRICAO) VALUES(6, 'Salário');

INSERT INTO TB_CONTA(CATEGORIA_ID, DESCRICAO) VALUES(1, 'Refrigerante');
INSERT INTO TB_CONTA(CATEGORIA_ID, DESCRICAO) VALUES(1, 'Bolacha');
INSERT INTO TB_CONTA(CATEGORIA_ID, DESCRICAO) VALUES(1, 'Pães');
INSERT INTO TB_CONTA(CATEGORIA_ID, DESCRICAO) VALUES(2, 'Internet');
INSERT INTO TB_CONTA(CATEGORIA_ID, DESCRICAO) VALUES(2, 'Aluguel');
INSERT INTO TB_CONTA(CATEGORIA_ID, DESCRICAO) VALUES(2, 'Conta de Energia');
INSERT INTO TB_CONTA(CATEGORIA_ID, DESCRICAO) VALUES(6, 'Adiantamento');
INSERT INTO TB_CONTA(CATEGORIA_ID, DESCRICAO) VALUES(6, '2º parcela Salário');
INSERT INTO TB_CONTA(CATEGORIA_ID, DESCRICAO) VALUES(3, 'Uber');

INSERT INTO TB_LANCAMENTO(DATA, CATEGORIA_ID, CONTA_ID, VALOR, OPERACAO, OBSERVACAO) VALUES('2019-05-21', 1, 3, 5.69, 1, '');
INSERT INTO TB_LANCAMENTO(DATA, CATEGORIA_ID, CONTA_ID, VALOR, OPERACAO, OBSERVACAO) VALUES('2019-05-20', 1, 2, 1.69, 1, '');
INSERT INTO TB_LANCAMENTO(DATA, CATEGORIA_ID, CONTA_ID, VALOR, OPERACAO, OBSERVACAO) VALUES('2018-05-01', 2, 5, 500.00, 1, '');
INSERT INTO TB_LANCAMENTO(DATA, CATEGORIA_ID, CONTA_ID, VALOR, OPERACAO, OBSERVACAO) VALUES('2018-01-11', 1, 3, 2.65, 1, '');
INSERT INTO TB_LANCAMENTO(DATA, CATEGORIA_ID, CONTA_ID, VALOR, OPERACAO, OBSERVACAO) VALUES('2019-01-20', 6, 8, 1200.00, 0, '');
INSERT INTO TB_LANCAMENTO(DATA, CATEGORIA_ID, CONTA_ID, VALOR, OPERACAO, OBSERVACAO) VALUES('2019-02-10', 3, 9, 11.60, 1, '');
INSERT INTO TB_LANCAMENTO(DATA, CATEGORIA_ID, CONTA_ID, VALOR, OPERACAO, OBSERVACAO) VALUES('2019-03-10', 3, 9, 9.69, 1, '');
INSERT INTO TB_LANCAMENTO(DATA, CATEGORIA_ID, CONTA_ID, VALOR, OPERACAO, OBSERVACAO) VALUES('2019-03-20', 6, 7, 968.00, 0, '');
INSERT INTO TB_LANCAMENTO(DATA, CATEGORIA_ID, CONTA_ID, VALOR, OPERACAO, OBSERVACAO) VALUES('2019-05-05', 1, 3, 1.69, 1, '');
INSERT INTO TB_LANCAMENTO(DATA, CATEGORIA_ID, CONTA_ID, VALOR, OPERACAO, OBSERVACAO) VALUES('2019-05-06', 1, 3, 3.79, 1, '');
INSERT INTO TB_LANCAMENTO(DATA, CATEGORIA_ID, CONTA_ID, VALOR, OPERACAO, OBSERVACAO) VALUES('2019-06-01', 2, 5, 500.00, 1, '');