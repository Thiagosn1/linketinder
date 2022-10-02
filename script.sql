CREATE TABLE candidato (
	id SERIAL PRIMARY KEY,
	nome CHARACTER VARYING(50) NOT NULL,
	sobrenome CHARACTER VARYING(50) NOT NULL,
	dt_nasc CHARACTER VARYING(50) NOT NULL,
	email CHARACTER VARYING(50) NOT NULL,
	cpf CHARACTER VARYING(11) NOT NULL,
	pais CHARACTER VARYING(30) NOT NULL,
	cep CHARACTER VARYING(10) NOT NULL,
	descricaoPessoal CHARACTER VARYING(150),
	senha CHARACTER VARYING(10) NOT NULL
);

CREATE TABLE empresa (
	id SERIAL PRIMARY KEY,
	nome CHARACTER VARYING(50) NOT NULL,
	cnpj CHARACTER VARYING(50) NOT NULL,
	emailCorporativo CHARACTER VARYING(30) NOT NULL,
	pais CHARACTER VARYING(30) NOT NULL,
	cep CHARACTER VARYING(10) NOT NULL,
	descricao CHARACTER VARYING(150),
	senha CHARACTER VARYING(15) NOT NULL
);

CREATE TABLE vaga (
	id SERIAL PRIMARY KEY,
	descricao CHARACTER VARYING(150) NOT NULL,
	localVaga CHARACTER VARYING(150) NOT NULL,
	idEmpresa INT REFERENCES empresa(id) NOT NULL
);

CREATE TABLE competencia (
	id SERIAL PRIMARY KEY,
	descricao CHARACTER VARYING(150) NOT NULL
);

CREATE TABLE competenciaCandidato(
	id SERIAL PRIMARY KEY,
	idCandidato INT REFERENCES candidato(id) NOT NULL,
	idCompetencia INT REFERENCES competencia(id) NOT NULL
);

CREATE TABLE competenciaEmpresa(
	id SERIAL PRIMARY KEY,
	idVaga INT REFERENCES vaga(id) NOT NULL,
	idCompetencia INT REFERENCES competencia(id) NOT NULL
);

INSERT INTO candidato(nome, sobrenome, dt_nasc, email, cpf, pais, cep, descricaoPessoal, senha) VALUES ('Thiago', 'Silva', '1999-10-15', 'thiago123@gmail.com', '11111111111', 'Brasil', '71110000', 'Desenvolvedor Web', 'thiago11');
INSERT INTO candidato(nome, sobrenome, dt_nasc, email, cpf, pais, cep, descricaoPessoal, senha) VALUES ('João', 'Ferreira', '2000-10-14', 'joao123@@gmail.com', '22222222222', 'Brasil', '72220000', 'Estudante', 'joao11');
INSERT INTO candidato(nome, sobrenome, dt_nasc, email, cpf, pais, cep, descricaoPessoal, senha) VALUES ('Mariana', 'Santos', '1995-09-30', 'mariana123@@gmail.com', '33333333333', 'Brasil', '73330000', 'Designer', 'mariana11');

INSERT INTO empresa(nome, cnpj, emailCorporativo, pais, cep, descricao, senha) VALUES ('Optimus Tecnologia', '11111111111111', 'optimustech@outlook.com', 'Brasil', '33330000', 'Consultoria Especializada em Tecnologia e Transformação Digital', 'optimus1');
INSERT INTO empresa(nome, cnpj, emailCorporativo, pais, cep, descricao, senha) VALUES ('Twisted Soluções', '22222222222222', 'twistedsolucoes@outlook.com', 'Brasil', '44440000', 'Soluções em tecnologia', 'twistedso1');
INSERT INTO empresa(nome, cnpj, emailCorporativo, pais, cep, descricao, senha) VALUES ('Harvest Informática', '33333333333333', 'harvestinfo@outlook.com', 'Brasil', '77770000', 'Equipamentos de Informática', 'harvestinfo1');

INSERT INTO competencia(descricao) VALUES ('Javascript');
INSERT INTO competencia(descricao) VALUES ('React');
INSERT INTO competencia(descricao) VALUES ('Java');
INSERT INTO competencia(descricao) VALUES ('PostgreSQL');

SELECT * FROM candidato;