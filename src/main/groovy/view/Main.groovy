package view

import model.Classes.Candidato
import model.Classes.Competencia
import model.Classes.Empresa
import model.Classes.Vaga
import model.DAO.CandidatoDAO
import model.DAO.CompetenciaDAO
import model.DAO.EmpresaDAO
import model.DAO.VagaDAO

int opcao
boolean rodar = true

while (rodar) {

    println "-----------------------------"
    println "         LINKETINDER         "
    println "1 - ADICIONAR EMPRESA"
    println "2 - ATUALIZAR EMPRESA"
    println "3 - DELETAR EMPRESA"
    println "4 - LISTAR EMPRESAS"
    println "5 - ADICIONAR CANDIDATO"
    println "6 - ATUALIZAR CANDIDATO"
    println "7 - DELETAR CANDIDATO"
    println "8 - LISTAR CANDIDATOS"
    println "9 - ADICIONAR COMPETÊNCIA"
    println "10 - ATUALIZAR COMPETÊNCIA"
    println "11 - DELETAR COMPETÊNCIA"
    println "12 - LISTAR COMPETÊNCIAS"
    println "13 - ADICIONAR VAGA"
    println "14 - ATUALIZAR VAGA"
    println "15 - DELETAR VAGA"
    println "16 - LISTAR VAGAS"
    println "17 - SAIR"
    println "-----------------------------"
    println()

    print "Digite a opção desejada: "
    opcao = System.in.newReader().readLine().toInteger()

    switch (opcao) {
        case 1:
            Empresa empresa = new Empresa()

            print "Digite o nome da empresa: "
            empresa.setNome(System.in.newReader().readLine())
            print "Digite o CNPJ da empresa: "
            empresa.setCnpj(System.in.newReader().readLine())
            print "Digite o email da empresa: "
            empresa.setEmailCorporativo(System.in.newReader().readLine())
            print "Digite o país da empresa: "
            empresa.setPais(System.in.newReader().readLine())
            print "Digite o CEP da empresa: "
            empresa.setCep(System.in.newReader().readLine())
            print "Digite a descrição da empresa: "
            empresa.setDescricao(System.in.newReader().readLine())
            print "Digite a senha da empresa: "
            empresa.setSenha(System.in.newReader().readLine())

            EmpresaDAO dao = new EmpresaDAO()
            dao.adiciona(empresa)
            break
        case 2:
            Empresa empresa = new Empresa()

            print "Digite o id da empresa que deseja alterar: "
            empresa.id = System.in.newReader().readLine() as int

            print "Digite o nome da empresa: "
            empresa.setNome(System.in.newReader().readLine())
            print "Digite o CNPJ da empresa: "
            empresa.setCnpj(System.in.newReader().readLine())
            print "Digite o email da empresa: "
            empresa.setEmailCorporativo(System.in.newReader().readLine())
            print "Digite o país da empresa: "
            empresa.setPais(System.in.newReader().readLine())
            print "Digite o CEP da empresa: "
            empresa.setCep(System.in.newReader().readLine())
            print "Digite a descrição da empresa: "
            empresa.setDescricao(System.in.newReader().readLine())
            print "Digite a senha da empresa: "
            empresa.setSenha(System.in.newReader().readLine())

            EmpresaDAO dao = new EmpresaDAO()
            dao.atualiza(empresa)
            break
        case 3:
            Empresa empresa = new Empresa()

            print "Digite o id da empresa que deseja remover: "
            empresa.id = System.in.newReader().readLine() as int

            EmpresaDAO dao = new EmpresaDAO()
            dao.remove(empresa)
            break
        case 4:
            EmpresaDAO dao = new EmpresaDAO()
            List<Empresa> empresas = dao.listar()
            for (Empresa empresa: empresas) {
                println("Nome: " + empresa.getNome())
                println("Email Corporativo: " + empresa.getEmailCorporativo())
                println("País: " + empresa.getPais())
                println("Descrição Pessoal: " + empresa.getDescricao())
                println("Competências: ")
                println()
            }
            break
        case 5:
            Candidato candidato = new Candidato()

            print "Digite o nome do candidato: "
            candidato.setNome(System.in.newReader().readLine())
            print "Digite o sobrenome do candidato: "
            candidato.setSobrenome(System.in.newReader().readLine())
            print "Digite a data de nascimento do candidato: "
            candidato.setDt_nasc(System.in.newReader().readLine())
            print "Digite o email do candidato: "
            candidato.setEmail(System.in.newReader().readLine())
            print "Digite o CPF do candidato: "
            candidato.setCpf(System.in.newReader().readLine())
            print "Digite o país do candidato: "
            candidato.setPais(System.in.newReader().readLine())
            print "Digite o CEP do candidato: "
            candidato.setCep(System.in.newReader().readLine())
            print "Digite a descrição do candidato: "
            candidato.setDescricaoPessoal(System.in.newReader().readLine())
            print "Digite a senha do candidato: "
            candidato.setSenha(System.in.newReader().readLine())

            CandidatoDAO dao = new CandidatoDAO()
            dao.adiciona(candidato)
            break
        case 6:
            Candidato candidato = new Candidato()

            print "Digite o id do candidato que deseja alterar: "
            candidato.id = System.in.newReader().readLine() as int

            print "Digite o email do candidato: "
            candidato.setEmail(System.in.newReader().readLine())
            print "Digite o país do candidato: "
            candidato.setPais(System.in.newReader().readLine())
            print "Digite o CEP do candidato: "
            candidato.setCep(System.in.newReader().readLine())
            print "Digite a descrição do candidato: "
            candidato.setDescricaoPessoal(System.in.newReader().readLine())
            print "Digite a senha do candidato: "
            candidato.setSenha(System.in.newReader().readLine())

            CandidatoDAO dao = new CandidatoDAO()
            dao.atualiza(candidato)
            break
        case 7:
            Candidato candidato = new Candidato()

            print "Digite o id do candidato que deseja remover: "
            candidato.id = System.in.newReader().readLine() as int

            CandidatoDAO dao = new CandidatoDAO()
            dao.remove(candidato)
            break
        case 8:
            CandidatoDAO dao = new CandidatoDAO()
            List<Candidato> candidatos = dao.listar()
            for (Candidato candidato : candidatos) {
                println("Nome: " + candidato.getNome() + " " + candidato.getSobrenome())
                println("Email: " + candidato.getEmail())
                println("País: " + candidato.getPais())
                println("Descrição Pessoal: " + candidato.getDescricaoPessoal())
                println("Competências: ")
                println()
            }
            break
        case 9:
            Competencia competencia = new Competencia()

            print "Digite o nome da competencia: "
            competencia.setDescricao(System.in.newReader().readLine())

            CompetenciaDAO dao = new CompetenciaDAO()
            dao.adiciona(competencia)
            break
        case 10:
            Competencia competencia = new Competencia()

            print "Digite o id da competência que deseja alterar: "
            competencia.id = System.in.newReader().readLine() as int

            print "Digite o nome da competência: "
            competencia.setDescricao(System.in.newReader().readLine())

            CompetenciaDAO dao = new CompetenciaDAO()
            dao.atualiza(competencia)
            break
        case 11:
            Competencia competencia = new Competencia()

            print "Digite o id da competência que deseja remover: "
            competencia.id = System.in.newReader().readLine() as int

            CompetenciaDAO dao = new CompetenciaDAO()
            dao.remove(competencia)
            break
        case 12:
            CompetenciaDAO dao = new CompetenciaDAO()
            List<Competencia> competencias = dao.listar()
            for (Competencia competencia : competencias) {
                println("Nome: " + competencia.getDescricao())
                println()
            }
            break
        case 13:
            Vaga vaga = new Vaga()

            print "Digite o nome da vaga: "
            vaga.setNome(System.in.newReader().readLine())
            print "Digite o local da vaga: "
            vaga.setLocalVaga(System.in.newReader().readLine())
            print "Digite a descrição da vaga: "
            vaga.setDescricao(System.in.newReader().readLine())
            print "Digite o id da empresa que deseja abrir a vaga: "
            vaga.setIdEmpresa(System.in.newReader().readLine() as int)

            VagaDAO dao = new VagaDAO()
            dao.adiciona(vaga)
            break
        case 14:
            Vaga vaga = new Vaga()

            print "Digite o id da vaga que deseja alterar: "
            vaga.id = System.in.newReader().readLine() as int

            print "Digite o nome da vaga: "
            vaga.setNome(System.in.newReader().readLine())
            print "Digite o local da vaga: "
            vaga.setLocalVaga(System.in.newReader().readLine())
            print "Digite a descrição da vaga: "
            vaga.setDescricao(System.in.newReader().readLine())

            VagaDAO dao = new VagaDAO()
            dao.atualiza(vaga)
            break
        case 15:
            Vaga vaga = new Vaga()

            print "Digite o id da vaga que deseja remover: "
            vaga.id = System.in.newReader().readLine() as int

            VagaDAO dao = new VagaDAO()
            dao.remove(vaga)
            break
        case 16:
            VagaDAO dao = new VagaDAO()
            List<Vaga> vagas = dao.listar()
            for (Vaga vaga : vagas) {
                println("Nome: " + vaga.getDescricao())
                println("Descrição: " + vaga.getDescricao())
                println("Local da Vaga: " + vaga.getLocalVaga())
                println()
            }
            break
        case 17:
            rodar = false
            println "SAINDO..."
            break
    }
}