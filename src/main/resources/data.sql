insert into PERFIL values ('MASTER');
insert into PERFIL values ('ADMINISTRADOR');
insert into PERFIL values ('COMUM');
insert into CARGO values ('GERENTE');
insert into CARGO values ('DESENVOLVEDOR');
insert into CARGO values ('COORDENADOR');
insert into CARGO values ('SUPORTE_TI');
insert into USUARIO (ID, CPF, DATA_DE_NASCIMENTO, NOME, SEXO, STATU, CARGO_TITULO, PERFIL_TITULO) values (1, '11954046030', 1991-06-05 00:00:00, 'Paulo', 'MASCULINO', 'INATIVO', 'DESENVOLVEDOR', 'COMUM');
insert into USUARIO (ID, CPF, DATA_DE_NASCIMENTO, NOME, SEXO, STATU, CARGO_TITULO, PERFIL_TITULO) values (2, '15724110075', 1990-12-01 00:00:00, 'João', 'MASCULINO', 'ATIVO', 'DESENVOLVEDOR', 'ADMINISTRADOR');
insert into USUARIO (ID, CPF, DATA_DE_NASCIMENTO, NOME, SEXO, STATU, CARGO_TITULO, PERFIL_TITULO) values (3, '64800770084', 2008-03-17 00:00:00, 'Maria', 'FEMININO', 'ATIVO', 'SUPORTE_TI', 'COMUM');
insert into USUARIO (ID, CPF, DATA_DE_NASCIMENTO, NOME, SEXO, STATU, CARGO_TITULO, PERFIL_TITULO) values (4, '09301177005', 1988-01-05 00:00:00, 'Josefina', 'FEMININO', 'ATIVO', 'GERENTE', 'MASTER');