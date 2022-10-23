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
            Empresa.adicionaEmpresa()
            break
        case 2:
            Empresa.atualizaEmpresa()
            break
        case 3:
            Empresa.deletaEmpresa()
            break
        case 4:
            Empresa.listaEmpresas()
            break
        case 5:
            Candidato.adicionaCandidato()
            break
        case 6:
            Candidato.atualizaCandidato()
            break
        case 7:
            Candidato.deletaCandidato()
            break
        case 8:
            Candidato.listaCandidatos()
            break
        case 9:
            Competencia.adicionaCompetencia()
            break
        case 10:
            Competencia.atualizaCompetencia()
            break
        case 11:
            Competencia.deletaCompetencia()
            break
        case 12:
            Competencia.listaCompetencias()
            break
        case 13:
            Vaga.adicionaVaga()
            break
        case 14:
            Vaga.atualizaVaga()
            break
        case 15:
            Vaga.deletaVaga()
            break
        case 16:
            Vaga.listaVagas()
            break
        case 17:
            rodar = false
            println "SAINDO..."
            break
    }
}