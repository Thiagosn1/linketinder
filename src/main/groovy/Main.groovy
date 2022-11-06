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
            EmpresaDAO.adicionaEmpresa()
            break
        case 2:
            EmpresaDAO.atualizaEmpresa()
            break
        case 3:
            EmpresaDAO.deletaEmpresa()
            break
        case 4:
            EmpresaDAO.listaEmpresas()
            break
        case 5:
            CandidatoDAO.adicionaCandidato()
            break
        case 6:
            CandidatoDAO.atualizaCandidato()
            break
        case 7:
            CandidatoDAO.deletaCandidato()
            break
        case 8:
            CandidatoDAO.listaCandidatos()
            break
        case 9:
            CompetenciaDAO.adicionaCompetencia()
            break
        case 10:
            CompetenciaDAO.atualizaCompetencia()
            break
        case 11:
            CompetenciaDAO.deletaCompetencia()
            break
        case 12:
            CompetenciaDAO.listaCompetencias()
            break
        case 13:
            VagaDAO.adicionaVaga()
            break
        case 14:
            VagaDAO.atualizaVaga()
            break
        case 15:
            VagaDAO.deletaVaga()
            break
        case 16:
            VagaDAO.listaVagas()
            break
        case 17:
            rodar = false
            println "SAINDO..."
            break
    }
}