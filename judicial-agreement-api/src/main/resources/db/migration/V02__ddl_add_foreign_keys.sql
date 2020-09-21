ALTER TABLE TB_CIDADE ADD FOREIGN KEY(ID_ESTADO) REFERENCES TB_ESTADO(ID);
ALTER TABLE TB_CLIENTE ADD FOREIGN KEY(ID_CIDADE) REFERENCES TB_CIDADE(ID);
ALTER TABLE TB_TELEFONE ADD FOREIGN KEY(ID_CLIENTE) REFERENCES TB_CLIENTE(ID);
ALTER TABLE TB_ACORDO ADD FOREIGN KEY(ID_CLIENTE) REFERENCES TB_CLIENTE(ID);
ALTER TABLE TB_ACORDO ADD FOREIGN KEY(ID_FORMA_PAGAMENTO) REFERENCES TB_FORMA_PAGAMENTO(ID);
ALTER TABLE TB_GUIA_PAGAMENTO ADD FOREIGN KEY(ID_ACORDO) REFERENCES TB_ACORDO(ID);