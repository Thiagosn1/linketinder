"use strict";

class Pessoa {
  constructor(name, email, country, state, descricao) {
    this.name = name;
    this.email = email;
    this.country = country;
    this.state = state;
    this.descricao = descricao;
  }
}

class PessoaFisica extends Pessoa {
  constructor(
    name,
    email,
    country,
    state,
    descricao,
    cpf,
    competencias,
    telefone
  ) {
    super(name, email, country, state, descricao);
    this.cpf = cpf;
    this.competencias = competencias;
    this.telefone = telefone;
  }
}

class PessoaJuridica extends Pessoa {
  constructor(
    name,
    email,
    country,
    state,
    descricao,
    cnpj,
    cep,
    competenciasNecessarias
  ) {
    super(name, email, country, state, descricao);
    this.cnpj = cnpj;
    this.cep = cep;
    this.competenciasNecessarias = competenciasNecessarias;
  }
}

let candidatos = new Array();

const candidato1 = new PessoaFisica(
  "Thiago",
  "thiago123@gmail.com",
  "Brasil",
  "Goiás",
  "Técnico em Informática",
  "05860698798",
  ["Java", "C#"]
);
const candidato2 = new PessoaFisica(
  "Mariana",
  "mariana123@gmail.com",
  "Brasil",
  "São Paulo",
  "Desenvolvedora Web Junior",
  "03286737739",
  ["javascript", "react"]
);
const candidato3 = new PessoaFisica(
  "Mariana",
  "mariana123@gmail.com",
  "Brasil",
  "São Paulo",
  "Desenvolvedora Web Junior",
  "03286737739",
  ["javascript", "react"]
);

candidatos.push(candidato1);
candidatos.push(candidato2);
candidatos.push(candidato3);

let empresas = new Array();

const empresa1 = new PessoaJuridica(
  "Twisted Soluções",
  "twistedsolucoes@outlook.com",
  "Brasil",
  "GO",
  "Soluções em Tecnologia"
);
const empresa2 = new PessoaJuridica(
  "Tech Ventures",
  "techventures@outlook.com",
  "Brasil",
  "RJ",
  "Consultoria Especializada em Tecnologia e Transformação Digital"
);
const empresa3 = new PessoaJuridica(
  "Tech Ventures",
  "techventures@outlook.com",
  "Brasil",
  "RJ",
  "Consultoria Especializada em Tecnologia e Transformação Digital"
);
empresas.push(empresa1);
empresas.push(empresa2);
empresas.push(empresa3);

const inputName = document.querySelector(".inputName");
const inputCPF = document.querySelector(".inputCPF");
const inputCNPJ = document.querySelector(".inputCNPJ");
const inputEmail = document.querySelector(".inputEmail");
const inputEstado = document.querySelector(".inputEstado");
const inputPais = document.querySelector(".inputPais");
const inputCEP = document.querySelector(".inputCEP");
const inputdescricao = document.querySelector(".descricao");
const inputTelefone = document.querySelector(".inputTelefone");
const checkboxJava = document.querySelector(".checkboxJava");
const checkboxGroovy = document.querySelector(".checkboxGroovy");
const checkboxJavaScript = document.querySelector(".checkboxJavaScript");
const checkboxMysql = document.querySelector(".checkboxMysql");
const checkboxPython = document.querySelector(".checkboxPython");
const checkboxSpring = document.querySelector(".checkboxSpring");

function criaCandidato() {
  let competencias = new Array();
  if (checkboxJava.checked) competencias.push("Java");
  if (checkboxGroovy.checked) competencias.push("Groovy");
  if (checkboxJavaScript.checked) competencias.push("JavaScript");
  if (checkboxMysql.checked) competencias.push("MySql");
  if (checkboxPython.checked) competencias.push("Python");
  if (checkboxSpring.checked) competencias.push("Spring");
  const candidato = new PessoaFisica(
    inputName.value,
    inputEmail.value,
    inputPais.value,
    inputEstado.value,
    inputdescricao.value,
    inputCPF.value,
    competencias,
    inputTelefone.value
  );
  candidatos.push(candidato);
  console.log(candidatos);
}

function listaCandidatos() {
  const listaCandidatos = document.querySelector(".listaCandidatos");
  const botao = document.querySelector(".button");
  listaCandidatos.removeChild(botao);
  for (let cand of candidatos) {
    const candidato = document.createElement("div");
    candidato.classList.add("candidato");
    const nomeCandidato = document.createElement("p");
    nomeCandidato.textContent = "*********";
    const descricao = document.createElement("p");
    descricao.textContent = cand.descricao;
    const competencias = document.createElement("p");
    competencias.textContent = cand.competencias;
    candidato.appendChild(nomeCandidato);
    candidato.appendChild(descricao);
    candidato.appendChild(competencias);

    listaCandidatos.appendChild(candidato);
    console.log(cand);
  }
}

function criaEmpresa() {
  let competenciasNecessarias = new Array();
  if (checkboxJava.checked) competenciasNecessarias.push("Java");
  if (checkboxGroovy.checked) competenciasNecessarias.push("Groovy");
  if (checkboxJavaScript.checked) competenciasNecessarias.push("JavaScript");
  if (checkboxMysql.checked) competenciasNecessarias.push("MySql");
  if (checkboxPython.checked) competenciasNecessarias.push("Python");
  if (checkboxSpring.checked) competenciasNecessarias.push("Spring");
  console.log(competenciasNecessarias);
  const empresa = new PessoaJuridica(
    inputName.value,
    inputEmail.value,
    inputPais.value,
    inputEstado.value,
    inputdescricao.value,
    competenciasNecessarias,
    inputCEP.value,
    inputEstado.value
  );
  empresas.push(empresa);
  console.log(empresas);
}

function listaEmpresas() {
  const listaEmpresas = document.querySelector(".listaEmpresas");
  const botao = document.querySelector(".button");
  listaEmpresas.removeChild(botao);
  for (let empr of empresas) {
    const empresa = document.createElement("div");
    empresa.classList.add("empresa");
    const nomeEmpresa = document.createElement("p");
    nomeEmpresa.textContent = "*********";
    const descricao = document.createElement("p");
    descricao.textContent = empr.descricao;
    const competenciasNecessarias = document.createElement("p");
    competenciasNecessarias.textContent = empr.competenciasNecessarias;

    empresa.appendChild(nomeEmpresa);
    empresa.appendChild(descricao);
    empresa.appendChild(competenciasNecessarias);
    listaEmpresas.appendChild(empresa);
    console.log(empr);
  }
}
