class Pessoa {
  nome: string;
  email: string;
  pais: string;
  estado: string;
  descricao: string;

  constructor(
    nome: string,
    email: string,
    pais: string,
    estado: string,
    descricao: string
  ) {
    this.nome = nome;
    this.email = email;
    this.pais = pais;
    this.estado = estado;
    this.descricao = descricao;
  }
}

class PessoaJuridica extends Pessoa {
  cnpj: string;
  cep: string;
  competenciasNecessarias: string[];

  constructor(
    nome: string,
    email: string,
    pais: string,
    estado: string,
    descricao: string,
    cnpj: string,
    cep: string,
    competenciasNecessarias: string[]
  ) {
    super(nome, email, pais, estado, descricao);
    this.cnpj = cnpj;
    this.cep = cep;
    this.competenciasNecessarias = competenciasNecessarias;
  }
}

class PessoaFisica extends Pessoa {
  cpf: string;
  competencias: string[];
  telefone: string;

  constructor(
    nome: string,
    email: string,
    pais: string,
    estado: string,
    descricao: string,
    cpf: string,
    competencias: string[],
    telefone: string
  ) {
    super(nome, email, pais, estado, descricao);
    this.cpf = cpf;
    this.competencias = competencias;
    this.telefone = telefone;
  }
}

let candidatos: Array<PessoaFisica> = new Array<PessoaFisica>();

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

let empresas: Array<PessoaJuridica> = new Array<PessoaJuridica>();

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
  let competencias: Array<string> = new Array<string>();
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
  const botao = document.querySelector(".buttonAdd");
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
  let competenciasNecessarias: Array<string> = new Array<string>();
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

function validaDadosCandidato(){
  const validaCPF = /^\d{3}\.\d{3}\.\d{3}\-\d{2}$/
  const validaEmail = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/
  const validaTelefone =

  var stringErro = " "

  if (!validaCPF.test(inputCPF.value)){
      stringErro = stringErro + "Insira um CPF válido!"
  }

  if (!validaEmail.test(inputEmail.value)){
      stringErro = stringErro + " Insira um Email válido!"
  }

  if (!validaTelefone.test(inputTelefone.value)){
      stringErro = stringErro + " Insira um Telefone válido!"
  }

  if (!(checkboxGroovy.checked || checkboxJava.checked || checkboxJavaScript.checked || checkboxMysql.checked || checkboxSpring.checked || checkboxPython.checked)){
      stringErro = stringErro + " Selecione alguma competência!"
  }

  erro.innerHTML = stringErro

  return (validaCPF.test(inputCPF.value) &&
      validaEmail.test(inputEmail.value) &&
      validaTelefone.test(inputTelefone.value) &&
      (checkboxGroovy.checked || checkboxJava.checked || checkboxJavaScript.checked || checkboxMysql.checked || checkboxSpring.checked || checkboxPython.checked)
  )
}

function cadastraCandidato(){
  if(validaDadosCandidato()){
      erro.style.display = "none"
      criaCandidato()
  }else{
      erro.style.display = "grid"
  }
}

function validaDadosEmpresa(){
  const validaCNPJ = /^\d{2}\.\d{3}\.\d{3}\/\d{4}\-\d{2}$/
  const validaCEP = /^\d{2}\.?\d{3}\-\d{3}/
  const validaEmail = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/

  var stringErro = " "

  if (!validaCNPJ.test(inputCNPJ.value)){
      stringErro = stringErro + "Insira um CNPJ válido!"
  }

  if (!validaCEP.test(inputCEP.value)){
      stringErro = stringErro + " Insira um CEP válido!"
  }

  if (!validaEmail.test(inputEmail.value)){
      stringErro = stringErro + " Insira um Email válido!"
  }

  if (!(checkboxGroovy.checked || checkboxJava.checked || checkboxJavaScript.checked || checkboxMysql.checked || checkboxSpring.checked || checkboxPython.checked)){
      stringErro = stringErro + " Selecione alguma competência necessária!"
  }

  erro.innerHTML = stringErro

  return (validaCNPJ.test(inputCNPJ.value) &&
          validaCEP.test(inputCEP.value) &&
          validaEmail.test(inputEmail.value) &&
          (checkboxGroovy.checked || checkboxJava.checked || checkboxJavaScript.checked || checkboxMysql.checked || checkboxSpring.checked || checkboxPython.checked)
  )
}

function cadastraEmpresa(){
  if(validaDadosEmpresa()){
      erro.style.display = "none"
      criaEmpresa()
  }else{
      erro.style.display = "grid"
  }
}
